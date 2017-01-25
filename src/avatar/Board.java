package avatar;


import core.Environement;
import utils.Utils;

import java.awt.*;
import java.util.*;

public class Board extends Environement{
    public Board(){
        Random rdm = new Random();
        if(Utils.seed != 0){
            rdm.setSeed(Utils.seed);
        }
        int x,y;

        x = rdm.nextInt(Utils.grideSizeX);
        y = rdm.nextInt(Utils.grideSizeY);
        int nbWalls = (Utils.grideSizeX * Utils.grideSizeY) / 100 * Utils.wallsPercent;
        for(int i = 0; i < nbWalls; i++){
            x = rdm.nextInt(Utils.grideSizeX);
            y = rdm.nextInt(Utils.grideSizeY);
            while(this.map[x][y] != null){
                x = rdm.nextInt(Utils.grideSizeX);
                y = rdm.nextInt(Utils.grideSizeY);
            }
            map[x][y] = new Wall(x,y,this);
        }

        x = rdm.nextInt(Utils.grideSizeX);
        y = rdm.nextInt(Utils.grideSizeY);
        while(this.map[x][y] != null){
            x = rdm.nextInt(Utils.grideSizeX);
            y = rdm.nextInt(Utils.grideSizeY);
        }
        map[x][y] = new Prey(x,y,this);

       /* for(int i = 0; i < Utils.nbHunters; i++){
            x = rdm.nextInt(Utils.grideSizeX);
            y = rdm.nextInt(Utils.grideSizeY);
            while(this.map[x][y] != null){
                x = rdm.nextInt(Utils.grideSizeX);
                y = rdm.nextInt(Utils.grideSizeY);
            }
            map[x][y] = new Hunter(x,y,this);
        }*/
    }

    public Color[][] getColor() {
        Color[][] res = new Color[Utils.grideSizeX][Utils.grideSizeY];
        for(int i = 0; i < Utils.grideSizeX; i++ ){
            for(int j = 0; j < Utils.grideSizeY; j++){
                if(map[i][j] != null){
                    res[i][j] = map[i][j].getColor();
                }
            }
        }
        return res;
    }

    public LinkedList<Prey> prey(){
        LinkedList<Prey> result = new LinkedList<Prey>();
        for(int i = 0; i < Utils.grideSizeX; i++ ){
            for(int j = 0; j < Utils.grideSizeY; j++){
                if(map[i][j] instanceof  Prey){
                    result.add((Prey) map[i][j]);
                }
            }
        }
        return result;
    }
}
