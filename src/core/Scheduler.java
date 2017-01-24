package core;

import java.awt.Color;
import java.util.Observable;

import particule.Surface;
import utils.Utils;


public abstract class Scheduler extends Observable{

	protected Environement environement;
	
	public void run(){
		setChanged();
		notifyObservers();
		if(Utils.isInfinity()){
			while(true){
				try {
					environement.decideAll();
					setChanged();
					notifyObservers();
					Thread.sleep(Utils.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else{
			for(int i = 0; i < Utils.nbTricks;i++){
				try {
					environement.decideAll();
					System.out.println(environement.toString());
					setChanged();
					notifyObservers();
					Thread.sleep(Utils.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Color[][] getMap(){
		return  environement.getColor();
	}
	
}
