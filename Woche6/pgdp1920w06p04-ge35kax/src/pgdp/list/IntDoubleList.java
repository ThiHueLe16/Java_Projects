package pgdp.list;

public class IntDoubleList {
	private IntDoubleListElement head;// das erste Element von Listtenelemt
	private IntDoubleListElement tail;//etzte (tail) Element der Liste
	
	
	
	public IntDoubleList() { 
		//Am Anfang hat die Liste kein Element
		head=null;
		tail=null;
	}
	
	public IntDoubleListElement getFirstElement() {
		return head;
	}
	
	public IntDoubleListElement getLastElement() {
		return tail;
	}
	
	public void append(int info){
		IntDoubleListElement neuElement = new IntDoubleListElement(info);
		if(head==null) {
			head=neuElement;
			tail=neuElement;
		}
		else {
			tail.next=neuElement;//???? hoi: mo hinh cua cai doublelistelemnt nay la sao, cau tao nhu nao
			neuElement.prev=tail;
			tail=neuElement;
		}
	}
	
	public int size() { //ie die Anzahl der Elemente einer Liste zurückgibt.
		IntDoubleListElement temp = head;
        int j = 0;
        // Zahlen wieviele Elemente es gibt, bis null erreicht wird
        while (temp != null) {
            temp = temp.next;
            j++;
        }
        return j;
	}
	
	public int get(int pos) { //die den info-Wert des Elements an der Position pos zurückgibt
		//int Wert=0;
		if(pos<0|| this.size()<=pos) { //??? this.size, this o day la gi
			System.out.println("gibt keine Zahl in dieser postion");
			return 0;
		}
		IntDoubleListElement a=head;
		for(int i=0;i<pos;i++) {
			a=a.next;
			//Wert=a.getInfo();
		}// kann auch so schreiben, kuerzer:
		//for(int i=0; i<pos;i++, a=a.next)
		//;
		
		//return Wert;
		return a.getInfo();
	}
	
	public void remove(int pos){
		int ikopie=0;
		for(int i=0;i<pos;i++,ikopie=i) 
		;	
		// ?????????giang lai phan mo hinh cua remove
	}
	
	public String toString() { ////???? hoi stringbuilder
        IntDoubleListElement temp = head;
        StringBuilder ret = new StringBuilder();
        // Liste iterieren
        while (temp != null) {
            // String iterativ konkatenieren
            ret.append(temp.getInfo());
            if (temp.next != null)
                // Komma hinzufuegen falls temp nicht das letze Element der List ist
                ret.append(',');
            temp = temp.next;
        }
        return ret.toString();//???? ret.toString la lam gi
    }
	
	
	//Zwei Listen gelten als gleich, wenn sie die gleichen Elemente in der gleichen Reihenfolge beinhalten.
	public boolean isEqual(IntDoubleList other) {
		IntDoubleListElement mytemp= head;
		IntDoubleListElement othertemp=other.head;
		
		while(mytemp!=null) {
			if(!mytemp.isEqual(othertemp)) 
				return false; // k dung ngoac trong if khi chi co 1 lenh tiep theo
				mytemp=mytemp.next;
				othertemp=othertemp.next;
		}
		return othertemp==null;
	}
	
	public int sum() { //die die Summe aller Listenelemente zurückgibt.
		int sumListe=0;
		IntDoubleListElement temp=head;
		if(temp==null) 
			return 0;
		else {
			while(temp!=null) {
				sumListe+=temp.getInfo();
				temp=temp.next; //???? temp.next se hoat dong the nao. next trong intdoulistElemt chi la 1 bien 
			}
		}
		return sumListe;
	}
	
	public IntDoubleList copy() {
		IntDoubleList neuList= new IntDoubleList();
		IntDoubleListElement mytemp= head;
		while(mytemp!=null) {
			neuList.append(mytemp.getInfo());// coi lai dong nay
			mytemp=mytemp.next;	
		}
		return neuList;
	}
	
	public IntDoubleListElement[] search(int intValue) {
		 IntDoubleListElement[] results = new IntDoubleListElement[this.size()];// tao 1 array co do dai bang liste de kiem nhung so bang voi value trong liste
	        int j = 0;
	        // temp hilft über die Elemente zu iterieren
	        IntDoubleListElement temp = head;
	        while (temp != null) {
	            // Wert in Kopie speichern
	            if (temp.getInfo() == intValue) {
	                results[j] = temp;
	                j++;
	            }
	            temp = temp.next;
	        }
	        IntDoubleListElement[] ret = new IntDoubleListElement[j];// tao 1 array moi co do dai bang so phan tu bang voi value, thi return k bi thua 
	        for (int k = 0; k < j; k++)
	            ret[k] = results[k];
	        return ret;
		
	}
}
