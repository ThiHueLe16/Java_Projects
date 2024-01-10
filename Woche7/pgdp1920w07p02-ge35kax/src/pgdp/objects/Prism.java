package pgdp.objects;

public class Prism {
	private BaseArea base;
	private double height;
	
	public Prism(BaseArea base,double height) {
		this.height=height;
		this.base=base;
	}
	public BaseArea getBase() {
		return this.base;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double surface() {
		return base.circumference()*height +2*base.area();
	}
	public double volume() {
		return base.area()*height;
	}
	public boolean isCube() {
		if(base.isSquare()) {
			return base.toSquare().getLength()==height;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
        return "Prisma{" + "basis= " + base + "; hoehe= " + height + "; volumen= " + volume() + "; oberflaeche= "
                + surface() + "; Wuerfel?= " + isCube() + '}';
    }
}
