package Window_package;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.JPanel;

public class VectorPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	static int width = 600;
	static int height = 600;
	
	Polygon xAxis;
	Polygon yAxis;
	static BasicStroke axisStroke = new BasicStroke(1);
	static BasicStroke vectorStroke = new BasicStroke(1);

	Arrow[][] arrowTab;
	static final int arrowsInRow = 10;
	static final int arrowsInColumn = 15;
	Arrow demoArrow = new Arrow(width/2, height/2 , -1, -2);

	public VectorPanel() {
		setBackground(Color.white);
		
		xAxis = new Polygon();
		xAxis.addPoint(0, height/2);
		xAxis.addPoint(width, height/2);
		yAxis = new Polygon();
		yAxis.addPoint(width/2, 0);
		yAxis.addPoint(width/2, height);
		
		arrowTab = new Arrow[arrowsInRow][arrowsInColumn];
		double xSpaceBetweenArrows = width/(arrowsInRow);
		double ySpaceBetweenArrows = height/(arrowsInColumn);
		
		
		for(int i = 0; i < arrowsInRow; i++)
		{
			for(int j = 0; j < arrowsInColumn; j++)
			{
				int posX = (int) (0 +i*xSpaceBetweenArrows);
				int posY = (int) (0 +j *ySpaceBetweenArrows);
				double argX = (-1)*width + i * 2*xSpaceBetweenArrows;
				double argY = (-1)*height + j * 2*ySpaceBetweenArrows;
				arrowTab[i][j] = new Arrow(posX, posY, argX, argY );
				
				
				//arrowTab[i+n][j+n] = new Arrow( (width/n)/2 + (i+n)*width/n, (height/n)/2 + (j+n)*height/n, fx, fy);
				//arrowTab[i][j] = new Arrow( (width/n)/2 + i*width/n, (height/n)/2 + j*height/n, 1, 1);
			}
		}


	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.BLACK);
		g2d.setStroke(axisStroke);
		g.drawPolygon(xAxis);
		g.drawPolygon(yAxis);
		g.drawRect(0, 0, width, height);
		
		g2d.setStroke(vectorStroke);
		g2d.setColor(Color.red);
		for(int i = 0; i < arrowsInRow; i++)
		{
			for(int j = 0; j < arrowsInColumn; j++)
			{
				g.drawPolygon(arrowTab[i][j]);
				g.fillPolygon(arrowTab[i][j]);
			}
		}
		
		//g.drawPolygon(demoArrow);
		//g.fillPolygon(demoArrow);
		
	}
	
}
