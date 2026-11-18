package practice.DSDesign.Lyft;


import java.util.*;

public final class PaginatedFetcher {

    // What the external API returns for one page
    public record Page(List<String> items, String nextPageToken) {
    }

    // Already Given
    @FunctionalInterface
    public interface PageSource {
        Page fetch(String pageToken) throws Exception;
    }

    private final PageSource source;

    // 1. Fetched items not yet returned [consume from this until we have enough]
    private final List<String> buffer = new ArrayList<>();

    // 2. Which page to fetch next? [fetch another page IF NEEDED]
    private String nextPageToken;

    // 3. Have we fetched the last page?
    private boolean exhausted;

    public PaginatedFetcher(PageSource source, String firstPageToken) {
        this.source = Objects.requireNonNull(source);
        this.nextPageToken = Objects.requireNonNull(firstPageToken);
    }

    // MUST REMEMBER STATE ACROSS CALLS
    public List<String> fetchN(int n) throws Exception {

        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative");
        }

        if (n == 0) {
            return new ArrayList<>();
        }

        // This is what we will return to the caller.
        List<String> result = new ArrayList<>();

        // Work on a temporary copy of saved items. We won't modify the real buffer until success.
        List<String> pending = new ArrayList<>(buffer);

        // Index of the next item to return from pending.
        int index = 0;

        // Temporary copies of our pagination state.
        String token = nextPageToken;
        boolean finished = exhausted;

        // Keep going until: We have n items, OR There is no more data
        while (result.size() < n) {

            // STEP 1: Consume an item already in memory.
            if (index < pending.size()) {
                result.add(pending.get(index));
                index++;
                continue;
            }

            // STEP 2: No buffered items left. [If there are no more API pages, STOP]
            if (finished) {
                break;
            }

            // STEP 3: Fetch the next page.
            Page page = source.fetch(token);

            // Add ALL page items to the pending list. We may use only some of them during this fetchN call.
            // ASSUMPTION : page is NOT NULL
            pending.addAll(page.items());

            // Remember which page should be fetched next.
            token = page.nextPageToken();

            // null means this was the final page. Note: There may still be pending items!
            finished = (token == null);
        }

        // STEP 4: SUCCESS! Save our updated state. Rebuild the buffer with only unread items.
        // Persistent state remains unchanged in case of ERROR from API
        buffer.clear();
        buffer.addAll(pending.subList(index, pending.size()));

        // Save the next page token for future calls.
        nextPageToken = token;
        exhausted = finished;

        // Return the requested elements. May contain fewer than n if data is exhausted.
        return result;
    }
    // IMPROVEMENT : Detect a cursor that POINTS BACK TO ITSELF ; Maintain a SET of VISITED TOKENS across Page requests
}