package pgdp.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ontap {
	
		 int data=50;  
		  
		 void change(int data){  
			 System.out.println(data);
			 
			 data=data+100;//changes will be in the local variable only  
			 System.out.println(data);
		 }  
		 
		 void f(int[] array) { 
			 array[0] = 19;
			 array = new int[] {42};
		 }
		 void g() {
		 int[] array = new int[1]; 
		 f(array);
		 
		
		 }
		 
		 public class hahaha{
				int hn;
				int b;
				
		}
		 
		
		 public static void main(String args[]) throws IOException{  
		   ontap op=new ontap();  
		  
		   System.out.println("before change "+op.data);  
		   op.change(500);  
		   System.out.println("after change "+op.data);  
		   int[] a =new int[5];
		   op.f(a);
		   int bint=5;
		   op.change(bint);;
		   System.out.println(bint);
		   System.out.println(a[0]); 
			 class hahaha {
				int haha1;
				
			}
			 BufferedReader g=new BufferedReader(new InputStreamReader(System.in)); 
			 if(g.readLine().equals("exis")) {
				 System.out.println("fell");
				 
			 }
			 PrintWriter h;
			 h.fl
		 } 
		 
}
