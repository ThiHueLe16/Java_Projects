package pgdp.strings;


public class MyString{
	private char[] data;
	private MyString next;
	
	
	public MyString(char[] data) {
		this.data=data;
		next=null;
	}
	
	public int length() {
		 int t=data.length;
		for(MyString a=next; a!=null; a=a.next) {
			t+=a.data.length;
		}
		return t;
	
	}
	 public void concat(char[] data) {
		 
		 if(next==null) {
			 next=new MyString(data); 
		 }
		 else {
			 MyString c=next;
			 while(c.next!=null){ 
				 c=c.next;
			 }
			 
			 c.next=new MyString(data); 
			
		 } 
	 }	
	 public String toString() {
		 String str=new String(data);
		 for(MyString t=next;t!=null;t=t.next) {
		 str+=new String(t.data);
		 }
		 
		 return str;
	 }
	 public boolean equals(MyString other) {
		 int le=data.length;
		 int i1=0;
		 int i2=0;
		 char[]array1=new char[le];
		 char[]array2=new char[le];
		 for(MyString a=next; a!=null; a=a.next) {
			 le+=a.data.length;
			 
		 }
		 System.out.println(le);
		 if(le!=other.length()) {
			 return false;
		 }
		 else {
			 
			 //kopieren alle Elemente von 1.String in 1 array
			for(int i=0; i<data.length;i++) {
				array1[i]=data[i];
				i1=i;
			}
			if(i1<le) {
				i1++;
			}
			for(int i=0;i<array1.length;i++) {
			System.out.println(array1[i]);}
			System.out.println(i1);
			for(MyString a=next; a!=null; a=a.next) {
				for(int i=0;i<a.data.length;i++) {
					array1[i1]=a.data[i];
					System.out.println(array1[i1]);
					i1++;
				}
			}
			//kopieren alle Elemente von 2.String in 1 array
			for(int i=0; i<other.data.length;i++) {
				array2[i]=data[i];
				
				i2=i;
			}
			
			for(MyString a=other.next; a!=null; a=a.next) {
				for(int i=0;i<a.data.length;i++) {
					array2[i2]=a.data[i];
					i2++;
				}
			}
			for(int i=0;i<le;i++) {
				if(array1[i]==array2[i]) {
					return true;
				}
			}
			return false;
			
		 }
	 }
	 public int indexOf(char c) {
		int index=0;
		for(int i=0;i<data.length;i=i+1) {
			if(data[i]==c) {
				index=i;
				return index;
			}
		}
		index=data.length;
		for(MyString a=next; a!=null; a=a.next) {
			for(int i=0; i<a.data.length;i++) {
				if(a.data[i]==c){
					index+=i;
					return index;
				}
			}
			index+=a.data.length;
		}
		return -1;
	 }
	 public int lastIndexOf(char c) {
		 int indexL=-1;
		
		 int gleich=0;//  Anzahl der gleichen Wert mit c in Array
		 int gleich1=0;//Anzahl der aktuellen Wert mit c 
		// rechnen die Anzahl der gleichen Wert mit c in Array
		 for(int i=0; i<data.length;i=i+1) {
			 if(data[i]==c) {
				 gleich++;
			 }
		 }
		 for(MyString a=next; a!=null; a=a.next) {
			 for(int i=0; i<a.data.length;i++) {
				 if(a.data[i]==c) {
					 gleich++;
				 }
			 }
		 }
		
		//Rechnen Lastindex
		 for(int i=0;i<data.length;i++) {
				if(data[i]==c) {
					indexL=i;
					gleich1++;
				}	
		}
		 if(gleich1==gleich) {
			 return indexL;
		 }
		indexL=data.length;
	
		for(MyString a=next; a!=null; a=a.next) {
			for(int i=0; i<a.data.length;i++) {
					if(a.data[i]==c) {
						indexL+=i;
						gleich1++;
					}
				}
				if(gleich1==gleich) {
					return indexL;
				}
				indexL+=a.data.length;
			}
			
		return -1;
		 
	 }
	
	public static void main(String[]args) {
		MyString str = new MyString(new char[]{'a','b','c','d'});
		
		str.concat(new char[]{'e','f'});
		str.concat(new char[]{});
		str.concat(new char[]{'e','m','k','p','q'});
		
		System.out.println(str.lastIndexOf('q'));
		str.toString();
		//System.out.println(str);*/
		//MyString str1 = new MyString(new char[]{'d','b','c','d'});
		//str1.concat(new char[]{'e','f'});
		//str1.concat(new char[]{'k'});
		//System.out.println(str1.indexOf('k'));
		//int b=str1.indexOf('e');
		//System.out.println(b);
		/*MyString str2 = new MyString(new char[]{'d','b','c','d'});
		str2.concat(new char[]{'e','f'});
		str2.concat(new char[]{'g'});
		System.out.println(str2.lastIndexOf('g'));*/
		//MyString str = new MyString(new char[]{'d','b','c','d'});
		//str.concat(new char[]{'e','f'});
		//str.concat(new char[]{'g'});
		//System.out.println(str.lastIndexOf('g'));
		
		//MyString str1 = new MyString(new char[]{'a','b','c','d'});
		//str1.concat(new char[]{'e','f'});
		//MyString str2 = new MyString(new char[]{'a','b','c','d','e','f'});
		//System.out.println(str1.equals(str2)); // true 
	}
}
 
