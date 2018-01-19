package jrJava.mapPractice;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice1{
	
	public static void main(String[] args) {
		
		Map map = new HashMap();
		map.put("name", "Thomas");
		map.put("gender", "M");
		map.put("grade", "8");
		map.put("name", "Eric");
		
		Set keys = map.keySet();
		Iterator iter = keys.iterator();
		
		while(iter.hasNext()){
			Object value = iter.next();
			System.out.println(value.toString());
		}
		
		
		System.out.println("There are " + map.size() + " values being stored.");
		
//		Object ref = map.get("name");
//		System.out.println(ref.toString());
//		System.out.println(map.get("name").toString());
//		System.out.println(map.get("grade").toString());
//		
//		map.clear();
//		System.out.println(map.size());
		
//		map.remove("gender");
//		System.out.println(map.size());
//		Object ref = map.get("gender");
//		System.out.println(ref);
	}
}