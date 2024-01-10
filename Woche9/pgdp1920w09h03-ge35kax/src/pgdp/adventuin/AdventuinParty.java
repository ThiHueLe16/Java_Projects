package pgdp.adventuin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import pgdp.color.RgbColor;
import pgdp.color.RgbColor8Bit;
//import pgdp.streams.Temperature;

public final class AdventuinParty {
    // TODO
	public static Map<HatType, List<Adventuin>> groupByHatType(List<Adventuin> listAdventuin){
		return listAdventuin.stream().collect(Collectors.groupingBy(Adventuin::getHatType));
	}
	
	public static void printLocalizedChristmasGreetings(List<Adventuin> listAdventuin) {
		listAdventuin.stream().sorted(Comparator.comparing(Adventuin::getHeight))
					.forEach(adventuin->System.out.println(adventuin.getLanguage().getLocalizedChristmasGreeting(adventuin.getName())));
		
	}
	
	public static Map<HatType, List<Adventuin>> getAdventuinsWithLongestNamesByHatType(List<Adventuin> listAdventuin){
		Map<HatType, List<Adventuin>> result=groupByHatType(listAdventuin);
		
		result.keySet().stream().forEach(HatType->{
			List<String> listNameJedeHattype = new LinkedList<String>();
			groupByHatType(listAdventuin).get(HatType).forEach(adventuin->listNameJedeHattype.add(adventuin.getName()));
			
			String longestName=listNameJedeHattype.stream().max(Comparator.comparing(String::length)).get();
			groupByHatType(listAdventuin).get(HatType).stream().forEach(adventuin->{
				if(adventuin.getName().length()!=longestName.length())
					result.get(HatType).remove(adventuin);
			});
			
			groupByHatType(listAdventuin).keySet().forEach(key->result.get(key).stream().forEach(p->System.out.println(p.getName())));
		});
		return result;
		
	}
	
	public static Map<Integer, Double> getAverageColorBrightnessByHeight(List<Adventuin> listAdventuin){
		Map<Integer, Double> result=new HashMap<Integer,Double>();
		List<Adventuin> listAdventuinCopy=new LinkedList<Adventuin>(); //erstellen neue Liste mit neu gerundete Height
		listAdventuin.forEach(adventuin->{
			
			listAdventuinCopy.add(new Adventuin(adventuin.getName(),Math.round((adventuin.getHeight()+5)/10)*10,adventuin.getColor(),adventuin.getHatType(),adventuin.getLanguage()));
		});
		
		Map<Integer,List<Adventuin>> mapAdventuinNachHeight =listAdventuinCopy.stream().collect(Collectors.groupingBy(Adventuin::getHeight));
		
		mapAdventuinNachHeight.keySet().stream().forEach(key->{
			List<Double> allHeight=new LinkedList<Double>();
			mapAdventuinNachHeight.get(key).stream().forEach(advent->{
				double neuHeight;
				RgbColor8Bit rgb=advent.getColor().toRgbColor8Bit();
				neuHeight=(0.2126*rgb.getRed()+0.7152*rgb.getGreen()+0.0722*rgb.getBlue())/255;
				System.out.println(neuHeight);
				allHeight.add(neuHeight);
			});
			result.put(key, allHeight.stream().mapToDouble(x->x).average().getAsDouble());
			
		});
		result.keySet().stream().forEach(p->System.out.println(p+"?"+result.get(p)));;
		return result;
	}
	
	public static Map<HatType, Double> getDiffOfAvgHeightDiffsToPredecessorByHatType(List<Adventuin> listAdventuin){
		Map<HatType, Double> result =new HashMap<HatType,Double>();
		Map<HatType,List<Adventuin>> mapNachHut= groupByHatType(listAdventuin);
		List<Integer> allHeight=new ArrayList<Integer>();
		List<Integer> negativeHoehenDifferenz=new LinkedList<Integer>();
		List<Integer> positiveHoehenDifferenz=new LinkedList<Integer>();
		
		
		mapNachHut.keySet().stream().forEach(hat->{
			mapNachHut.get(hat).stream().forEach(adventuin->allHeight.add(adventuin.getHeight()));
			
			allHeight.add(allHeight.get(0));
			
			IntStream.range(0, allHeight.size()-1).map(i->allHeight.get(i+1)-allHeight.get(i)).forEach(p->{
				System.out.println(p);
				if(p>0)
					positiveHoehenDifferenz.add(p);
				if(p<0)
					negativeHoehenDifferenz.add(p);
			});
			
			if(negativeHoehenDifferenz.isEmpty() && positiveHoehenDifferenz.isEmpty())
				result.put(hat, 0.0);
			else if(positiveHoehenDifferenz.isEmpty())
				result.put(hat, -negativeHoehenDifferenz.stream().mapToInt(i->i).average().getAsDouble());
			else if(negativeHoehenDifferenz.isEmpty())
				result.put(hat, positiveHoehenDifferenz.stream().mapToInt(i->i).average().getAsDouble());
			else
				result.put(hat, positiveHoehenDifferenz.stream().mapToInt(i->i).average().getAsDouble()-
						negativeHoehenDifferenz.stream().mapToInt(i->i).average().getAsDouble());
		});
		result.keySet().forEach(k->System.out.println(result.get(k)));
		return result;
		
		
	}
	public static void main(String[]args) {
		List<Adventuin> test=new LinkedList<Adventuin>();
		test.add(new Adventuin("AdvenTux", 100, new RgbColor(3, 2, 7, 0), HatType.FISHY_HAT, Language.ENGLISH));
		test.add(new Adventuin("Adven", 100, new RgbColor(3, 2, 7, 5), HatType.FISHY_HAT, Language.ENGLISH));
		test.add(new Adventuin("AdvenTuhhhhh", 100, new RgbColor(3, 2, 7, 6), HatType.FISHY_HAT, Language.ENGLISH));
		test.add(new Adventuin("Advenabchhhh", 110, new RgbColor(3, 5, 7, 0), HatType.FISHY_HAT, Language.ENGLISH));
		//Map<HatType, List<Adventuin>> maptest= getAdventuinsWithLongestNamesByHatType(test);
		//printLocalizedChristmasGreetings(test);
		//getAverageColorBrightnessByHeight(test);
		getDiffOfAvgHeightDiffsToPredecessorByHatType(test);
	}

}