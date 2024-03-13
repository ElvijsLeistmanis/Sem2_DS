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
	
	public void print() throws Exception {
		if(isEmpty()) throw new Exception("List is empty.");
		MyListNode temp = first;
		for (int i = 0; i < counter; i++) {
			System.out.println(temp + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
}
