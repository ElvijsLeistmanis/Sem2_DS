package datastr;

@SuppressWarnings("rawtypes")
public class MyListNode<T> {
	private T element;
	private MyListNode next = null;
	private MyListNode previous = null;
	
	public T getElement() {
		return element;
	}
	public void setElement(T element) {
		if (element != null)
			this.element = element;
		else
			this.element = (T) new Object();
	}
	
	public MyListNode getNext() {
		return next;
	}
	
	public void setNext(MyListNode next) {
		this.next = next;
	}
	
	public MyListNode getPrevious() {
		return previous;
	}
	
	public void setPrevious(MyListNode previous) {
		this.previous = previous;
	}
	
	public MyListNode(T element) {
		setElement(element);
	}
	
	public String toString() {
		return ""+element;
	}
}
