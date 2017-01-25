package avatar;

import core.Agent;
import core.Environement;

import java.awt.*;


public class Wall extends Agent{
    public Wall(int x, int y, Board environement) {
        super(x, y, environement);
        this.color = Color.black;
    }

    @Override
    public void update() {

    }

    @Override
    public void decide() {

    }
}
