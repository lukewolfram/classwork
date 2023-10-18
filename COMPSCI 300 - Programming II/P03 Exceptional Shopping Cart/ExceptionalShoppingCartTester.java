//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Exceptional Shopping Cart Tester
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

import java.io.File;
import java.util.NoSuchElementException;

/**
 * This tests if all methods of ExceptionalShoppingCart properly handle exceptions
 * 
 * @author Luke Wolfram
 *
 */
public class ExceptionalShoppingCartTester {
  /**
   * Calls runAllTests() to test all methods and prints the result
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.print("All tests pass: " + runAllTests());
  }
  /**
   * Tests ExceptionalShoppingCart.lookupProductByName() 
   * and ExceptionalShoppingcart.lookupProductById() for proper exception handling when passed
   * invalid names and identifiers
   * 
   * @return true if no tests fail, false if otherwise
   */
  public static boolean testLookupMethods() {
    try {
      ExceptionalShoppingCart.lookupProductByName(null);
      System.out.println("lookupProductByName failed to throw a NoSuchElementException when "
          + "passed null");
      return false;
    } catch (NoSuchElementException e) {
        System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.lookupProductByName("");
      System.out.println("lookupProductByName failed to throw a NoSuchElementException when "
          + "passed an empty string");
      return false;
    } catch (NoSuchElementException e) {
        System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.lookupProductByName("NOT FOUND");
      System.out.println("lookupProductByName failed to throw a NoSuchElementException when "
          + "passed an item not found in the market");
      return false;
    } catch (NoSuchElementException e) {
        System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.lookupProductById(9);
      System.out.println("lookupProductById failed to throw an IllegalArgumentException when "
          + "passed an ID not found in the market");
      return false;
    } catch (IllegalArgumentException e) {
        System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.lookupProductById(9999);
      System.out.println("lookupProductById failed to throw an IllegalArgumentException when "
          + "passed an ID not found in the market");
      return false;
    } catch (NoSuchElementException e) {
        System.out.println(e);
    }
    return true;
  }
  /**
   * Tests ExceptionalShoppingCart.addItemToMarketCatalog() for proper handling of exceptions
   * when passed various invalid identifiers, names, and prices
   * 
   * @return true if no tests fail, false if otherwise
   */
  public static boolean testAddItemToMarketCatalog() {
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog(null, "Strawberry", "$4.99");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed a null ID");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("", "Strawberry", "$4.99");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed an empty ID");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("9", "Strawberry", "$4.99");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed an invalid ID");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("asdf", "Strawberry", "$4.99");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed an invalid ID");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("4032", null, "$4.99");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed a null item name");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("4032", "", "$4.99");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed an empty item name");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("4032", "Strawberry", null);
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed a null price");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("4032", "Strawberry", "");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed an empty price");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("4032", "Strawberry", "string");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed a price that is not parsable to a double");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("4032", "Strawberry", "$499");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed a price that is not parsable to a double");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.addItemToMarketCatalog("4032", "Strawberry", "$4.9.9");
      System.out.println("addItemToMarketCatalog failed to throw an IllegalArgumentException when "
          + "passed a price that is not parsable to a double");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
    
    return true;
  }
  /**
   * Tests ExceptionalShoppingCart.getProductPrice() for proper handling of exceptions 
   * when passed invalid names
   * 
   * @return true if no test fails, false if otherwise
   */
  public static boolean testGetProductPrice() {
    try {
      ExceptionalShoppingCart.getProductPrice("NOT FOUND");
      System.out.println("getProductPrice failed to throw a NoSuchElementException when "
          + "passed an item not found in the market");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.getProductPrice(null);
      System.out.println("getProductPrice failed to throw a NoSuchElementException when "
          + "passed null");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.getProductPrice("");
      System.out.println("getProductPrice failed to throw a NoSuchElementException when "
          + "passed an empty string");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println(e);
    }
    return true;
  }
  /**
   * Tests ExceptionalShoppingCart.testSaveCartSummary() for proper handling of exceptions when 
   * passed a cart size less than zero
   * 
   * @return true if no test fails, false if otherwise
   */
  public static boolean testSaveCartSummary() {
    File f = new File("cartSummary");
    String[] cart = new String[] {"Apple", "Apple", "Milk", "", "Chocolate", "Pizza", "Pizza", 
        "Pizza", "Unknown", "Grape"};
    try {
      ExceptionalShoppingCart.saveCartSummary(cart, -1, f);
      System.out.println("saveCartSummary failed to throw an IllegalArgumentException when "
          + "passed a size less than 0");
      return false;
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
  return true;
  }
  /**
   * Tests ExceptionalShoppingcart.testLoadCartSummary() for proper handling of exceptions when
   * passed a cart with negative size and a cart that goes over capacity
   * 
   * @return true if no tests fail, false if otherwise
   */
  public static boolean testLoadCartSummary() {
    File f = new File("cartSummary2");
    String[] cart = new String[] {null, null, null, null, null, null, 
        null, null, null, null};
    
    try {
      ExceptionalShoppingCart.loadCartSummary(f, cart, -1);
      System.out.println("loadCartSummary failed to throw an IllegalArgumentException when "
          + "passed a size less than zero");
      return false;
    } catch (IllegalArgumentException e) {
        System.out.println(e);
    }
    
    try {
      ExceptionalShoppingCart.loadCartSummary(f, cart, 9);
      System.out.println("loadCartSummary failed to throw an IllegalStateException when "
          + "passed cart reached capacity");
      return false;
    } catch (IllegalStateException e) {
        System.out.println(e);
    }
    
    return true;
  }
  /**
   * This method tests runs all test methods
   * 
   * @return true if every single test in this tester class passes, false if a single test fails
   */
  public static boolean runAllTests() {
    if (testLookupMethods() && testAddItemToMarketCatalog() && testGetProductPrice()
        && testSaveCartSummary() && testLoadCartSummary()) {
      return true;
    }
    return false;
  }
}
