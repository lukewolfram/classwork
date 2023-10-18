//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Room
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
 * Stores a String location and int capacity of a classroom in an object Room
 * @author Luke Wolfram
 */
public class Room {
  private String location;      //location of the room
  private int capacity;         //# of students that can fit in the room
  
  /**
   * Default constructor
   * @param location String to be set to private field location
   * @param capacity int to be set to private field capacity
   */
  public Room(String location, int capacity) {
    this.location = location;
    this.capacity = capacity;
  }
  
  /**
   * Getter for private field location
   * @return private field location
   */
  public String getLocation() {
    return location;
  }
  
  /**
   * Getter for private field capacity
   * @return private field capacity
   */
  public int getCapacity() {
    return capacity;
  }
  
  /**
   * Reduces the total room capacity by amount of students in a course
   * @param reduce amount of students to subtract the Room's capacity by
   * @return a new Room, which is the same as the initial Room, except that the capacity has been
   *         reduced
   */
  public Room reduceCapacity(int reduce) {
    if (reduce > getCapacity()) {
      throw new IllegalArgumentException("Room.reduceCapacity(): Reduce is greater than capacity");
    }
    Room newRoom = new Room(getLocation(), capacity - reduce);
    return newRoom;
  }
}
