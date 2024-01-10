package pgdp.collections;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class PenguinColony {

    private HashSet<Penguin> penguins;

    public PenguinColony(HashSet<Penguin> penguins) {
        this.penguins = penguins;
    }

    public HashSet<Penguin> getPenguins() {
        return penguins;
    }

    public void setPenguins(HashSet<Penguin> penguins) {
        this.penguins = penguins;
    }

    public void uniteColonies(PenguinColony otherColony) {
        // TODO
    	for(Penguin penguin: otherColony.penguins)
    		penguins.add(penguin);
    	for(Penguin penguinOther: otherColony.penguins)
    		otherColony.penguins.remove(penguinOther);
    }

    public PenguinColony splitColony(Predicate<? super Penguin> pred) {
        // TODO
    	HashSet<Penguin> penPredAccept=new HashSet<>();
    	PenguinColony penguinPred=new PenguinColony(penPredAccept);
    	for(Penguin penguin: penguins) {
    		if(pred.test(penguin)) {
    				penPredAccept.add(penguin);
    		}
    	}
    	for(Penguin penguin: penPredAccept)
    		penguins.remove(penguin);	
        return penguinPred;
    }

    public Penguin findFirstFriend(LinkedList<Penguin> penguinFriends) {
        // TODO
    	for(Penguin penguin: penguinFriends) {
    		if(penguins.contains(penguin)) {
    			return penguin;
    		}
    	}
    	return null;
    }

    public boolean canFeedPenguinsWithProperty(Predicate<? super Penguin> pred, Set<Fish> fishes) {
        // TODO
    	Set<Fish> alleLieblingFish= new HashSet<>();
    	for(Penguin penguin: penguins) {
    		if(pred.test(penguin))
    			alleLieblingFish.add(penguin.getFavoriteFish());
    	}
    	return fishes.containsAll(alleLieblingFish);
        
    }

    public int computeSum(Function<? super Penguin, Integer> fun) {
        // TODO
    	int result=0;
    	for(Penguin penguin:penguins) {
    		result+=fun.apply(penguin);
    	}
        return result;
    }
    public static void main(String[]args) {	 }

}
