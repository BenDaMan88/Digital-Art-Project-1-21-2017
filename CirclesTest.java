import java.awt.Color;

/**
 * cricles, it makes pretty circles.
 * 
 * @author Ben Johnson 
 * @version 1/19/2017
 */
public class CirclesTest
{
    private int width;
    private int height;
    private Canvas window;
    
    /**
     * constructor for the circlesTest class, creates empty canvas with specified size.
     * 
     * @param none
     * @return nothing
     */
    public CirclesTest()
    {
        window = new Canvas("ART!", 600, 600, Color.BLACK);
        window.setVisible(true);
        width = 600;
        height = 600;
    }
    
    /**
     * constructor for the circlestest class, creates empty canvas 600 x 600.
     * 
     * @param none
     * @return nothing
     */
    public CirclesTest(int WIDTH, int HEIGHT)
    {
        window = new Canvas("ART!", WIDTH, HEIGHT);
        window.setVisible(true);
        width = WIDTH;
        height = HEIGHT;
    }
    
    /**
     * creates a masterpiece of art with circles.
     * 
     * @param none
     * @return nothing
     */
    public void Circles()
    {
        int count = 0;
        double x = -10;
        for(int i = 0; i < width; i += 20)
        {
            if(count % 2 == 0)
            {
                window.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                window.setForegroundColor(new Color(255,255, 255));
            }
            window.fillCircle((i)/2-(int)Math.pow(x,2)+90,(i)/2, width-i);
            count ++;
            x+=.6;
        }
    }
}
