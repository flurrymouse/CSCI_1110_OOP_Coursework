/*
Author: 
Date: 

Description: The average running time of quicksort is O(NlogN), But if the quicksort start from the first or end element, the running time will be O(N^2)
*/
import java.util.Comparator;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quicksort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
   quicksort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }

  public static <AnyType extends Comparable<? super AnyType>> void quicksort( AnyType [ ] a )
    {
        quicksort( a, 0, a.length - 1 );
    }
    public static <E> void quicksort(E[] list, Comparator<? super E> comparator) {
    quicksort(list, 0, list.length - 1, comparator);
  }

  public static <E> void quicksort(
      E[] list, int first, int last, Comparator<? super E> comparator) {
    if (last > first) {
      int pivotIndex = partition(list, first, last, comparator);
      quicksort(list, first, pivotIndex - 1, comparator);
      quicksort(list, pivotIndex + 1, last, comparator);
    }
  }

public static <E> int partition(
      E[] list, int first, int last, Comparator<? super E> comparator) {
    E pivot = list[first];
    int low = first + 1; 
    int high = last; 

    while (high > low) {

      while (low <= high && comparator.compare(list[low], pivot) <= 0)
        low++;


      while (low <= high && comparator.compare(list[high], pivot) > 0)
        high--;

      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && comparator.compare(list[high], pivot) >= 0)
      high--;

    if (comparator.compare(pivot, list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    }
    else {
      return first;
    }
  }


   private static final int CUTOFF = 10;

   private static <AnyType extends Comparable<? super AnyType>> void quicksort( AnyType [ ] a, int low, int high )
    {
        if( low + CUTOFF > high )
            insertionSort( a, low, high );
        else
        {
            int middle = ( low + high ) / 2;
            if( a[ middle ].compareTo( a[ low ] ) < 0 )
                swapReferences( a, low, middle );
            if( a[ high ].compareTo( a[ low ] ) < 0 )
                swapReferences( a, low, high );
            if( a[ high ].compareTo( a[ middle ] ) < 0 )
                swapReferences( a, middle, high );

            swapReferences( a, middle, high - 1 );
            AnyType pivot = a[ high - 1 ];

            int i, j;
            for( i = low, j = high - 1; ; )
            {
                while( a[ ++i ].compareTo( pivot ) < 0 )
                    ;
                while( pivot.compareTo( a[ --j ] ) < 0 )
                    ;
                if( i >= j )
                    break;
                swapReferences( a, i, j );
            }

            swapReferences( a, i, high - 1 );

            quicksort( a, low, i - 1 );
            quicksort( a, i + 1, high );
        }
    }
    public static final <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
    {
        AnyType tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }
private static <AnyType extends Comparable<? super AnyType>> void insertionSort( AnyType [ ] a, int low, int high )
    {
        for( int p = low + 1; p <= high; p++ )
        {
            AnyType tmp = a[ p ];
            int j;

            for( j = p; j > low && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

}