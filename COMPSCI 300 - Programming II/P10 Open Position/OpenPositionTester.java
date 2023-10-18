import java.util.NoSuchElementException;

/**
 * This class implements unit test methods to check the correctness of Application, 
 * ApplicationIterator, ApplicationQueue and OpenPosition classes in the assignment.
 *
 */
public class OpenPositionTester {

    /**
     * This method tests and makes use of the Application constructor, getter methods,
     * toString() and compareTo() methods.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testApplication() {
        // create an Application with valid input
        Application t = new Application("Joe", "asdf@whatever.com", 69);
        // create an Application with invalid input:
        // blank name
        try {
          Application t1 = new Application(null, "asdf@asdf.com", 69);
          System.out.println("Application constructor did not throw an IAE with a null name");
          return false;
          } catch (IllegalArgumentException e) {
          System.out.println("Application successfully threw an IAE with a null name");
        }
        try {
          Application t1 = new Application("", "asdf@asdf.com", 69);
          System.out.println("Application constructor did not throw an IAE with a blank name");
          return false;
          } catch (IllegalArgumentException e) {
          System.out.println("Application successfully threw an IAE with a blank name");
        }
        // null email
        try {
          Application t1 = new Application("Joe", null, 69);
          System.out.println("Application constructor did not throw an IAE with a null email");
          return false;
          } catch (IllegalArgumentException e) {
          System.out.println("Application successfully threw an IAE with a null email");
        }
        // no @ email
        try {
          Application t1 = new Application("Joe", "asdf", 69);
          System.out.println("Application constructor did not throw an IAE when passed no @");
          return false;
          } catch (IllegalArgumentException e) {
          System.out.println("Application successfully threw an IAE with no @ in email");
        }
        // too many @ email
        try {
          Application t1 = new Application("Joe", "@asdf@", 69);
          System.out.println("Application constructor did not throw an IAE when passed multiple @");
          return false;
          } catch (IllegalArgumentException e) {
          System.out.println("Application successfully threw an IAE with multiple @ in email");
        }
        // invalid score
        try {
          Application t1 = new Application("Joe", "asdf@whatever", -1);
          System.out.println("Application constructor did not throw an IAE when score < 0");
          return false;
          } catch (IllegalArgumentException e) {
          System.out.println("Application successfully threw an IAE with a score < 0");
        }
        try {
          Application t1 = new Application("Joe", "asdf@whatever", 101);
          System.out.println("Application constructor did not throw an IAE when score > 100");
          return false;
          } catch (IllegalArgumentException e) {
          System.out.println("Application successfully threw an IAE with a score > 100");
        }
        try {
          Application t1 = new Application("Joe", "asdf@whatever", 0);
          } catch (IllegalArgumentException e) {
            System.out.println("Application threw an IAE when score == 0");
          return false;
        }
        try {
          Application t1 = new Application("Joe", "asdf@whatever", 100);
          } catch (IllegalArgumentException e) {
            System.out.println("Application threw an IAE when score == 100");
          return false;
        }
        // verify getters
        if (!t.getName().equals("Joe")) {
          System.out.println("Application.getName() failed");
          return false;
        }
        if (!t.getEmail().equals("asdf@whatever.com")) {
          System.out.println("Application.getEmail() failed");
          return false;
        }
        if (t.getScore() != 69) {
          System.out.println("Application.getScore() failed");
          return false;
        }
        // verify compareTo
        Application less = new Application("Joe", "asdf@whatever", 68);
        Application more = new Application("Joe", "asdf@whatever", 70);
        Application equal = new Application("Joe", "asdf@whatever", 69);
        
        if (t.compareTo(more) != -1) {
          System.out.println("Application.compareTo() failed to return a -1");
          return false;
        }
        if (t.compareTo(less) != 1) {
          System.out.println("Application.compareTo() failed to return a 1");
          return false;
        }
        if (t.compareTo(equal) != 0) {
          System.out.println("Application.compareTo() failed to return a 0");
          return false;
        }
        // verify toString
        if (!t.toString().equals("Joe:asdf@whatever.com:69")) {
          System.out.println("Application.toString() failed to return the correct string");
          return false;
        }
        return true;
    }

    /**
     * This method tests and makes use of the ApplicationIterator class.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testApplicationIterator() {
        // create an ApplicationQueue with capacity at least 3
        // and at least 3 Applications with different scores
        ApplicationQueue queue = new ApplicationQueue(7);
        Application a1 = new Application("1st", "@", 1);
        Application a2 = new Application("2nd", "@", 2);
        Application a3 = new Application("3rd", "@", 3);
        Application a4 = new Application("4th", "@", 4);
        Application a5 = new Application("5th", "@", 5);
        Application a6 = new Application("6th", "@", 6);
        Application a7 = new Application("7th", "@", 7);
        // add those Applications to the queue
        queue.enqueue(a7);
        queue.enqueue(a6);
        queue.enqueue(a5);
        queue.enqueue(a4);
        queue.enqueue(a3);
        queue.enqueue(a2);
        queue.enqueue(a1);
        ApplicationIterator iter = new ApplicationIterator(queue);
        Application[] expected = new Application[] {a1, a2, a3, a4, a5, a6, a7};
        // verify that iterating through the queue gives you the applications in order of
        // INCREASING score
        for (int i = 0; i < queue.size(); i++) {
          if (iter.next().compareTo(expected[i]) != 0) {
            System.out.println("Iteration failed at index " + i);
            return false;
          }
        }
        return true;  // TODO change this
    }
    
    /**
     * This method tests and makes use of the enqueue() and dequeue() methods
     * in the ApplicationQueue class.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testEnqueueDequeue() {
        // create an ApplicationQueue with capacity 3
        // and at least 4 Applications with different scores
      try {
      ApplicationQueue queue = new ApplicationQueue(3);
      Application a1 = new Application("1st", "@", 1);
      Application a2 = new Application("2nd", "@", 2);
      Application a3 = new Application("3rd", "@", 3);
      Application a4 = new Application("4th", "@", 4);
      } catch (NullPointerException e) {
        System.out.println("NPE thrown");
        return false;
      }
      ApplicationQueue queue = new ApplicationQueue(3);
      Application a1 = new Application("1st", "@", 1);
      Application a2 = new Application("2nd", "@", 2);
      Application a3 = new Application("3rd", "@", 3);
      Application a4 = new Application("4th", "@", 4);
        // enqueue an invalid value (null)
        try {
          queue.enqueue(null);
          System.out.println("ApplicationQueue.enqueue() failed to throw an NPE");
          return false;
        } catch (NullPointerException e) {
          System.out.println("ApplicationQueue.enqueue() successfully threw an NPE");
        }
        try {
          ApplicationQueue empty = new ApplicationQueue(0);
          System.out.println("ApplicationQueue failed to throw a IAE with capacity < 1");
          return false;
        } catch (IllegalArgumentException e) {
          System.out.println("ApplicationQueue successfully threw an IAE with capacity < 1");
        }  catch (NullPointerException e) {
          System.out.println("NPE thrown");
          return false;
        }
        // enqueue one valid application
        try {
          queue.enqueue(a2);
          if (queue.peek().compareTo(a2) != 0) {
            System.out.println("ApplicationQueue.enqueue() failed");
            return false;
          }
        }
        catch (NullPointerException e) {
          return false;
        }
        // enqueue two more valid applications
        try {
          queue.enqueue(a1);
          if (queue.peek().compareTo(a1) != 0) {
            System.out.println("ApplicationQueue.enqueue() failed when percolating up");
            return false;
          }
          queue.enqueue(a3);
        } catch (NullPointerException e) {
          System.out.println("NPE thrown");
          return false;
        }
        // enqueue one more application (exceeds capacity)
        try {
          queue.enqueue(a4);
          System.out.println("ApplicationQueue.enqueue() failed to throw an ISE");
          return false;
        } catch (IllegalStateException e) {
          System.out.println("ApplicationQueue.enqueue() successfully threw an ISE");
        }  catch (NullPointerException e) {
          System.out.println("NPE thrown");
          return false;
        }
        // dequeue one application (should be lowest score)
        try {
          if (queue.dequeue().compareTo(a1) != 0) {
            System.out.println("ApplicationQueue.dequeue() failed to remove the lowest score");
            return false;
          }
          // dequeue all applications
          if (queue.dequeue().compareTo(a2) != 0) {
            System.out.println("ApplicationQueue.dequeue() failed to remove the lowest score");
            return false;
          }
          if (queue.dequeue().compareTo(a3) != 0) {
            System.out.println("ApplicationQueue.dequeue() failed to remove the lowest score");
            return false;
          }
        } catch (NullPointerException e) {
          System.out.println("NPE thrown");
          return false;
        }
        // dequeue from an empty queue
        try {
          queue.dequeue();
          System.out.println("ApplicationQueue.dequeue() failed to throw an NSEE");
          return false;
        } catch (NoSuchElementException e) {
          System.out.println("ApplicationQueue.dequeue() successfully threw an NSEE");
        }  catch (NullPointerException e) {
          System.out.println("NPE thrown");
          return false;
        }
        
        return true;  // TODO change this
    }

    /**
     * This method tests and makes use of the common methods (isEmpty(), size(), peek())
     * in the ApplicationQueue class.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testCommonMethods() {
        // create an ApplicationQueue with 0 capacity (should fail)
      try {
        ApplicationQueue aq = new ApplicationQueue(0);
        System.out.println("ApplicationQueue failed to throw an IAE");
        return false;
      } catch (IllegalArgumentException e) {
        System.out.println("ApplicationQueue successfully caught an IAE");
      }
        // create an ApplicationQueue with capacity 3
        // and at least 3 Applications with different scores
      ApplicationQueue queue = new ApplicationQueue(3);
      Application a1 = new Application("1st", "@", 1);
      Application a2 = new Application("2nd", "@", 2);
      Application a3 = new Application("3rd", "@", 3);
        // verify the methods' behaviors on an empty queue
      if (queue.size() != 0) {
        System.out.println("ApplicationQueue.size() failed to report a correct size of 0");
        return false;
      }
      if (!queue.isEmpty()) {
        System.out.println("ApplicationQueue.isEmpty() failed to report an empty queue as empty");
        return false;
      }
      try {
        queue.peek();
        System.out.println("ApplicationQueue.peek() failed to throw an NSEE");
        return false;
      } catch (NoSuchElementException e) {
        System.out.println("ApplicationQueue.peek() successfully threw an NSEE");
      }
        // add one Application and verify the methods' behaviors
      queue.enqueue(a3);
      if (queue.size() != 1) {
        System.out.println("ApplicationQueue.size() failed to report correct size of 1");
        return false;
      }
      if (queue.isEmpty()) { 
        System.out.println("ApplicationQueue.isEmpty() failed, said it was empty when really not");
        return false;
      }
      if (queue.peek().compareTo(a3) != 0) {
        System.out.println("ApplicationQueue failed to peek the right Application");
        return false;
      }
        // add the rest of the Applications and verify the methods' behaviors
      queue.enqueue(a2);
      if (queue.size() != 2) {
        System.out.println("ApplicationQueue.size() failed to report correct size of 1");
        return false;
      }
      if (queue.isEmpty()) { 
        System.out.println("ApplicationQueue.isEmpty() failed, said it was empty when really not");
        return false;
      }
      if (queue.peek().compareTo(a2) != 0) {
        System.out.println("ApplicationQueue failed to peek the right Application");
        return false;
      }
      queue.enqueue(a1);
      if (queue.size() != 3) {
        System.out.println("ApplicationQueue.size() failed to report correct size of 1");
        return false;
      }
      if (queue.isEmpty()) { 
        System.out.println("ApplicationQueue.isEmpty() failed, said it was empty when really not");
        return false;
      }
      if (queue.peek().compareTo(a1) != 0) {
        System.out.println("ApplicationQueue failed to peek the right Application");
        return false;
      }
        return true;  // TODO change this
    }

    /**
     * This method tests and makes use of OpenPosition class.
     * 
     * @return true when this test verifies the functionality, and false otherwise
     */
    public static boolean testOpenPosition() {
        // create an OpenPosition with 0 capacity (should fail)
      try {
        OpenPosition a = new OpenPosition("name", 0);
        System.out.println("OpenPosition failed to throw an IAE");
        return false;
      } catch (IllegalArgumentException e) {
        System.out.println("OpenPosition successfully threw an IAE");
      }
        // create an OpenPosition with capacity 3
        // and at least 5 Applications with different scores
      OpenPosition t = new OpenPosition("name", 3);
      Application a1 = new Application("1st", "@", 1);
      Application a2 = new Application("2nd", "@", 2);
      Application a3 = new Application("3rd", "@", 3);
      Application a4 = new Application("4th", "@", 4);
      Application a5 = new Application("5th", "@", 5);
        // verify that the 3 MIDDLE-scoring Applications can be added
        // don't use the highest and lowest scoring applications YET
      if (!t.add(a3)) {
        System.out.println("OpenPosition.add() failed to add the first Application");
        return false;
      }
      if (!t.add(a2)) {
        System.out.println("OpenPosition.add() failed to add the second Application");
        return false;
      }
      if (!t.add(a4)) {
        System.out.println("OpenPosition.add() failed to add the third Application");
        return false;
      }
        // verify that getApplications returns the correct value for your input
      if (!t.getApplications().equals("2nd:@:2\n3rd:@:3\n4th:@:4\n")) {
        System.out.println("OpenPosition.getApplications() failed");
        return false;
      }
        // verify that the result of getTotalScore is the sum of all 3 Application scores
      t.add(a4); t.add(a3); t.add(a2);
      if (t.getTotalScore() != 9) {
        System.out.println("OpenPosition.getTotalScore() failed");
        return false;
      }
        // verify that the lowest-scoring application is NOT added to the OpenPosition
      t.add(a4); t.add(a3); t.add(a2);
      if (t.add(a1)) {
        System.out.println("OpenPosition.add() added a score lower than the root when full");
        return false;
      }
        // verify that the highest-scoring application IS added to the OpenPosition
      t.add(a3); t.add(a2);
      if (!t.add(a5)) {
        System.out.println("OpenPosition.add() did not add a score higher than the root when full");
        return false;
      }
        // verify that getApplications has changed correctly
      if (!t.getApplications().equals("3rd:@:3\n4th:@:4\n5th:@:5\n")) {
        System.out.println("OpenPosition.getApplications() failed to change output");
        return false;
      }
        // verify that the result of getTotalScore has changed correctly
      t.add(a3); t.add(a4); t.add(a5);
      if (t.getTotalScore() != 12) {
        System.out.println("OpenPosition.getTotalScore() failed to get the changed total score");
        return false;
      }
        return true;  // TODO change this
    }
    
    /**
     * This method calls all the test methods defined and implemented in your OpenPositionTester class.
     * 
     * @return true if all the test methods defined in this class pass, and false otherwise.
     */
    public static boolean runAllTests() {
        return testApplication() && testApplicationIterator()
                && testEnqueueDequeue() && testCommonMethods()
                && testOpenPosition();
    }

    /**
     * Driver method defined in this OpenPositionTester class
     * 
     * @param args input arguments if any.
     */
    public static void main(String[] args) {
        System.out.print(runAllTests());
    }
}