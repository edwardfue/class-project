import java.util.Iterator;
import java.util.Vector;

public class DoubleEndedQueue<E> implements DoubleEndedQueueInterface<E> {
	
	private Node <E> front;
	private Node <E> back;
	private int size;
	
	public DoubleEndedQueue() {
		this.front = null;
		this.back = null;
		this.size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		Vector<E> vector = new Vector<E>(this.size);
		
		Node<E> curNode = this.front;
		while(curNode != null) {
			vector.add(curNode.getElement());
			curNode = curNode.getNext();
		}
		return new ElementIterator<E>(vector);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.size == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addFront(E element) throws NullPointerException {
		// TODO Auto-generated method stub
		if(element == null) {	
			throw new NullPointerException("Unable to add a null element to the "
					+ "front");
		}
		Node<E> newNode = new Node(element);
		if(this.isEmpty()) {
			this.back = newNode;
		}
		else {
			this.front.setPrevious(this.back);
		}
		
		newNode.setNext(this.front);
		this.front = newNode;

		this.size++;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addBack(E element) throws NullPointerException {
		// TODO Auto-generated method stub
		if(element == null) {
			throw new NullPointerException("Unable to add a null element to the "
					+ "back");
		}
		Node<E> newNode = new Node(element);
		if(this.isEmpty()) {
			this.front = newNode;
		}
		
		else {
			this.back.setNext(newNode);
			newNode.setPrevious(this.back);
		}
		
		this.back = newNode;
		
		this.size++;
		
		
	}

	@Override
	/* main issue as of right now is the remove methods
	 * already illustrated an paper image of how the Double 
	 * endqueue has to do with the remove. Must look at more 
	 * examples on how to remove the first node
	 * noted that a double Endend queue is also called a
	 * doubly linked list 
	 * 
	 * 
	*/ 
	public E removeFront() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}
		
		E temp = this.front.getElement();
		
		if(this.front == this.back) {
			this.back = this.front = null;
		}
		
		else {
			Node<E> curNode = this.front.getNext();
			curNode.setPrevious(null);
			this.front.setNext(null);
			this.front = curNode;
		}
		
		this.size--;
		return temp;

		
		
		/*
		 * 
		 * was editing back and forth on both attempts to see if it work 
		 * I was playing around with these two method for 2 to 3 day and 
		 * spend a while watching youtube video related to double ended queue
		 * also was drawing how to make the code and looking at both linked list
		 * and linked queue interface to see what was the remove and dequeue method
		 * 
		 * Attempt 2
		if(this.front.getNext() == null) {
			this.back = null;
		}
		else {
			this.front.getNext().setPrevious(null);
			this.front.getNext();
		}
		return (E)temp;
		if(this.front == this.back) {
			this.back= this.front = null;
		}
		else {
			this.front = this.front.getNext();
		}
		this.size--;
		return (E) temp;
		---------------------
		Attempt 1
		this.front = this.front.getNext();
		this.front.setPrevious(null);
		this.size--;
		return (E) temp;
		*/

	}

	@Override
	public E removeBack() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}
		
		E temp = this.back.getElement();
		
		if(this.front == this.back) {
			this.back = this.front = null;
		}
		else {
			Node<E> curNode = this.back.getPrevious();
			curNode.setNext(null);
			this.back.setPrevious(null);
			this.back = curNode;
		}
		/*
		 
		Node<E> temp = this.back;
		if(this.front == this.back) {
			this.front = null;
		}
		else {
			this.back.setPrevious(null);
		}
		 this.back = this.back.getPrevious();
		 temp.setPrevious(null);
		 */
		 
		 this.size--;
		return temp;
	}

	@Override
	public E peekFront() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}
		else {
		return this.front.getElement();
		}
	}

	@Override
	public E peekBack() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.back.getElement();
		}
	}

	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		this.front = null;
		this.back = null;
		this.size = 0;
		
	}

}
