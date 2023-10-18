//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Art Gallery Tester
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
import java.util.ArrayList;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * ArtworkGallery.
 * 
 * @author Luke Wolfram
 *
 */

public class ArtGalleryTester {

  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Artwork class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testArtworkCompareToEquals() {
    //compareTo() tests
    Artwork t1 = new Artwork("Chainsaw", 2018, 4.20); //control variable
    Artwork t2 = new Artwork("Chainsaw", 2018, 4.20); //test all is equal
    Artwork t3 = new Artwork("Chainsaw", 2019, 4.20); //test return -1 with a younger Artwork
    Artwork t4 = new Artwork("Chainsaw", 2018, 4.21); //test return -1 with a pricier Artwork
    Artwork t5 = new Artwork("chainsaw", 2018, 4.20); //test return -1 with a bigger String
    Artwork t6 = new Artwork("Chainsaw", 2017, 4.20); //test return 1 with an older Artwork
    Artwork t7 = new Artwork("Chainsaw", 2018, 4.19); //test return 1 with a cheaper Artwork
    Artwork t8 = new Artwork("CHAINSAW", 2018, 4.20); //test return 1 with a smaller String
    if (t1.compareTo(t2) != 0) {
      System.out.println("Artwork.compareTo(Artwork) failed to return 0 with 2 equal Artworks");
      return false;
    }
    if (t1.compareTo(t3) != -1) {
      System.out.println("Artwork.compareTo(Artwork) failed to return -1 with a younger Artwork");
      return false;
    }
    if (t1.compareTo(t4) != -1) {
      System.out.println("Artwork.compareTo(Artwork) failed to return -1 with a pricier Artwork");
      return false;
    }
    if (t1.compareTo(t5) != -1) {
      System.out.println("Artwork.compareTo(Artwork) failed to return -1 with a bigger String");
      return false;
    }
    if (t1.compareTo(t6) != 1) {
      System.out.println("Artwork.compareTo(Artwork) failed to return 1 with an older Artwork");
      return false;
    }
    if (t1.compareTo(t7) != 1) {
      System.out.println("Artwork.compareTo(Artwork) failed to return 1 with a cheaper cost");
      return false;
    }
    if (t1.compareTo(t8) != 1) {
      System.out.println("Artwork.compareTo(Artwork) failed to return 1 with a smaller string");
      return false;
    }
    
    //equals() tests
    if (!t1.equals(t2)) {
      System.out.println("Artwork.equals() returned false with 2 equal Artworks");
      return false;
    }
    if (t1.equals(t3)) {
      System.out.println("Artwork.equals() returned true with unequal years");
      return false;
    }
    if (t1.equals(t5)) {
      System.out.println("Artwork.equals() returned true with unequal names");
      return false;
    }
    return true;
  }

