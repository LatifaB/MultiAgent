package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import utils.Utils;

public class MyJPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Color[][] map;

	public MyJPanel(){
        setPreferredSize(new Dimension(Utils.boxSize*Utils.grideSizeX, Utils.boxSize*Utils.grideSizeY));
	}

	  public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int i = 0; i < Utils.grideSizeX; i++ ){
			if(Utils.showGrid()){
				g.setColor(Color.black);
				g.drawLine(i*Utils.boxSize, 0, i*Utils.boxSize, map[0].length*Utils.boxSize);
			}
			for(int j = 0; j < Utils.grideSizeY; j++){
				if(map[i][j] != null){
					g.setColor(map[i][j]);
					g.fillOval(i*Utils.boxSize, j*Utils.boxSize, Utils.boxSize, Utils.boxSize);
				}
				if(Utils.showGrid() && i == 0){
					g.setColor(Color.black);
					g.drawLine(0, j*Utils.boxSize, map.length*Utils.boxSize, j*Utils.boxSize);
				}
			}
		}
		if(Utils.showGrid()){
			g.setColor(Color.black);
			g.drawLine(Utils.grideSizeX*Utils.boxSize, 0, Utils.grideSizeX*Utils.boxSize, Utils.grideSizeY*Utils.boxSize);
			g.drawLine(0, Utils.grideSizeY*Utils.boxSize, Utils.grideSizeX*Utils.boxSize, Utils.grideSizeY*Utils.boxSize);
		}

	  }
	  
	  public void setMap(Color[][] map){
		  this.map = map;
	  }


}
