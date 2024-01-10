package pgdp.zoo;
public class Animal{
	private String name;
	private int foodCosts;
	public Animal(String name, int foodCosts){
		this.name=name;
		this.foodCosts=foodCosts;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getFoodCosts() {
		return this.foodCosts;
	}
	
	public String toString() {
		String animal="(name: "+this.name+ ", foodCosts: "+this.foodCosts+")";
		return animal;
	}
	
	
	
	
}