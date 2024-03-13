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
}
