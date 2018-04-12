// Name: Pengxiang Xu
// USC NetID: pengxiax
// CS 455 PA1
// Fall 2017

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   private int pxBottom;
   private int pxLeft;
   private int pxWidth;
   private int pxBarHeight;
   private double barScale;
   private Color barColor;
   private String barLabel;
      
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {
	   pxBottom = bottom;
	   pxLeft = left;
	   pxWidth = width;
	   pxBarHeight = barHeight;
	   barScale = scale;
	   barColor = color;
	   barLabel = label;
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
	   // Get label width and height
	   Font font = g2.getFont();
	   FontRenderContext context = g2.getFontRenderContext();
	   Rectangle2D labelBounds = font.getStringBounds(barLabel, context);
	   int widthOfLabel = (int)labelBounds.getWidth();
	   int heightOfLabel = (int)labelBounds.getHeight();
	 	   
	   // Construct bar
	   Rectangle rec = new Rectangle(pxLeft,
					 pxBottom - pxBarHeight,
					 pxWidth,
					 pxBarHeight - heightOfLabel);
	   
	   // Draw bar labels 
	   g2.drawString(barLabel, 
			         pxLeft - ((widthOfLabel - pxWidth) / 2) , 
			         pxBottom);
	   
	   // Draw bars
	   g2.setColor(barColor);
	   g2.draw(rec);
	   g2.fill(rec);
	   g2.setColor(Color.black);
   }
}
