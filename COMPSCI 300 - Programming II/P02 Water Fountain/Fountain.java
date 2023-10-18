//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Fountain
// Course:   CS 300 Spring 2022
//
// Author:   Luke Wolfram
// Email:    lwolfram@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:                NONE
// Partner Email:               NONE
// Partner Lecturer's Name:     NONE 
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:                     NONE 
// Online Sources:              NONE
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import java.io.File;
import processing.core.PImage;

/**
 * 
 * This class outputs a picture of a fountain with a flowing water effect
 * 
 * @author Luke Wolfram
 *
 */
public class Fountain {
  
  private static Random randGen;
  private static PImage fountainImage;
  private static int positionX;
  private static int positionY;
  private static Droplet[] droplets;
  private static int startColor;
  private static int endColor;
  
  /**
   * Creates however many droplets it has been called to create
   * 
   * @param dropletsToCreate amount of droplets to create
   */
  private static void createNewDroplets(int dropletsToCreate) {
    int dropletsCreated = 0;
    randGen = new Random();
    
    for (int i = 0; i < droplets.length; i++) {
      if (dropletsCreated == dropletsToCreate) {
        break;
      }
      if (droplets[i] == null) {
        droplets[i] = new Droplet(
            positionX + (randGen.nextFloat() * 6) - 3, 
            positionY + (randGen.nextFloat() * 6) - 3, 
            randGen.nextFloat() * 15 + 4, 
            Utility.lerpColor(startColor, endColor, randGen.nextFloat()));
        droplets[i].setVelocityX(randGen.nextFloat() * -2 + 1);
        droplets[i].setVelocityY(randGen.nextFloat() * -15 + 5);
        droplets[i].setAge(randGen.nextInt(41));
        droplets[i].setTransparency(randGen.nextInt(96) + 32);
        dropletsCreated++;
      }
    }
  }
  
  /**
   * Updates droplet position and age, making the effect that droplets are moving
   * 
   * @param index the index of the droplet in the droplets array that will be updated
   */
  private static void updateDroplet(int index) {
    Utility.circle(droplets[index].getPositionX(), 
        droplets[index].getPositionY(), droplets[index].getSize());
    Utility.fill(droplets[index].getColor(), 150);
    
    droplets[index].setVelocityY(0.3f);
    droplets[index].setPositionX(droplets[index].getPositionX() + droplets[index].getVelocityX());
    droplets[index].setPositionY(droplets[index].getPositionY() + droplets[index].getVelocityY());
    droplets[index].setAge(droplets[index].getAge() + 1);
  }
  
  /**
   * Removes any droplet when it reaches the age passed
   * 
   * @param maxAge the age that droplets will be removed at
   */
  private static void removeOldDroplets(int maxAge) {
    for (int i = 0; i < droplets.length; i++) {
      if (droplets[i] != null && droplets[i].getAge() > maxAge) {
        droplets[i] = null;
      }
    }
  }
  
  /**
   * Initializes multiple private fields needed in later methods,
   * like position, the fountain image, droplet colors, and the array of droplets to be modified
   */
  public static void setup() {
    randGen = new Random();
    positionX = Utility.width()/2;  //x center of the display window
    positionY = Utility.height()/2; //y center of the display window
    fountainImage = Utility.loadImage("images" + File.separator + "fountain.png");
    startColor = Utility.color(23, 141, 235);   //blue
    endColor = Utility.color(23, 200, 255);     //light blue
    droplets = new Droplet[800];
  }
  
  /**
   * Continuously outputs the background, the fountain, and the fountains water effect
   * (calling createNewDroplets(), updateDroplets(), and removeOldDroplets())
   */
  public static void draw() {
    Utility.background(Utility.color(253,245,230));
    Utility.image(fountainImage, positionX, positionY);
    
    createNewDroplets(10);
    
    for (int i = 0; i < droplets.length; i++) {
      if (droplets[i] != null) {
        updateDroplet(i);
      }
    }
    removeOldDroplets(80);
  }
  
  /**
   * Moves the fountain and its water effect to wherever the mouse cursor 
   * is positioned at when it is clicked/held
   */
  public static void mousePressed() {
    positionX = Utility.mouseX();
    positionY = Utility.mouseY();
  }
  
  /**
   * Takes a screenshot when the 's'/'S' key is pressed
   * 
   * @param key the keyboard key pressed that is passed as input
   */
  public static void keyPressed(char key) {
    if (key == 's' || key == 'S') {
      Utility.save("screenshot.png");
    }
  }

  /**
   * Runs all methods.  Calls the setup() method once, and continuously calls
   * the draw(), mousePressed(), and keyPressed() methods.
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    Utility.runApplication();
  }
  
  /**
  * This tester initializes the droplets array to hold at least three droplets.
  * Creates a single droplet at position (3,3) with velocity (-1,-2). Then checks
  * whether calling updateDroplet() on this droplet's index correctly results in
  * changing its position to (2.0, 1.3).
  *
  * @return true when no defect is found, and false otherwise
  */
  private static boolean testUpdateDroplet() {
    if(droplets[0].getPositionX() != 2.0) {
      System.out.println("Problem detected: Your updateDroplet() method "
          + "failed to return the droplet's expected X position when passed a "
          + "droplet with positionX = 3");
      return false;
    }
    if(droplets[0].getPositionY() != 1.3) {
      System.out.println("Problem detected: Your updateDroplet() method "
          + "failed to return the droplet's expected Y position when passed a "
          + "droplet with positionX = 3");
      return false;
    }
  return true;
  }
  /**
  * This tester initializes the droplets array to hold at least three droplets.
  * Calls removeOldDroplets(6) on an array with three droplets (two of which have
  * ages over six and another that does not). Then checks whether the old droplets
  * were removed and the young droplet was left alone.
  *
  * @return true when no defect is found, and false otherwise
  */
  private static boolean testRemoveOldDroplets() {
    if(droplets[0] != null || droplets[1] != null) {
      System.out.println("Problem detected: Your removeOldDroplets() method "
          + "failed to remove old droplets when passed an array with "
          + "2 old droplets and 1 young droplet");
      return false;
    }
    if(droplets[2] == null) {
      System.out.println("Problem detected: Your removeOldDroplets() method "
          + "removed a young droplet when passed an array with "
          + "2 old droplets and 1 young droplet");
      return false;
    }
  return true;
  }
}
