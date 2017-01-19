package model;

import java.awt.Color;
import java.util.Random;

import utils.Utils;

public class Agent {
	private int x;
	private int y;
	private Color color;
	private int pasX;
	private int pasY;
	private Environement environement;
	private boolean moved;

	public Agent(int x, int y, Environement environement){
		Random rnd = new Random();
		if(Utils.seed != 0){
			rnd.setSeed(Utils.seed);
		}
		Color[] colorList = {Color.black,Color.blue,Color.cyan,Color.darkGray,Color.green,Color.magenta,Color.orange,
				Color.pink,Color.red,Color.yellow};
		int[] pas = {1,-1};
		this.color = colorList[rnd.nextInt(10)];
		this.x = x;
		this.y = y;
		pasX = pas[rnd.nextInt(2)];
		pasY = pas[rnd.nextInt(2)];
		this.environement = environement;
		System.out.println(this.x);
		System.out.println(this.y);
		System.out.println(this.color);
		System.out.println(this.pasX);
		System.out.println(this.pasY);
	}
	
	public int getPasX(){
		return this.pasX;
	}
	
	public int getPasY(){
		return this.pasY;
	}
	
	public void setPasX(int pasX){
		this.pasX = pasX;
	}
	
	public void setPasY(int pasY){
		this.pasY = pasY;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void update(){
		int newX = this.x + this.pasX;
		int newY = this.y + this.pasY;
		if(Utils.isThorique()){
			newX = (newX + Utils.grideSizeX) % Utils.grideSizeX;
			newY = (newY + Utils.grideSizeY) % Utils.grideSizeY;
		}
		environement.setAgent(this.x,this.y,null);
		this.x = newX;
		this.y = newY;
		environement.setAgent(newX, newY, this);
		
	}
	

	public void decide(){
		this.moved = true;

		// detecion du bord seulement si c'est pas thorique
		int newX = this.x + this.pasX;
		int newY = this.y + this.pasY;

		if(!Utils.isThorique()){
			if((newX == (-1)) || (newX == Utils.grideSizeX)){
				this.pasX = this.pasX * (-1);
			}
			if((newY == (-1)) || (newY == Utils.grideSizeY)){
				this.pasY = this.pasY * (-1);
			}
			newX = this.x + this.pasX;
			newY = this.y + this.pasY;
		}

		//detection de la collision
		if(Utils.isThorique()){
			newX = (newX + Utils.grideSizeX) % Utils.grideSizeX;
			newY = (newY + Utils.grideSizeY) % Utils.grideSizeY;
		}
		if(!environement.isEmpty(newX, newY)){
			echange(environement.getAgent(newX, newY));
		}else{
			update();
		}
	}

	public void echange(Agent agent){
		int aux = agent.getPasX();
		agent.setPasX(this.pasX);
		this.pasX = aux;
		aux = agent.getPasY();
		agent.setPasY(this.pasY);
		this.pasY = aux;	}

	public boolean isMoved() {
		return moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	
}

