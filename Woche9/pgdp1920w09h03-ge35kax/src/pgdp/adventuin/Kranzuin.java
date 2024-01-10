package pgdp.adventuin;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.IntStream;
//Frage: was passiert, wenn es nur 1 Frage mit nur 1 Zahl gibt, dann was kann man zurueckgeben????

public final class Kranzuin {
	public static final Kranzuin JULIAN=new Kranzuin();
	private Kranzuin(){
		
	};
	public int beantworteFragen(List<String> listString) {
		int result;
		List<Boolean>check=new LinkedList<Boolean>();//check, ob es einen Zahl gibt, die größer gleich 15 ist und die von mindestens einem relevante-Frage-String ganzzahlig durch dessen Länge teilbar ist
		List<Integer> listLaenge=new LinkedList<Integer>();
		List<String> listFrage=new LinkedList<String>();
		listString.stream().forEach(str->{
			if(str.contains("Blätter")|| str.contains("Aufgaben")||str.contains("Anzahl")) 
				listFrage.add(str);
		});
		List<Integer>listZahlen=new LinkedList<Integer>();
		List<Integer> ZahlenJederFrage=new LinkedList<Integer>();
		List<Integer> checkTeilbar=new LinkedList<Integer>();
		
		
		if(listFrage.isEmpty()) //es gibt keine Frage
			return Integer.MAX_VALUE;
		
		else { //es gibt mindestens 1 Frage
			listFrage.stream().forEach(str->{
				str = str.replaceAll("[ ]", ",");// andern alle leerzeichen in ,
		        str=str.replaceAll("[^0-9\\,]","");//remove alle Zeichen, die nicht Zahlen oder ","
		        String[] zahlen = str.split(",");
		        for (int i = 0; i < zahlen.length; i++) {
		            try {
		            	Integer.parseInt(zahlen[i]);
		            	listZahlen.add(Integer.parseInt(zahlen[i]));
		            } 
		            catch (NumberFormatException e) {
		            }
		       }	
		       if(listZahlen.size()==1)
		    	   ZahlenJederFrage.add(listZahlen.get(0));
		       if(listZahlen.size()>1) {
		    	   	Integer min=listZahlen.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
		        	Integer max=listZahlen.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
		        	ZahlenJederFrage.add((min+max)/2);
		       }
			});
			if(ZahlenJederFrage.isEmpty()) {
				result=ThreadLocalRandom.current().ints(15,2000).filter(new IntPredicate() {

					@Override
					public boolean test(int value) {
						// TODO Auto-generated method stub
						listFrage.stream().forEach(frage->{
							listLaenge.add(frage.length());
						}
						);
						listLaenge.stream().forEach(laenge->{
							if(value%laenge==0) {
								check.add(true);
							}
						});
						if(!check.isEmpty())
							return true;
						else
							return false;
					}
					
				}).findFirst().getAsInt();
				listFrage.forEach(frage->{
					if(result%frage.length()==0) 
						checkTeilbar.add(1);
				});
				if(checkTeilbar.size()==1)
					return result;
				else {
					listFrage.stream().forEach(frage->listLaenge.add(frage.length()));
					return 15+listLaenge.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
				}
					
			}
			else{
				Integer minZahlen=ZahlenJederFrage.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
				if(minZahlen<15) 
					return 1783;
				else {
					return minZahlen;
				}
				
			}
	        
		}
		/*listFrage.stream().forEach(str-> { //bat dau o 
			str = str.replaceAll("[ ]", ",");// andern alle leerzeichen in ,
	        str=str.replaceAll("[^0-9\\,]","");//remove alle Zeichen, die nicht Zahlen oder ","
	        String[] zahlen = str.split(",");
	        for (int i = 0; i < zahlen.length; i++) {
	            try {
	            	Integer.parseInt(zahlen[i]);
	            	listZahlen.add(Integer.parseInt(zahlen[i]));
	            } 
	            catch (NumberFormatException e) {
	            }
	       }
	        if(!listZahlen.isEmpty()|| listZahlen.size()!=1) {
	        	Integer min=listZahlen.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
	        	Integer max=listZahlen.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
	        	ZahlenJederFrage.add((min+max)/2);
	        	
	        }
	        if(listZahlen.size()==1) {
	        	ZahlenJederFrage.add(listZahlen.get(0));
	        }
		});	
		if(listFrage.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		else if(ZahlenJederFrage.isEmpty()) {
		
			result=ThreadLocalRandom.current().ints(15,2000).filter(new IntPredicate() {

				@Override
				public boolean test(int value) {
					// TODO Auto-generated method stub
					listFrage.stream().forEach(frage->{
						listLaenge.add(frage.length());
					}
					);
					listLaenge.stream().forEach(laenge->{
						if(value%laenge==0) {
							check.add(true);
						}
					});
					if(!check.isEmpty())
						return true;
					else
						return false;
				}
				
			}).findFirst().getAsInt();
			return result;
		}
		else {
			Integer min=ZahlenJederFrage.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
			if(min<15) 
				return 1783;
			else
				return min;
		}*/ //xoa o day
		
	}
	public static void main(String[]args) {
		
		
        String str = "-1.223 %^& fsf 0.234 56.65 fsf 9 f";
        String str1="abc12m3 56 78f10";
        
        str1 = str1.replaceAll("[ ]", ",");
        str1=str1.replaceAll("[^0-9\\,]","");
        //System.out.println(Integer.parseInt("ab"));
        System.out.println(str1);
        /** cat thanh cac phan tu thong qua dau phay */
        String[] item = str1.split(",");
        
        // duyet cac phan tu, neu la so thi in ra
        for (int i = 0; i < item.length; i++) {
        	
        try {
        	//Double.parseDouble(s)
        Double.parseDouble(item[i]);
        System.out.println(item[i]);
        } catch (NumberFormatException e) {
        }
        }
        //System.out.println(ThreadLocalRandom.current().ints(15, 20).filter(x->x%7==0).findFirst().getAsInt());
        
        }
	
        
        
	
}
