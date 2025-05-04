package behavioural.iteratorPattern.iterator;

import behavioural.iteratorPattern.playlist.Playlist;

import java.util.ArrayList;
import java.util.Collections;

public class ShufflePlaylistIterator implements PlaylistIterator {

    int index;
    Playlist playlist;
    private final ArrayList<String> shuffledSongs;

    public ShufflePlaylistIterator(Playlist playlist) {
        this.index = 0;
        this.playlist = playlist;
        this.shuffledSongs = new ArrayList<>(playlist.getSongs());
        Collections.shuffle(shuffledSongs);
    }

    @Override
    public boolean hasNext() {
        return index < shuffledSongs.size();
    }

    @Override
    public String next() {
        return shuffledSongs.get(index++);
    }
}
