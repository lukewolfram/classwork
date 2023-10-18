//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    DNA Tester
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
 * Test methods to verify your implementation of the methods for P08.
 */
public class DNATester {
  /**
   * Tests the enqueue() and dequeue() methods
   * @return true iff the methods work correctly
   */
  public static boolean testEnqueueDequeue() {
    
    try {
      DNA t = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    } catch (NullPointerException e) {
      System.out.println("testEnqueueDequeue(): NPE thrown");
      return false;
    }
    
    try {
      DNA t = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
      t.DNA.dequeue();
    } catch (NullPointerException e) {
      System.out.println("testEnqueueDequeue(): NPE thrown");
      return false;
    }
    
    
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String DNAString = "GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG";
    
    if (!testDNA.DNA.toString().replaceAll(" ", "").equals(DNAString)) {
      System.out.println("testEnqueueDequeue(): enqueue() failed");
      return false;
    }
    
    for (int i = 0; i < DNAString.length(); i++) {
      if (!testDNA.DNA.dequeue().equals((Character)DNAString.charAt(i))) {
        System.out.println("testEnqueueDequeue(): dequeue failed");
        return false;
      }
    }

    try {
      DNA testDNA3 = new DNA("");
      testDNA3.DNA.dequeue();
      System.out.println("LinkedQueue.dequeue failed to throw a NoSuchElementException");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println("LinkedQueue.dequeue successfully threw a NoSuchElementException");
    }
    return true;
  }
  
  /**
   * Tests the size() and isEmpty() methods
   * @return true iff the methods work correctly
   */
  public static boolean testQueueSize() {
    try {
      DNA t = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
      t.DNA.size();
    } catch (NullPointerException e) {
      System.out.println("testEnqueueDequeue(): NPE thrown");
      return false;
    }
    try {
      DNA t = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
      t.DNA.isEmpty();
    } catch (NullPointerException e) {
      System.out.println("testEnqueueDequeue(): NPE thrown");
      return false;
    }
    try {
      DNA t = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
      t.DNA.peek();
    } catch (NullPointerException e) {
      System.out.println("testEnqueueDequeue(): NPE thrown");
      return false;
    }
    
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    if (testDNA.DNA.toString().replaceAll(" ", "").length() != 60) {
      System.out.println("LinkedQueue.size() failed");
      return false;
    }
    if (testDNA.DNA.size() != 60) {
      System.out.println("LinkedQueue.size() failed");
      return false;
    }
    if (testDNA.DNA.isEmpty()) {
      System.out.println("LinkedQueue.isEmpty() failed, queue reported empty when not");
      return false;
    }
    
    for (int i = 0; i < 60; i++) {
      testDNA.DNA.dequeue();
    }

    if (testDNA.DNA.size() != 0) {
      System.out.println("LinkedQueue.size() failed");
      return false;
    }
    if (!testDNA.DNA.isEmpty()) {
      System.out.println("LinkedQueue.isEmpty() failed, should be empty");
      return false;
    }
    try {
      testDNA.DNA.peek();
      System.out.println("LinkedQueue.peek() failed to throw a NoSuchElementException");
      return false;
    } catch (NoSuchElementException e) {
      System.out.println("LinkedQueue.peek() successfully threw a NoSuchElementException");
    }
    
    DNA testDNA2 = new DNA("");
    if (testDNA2.DNA.size() != 0) {
      System.out.println("LinkedQueue.size() failed");
      return false;
    }
    if (!testDNA2.DNA.isEmpty()) {
      System.out.println("LinkedQueue.isEmpty() failed, should be empty");
      return false;
    }
    return true;
  }
  
  /**
   * Tests the transcribeDNA() method
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String mRNA = "CCUCAGUCAAUUCGCUGGCCCUGUAUGACAGAACCAUUAGAGGCUCGAUCUUUCAGAGAC";
    if (!testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA)) {
      System.out.println("DNA.transcribeDNA() failed to produce the expected output");
      return false;
    }
    
    DNA testDNA2 = new DNA("CCGGCCCTCCGGTGGATCCAA");
    String mRNA2 = "GGCCGGGAGGCCACCUAGGUU";
    
    if (!testDNA2.transcribeDNA().toString().replaceAll(" ", "").equals(mRNA2)) {
      System.out.println("DNA.transcribeDNA() failed to produce the expected output");
      return false;
    }
    return true;
  }
  
  /**
   * Tests the translateDNA() method
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    if (!testDNA.translateDNA().toString().replaceAll(" ", "").equals("PQSIRWPCMTEPLEARSFRD")) {
      return false;
    }
    
    DNA testDNA2 = new DNA("CCGGCCCTCCGGTGGATCCAA");
    if (!testDNA2.translateDNA().toString().replaceAll(" ", "").equals("GREAT")) {
      return false;
    }
    
    DNA testDNA3 = new DNA("GGA");
    if (!testDNA3.translateDNA().toString().replaceAll(" ", "").equals("P")) {
      return false;
    }
    
    DNA testDNA4 = new DNA("GATTACA");
    if (!testDNA4.translateDNA().toString().replaceAll(" ", "").equals("LM")) {
      return false;
    }
    return true;
  }
  
  /**
   * Tests the mRNATranslate() method
   * @return true iff the method works correctly
   */
  public static boolean testMRNATranslate() {
    DNA testDNA = new DNA("GGA");
    if (!testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString().replaceAll(" ", "").equals("P")){
      System.out.println("DNA.mRNATranslate() failed");
      return false;
    }
    
    DNA testDNA2 = new DNA("GATTACA");
    if (!testDNA2.mRNATranslate​(testDNA2.transcribeDNA()).toString().replaceAll(" ", "")
        .equals("LM")) {
      return false;
    }
    
    DNA testDNA3 = new DNA("CCGGCCCTCCGGTGGATCCAA");
    if (!testDNA.mRNATranslate​(testDNA3.transcribeDNA()).toString().replaceAll(" ", "")
        .equals("GREAT")){
      System.out.println("DNA.mRNATranslate() failed");
      return false;
    }
    
    DNA testDNA4 = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    if (!testDNA.mRNATranslate​(testDNA4.transcribeDNA()).toString().replaceAll(" ", "")
        .equals("PQSIRWPCMTEPLEARSFRD")){
      System.out.println("DNA.mRNATranslate() failed");
      return false;
    }
    return true;
  }
  
  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * @param args unused
   */
  public static void main(String[] args) {
    System.out.println("testEnqueueDequeue: " + testEnqueueDequeue());
    System.out.println("testQueueSize: " + testQueueSize());
    System.out.println("testMRNATranslate: " + testMRNATranslate());
    System.out.println("transcribeDNA: "+testTranscribeDNA());
    System.out.println("translateDNA: "+testTranslateDNA());
  }

}