//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    SongPlayer
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
 * This class models an iterable collection of songs. Songs can be played in the forward or reverse order.
 */
public class SongPlayer extends Object implements Iterable<Song> {
  private int size = 0;             //size of the list
  private LinkedNode<Song> head;    //head of this doubly linked list
  private LinkedNode<Song> tail;    //tail of this doubly linked list
  private boolean playingBackward;  //true if this song player is reading the list backward
  
  /**
   * Adds a Song as Last Song
   * @param oneSong - the song that is going to be added to the tail of this 
   *                  doubly linked list of songs
   */
  public void addLast​(Song oneSong) {
    if (size == 0) {
      this.tail = new LinkedNode<Song>(null, oneSong, null);
      this.head = tail;
    } 
    else if (size == 1) {
      this.tail = new LinkedNode<Song>(head, oneSong, null);
      head.setNext​(tail);
    } 
    else {
      LinkedNode<Song> nodeToAdd = new LinkedNode<Song>(null, oneSong, null);
      LinkedNode<Song> copy = head;
      for (int i = 0; i < size - 1; i++) {
        copy = copy.getNext();
      }
      this.tail = nodeToAdd;
      tail.setPrev​(copy);
      copy.setNext​(nodeToAdd);
    }
    size++;
  }
  
  /**
   * Adds a song as First Song
   * @param oneSong - the song that is going to be added to the head of this 
   *                  doubly linked list of songs
   * @throws NullPointerException with a descriptive error message if the passed oneSong is null
   */
  public void addFirst​(Song oneSong) {
    if (oneSong == null) {
      throw new NullPointerException("SongPlayer.addFirst(): Song param is null");
    }
    
    if (size == 0) {
      this.head = new LinkedNode<Song>(null, oneSong, null);
      this.tail = head;
    } 
    else if (size == 1) {
      this.head = new LinkedNode<Song>(null, oneSong, tail);
      tail.setPrev​(head);
    } 
    else {
      LinkedNode<Song> copy = tail;
      for (int i = size - 1; i > 0; i--) {
        copy = copy.getPrev();
      }
      LinkedNode<Song> nodeToAdd = new LinkedNode<Song>(null, oneSong, copy);
      this.head = nodeToAdd;
      copy.setPrev​(nodeToAdd);
    }
    size++;
  }
  
  /**
   * adds Song at a given position/order within this collection of songs
   * @param index - the given index where the new song will be added
   * @param oneSong - the song that is going to be added
   * @throws NullPointerException - with a descriptive error message if the passed oneSong is null
   * @throws IndexOutOfBoundsException - with a descriptive error message if index is 
   *                                     out of the 0 .. size() range
   */
  public void add​(int index, Song oneSong) {
    if (oneSong == null) {
      throw new NullPointerException ("SongPlayer.add(): Song param is null");
      }
    if ((index >= size && size > 0) || index < 0) {
      throw new IndexOutOfBoundsException("SongPlayer.add(): index out of bounds");
      }
    
    else if (index == 0) {
      addFirst​(oneSong);
      } 
    else if (index == size - 1) {
      addLast​(oneSong);
      }
    else {
      LinkedNode<Song> copy = head;
      for (int i = 0; i < index; i++) {
        copy = copy.getNext();
        }
    if (copy.getNext() == null) {
      LinkedNode<Song> nodeToAdd = new LinkedNode<Song>(copy, oneSong, null);
      copy.setNext​(nodeToAdd);
      this.tail = nodeToAdd;
      size++;
      } 
    else {
    LinkedNode<Song> nodeToAdd = new LinkedNode<Song>(copy, oneSong, copy.getNext());
    copy.setNext​(nodeToAdd);
    copy.getNext().setPrev​(nodeToAdd);
    size++;
      }
    }
  }
  
