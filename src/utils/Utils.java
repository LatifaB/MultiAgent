package utils;

import java.util.ResourceBundle;

public class Utils {
	public static ResourceBundle bundle = ResourceBundle.getBundle("config");
	
	public static int grideSizeX = Integer.parseInt(Utils.bundle.getString("gridSizeX"));
	public static int grideSizeY = Integer.parseInt(Utils.bundle.getString("gridSizeY"));
	public static int canvasSizeX = Integer.parseInt(Utils.bundle.getString("canvasSizeX"));
	public static int canvasSizeY = Integer.parseInt(Utils.bundle.getString("canvasSizeY"));
	public static int delay = Integer.parseInt(Utils.bundle.getString("delay"));
	public static int seed = Integer.parseInt(Utils.bundle.getString("seed"));
	public static int refresh = Integer.parseInt(Utils.bundle.getString("refresh"));        //refresh sur le repaint
	public static int nbParticules = Integer.parseInt(Utils.bundle.getString("nbParticules"));
	public static int nbTricks = Integer.parseInt(Utils.bundle.getString("nbTricks"));
	
	public static String scheduling = Utils.bundle.getString("scheduling");

	public static boolean isThorique(){ 
		return new Boolean(Utils.bundle.getString("thorique")).booleanValue();
		}

	public static boolean showGrid(){ 
		return new Boolean(Utils.bundle.getString("grid")).booleanValue();
		}
	
	public static boolean showTrace(){ 
		return new Boolean(Utils.bundle.getString("trace")).booleanValue();} // ajout de la trace
	

	static public boolean isInfinity(){ 
		return nbTricks == 0;
	}
	
	static public int[] modulo(int x, int y){
		int res[] = new int[2];
		res[0] = (x + grideSizeX) % grideSizeX;
		res[1] = (y + grideSizeY) % grideSizeY;
		return res;
	}
	
	
}

