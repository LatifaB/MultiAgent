import controler.SMA;
import view.MyView;

public class Main {

	public static void main(String[] args) {
		SMA sma = new SMA();
		MyView view = new MyView();
		sma.addObserver(view);
		sma.run();
	}

}