  /**
   * Returns the first Song in this list.
   * @return the Song at the head of this list
   * @throws NoSuchElementException - with a descriptive error message if this list is empty
   */
  public Song getFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("SongPlayer.getFirst(): list is empty");
    }
    System.out.print("First song: " + head.getData() + "\n");
    return head.getData();
  }
  
  /**
   * Returns the last Song in this list.
   * @return the Song at the tail of this list
   * @throws NoSuchElementException - with a descriptive error message if this list is empty
   */
  public Song getLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("SongPlayer.getLast(): list is empty");
    }
    System.out.print("Last song: " + tail.getData() + "\n");
    return tail.getData();
  }
  
  /**
   * Returns the song at the specified position in this list.
   * @param index - index of the song to return
   * @return the song at the specified position in this list
   * @throws IndexOutOfBoundsException - with a descriptive error message if index 
   *                                     is out of the 0 .. size()-1 range
   */
  public Song get​(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("SongPlayer.add(): index out of bounds");
    }
    
    LinkedNode<Song> copy = head;
    for (int i = 0; i < index; i++) {
      copy = copy.getNext();
    }
    System.out.print("Song at index " + index + ": "+ copy.getData() + "\n");
    return copy.getData();
  }
  
  /**
   * Removes and returns the first song from this list.
   * @return the first song from this list
   * @throws NoSuchElementException - with a descriptive error message if this list is empty
   */
  public Song removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException("SongPlayer.removeFirst(): list is empty");
    }
    
    Song removed = head.getData();
    if (head.getNext() != null) {
      this.head = head.getNext();
      head.setPrev​(null);
    } else {
      this.head = null;
      this.tail = null;
    }
    size--;
    System.out.print("Removed: " + removed.getSongName() + "\n");
    return removed;
  }
  
  /**
   * Removes and returns the last song from this list.
   * @return the last song from this list
   * @throws NoSuchElementException - with a descriptive error message if this list is empty
   */
  public Song removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException("SongPlayer.removeLast(): list is empty");
    }
    
    Song removed = tail.getData();
    if (tail.getPrev() != null) {
      this.tail = tail.getPrev();
      tail.setNext​(null);
    } else {
      this.head = null;
      this.tail = null;
    }
    size--;
    System.out.print("Removed: " + removed.getSongName() + "\n");
    return removed;
  }
  
  /**
   * Removes the song at the specified position in this list and returns the song that was 
   * removed from the list. The order of precedence of the other songs in the list 
   * should not be modified.
   * @param index - the index of the song to be removed
   * @return the song previously at the specified position
   * @throws IndexOutOfBoundsException - with a descriptive error message if index is 
   *                                     out of the 0 .. size()-1 range
   */
  public Song remove​(int index) {
    if (index >= size || index < 0) {
      throw new IndexOutOfBoundsException("SongPlayer.add(): index out of bounds");
    }
    
    LinkedNode<Song> copy = head;
    for (int i = 0; i < index; i++) {
      copy = copy.getNext();
    }
    
    Song songToReturn = copy.getData();

    if (copy == head) {
      removeFirst();
      return songToReturn;
    } else if (copy == tail) {
      removeLast();
      return songToReturn;
    } else {
      copy.getPrev().setNext​(copy.getNext());
      copy.getNext().setPrev​(copy.getPrev());
      copy = null;
      System.out.print("Removed: " + songToReturn.getSongName() + "\n");
      size--;
      return songToReturn;
    }
  }
  
  /**
   * Returns true if this list contains a match with the specified song. More formally, returns true 
   * if and only if this list contains at least one song e such that Objects.equals(o, e).
   * @param o - song whose presence in this list is to be tested
   * @return true if this list contains the specified song
   */
  public boolean contains​(Song o) {
    LinkedNode<Song> copy = head;
    if (copy.getData().toString().equals(o.toString())) {
      return true;
    }
    for (int i = 0; i < size; i++) {
      copy = copy.getNext();
      if (copy.getData().toString().equals(o.toString())) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Removes all of the songs from this list. The list will be empty after this call returns.
   */
  public void clear() {
    if (!isEmpty()) {
      int sizeCopy = size;
      LinkedNode<Song> copy = head;
      for (int i = 0; i < sizeCopy - 1; i++) {
        copy = copy.getNext();
        copy.getPrev().setPrev​(null);
        copy.getPrev().setNext​(null);
        size--;
      }
      this.head = null;
      this.tail = null;
      size--;
    }
  }
  
  /**
   * Returns true if this list is empty.
   * @return true if this list is empty.
   */
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    }
    return false;
  }
  
  /**
   * Returns the number of songs in this list.
   * @return the number of songs in this list
   */
  public int size() {
    return size;
  }
  
  /**
   * Returns an iterator to iterate through the songs in this list with respect to current playing 
   * direction of this song player (either in the forward or in the backward direction)
   * @return an Iterator to traverse the list of songs in this SongPlayer with respect to the 
   *         current playing direction specified by the playingBackward data field.
   */
  public Iterator<Song> iterator() {
    if (!playingBackward) {
      Iterator<Song> frwd = new ForwardSongIterator(head);
      return frwd;
    }
    Iterator<Song> bkwd = new BackwardSongIterator(tail);
    return bkwd;
  }
  
  /**
   * Mutator of the playingDirection of this song player. It switches the playing direction 
   * by setting playingBackward to its opposite value.
   */
  public void switchPlayingDirection() {
    if (playingBackward) {
      this.playingBackward = false;
    } else {
      this.playingBackward = true;
    }
  }
  
  /**
   * Plays the songs in this song player in the current playing direction. 
   * This method MUST be implemented using an enhanced for-each loop.
   * @return a String representation of the songs in this song player. String representations of 
   *         each song are separated by a newline. 
   *         If this song player is empty, this method returns an empty string.
   */
  public String play() {
    String s = "";
    if (size == 0) {
      System.out.println("Playlist is empty");
      return s;
    }
    
    Iterator<Song> it = iterator();
    Song[] thing = new Song[size];
    
    if (playingBackward) {
      s += "Playing backward\n";
    } else {
      s += "Playing forward\n";
    }
    for (int i = 0; i < size; i++) {
      thing[i] = get​(i);
    }
    for (Song song : thing) {
      s += (it.next()).toString() + "\n";
    }
    return s;
  }
}
