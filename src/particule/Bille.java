package particule;

import java.awt.Color;
import java.util.Random;

import core.Agent;
import utils.Utils;

public class Bille extends Agent{
	private Color color;
	
	public Bille(int x, int y, Surface surface){
		super(x,y,surface);
		
		Color[] colorList = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.green,Color.magenta,Color.orange, Color.pink,Color.red,Color.yellow};
		Random rdm = new Random();
		if(Utils.seed != 0){
			rdm.setSeed(Utils.seed);
		}
		this.color = colorList[rdm.nextInt(10)];
	}
	
	public void decide(){
		this.isMoved = true;
		
		// detecion du bord seulement si c'est pas thorique
		int i = this.x + this.pasX;
		int j = this.y + this.pasY;

		if(!Utils.isThorique()){
			if((i == (-1)) || (j == Utils.grideSizeX)){
				this.pasX = this.pasX * (-1);
			}
			if((j == (-1)) || (j == Utils.grideSizeY)){
				this.pasY = this.pasY * (-1);
			}
			i = this.x + this.pasX;
			j = this.y + this.pasY;

		}
		
		//detection de la collision
		if(Utils.isThorique()){
			i = (i + Utils.grideSizeX) % Utils.grideSizeX;
			j = (j + Utils.grideSizeY) % Utils.grideSizeY;
		}
		if(environement.getAgent(i, j) != null){
			echange(environement.getAgent(i, j));
		}else{
			update();
		}
	}

	
    public Color getColor(){
    	return this.color;
    }


}
