package pgdp.oop;

public class PlayerPenguin extends Penguin {
    public PlayerPenguin(int x, int y) {
        super(x, y);
    }

    public boolean canEat(Animal animal) {
        return animal.eatenBy(this);
    }
    @Override
    protected boolean eatenBy(Penguin penguin) {
    	// TODO Auto-generated method stub
    	return false;
    }

    @Override
    protected boolean eatenBy(PlayerPenguin playerPenguin) {
    	// TODO Auto-generated method stub
    	return false;
    }

    @Override
    protected boolean eatenBy(Whale whale) {
    	// TODO Auto-generated method stub
    	return true;
    }

    @Override
    protected boolean eatenBy(LeopardSeal leopardSeal) {
    	// TODO Auto-generated method stub
    	return false;
    }

    @Override
    protected boolean eatenBy(Fish fish) {
    	// TODO Auto-generated method stub
    	return false;
    }
    public boolean catchPlayer() {
    	return false;
    }
    

    public boolean move(int newX, int newY) {
    	if(Animal.antarktis[newX][newY]!=null &&Animal.antarktis[newX][newY].catchPlayer()) {//endgame Bedingung 
    		return true;
    	}
    	Animal.antarktis[x][y]=null; //
		x=newX;
		y=newY;
		if(Animal.antarktis[newX][newY]!=null) Animal.antarktis[newX][newY].alive=false;
		Animal.antarktis[newX][newY]=this;
    	return false;
    }
}
