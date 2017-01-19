package core;

import java.awt.Color;

import utils.Utils;

public abstract class Environement {
	protected Agent[][] map;
	
	public Environement(){
		this.map = new Agent[Utils.grideSizeX][Utils.grideSizeY];
		for(int i = 0; i < Utils.grideSizeX; i++){
			for(int j = 0; j < Utils.grideSizeY; j++){
				map[i][j] = null;
			}
		}
	}
	
	
	public Agent getAgent(int x, int y){
		return map[x][y];
	}
	
	public void setAgent(int x, int y, Agent agent){
		map[x][y] = agent;
	}
	
	
	public void decideAll(){
		for(int i = 0; i < Utils.grideSizeX; i++){
			for(int j = 0; j < Utils.grideSizeY; j++){
				if(map[i][j] != null && !map[i][j].isMoved()){
					map[i][j].decide();
					//System.out.println();
				}
			}
		}
		resetAll();
	}
	
	private void resetAll(){
		for(int i = 0; i < Utils.grideSizeX; i++){
			for(int j = 0; j < Utils.grideSizeY; j++){
				if(map[i][j] != null){
					map[i][j].resetMoved();
				}
			}
		}
	}
	
	public String toString(){
		String res = "";
		for(int i = 0; i < Utils.grideSizeX; i++){
			for(int j = 0; j < Utils.grideSizeY; j++){
				if(map[i][j] != null){
					res = res + "*|";
				}else{
					res = res + " |";
				}
			}
			res = res + "\n";
		}
		return res;
	}
	
	public abstract Color[][] getColor();
	
}
