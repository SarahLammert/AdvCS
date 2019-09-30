package caseStudyLab;

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class BalloonDraw extends JFrame
{
  public BalloonDraw()  // constructor
  {
    super("Drawing Editor");

    DrawingPanel canvas = new DrawingPanel();
    ControlPanel controls = new ControlPanel(canvas);
    Container c = getContentPane();
    c.add(canvas, BorderLayout.CENTER);
    c.add(controls, BorderLayout.SOUTH);
  }

  public static void main(String[] args)
  {
    BalloonDraw window = new BalloonDraw();
    window.setBounds(100, 100, 400, 400);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}

/*
 * 87 - Explain why the different types of balloons are not fully implemented:
 * The reason for this is the draw method is taken from the superclass of balloon.
 * It has not been overwritten in the specific subclass of balloon to draw.
 * 
 * 
 * 
 */
