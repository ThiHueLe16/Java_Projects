package pgdp.store;

import java.util.HashMap;

import java.util.LinkedList;


import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

public class ScrewStore {
	private HashMap<Screw,Integer> storage;
	private LinkedList<Order> orders;
	
	public ScrewStore(){
		storage =new HashMap<>();
		orders = new LinkedList<>();
	}
	

    public void addItem(Screw type, int amount) {
    	Integer current=storage.get(type);//
    	if( current== null) { // gibt kein Schraube von diesem type im Storage
    		storage.put(type, amount);
    	}
    	else {
    		storage.put(type, amount+current);
    	}
    }

    public void takeOrder(Screw type, int amount) {
    	if(amount>0) {
    		orders.add(new Order(type,amount));
    	}
    }

    public boolean executeOrder() {
    	if(orders.isEmpty())
    		return false;
    	Order order=orders.getFirst(); // lay order dau tien trong list
    	Integer amount=storage.get(order.getScrew());//lay amount cua oder.screw trong storage 
    	if(amount!=null) {
    		if(amount==order.getAmount()) {
    			storage.remove(order.getScrew());
    			return true;
    		}
    		if(amount>order.getAmount()) {
    			storage.put(order.getScrew(),amount-order.getAmount());
    			return true;
    		}
    	}
    	
        return false;
    }

    public void inflation(double percent) {//
    	for (Screw key : storage.keySet())
            key.setPrice(key.getPrice() * (1 + percent));
    }
    /*
     * Loesung 2: alle Key nehmen mit Iterator()
     * Iterator<String> iterator = storage.keySet().iterator();
     * while(iterator.hasNext()){
     * 		iterator.next()=iterator.next()*
     * }
     */
    

    public int count() {//
    	int count = 0;
        for (Integer i : storage.values())
            count += i;
        return count;
       
    }

    public double value() {
    	double value = 0;
        for (Entry<Screw, Integer> entry : storage.entrySet())
            value += entry.getKey().getPrice() * entry.getValue();
        return value;
    }

    public String storageToString() {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }


	public HashMap<Screw, Integer> getStorage() {
		return storage;
	}


	public void setStorage(HashMap<Screw, Integer> storage) {
		this.storage = storage;
	}


	public LinkedList<Order> getOrders() {
		return orders;
	}


	public void setOrders(LinkedList<Order> orders) {
		this.orders = orders;
	}

//    public HashMap<Screw, Integer> getStorage() {
//        return storage;
//    }
}
