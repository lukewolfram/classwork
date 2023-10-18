//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    User
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
 * This class stores username, password, and admin permissions of object User
 * @author Luke Wolfram
 */
public class User {
  private final String USERNAME;
  private String password;
  private boolean isAdmin;
  /**
   * Default constructor
   * @param username Username to set the the private USERNAME field
   * @param password Password to set to the private password field
   * @param isAdmin  Whether the User has been given admin perms or not
   */
  public User(String username, String password, boolean isAdmin) {
    this.USERNAME = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }
  /**
   * Makes sure that the password given is equal to the instance's private password field
   * @param password The password to compare
   * @return True if password param equals the private password field, false if not
   */
  public boolean isValidLogin(String password) {
    if (this.password.equals(password)) {
      return true;
    } 
    return false;
  }
  /**
   * Gets the username of the User
   * @return USERNAME
   */
  public String getUsername() {
    return USERNAME;
  }
  /**
   * Gets the admin status of the User
   * @return True if User is admin, false if not
   */
  public boolean getIsAdmin() {
    if (isAdmin) {
      return true;
    }
    return false;
  }
  /**
   * Sets the password of a User to a new password
   * @param password The new password to be set to the private password field
   */
  public void setPassword(String password) {
    this.password = password;
  }
  /**
   * Sets the admin status of a User
   * @param isAdmin True to make the User an admin, false if it is being revoked
   */
  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }
}
