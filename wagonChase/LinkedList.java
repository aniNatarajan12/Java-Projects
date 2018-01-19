package jrJava.wagonChase;

import Java.util.Iterator;

public class LinkedList {
	
	private Link first;
	
	public Link removeFirst(){
		return null;
	}
	
	public void insert(Link link){
		
	}
	
	public void insert(Object obj){
		Link link = new Link(obj, first);
		first = link;
	}
	
}
