package pgdp.color;

public class RgbaColor extends RgbColor {
	private int alpha;
	//GET
	public int getAlpha() {
		return this.alpha;
	}
	
	//Konstruktor
	public RgbaColor(int bitDepth, int red, int green, int blue, int alpha){
		super(bitDepth,red,green,blue);//kontruktor von oberklasse aufrufen
		
		if(0<=alpha && alpha<=(IntMath.powerOfTwo(bitDepth)-1)) {
			this.alpha=alpha;
		}
	}
	public RgbColor8Bit toRgbColor8Bit() {
		if(this.alpha < (IntMath.powerOfTwo( this.getBitDepth())-1) ) {
			ExceptionUtil.unsupportedOperation("Fehler,weil der Alphawert nicht maximal ist ");
		}
			return super.toRgbColor8Bit();	
	}
}