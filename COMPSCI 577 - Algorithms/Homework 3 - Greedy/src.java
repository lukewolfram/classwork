import java.util.Scanner;
import java.util.ArrayList;

public class src {
  public static String output = "";
  public static final int START = 0;
  public static final int FINISH = 1;
  
  public static void finishFirst(ArrayList<int[]> requests) {
      int minFinishTime;
      int minFinishIndex;
      
      ArrayList<int[]> optimal = new ArrayList<int[]>();
      
      while (!requests.isEmpty()) {
        minFinishTime = Integer.MAX_VALUE;
        minFinishIndex = -1;
        
        for (int currJobIndex = 0; currJobIndex < requests.size(); currJobIndex++) {
          if (requests.get(currJobIndex)[FINISH] < minFinishTime) {
            minFinishTime = requests.get(currJobIndex)[FINISH];
            minFinishIndex = currJobIndex;
          } 
        }
        
        optimal.add(requests.get(minFinishIndex));

        for (int currJobIndex = requests.size() - 1; currJobIndex > -1; currJobIndex--) {
          if (!(minFinishTime <= requests.get(currJobIndex)[START])) {
            requests.remove(currJobIndex);
          }
        }
      }
      
      output += (optimal.size() + "\n");
  }
  
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    
    int numJobs;
    
    int numInstances = scnr.nextInt();
    
    for (int i = 0; i < numInstances; i++) {
      
      numJobs = scnr.nextInt();
      
      ArrayList<int[]> requests = new ArrayList<int[]>();
      
      for (int j = 0; j < numJobs; j++) {
        int[] job = new int[2];
        scnr.nextLine();
      
        job[START] = scnr.nextInt();
        job[FINISH] = scnr.nextInt();
          
        requests.add(job);
      }
      finishFirst(requests);
    }    
    scnr.close();
    
    System.out.print(output);
  } //      END main
}//     END FinishFirst
