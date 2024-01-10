package pgdp.list;

public class IntDoubleListElement { //ein Element von der Liste initialisiert
	
	private int info;
	
	// Konstruktor, der die Attribute private info, public next und public prev initialisiert
	public void setInfo(int inf) {
		this.info=inf;
	}
	public int getInfo() {
		return this.info;
	}
	public IntDoubleListElement prev;
	public IntDoubleListElement next;
	
	
	// Konstruktor, der die Attribute private info, public next und public prev initialisiert
	public IntDoubleListElement(int Infoanfang) {
		this.next=null;
		this.info=Infoanfang;
		this.prev=null;
	}
	
	public boolean isEqual(IntDoubleListElement other) {
		return other !=null &&this.info==other.info;
	}
	
	
	
}
