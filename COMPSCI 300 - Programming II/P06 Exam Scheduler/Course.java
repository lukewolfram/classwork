//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Course
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
 * Creates and stores a name and amount of students in an object Course
 * @author Luke Wolfram
 */
public class Course {
  private String name;          //name of the course
  private int numStudents;      //amount of students in the course
  
  /**
   * Default constructor
   * @param name            name of the course to set to private field name
   * @param numStudents     amount of students to set to private field numStudents
   * @throws IllegalArgumentException if numStudents is <= 0
   */
  public Course(String name, int numStudents) {
    if (numStudents <= 0) {
      throw new IllegalArgumentException("Course constructor 1: Number of students can not be less "
          + "than or equal to zero");
    }
    this.name = name;
    this.numStudents = numStudents;
  }
  
  /**
   * Getter for private field name
   * @return Stringname
   */
  public String getName() {
    return name;
  }
  
  /**
   * Getter for private field numStudents
   * @return int numStudents
   */
  public int getNumStudents() {
    return numStudents;
  }
}
