package model;

import java.awt.Color;
import java.util.Random;
import utils.Utils;

public class Environement {
	private Agent[][] map;
	
	public Environement(){
		map = initArray();
		init();
		System.out.println(this.toString());
	}
	
	private void init(){
		int x,y;
		Random rnd = new Random();
		if(Utils.seed != 0){
			rnd.setSeed(Utils.seed);
		}
		for(int i = 0; i < Utils.nbParticules; i++){
			x = rnd.nextInt(Utils.grideSizeX);
			y = rnd.nextInt(Utils.grideSizeY);
			while(map[x][y] != null){
				x = rnd.nextInt(Utils.grideSizeX);
				y = rnd.nextInt(Utils.grideSizeY);
			}
			map[x][y] = new Agent(x,y,this);
		}
		
	}
	
	private Agent[][] initArray(){
		Agent[][] tab = new Agent[Utils.grideSizeX][Utils.grideSizeY];
		for(int i = 0; i < Utils.grideSizeX ; i++){
			for(int j = 0; j < Utils.grideSizeY ; j++){
				tab[i][j] = null;
			}
		}
		return tab;
	}
	
	public boolean isEmpty(int x, int y){
		return map[x][y] == null;
	}
	
	public String toString(){
		String result = "";
		Agent agent;
		for(int i = 0; i < Utils.grideSizeX; i++){
			for(int j = 0; j < Utils.grideSizeY; j++){
				agent = map[j][i];
				if(agent == null){
					result = result + " |";
				}else{
					result = result + "*|";
				}
			}
			result = result + "\n";
		}
		return result;
	}
	
	public void decideAll(){
		Agent agent;
			for(int i = 0; i < Utils.grideSizeX; i++){
				for(int j = 0; j < Utils.grideSizeY; j++){
					agent = map[i][j];
					if(agent != null && !agent.isMoved()){
						agent.decide();
					}
				}
			}
		finishTurn();
	}
	
	private void finishTurn() {
		for(Agent[] row : map){
			for(Agent agent : row){
				if(agent != null){
					agent.setMoved(false);
				}
			}
		}
	}

	public Agent getAgent(int x, int y){
		return map[x][y];
	}	
	public void setAgent(int x, int y, Agent agent){
		map[x][y] = agent;
	}
	
	public Color[][] getMap(){
		Color[][] res = new Color[Utils.grideSizeX][Utils.grideSizeY];
		for(int i = 0; i < Utils.grideSizeX; i++ ){
			for(int j = 0; j < Utils.grideSizeY; j++){
				if(!this.isEmpty(i, j)){
					res[i][j] = map[i][j].getColor();
				}else{
					res[i][j] = null;
				}
			}
		}
		return res;
	}
}
