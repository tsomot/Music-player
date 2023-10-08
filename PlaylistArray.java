
/** PlaylistArray.java
  * @author Tenzin Tsomo
  * @description PlaylistArray class to add, remove and show details of playlist using Array Structure
  * @version 1.0, 2023-04-20
*/
import java.util.Scanner;

public class PlaylistArray {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter your Playlist Name");
            String playlistFile = input.nextLine();
            Song[] songs = new Song[100]; /** Create an array of Song objects*/
            int songCount = 0; /**Counter for number of songs added*/

            boolean temp = true;
            while (temp) {
                System.out.println("Enter 1 To Add Songs To Playlist:  " + playlistFile + "\n"
                        + "Enter 2 to remove Songs From Playlist: " + playlistFile + "\n"
                        + "Enter 3 To show the songs in Playlist: " + playlistFile + "\n"
                        + "Enter 4 To Play The Playlist: " + playlistFile + "\n" + "Enter 5 To Exit");
                int input1 = input.nextInt();
                switch (input1) {
                    case 1: /** Add Songs to the Playlist */
                        System.out.println("Name of the Song");
                        input.nextLine();
                        String songName = input.nextLine();
                        System.out.println("Name of the artist");
                        String artist = input.nextLine();
                        System.out.println("Duration of the song");
                        String duration = input.nextLine();
                        Song s = new Song(songName, artist, duration);
                        songs[songCount] = s;
                        songCount++;
                        System.out.println(songName + " song is added to playlist " + playlistFile + "!!!\n");
                        break;

                    case 2: /** Remove Songs to the Playlist */
                        if (songCount == 0) {
                            System.out.println("Empty File: " + playlistFile);
                            break;
                        } else {
                            System.out.println("List of songs");
                            for (int i = 0; i < songCount; i++) {
                                System.out.println((i + 1) + ". " + songs[i].toString());
                            }
                            System.out.println("Enter which song to remove, first song is at index 1");
                            int index = input.nextInt();

                            if (index <= 0 || index > songCount) {
                                System.out.println("No Song in that index");
                            } else {
                                // Shift all elements after index one position to the left
                                for (int i = index - 1; i < songCount - 1; i++) {
                                    songs[i] = songs[i + 1];
                                }
                                songCount--;
                                System.out.println("Song Removed");
                            }
                            break;
                        }

                    case 3: /** Show Songs in the Playlist */
                        if (songCount == 0) {
                            System.out.println("No songs in the playlist");
                            break;
                        } else {
                            System.out.println("Here is the List of songs");
                            for (int i = 0; i < songCount; i++) {
                                System.out.println((i + 1) + ". " + songs[i].toString());
                            }
                            break;
                        }

                    case 4: /** Play the Playlist */
                        if (songCount == 0) {
                            System.out.println("No songs in the playlist");
                            break;
                        } else {
                            System.out.println("Here is the List of songs");
                            for (int i = 0; i < songCount; i++) {
                                System.out.println((i + 1) + ". " + songs[i].toString());
                            }
                            System.out.println("Current Song-----");
                            songs[0].showSong();
                            int index = 0; // Index of current playing song
                            boolean next = true;
                            while (next) {
                                System.out.println("Enter 1 for Next Song, 2 for Previous Song, 3 to Stop Playing");
                                int playOption = input.nextInt();
                                switch (playOption) {
                                    case 1: /** Next Song */
                                        if (index == songCount - 1) {
                                            System.out.println("End of Playlist");
                                        } else {
                                            index++;
                                            songs[index].showSong();
                                        }
                                        break;
                                    case 2: /** Previous Song */
                                        if (index == 0) {
                                            System.out.println("This is the First Song");
                                        } else {
                                            index--;
                                            songs[index].showSong();
                                        }
                                        break;
                                    case 3: /** Stop Playing */
                                        next = false;
                                        System.out.println("Stopped Playing Playlist");
                                        break;
                                    default:
                                        System.out.println("Invalid Input");
                                        break;
                                }
                            }
                            break;
                        }
    
                    case 5: /** Exit */
                        temp = false;
                        break;
    
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
        }
    
    }
}
    