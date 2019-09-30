package caseStudyLab;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Banner extends JPanel
                 implements ActionListener
{
  private int xPos, yPos;// hold the coordinates of the message
  private static int xB;
  private static Balloon b1;
  private static Balloon b2;
  private static Balloon b3;
  private static Balloon b4;
  
  // Called automatically after a repaint request
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g); // Paint the background
    g.setColor(Color.RED);
    //g.drawString("Hello, Action!", xPos, yPos);
    b1.draw(g, true);
    b2.draw(g, true);
    b3.draw(g, true);
    b4.draw(g, true);
    if(b1.getY() > b1.getRadius()) {
    	b1.move(b1.getX(), b1.getY()-4);
    } else {
    	b1.move(b1.getX(), xB);
    }
    if(b2.getY() > b2.getRadius()) {
    	b2.move(b2.getX(), b2.getY()-4);
    } else {
    	b2.move(b2.getX(), xB);
    }
    
    if(b3.getY() > b3.getRadius()) {
    	b3.move(b3.getX(), b3.getY()-4);
    } else {
    	b3.move(b3.getX(), xB);
    }
    if(b4.getY() > b4.getRadius()) {
    	b4.move(b4.getX(), b4.getY()-4);
    } else {
    	b4.move(b4.getX(), xB);
    }
    
  }

  // Called automatically when the timer "fires"
  public void actionPerformed(ActionEvent e)
  {
    // Adjust the horizontal position of the message:
    xPos--;  // subtract 1
    if (xPos < -100)
      xPos = getWidth();

    repaint();
  }

  public static void main(String[] args)
  {
	xB = 450;
    JFrame window = new JFrame("Action Demo");
    b1 = new RoundBalloon(100, xB, 25, Color.BLACK);
    b2 = new FancyBalloon(200, xB, 25, Color.RED);
    b3 = new OvalBalloon(300, xB, 25, Color.YELLOW);
    b4 = new SquareBalloon(400, xB, 25, Color.GRAY);
    

    // Set this window's location and size:
    // upper-left corner at 300, 300; width 300, height 500
    window.setBounds(500, 500, 500, 500);

    //  Create panel, a Banner object, which is a kind of JPanel:
    Banner panel = new Banner();
    panel.setBackground(Color.CYAN);  // the default color is light gray

    // Add panel to window:
    Container c = window.getContentPane();
    c.add(panel);

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

    // Set the initial position of the message:
    panel.xPos = panel.getWidth();
    panel.yPos = panel.getHeight() / 2;

    // Create a Timer object that fires every 30 milliseconds;
    // attach it to panel so that panel "listens to" and
    // processes the timer events; start the timer:
    Timer clock = new Timer(30, panel);
    clock.start();
  }
}
