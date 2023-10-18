import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class src {
  public static int n;
  
  public static class Job implements Comparable<Job>
  {
    int start;
    int fin;
    int val;
    
    public Job(int i, int j, int k)
    {
      start = i;
      fin = j;
      val = k;
    }

    @Override
    public int compareTo(src.Job o) {
      if (this.fin < o.fin) {return -1;}
      if (this.fin == o.fin) {return 0;}
      else return 1;
    }
  }
  
  public static Job[] sort(Job[] unsorted)
  {
    Arrays.sort(unsorted);
    
    return unsorted;
  }
  
  public static int findI(Job[] jobs, int j)
  {
    int curr = 0;
    
    for (int i = 0; i < j; i++)
    {
      if (jobs[i].fin <= jobs[j].start && jobs[i].fin > jobs[curr].fin)
      {
        curr = i;
      }
    }
    
    return curr;
  }
  
  public static void WeightIntDP(Job[] jobs)
  {
    int[] m = new int[n];
    m[0] = jobs[0].val;
    
    for (int j = 1; j < n; j++ )
    {
      int i = findI(jobs, j);
      
      m[j] = Math.max(m[j - 1], m[i] + jobs[j].val);
    }
    
    System.out.println(m[n - 1]);
  }
  
  public static void main (String[] args) 
  {
    Scanner scnr = new Scanner(System.in);
    
    int numInstances = scnr.nextInt();
    
    for (int i = 0; i < numInstances; i++) 
    {
      n = scnr.nextInt();
      
      Job[] unsortedJobs = new Job[n];
      
      int start, finish, value;
      
      for (int j = 0; j < n; j++) 
      {
        start = scnr.nextInt();
        finish = scnr.nextInt();
        value = scnr.nextInt();
        
        unsortedJobs[j] = new Job(start, finish, value);
      }
      
      Job[] sortedJobs = sort(unsortedJobs);
      unsortedJobs = null;
      
      WeightIntDP(sortedJobs);
    }
    
    scnr.close();
  }
}
