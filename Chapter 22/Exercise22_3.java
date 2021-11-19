import java.util.*;

/* There is only one for loop, the only thing will affect the running time in for loop is the relationship of i,  the loop just go through all the stuff in the st1.length one by one, there is no ohter relationship in the loop, So the running time should be O(N)Linear.
**/
public class Exercise22_3 {
  public static void main(String[] args) {
      int o = -1; // for index
      int C = 0; // for count
      Scanner input = new Scanner(System.in);
    
      System.out.print("Enter the first string: ");
      String st1 = input.nextLine();
      System.out.print("Enter the second string: ");
      String st2 = input.nextLine();
    
      
    
      for (int i = 0; i < st1.length(); i++) {
        if (st1.charAt(i) == st2.charAt(0) && C == 0) {
          o = i;
          C++;
        }
        else if (st1.charAt(i) == st2.charAt(C)) {
          C++;
        }
        else {
          C = 0;
          o = -1;
        }
        
        if (C == st2.length())
          break;
      }
    
      if (C > 1)
        System.out.println("Matched at index " + C);
      else
        System.out.println("Error");
    }
  
  
}