package behavioural.iteratorPattern.playlist;

import behavioural.iteratorPattern.iterator.FavouritePlaylistIterator;
import behavioural.iteratorPattern.iterator.PlaylistIterator;
import behavioural.iteratorPattern.iterator.ShufflePlaylistIterator;
import behavioural.iteratorPattern.iterator.SimplePlaylistIterator;

import java.util.ArrayList;

public class Playlist {

    private final ArrayList<String> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void addSong(String song) {
        songs.add(song);
    }

    public PlaylistIterator iterator(String type) {
        switch (type) {
            case "simple" :
                return new SimplePlaylistIterator(this);
            case "shuffled" :
                return new ShufflePlaylistIterator(this);
            case "favourites" :
                return new FavouritePlaylistIterator(this);
            default:
                return null;
        }
    }

    // Without using iterator pattern
    public void playPlaylist(boolean shuffle) {
        if (shuffle) {
            System.out.println("Shuffling playlist");
        } else {
            for (String song : songs) {
                System.out.println("Playing song : " + song);
            }
        }
    }
}
