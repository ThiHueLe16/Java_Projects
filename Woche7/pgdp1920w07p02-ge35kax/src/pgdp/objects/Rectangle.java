package pgdp.objects;

public class Rectangle extends BaseArea {
	private double width;
	private double height;
	/*public void setWidth(double width) {
		this.width=width;
	}
	public double getWidth() {
		return this.width;
	}*/
	//nen set gia tei trong konstruktor
	//Konstruktor
	public Rectangle(double width, double height) {
		this.width=width;
		this.height=height;
	}
	public double getHeight() {
		//return height;
		return height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double circumference() {
		return 2*(width+height);
	}
	
	public double area() {
		return width*height;
	}
	public boolean isSquare() {
		return width==height;
	}
	
	public Square toSquare() {
		if(isSquare()) {
			return new Square(height);
		}
		else {
			return null;
		}
		
	}
}
