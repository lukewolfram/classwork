
/**
 * This class models a application with a name and due date
 */
public class Application implements Comparable<Application>{
    private final String name;  // name of this applicant
    private final String email; // email of this applicant
    private final int score;    // estimated score of this applicant
    
    /**
     * Creates a new Application with the given information
     *
     * @param name       name of this applicant
     * @param email      email of this applicant
     * @param score      estimated score of this applicant (must be in the range 0 .. 100)
     * @throws IllegalArgumentException if the provided name is null or blank, or if the email is
     *                                  null or does not have a single {@literal @}, or if score
     *                                  is not in the 0 .. 100 range.
     */
    public Application(String name, String email, int score) {
      if (name == null || name.isBlank()) {
        throw new IllegalArgumentException("String name is null/blank");
      }
      if (email == null || email.isBlank()) {
        throw new IllegalArgumentException("String email is null");
      }
      if (email.indexOf("@") == -1 || (email.lastIndexOf("@") > email.indexOf("@"))) {
        throw new IllegalArgumentException("String email has 0 or more than 1 @");
      }
      if (score < 0 || score > 100) {
        throw new IllegalArgumentException("int score not in 0 ... 100 range");
      }
      
      this.name = name;
      this.email = email;
      this.score = score;
    }

    /**
     * Returns the name of this Applicant
     * 
     * @return the name of this Applicant
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the email of this Applicant
     * 
     * @return the email of this Applicant
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the score of this Applicant
     * 
     * @return the score of this Applicant
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Compares this Applicant to another applicant based on their score
     * 
     * @return a negative integer if this Applicant has an lower score, {@code 0} if the two
     *         Applicants have the same score, and a positive integer if this
     *         Applicant has a higher score.
     * @throws NullPointerException if the other assignment o is null
     */
    @Override
    public int compareTo(Application other) {
      if (other == null) {
        throw new NullPointerException("Application other is null");
      }
      if (score < other.getScore()) {
        return -1;  
      }
      else if (score > other.getScore()) {
        return 1;
      }
      return 0;
    }

    /**
     * Returns a String representing this Application containing its name, email and score.
     * (This implementation is provided for you.)
     * 
     * @return a String representing this Application
     */
    @Override
    public String toString() {
        return name + ":" + email + ":" + score;
    }
}