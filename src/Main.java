import avatar.MyViewAvatar;
import avatar.SchedulerAvatar;
import particule.MyViewBille;
import particule.SchedulerBille;
import utils.Utils;
import wator.MyViewWator;
import wator.SchedulerWator;

public class Main {

	public static void main(String[] args) {

		switch(args[0]) {
			case "bille":
				SchedulerBille bille = new SchedulerBille();
				MyViewBille viewBille = new MyViewBille();
				bille.addObserver(viewBille);
				bille.run();
				break;

			case "wator":
				SchedulerWator wator = new SchedulerWator();
				MyViewWator viewWator = new MyViewWator();
				wator.addObserver(viewWator);
				wator.run();
				break;

			default :
				SchedulerAvatar avatar = new SchedulerAvatar();
				MyViewAvatar viewAvatar = new MyViewAvatar(avatar.getPreys());
				avatar.addObserver(viewAvatar);
				avatar.run();
		}

	}

}
