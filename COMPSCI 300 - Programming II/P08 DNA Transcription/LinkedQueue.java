//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Linked Queue
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
 * A generic implementation of a linked queue
 * @param T - The type of data to be contained in the queue
 */
public class LinkedQueue<T> extends Object implements QueueADT<T> {
  protected Node<T> back;   //The node at the back of the queue, added MOST recently
  protected Node<T> front;  //The node at the front of the queue, added LEAST recently
  private int n;            //The number of elements in the queue
  
  /**
   * Adds the given data to this queue; every addition to a queue is made at the back
   * @param data - the data to add
   */
  public void enqueue(T data) {
    Node<T> nodeToAdd = new Node<T>(data);
    if (n > 0) {
      back.setNext(nodeToAdd);
      back = nodeToAdd;
    } else {
      back = nodeToAdd;
      front = nodeToAdd;
    }
    n++;
  }

  /**
   * Removes and returns the item from this queue that was least recently added
   * @return the item from this queue that was least recently added
   * @throws NoSuchElementException - if this queue is empty
   */
  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("LinkedQueue.dequeue(): list is empty");
    }
    
    T toReturn = front.getData();
    if (n > 0) {
      front = front.getNext();
      n--;
      return toReturn;
    } else {
      front = null;
      back = null;
      n--;
      return toReturn;
    }
  }

  /**
   * Returns the item least recently added to this queue without removing it
   * @return the item least recently added to this queue
   * @throws NoSuchElementException - if this queue is empty
   */
  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("LinkedQueue.dequeue(): list is empty");
    }
    return front.getData();
  }
  
  /**
   * Checks whether the queue contains any elements
   * @return true if this queue is empty; false otherwise
   */
  public boolean isEmpty() {
    if (front != null && back != null && n > 0) {
      return false;
    }
    return true;
  }
  
  /**
   * Returns the number of items in this queue
   * @return the number of items in this queue
   */
  public int size() {
    return n;
  }

  /**
   * Returns a string representation of this queue, beginning at the front (least recently added) 
   * of the queue and ending at the back (most recently added). An empty queue is represented as an 
   * empty string; otherwise items in the queue are represented using their data separated by spaces
   * 
   * @return the sequence of items in FIFO order, separated by spaces
   */
  @Override
  public String toString() {
    String s = "";
    if (!isEmpty()) {
      Node<T> frontCopy = front;
      for (int i = 0; i < n; i++) {
        s += frontCopy.getData() + " ";
        frontCopy = frontCopy.getNext();
      }
      return s;
    }
    return s;
  }
}
