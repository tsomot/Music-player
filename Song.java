/** Song.java
  * @author Tenzin Tsomo
  * @description Node objects as Songs for playlist
  * @version 1.0, 2023-04-20
*/

public class Song {
    /** attributes */
    private String name;
    private String artist;
    private String duration;
    private int index;
/** initializes the name, artist and duration */
    public Song(String name, String artist, String duration) {
        this.name = name;
        this.artist = artist;
        this.duration = duration;
    }
/** gets the name of the song */
    public String getName() {
        return name;
    }
/** gets the artist of the song */
    public String getArtist() {
        return artist;
    }
/** gets the length of the song */
    public String getDuration() {
        return duration;
    }
/** gets the index of the song */
    public int getIndex() {
        return index;
    }
/** sets the index of the song */
    public void setIndex(int index) {
        this.index = index;
    }
/**prints the details of the song */
    public void showSong() {
        System.out.println("Song " + index + ": " + name + " by " + artist + " (" + duration + ")");
    }
}
