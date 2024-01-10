package pgdp.w02.h02;

public class test {
	static int count=0;
	static int modulo_inverse(int n, int m) {
		  for (int i=1; i < m; i++) {
		    if (((long ) n * i) % m == 1) {
		      return i;
		    }
		  }
		  return -1; // not exist
		}
	int a=935;
	static void ordnung(int n,int m) {
			count++;
	
		while(true) {
			int b=935*n%m;
			int c=935*n-m*b;
			if(c==935) {
				break;
			}
			else {
				test.ordnung(c, m);
			}
		}
		
	}
	public static void main(String[]args) {
		//System.out.println(test.modulo_inverse(935, 1491));
		test.ordnung(935, 1491);
		System.out.println(count);
	}
	
}
