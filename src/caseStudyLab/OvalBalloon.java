package caseStudyLab;

import java.awt.Color;
import java.awt.Graphics;

public class OvalBalloon extends Balloon {
	public OvalBalloon() {
		
	}
	public OvalBalloon(int x, int y, int r, Color c) {
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
	      g.fillOval(x - (r/2),
	                 y - r, r, 2*r);
	    else
	      g.drawOval(x - (r/2),
	                 y - r, r, 2*r);
	  }
	//Having trouble understanding what the book wants with this -- So I did it my own way
	 public double distance(int x, int y)
	  {
	    double dx = x - this.getX();
	    double dy = y - this.getY();
	    return Math.sqrt(dx*dx + dy*dy);
	  }
	

}
