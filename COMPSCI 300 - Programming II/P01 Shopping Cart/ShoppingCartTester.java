//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Shopping Cart Tester
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
 * Tests methods in the ShoppingCart class
 */
public class ShoppingCartTester {

  /**
  * Prints the results of the tests 
  * @param args input arguments if any
  */
  public static void main(String[] args) {
//  System.out.println(ShoppingCart.getCopyOfMarketItems());
    System.out.println("testLookupMethods(): " + testLookupMethods());
    System.out.println("testGetProductPrice(): " + testGetProductPrice());
    System.out.println("testAddItemToCartContainsNbOccurrences(): " 
        + testAddItemToCartContainsNbOccurrences());
    System.out.println("testRemoveItem(): " + testRemoveItem());
    System.out.println("testCheckoutGetCartSummary(): " + testCheckoutGetCartSummary());
    System.out.println("runAllTests(): " + runAllTests());
  }
  
  /**
  * Checks whether ShoppingCart.lookupProductByName() and
  * ShoppingCart.lookupProductById() methods work as expected.
  * @return true when this test verifies a correct functionality,
  * and false otherwise
  */
  public static boolean testLookupMethods() {
    // Test 1, verifies the output with the first name in the market
    String expectedOutput = "4390 Apple $1.59";
    if(!ShoppingCart.lookupProductByName("Apple").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Apple as input");
      return false;
    }
    
    // Test 2, verifies the output with the first id in the market
    if(!ShoppingCart.lookupProductById(4390).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id "
          + "of Apple as input");
      return false;
    }
    
