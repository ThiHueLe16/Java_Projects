package pgdp.iter;

import java.util.Iterator;

public class Range implements Iterable<Integer>{
	
	private final int begin, end, stride;
	
	public int getBegin() {
		return this.begin;
	}
	
	public int getEnd() {
		return this.end;
	}
	
	public int getStride() {
		return this.stride;
	}
	
	public Range(int begin, int end, int stride) {
		this.begin=begin;
		this.end=end;
		
		if(stride<=0)
			Util.badArgument("stride ist kleiner oder gleich 0");
		this.stride=stride;
	}
	
	public Range(int begin, int end) {
		this.begin=begin;
		this.end=end;
		stride=1;
	}
	
	public Iterator<Integer> iterator(){	
		  //anonyme Klasse
			// phair nawm trong class anonym, neu k ite khi tdoi ben trong anonymclass se lam thay doi ite cua class chinh range => fehler

			
			
			if(begin<end) { // luu y 
				return new Iterator<Integer>() { 
					private int ite=begin;
				@Override
				public boolean hasNext() {
					if(ite<=end)
						return true;
					return false;
				}
				
				@Override
				public Integer next() {
					if(ite>end) {
						Util.noSuchElement("Es gibt kein Element mehr");
						return null;
					}
					else {
						ite+=stride;
						return ite-stride;
						}
				}	
				};
			}
			
			
			else if(begin>end) {
				return new Iterator<Integer>(){ 
					private int ite=begin;
					
					public boolean hasNext() {
						if(ite>=end)
							return true;
						return false;
					}
					
					public Integer next() {
						if(ite<end) {
							Util.noSuchElement("Es gibt kein Element mehr");
							return null;
						}
						else {
							ite-=stride;
							return ite+stride;
						}
					}
				};
			}
			
			else {
				return new Iterator<Integer>(){ 
					private int ite=begin;
					public boolean hasNext() {
						return ite==begin;
					}
					public Integer next() {
							ite+=stride;
							return ite-stride;
					}
				};
		}
	}
	public static void main(String[] args) {
		Range range = new Range(-4, -13, 3);
		Iterator<Integer> iter = range.iterator();
		
		while(iter.hasNext()) {
			
			System.out.println(iter.next());
			
		}
	
		
	}
}



