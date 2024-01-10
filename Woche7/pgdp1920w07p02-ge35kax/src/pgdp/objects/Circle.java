package pgdp.objects;

public class Circle extends BaseArea{
	private double radius;
	//Konstruktor
	public Circle(double radius) {
		this.radius=radius;
	}
	public double getRadius() {
		return this.radius;
	}
	
	//Methode
	public double circumference() {
		return 2*Math.PI*this.radius;
	}
	public double area() {
		return Math.PI*radius*radius;
	}
	
}
