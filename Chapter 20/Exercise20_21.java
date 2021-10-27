/*
Author: HAN GAO
Date: Sep.30

Description: 
*/
import java.util.Comparator;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    selectionSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++)
      System.out.println(list1[i].getArea() + " ");
  }
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator){
    for (int i = 1; i < list.length; i++){
      for (int a = 0; a < list.length-i; a++){
        if (comparator.compare(list[a], list[a+1]) > 0 ){
        E temp = list[a];
        list[a] = list[a+1];
        list[a+1] = temp;
     }  
  }
  }
  }
}