package pgdp.oop;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.io.File;

public abstract class Animal {
  protected int x, y;
  static String filename;
  protected File f;
  protected Image image;

  protected static Animal[][] antarktis;//static: bien cua class, k phai cua tung objekt. muon goi thi phai class.name: z.B animal.antarktis
  
  public boolean alive;//new
//new

  public Animal(int x, int y) {
    this.x = x;
    this.y = y;
    alive=true;
  }
  
  
  public boolean checkNachbarn(int a, int b) { //check, ob Nachbarn von Futter this. fressen kann
	  int[][]direction=new int[][]{ { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	  for(int i=0;i<4;i++) {
		  
			int newX=a+direction[i][0];
			int newY=b+direction[i][1];
			if(newX<0) {
			   		newX=antarktis.length-1;
			   	}
			if(newX>antarktis.length-1) newX=0;
			if(newY<0) newY=antarktis.length-1;
			if(newY >antarktis[0].length-1) newY=0;
			if(Animal.antarktis[newX][newY]!=null &&Animal.antarktis[newX][newY].canEat(this)) {//check nachbarn von Futter
				return false;
			}
	  }
	  return true; 
  }
  
  public void move() {
    int[][]direction=new int[][]{ { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    boolean schonmove=false;
    for(int i=0; i<4;i++) {
    	int newX=x+direction[i][0];
    	int newY=y+direction[i][1];
    	
    	
	    if(newX<0) {
	   		newX=antarktis.length-1;
	   	}
	   	if(newX>antarktis.length-1) newX=0;
	   	if(newY<0) newY=antarktis.length-1;
    	if(newY >antarktis[0].length-1) newY=0;

    	if(Animal.antarktis[newX][newY]!=null &&this.canEat(Animal.antarktis[newX][newY]) && this.checkNachbarn(newX,newY)){//check futter
    		Animal.antarktis[x][y]=null; //
    		x=newX;
    		y=newY;
    		Animal.antarktis[newX][newY].alive=false;
    		Animal.antarktis[newX][newY]=this;
    		schonmove=true;
    		break;// endet for
    	}
    }
    if(!schonmove) { //Falls sie sich auf kein Feld mit Futter bewegen können, so bewegen sie sich auf das erste erlaubte Feld 
    	for(int i=0; i<4;i++) {
    		int newX=x+direction[i][0];
        	int newY=y+direction[i][1];
        	
        	
    	    if(newX<0) newX=antarktis.length-1;
    	   	if(newX>antarktis.length-1) newX=0;
    	   	if(newY<0) newY=antarktis[0].length-1;
        	if(newY >antarktis[0].length-1) newY=0;
        	
        	if(Animal.antarktis[newX][newY]==null && this.checkNachbarn(newX,newY)){//check 
        		Animal.antarktis[x][y]=null;
        		x=newX;
        		y=newY;
        		Animal.antarktis[newX][newY]=this;
        		break;// endet for
        	}
    	}
    }
  }
  public boolean catchPlayer() {
	  return false;
  }

  public abstract boolean canEat(Animal animal);

  protected abstract boolean eatenBy(Penguin penguin);
  protected abstract boolean eatenBy(PlayerPenguin playerPenguin);
  protected abstract boolean eatenBy(Whale whale);
  protected abstract boolean eatenBy(LeopardSeal leopardSeal);
  protected abstract boolean eatenBy(Fish fish);

  public static void setAntarktis(Animal[][] antarktis) {
    Animal.antarktis = antarktis;
  }
  // Graphics Stuff - You don't have to do anything here

  private void paintSymbol(Graphics g, Color c, int height, int width) {
    GradientPaint gradient = new GradientPaint(15, 0, c, width, 0, Color.LIGHT_GRAY);
    ((Graphics2D) g).setPaint(gradient);
    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.fillOval((int) (width * 0.3), (int) (height * 0.3), (int) (width * 0.5),
        (int) (height * 0.5));
  }

  public void draw(Graphics g, int height, int width) {
    if (image == null) {
      paintSymbol(g, Color.YELLOW, height, width);
      return;
    }
    ((Graphics2D) g).drawImage(image, 0, 0, width, height, 0, 0, image.getWidth(null),
        image.getHeight(null), null);
  }
}
