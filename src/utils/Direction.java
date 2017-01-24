package utils;

import java.util.LinkedList;
import java.util.Random;

public class Direction {

    private LinkedList<Pair> nonVue = initDirection();
    private LinkedList<Pair> dejaVue = new LinkedList<Pair>();

    private LinkedList<Pair> initDirection(){
        LinkedList<Pair> dir = new LinkedList<Pair>();
        dir.add(new Pair(0, 1));
        dir.add(new Pair(0, -1));
        dir.add(new Pair(1, 0));
        dir.add(new Pair(-1, 0));
        dir.add(new Pair(1, 1));
        dir.add(new Pair(-1, 1));
        dir.add(new Pair(1, -1));
        dir.add(new Pair(-1, -1));
        return dir;
    };

    public Pair nextDirection(){
        Random rdm = new Random();
        if(Utils.seed != 0) {
            rdm.setSeed(Utils.seed);
        }
        if(nonVue.size() > 0) {
            int nextInt = rdm.nextInt(nonVue.size());
            Pair direction = nonVue.get(nextInt);
            nonVue.remove(direction);
            dejaVue.add(direction);
            return direction;
        }
        nonVue = dejaVue;
        dejaVue = new LinkedList<Pair>();
        return null;
    }
}
