// Name: Pengxiang Xu
// USC NetID: pengxiax
// CS 455 PA1
// Fall 2017

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * class CoinSimComponent
 * 
 * Initializes data and runs the simulation.
 *  
 * Invariant: 
 */

public class CoinSimComponent extends JComponent{
	private int twoHeadToss;
	private int twoTailToss;
	private int headTailToss;
	private int numTrailsCount;
	private int probTwoHead;
	private int probTwoTail;
	private int probHeadTail;
	private int barBottom;
	private int widthSeperate; // width between two bars
	private int tallestBarHeight;
	private int frameHeight;
	private int frameWidth;
	private int twoHeadLeft;
	private int twoHeadHeight;
	private int twoTailLeft;
	private int twoTailHeight;
	private int headTailLeft;
	private int headTailHeight;
	private double scale;
	
	private final int BAR_WIDTH = 100;// Bar width of each bar: 100px
	private final int VERTICAL_BUFFER = 50; //Vertical buffer: 50px
	private final Color TWO_HEAD_COLOR = Color.red;
	private final Color TWO_TAIL_COLOR = Color.blue;
	private final Color HEAD_TAIL_COLOR = Color.green;
	
	
	/**
    Creates a coin simulation component.   

    @param numTrails number of simulation trails 
 */
	
	public CoinSimComponent(int numTrails) {
		CoinTossSimulator cts = new CoinTossSimulator();
		cts.run(numTrails);
		numTrailsCount = cts.getNumTrials();
		twoHeadToss = cts.getTwoHeads();
		twoTailToss = cts.getTwoTails();
		headTailToss = cts.getHeadTails();
	
		// Determine the probability of each outcome
		probTwoHead = (int)(Math.round(((double)twoHeadToss / (double)numTrailsCount) * 100));
		probTwoTail = (int)(Math.round(((double)twoTailToss / (double)numTrailsCount) * 100));
		probHeadTail = (int)(Math.round(((double)headTailToss / (double)numTrailsCount) * 100));
	}
	
	/**
    Overrides paintComponent

    @param g the graphics content
 */

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
			
		frameHeight = this.getHeight();
		frameWidth = this.getWidth();
		
		// Determine the left position of each bar
		widthSeperate = (frameWidth - 3 * BAR_WIDTH) / 4; 
		twoHeadLeft = widthSeperate;
		headTailLeft = 2 * widthSeperate + BAR_WIDTH;
		twoTailLeft = 3 * widthSeperate + 2 * BAR_WIDTH;
		
		// Determine the tallest bar height and scale without label height
		tallestBarHeight = frameHeight - 2 * VERTICAL_BUFFER;
		
		if (probHeadTail > probTwoHead) {
			if (probHeadTail > probTwoTail) {
				twoHeadHeight = tallestBarHeight;
				scale = Math.round((double)tallestBarHeight / (double)probHeadTail * 100)/100.0;
			}
			else{
				twoTailHeight = tallestBarHeight;
				scale = Math.round((double)tallestBarHeight / (double)probTwoTail * 100)/100.0;
			}
		}
		else if (probTwoHead > probTwoTail) {
			twoHeadHeight = tallestBarHeight;
			scale = Math.round((double)tallestBarHeight / (double)probTwoHead * 100)/100.0;
		}
		else {
			twoTailHeight = tallestBarHeight;
			scale = Math.round((double)tallestBarHeight / (double)probTwoTail * 100)/100.0;
		}
		
		// Determine the height of each bar without label height
		twoHeadHeight = (int)(scale * probTwoHead);
		headTailHeight = (int)(scale * probHeadTail);
		twoTailHeight = (int)(scale * probTwoTail);
		
		// Determine the bottom of each bar without label height
		barBottom = tallestBarHeight + VERTICAL_BUFFER;
		
		// Construct bars and draw bars
		Bar twoHeads = new Bar(barBottom, twoHeadLeft, BAR_WIDTH, twoHeadHeight, scale, TWO_HEAD_COLOR, 
							   "Two Heads: " + twoHeadToss + "(" + probTwoHead + "%)");
		Bar headTails = new Bar(barBottom, headTailLeft , BAR_WIDTH, headTailHeight, scale, HEAD_TAIL_COLOR, 
								"A Head and a Tail: " + headTailToss + "(" + probHeadTail + "%)");
		Bar twoTails = new Bar(barBottom, twoTailLeft , BAR_WIDTH, twoTailHeight , scale, TWO_TAIL_COLOR,
							   "Two Tails: " + twoTailToss + "(" + probTwoTail + "%)");
		
		twoHeads.draw(g2);
		headTails.draw(g2);
		twoTails.draw(g2);
	}
}
