//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    SongPlayerTester
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

import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of Song, LinkedNode, SongPlayer
 * ForwardSongIterator and BackwardSongIterator classes in P07 Iterable Song Player assignment.
 * 
 */
public class SongPlayerTester {
  /**
   * This method test and make use of the Song constructor, an accessor (getter) method,
   * overridden method toString() and equal() method defined in the Song class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSong() {
    Song s = new Song("Gamma Knife", "King Gizzard & The Lizard Wizard", "4:21");
    
    //Getter method testers
    if (!s.getSongName().equals("Gamma Knife")) {
      System.out.println("Song.getSongName() did not return correct song name");
      return false;
    }
    if (!s.getArtist().equals("King Gizzard & The Lizard Wizard")) {
      System.out.println("Song.getSongName() did not return correct artist");
      return false;
    }
    if (!s.getDuration().equals("4:21")) {
      System.out.println("Song.getSongName() did not return correct duration");
      return false;
    }
    
    //toString() tester
    if (!s.toString().equals("Gamma Knife---King Gizzard & The Lizard Wizard---4:21")) {
      System.out.println("Song.toString() did not return correct string representation\n"
          + "Bad string: " + s.toString());
      return false;
    }
    
    //equals() tester
    Song s2 = new Song("Gamma Knife", "King Gizzard & The Lizard Wizard", "4:21");
    if (!s.equals(s2)) {
      System.out.println("Song.equals() returned false when true was expected");
      return false;
    }
    s2 = new Song("asdf", "King Gizzard & The Lizard Wizard", "4:21");
    if (s.equals(s2)) {
      System.out.println("Song.equals() returned true when false was expected with an unequal "
          + "song name");
      return false;
    }
    s2 = new Song("Gamma Knife", "asdf", "4:21");
    if (s.equals(s2)) {
      System.out.println("Song.equals() returned true when false was expected with an unequal "
          + "artist name");
      return false;
    }
    
    //Constructor testers
      //These ones test duration
    try {
      s = new Song("Walcott", "Vampire Weekend", "4");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given a duration with length less than 4");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given a duration with length less than 4");
    }
    try {
      s = new Song("Walcott", "Vampire Weekend", "42:1");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given a duration of length 4 without a semicolon at index 1");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given a duration of length 4 without a semicolon at index 1");
    }
    try {
      s = new Song("Walcott", "Vampire Weekend", "4:61");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given a duration of length 4 with seconds greater than 59");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given a duration of length 4 with seconds greater than 59");
    }
    try {
      s = new Song("Walcott", "Vampire Weekend", "ABCD");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given a duration of length 4 without numbers");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given a duration of length 4 without numbers");
    }
    try {
      s = new Song("Walcott", "Vampire Weekend", "12345");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given a duration of length 5 without a semicolon");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given a duration of length 5 without a semicolon");
    }
    try {
      s = new Song("Walcott", "Vampire Weekend", "64:21");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given a duration of length 5 with minutes above 59");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given a duration of length 5 with minutes above 59");
    }
    try {
      s = new Song("Walcott", "Vampire Weekend", "04:61");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given a duration of length 5 with seconds above 59");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given a duration of length 5 with seconds above 59");
    }
    
    //These ones test blank params
    try {
      s = new Song("Walcott", "", "");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given blank strings");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given blank strings");
    }
    try {
      s = new Song("", "Vampire Weekend", "");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given blank strings");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given blank strings");
    }
    try {
      s = new Song("", "", "3:41");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given blank strings");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given blank strings");
    }
    try {
      s = new Song("", "", "");
      System.out.println("Song.java constructor did not throw an IllegalArgumentException "
          + "when given blank strings");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("Song.java constructor successfully threw an IllegalArgumentException "
          + "when given blank strings");
    }
    return true;
  }
  
  /**
   * This method test and make use of the LinkedNode constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedNode() {
    //Tests constructor throws
    try {
      LinkedNode<String> a = new LinkedNode<String>(null, null, null);
      System.out.println("LinkedNode.java constructor failed to throw an IllegalArgumentException"
          + " when given a blank data param");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println("LinkedNode.java constructor successfully threw an IllegalArgumentException"
          + " when given a blank data param");
    }
    
    Song song1 = new Song("1234 1234", "Streetlight Manifesto", "7:10");
    Song song2 = new Song("If Only For Memories", "Streetlight Manifesto", "5:28");
    Song song3 = new Song("Duk Koo Kim", "Sun Kil Moon", "14:32");
    
    LinkedNode<Song> node1 = new LinkedNode<Song>(null, song1, null);
    LinkedNode<Song> node2 = new LinkedNode<Song>(null, song2, null);
    LinkedNode<Song> node3 = new LinkedNode<Song>(null, song3, null);
    
    if (!node1.getData().toString().equals(song1.toString())) {
      System.out.println("LinkedNode.getData() failed to properly retrieve the data field");
      return false;
    }
    
    node1.setPrev​(node2);
    if (!node1.getPrev().getData().toString().equals(song2.toString())) {
      System.out.println("LinkedNode.setPrev() failed to assign a node prior");
      return false;
    }
    
    node1.setNext​(node3);
    if (!node1.getNext().getData().toString().equals(song3.toString())) {
      System.out.println("LinkedNode.setNext() failed to assign a node after");
      return false;
    }
    return true;
  }

  /**
   * This method checks for the correctness of addFirst(), addLast() and add(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerAdd() {
    Song s1 = new Song("n1", "a1", "1:00");
    Song s2 = new Song("n2", "a2", "2:00");
    Song s3 = new Song("n3", "a3", "3:00");
    Song s4 = new Song("n4", "a4", "4:00");
    Song s5 = new Song("n5", "a5", "5:00");
    SongPlayer p1 = new SongPlayer();
    
    try {
      p1.addFirst​(null);
      System.out.println("SongPlayer.addFirst() failed to throw a NullPointerException when passed"
          + " a null Song");
      return false;
    } catch (NullPointerException e) {
      System.out.println("SongPlayer.addFirst() successfully caught a NullPointerException");
    }
    
    p1.addLast​(s4);
    p1.addLast​(s5);
    p1.addFirst​(s2);
    p1.addFirst​(s1);
    p1.add​(1, s3);
    
    if (!p1.get​(0).equals(s1)) {
      System.out.println("SongPlayer.add() failed to add a song to the front");
      return false;
    }
    if (!p1.get​(1).equals(s2)) {
      System.out.println("SongPlayer.addFirst() failed to add a song");
      return false;
    }
    if (!p1.get​(2).equals(s3)) {
      System.out.println("SongPlayer.addFirst() failed to add a song");
      return false;
    }
    if (!p1.get​(3).equals(s4)) {
      System.out.println("SongPlayer.addFirst() failed to add a song");
      return false;
    }
    if (!p1.get​(4).equals(s5)) {
      System.out.println("SongPlayer.addFirst() failed to add a song");
      return false;
    }
    return true;
  }
  
  /**
   * This method checks for the correctness of getFirst(), getLast() and get(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerGet() {
    Song s1 = new Song("n1", "a1", "1:00");
    Song s2 = new Song("n2", "a2", "2:00");
    Song s3 = new Song("n3", "a3", "3:00");
    Song s4 = new Song("n4", "a4", "4:00");
    Song s5 = new Song("n5", "a5", "5:00");
    SongPlayer p1 = new SongPlayer();
    
    try {
      p1.getFirst();
      System.out.println("SongPlayer.getFirst() failed to throw a NoSuchElementException");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println("SongPlayer.getFirst() successfully caught a NoSuchElementException");
    }
    try {
      p1.getFirst();
      System.out.println("SongPlayer.getFirst() failed to throw a NoSuchElementException");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println("SongPlayer.getFirst() successfully caught a NoSuchElementException");
    }
    try {
      p1.get​(-1);
      System.out.println("SongPlayer.get() failed to throw an IndexOutOfBoundsException");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("SongPlayer.get() successfully caught an IndexOutOfBoundsException");
    }
    
    p1.addFirst​(s5);
    p1.addFirst​(s4);
    p1.addFirst​(s3);
    p1.addFirst​(s2);
    p1.addFirst​(s1);
    
    try {
      p1.get​(5);
      System.out.println("SongPlayer.get() failed to throw an IndexOutOfBoundsException");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("SongPlayer.get() successfully caught an IndexOutOfBoundsException");
    }
    
    if (!p1.getFirst().equals(s1)) {
      System.out.println("SongPlayer.getFirst() failed to get the first song");
      return false;
    }
    if (!p1.getLast().equals(s5)) {
      System.out.println("SongPlayer.getLast() failed to get the last song");
      return false;
    }
    if (!p1.get​(2).equals(s3)) {
      System.out.println("SongPlayer.get() failed to get a song");
      return false;
    }
    if (!p1.get​(3).equals(s4)) {
      System.out.println("SongPlayer.get() failed to get a song");
      return false;
    }
    if (!p1.get​(4).equals(s5)) {
      System.out.println("SongPlayer.get() failed to get a song");
      return false;
    }
    return true;
  }
  
  /**
   * This method checks for the correctness of removeFirst(), removeLast() and remove(int index)
   * method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerRemove() {
    Song s1 = new Song("n1", "a1", "1:00");
    Song s2 = new Song("n2", "a2", "2:00");
    Song s3 = new Song("n3", "a3", "3:00");
    Song s4 = new Song("n4", "a4", "4:00");
    Song s5 = new Song("n5", "a5", "5:00");
    SongPlayer p1 = new SongPlayer();
    
    p1.addFirst​(s5);
    p1.addFirst​(s4);
    p1.addFirst​(s3);
    p1.addFirst​(s2);
    p1.addFirst​(s1);
    
    //test remove(int) throws
    try {
      p1.remove​(5);
      System.out.println("SongPlayer.remove() failed to throw IndexOutOfBoundsException");
      return false;
    } catch(IndexOutOfBoundsException e) {
      System.out.println("SongPlayer.remove() sucessfully caught an IndexOutOFBoundsException");
    }
    try {
      p1.remove​(-1);
      System.out.println("SongPlayer.remove() failed to throw IndexOutOfBoundsException");
      return false;
    } catch(IndexOutOfBoundsException e) {
      System.out.println("SongPlayer.remove() sucessfully caught an IndexOutOFBoundsException");
    }
    
    
    //Test removeFirst() and removeLast()
    if (!p1.removeFirst().equals(s1)) {
      System.out.println("SongPlayer.removeFirst() failed to return the correct Song");
      return false;
    }
    if (!p1.removeLast().equals(s5)) {
      System.out.println("SongPlayer.removeLast() failed to return the correct Song");
      return false;
    }
    
    //Test remove(int)
    p1.addFirst​(s1);
    p1.addLast​(s5);
    if (!p1.remove​(4).equals(s5)) {
      System.out.println("SongPlayer.remove() failed to return the correct Song");
      return false;
    }
    if (!p1.remove​(3).equals(s4)) {
      System.out.println("SongPlayer.remove() failed to return the correct Song");
      return false;
    }
    if (!p1.remove​(2).equals(s3)) {
      System.out.println("SongPlayer.remove() failed to return the correct Song");
      return false;
    }
    if (!p1.remove​(1).equals(s2)) {
      System.out.println("SongPlayer.remove() failed to return the correct Song");
      return false;
    }
    try {
      p1.remove​(1);
      System.out.println("SongPlayer.remove() failed to throw an IndexOutOfBoundsException");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("SongPlayer.remove() successfully threw an IndexOutOfBoundsException");
    }
    if (!p1.remove​(0).equals(s1)) {
      System.out.println("SongPlayer.remove() failed to return the correct Song");
      return false;
    }
    p1.add​(0, s1);
    if (!p1.remove​(0).equals(s1)) {
      System.out.println("SongPlayer.remove() failed to return the correct Song");
      return false;
    }
    
    //Test remove(int) throws
    try {
      p1.remove​(0);
      System.out.println("SongPlayer.remove() failed to throw an IndexOutOfBoundsException when"
          + " there are no songs");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("SongPlayer.remove() successfully threw an IndexOutOfBoundsExcepetion"
          + " when given an empty playlist");
    }
    try {
      p1.remove​(4);
      System.out.println("SongPlayer.remove() failed to throw an IndexOutOfBoundsException when"
          + " there are no songs");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("SongPlayer.remove() successfully threw an IndexOutOfBoundsExcepetion"
          + " when given an empty playlist");
    }
    try {
      p1.remove​(2);
      System.out.println("SongPlayer.remove() failed to throw an IndexOutOfBoundsException when"
          + " there are no songs");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("SongPlayer.remove() successfully threw an IndexOutOfBoundsExcepetion"
          + " when given an empty playlist");
    }
    
    //Test removeFirst() and removeLast() throws
    try {
      p1.removeFirst();
      System.out.println("SongPlayer.removeFirst() failed to throw a NoSuchElementException "
          + "with an empty list");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println("SongPlayer.removeFirst() successfully caught a NoSuchElementException "
          + "when given an empty list");
    }
    try {
      p1.removeLast();
      System.out.println("SongPlayer.removeLast() failed to throw a NoSuchElementException "
          + "with an empty list");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println("SongPlayer.removeLast() successfully caught a NoSuchElementException "
          + "when given an empty list");
    }
    return true;
  }
 
  /**
   * This method checks for the correctness of iterator(), switchPlayingDirection() and 
   * String play() method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerIterator() {
    Song s1 = new Song("n1", "a1", "1:00");
    Song s2 = new Song("n2", "a2", "2:00");
    Song s3 = new Song("n3", "a3", "3:00");
    Song s4 = new Song("n4", "a4", "4:00");
    Song s5 = new Song("n5", "a5", "5:00");
    SongPlayer p1 = new SongPlayer();
    
    p1.addFirst​(s5);
    p1.addFirst​(s4);
    p1.addFirst​(s3);
    p1.addFirst​(s2);
    p1.addFirst​(s1);
    
    
    String expectedOutputFrwd = "Playing forward\nn1---a1---1:00\nn2---a2---2:00"
        + "\nn3---a3---3:00\nn4---a4---4:00\nn5---a5---5:00\n";
    String expectedOutputBkwd = "Playing backward\nn5---a5---5:00\nn4---a4---4:00"
        + "\nn3---a3---3:00\nn2---a2---2:00\nn1---a1---1:00\n";
    
    //Test switchPlayingDirection() iterator() and play()
    if (!p1.play().contains("Playing forward")) {
      System.out.println("SongPlayer.iterator() is not playing forwards");
      return false;
    }
    p1.switchPlayingDirection();
    if (!p1.play().contains("Playing backward")) {
      System.out.println("SongPlayer.iterator() is not playing backwards");
      return false;
    }
    p1.switchPlayingDirection();
    if (!p1.play().equals(expectedOutputFrwd)) {
      System.out.println("SongPlayer.play() returns incorrect String");
      return false;
    }
    p1.switchPlayingDirection();
    if (!p1.play().equals(expectedOutputBkwd)) {
      System.out.println("SongPlayer.play() returns incorrect String");
      return false;
    }
    p1.clear();
    if (!p1.play().equals("")) {
      System.out.println("SongPlayer.play() failed to return a blank String when given an empty "
          + "playlist");
      return false;
    }
    return true;
  }
  
  /**
   * This method checks for the correctness of contains(Object song), clear(),
   * isEmpty()and size() method in SongPlayer class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testSongPlayerCommonMethod() {
    Song s1 = new Song("n1", "a1", "1:00");
    Song s2 = new Song("n2", "a2", "2:00");
    Song s3 = new Song("n3", "a3", "3:00");
    Song s4 = new Song("n4", "a4", "4:00");
    Song s5 = new Song("n5", "a5", "5:00");
    SongPlayer p1 = new SongPlayer();
    
    //Tests size()
    p1.addFirst​(s5);
    if (p1.size() != 1) {
      System.out.println("SongPlayer.size() failed to return the correct size");
      return false;
    }
    p1.addFirst​(s4);
    if (p1.size() != 2) {
      System.out.println("SongPlayer.size() failed to return the correct size");
      return false;
    }
    p1.addFirst​(s3);
    if (p1.size() != 3) {
      System.out.println("SongPlayer.size() failed to return the correct size");
      return false;
    }
    p1.addFirst​(s2);
    if (p1.size() != 4) {
      System.out.println("SongPlayer.size() failed to return the correct size");
      return false;
    }
    p1.addFirst​(s1);
    if (p1.size() != 5) {
      System.out.println("SongPlayer.size() failed to return the correct size");
      return false;
    }
    
    //Test contains(Object song)
    if (!p1.contains​(s1)) {
      System.out.println("SongPlayer.contaions() failed to report a Song's presence in the "
          + "playlist");
      return false;
    }
    if (!p1.contains​(s2)) {
      System.out.println("SongPlayer.contaions() failed to report a Song's presence in the "
          + "playlist");
      return false;
    }
    if (!p1.contains​(s3)) {
      System.out.println("SongPlayer.contaions() failed to report a Song's presence in the "
          + "playlist");
      return false;
    }
    if (!p1.contains​(s4)) {
      System.out.println("SongPlayer.contaions() failed to report a Song's presence in the "
          + "playlist");
      return false;
    }
    if (!p1.contains​(s5)) {
      System.out.println("SongPlayer.contaions() failed to report a Song's presence in the "
          + "playlist");
      return false;
    }
    if (p1.size() != 5) {
      System.out.println("SongPlayer.size() failed to return the correct size");
    }
    
    //Tests clear()
    p1.clear();
    try {
      p1.getFirst();
      System.out.println("SongPlayer.clear() failed");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println("SongPlayer.clear success");
    }
    try {
      p1.getLast();
      System.out.println("SongPlayer.clear() failed");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println("SongPlayer.clear success");
    }
    try {
      p1.get​(0);
      System.out.println("SongPlayer.clear() failed");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("SongPlayer.clear success");
    }
    if (!p1.isEmpty()) {
      System.out.println("SongPlayer.clear() failed");
    }
    if (p1.size() != 0) {
      System.out.println("SongPlayer.size() failed");
    }
    return true;
  }
  
  /**
   * This method checks for the correctness of ForwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testForwardSongIterator() {
    LinkedNode<Song> l1 = new LinkedNode<Song>(null, new Song("n1", "a1", "1:00"), null);
    LinkedNode<Song> l2 = new LinkedNode<Song>(l1, new Song("n2", "a2", "2:00"), null);
    LinkedNode<Song> l3 = new LinkedNode<Song>(l2, new Song("n3", "a3", "3:00"), null);
    LinkedNode<Song> l4 = new LinkedNode<Song>(l3, new Song("n4", "a4", "4:00"), null);
    LinkedNode<Song> l5 = new LinkedNode<Song>(l4, new Song("n5", "a5", "5:00"), null);
    l1.setNext​(l2);
    l2.setNext​(l3);
    l3.setNext​(l4);
    l4.setNext​(l5);
    ForwardSongIterator f1 = new ForwardSongIterator(l1);
    
    //next() and hasNext() tests
    if (!f1.hasNext()) {
      System.out.println("ForwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l1.toString())) {
      System.out.println("ForwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (!f1.hasNext()) {
      System.out.println("ForwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l2.toString())) {
      System.out.println("ForwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (!f1.hasNext()) {
      System.out.println("ForwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l3.toString())) {
      System.out.println("ForwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (!f1.hasNext()) {
      System.out.println("ForwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l4.toString())) {
      System.out.println("ForwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (!f1.hasNext()) {
      System.out.println("ForwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l5.toString())) {
      System.out.println("ForwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (f1.hasNext()) {
      System.out.println("ForwardSongIterator.hasNext() failed to recognize a null next node");
      return false;
    }
    
    try {
      ForwardSongIterator f2 = new ForwardSongIterator(null);
      System.out.println(f2.next());
    } catch (NoSuchElementException e) {
      System.out.println("ForwardSongIterator.next() successfully caught a NoSuchElementException"
          + " when no song is next");
    }
    return true;
  }
  
  /**
   * This method checks for the correctness of BackwardSongIterator class
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBackwardSongIterator() {
    LinkedNode<Song> l1 = new LinkedNode<Song>(null, new Song("n1", "a1", "1:00"), null);
    LinkedNode<Song> l2 = new LinkedNode<Song>(l1, new Song("n2", "a2", "2:00"), null);
    LinkedNode<Song> l3 = new LinkedNode<Song>(l2, new Song("n3", "a3", "3:00"), null);
    LinkedNode<Song> l4 = new LinkedNode<Song>(l3, new Song("n4", "a4", "4:00"), null);
    LinkedNode<Song> l5 = new LinkedNode<Song>(l4, new Song("n5", "a5", "5:00"), null);
    l1.setNext​(l2);
    l2.setNext​(l3);
    l3.setNext​(l4);
    l4.setNext​(l5);
    BackwardSongIterator f1 = new BackwardSongIterator(l5);
    
    //next() and hasNext() tests
    if (!f1.hasNext()) {
      System.out.println("BackwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l1.toString())) {
      System.out.println("BackwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (!f1.hasNext()) {
      System.out.println("BackwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l2.toString())) {
      System.out.println("BackwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (!f1.hasNext()) {
      System.out.println("BackwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l3.toString())) {
      System.out.println("BackwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (!f1.hasNext()) {
      System.out.println("BackwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l4.toString())) {
      System.out.println("BackwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (!f1.hasNext()) {
      System.out.println("BackwardSongIterator.hasNext() failed to recognize a valid next node");
      return false;
    }
    if (f1.next().toString().equals(l5.toString())) {
      System.out.println("BackwardSongIterator.next() failed to get the correct node data");
      return false;
    }
    if (f1.hasNext()) {
      System.out.println("BackwardSongIterator.hasNext() failed to recognize a null next node");
      return false;
    }
    
    try {
      ForwardSongIterator f2 = new ForwardSongIterator(null);
      System.out.println(f2.next());
    } catch (NoSuchElementException e) {
      System.out.println("BackwardSongIterator.next() successfully caught a NoSuchElementException"
          + " when no song is next");
    }
    return true;
  }

  /**
   * This method calls all the test methods defined and implemented in your SongPlayerTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
    if (testSong() && testLinkedNode() && testForwardSongIterator() && testBackwardSongIterator() && 
        testSongPlayerAdd() && testSongPlayerGet() && testSongPlayerRemove()  && 
        testSongPlayerIterator() && testSongPlayerCommonMethod()) {
      return true;
    }
    return false;
  }

  /**
   * Driver method defined in this SongPlayerTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    if (runAllTests()) {
      System.out.println("All tests pass");
    } else {
      System.out.println("Back to work...");
    }
  }
}