package wator;

import java.awt.Color;

import core.Agent;

public class Fish extends Agent{
	private Color color;
	private int age;

	public Fish(int x, int y, Wator water) {
		super(x, y, water);
		this.color = Color.cyan;
		this.age = 0;
	}

	@Override
	public void decide() {
		
		
		if(this.age == 0){
			this.color = Color.blue;
		}
		this.age++;
	}

}
