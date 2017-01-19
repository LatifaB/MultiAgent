package core;

import java.util.Random;

import utils.Utils;

public abstract class Agent {
	protected int x;
	protected int y;
	protected int pasX;
	protected int pasY;
	protected boolean isMoved;
	protected Environement environement;
	
	public Agent(int x, int y, Environement environement){
		int[] pas = {1,-1};
		this.x = x;
		this.y = y;
		this.isMoved = false;
		this.environement = environement;
		Random rdm = new Random();
		if(Utils.seed != 0){
			rdm.setSeed(Utils.seed);
		}
		this.pasX = pas[rdm.nextInt(2)];
		this.pasY = pas[rdm.nextInt(2)];
		
	}
	
	public boolean isMoved(){
		return this.isMoved;
	}
	
	public void resetMoved(){
		this.isMoved = false;
	}
	
	
	protected void echange(Agent agent){
		int aux = agent.getPasX();
		agent.setPasX(this.pasX);
		this.pasX = aux;
		aux = agent.getPasY();
		agent.setPasY(this.pasY);
		this.pasY = aux;
	}
	
	public void update(){
		int i = this.x + this.pasX;
		int j = this.y + this.pasY;
		if(Utils.isThorique()){
			i = ( i + Utils.grideSizeX) % Utils.grideSizeX;
			j = ( j + Utils.grideSizeY) % Utils.grideSizeY;
		}
		environement.setAgent(this.x, this.y, null);
		this.x = i;
		this.y = j;
		environement.setAgent(i, j, this);
	}
	
	private void setPasY(int pasY2) {
		this.pasY = pasY2;
	}

	private int getPasY() {
		return this.pasY;
	}

	private void setPasX(int pasX2) {
		this.pasX = pasX2;
	}

	private int getPasX() {
		return this.pasX;
	}

	public abstract void decide();
}
