package avatar;

import core.Scheduler;

import java.util.LinkedList;


public class SchedulerAvatar extends Scheduler{

    public SchedulerAvatar() {
        this.environement = new Board();
    }

    public LinkedList<Prey> getPreys(){
        return ((Board) this.environement).prey();
    }
}
