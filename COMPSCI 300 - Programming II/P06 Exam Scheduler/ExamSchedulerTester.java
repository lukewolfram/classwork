//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ExamSchedulerTester
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
 * Project method tester
 * @author Luke Wolfram
 */
public class ExamSchedulerTester {
  
  /**
   * Calls all testing methods and prints a result
   * @param args input args if any
   */
  public static void main(String[] args) {
    System.out.println("Initiating tests...");
    if (testAllMethods()) {
      System.out.println("All tests passed!");
    } else {
      System.out.println("Back to work...");
    }
  }
  
  /**
   * Tests methods in the Course class
   * @return true if all tests pass, false if not
   */
  public static boolean testCourse() {
    Course test = new Course("CS300", 300);
    
    //Test if the right name has been retrieved
    if (!test.getName().equals("CS300")) {
      System.out.println("Course.getName() failed to get the right name");
      return false;
    }
    
    //Test if the right # of students retrieved
    if (test.getNumStudents() != 300) {
      System.out.println("Course.getName() failed to get the right number of students");
      return false;
    }
    
    //Test the constructor with an invalid numStudents
    try {
      Course test2 = new Course("CS300", 0);
      System.out.println("Course constructor did not throw an IllegalArgumentException when given"
          + " a number of students less than or equals to 0");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    return true;
  }
  
  /**
   * Tests methods in the Room class
   * @return true if all tests pass, false if otherwise
   */
  public static boolean testRoom() {
    Room test = new Room("Noland 168", 200);
    
    //Tests location retrieval
    if (!test.getLocation().equals("Noland 168")) {
      System.out.println("Room.getLocation() failed to get the right location");
      return false;
    }
    
    //Tests capacity retrieval
    if (test.getCapacity() != 200) {
      System.out.println("Romo.getCapacity() failed to get the right capacity");
      return false;
    }
    
    //Tests reduce capacity with a reduce param larger than the Room capacity
    try {
      test.reduceCapacity(201);
      System.out.println("Room.reduceCapacity() failed to throw an IllegalArgumentException when"
          + " trying to remove an int greater than its capacity");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    return true;
  }
  
  /**
   * Tests getter methods in the Schedule class
   * @return true if all tests pass, false if otherwise
   */
  public static boolean testSchedulersAccessors() {
    Room room1 = new Room("R1location", 50);
    Room room2 = new Room("R2location", 100);
    Room room3 = new Room("R3Location", 200);
    Room[] rooms = {room1, room2, room3};
    Course course1 = new Course("CS200", 1);
    Course course2 = new Course("CS300", 80);
    Course course3 = new Course("CS240", 150);
    Course[] courses = {course1, course2, course3};
    Schedule schedule = new Schedule(rooms, courses);
    
    //Tests .getNumRooms()
    if (schedule.getNumRooms() != 3) {
      System.out.println("Schedule.getNumRooms() failed to get the correct number of rooms");
      return false;
    }
    //Tests .getNumCourses()
    if (schedule.getNumCourses() != 3) {
      System.out.println("Schedule.getNumCourses() failed to get the correct number of courses");
      return false;
    }
    //Tests .isAssigned()
    if (schedule.isAssigned(0)) {
      System.out.println("Schedule.isAssigned() reported a course as assigned when it is not");
      return false;
    }
    //Tests .isComplete()
    if (schedule.isComplete()) {
      System.out.println("Schedule.isCopmlete() reported all courses assigned when not");
      return false;
    }
    //Tests .toString() for correct output
    if (!schedule.toString().equals("{CS200: Unassigned, CS300: Unassigned, CS240: Unassigned}")) {
      System.out.println("Schedule.toString() failed to return the correct string");
      System.out.println("Printed: " + schedule.toString());
      return false;
    }
    //Tests retrieval of a Room's location
    if (!schedule.getRoom(0).getLocation().equals("R1location")) {
      System.out.println("Schedule.getRoom() failed to return the correct room location");
      return false;
    }
    //Tests retrieval of a Room's capacity
    if (schedule.getRoom(0).getCapacity() != 50) {
      System.out.println("Schedule.getRoom() failed to return the correct room capacity");
      return false;
    }
    //Tests retrieval of a Course's name
    if (!schedule.getCourse(0).getName().equals("CS200")) {
      System.out.println("Schedule.getCourse() failed to return the correct course name");
      return false;
    }
    //Tests retrieval of a Course's numStudents
    if (schedule.getCourse(0).getNumStudents() != 1) {
      System.out.println("Schedule.getRoom() failed to return the correct course student amount");
      return false;
    }
    //Tests .getRoom() throws
    try {
      schedule.getRoom(3);
      System.out.println("schedule.getRoom() failed to throw an IndexOutOfBoundsException");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
    }
    //Tests .getCourse() throws
    try {
      schedule.getCourse(3);
      System.out.println("schedule.getCourse() failed to throw an IndexOutOfBoundsException");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
    }
    //Tests .getAssignment() throws
    try {
      schedule.getAssignment(3);
      System.out.println("schedule.getAssignment() failed to throw an IndexOutOfBoundsException");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
    }
    try {
      schedule.getAssignment(0);
      System.out.println("schedule.getAssignment() failed to throw an IllegalArgumentException");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    return true;
  }
  
  public static boolean testAssignCourse() {
    Room room1 = new Room("R1location", 50);
    Room room2 = new Room("R2location", 90);
    Room room3 = new Room("R3Location", 300);
    Room[] rooms = {room1, room2, room3};
    Course course1 = new Course("CS200", 1);
    Course course2 = new Course("CS300", 80);
    Course course3 = new Course("CS240", 150);
    Course[] courses = {course1, course2, course3};
    Schedule schedule = new Schedule(rooms, courses);
    
    //Tests .assignCourse() throws
    try {
      schedule.assignCourse(-1, 0);
      System.out.println("Schedule.assignCourse() failed to throw an IndexOutOfBoundsException"
          + " with an invalid course index");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
    }
    try {
      schedule.assignCourse(3, 0);
      System.out.println("Schedule.assignCourse() failed to throw an IndexOutOfBoundsException"
          + " with an invalid course index");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
    }
    try {
      schedule.assignCourse(0, -1);
      System.out.println("Schedule.assignCourse() failed to throw an IndexOutOfBoundsException"
          + " with an invalid room index");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
    }
    try {
      schedule.assignCourse(0, 3);
      System.out.println("Schedule.assignCourse() failed to throw an IndexOutOfBoundsException"
          + " with an invalid room index");
      return false;
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
    }
    try {
      schedule.assignCourse(2, 0);
      System.out.println("Schedule.assignCourse() failed to throw an IllegalArgumentException"
          + " with a room that has insufficient capacity");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    schedule = schedule.assignCourse(0, 0);
    
    //Tests if a course was assigned
    if (!schedule.isAssigned(0)) {
      System.out.println("Schedule.assignCourse() did not assign a course");
      return false;
    }
    //Tests if a Room's capacity was reduced after being assigned a course
    if (schedule.getAssignment(0).getCapacity() != 49) {
      System.out.println("Schedule.assignCourse() did not reduce the capacity when assigning a "
          + "course");
      return false;
    }
    try {
      schedule.assignCourse(0, 0);
      System.out.println("Schedule.assignCourse() failed to throw an IllegalArgumentException"
          + " with a course already assigned a room");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    return true;
  }
  
  public static boolean testFindSchedule() {
    Room room1 = new Room("0", 75);
    Room room2 = new Room("1", 100);
    Room room3 = new Room("2", 15);
    Room[] rooms1 = {room1, room2, room3};
    Course course1 = new Course("a", 15);
    Course course2 = new Course("b", 90);
    Course course3 = new Course("c", 70);
    Course[] courses1 = {course1, course2, course3};
    Schedule schedule = ExamScheduler.findSchedule(rooms1, courses1);
    
    //Tests if findSchedule produces the expected schedule
    if (!schedule.toString().equals("{c: 0, b: 1, a: 2}")) {
      System.out.println("ExamScheduler.findSchedule() failed to produce the correct string "
          + "representation");
      return false;
    }
    
    Room room4 = new Room("0", 75);
    Room room5 = new Room("1", 100);
    Room room6 = new Room("2", 15);
    Room[] rooms2 = {room4, room5, room6};
    Course course4 = new Course("a", 20);
    Course course5 = new Course("b", 110);
    Course course6 = new Course("c", 80);
    Course[] courses2 = {course4, course5, course6};
    
    //Tests if findSchedule will throw when given an invalid schedule
    try {
      Schedule schedule2 = ExamScheduler.findSchedule(rooms2, courses2);
      System.out.println("ExamScheduler.findSchedule() failed to throw an IllegalStateException");
      return false;
      
    } catch (IllegalStateException e) {
      System.out.println(e);
    }
    return true;
  }
  
  public static boolean testFindAllSchedules() {
    return true;
  }
  
  public static boolean testAllMethods() {
    if (testCourse() && testRoom() && testSchedulersAccessors() && testAssignCourse()
        && testFindSchedule() && testFindAllSchedules()) {
      return true;
    }
    return false;
  }
}
