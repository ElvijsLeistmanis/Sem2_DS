package datastr;

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
}
