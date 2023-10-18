import java.util.Scanner;
import java.util.LinkedList;

public class src 
{
  
  public static int countSort(LinkedList<Integer> A) 
  {
    if (A.size() == 1) 
    {
      return 0;
    }
    
    LinkedList<Integer> A1 = new LinkedList<>();
    LinkedList<Integer> A2 = new LinkedList<>();
    
    A1.addAll(A.subList(0, A.size() / 2));
    A2.addAll(A.subList(A.size() / 2, A.size()));
    
    int c1 = countSort(A1);
    int c2 = countSort(A2);    
    int c = mergeCount(A1, A2);
    
    return (c + c1 + c2);
  }
  
  public static int mergeCount(LinkedList<Integer> A, LinkedList<Integer> B) 
  {
    LinkedList<Integer> S = new LinkedList<>();
    
    int c = 0;
    boolean fromB = false;
    
    while (!A.isEmpty() || !B.isEmpty())
    {
      if (A.isEmpty())
      {
        S.add(B.pop());
        continue;
      }
      
      if (B.isEmpty())
      {
        S.add(A.pop());
        continue;
      }
      
      Integer min = Math.min(A.peek(), B.peek());
      S.add(min);
      
      if (min == A.peek())
      {
        A.pop();
      }
      else
      {
        B.pop();
        fromB = true;
      }
      
      if (fromB)
      {
        c += A.size();
      }
    }
    
    return c;
  }
  
  
  public static void main (String[] args) 
  {
    Scanner scnr = new Scanner(System.in);
    
    int numInstances = scnr.nextInt();
    
    int numElements;
    
    for (int i = 0; i < numInstances; i++) 
    {
      
      numElements = scnr.nextInt();
      LinkedList<Integer> ranking = new LinkedList<>();
      
      for (int j = 0; j < numElements; j++) 
      {
        ranking.add(scnr.nextInt());
      }
      
      System.out.println(countSort(ranking));
    }
    
    scnr.close();
  }
  
}
