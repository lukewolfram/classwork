//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Shopping Cart
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
 * 
 * This class makes a customizable shopping cart, calculates its cost, 
 * and makes a summary of the cart
 * 
 */
public class ShoppingCart {
  private static final double TAX_RATE = 0.05; // sales tax
  
    //MarketItems: a perfect-size two-dimensional array that stores the list of
    //available items in a given market
    //MarketItems[i][0] refers to a String representation of the item identifiers
    //MarketItems[i][1] refers the item name. Item names are also unique
    //MarketItems[i][2] a String representation of the unit price
    //of the item in dollars
  private static String[][] marketItems = new String[][] {{"4390", "Apple", "$1.59"},
    {"4046", "Avocado", "$0.59"}, {"4011", "Banana", "$0.49"},
    {"4500", "Beef", "$3.79"}, {"4033", "Blueberry", "$6.89"},
    {"4129", "Broccoli", "$1.79"}, {"4131", "Butter", "$4.59"},
    {"4017", "Carrot", "$1.19"}, {"3240", "Cereal", "$3.69"},
    {"3560", "Cheese", "$3.49"}, {"3294", "Chicken", "$5.09"},
    {"4071", "Chocolate", "$3.19"}, {"4363", "Cookie", "$9.5"},
    {"4232", "Cucumber", "$0.79"}, {"3033", "Eggs", "$3.09"},
    {"4770", "Grape", "$2.29"}, {"3553", "Ice Cream", "$5.39"},
    {"3117", "Milk", "$2.09"}, {"3437", "Mushroom", "$1.79"},
    {"4663", "Onion", "$0.79"}, {"4030", "Pepper", "$1.99"},
    {"3890", "Pizza", "$11.5"}, {"4139", "Potato", "$0.69"},
    {"3044", "Spinach", "$3.09"}, {"4688", "Tomato", "$1.79"},
    null, null, null, null};
    
