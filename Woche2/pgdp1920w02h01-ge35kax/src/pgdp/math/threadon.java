package pgdp.math;

import java.util.List;

public class threadon extends Thread {
	    int h=0; 
	    public void run() {
	        super.run();
	        System.out.println(Thread.currentThread().getName() + " đang chạy.");
	        try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Kết thúc " + Thread.currentThread().getName());
	        
	    }
	   
	     public static void main(String[]args ) {
	    	 
	    	 
	    	 List a=List.of(1,2,3,4,5);
	    	Stream<String>a;
	    	PrintWriter p;
	    	p.pri
	    	
	     }
}
