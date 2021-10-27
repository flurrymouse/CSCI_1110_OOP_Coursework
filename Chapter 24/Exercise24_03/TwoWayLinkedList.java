import java.util.ListIterator;
import javax.lang.model.element.*;

class TwoWayLinkedList<E> extends java.util.AbstractSequentialList<E> {
	private Node<E> head, tail;
	private int size;

	/** Create a default list */
	public TwoWayLinkedList() {
	}

	/** Create a list from an array of objects */
	public TwoWayLinkedList(E[] objects) {
		for (E e : objects)
			add(e);
	}

	/** Return the head element in the list */
	public E getFirst() {
		if (size == 0) {
			return null;
		} else {
			return head.element;
		}
	}

	/** Return the last element in the list */
	public E getLast() {
		if (size == 0) {
			return null;
		} else {
			return tail.element;
		}
	}

	/** Add an element to the beginning of the list */
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new node
		newNode.next = head; // link the new node with the head
		head = newNode; // head points to the new node
		size++; // Increase list size

		if (tail == null) // the new node is the only node in list
			tail = head;

		if (head != tail)
			// For a two-way linked list, make the next item's previous element the head
			newNode.next.previous= head;
	}

	/** Add an element to the end of the list */
	public void addLast(E e) {
		Node<E> newNode = new Node<E>(e); // Create a new for element e

		Node<E> temp = tail; // For a two-way linked list

		if (tail == null) {
			head = tail = newNode; // The new node is the only node in list
		} else {
			tail.next = newNode; // Link the new with the last node
			tail = tail.next; // tail now points to the last node
		}

		size++; // Increase size
		tail.previous=temp;
		// For a two-way linked list, link the tail's previous element to temp
	}

	/**
	 * Add a new element at the specified index in this list The index of the
	 * head element is 0
	 */
	public void add(int index, E e) {
		if (index == 0) {
			addFirst(e);
		} else if (index >= size) {
			addLast(e);
		} else {
			Node<E> current = head;
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<E>(e);
			(current.next).next = temp;
			size++;
			temp.previous = current.next;
			current.next.previous = current;
			// For a two-way linked list, link temp's previous element to current's next element
			// For a two-way linked list, link current's next's previous element to current
		}
	}

	/**
	 * Remove the head node and return the object that is contained in the
	 * removed node.
	 */
	public E removeFirst() {
		if (size == 0) {
			return null;
		} else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) {
				tail = null;
			}
			return temp.element;
		}
	}

	/**
	 * Remove the last node and return the object that is contained in the
	 * removed node.
	 */
	public E removeLast() {
		if (size == 0) {
			return null;
		} else if (size == 1) {
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		} else {
			Node<E> current = head;

			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}

	/**
	 * Remove the element at the specified position in this list. Return the
	 * element that was removed from the list.
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			return null;
		} else if (index == 0) {
			return removeFirst();
		} else if (index == size - 1) {
			return removeLast();
		} else {
			Node<E> previous = head;

			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}

			Node<E> current = previous.next;
			previous.next = current.next;
			current.next.previous = previous; // For a two-way linked list
			size--;
			return current.element;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");

		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", "); // Separate two elements with a comma
			} else {
				result.append("]"); // Insert the closing ] in the string
			}
		}

		return result.toString();
	}

	/** Clear the list */
	public void clear() {
		head = tail = null;
	}

	/** Return true if this list contains the element o */
	public boolean contains(Object e) {
		System.out.println("Implementation left as an exercise");
		return true;
	}

	/** Return the element from this list at the specified index */
	public E get(int index) {
		System.out.println("Implementation left as an exercise");
		return null;
	}

	/**
	 * Return the index of the head matching element in this list. Return -1 if
	 * no match.
	 */
	public int indexOf(Object e) {
		System.out.println("Implementation left as an exercise");
		return 0;
	}

	/**
	 * Return the index of the last matching element in this list Return -1 if
	 * no match.
	 */
	public int lastIndexOf(Object e) {
		System.out.println("Implementation left as an exercise");
		return 0;
	}

	/**
	 * Replace the element at the specified position in this list with the
	 * specified element.
	 */
	public E set(int index, E e) {
		System.out.println("Implementation left as an exercise");
		return null;
	}

	/** Override the iterator method defined in Iterable */
	public java.util.ListIterator<E> iterator() {
		return new LinkedListIterator<E>();
	}

	private class LinkedListIterator<E> implements java.util.ListIterator<E> {
		private Node<E> current = (Node<E>)head; // Current index
		int index = 0;

		public LinkedListIterator() {
		}
		
		public LinkedListIterator(int index) {
			if (index < 0 || index > size)
				throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
					+ size);
			for (int nextIndex = 0; nextIndex < index; nextIndex++)
				current = current.next;
		}
	
		public boolean hasNext() {
			return (current != null);
		}

		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}

		public void remove() {
			System.out.println("Implementation left as an exercise");
		}

		public void add(E e) {
			System.out.println("Implementation left as an exercise");
		}

		public boolean hasPrevious() {
			return current != head;
		}

		public int nextIndex() {
			System.out.println("Implementation left as an exercise");
			return 0;
		}

		public E previous() {
			E e = current.element;
			current = current.previous;
			return e;
		}

		public int previousIndex() {
			System.out.println("Implementation left as an exercise");
			return 0;
		}

		@Override
		public void set(E e) {
			current.element = e; // TODO Auto-generated method stub
		}
	}

	public class Node<E> {
		E element;
		Node<E> next;
		Node<E> previous;

		public Node(E o) {
			element = o;
		}
	}

	public int size() {
		return size;
	}

	public ListIterator<E> listIterator(int index) {
		return new LinkedListIterator<E>(index); 
	}
}