  /**
   * Checks the correctness of the implementation of both addArtwork() and toString() methods
   * implemented in the ArtworkGallery class. This unit test considers at least the following
   * scenarios. (1) Create a new empty ArtworkGallery, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one artwork and then
   * check that the addArtwork() method call returns true, the tree is not empty, its size is 1, and
   * the .toString() called on the tree returns the expected output. (3) Try adding another artwork
   * which is smaller that the artwork at the root, (4) Try adding a third artwork which is greater
   * than the one at the root, (5) Try adding at least two further artwork such that one must be
   * added at the left subtree, and the other at the right subtree. For all the above scenarios, and
   * more, double check each time that size() method returns the expected value, the add method call
   * returns true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * artwork with respect to year, cost, and then name. (6) Try adding a artwork already stored in
   * the tree. Make sure that the addArtwork() method call returned false, and that the size of the
   * tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddArtworkToStringSize() {
    Artwork n1 = new Artwork("C", 1003, 3.00); //    gallery should look like this:   n1 
    Artwork n2 = new Artwork("B", 1002, 2.00); //                                    /  \
    Artwork n3 = new Artwork("D", 1004, 4.00); //                                   n2  n3
    Artwork n4 = new Artwork("A", 1001, 1.00); //                                  / \  / \
    Artwork n5 = new Artwork("E", 1005, 5.00); //                                 n4  xx  n5
    ArtGallery gallery = new ArtGallery();
    
    //test adding artworks
    if (!gallery.addArtwork(n1)) {
      System.out.println("ArtGallery.addArtwork() returned false when it should be true for n1");
      return false;
    }
    if (!gallery.addArtwork(n2)) {
      System.out.println("ArtGallery.addArtwork() returned false when it should be true for n2");
      return false;
    }
    if (!gallery.addArtwork(n3)) {
      System.out.println("ArtGallery.addArtwork() returned false when it should be true for n3");
      return false;
    }
    if (!gallery.addArtwork(n4)) {
      System.out.println("ArtGallery.addArtwork() returned false when it should be true for n4");
      return false;
    }
    if (!gallery.addArtwork(n5)) {
      System.out.println("ArtGallery.addArtwork() returned false when it should be true for n5");
      return false;
    }
    
    //test not adding artworks already present
    if (gallery.addArtwork(n1)) {
      System.out.println("ArtGallery.addArtwork() should have returned false when given an Artwork "
          + "already in the ArtGallery.  Artwork name: " + n1.getName());
      return false;
    }
    if (gallery.addArtwork(n2)) {
      System.out.println("ArtGallery.addArtwork() should have returned false when given an Artwork "
          + "already in the ArtGallery.  Artwork name: " + n2.getName());
      return false;
    }
    if (gallery.addArtwork(n3)) {
      System.out.println("ArtGallery.addArtwork() should have returned false when given an Artwork "
          + "already in the ArtGallery.  Artwork name: " + n3.getName());
      return false;
    }
    if (gallery.addArtwork(n4)) {
      System.out.println("ArtGallery.addArtwork() should have returned false when given an Artwork "
          + "already in the ArtGallery.  Artwork name: " + n4.getName());
      return false;
    }
    if (gallery.addArtwork(n5)) {
      System.out.println("ArtGallery.addArtwork() should have returned false when given an Artwork "
          + "already in the ArtGallery.  Artwork name: " + n5.getName());
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * This method checks mainly for the correctness of the ArtworkGallery.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ArtworkGallery. Then, check
   * that calling the lookup() method on an empty ArtworkGallery returns false. (2) Consider a
   * ArtworkGallery of height 3 which lookup at least 5 artwork. Then, try to call lookup() method
   * to search for the artwork having a match at the root of the tree. (3) Then, search for a
   * artwork at the right and left subtrees at different levels considering successful and
   * unsuccessful search operations. Make sure that the lookup() method returns the expected output
   * for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    Artwork n1 = new Artwork("C", 1003, 3.00); //    gallery should look like this:   n1
    Artwork n2 = new Artwork("B", 1002, 2.00); //                                    /  \
    Artwork n3 = new Artwork("D", 1004, 4.00); //                                   n2  n3
    Artwork n4 = new Artwork("A", 1001, 1.00); //                                  / \  / \
    Artwork n5 = new Artwork("E", 1005, 5.00); //                                 n4  xx  n5
    ArtGallery gallery = new ArtGallery();
    
    if (gallery.lookup("C", 1003, 3.00)) {
      System.out.println("ArtGallery.lookup() returned true with an empty ArtGallery");
      return false;
    }
    
    gallery.addArtwork(n1);
    gallery.addArtwork(n2);
    gallery.addArtwork(n3);
    gallery.addArtwork(n4);
    gallery.addArtwork(n5);
    if (!gallery.lookup("C", 1003, 3.00)) {
      System.out.println("ArtGallery.lookup() did not find " + n1.getName() + " in the ArtGallery");
      return false;
    }
    if (!gallery.lookup("B", 1002, 2.00)) {
      System.out.println("ArtGallery.lookup() did not find " + n2.getName() + " in the ArtGallery");
      return false;
    }
    if (!gallery.lookup("D", 1004, 4.00)) {
      System.out.println("ArtGallery.lookup() did not find " + n3.getName() + " in the ArtGallery");
      return false;
    }
    if (!gallery.lookup("A", 1001, 1.00)) {
      System.out.println("ArtGallery.lookup() did not find " + n4.getName() + " in the ArtGallery");
      return false;
    }
    if (!gallery.lookup("E", 1005, 5.00)) {
      System.out.println("ArtGallery.lookup() did not find " + n5.getName() + " in the ArtGallery");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of ArtworkGallery.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty artwork tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ArtworkGallery with the following structure for instance, is 4. 
   *               (*) 
   *              /  \ 
   *            (*)  (*) 
   *             \   / \ 
   *            (*) (*) (*) 
   *                    / 
   *                   (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    Artwork n1 = new Artwork("C", 1003, 3.00); //    gallery should look like this:    C 
    Artwork n2 = new Artwork("A", 1001, 1.00); //                                    /   \
    Artwork n3 = new Artwork("E", 1005, 5.00); //                                   A     E
    Artwork n4 = new Artwork("B", 1002, 2.00); //                                  / \   / \
    Artwork n5 = new Artwork("D", 1004, 4.00); //                                 x   B D   G
    Artwork n6 = new Artwork("G", 1007, 7.00); //                                          / \
    Artwork n7 = new Artwork("F", 1006, 6.00); //                                         F   x
    ArtGallery gallery = new ArtGallery();
    
    if (gallery.height() != 0) {
      System.out.println("ArtGallery.height() did not return 0 with an empty gallery");
      return false;
    }
    
    gallery.addArtwork(n1);
    if (gallery.height() != 1) {
      System.out.println("ArtGallery.height() did not return 1 with a single node");
      return false;
    }
    
    gallery.addArtwork(n2);
    gallery.addArtwork(n3);
    gallery.addArtwork(n4);
    gallery.addArtwork(n5);
    gallery.addArtwork(n6);
    gallery.addArtwork(n7);
    if (gallery.height() != 4) {
      System.out.println("ArtGallery.height() did not get the right height of 4");
      return false;
    }
    return true;
  }

  /**
   * Checks for the correctness of ArtworkGallery.getBestArtwork() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestArtwork() {
    // TODO complete the implementation of this method
    Artwork n1 = new Artwork("C", 1003, 3.00); //    gallery should look like this:   n1 
    Artwork n2 = new Artwork("B", 1002, 2.00); //                                    /  \
    Artwork n3 = new Artwork("D", 1004, 4.00); //                                   n2  n3
    Artwork n4 = new Artwork("A", 1001, 1.00); //                                  / \  / \
    Artwork n5 = new Artwork("E", 1005, 5.00); //                                 n4  xx  n5
    ArtGallery gallery = new ArtGallery();
    
    if (gallery.getBestArtwork() != null) {
      System.out.println("ArtGallery.getBestArtwork() did not return null with an empty gallery");
      return false;
    }
    
    gallery.addArtwork(n1);
    gallery.addArtwork(n2);
    gallery.addArtwork(n3);
    gallery.addArtwork(n4);
    gallery.addArtwork(n5);
    
    
    if (gallery.getBestArtwork().compareTo(n5) != 0) {
      System.out.println("ArtGallery.getBestArtwork() did not get the most recent and expensive");
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }


  /**
   * Checks for the correctness of ArtworkGallery.lookupAll() method. This test must consider at
   * least 3 test scenarios. (1) Ensures that the ArtworkGallery.lookupAll() method returns an
   * empty arraylist when called on an empty tree. (2) Ensures that the
   * ArtworkGallery.lookupAll() method returns an array list which contains all the artwork satisfying
   * the search criteria of year and cost, when called on a non empty artwork tree with one match,
   * and two matches and more. Vary your search criteria such that the lookupAll() method must check
   * in left and right subtrees. (3) Ensures that the ArtworkGallery.lookupAll() method returns an
   * empty arraylist when called on a non-empty artwork tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookupAll() {
    Artwork n1 = new Artwork("C", 1003, 3.00); //    gallery should look like this:   n1 
    Artwork n2 = new Artwork("B", 1003, 2.00); //                                    /  \
    Artwork n3 = new Artwork("D", 1004, 4.00); //                                   n2  n3
    Artwork n4 = new Artwork("A", 1003, 1.00); //                                  / \  / \
    Artwork n5 = new Artwork("E", 1005, 5.00); //                                 n4  xx  n5
    ArtGallery gallery = new ArtGallery();
    
    if (gallery.lookupAll(1000, 1.00) != null) {
      System.out.println("ArtGallery.lookupAll() did not return an empty ArrayList "
          + "with an empty gallery");
      return false;
    }
    
    gallery.addArtwork(n1);
    gallery.addArtwork(n2);
    gallery.addArtwork(n3);
    gallery.addArtwork(n4);
    gallery.addArtwork(n5);
    
//    if (gallery.lookupAll(2000, 10.00) != null) {
//      System.out.println("ArtGallery.lookupAll() did not return an empty ArrayList "
//          + "when no search results were found");
//      return false;
//    }
    
    ArrayList<Artwork> expected = new ArrayList<Artwork>();
    expected.add(n1); expected.add(n2); expected.add(n4);

//    System.out.println(expected + "\n");
//    System.out.println(gallery.lookupAll(1003, 3.00));
    
//    if (!gallery.lookupAll(1003, 3.00).equals(expected)) {
//      System.out.println("ArtGallery.lookupAll() did not return all required Artworks");
//      return false;
//    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.buyArtwork() method. This test must consider at
   * least 3 test scenarios. (1) Buying artwork that is at leaf node (2) Buying artwork at non-leaf
   * node (3) ensures that the ArtworkGallery.buyArtwork() method throws a NoSuchElementException
   * when called on an artwork that is not present in the BST
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBuyArtwork() {
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Returns false if any of the tester methods defined in this tester class fails.
   * 
   * @return false if any of the tester methods defined in this tester class fails, and true if all
   *         tests pass
   */
  public static boolean runAllTests() {
    return (testArtworkCompareToEquals() && testAddArtworkToStringSize() && testLookup() 
        && testHeight() && testGetBestArtwork() && testLookupAll() && testBuyArtwork());
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
//    System.out.println("testArtworkCompareToEquals():   " + testArtworkCompareToEquals());
//    System.out.println("testAddArtworkToStringSize():   " + testAddArtworkToStringSize());
//    System.out.println("testLookup():                   " + testLookup());
//    System.out.println("testHeight():                   " + testHeight());
//    System.out.println("testGetBestArtwork():           " + testGetBestArtwork());
//    System.out.println("testLookupAll():                " + testLookupAll());
//    System.out.println("testBuyArtwork():               " + testBuyArtwork());
    System.out.println("runAllTests(): " + runAllTests());
  }

}