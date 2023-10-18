
/**
 * A application handler of an open position using priority queue. Only saves a new Application
 * when the queue is not full, or when it can replace older, lower-scored ones with its higher
 * scores.
 */
public class OpenPosition {
    private String positionName;
    private ApplicationQueue applications; // the priority queue of all applications
    private int capacity;                  // the number of vacancies
    
    /**
     * Creates a new open position with the given capacity
     * 
     * @param capacity the number of vacancies of this position
     * @throws IllegalArgumentException with a descriptive error message if the capacity is not a
     *                                  positive integer
     */
    public OpenPosition(String positionName, int capacity) {
        // TODO verify the value of capacity
      if (capacity < 1) {
        throw new IllegalArgumentException("int capacity is not a positive integer");
      }
        // TODO initialize the data fields appropriately
      this.positionName = positionName;
      this.applications = new ApplicationQueue(capacity);
      this.capacity = capacity;
    }
    
    public String getPositionName() { 
      return this.positionName;
    }
    
    /**
     * Tries to add the given Application to the priority queue of this position.  return
     * False when the new Application has a lower score than the lowest-scored Application
     * in the queue.
     * 
     * @return Whether the given Application was added successfully
     */
    public boolean add(Application application) {
        // TODO if the queue is full, determine whether this application has a higher score than 
        // the current lowest-scoring application; if not, do not add it
      if (applications.isEmpty()) {
        applications.enqueue(application);
        if (applications.peek().compareTo(application) == 0) {
          return true;
        }
      }
      // TODO if there is room in the queue OR this application has a higher score than the current
      // lowest-scoring application, add it to the queue
      else if (applications.size() < capacity) {
        applications.enqueue(application);
        return true;
      }
      else if (applications.size() == capacity) {
        if (application.compareTo(applications.peek()) == 1) {
          applications.dequeue();
          applications.enqueue(application);
       //   if (applications.peek().compareTo(application) == 0) {
            return true;
            //  }
        }
      }
      return false;
    }
    
    /**
     * Returns the list of Applications in the priority queue.
     * 
     * @return The list of Applications in the priority queue, in increasing order of the
     * scores.
     */
    public String getApplications() {
      ApplicationQueue aqToUse = applications;
      return aqToUse.toString();
    }
    
    /**
     * Returns the total score of Applications in the priority queue.
     * 
     * @return The total score of Applications in the priority queue.
     */
    public int getTotalScore() {
      int toReturn = 0;
      ApplicationQueue aqToUse = applications.deepCopy();
      ApplicationIterator iter = new ApplicationIterator(applications);
        // TODO calculate the total score of all applications currently in the queue
      while (iter.hasNext()) {
        toReturn += iter.next().getScore();
      }
        return toReturn;  // TODO fix
    }
}