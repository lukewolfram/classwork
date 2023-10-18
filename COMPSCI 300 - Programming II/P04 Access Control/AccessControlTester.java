//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Access Control Tester
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
 * Tests methods in AccessControl
 * @author Luke Wolfram
 */
public class AccessControlTester {
  /**
   * Calls runAllTests() and prints whether they all pass or not
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("All tests pass: " + runAllTests());
  }
  /**
   * Tests User.isValidLogin(), .getUsername(), .getIsAdmin(), .setPassword(), and .setIsAdmin()
   * @return True if all tests pass, false if not
   */
  public static boolean testUserConstructorAndMethods() {
    User testUser = new User("username", "password", true);
    if (!testUser.isValidLogin("password")) {
      System.out.println("User.isValidLogin() failed to recognize a valid password");
      return false;
    }
    if (!testUser.getUsername().equals("username")) {
      System.out.println("User.getUsername() failed to get correct username");
      return false;
    }
    if (!testUser.getIsAdmin()) {
      System.out.println("User.getIsAdmin() failed to get correct admin status");
      return false;
    }
    testUser.setPassword("test");
    if (!testUser.isValidLogin("test")) {
      System.out.println("User.setPassword() failed to set the password");
      return false;
    }
    testUser.setIsAdmin(false);
    if (testUser.getIsAdmin()) {
      System.out.println("User.setIsAdmin() failed to change admin status");
    }
    return true;
  }
  /**
   * Tests AccessControl.isValidLogin() for correctly logging in a user
   * @return True if all tests pass, false if not
   */
  public static boolean testAccessControlIsValidLoginNotValidUser() {
    AccessControl testUser = new AccessControl();
    if (AccessControl.isValidLogin("bad", "root")) {
      System.out.println("AccessControl.isValidLogin() failed to detect an invalid login when "
          + "passed an invalid username");
      return false;
    }
    if (AccessControl.isValidLogin("bad", "bad")) {
      System.out.println("AccessControl.isValidLogin() failed to detect an invalid login when "
          + "passed an invalid username and password");
      return false;
    }
    if (!AccessControl.isValidLogin("admin", "root")) {
      System.out.println("AccessControl.isValidLogin() failed to detect a valid login");
      return false;
    }
    return true;
  }
  /**
   * Tests AccessControl.addUser(String username)
   * @return True if all tests pass, false if not
   */
  public static boolean testAddUserWithNoAdminPowers() {
    AccessControl test = new AccessControl();
    test.setCurrentUser("admin");
    test.addUser("noadmin", false);
    test.setCurrentUser("noadmin");
    if (test.addUser("testusername")) {
      System.out.println("AccessControl.addUser() failed: Added a user while currentUser did not "
          + "have admin");
      return false;
    }
    try {
      test.addUser(null);
      System.out.println("AccessControl.addUser() failed: Did not throw an IllegalArgumentException "
          + "when passed a null username");
      return false;
    } catch (IllegalArgumentException e) {
        System.out.println(e);
    }
    try {
      test.addUser("test");
      System.out.println("AccessControl.addUser() failed: Did not throw an IllegalArgumentException "
          + "when passed a username less than 5 chars");
      return false;
    } catch (IllegalArgumentException e) {
        System.out.println(e);
    }
    test.setCurrentUser("admin");
    test.removeUser("noadmin");
    return true;
  }
  /**
   * Tests AccessControl.setCurrentUser() and .removeUser()
   * @return True if all tests pass, false if not
   */
  public static boolean testAddRemoveUserWithAdminPowers() {
    AccessControl test = new AccessControl();
    test.setCurrentUser("admin");
    if (test.addUser("testusername") == false) {
      System.out.println("AccessControl.addUser() failed: Did not add a user while "
          + "currentUser had admin");
      return false;
    }
    if (test.removeUser("testusername") == false) {
      System.out.println("AccessControl.removeUser() failed: Did not remove a user while "
          + "currentUser had admin");
      return false;
    }
    try {
      test.removeUser(null);
      System.out.println("AccessControl.removeUser() failed: Did not throw a "
          + "NoSuchElementException when passed a null username");
      return false;
    } catch (NoSuchElementException e) {
        System.out.println(e);
    }
    try {
      test.removeUser("test");
      System.out.println("AccessControl.removeUser() failed to throw a NoSuchElementException when "
          + "passed a username less than 5 chars");
      return false;
    } catch (NoSuchElementException e) {
        System.out.println(e);
    }
    return true;
  }
  /**
   * Runs all tests
   * @return True if all tester methods pass, false if not
   */
  public static boolean runAllTests() {
    if (testUserConstructorAndMethods() && testAccessControlIsValidLoginNotValidUser()
        && testAddUserWithNoAdminPowers() && testAddRemoveUserWithAdminPowers()) {
      return true;
    }
    return false;
  }
}
