//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Song
// Course:   CS 300 Spring 2022
//
// Author:   Luke Wolfram
// Email:    lwolfram@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NONE
// Partner Email:   NONE
// Partner Lecturer's Name: NONE 
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE 
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models a Song object which contains 3 strings: a name, artist, and duration
 */
public class Song {
  private String songName; // name or title of the song
  private String artist;   // artist of the song
  private String duration; // duration of the song
  
  /**
   * Creates a new Song given the song name, the name of the artist, and the duration of the song
   * @param songName - title of the song
   * @param artist   - name of the artist who performed the song
   * @param duration - duration of the song in format mm:ss
   * @throws IllegalArgumentException if any param is blank
   */
  public Song(String songName , String artist, String duration) {
    if (songName .isBlank() || artist.isBlank() || duration.isBlank()) {
      throw new IllegalArgumentException("Song.java constructor: No strings may be blank");
    }
    //Massive and massively stupid block to make certain duration is formatted as "X:XX" or "XX:XX"
    if (duration.length() == 4) {
      if (!Character.isDigit(duration.charAt(0)) || duration.charAt(1) != ':'
          || !Character.isDigit(duration.charAt(2)) 
          || Character.getNumericValue(duration.charAt(2)) >= 6 
          || !Character.isDigit(duration.charAt(3))) {
        throw new IllegalArgumentException("Song.java constructor: duration misformatted");
      }
    } else if (duration.length() == 5) {
      if (!Character.isDigit(duration.charAt(0)) || 
          Character.getNumericValue(duration.charAt(0)) >= 6
          || !Character.isDigit(duration.charAt(1))  
          || duration.charAt(2) != ':' || !Character.isDigit(duration.charAt(3))
          || Character.getNumericValue(duration.charAt(3)) >= 6 
          || !Character.isDigit(duration.charAt(4))) {
        throw new IllegalArgumentException("Song.java constructor: duration misformatted");
      }
    } else {
      throw new IllegalArgumentException("Song.java constructor: duration misformatted");
    }
    
    this.songName = songName;
    this.artist = artist;
    this.duration = duration;
  }
  
  /**
   * Gets the title or name of this song
   * @return name of this Song  
   */
  public String getSongName() {
    return this.songName;
  }
  
  /**
   * Gets the artist of this song
   * @return artist of this Song
   */
  public String getArtist() {
    return this.artist;
  }
  
  /*
   * Gets the duration of this song
   * @return duration of this song
   */
  public String getDuration() {
    return this.duration;
  }
  
  /**
   * Overrides equals(Object) in class java.lang.Object
   * Returns true when this song's name and artist strings equals to the other song's name 
   * and artist strings, and false otherwise
   * @param other - Song object to compare this object to
   * @return true when the this song has matching name and artist with respect to another song 
   * (case insensitive comparison)
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Song)) {
      System.out.println("Song.equals(): parameter passed is not a Song object");
      return false;
    }
    Song s = (Song)other;
    if (!s.getSongName().equalsIgnoreCase(this.songName)) {
      System.out.println("Song.equals(): song names do not match");
      return false;
    }
    if (!s.getArtist().equalsIgnoreCase(this.artist)) {
      System.out.println("Song.equals(): artists do not match");
      return false;
    }
    return true;
  }
  
  /**
   * Overrides toString in class java.lang.Object
   * Returns a string representation of this song. This string should be formatted as follows:
   * "songName---artist---duration" where songName is the title of the song, 
   * artist is the name of the artist, and duration is the duration of the song.
   * @return a string representation of this song.
   */
  @Override
  public String toString() {
    String s = "";
    s += (songName + "---" + artist + "---" + duration);
    return s;
  }
}
