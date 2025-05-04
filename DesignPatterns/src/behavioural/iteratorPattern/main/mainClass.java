package behavioural.iteratorPattern.main;

/*
* Extremely useful when we want to access elements in a collection sequentially without exposing the
* complexity of a collection itself.
*
* Traditional iteration using a loop is hard to maintain as we add more features like shuffle, filtering etc.
* Code becomes cluttered
*
* Tightly coupled : Any change in iteration logic requires modifying the iteration method which is not scalable
*
* Need to figure out a way to end up catering different kind of iterations on a list
* Separation of concerns
*
* */

import behavioural.iteratorPattern.iterator.PlaylistIterator;
import behavioural.iteratorPattern.playlist.Playlist;

public class mainClass {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        playlist.addSong("song1");
        playlist.addSong("song2 Fav");
        playlist.addSong("song3");
        playlist.addSong("song4 Fav");
        playlist.addSong("song5");

        System.out.println("Simple Playlist :");
        PlaylistIterator simpleIterator = playlist.iterator("simple");
        while(simpleIterator.hasNext()) {
            System.out.println("Playing : " + simpleIterator.next());
        }

        System.out.println("\nShuffled Playlist : ");
        PlaylistIterator shufflePlaylistIterator = playlist.iterator("shuffled");
        while (shufflePlaylistIterator.hasNext()) {
            System.out.println("Playing : " + shufflePlaylistIterator.next());
        }

        System.out.println("\nFavourite Playlist : ");
        PlaylistIterator favouritePlaylistIterator = playlist.iterator("favourites");
        while (favouritePlaylistIterator.hasNext()) {
            System.out.println("Playing : " + favouritePlaylistIterator.next());
        }
    }
}
