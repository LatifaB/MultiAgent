package wator;


import core.Agent;
import utils.Pair;
import utils.Utils;

import java.awt.*;

public abstract class MarinCreature extends Agent {

    protected int age;
    protected Color adultColor;

    public MarinCreature(int x, int y, Wator environement) {
        super(x, y, environement);
    }

    public void update(){}

    public void updateMarinCreature(Pair direction, MarinCreature agent, int breed) {
        int nextX = this.x + direction.first();
        int nextY = this.y + direction.second();
        if(Utils.isThorique()){
            int[] tab = Utils.modulo(nextX,nextY);
            nextX = tab[1];
            nextY = tab[2];
        }
        this.environement.setAgent(nextX,nextY,this);
        if ((this.age % breed) == 0) {
            this.environement.setAgent(x, y, agent);
        }else{
            this.environement.setAgent(x, y, null);
        }
        this.x = nextX;
        this.y = nextY;
        if(this.age == 0){
            this.color = this.adultColor;
        }
        this.age++;
    }

}
