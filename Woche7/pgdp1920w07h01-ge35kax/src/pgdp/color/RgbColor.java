package pgdp.color;

public class RgbColor {
	
	private  int red;
	private int green ;
	private int blue;
	private int bitDepth;
	
	
	public RgbColor(int bitDepth, int red, int green, int blue) {
		if(0<bitDepth && bitDepth<32) {
			this.bitDepth=bitDepth;
			/*if(bitDepth==31) {
				if(0<=red && red <= (IntMath.powerOfTwo(this.bitDepth)-1)) {
					this.red=red;
				}
				if(0<=blue && blue <= (IntMath.powerOfTwo(this.bitDepth)-1)) {
					this.blue=blue;
				}
				if(0<=green && green <= (IntMath.powerOfTwo(this.bitDepth)-1)) {
					this.green=green;
				}
			}*/
			//else {
				if(0<=red && red <= (IntMath.powerOfTwo(this.bitDepth)-1)) //Gueltigkeit pruefen
					this.red=red;
				else 
					ExceptionUtil.unsupportedOperation("Fehler,weil rotAnteil ungültig ist ");
				
				if(0<=blue && blue <= (IntMath.powerOfTwo(this.bitDepth)-1)) 
					this.blue=blue;
				else 	
					ExceptionUtil.unsupportedOperation("Fehler,weil rotAnteil ungültig ist ");
				
				if(0<=green && green <= (IntMath.powerOfTwo(this.bitDepth)-1)) 
					this.green=green;
				else
					ExceptionUtil.unsupportedOperation("Fehler,weil rotAnteil ungültig ist ");
			//}
		}
		else {
			ExceptionUtil.unsupportedOperation("Fehler,weil bitDepth ungültig ist ");
		}
	}
	public int getRed() {
		return this.red;
	}
	
	public int getGreen() {
		return this.green;
	}
	
	public int getBlue() {
		return this.blue;
	}
	
	public int getBitDepth() {
		return this.bitDepth;
	}
	
	//Methode;
	public RgbColor8Bit toRgbColor8Bit() {
		int redK=this.getRed();
		int greenK=this.getGreen();
		int blueK=this.getBlue();
		
		if(this.bitDepth==8) {
			return new RgbColor8Bit(this.red,this.green,this.blue);
		}
		
		else if(this.bitDepth>8) {
			
			int Differenz=bitDepth-8-1;
			int lastBit;
			redK /=(IntMath.powerOfTwo(Differenz));
			lastBit=redK%2;
			redK/=2;
			if(lastBit==1 && redK<255) {
				redK+=1;
			}
			
			blueK /=(IntMath.powerOfTwo(Differenz));
			lastBit=blueK%2;
			blueK/=2;
			if(lastBit==1 && blueK<255) {
				blueK+=1;
			}
			
			greenK /=(IntMath.powerOfTwo(Differenz));
			lastBit=greenK%2;
			greenK/=2;
			if(lastBit==1 && greenK<255) {
				greenK+=1;
			}
			
			return new RgbColor8Bit(redK,greenK,blueK);
		}
		else {
			
			if(this.bitDepth==3 || this.bitDepth==5 || this.bitDepth==7) {
			
				int Differenz1=8-this.bitDepth;
				int Diff1kopie=0;
				
				while(Differenz1>0) {
					Differenz1-=this.bitDepth;	
					
				}
				
				Diff1kopie=-Differenz1;
				Differenz1=8-this.bitDepth-Differenz1;
				while(Differenz1!=0) {
					redK+=this.red*IntMath.powerOfTwo(Differenz1);
					greenK+=this.green*IntMath.powerOfTwo(Differenz1);
					blueK+=this.blue*IntMath.powerOfTwo(Differenz1);
					Differenz1-=this.bitDepth;	
				}
				redK/=IntMath.powerOfTwo(Diff1kopie);
				greenK/=IntMath.powerOfTwo(Diff1kopie);
				blueK/=IntMath.powerOfTwo(Diff1kopie);
			}
			else {
				int Differenz2=8-this.bitDepth;
				System.out.println(this.red);
				while(Differenz2>0) {
					redK+=this.red*IntMath.powerOfTwo(Differenz2);
					greenK+=this.green*IntMath.powerOfTwo(Differenz2);
					blueK+=this.blue*IntMath.powerOfTwo(Differenz2);
					Differenz2-=this.bitDepth;	
				}
			}
			return new RgbColor8Bit(redK,greenK,blueK);
		}
	}	
	public static void main(String[] args) {}
}
