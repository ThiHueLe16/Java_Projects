package pgdp.oop;

import java.awt.event.WindowEvent;

public class Antarktis extends Maze {
    private static int width, height;
    private static Penguin lostPenguin;
    private static Whale[] whales = new Whale[16];
    private static LeopardSeal[] leopardSeals = new LeopardSeal[16];
    private static Fish[] fishes = new Fish[300];
    private static PlayerPenguin playerPenguin;

    public static void main(String[] args) {
        width = 41;
        height = 41;
        antarktis = generateMaze(width, height);
        setupMaze();
        Animal.setAntarktis(antarktis);
        gameLoop();
        // Close the opnend frame
        closeFrame();
    }

    private static void gameLoop() {
        boolean end=false;
    	while (!end) {
            draw();
            int pX=playerPenguin.x;
            int pY=playerPenguin.y;
            if(currentEvent==UP) {
            	pY=pY-1;
            }
            if(currentEvent==DOWN) {
            	pY=pY+1;
            }
            if(currentEvent==LEFT) {
            	pX=pX-1;
            }
            if(currentEvent==RIGHT) {
            	pX=pX+1;
            }
        	
    	    if(pX<0) {
    	   		pX=antarktis.length-1;
    	   	}
    	   	if(pX>antarktis.length-1) pX=0;
    	   	if(pY<0) pY=antarktis.length-1;
        	if(pY >antarktis.length-1) pY=0;
            end=playerPenguin.move(pX,pY);
            moveAll();
            if(!lostPenguin.alive) end=true;
           
            // TODO maybe
            currentEvent=NOTHING;
        }
    }

    private static void moveAll() {
        
        	 for (int i = 0; i < whales.length; i++) {
                if (whales[i].alive){
                	whales[i].move();
                }
             }

             for (int i = 0; i < leopardSeals.length; i++) {
               if(leopardSeals[i].alive) {
            	   leopardSeals[i].move();
               }
             }
             
             lostPenguin.move();
             for (int i = 0; i < fishes.length; i++) {
                if(fishes[i].alive) {
                	fishes[i].move();
                }
             }
        
    }

    /**
     * Example Setup for easier Testing during development
     */
    private static void setupMaze() {
        int[] pos;
        playerPenguin = new PlayerPenguin(3, 3);
        antarktis[3][3] = playerPenguin;

        for (int i = 0; i < whales.length; i++) {
            pos = getRandomEmptyField();
            whales[i] = new Whale(pos[0], pos[1]);
            antarktis[pos[0]][pos[1]] = whales[i];
        }

        for (int i = 0; i < leopardSeals.length; i++) {
            pos = getRandomEmptyField();
            leopardSeals[i] = new LeopardSeal(pos[0], pos[1]);
            antarktis[pos[0]][pos[1]] = leopardSeals[i];
        }

        for (int i = 0; i < fishes.length; i++) {
            pos = getRandomEmptyField();
            fishes[i] = new Fish(pos[0], pos[1]);
            antarktis[pos[0]][pos[1]] = fishes[i];
        }

        antarktis[20][20] = new Penguin(20, 20);
        lostPenguin = (Penguin) antarktis[20][20];
    }
}
