//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    BackwardSongIterator
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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class models an iterator to play songs in the reverse backward direction from 
 * a doubly linked list of songs
 */
public class BackwardSongIterator extends Object implements Iterator<Song> {
  private LinkedNode<Song> next; //reference to the next linked node in a list of nodes
  
  /**
   * Creates a new iterator which iterates through songs in back/tail to front/head order
   * @param last - reference to the tail of a doubly linked list of songs
   */
  public BackwardSongIterator(LinkedNode<Song> last) {
    this.next = last; 
  }
  
  /**
   * Checks whether there are more songs to return in the reverse order
   * @return true if there are more songs to return in the reverse order
   */
  @Override
  public boolean hasNext() {
    if (next != null) {
      return true;
    }
    return false;
  }
  
  /**
   * Returns the next song in the iteration
   * @throws NoSuchElementException if no song is next in the backwards order (hasNext() == false)
   */
  @Override
  public Song next() {
    if (hasNext()) {
      LinkedNode<Song> copy = next;
      this.next = copy.getPrev();
      return copy.getData();
    }
    throw new NoSuchElementException("ForwardSongIterator.prev(): No song prev");
  }
}
