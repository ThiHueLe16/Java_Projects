package pgdp.streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTemperatures extends Temperatures {
    public StreamTemperatures(String filepath) {
        super(filepath);
    }

    public long size() {
    	
      //  return data.size();
      return stream().count();  
    }

    public List<LocalDate> dates() {
        return stream().map(Temperature::getDate).distinct().sorted().collect(Collectors.toList());
        
    }

    public Set<String> cities() {
    	
        return stream().map(Temperature::getCity).collect(Collectors.toSet());
    }

    public Set<String> countries() {
        return null;
    }

    public Map<String, List<Double>> temperaturesByCountry() {
    	Map<String, List<Double>> result=new HashMap<String,List<Double>>();
    	countries().forEach(c->result.put(c, new LinkedList<Double>()));
    	stream().forEach(temperature-> result.get(temperature).add(temperature.getTemperature()));
        return result;
    }

    @Override
    public String coldestCountryAbs() {
    	
       // return stream().min(Comparator.comparing(Temperature::getTemperature)).get().getCountry();
        	return stream().min(Comparator.comparing(Temperature::getTemperature)).get().getCountry();
    }

    @Override
    public String hottestCountryAbs() {
    	
        return stream().max(Comparator.comparing(Temperature::getTemperature)).get().getCountry();
    }

    @Override
    public Map<String, Double> countriesAvgTemperature() {
    	
        return null;
    }

   
    public Map<String, Double> avgTemperatureDeltaPerYearPerCountry() {//////////
        Map<String, List<Temperature>> tempsPerCountry = stream()
                .collect(Collectors.groupingBy(Temperature::getCountry));
        Map<String, Double> avgTempDeltaPerCountry = tempsPerCountry.entrySet()
                .stream().collect(Collectors.toMap(Entry::getKey, entry -> {
                    Map<Integer, List<Temperature>> tempsPerYear = entry
                            .getValue().stream()
                            .collect(Collectors
                                    .groupingBy(temperature -> temperature
                                            .getDate().getYear()));
                    double[] avgTempsPerYear = tempsPerYear.entrySet().stream()
                            .sorted(Comparator
                                    .comparing(entry2 -> entry2.getKey()))
                            .mapToDouble(entry2 -> entry2.getValue().stream()
                                    .mapToDouble(temp -> temp.getTemperature())
                                    .average().getAsDouble())
                            .toArray();
                    return IntStream.range(0, avgTempsPerYear.length - 1)
                            .mapToDouble(i -> avgTempsPerYear[i + 1]
                                    - avgTempsPerYear[i])
                            .average().getAsDouble();
                }));
        avgTempDeltaPerCountry.put("Globally", avgTempDeltaPerCountry.values()
                .stream().mapToDouble(it -> it).average().getAsDouble());
        return avgTempDeltaPerCountry;
    }

    public static void main(final String[] args) {
        String filepath = "temperaturesEurope1963Till2013ByCity.csv";
        StreamTemperatures temperatures = new StreamTemperatures(filepath);

        temperatures.printSummary();
        final Map<String, Double> values = temperatures
                .avgTemperatureDeltaPerYearPerCountry();

        print("Averaged yearly temperature delta per country:",
                Arrays.toString(values.entrySet().toArray()));
    }
    
    

}