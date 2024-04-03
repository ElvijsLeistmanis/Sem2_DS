package service;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Integer> myList = new MyLinkedList<Integer>();
		try {
			myList.addElement(23);
			myList.addElement(103);
			myList.addElement(-23);
			myList.print();
			myList.insertElement(12, 2);
			myList.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
