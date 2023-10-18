//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Schedule
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

import java.util.Arrays;

/**
 * Assigns courses to rooms
 * @author Luke Wolfram
 */
public class Schedule {
  private Room[] rooms;         //Array with Room objects
  private Course[] courses;     //Array with Course objects
  private int[] assignments;    //Array where the index is the Course from courses[] and
                                //the element at assignments[index] is the Room from rooms[] that
                                //the course is assigned to
  
  /**
   * Default constructor.  Creates an empty assignments array
   * @param roomArray array of Rooms that will be assigned to private field rooms
   * @param courseArray array of Courses that will be assigned to private field courses
   */
  public Schedule(Room[] roomArray, Course[] courseArray) {
    this.rooms = roomArray;
    this.courses = courseArray;
    int assignArray[] = new int[courseArray.length];
    Arrays.fill(assignArray, -1);
    this.assignments = assignArray;
  }
  
  /**
   * Special constructor that will be called when called when assigning courses to the assignments
   * array
   * @param roomArray           array of Rooms that will be assigned to private field rooms
   * @param courseArray         array of Courses that will be assigned to private field courses
   * @param assignmentsArray    array of ints that will be assigned to private field assignments
   */
  private Schedule(Room[] roomArray, Course[] courseArray, int[] assignmentsArray) {
    this.rooms = roomArray;
    this.courses = courseArray;
    this.assignments = assignmentsArray;
  }
  
  /**
   * Getter for the amount of Room objects in rooms
   * @return an int the length of rooms
   */
  public int getNumRooms() {
    return rooms.length;
  }
  
  /**
   * Getter for the Room at the index
   * @param index
   * @return Room object that is at index
   * @throws IndexOutOfBoundsException if invalid index
   */
  public Room getRoom(int index) {
    if (index < 0 || index >= rooms.length) {
      throw new IndexOutOfBoundsException("Schedule.getRoom(): Invalid room index");
    }
    return rooms[index];
  }
  
  /**
   * Getter for amount of Course objects in courses
   * @return an int the length of courses
   */
  public int getNumCourses() {
    return courses.length;
  }
  
  /**
   * Getter for the Course at the index
   * @param index
   * @return Course object at index
   * @throws IndexOutOfBoundsException if invalid index
   */
  public Course getCourse(int index) {
    if (index < 0 || index >= courses.length) {
      throw new IndexOutOfBoundsException("Schedule.getCourse(): Invalid course index");
    }
    return courses[index];
  }
  
  /**
   * Checks if a course is assigned to a room
   * @param index the course to check from the assignments array
   * @return boolean true if the course is assigned a course, false if otherwise
   */
  public boolean isAssigned(int index) {
    if (assignments[index] != -1) {
      return true;
    }
    return false;
  }
  
  /**
   * Getter for the Room object assigned to the course at the index
   * @param index the course to find the Room object from
   * @return Room object
   * @throws IndexOutOfBoundsException if invalid course index
   * @throws IllegalArgumentException if course hasn't been assigned a room
   */
  public Room getAssignment(int index) {
    if (index < 0 || index >= courses.length) {
      throw new IndexOutOfBoundsException("Schedule.getAssignment(): Invalid course index");
    }
    if (assignments[index] == -1) {
      throw new IllegalArgumentException("Schedule.getAssignment(): Course has not been "
          + "assigned a room");
    }
    return rooms[assignments[index]];
  }
  
  /**
   * Checks if every course has been assigned a room
   * @return true if every course has been assigned a room, false if otherwise
   */
  public boolean isComplete() {
    for (int i = 0; i < assignments.length; i++) {
      if (assignments[i] == -1) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * Assigns a course and room to the private field assignments 
   * @param courseIndex the index of assignments[] to be assigned a room
   * @param roomIndex   the index of rooms[] that will be added to assignments[] at courseIndex
   * @return A new schedule that has a room assigned to the course
   * @throws IndexOutOfBoundsException if either index is invalid
   * @throws IllegalArgumentException if Course has already been assigned a room or room can not
   *                                  fit the amount of students in the course
   */
  public Schedule assignCourse(int courseIndex, int roomIndex) {
    if (courseIndex < 0 || courseIndex >= courses.length) {
      throw new IndexOutOfBoundsException("Schedule.assignCourse(): Invalid course index of "
          + courseIndex);
    }
    if (roomIndex < 0 || roomIndex >= rooms.length) {
      throw new IndexOutOfBoundsException("Schedule.assignCourse(): Invalid room index of "
          + roomIndex);
    }
    if (isAssigned(courseIndex)) {
      throw new IllegalArgumentException("Schedule.assignCourse(): Course already assigned a room");
    }
    if (courses[courseIndex].getNumStudents() > rooms[roomIndex].getCapacity()) {
      throw new IllegalArgumentException("Schedule.assignCourse(): Room does not have "
          + "sufficient capacity");
    }
    
    int[] newAssignmentsArray = assignments.clone();
    newAssignmentsArray[courseIndex] = roomIndex;
    Room[] newRooms = rooms.clone();
    newRooms[roomIndex] = newRooms[roomIndex].reduceCapacity(courses[courseIndex].getNumStudents());
    Schedule newSchedule = new Schedule(newRooms, courses, newAssignmentsArray);
    return newSchedule;
  }
  
  @Override
  /**
   * Returns a string in the format "{class: assignment, ...}" 
   */
  public String toString() {
    String s = "{";
    for (int i = 0; i < assignments.length; i++) {
      if (assignments[i] == -1) {
        s = (s + courses[i].getName() + ": Unassigned, ");
      } else {
        s = (s + courses[assignments[i]].getName() + ": " + rooms[i].getLocation() + ", ");
      }
    }
    if (s.endsWith(", ")) {
      s = s.substring(0, s.length() - 2);
    }
    s = s.concat("}");
    return s;
  }
}
