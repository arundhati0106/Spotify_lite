import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    //album has a name, an artist who sang all the songs of album, and a list of songs
    private String name;
    private String artist;
    private List<Song> songs;

    //constructor, made with name and artist of album
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        //while making new album, create a new list, for list of songs in album
        //memory allocation is done in this statement
        this.songs = new ArrayList<>();
    }

    //getters and setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //methods

    //1. find a song in the album, using title
    public boolean findSong(String title){
        for(Song s:songs){
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }

    //2. add song to album, using title...
    //make an object of song class, using method findSong, see if the
    //song is present in album, if yes, dont add, if not, add
    public void addSongtoAlbum(String title, double duration) {
        Song s = new Song(title, duration);
        if(findSong(s.getTitle()))
            System.out.println("Song already present in the album.");
        else {
            songs.add(s);
            System.out.println("Song has been added to your playlist");
        }
        return;
    }

    //2. add song to playlist, from album
    //polymorphism; 2.1. using title
    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playlist) {
        //search if song mentioned is present in the album
        if(findSong(title)) {
            //then search for song and add to playlist
            for(Song song: songs) {
                if(song.getTitle().equals(title)) {
                    playlist.add(song);
                    System.out.println("Song has been added to your playlist");
                    break;
                }
            }
        }
        System.out.println("Song is not present in the album, thus cant be added to the playlist");
        return;
    }

    //2.2 using track no, i.e. indexing, i.e. position of song in the album... 3rd song in album
    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song> playlist) {
        int index = trackNo - 1;                 //0-based indexing
        if(index >= 0 && index < songs.size()) { //index in range of album size
            System.out.println("Song has been added to your playlist");
            playlist.add(songs.get(index));
        }
        System.out.println("Invalid track number");
        return;
    }
}
