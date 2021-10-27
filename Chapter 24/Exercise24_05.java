import java.util.*;
public class Exercise24_05{
public static void main(String[] args) {
	GenericQueue<String> newq = new GenericQueue<String>();
	

	newq.enqueue("Sam");
	System.out.println("1. " + newq);
	
	newq.enqueue("Suxin");
	System.out.println("2. " + newq);
	
	newq.enqueue("Jerry"); 
	newq.enqueue("Jackson"); 
	System.out.println("3. " + newq);
	
	System.out.println("4. " + newq.requeue());
	System.out.println("5. " + newq.requeue());
	System.out.println("6. " + newq);
	}

	static class GenericQueue<E> extends java.util.LinkedList<E> {
	private static final long serialVersionUID = 1L;
	public void enqueue(E e) {addLast(e);}
	public E requeue() {return removeFirst();}
	public int getSize() {return size();}
	public String toString() {return "Queue: " + super.toString();}
	}
}