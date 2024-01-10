package pgdp.oop;

import java.awt.Toolkit;
import java.io.File;

public class LeopardSeal extends Animal {
  static String filename = "leopard.png";

  public LeopardSeal(int x, int y) {
    super(x, y);

    f = new File(filename);
    image = Toolkit.getDefaultToolkit().getImage(f.getAbsolutePath());
  }

  public boolean canEat(Animal animal) {
    return animal.eatenBy(this);
  }
  public boolean catchPlayer() {
	  return true;
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
}
