//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Access Control
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

import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * This class stores the information of users and allows an admin to modify it freely
 * @author Luke Wolfram
 */
public class AccessControl {
  private static ArrayList<User> users;
  private User currentUser;
  private static final String DEFAULT_PASSWORD = "changeme";
  /**
   * Default constructor.  Creates an ArrayList of type User with if there is no
   * current ArrayList.  Adds only one user to the new ArrayList 
   * which has admin commands, and then sets currentUser to null
   */
  public AccessControl() {
    if (users == null) {
      users = new ArrayList<User>();
      User user = new User("admin", "root", true);
      users.add(user);
    }
    currentUser = null;
  }
  /**
   * Determines whether or not a given username and password corresponds to an instance of a User
   * class in users<>
   * 
   * @param username The username of the User to look for in users<>
   * @param password The password of the User to look for in users<>
   * @return True if username and password are found in the same User, false if not
   */
  public static boolean isValidLogin(String username, String password) {
    for (int i = 0; i < users.size(); i++) {
      if ((users.get(i).getUsername()).equals(username) && users.get(i).isValidLogin(password)) {
        System.out.println("Welcome " + username);
        return true;
      }
    }
    System.out.println("Invalid login");
    return false;
  }
  /**
   * Logs the current user out by setting currentUser to null
   */
  public void logout() {
    currentUser = null;
  }
  /**
   * Changes the password of the current user
   * 
   * @param newPassword The new password to set the User's password to       
   */
  public void changePassword(String newPassword) {
    currentUser.setPassword(newPassword);
  }
  /**
   * Sets the current user
   * 
   * @param username The User to be the current user
   */
  public void setCurrentUser(String username) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        currentUser = users.get(i);
        System.out.println("Current user: " + users.get(i).getUsername());
        break;
      } 
      if (i == users.size() - 1) {
        System.out.println("User not found");
      }
    }
  }
  /**
   * Adds a new instance of User to users<> with default password and no admin
   * 
   * @param username The username of the User to add
   * @return True if user was added, false if current user is null or does not have admin 
   *         or if the new user was not found in users<>
   * @throws IllegalArgumentException if username is not unique or not formatted correctly
   */
  public boolean addUser(String username) {
    if (username == null || username.length() < 5) {
      throw new IllegalArgumentException("Username is null or less than 5 chars");
    }
    if (currentUser == null || !currentUser.getIsAdmin()) {
      System.out.println("Admin required to add users");
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        throw new IllegalArgumentException("Username is taken");
      }
    }
    User newUser = new User(username, DEFAULT_PASSWORD, false);
    users.add(newUser);
    if (users.get(users.size() - 1).getUsername().equals(username)) {
      System.out.println("User " + username + " added");
      return true;
    }
    return false;
  }
  /**
   * Adds a new instance of User to users<> that can have admin
   * 
   * @param username The username of the User to add
   * @param isAdmin Whether or not the new User will have admin
   * @return True if user was added, false if current user is null or does not have admin 
   *         or if the new user was not found in users<>
   * @throws IllegalArgumentException if username is not unique or not formatted correctly
   */
  public boolean addUser(String username, boolean isAdmin) {
    if (username == null || username.length() < 5) {
      throw new IllegalArgumentException("Username is null or less than 5 chars");
    }
    if (currentUser == null || !currentUser.getIsAdmin()) {
      System.out.println("Admin required to add users");
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        throw new IllegalArgumentException("Username is taken");
      }
    }
    User newUser = new User(username, DEFAULT_PASSWORD, isAdmin);
    users.add(newUser);
    if (users.get(users.size() - 1).getUsername().equals(username)) {
      System.out.println("User " + username + " added");
      return true;
    }
    return false;
  }
  /**
   * Removes an instance of User from users<>
   * @param username The User to remove
   * @return True if user was removed.  False if current user is null or does not have admin, and if
   *         User was not removed
   * @throws NoSuchElementException If User not found
   */
  public boolean removeUser(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      System.out.println("Admin required to remove users");
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.remove(users.get(i));
        for (int j = 0; j < users.size(); j++) {
          if (users.get(j).getUsername().equals(username)) {
            return false;
          }
          if (j == users.size() - 1) {
            System.out.println("User " + username + " removed");
            return true;
          }
        }
      }
      if (i == users.size() - 1) {
        throw new NoSuchElementException("User not found");
      }
    }
    return false;
  }
  /**
   * Gives admin to a User
   * @param username The user to give admin to
   * @return True if user was given admin, false if currentUser is null, doesn't have admin, or 
   *         the user was not given admin
   * @throws NoSuchElementException if user not found
   */
  public boolean giveAdmin(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      System.out.println("Admin required to give users admin");
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setIsAdmin(true);
        if (users.get(i).getIsAdmin()) {
          System.out.println("User " + username + " given admin");
          return true;
        }
      }
      if (i == users.size() - 1) {
        throw new NoSuchElementException("User not found");
      }
    }
    return false;
  }
  /**
   * Removes admin from a user
   * @param username The user to remove admin from
   * @return True if admin was removed, false if currentUser is null, doesn't have admin, or admin
   *         was not removed
   * @throws NoSuchElementException if user not found
   */
  public boolean takeAdmin(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      System.out.println("Admin required to take admin");
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setIsAdmin(false);
        if (!users.get(i).getIsAdmin()) {
          System.out.println("User " + username + " lost admin");
          return true;
        }
      }
      if (i == users.size() - 1) {
        throw new NoSuchElementException("User not found");
      }
    }
    return false;
  }
  /**
   * Resets a user's password to the default password
   * @param username the user to reset the password of
   * @return True if password was reset, false if no current user or current user doesn't have admin
   *         or if password was not reset
   * @throws NoSuchElementException if user not found
   */
  public boolean resetPassword(String username) {
    if (currentUser == null || !currentUser.getIsAdmin()) {
      System.out.println("Admin required to reset passwords");
      return false;
    }
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(username)) {
        users.get(i).setPassword(DEFAULT_PASSWORD);
        if (users.get(i).isValidLogin(DEFAULT_PASSWORD)) {
          System.out.println("User " + username + " password reset");
          return true;
        }
      }
      if (i == users.size() - 1) {
        throw new NoSuchElementException("User not found");
      }
    }
    return false;
  }
}
