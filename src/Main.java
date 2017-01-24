import particule.MyViewBille;
import particule.SchedulerBille;
import wator.MyViewWator;
import wator.SchedulerWator;

public class Main {

	public static void main(String[] args) {
		/*SchedulerBille sma = new SchedulerBille();
		MyViewBille view = new MyViewBille();
		sma.addObserver(view);
		sma.run();*/
		

		SchedulerWator sma = new SchedulerWator();
		MyViewWator view = new MyViewWator();
		sma.addObserver(view);
		sma.run();

	}

}
