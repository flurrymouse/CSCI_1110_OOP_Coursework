import java.util.*;

public class Exercise22_1 {
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    LinkedList<Character> max = new LinkedList<>();
    LinkedList<Character> list = new LinkedList<>();
    
    System.out.print("Enter a string: ");
    String string = input.nextLine(); 
    
    for (int i = 0; i < string.length(); i++) {
      if (list.size() > 1 && string.charAt(i) <= list.getLast() && list.contains(string.charAt(i))) {
      list.clear();
      }
      
      list.add(string.charAt(i));
      if (list.size() > max.size()) { 
      max.clear();
      max.addAll(list);
      }
    }
    
    System.out.print("The maximum consecutive substring is ");
    
    for (Character ch: max) { 
    
    System.out.print(ch); 
    }
    
    System.out.println();
    }
  
}