import java.sql.SQLOutput;
import java.util.*;

public class Main {
    //make a list of albums, can be accessed directly
    public static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        //create albums
        Album album1 = new Album("Ashiqui 2","Arijit Sing");
        album1.addSongtoAlbum("Aasan Nahi Yahan",3.34);
        album1.addSongtoAlbum("Milne hai mujhse ayi",6.30);
        album1.addSongtoAlbum("Tum hi ho",3.57);
        album1.addSongtoAlbum("Chahun main ya naa",5.05);

        Album album2 = new Album("Deewana","Sonu Nigam");
        album2.addSongtoAlbum("Is kadar pyar hai tumse",5.35);
        album2.addSongtoAlbum("Deewana tera",6.00);
        album2.addSongtoAlbum("Ab mujhe raat din",6.26);

        //add albums to list of albums
        albums.add(album1);
        albums.add(album2);

        //search for a song in said album
        System.out.println(album1.findSong("Tum hi ho tera"));

        //create playlist
        LinkedList<Song> myPlayList = new LinkedList<>();
        //add songs to playlist from mentioned album
        album1.addToPlaylistFromAlbum("Tum hi ho",myPlayList);
        album2.addToPlaylistFromAlbum(2,myPlayList);
        album1.addToPlaylistFromAlbum("Aasan Nahi Yahan",myPlayList);
        album2.addToPlaylistFromAlbum("Is kadar pyar hai tumse", myPlayList);

        play(myPlayList);
    }

    //play songs from a personalised playlist
    public static void play(LinkedList <Song> playList) {
        //take inputs from user, as to what action is required next
        Scanner sc = new Scanner(System.in);

        //traverse in both directions in a doubly LL
        //for each traverses only in fwd direction
        ListIterator<Song> itr = playList.listIterator();

        //this returns true only if the iterator moved in fwd direction, in the last iteration
        boolean lastMoveForward = false;

        //if playlist is not empty, then songs can be played
        if(playList.size() > 0) {
            System.out.println("Currently playing: ");
            //itr.next is the current song
            System.out.println(itr.next());
        }
        else {
            System.out.println("Playlist is empty");
            return;
        }

        System.out.println("Enter your choice (number) from the menu");

        //choices as to what all can the user do while playing
        printMenu();

        //run loop until user enters a number/choice that makes it quit the app/ stop playing
        boolean quit = false;

        while(!quit) {
            int choice = sc.nextInt();
            switch(choice){
                case 1: //next song
                    //if the last iteration was moving backward, then the next song would be next of next
                    //one next would play the curr song
                    if(lastMoveForward == false){
                        //move one step additionally
                        itr.next();
                        //update this as we moved fwd, so last move was fwd, hence true
                        lastMoveForward = true;
                    }

                    //if we aren't at the last pos, move next
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }
                    //we are at the last song of playlist
                    else{
                        System.out.println("You have reached the end of the playlist");
                        lastMoveForward = false;
                    }
                    break;

                case 2: //previous song
                    //if the last iteration was moving forward, then the previous song would be prev of prev
                    //one prev would play the curr song
                    if(lastMoveForward == true){
                        //move one step additionally
                        itr.previous();
                        //update this as we moved fwd, so last move was fwd, hence true
                        lastMoveForward = false;
                    }

                    //if we aren't at the first pos, move prev
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }
                    //we are at the first song of playlist
                    else{
                        System.out.println("You are at the start of playlist");
                        lastMoveForward = true;
                    }
                    break;

                case 3: //repeat song
                    //if last move was fwd, play prev song
                    if(lastMoveForward==true){
                        // not reqd to check as its obvious, but good practice
                        // if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            lastMoveForward = false;
                        // }
                    }

                    //if last move was backward, play next song
                    else{
                        //if(itr.hasNext()){
                            System.out.println(itr.next());
                            lastMoveForward = true;
                        //}
                    }
                    break;

                case 4: //Show menu again
                    printMenu();
                    break;

                case 5: //delete curr song
                    break;

                case 6: //print/show all songs in the playlist
                    printSongs(playList);
                    break;

                case 7: //exit/stop playing
                    quit = true;
                    break;
            }
        }
    }

    //print all songs in the playlist
    public static void printSongs(LinkedList<Song> playList){
        for(Song song: playList)
            System.out.println(song);
        return;
    }

    //show menu
    public static void printMenu(){
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in playlist");
        System.out.println("7 - Exit");

        return;
    }
}