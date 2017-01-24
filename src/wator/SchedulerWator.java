package wator;

import core.Scheduler;
import particule.Surface;


public class SchedulerWator extends Scheduler {

    public SchedulerWator() {
        this.environement = new Wator();
    }
}