    // Test 3, verifies the output with the last name in the market
    expectedOutput = "4688 Tomato $1.79";
    if(!ShoppingCart.lookupProductByName("Tomato").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed the name of "
          + "the last non-null product found in the market.");
      return false;
    }
    
    // Test 4, verifies the output with the last identifier in the market
    if(!ShoppingCart.lookupProductById(4688).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the identifier of "
          + "of the last non-null product found in the market.");
      return false;
    }
    
    // Test 5, verifies the output with a name in the middle of the market
    expectedOutput = "3033 Eggs $3.09";
    if(!ShoppingCart.lookupProductByName("Eggs").equals(expectedOutput)) {
      System.out.println(ShoppingCart.lookupProductByName("Eggs"));
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed the name of "
          + "a product found in the middle of the market.");
      return false;
    }
    
    // Test 6, verifies the output with an identifier in the middle of the market
    if(!ShoppingCart.lookupProductById(3033).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the identifier of "
          + "a product found in the middle of the market.");
      return false;
    }
    
    // Test 7, verifies the output with a name not found in the market
    expectedOutput = "No match found";
    if(!ShoppingCart.lookupProductByName("NOT FOUND").equals(expectedOutput)) {
      System.out.println(ShoppingCart.lookupProductByName("NOT FOUND") + " hi");
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed the name of "
        + "a product not found in the market.");
      return false;
    }
    
    // Test 8, verifies the output with a null name
    if(!ShoppingCart.lookupProductByName(null).equals(expectedOutput)) {
      System.out.println(ShoppingCart.lookupProductByName(null));
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed null");
      return false;
    }
    
    // Test 9, verifies the output with an identifier not found in the market
    if(!ShoppingCart.lookupProductById(1000).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the identifier "
          + "of a product not found in the market.");
      return false;
    }
  return true; //Successfully passed all tests
  }

  /**
  * Checks the correctness of ShoppingCart.getProductPrice() method
  * @return true when this test verifies a correct functionality,
  * and false otherwise
  */
  public static boolean testGetProductPrice() {
    // Test 1, verifies the output with the price of an apple
    double expectedPrice = 1.59;
    if(Math.abs(ShoppingCart.getProductPrice("Apple") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method " 
          + "failed to return the expected output when passed Apple as input");
      return false;
    }
    
    // Test 2, verifies the output with the price of the last product in the market
    expectedPrice = 1.79;
    if(Math.abs(ShoppingCart.getProductPrice("Tomato") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method " 
          + "failed to return the expected output when passed the name of "
          + "the last product in the market.");
      return false;
    }
    
    // Test 3, verifies the output with the price of an item not found in the market
    expectedPrice = -1.0;
    if(Math.abs(ShoppingCart.getProductPrice("NOT FOUND") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method " 
          + "failed to return the expected output when passed the name of "
          + "a product not found in the market.");
      return false;
    }
    
    // Test 4, verifies the output with a null name
    if(Math.abs(ShoppingCart.getProductPrice(null) - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method " 
          + "failed to return the expected output when passed the name of "
          + "a product not found in the market.");
      return false;
    }
    return true; //Successfully passed all tests
  }
  
  /**
   * Returns true if the addItemToCart(), contains(), and nbOccurrences() 
   * methods are properly working.  False if not.
   */
  public static boolean testAddItemToCartContainsNbOccurrences() {
    // Test 1, verifies the output with an empty cart that will have one item added to it
    String[] emptyCart = new String[10];
    String[] bananaCart = new String[]{"Banana", null, null, null, null, //expected cart contents
        null, null, null, null, null};
    String item = "Banana";
    int expectedSize = 1;
    int expectedOccurrences = 1;
    boolean expectedContainsOutput = true;
    
    if(ShoppingCart.addItemToCart(item, emptyCart, 0) != expectedSize) {
      System.out.println("Problem detected: Your addItemToCart() method " 
          + "failed to return the expected output when passed a product in the market "
          + "and did ");
      return false;
    }
    else if(ShoppingCart.nbOccurrences(item, bananaCart, expectedSize) != expectedOccurrences) {
      System.out.println("Problem detected: Your nbOccurrences() method " 
          + "failed to return the expected output when passed a product in the cart "
          + "and did not output the correct number of its occurrences in the cart.");
      return false;
    }
    else if(ShoppingCart.contains(item, bananaCart, expectedSize) != expectedContainsOutput) {
      System.out.println("Problem detected: Your contains() method " 
          + "failed to return the expected output when passed a product in the cart "
          + "and did not output the correct state of its presence in the cart.");
      return false;
    }
    
    // Test 2, verifies the output with a full cart
    String[] fullCart = {"Milk", "Apple", "Banana", "Pizza"};
    item = "Eggs";
    expectedSize = 4;
    expectedOccurrences = 0;
    expectedContainsOutput = false;
    
    if(ShoppingCart.addItemToCart(item, fullCart, 4) != expectedSize) {
      System.out.println("Problem detected: Your addItemToCart() method " 
          + "failed to return the expected output when passed a product in the market "
          + "and did not correctly add nor correctly output the size of the cart.");
      return false;
    }
    else if(ShoppingCart.nbOccurrences(item, fullCart, 4) != expectedOccurrences) {
      System.out.println("Problem detected: Your nbOccurrences() method " 
          + "failed to return the expected output when passed a product in the cart "
          + "and did not output the correct number of its occurrences in the cart.");
      return false;
    }
    else if(ShoppingCart.contains(item, fullCart, 4) != expectedContainsOutput) {
      System.out.println("Problem detected: Your contains() method " 
          + "failed to return the expected output when passed a product in the cart "
          + "and did not output the correct state of its presence in the cart.");
      return false;
    }
    
    // Test 3, verifies the output with a non empty cart
    String[] nonEmptyCart = new String[]{"Milk", "Apple", "Banana", "Pizza",
    null, null};
    String[] expectedNonEmptyCart = new String[]{"Milk", "Apple", "Banana", 
        "Pizza", "Eggs", null};
    expectedSize = 5; // 4 items are stored in the cart
    expectedOccurrences = 1;
    expectedContainsOutput = true;
    
    if(ShoppingCart.addItemToCart(item, nonEmptyCart, 4) != expectedSize) {
      System.out.println("Problem detected: Your addItemToCart() method " 
          + "failed to return the expected output when passed a product in the market "
          + "and did not correctly add nor correctly output the size of the cart.");
      return false;
    }
    else if(ShoppingCart.nbOccurrences(item, expectedNonEmptyCart, expectedSize) != 
        expectedOccurrences) {
      System.out.println("Problem detected: Your nbOccurrences() method " 
          + "failed to return the expected output when passed a product in the cart "
          + "and did not output the correct number of its occurrences in the cart.");
      return false;
    }
    else if(ShoppingCart.contains(item, expectedNonEmptyCart, expectedSize) != 
        expectedContainsOutput) {
      System.out.println("Problem detected: Your contains() method " 
          + "failed to return the expected output when passed a product in the cart "
          + "and did not output the correct state of its presence in the cart.");
      return false;
    }
    return true; //Successfully passed all tests
  }
  
  /**
   * Returns true if the removeItem() method and emptyCart() method are
   * properly working
   */
  public static boolean testRemoveItem() {
    // Test 1, verifies the output with an empty cart
    String[] emptyCart = new String[5];
    String item = "Apple";
    int size = 0;
    int expectedOutput = 0;
    
    if(ShoppingCart.removeItem(emptyCart, item, size) != expectedOutput) {
      System.out.println("Problem detected: Your removeItem() method " 
          + "failed to return the expected output when passed the name of "
          + "a product not found in the cart.");
      return false;
    }
    if(ShoppingCart.emptyCart(emptyCart, size) != expectedOutput) {
      System.out.println("Problem detected: Your emptyCart() method " 
          + "failed to return the expected output when passed an empty cart.");
      return false;
    }
    
    // Test 2, verifies the output with an item not found in the cart
    String[] missingProductCart = new String[]{"Milk", "Apple", "Banana",
        "Pizza", "Milk", null, null};
    item = "Eggs";
    size = 5;
    expectedOutput = 5;
    
    if(ShoppingCart.removeItem(missingProductCart, item, size) != expectedOutput) {
      System.out.println("Problem detected: Your removeItem() method " 
          + "failed to return the expected output when passed the name of "
          + "a product found in the cart.");
      return false;
    }

    // Test 3, verifies the output with a non empty cart
    String[] nonEmptyCart = new String[]{"Milk", "Apple", "Banana", "Apple", "Pizza", null, null};
    item = "Apple";
    size = 5;
    expectedOutput = 4;
    
    if(ShoppingCart.removeItem(nonEmptyCart, item, size) != expectedOutput) {
      System.out.println("Problem detected: Your removeItem() method " 
          + "failed to return the expected output when passed the name of "
          + "a product found in the cart.");
      return false;
    }
    
    expectedOutput = 0;
    
    if(ShoppingCart.emptyCart(nonEmptyCart, size) != expectedOutput) {
      System.out.println("Problem detected: Your emptyCart() method " 
          + "failed to return the expected output when passed a non empty cart.");
      return false;
    }
    
    return true; //Successfully passed all tests
  }
  
  /**
   * Returns true if the checkout() and getCartSummary() methods
   * are properly working.  False if not.
   */
  public static boolean testCheckoutGetCartSummary() {
    // Test 1, verifies the output with an empty cart
    String[] emptyCart = new String[7];
    int size = 0;
    String expectedOutput = "Cart is empty";
    double expectedPrice = 0.0;
    
    if(!(ShoppingCart.getCartSummary(emptyCart, size).equals(expectedOutput))) {
      System.out.println("Problem detected: Your getCartSummary() method " 
          + "failed to return the expected output when passed  an empty cart.");
      return false;
    }
    
    if(Math.abs((ShoppingCart.checkout(emptyCart, size)) - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your checkout() method " 
          + "failed to return the expected output when passed  an empty cart.");
      return false;
    }
    
    // Test 2, verifies the output with a cart containing no duplicate items
    String[] uniqueCart = new String[]{"Milk", "Apple", "Banana", "Pizza", null, null};
    size = 4;
    expectedOutput = "(1) Milk\n(1) Apple\n(1) Banana\n(1) Pizza\n";
    if(!(ShoppingCart.getCartSummary(uniqueCart, size).equals(expectedOutput))) {
      System.out.println("Problem detected: Your getCartSummary() method " 
          + "failed to return the expected output when passed a cart containing "
          + "unique items.");
      return false;
    }
    expectedPrice = 16.45;
    if(Math.abs((ShoppingCart.checkout(uniqueCart, size)) - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your checkout() method " 
          + "failed to return the expected output when passed a cart containing "
          + "unique items.");
      return false;
    }
    
    // Test 3, verifies the output with a cart containing duplicate items
    String[] multipleCart = new String[] {"Tomato", "Milk", "Milk", "Eggs", "Tomato", 
        "Onion", "Eggs", "Milk", "Banana", null, null};
    size = 9;
    expectedOutput = "(2) Tomato\n(3) Milk\n(2) Eggs\n(1) Onion\n(1) Banana\n";
    if(!(ShoppingCart.getCartSummary(multipleCart, size).equals(expectedOutput))) {
      System.out.println("Problem detected: Your getCartSummary() method " 
          + "failed to return the expected output when passed a cart containing "
          + "multiple occurences of the same items.");
      return false;
    }
    
    expectedPrice = 18.18;
    if(Math.abs((ShoppingCart.checkout(multipleCart, size)) - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your checkout() method " 
          + "failed to return the expected output when passed a cart containing "
          + "multiple occurences of the same items.");
      return false;
    }
    return true; //Successfully passed all tests
  }
  
  /**
   * Returns true if every single test has been successfully passed
   * Returns false if a single test is failed
   */
  public static boolean runAllTests() {
    if (testLookupMethods() && testGetProductPrice() && testAddItemToCartContainsNbOccurrences()
        && testRemoveItem() && testCheckoutGetCartSummary()) {
          return true;
        }
    return false;
  }  
}