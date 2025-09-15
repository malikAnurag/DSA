package practice.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class WebCrawler {

    String hostname;
    HtmlParser parser;
    AtomicInteger urlsToParse = new AtomicInteger(0);
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    ConcurrentHashMap<String, Boolean> hm = new ConcurrentHashMap<>();

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        this.parser = htmlParser;
        hostname = startUrl.split("/")[2];

        hm.put(startUrl, true);
        urlsToParse.addAndGet(1);

        executorService.submit(new Task(startUrl));

        while(urlsToParse.get() > 0) {
            try {
                Thread.sleep(80);
            } catch(Exception e) {
            }
        }

        executorService.shutdown();
        return new ArrayList<>(hm.keySet());
    }

    class Task implements Runnable {

        String url;

        Task(String url) {
            this.url = url;
        }

        public void run() {

            for(String extractedUrl : parser.getUrls(url)) {

                String host = extractedUrl.split("/")[2];

                if(host.equals(hostname) && hm.putIfAbsent(extractedUrl, true) == null) {
                    urlsToParse.addAndGet(1);
                    executorService.submit(new Task(extractedUrl));
                }
            }
            urlsToParse.addAndGet(-1);
        }
    }
}

class HtmlParser {
    public List<String> getUrls(String url) {
        return new ArrayList<>();
    }
}
