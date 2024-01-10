package pgdp.oop;

import java.awt.Toolkit;
import java.io.File;

public class Fish extends Animal {
  static String filename = "fish.png";

  public Fish(int x, int y) {
    super(x, y);

    f = new File(filename);
    image = Toolkit.getDefaultToolkit().getImage(f.getAbsolutePath());
  }

  public boolean canEat(Animal animal) {
    return animal.eatenBy(this);
  }
 protected boolean eatenBy(Penguin penguin) {
	// TODO Auto-generated method stub
		return true;
}

@Override
protected boolean eatenBy(PlayerPenguin playerPenguin) {
	// TODO Auto-generated method stub
	return true;
}

@Override
protected boolean eatenBy(Whale whale) {
	// TODO Auto-generated method stub
	return false;
}

@Override
protected boolean eatenBy(LeopardSeal leopardSeal) {
	// TODO Auto-generated method stub
	return true;
}

@Override
protected boolean eatenBy(Fish fish) {
	// TODO Auto-generated method stub
	return false;
}
public void move() {
	int[][]direction=new int[][]{ { 0, -1 }, { 1, 0}, { 0, 1 }, { -1, 0 } };
	for(int i=0; i<4;i++) {
    	int newX=x+direction[i][0];
    	int newY=y+direction[i][1];
    	
    	
	    if(newX<0) {
	   		newX=antarktis.length-1;
	   	}
	   	if(newX>antarktis.length-1) newX=0;
	   	if(newY<0) newY=antarktis.length-1;
    	if(newY >antarktis.length-1) newY=0;
    	
    	if(Animal.antarktis[newX][newY]==null && this.checkNachbarn(newX,newY)){//check
    		Animal.antarktis[x][y]=null;
    		x=newX;
    		y=newY;
    		Animal.antarktis[x][y]=this;
    		break;
    	}
    }
}


}
