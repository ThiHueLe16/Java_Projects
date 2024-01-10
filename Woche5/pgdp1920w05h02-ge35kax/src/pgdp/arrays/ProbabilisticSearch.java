package pgdp.arrays;

public class ProbabilisticSearch extends  MiniJava {
    /**
     * Binary Search aus der Vorlesung leicht abgewandelt
     */
	public static int[] find1(int[] a, int x) {
	        return find0(a, x, 0, a.length-1, 1);
	 }
	
	public static long[] Maxarray(long []a) {
		long[]result=new long[2];
		result[0]=a[0];//max von array
		result[1]=0;//Index von Maxelement
		for(int i=0; i<a.length;i++) {
			if(result[0]<a[i]) {
				result[0]=a[i];
				result[1]=i;	
			}
		}
		return result;
	}
	
	public static long summeArray(long []a) {
		int sumbinar=0;
		for(int i=0;i<a.length;i++) {
			sumbinar+=a[i];
		}
		return sumbinar;
	}
	
	
	public static long[] findorgbinar(int[] a, int x, int n1, int n2) {
		long[] resultbinar = new long[3] ;//Ausgbe , 0-Index=max ;1-Index: wo steht max; 2-Index: Summe der Aufrufe
		
		
		long [] binar=new long[a.length];// speichern Wert der Aufruf von jeden Element im Array
		for(int i=0; i<a.length;i++) { // alle Wert werden am Anfang mit 0 initialisiert
			binar[i]=0;
		}
		long[] maxbinar=new long[2];//max aufruf und index ausgeben
		maxbinar= Maxarray( binar);
		resultbinar[2]	= summeArray(binar);
		
		int t=(n1+n2)/2;
		if (a[t] == x) {
			binar[t]=binar[t]+1;
			resultbinar[2]= summeArray( binar);
			resultbinar[0]=maxbinar[0];
			resultbinar[1]=maxbinar[1];
	        return resultbinar;
		}
	    else if (n1 >= n2) {
	    	resultbinar[2]=summeArray( binar);
			maxbinar=Maxarray( binar);
			resultbinar[0]=maxbinar[0];
			resultbinar[1]=maxbinar[1];
	        return resultbinar;  
	    }
		
	    else if (x > a[t]) {
	    	for(int  i=t+1; i<=n2;i++) {
	    		binar[i]=binar[i]+1;
	    	}
	    	return findorgbinar(a, x, t+1, n2);
	    }
		else if(n1<t) {
			for(int i=n1;i<=t-1;i++) {
				binar[i]=binar[i]+1;
			}
	        return findorgbinar(a, x, n1, t-1);
		}
	    else { 
	    	maxbinar=Maxarray( binar);
			resultbinar[2]=summeArray(binar);
			resultbinar[0]=maxbinar[0];
			resultbinar[1]=maxbinar[1];
	        return resultbinar;  
	    }
	}
	
	
    public static int[] find (int[] a, int x, int n1,int n2) {
        return find0(a, x, n1, n2, 1);
    }

    public static int[] find0 (int[] a, int x, int n1, int n2, int numberOfSteps) {
        int t = (n1+n2)/2;
        if (a[t] == x)
            return new int[]{t, numberOfSteps};
        else if (n1 >= n2)
            return new int[]{-1, numberOfSteps};   
        else if (x > a[t])
            return find0 (a,x,t+1,n2, numberOfSteps + 1);
        else if (n1 < t)
            return find0 (a,x,n1,t-1, numberOfSteps + 1);
        else return new int[]{-1, numberOfSteps};
    }
    
    public static int exponent (int k) {
    	//oputput: das Ergebnis von 2^k
    	int expo=1;
    	if(k==0) {
    		return 1;
    	}
    	for(int i=1;i<=k;i++) {
    		expo=expo*2;
    	}
    	return expo;
    }
    
    public static int[] probalisticSearch(int[] arr,  int value) {
    	//tim khoang 
        // TODO
    	
    	int[]resultB=new int[2];
    	int[] result =new int[2];//const
    	
    	int k=1; //Schritte= k+1
    	boolean t=true;
    	int Position;
    	Position= Math.round((value-arr[0])/((arr[arr.length-1]-arr[0])/(arr.length-1)));//const
    	
    	int sp=Position;//
    	int spkopie=sp;
    	
    	if(arr[Position]==value) {
    		result[0]=sp;
    		result[1]=k;
    		return result;
    		
    	}
    	
    	
    	if(arr[Position]<value) {
    	
	    	while(arr[sp]<value) {
	    			spkopie=sp;
	    			sp=Position + exponent(k)-1;
	    			++k;
	    	}
    		if(arr[sp]==value) {
    			result[0]=sp;
    			result[1]=k+1;
    			return result;
    		}
    		else {
    			resultB=find(arr,value,spkopie+1,sp-1);
    			result[0]=resultB[0];
    			result[1]=k +resultB[1]-1;
    			return result;
    		}	
    	}
    	
    	
    	if(arr[Position]>value) {
    	
    		while(arr[sp]>value && t==true) {
	    		t=false;
	    		spkopie=sp;
	    		sp=Position-(exponent(k)-1);
	    		if(sp>=0) {
	    		t=true;	
	    		}
	    		++k;
	    	}
    		
    		if(arr[sp]==value) {
    			result[0]=sp;
    			result[1]=k+1;
    			return result;
    		}
    		else {
    			resultB=find(arr,value,sp+1,spkopie-1);    			
    			result[1]=k+resultB[1]-1;
    			result[0]=resultB[0];
    			return result;
    		}
    	}
    	
        return new int[]{};
    }
    
    public static void compareApproaches(int[] arr, int min, int max) {
        // TODO
    	long[]ergebnis=new long[3];
    	int value=readInt();
    	ergebnis=findorgbinar( arr, value, min, max);
    	write("Binäre Suche:");
    	write("Maximale Anzahl an Aufrufen:");
    	write(ergebnis[0]);
    	write("Wert bei dem die maximale Anzahl an Aufrufen auftritt:");
    	write(ergebnis[1]);
    	write("Anzahl der gesamten Aufrufe:");
    	write(ergebnis[2]);
    }

    public static void main(String[] args) {
        // Not part of the exercise but can be helpful for debugging purposes
         int[] exampleArray = new int[]{6, 20, 22, 35, 51, 54, 59, 74, 77, 80, 87, 94};
         int[] a=new int[2];
         a=probalisticSearch(exampleArray, 75);
         write(a[0]);
         write(a[1]);
         compareApproaches(exampleArray,exampleArray[0],exampleArray[11]);
         
    }
}
