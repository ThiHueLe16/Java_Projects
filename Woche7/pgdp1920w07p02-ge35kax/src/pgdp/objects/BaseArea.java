package pgdp.objects;

public abstract class BaseArea {
	public abstract double circumference();
	
	public abstract double area();
	
	public boolean isSquare() {
		return false;
	}
	
	public Square toSquare(){
		return null;
	}
	
	public String toString() {
        return "Umfang: " + circumference() + "; Flaeche: " + area() + "; Quadrat?: " + isSquare();
    }
}
