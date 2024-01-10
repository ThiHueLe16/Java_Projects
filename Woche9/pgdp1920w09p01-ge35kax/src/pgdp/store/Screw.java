package pgdp.store;

public class Screw {
    private final double diameter;
    private final double length;
    private double price;
    private final ScrewDrive head;

    public Screw(ScrewDrive head,double diameter, double length, double price) {
        this.diameter = diameter;
        this.length = length;
        this.price = price;
        this.head=head;
    }
    

    public ScrewDrive getHead() {
        return head;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getLength() {
        return length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int hashCode() {//???????
    	return head.hashCode() + 7 * Double.hashCode(diameter)
        + 49 * Double.hashCode(length);
    }
    public boolean equals(Object obj) {
    	if(obj==null|| !(obj instanceof Screw)) {
    		return false;
    	}
    	Screw another=(Screw) obj;
    	return another.head==head && another.diameter==diameter && another.length==length;
    }
    public String toString() {
    	return "head :"+head+"diameter:"+diameter+"length:"+length;
    }
}
