package jrJava.usingInterface;


public class Programmer /* extends Employee */ implements JavaTeacher, Father, Husband {

	protected String name;
	protected int level;
	
	public Programmer(String _name, int _level){
		name = _name;
		level = _level;
	}
	
	public String getName(){ return name; }
	
	public int getLevel(){ return level; }
	
	
	public void punishStudent(){
		System.out.println("Spank, spank, and spank !!!");
	}
	
	public void takeAwayLaptops(){
		System.out.println("Only if it's an expensive one.");
	}

	
	public void makeMoney() {
		System.out.println("I've made $1,000,000 this year.");
	}

	
	public void fixToilet() {
		System.out.println("I don't know how. Call a plumber.");
	}

	
	public void payAllowance() {
		System.out.println("Here is $200. Need more?");
	}

	public void takeOutTrash() {
		System.out.println("Is it already Tuesday?");
		
	}
}
