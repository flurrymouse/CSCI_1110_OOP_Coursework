import java.util.*;
import java.util.Scanner;

/**The running time of the first loop is O(N^2), because there is a loop inside the loop, the running time of second loop is O(N^2), O(N^2) + O(N^2) = O(N^2), So the running time is O(N^2)
 */

public class Exercise22_1 {
public static void main(String[] args)
{

Scanner sc = new Scanner(System.in);
System.out.println("Please Enter a string:");
String inp =sc.next();
  
int max=0;
int count=1;
//first loop
for(int i = 0;i<inp.length();i++)
{
int c =1; 
for(int j =i;j<inp.length()-1;j++)
{
int o = (int)inp.charAt(j);
o++;
if(o==inp.charAt(j+1)){
c++;}
else {break;}
}
if(count<c)
{
count=c;
max = i;
}
if((inp.length()-i)<count){break;}
}

System.out.print("Maximum consecutive substring is:");
//second loop
int k=0;
for(int i=max;k<count;k++,i++)
System.out.print(inp.charAt(i));
  
System.out.println();
}
  
  
}