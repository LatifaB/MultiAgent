package wator;

import core.Environement;
import utils.Direction;
import utils.Pair;
import utils.Utils;

import java.awt.*;


public class Shark extends MarinCreature {

    private int starvingTime = 0;

    public Shark(int x, int y, Wator environement) {
        super(x, y, environement);
        this.color = Color.pink;
        this.adultColor = Color.red;
        this.age = 0;
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
        while(this.isEmpty(nextX,nextY) && direction != null){
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
            if(this.starvingTime == Utils.sharkStraveTime){
                this.environement.setAgent(this.x,this.y,null);
            }else{
                this.starvingTime++;
            }
            direction = dir.nextDirection();
            nextX = this.x + direction.first();
            nextY = this.y + direction.second();
            if(Utils.isThorique()){
                int[] tab = Utils.modulo(nextX,nextY);
                nextX = tab[0];
                nextY = tab[1];
            }
            while(this.environement.getAgent(nextX,nextY) != null
                    && direction != null){
                direction = dir.nextDirection();
                nextX = this.x + direction.first();
                nextY = this.y + direction.second();
                if(Utils.isThorique()){
                    int[] tab = Utils.modulo(nextX,nextY);
                    nextX = tab[0];
                    nextY = tab[1];
                }
            }
            return;
        }else {
            this.updateMarinCreature(new Pair(nextX,nextY),new Shark(this.x,this.y,(Wator)this.environement), Utils.fishBreedTime);
            this.starvingTime = 0;
        }
        return;
    }

    private boolean isEmpty(int x, int y){
        if(x == -1 || x == Utils.grideSizeX || y == -1 || y == Utils.grideSizeY){
            return true;
        }
        return this.environement.getAgent(x, y) == null
                || this.environement.getAgent(x,y) instanceof Shark;
    }
}
