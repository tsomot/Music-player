
/** Playlist.java
  * @author Tenzin Tsomo
  * @description Playlist class to add, remove and show details of playlist using Linked List Data Structure
  * @version 1.0, 2023-04-20
*/
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {

 public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter your Playlist Name");
            String playlistFile=input.nextLine();
            LinkedList<Song> songs=new LinkedList<>();//Song is a class with three attributes song name,artist name and duration of the song
            boolean temp=true;
            while(temp){
                System.out.println(" Enter 1 To Add Songs To Playlist:  "+playlistFile+"\n"+
                                    "Enter 2 to remove Songs From Playlist: "+playlistFile+"\n"+
                                     "Enter 3 To show the songs in Playlist: "+playlistFile+"\n"+
                                     "Enter 4 To Play The Playlist: "+playlistFile+"\n"+
                                     "Enter 5 To Exit");
                int input1=input.nextInt();
                switch(input1){
                    case 1:/** Add Songs to the Playlist */
                           System.out.println("Name of the Song");
                           input.nextLine();
                           String songName =input.nextLine();
                           System.out.println("Name of the artist");
                           String artist=input.nextLine();
                           System.out.println("Duration of the song");
                           String duration=input.nextLine();
                           Song s=new Song(songName ,artist,duration);
                           songs.add(s);
                           System.out.println(songName +" song is added to playlist "+playlistFile+"!!!\n");
                           break;
                
                    case 2:/** Remove Songs to the Playlist */
                           if (songs.size() == 0) {
                               System.out.println("Empty File: " + playlistFile);
                               break;
                           } else {
                               System.out.println("List of songs");
                               for (Song i : songs) {  //enhanced for loop.
                                   i.showSong();
                               }
                               System.out.println("Enter which song to remove, first song is at index 1");
                               int index = input.nextInt();
                       
                               if (index <= 0 || index > songs.size()) {
                                   System.out.println("No Song in that index");
                               } else {
                                   songs.remove(index - 1);
                                   System.out.println("Song Removed");
                                   // updates the indices of subsequent songs in the playlist
                                   for (int i = index - 1; i < songs.size(); i++) {
                                       songs.get(i).setIndex(i + 1);
                                   }
                               }
                               break;
                           }
                           
                    case 3:/** Show Songs in the Playlist  */
                          if(songs.size()==0){
                           System.out.println("No songs in the playlist");
                           break;
                              }
                         else{
                            System.out.println("Here is the List of songs");
                             for(Song i:songs){//enhanced for loop
                                 i.showSong();
                             }
                            break;
                              }
                    case 4: /** Play the Playlist */
                           if(songs.size()==0){
                           System.out.println("No songs in the playlist");
                           break;
                              }
                          else{
                            System.out.println("Here is the List of songs");
                             for(Song i:songs){ //enhanced for loop 
                                 i.showSong();
                             }
                             System.out.println("Current Song-----");
                             songs.getFirst().showSong();
                             ListIterator<Song> j=songs.listIterator();//This is iterator and helps us to iterate to a linked list.
                            j.next();//as our first song is currently playing.
                            boolean onward=true;//helps to keep a track as user is going onward the linked list or backwards
                            boolean end =false; //To check wheather the user reached end of the linked list or not.
                          
                        
                            boolean next=true;
                            while(next){
                                System.out.println("Enter 1 to play the next song\n"
                                                    +"Enter 2 to play the previous song\n"
                                                    +"Enter 3 to play the same song again\n"
                                                    +"Enter 4 to stop the playlist");
                                
                                 int input2=input.nextInt();
                           switch(input2){
                               case 1:/** Plays the next song */
                                  
                                   if(!onward)
                                    {
                                      if(j.hasNext())
                                      {
                                          j.next();
                                      }
                                      onward=true;
                               

                                    }
                                   if(end ==true){
                                       j.previous();
                                       end =false;
                                   }
                           
                           
                                      
                                      
                                       
                                        if(j.hasNext())
                                        {
                                        
                                        System.out.println("Song Playing----->");
                                        j.next().showSong();
                          
                                        }
                                        else{
                                        System.out.println("Playlist end .....");
                                        end =true;
                                
                                        }
                                       
                                       
                                    
                                        break;
                               case 2:/** Plays the previous song */
                                      
                                   
                              if(onward)
                             {
                                 if(j.hasPrevious())
                                 {
                                     j.previous();
                                 }
                          
                                 onward=false;
                                 
                                
                             }
                              if(end ==true){
                                  j.next();
                                  end =false;
                              }
                    
                      
                            
                            
                            if(j.hasPrevious())
                            {
                            System.out.println("Song Playing------ ");
                            j.previous().showSong();
                          
                            }
                            else{
                                System.out.println("Playlist end .....");
                                end =true;
                                
                            }
                        
                            break;
                               case 3:/** Plays the same song again */
                                   if(onward)
                                      {System.out.println("Current Song again\n\n");
                                        j.previous().showSong();
                                        onward=false;
                                       }
                                   if(!onward)
                                    {   System.out.println("Current Song again\n\n");
                                        j.next().showSong();
                                        onward=true;
                                    }
                                
                                break;
                               case 4:next=false;/** Stops the playlist*/
                                       break;
                               default:next=false;
                                     
                                       break;
                                   
                              
                            }
                          
                          
                                  
                           }
                              }
                           break;
                    case 5:temp=false; /** Exits the playlist*/
                           break;
                    default:temp =false;
                            break;
                            
                            
                }
            }
        }
        
        
        }
        }

    
    

