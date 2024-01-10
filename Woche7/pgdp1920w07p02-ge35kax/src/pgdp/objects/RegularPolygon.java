package pgdp.objects;

public class RegularPolygon extends BaseArea {
	private int n;
	private double length;
	
	public RegularPolygon(int n, double length) {
		this.length=n;
		this.length=length;
	}
	
	public int getN(){
		return this.n;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double circumference() {
		return n*length;
	}
	
	public double area() {
		return (n*length*length)/(4*Math.tan(Math.PI/n));
	}
	public boolean isSquare() {
		return n==4;
	}
	public Square toSquare() {
		if(isSquare()) {
			return new Square(length);
		}
		else
			return null;
	}
}
