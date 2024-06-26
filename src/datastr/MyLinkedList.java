package datastr;

@SuppressWarnings("rawtypes")
public class MyLinkedList<T>{
	private MyListNode first = null;
	private MyListNode last = null;
	private int counter = 0;
	
	public boolean isEmpty() {
		return (counter == 0);
	}
	
	public int howManyElements() {
		return counter;
	}
	
	public void addElement(T element) throws Exception {
		if (element == null) throw new Exception("Bad input value.");
		
		if(isEmpty()) {
			MyListNode<T> newNode = new MyListNode<T>(element);
			first = newNode;
			last = newNode;
			counter++;
		}
		else {
			MyListNode<T> newNode = new MyListNode<T>(element);
			newNode.setPrevious(last);
			last.setNext(newNode);
			last = newNode;
			counter++;
		}
	}
	
	public void print() throws Exception {
		if(isEmpty()) throw new Exception("List is empty.");
		MyListNode temp = first;
		for (int i = 0; i < counter; i++) {
			System.out.print(temp + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	public void insertElement(T element, int pos) throws Exception {
		if (element == null) throw new Exception("Bad input value.");
		if (pos > counter || pos < 0) throw new Exception("Cannot insert element at this position.");
		
		if (isEmpty() && pos == 0) {
			addElement(element);
		}
		else if (isEmpty() && pos != 0) {
			throw new Exception("Cannot insert element at this position.");
		}
		else if(pos == 0){
			MyListNode newNode = new MyListNode(element);
			newNode.setNext(first);
			first.setPrevious(newNode);
			first = newNode;
			counter++;
		}
		else if (pos == counter){
			addElement(element);
		}
		else {
			MyListNode temp = first;
			for (int i = 0; i < pos; i++) {
				temp = temp.getNext();
			}
			MyListNode rightNode = temp;
			MyListNode leftNode = temp.getPrevious();
			
			MyListNode newNode = new MyListNode(element);
			newNode.setNext(rightNode);
			rightNode.setPrevious(newNode);
			
			newNode.setPrevious(leftNode);
			leftNode.setNext(newNode);
			counter++;
		}
	}
	
	public void deleteElement(int pos) throws Exception {
		if (pos >= counter || pos < 0) throw new Exception("Cannot delete element at this position.");
		if (isEmpty()) throw new Exception("List is empty.");
		
		if (pos == 0) {
			first = first.getNext();
			first.setPrevious(null);
		}
		else if (pos == counter - 1) {
			last = last.getPrevious();
			last.setNext(null);
		}
		else {
			MyListNode temp = first;
			for (int i = 0; i < pos; i++) {
				temp = temp.getNext();
			}
			
			MyListNode leftNode = temp.getPrevious();
			MyListNode rightNode = temp.getNext();
			
			leftNode.setNext(rightNode);
			rightNode.setPrevious(leftNode);
		}
		System.gc();
		counter--;
	}
	
	public T getElement(int pos) throws Exception {
		if (isEmpty()) throw new Exception("List is empty.");
		if (pos < 0 || pos > counter) throw new Exception("Bad position.");
		
		MyListNode temp = first;
		for (int i = 0; i < pos; i++) {
			temp = temp.getNext();
		}
		return (T) temp.getElement();
	}
	
	public boolean findElement(T element) throws Exception {
		if (isEmpty()) throw new Exception("List is empty.");
		if (element == null) throw new Exception("Bad element.");
		
		MyListNode temp = first;
		for (int i = 0; i < counter; i++) {
			if (temp.getElement().equals(element)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public void makeEmpty() {
		first = null;
		last = null;
		counter = 0;
		System.gc();
	}
}
