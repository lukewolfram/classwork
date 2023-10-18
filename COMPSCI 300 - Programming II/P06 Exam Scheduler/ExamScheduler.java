//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    ExamScheduler
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
import java.util.ArrayList;

/**
 * Find valid schedules for courses and rooms
 * @author Luke Wolfram
 */
public class ExamScheduler {
  /**
   * Finds a valid schedule
   * @param rooms   Array of Room objects
   * @param course  Array of Course objects
   * @return schedule with rooms assinged to courses
   */
  public static Schedule findSchedule(Room[] rooms, Course[] course) {
    Schedule schedule = new Schedule(rooms, course);
    Schedule scheduleToReturn = findScheduleHelper(schedule, 0);
    return scheduleToReturn;
  }
  
  /**
   * Helper method for findSchedule.  Assigns all the courses and rooms correctly
   * @param schedule    an empty schedule
   * @param index       the course
   * @return schedule with courses and rooms assigned
   * @throws IllegalStateException if every course can not be assigned a room
   */
  private static Schedule findScheduleHelper(Schedule schedule, int index) {
    int sortedArray[] = new int[schedule.getNumCourses()];
    Arrays.fill(sortedArray, -1);
    
    if (index == schedule.getNumCourses()) {
      if (!schedule.isComplete()) {
        throw new IllegalStateException("findScheduleHelper(): Schedule is invalid");
      }
      return schedule;
    }
    else if (schedule.isAssigned(index)) {
      index++;
      return findScheduleHelper(schedule, index);
    }
    //A bit weird here.  Basically I find the capacity of a room after subtracting a course's
    //number of students.  Find the smallest difference and assign the course with that.
    else if (!schedule.isAssigned(index)) {
      for (int i = 0; i < schedule.getNumCourses(); i++) {
        if (schedule.getRoom(i).getCapacity() >= schedule.getCourse(index).getNumStudents()) {
          sortedArray[i] = schedule.getRoom(i).getCapacity() 
              - schedule.getCourse(index).getNumStudents();
        }
      }
      int unsortedArray[] = sortedArray.clone();
      Arrays.sort(sortedArray);
      int smallestDifferenceIndex = -1;
      for (int j = 0; j < sortedArray.length; j++) {
        if (sortedArray[j] == -1) {
          continue;
        }
        for (int k = 0; k < sortedArray.length; k++) {
          if (unsortedArray[k] == sortedArray[j]) {
            smallestDifferenceIndex = k;
            break;
          }
        }
        break;
      }
      if (smallestDifferenceIndex == -1) {
        return findScheduleHelper(schedule, index + 1);
      }
      schedule = schedule.assignCourse(index, smallestDifferenceIndex);
      return findScheduleHelper(schedule, index + 1);
    }
    return schedule;
  }
  
  /**
   * Finds all valid schedules
   * @param rooms   array of Room objects
   * @param courses array of Course objects
   * @return an ArrayList with all possible, valid schedules
   */
  public static ArrayList<Schedule> findAllSchedules(Room[] rooms, Course[] courses) {
    ArrayList<Schedule> allSchedules = new ArrayList<Schedule>();
    Schedule schedule = new Schedule(rooms, courses);
    allSchedules = (findAllSchedulesHelper(schedule, 0));
    return allSchedules;
  }
  
  /**
   * Helper method for findAllSchedules.  I didn't have enough time to finish it
   * @param schedule an empty schedule to be modified and added to the ArrayList of Schedule objects 
   * @param index    the course
   * @return an ArrayList with all possible, valid schedules
   */
  private static ArrayList<Schedule> findAllSchedulesHelper(Schedule schedule, int index) {
    ArrayList<Schedule> scheduleArrayList = new ArrayList<Schedule>();
    
    if (index == schedule.getNumCourses()) {
      if (schedule.isComplete()) {
        scheduleArrayList.add(schedule);
        return scheduleArrayList;
      }
    }
    else if (schedule.isAssigned(index)) {
      index++;
      return findAllSchedulesHelper(schedule, index);
    }
    else if (!schedule.isAssigned(index)) {
      index++;
      return findAllSchedulesHelper(schedule, index);
    }
    return scheduleArrayList;
  }
}
