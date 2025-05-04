package behavioural.iteratorPattern.iterator;

import behavioural.iteratorPattern.playlist.Playlist;

public class SimplePlaylistIterator implements PlaylistIterator {

    int index;
    Playlist playlist;

    public SimplePlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSongs().size();
    }

    @Override
    public String next() {
        return playlist.getSongs().get(index++);
    }
}
