package pgdp.math;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Point2D implements Comparable<Point2D> {
		private double x, y, d = 0;
		public Point2D(double x, double y) {this.x = x; this.y = y;} public double getX() {return x;}
		public double getY() {return y;}
		public double getDistance() {return d;}
		public void setDistance(double d) {this.d = d;}
		public String toString() {return "x: "+x+", y: "+y+", d: "+d;} public int compareTo(Point2D point) {
		if (point.getDistance() < getDistance()) return 1;
		else if (point.getDistance() > getDistance()) return -1; return 0;
		
		
		} 
		public static Stream<String> iterateLinesFromFile(File csvFile) {
			// try-with-resources Statement schließt den BufferedReader automatisch 
			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			      return br.lines().collect(Collectors.toList()).stream();
			    } catch (IOException e) {
			      e.printStackTrace();
			      return null;
			    }
			}
		
		    public static void main(String[] args) {
		// // // // //
		if (args.length < 2) { // Fehlerbehandlung nicht gefordert??? System.out.println("usage: Main <csvFileName> <threshold>"); return;
		}
		File csvFile = new File(args[0]); // Dateiname zu Datei-Objekt
		double threshold = Double.parseDouble(args[1]); // String zu double
		/* Punkte aus Datei einlesen und als Liste (java.util.List) von 􏰁→ Point2D-Objekten zwischenspeichern: */
		Stream<String> lines = iterateLinesFromFile(csvFile);
		List<Point2D> points = lines.map(s -> {
		    String[] values = s.split(";");
		    double x = Double.valueOf(values[0]);
		    double y = Double.valueOf(values[1]);
		    return new Point2D(x, y);
		}).collect(Collectors.toList());
		/* Setze Attribut d (Distanz) f ̈ur jeden Punkt p auf den
		􏰁→ Manhatten-Abstand zwischen p und dem ersten Punkt der Liste: */
		Point2D first = points.get(0);
		points.stream().forEach(p -> p.setDistance(
		        Math.abs(p.getX() - first.getX()) +
		        Math.abs(p.getY() - first.getY())
		));
		/* Aufsteigende Sortierung nach Distanz erzeugen und anschließend
		􏰁→ diejenigen Punkte ausgeben, deren Distanz kleiner ist als der
		􏰁→ Grenzwert (Vertauschen von filter und sorted ist m ̈oglich): */
		points.stream()
		.sorted() // funktioniert hier ohne Parameter, da Point2D das // Interface Comparable<Point2D> implementiert, anderenfalls:
		    .sorted((p1, p2) -> {
		        if (p1.getDistance() > p2.getDistance())       return 1;
		        else if (p1.getDistance() < p2.getDistance())  return -1;
		        else   return 0;
		})
		    .filter(p -> p.getDistance() < threshold)
		    .forEach(System.out::println);
		 Iterable<Integer> a=new Iterable<Integer>() {

			@Override
			public Iterator<Integer>iterator() {
				
				// TODO Auto-generated method stub
				return new Iterator<Integer>() {

					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public Integer next() {
						// TODO Auto-generated method stub
						return null;
					}
					
				};
			}
			Iterable<Integer> b=()->{
				return new Iterator<Integer>(){

					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						return false;
					}

					@Override
					public Integer next() {
						// TODO Auto-generated method stub
						return null;
					}
					
				};
			};
				
				
			
		 };
		} }
		
		

