package behaviouralDesignPatterns.iteratorPattern.iterator;

import behaviouralDesignPatterns.iteratorPattern.playlist.Playlist;

public class FavouritePlaylistIterator implements PlaylistIterator{

    private int index;
    private final Playlist playlist;

    public FavouritePlaylistIterator(Playlist playlist) {
        this.playlist = playlist;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        while(index < playlist.getSongs().size()) {
            if(playlist.getSongs().get(index).contains("Fav")) {
                return true;
            }
            index++;
        }
        return false;
    }

    @Override
    public String next() {
        return playlist.getSongs().get(index++);
    }
}
