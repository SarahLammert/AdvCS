package caseStudyLab;

import java.awt.Color;
import java.awt.Graphics;

public class SquareBalloon extends Balloon {
	public SquareBalloon() {
		
	}
	public SquareBalloon(int x, int y, int r, Color c) {
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
	      g.fillRect(x - (r/2),
	                 y - r, r, 2*r);
	    else
	      g.drawRect(x - (r/2),
	                 y - r, r, 2*r);
	  }
	 public double distance(int x, int y)
	  {
	    double dx = x - this.getX();
	    double dy = y - this.getY();
	    return Math.sqrt(dx*dx + dy*dy);
	  }

}