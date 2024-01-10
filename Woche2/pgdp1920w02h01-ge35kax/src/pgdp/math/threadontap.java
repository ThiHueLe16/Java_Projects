package pgdp.math;

import java.io.BufferedReader;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class threadontap {
	public static void main(String[] args) {
        threadon thread1 = new threadon();
        thread1.setName("Thread 1");
        thread1.start();    // khởi chạy thread 1
        threadon thread2 = new threadon ();
        thread2.setName("Thread 2");
        thread2.start();    // khởi chạy thread2
       
        
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       System.out.println("hallo");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
       
        
        threadon thread3 = new threadon();
        thread3.setName("Thread 3");
        thread3.start();    // khởi chạy thread3 
        
        try {
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BufferedReader br;
        br.lines().collect(Collectors.toList()).stream()
        Stream<String >a;
        a.map
    }
}