   /**
    * Searches for a product by name.
    * 
    * @param name - the name of the product to search for
    * @return Returns a string representation (id, name, price) of the item whose
    * name is provided as input if a match was found.  Returns "No match found" if 
    * item is null or not found.
    */
   public static String lookupProductByName(String name) {
     if (name == null) {
       return "No match found";
     }
     
     String stringToReturn = "";
     
     for (int i = 0; i < marketItems.length; i++) {
       if (name.equals(marketItems[i][1])) {
         return (marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2]);
       }
       else if (marketItems[i + 1] == null) {
         return "No match found";
       }
     }
     return stringToReturn; // default statement added to allow this code to compile
   }
   
   /**
    * Searches for a product by identifier.
    * 
    * @param id - the identifier of the item to search for
    * @return Returns a string representation (id, name, price) of the item whose identifier
    * is provided as input if a match was found.  Returns "No match found" if item
    * is null or not found.
    */
   // Returns a string representation of the item whose id is
   // provided as input if a match was found.
   // The format of the returned string is presented above
   // id - the identifier of the product or item to search
   public static String lookupProductById(int id) {
     String stringToReturn = "";
     
     for (int i = 0; i < marketItems.length; i++) {
       if (id == Integer.parseInt(marketItems[i][0])) {
         return (marketItems[i][0] + " " + marketItems[i][1] + " " + marketItems[i][2]);
       }
       else if (marketItems[i + 1] == null) {
         return "No match found";
       }
     }
     return stringToReturn;
   }
   // given its name. If no match was found in the market catalog, this
   // method returns -1.0
   // name - the name of the product to check its price

   /**
    * Searches for the price of a product by name.
    * 
    * @param name - the name of the product to search for
    * @return Returns a double of the price of the market item.
    * Returns -1.0 if item is null or not found.
    */
   public static double getProductPrice(String name) {
     if (name == null) {
       return -1.0;
     }
     
     double doubleToReturn = 0.0;
     
     for (int i = 0; i < marketItems.length; i++) {
       if (name.equals(marketItems[i][1])) {
         return (Double.parseDouble((marketItems[i][2]).substring(1)));
       }
       else if (marketItems[i + 1] == null) {
         return -1.0;
       }
     }
     return doubleToReturn; // default statement added to allow this code to compile
   }
   
   /**
    * Copies the private market items into a public array.
    * 
    * @return 2D string array deep copy of the marketItems array
    */
   // Returns a deep copy of the marketItems array
   public static String[][] getCopyOfMarketItems() {
     String[][] arrayToReturn = new String[marketItems.length][marketItems[0].length];
     for (int row = 0; row < marketItems.length; row++) {
       if (marketItems[row] == null) {
         arrayToReturn[row] = null;
       }
       else {
         for (int col = 0; col < marketItems[0].length; col++) {
           arrayToReturn[row][col] = marketItems[row][col];
         }
       }
     }
     
//  Prints copied array
//     for (int row = 0; row < marketItems.length; row++) {
//       System.out.print("row " + row + " ");
//       if (arrayToReturn[row] == null) {
//         System.out.println(arrayToReturn[row]);
//         continue;
//       }
//       else {
//         for (int col = 0; col < marketItems[0].length; col++) {
//           System.out.print(" " + col + " " + arrayToReturn[row][col]);
//         }
//         System.out.println();
//       }
//     }
     
//  Prints every element to manually see what has and hasn't been successfully copied
//     for (int row = 0; row < marketItems.length; row++) {
//       if (marketItems[row] == null && (arrayToReturn[row] == marketItems[row])) {
//         System.out.println("row " + row + " same null ");
//         continue;
//       }
//       else if (marketItems[row] == null && arrayToReturn[row] != marketItems[row]) {
//         System.out.println("row " + row + " diff null ");
//         continue;
//       }
//       for (int col = 0; col < marketItems[0].length; col++) {
//         if (marketItems[row][col] == arrayToReturn[row][col]) {
//           System.out.print("column " + col + " same ");
//         }
//         else {
//           System.out.print("column " + col + " diff ");
//         }
//       }
//       System.out.println();
//     }
   return arrayToReturn;
   }
  
   /**
   * Adds an item to a cart if there is space.
   * 
   * @param item - the item to be added
   * @param cart - array of products to be searched through
   * @param size - amount of non-null items in cart
   * @return Returns int size + 1 if the item was successfully added.
   * Returns size if item was not added.
   */
  // Appends an item to a given cart (appends means adding to the end).
  // If the cart is already full (meaning its size equals its length),
  // the item will not be added to the cart.
  // item - the name of the product to be added to the cart
  // cart - an array of strings which contains the names of items in the cart
  // size - the number of items in the cart
  // Returns the size of the oversize array cart after trying to add item
  // to the cart. This method returns the same of size without making
  // any change to the contents of the array if it is full.
  public static int addItemToCart(String item, String[] cart, int size) {
    if (size < cart.length) {
      cart[size] = item;
      size++;
    }
    return size;
  }
  
  /**
   * Counts how many times an item occurs in a cart.
   * 
   * @param item - the item whose occurrences are to be searched for.
   * @param cart - array of products to be searched through
   * @param size - amount of non-null items in cart.
   * @return Returns an int of how many times the item occurs in the cart.
   */
  // Returns the number of occurrences of a given item within a cart. This
  // method must not make any changes to the contents of the cart.
  // item - the name of the item to search
  // cart - an array of strings which contains the names of items in the cart
  // size - the number of items in the cart
  // Returns the number of occurrences of item (exact match) within the oversize
  // array cart. Zero or more occurrences of item can be present in the cart.
  public static int nbOccurrences(String item, String[] cart, int size) {
    int intToReturn = 0;
    for (int i = 0; i < cart.length; i++) {
      if (item.equals(cart[i])) {
        cart[i] = item;
        intToReturn++;
      }
    }
    return intToReturn;
  }
  
  /**
   * Determines if a cart contains an item
   * 
   * @param item - the item whose presence is to be searched for
   * @param cart - array of products to be searched through
   * @param size - amount of non-null items in cart.
   * @return Returns true if the cart contains it, false if not found.
   */
  // Checks whether a cart contains at least one occurrence of a given item.
  // This method must not make any changes to the contents of the cart.
  // item - the name of the item to search
  // cart - an array of strings which contains the names of items in the cart
  // size - the number of items in the cart
  // Returns true if there is a match (exact match) of item within the
  // provided cart, and false otherwise.
  public static boolean contains(String item, String[] cart, int size) {
    boolean booleanToReturn = false;
    for (int i = 0; i < cart.length; i++) {
      if (item.equals(cart[i])) {
        booleanToReturn = true;
      }
    }
    return booleanToReturn;
  }
  
  /**
   * Calculates total price of items with tax
   * 
   * @param cart - array of products whose prices are to be added up
   * @param size - amount of non-null items in cart
   * @return Returns a double of the total price with sales tax.
   */
  // This method returns the total value in dollars of the cart. All
  // products in the market are taxable (subject to TAX_RATE).
  // cart - an array of strings which contains the names of items in the cart
  // size - the number of items in the cart
  // Returns the total value in dollars of the cart accounting taxes.
  public static double checkout(String[] cart, int size) {
    double doubleToReturn = 0.0;
    
    for (int i = 0; i < size; i++) {
      doubleToReturn += getProductPrice(cart[i]);
    }
    doubleToReturn = Math.round((doubleToReturn * (1 + TAX_RATE)) * 100.0) / 100.0;
    return doubleToReturn;
  }
  
  /**
   * Removes an item from a cart
   * 
   * @param cart - array of products to be searched through and altered
   * @param item - element to delete from cart
   * @param size - amount of non-null items in cart
   * @return Returns size-1 if removal was successful.
   * Returns size if removal was unsuccessful.
   */
  // Removes one occurrence of item from a given cart. If no match with item
  // was found in the cart, the method returns the same value of input size
  // without making any change to the contents of the array.
  // item - the name of the item to remove
  // cart - an array of strings which contains the names of items in the cart
  // size - the number of items in the cart
  // Returns the size of the oversize array cart after trying to remove item
  // from the cart.
  public static int removeItem(String[] cart, String item, int size) {
    if (size > 0) {
      for (int i = 0; i < size; i++) {
        if (item.equals(cart[i])) {
          for (int j = i + 1; j < size; j++) {
            cart[i] = cart[j];
            i++;
          }
        cart[size - 1] = null;
        size--;
        return size;
        }
      }
    }
    return size;
  }
  
  /**
   * Makes every item in the cart null
   * 
   * @param cart - array to be emptied
   * @param size - amount of non-null items in cart
   * @return Returns 0 if cart was successfully emptied.
   * Returns a non zero in if cart was not successfully emptied.
   */
  // Removes all items from a given cart. The array cart must be empty (contains
  // only null references) after this method returns.
  // cart - an array of strings which contains the names of items in the cart
  // size - the number of items in the cart
  // Returns the size of the cart after removing all its items.
  public static int emptyCart(String[] cart, int size) {
    if (size > 0) {
      for (int i = size - 1; size > 0; i--) {
        cart[i] = null;
        size--;
      }
    }
    return size;
  }
  
  /**
   * Finds and lists occurrences of every item in the cart
   * 
   * @param cart - array of products to be read
   * @param size - amount of non-null items in cart
   * @return Returns a string of occurrences of an item, with each unique item 
   * only being printed once, preceded by its occurrences
   * Example: (#occurrences) item1
   *          (#occurrences) item2
   *          etc...
   */
  // Returns a string representation of the summary of the contents of a given cart.
  // The format of the returned string contains a set of lines where each line contains
  // the number of occurrences of a given item, between parentheses, followed by
  // one space followed by the name of a unique item in the cart.
  // (#occurrences) name1
  // (#occurrences) name2
  // etc.
  // Further details about the format of the returned string is provided
  // in the next section.
  // cart - an array of strings which contains the names of items in the cart
  // size - the number of items in the cart
  // Returns a string representation of the summary of the contents of the cart
  public static String getCartSummary(String[] cart, int size) {
    String stringToReturn = "Cart is empty";
    String duplicateProducts = ""; // a string that will be appended once with each unique product
                                   // as to not repeat products in the return string.
    int productAmount = 0;
    
    if (size > 0) {
      stringToReturn = "";
      for (int j = 0; j < size; j++) {
        productAmount = 0;
         for (int k = j; k < size; k++) {
           if ((cart[j].equals(cart[k])) && !duplicateProducts.contains((cart[j]))) {
             productAmount++;
           }
         }
         duplicateProducts = duplicateProducts.concat(cart[j].toString());
         if (productAmount > 0) {
           stringToReturn = stringToReturn.concat("(" + productAmount + ") " + (cart[j] + "\n"));
         }
      }
    }
    return stringToReturn;
  } 
}