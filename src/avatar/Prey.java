package avatar;

import core.Environement;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Prey extends Avatar implements KeyListener {
    private float vitesse = 0;

    public Prey(int x, int y, Environement environement) {
        super(x, y, environement);
        this.color = Color.green;
    }




    @Override
    public void update() {

    }

    @Override
    public void decide() {
        if(vitesse  >= 1){
            vitesse = 0;
            int i = this.x + this.dirX;
            int j = this.y + this.dirY;
            if (isOccupied(i, j)) {
                return;
            }

            if (Utils.isThorique()) {
                i = (i + Utils.grideSizeX) % Utils.grideSizeX;
                j = (j + Utils.grideSizeY) % Utils.grideSizeY;
            }

            this.environement.setAgent(this.x, this.y, null);
            this.environement.setAgent(i, j, this);
            this.x = i;
            this.y = j;
        }
        vitesse = vitesse + Utils.speedAvatar;
    }

    private boolean isOccupied(int x, int y){
        if(!Utils.isThorique()) {
            if (x == -1 || x == Utils.grideSizeX || y == -1 || y == Utils.grideSizeY) {
                return true;
            }
        }
        return this.environement.getAgent(x, y) != null;

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN :
                this.dirX = 0;
                this.dirY = 1;
                break;
            case KeyEvent.VK_UP :
                this.dirX = 0;
                this.dirY = -1;
                break;
            case KeyEvent.VK_LEFT :
                this.dirX = -1;
                this.dirY = 0;
                break;
            case KeyEvent.VK_RIGHT:
                this.dirX = 1;
                this.dirY = 0;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
