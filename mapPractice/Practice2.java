package jrJava.mapPractice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice2 {

	public static void main(String[] args) {
		
		Map student1 = new HashMap();
		student1.put("name", "Y");
		student1.put("gender", "M");
		student1.put("grade", "8");
		student1.put("friend", "Z");
		
		Map student2 = new HashMap();
		student2.put("name", "Z");
		student2.put("gender", "F");
		student2.put("grade", "10");
		student2.put("friend", "Y");
		
		Map boss = new HashMap();
		boss.put("1", student1);
		boss.put("2", student2);
		displayAll(boss);
	}
	
	public static void displayAll(Map map){
		Set keys = map.keySet();
		Iterator iter = keys.iterator();
		while(iter.hasNext()){
			String key = (String) iter.next();
			Map student = (Map) map.get(key);
			Set set = student.keySet();
			Iterator studentIter = set.iterator();
			while(studentIter.hasNext()){
				String studentKey = (String) studentIter.next();
				Object studentValue = student.get(studentKey);
				System.out.println(studentKey + " : " + studentValue);
			}
			System.out.println("---------------------------");
		}
	}

}
