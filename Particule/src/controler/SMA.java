package controler;

import java.awt.Color;
import java.util.Observable;

import model.Environement;
import utils.Utils;

public class SMA extends Observable{
	
	private Environement env;
	
	public SMA(){
		this.env = new Environement();
	}

	public Color[][] getMap(){
		return env.getMap();
	}
	
	public void run(){
		setChanged();
		notifyObservers();
		if(Utils.isInfinity()){
			while(true){
				try {
					env.decideAll();
					System.out.println(env.toString());
					setChanged();
					notifyObservers();
					Thread.sleep(Utils.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else{
			for(int i = 0;i < Utils.nbTricks; i++){
				try {
					env.decideAll();
					System.out.println(env.toString());
					setChanged();
					notifyObservers();
					Thread.sleep(Utils.delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
