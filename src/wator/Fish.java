package wator;

import utils.Direction;
import utils.Pair;
import utils.Utils;

import java.awt.*;

public class Fish extends MarinCreature{

	public Fish(int x, int y, Wator water) {
		super(x, y, water);
		this.color = Color.green;
		this.adultColor = Color.blue;
		this.age = 0;
	}


	@Override
	public void update() {
	}

	@Override
	public void decide() {
		int nextX, nextY;
		Direction dir = new Direction();
		Pair direction = dir.nextDirection();
		nextX = this.x + direction.first();
		nextY = this.y + direction.second();
		if(Utils.isThorique()){
			int[] tab = Utils.modulo(nextX,nextY);
			nextX = tab[0];
			nextY = tab[1];
		}
		while(!this.isEmpty(nextX,nextY) && direction != null){
			direction = dir.nextDirection();
			nextX = this.x + direction.first();
			nextY = this.y + direction.second();
			if(Utils.isThorique()){
				int[] tab = Utils.modulo(nextX,nextY);
				nextX = tab[0];
				nextY = tab[1];
			}
		}
		if(direction == null){
			return;
		}else {
			this.updateMarinCreature(new Pair(nextX,nextY),new Fish(this.x,this.y,(Wator)this.environement), Utils.fishBreedTime);
		}
		return;
	}

	private boolean isEmpty(int x, int y){
		if(x == -1 || x == Utils.grideSizeX || y == -1 || y == Utils.grideSizeY){
			return false;
		}
		return this.environement.isEmpty(x, y);
	}

}
