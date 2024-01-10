package pgdp.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Stream;


public class Penguin {
  private List<Geo> locations;
  private String trackID;

  public Penguin(List<Geo> locations, String trackID) {
    this.locations = locations;
    this.trackID = trackID;
  }

  @Override
  public String toString() {
    return "Penguin{" +
        "locations=" + locations +
        ", trackID='" + trackID + '\'' +
        '}';
  }

  public List<Geo> getLocations() {
    return locations;
  }

  public String getTrackID() {
    return trackID;
  }

  public String toStringUsingStreams() {
    // TODO
	
	
	/*Stream<Geo> sorted = locations.stream().sorted(new Comparator<Geo>(){

		@Override
		
		public int compare(Geo pengu1, Geo pengu2) {
			if(pengu1.latitude!=pengu2.latitude) 
				return (int)(-pengu1.latitude +pengu2.latitude);
				
			else {
				return (int)(-pengu1.longitude+pengu2.longitude);
			}
			
		}
	});*/
	 Stream<Geo> sorted=locations.stream().sorted(Comparator.comparing(Geo::getLatitude).thenComparing(Geo::getLongitude).reversed());
	
	
	List<String> geoNeu=new ArrayList<String>();
	sorted.forEach(s-> geoNeu.add(s.toString()));
	
	return "Penguin{locations=" + geoNeu.toString()+", trackID='"+this.trackID+"'}" ;
  }
  public static void main(String[]args) {
	  List<Geo> list=new  ArrayList<Geo>();
	  Geo d=new Geo(-42.989719,3);
	  Geo b=new Geo(-42.989811,-5);
	  Geo c=new Geo(3,1);
	  list.add(d);
	  list.add(b);
	  list.add(c);
	  Penguin pen=new Penguin(list,"pp");
	  
	  System.out.println(pen.toStringUsingStreams());
	  
	  
  }
	
	
 
}
