public abstract class MyAbstractList<E> implements MyList<E> {
	protected int size = 0; // The size of the list

	/** Create a default list */
	protected MyAbstractList() {
	}

	/** Create a list from an array of objects */
	protected MyAbstractList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	/** Add a new element at the end of this list */
	public void add(E e) {
		add(size, e);
	}

	/** Return true if this list contains no elements */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Return the number of elements in this list */
	public int size() {
		return size;
	}

	/** Remove the first occurrence of the element o from this list.
	 *  Shift any subsequent elements to the left.
	 *  Return true if the element is removed. */
	public boolean remove(E e) {
		if (indexOf(e) >= 0) {
			remove(indexOf(e));
			return true;
		}
		else 
			return false;
	}
	public boolean addAll(MyList<E> otherList){
		boolean ac = false;
		for( int i = 0; i< otherList.size(); i++){
		E e = otherList.get(i);
		if(!contains(e)){
			add(e);
			ac = true;
		}
	}
	return ac;
	}
	
	public boolean removeAll(MyList<E> otherList){
		boolean rc = false;
		for( int i = 0; i< otherList.size(); i++){
		E e = otherList.get(i);
		if(contains(e)){
			remove(e);
			rc = true;
		}
	}
	return rc;
	}
	
	public boolean retainAll(MyList<E> otherList){
		boolean rec = false;
		for( int i = size-1; i>=0; i--){
		E e = get(i);
		if(!otherList.contains(e)){
			remove(i);
			rec = true;
		}
	}
	return rec;
	}
	
	
		
	
}