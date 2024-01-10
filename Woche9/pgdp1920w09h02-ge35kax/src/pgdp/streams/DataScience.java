package pgdp.streams;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
//import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
//import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.crypto.Data;

public class DataScience {
  public static Stream<Penguin> getDataByTrackId(Stream<PenguinData> stream) {
	 List<Penguin> listPenguin=new LinkedList<Penguin>();
	 List<String> allID=new LinkedList<String>();
	stream.forEach(data->{
		if(!allID.contains(data.getTrackID())) {
			allID.add(data.getTrackID());
			listPenguin.add(new Penguin(new LinkedList<Geo>(),data.getTrackID()));
		}
		listPenguin.stream().forEach(penguin->{
			if(penguin.getTrackID().equals(data.getTrackID())){
				penguin.getLocations().add(new Geo(data.getGeom().getLatitude(),data.getGeom().getLongitude()));
			}
		});
	});
	
	return listPenguin.stream();
	  
  }

  
  public static void outputPenguinStream() {
	
	  System.out.println(DataScience.getDataByTrackId(CSVReading.processInputFile()).count());
	  DataScience.getDataByTrackId(CSVReading.processInputFile()).sorted(Comparator.comparing(Penguin::getTrackID)).forEach(penguin->System.out.println(penguin.toStringUsingStreams()));
	  
	
	  
  }
  

  public static void outputLocationRangePerTrackid(Stream<PenguinData> stream) {
	 
	  Map<String,List<PenguinData>> mapPenguinProTrackID=stream.collect(Collectors.groupingBy(PenguinData::getTrackID));
	  mapPenguinProTrackID.keySet().stream().forEach(keyTrackID->{
		 List<PenguinData> listPenguinData=mapPenguinProTrackID.get(keyTrackID);
		 List<Double> listLongitude=new LinkedList<Double>();
		 List<Double> listLatitude=new LinkedList<Double>();
		 listPenguinData.forEach(penData->{
			 listLongitude.add(penData.getGeom().getLongitude());
			 listLatitude.add(penData.getGeom().getLatitude());
		 });
		  Double minLongitude=listLongitude.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
		  Double maxLongitude=listLongitude.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
		  Double minLatitude=listLatitude.stream().collect(Collectors.minBy(Comparator.naturalOrder())).get();
		  Double maxLatitude=listLatitude.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get();
		  Double avgLongitude=listLongitude.stream().mapToDouble(Double->Double).average().getAsDouble();
		  Double avgLatitude=listLatitude.stream().mapToDouble(Double->Double).average().getAsDouble();
		  System.out.println(keyTrackID);
		  System.out.println("Min Longitude: "+minLongitude+" Max Longitude: "+maxLongitude+" Avg Longitude: "+avgLongitude+" Min Latitude: "+minLatitude+" Max Latitude: "+maxLatitude+ " Avg Latitude: "+avgLatitude);
 	  });
	  
	  
  }
	  

  public static void main(String[] args) {
	  //DataScience.outputPenguinStream();
	  DataScience.getDataByTrackId(CSVReading.processInputFile());
	  DataScience.outputLocationRangePerTrackid(CSVReading.processInputFile());
   
  }
}