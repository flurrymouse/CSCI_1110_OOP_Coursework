/*
Author: Y. Daniel Liang

Listing 23.9 Heap Class
 */
public class Heap<E extends Comparable<E>> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();

  /** Create a default heap */
  public Heap() {
  }

  /** Create a heap from an array of objects */
  public Heap(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  /** Add a new object into the heap */
  public void add(E newObject) {
    list.add(newObject); // Append to the heap
    int currentIndex = list.size() - 1; // The index of the last node

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      // Swap if the current object is greater than its parent
      if (list.get(currentIndex).compareTo(
          list.get(parentIndex)) > 0) {
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      }
      else
        break; // the tree is a heap now

      currentIndex = parentIndex;
    }
  }

  /** Remove the root from the heap */
  public E remove() {
    if (list.size() == 0) return null;

    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;

      // Find the minimum between two children
      if (leftChildIndex >= list.size()) break; // The tree is a heap
      int minIndex = leftChildIndex;
      if (rightChildIndex < list.size()) {
        if (list.get(minIndex).compareTo(
            list.get(rightChildIndex)) < 0) {
          minIndex = rightChildIndex;
        }
      }

      // Swap if the current node is less than the minimum
      if (list.get(currentIndex).compareTo(
          list.get(minIndex)) < 0) {
        E temp = list.get(minIndex);
        list.set(minIndex, list.get(currentIndex));
        list.set(currentIndex, temp);
        currentIndex = minIndex;
      }
      else
        break; // The tree is a heap
    }

    return removedObject;
  }

  /** Get the number of nodes in the tree */
  public int getSize() {
    return list.size();
  }
  
  /** Return true if heap is empty */
  public boolean isEmpty() {
    return list.size() == 0;
  }
}