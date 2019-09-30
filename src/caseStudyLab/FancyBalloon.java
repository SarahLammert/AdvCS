package caseStudyLab;

import java.awt.Color;
import java.awt.Graphics;

public class FancyBalloon extends Balloon {
	public FancyBalloon() {
		
	}
	public FancyBalloon(int x, int y, int r, Color c) {
		super(x, y, r, c);
		
	}
	
	public void draw(Graphics g, boolean makeItFilled)
	  {
		  int x = getX();
		  int y = getY();
		  int r = getRadius();
		  Color c = getColor();
	    g.setColor(c);
	    if (makeItFilled)
	    {
	      g.fillOval(x - r,
	    		  	 y - r, r*2, r*2);
	      g.fillArc(x - r, y - r, r*4, r*3, 200, 50);
	    } else {
	    	g.drawOval(x - r,
	    		  	 y - r, r*2, r*2);
	    	g.fillArc(x - r, y - r, r*4, r*3, 200, 50);
	    }
	     
	  }
	 public double distance(int x, int y)
	  {
	    double dx = x - this.getX();
	    double dy = y - this.getY();
	    return Math.sqrt(dx*dx + dy*dy);
	  }

}