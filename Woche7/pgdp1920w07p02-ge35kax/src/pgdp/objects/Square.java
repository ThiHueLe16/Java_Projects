package pgdp.objects;

public class Square extends BaseArea{
	private double length;
	public Square(double length) {
		this.length=length;
	}
	public double getLength() {
		return this.length;
	}
	
	public double circumference() {
		return 4*length;
	}
	
	public double area() {
		return length*length;
	}
	
	public boolean isSquare() {
		return true;
	}
	
	public Square toSquare() {
		return this;
	}
}
