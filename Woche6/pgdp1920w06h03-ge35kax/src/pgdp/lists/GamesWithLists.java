package pgdp.lists;

import java.util.Scanner;

public class GamesWithLists {
		
  public static IntDoubleList reuniteLists(IntDoubleList[] arrayOfLists) {
    // TODO
	  IntDoubleList reList=new IntDoubleList();
	  IntDoubleList reListE=new IntDoubleList();
	  int h=0; int k=0;
	  if(arrayOfLists.length<=10000) {
		  for(int i=0; i<arrayOfLists[0].size();i++) { //die Relists wird am Anfang mit alle Element von arrOfList[0]intialisiert	  
			reList.append( arrayOfLists[0].get(i));
		  }
		  for(int i=1;i<arrayOfLists.length;i++) {//so sanh relist voi tung ptu trong array
			  h=0;k=0;
			  reListE=new IntDoubleList();
			while(h<reList.size()&& k<arrayOfLists[i].size()) { 
				  if(reList.get(h)<arrayOfLists[i].get(k)) {
					 reListE.append(reList.get(h));
					 h++;
				 }
				  else if(reList.get(h)>arrayOfLists[i].get(k)) {
						reListE.append(arrayOfLists[i].get(k));
						k++;
				  }
				  else {
					  	reListE.append(arrayOfLists[i].get(k));
						k++;
						reListE.append(reList.get(h));
						h++;
				  }
			}
			while(h<reList.size()) {
				reListE.append(reList.get(h));
				h++;
			}
			while(k<arrayOfLists[i].size()) {
				reListE.append(arrayOfLists[i].get(k));
				k++;
			}
			reList=reListE.copy();
			
		  }
	  }
	  return reListE; 
  }
	 /* IntDoubleList reList=new IntDoubleList();
	  IntDoubleList reListE=new IntDoubleList(); 
	  int h=0; int k=0;
	  if(arrayOfLists.length<=10000) {
		  for(int i=0; i<arrayOfLists[0].size();i++) { //die Relists wird am Anfang mit alle Element von arrOfList[0]intialisiert	  
				reList.append( arrayOfLists[0].get(i));
			  }
		  for(int i=1;i<arrayOfLists.length;i++) {
			  while(reList.head.getInfo()< arrayOfLists[i].head.getinfo()) {
				  
			  }
		  }
	  }*/
   

  public static IntDoubleList partTheList(IntDoubleList list, int value) {
    // TODO
	  IntDoubleList paListE=new IntDoubleList();
	  if(list.size()<=10000) {
		   for(int i=0; i<list.size();i++) {
			   if(list.get(i)<value) {
				   paListE.append(list.get(i));
				   list.remove(i);
				   i=i-1;
			   }
		   }
		   for(int i=0; i<list.size();i++) {
			   paListE.append(list.get(i));
		   }
	  }
	  
    return paListE;
  }

  public static IntDoubleList mixedList(IntDoubleList list) {
    // TODO
	  IntDoubleList mixListE=new IntDoubleList(); 
	  int m=0;
	  int n=list.size()-1;
	  while(m<list.size() && n>0) {
		  n=list.size()-1;//nach jeder schleife wird size von list geaendert, n ist auch geaendert.
		  mixListE.append(list.get(m));
		  mixListE.append(list.get(n));
		  list.remove(m);
		  list.remove(n-1);
		  n=list.size()-1;//nach jeder schleife wird size von list geaendert, n ist auch geaendert.
	  }
	  if(m<list.size()) {
		  mixListE.append(list.get(m));
		  list.remove(m);
	  }
	  return mixListE;
  }
}
