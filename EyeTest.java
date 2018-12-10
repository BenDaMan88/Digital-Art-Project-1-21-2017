import java.awt.Color;

/**
 * Write a description of class EyeTest here.
 * 
 * @author Ben Johnson 
 * @version 1/19/2017
 */
public class EyeTest
{
    private int width;
    private int height;
    private Canvas window;
    
    /**
     * constructor for the EyeTest class, creates empty canvas with specified size.
     */
    public EyeTest(int WIDTH, int HEIGHT)
    {
        window = new Canvas("ART!", WIDTH, HEIGHT);
        window.setVisible(true);
        width = WIDTH;
        height = HEIGHT;
    }
    
    /**
     * constructor for the Eyetest class, creates empty canvas 600 x 600.
     * 
     * @param none
     * @return nothing
     */
    public EyeTest()
    {
        window = new Canvas("ART!", 600, 600);
        window.setVisible(true);
        width = 600;
        height = 600;
    }
    
    /**
     * the pupil or inner circles of the eye.
     * 
     * @param none
     * @return nothing
     */
    public void circles()
    {
        int count = 0;
        for(int i = 0; i < width-110; i += 10)
        {
            if(count % 2 == 0)
            {
                window.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                window.setForegroundColor(new Color(255,255, 255));
            }
            window.fillCircle((i)/2,(i)/2, width-i);
            count ++;
        }
    }
    
    /**
     * the curvy part of the eye (outside).
     * 
     * @param none
     * @return nothing
     */
    public void curves()
    {
        int count = 0;
        double x = 0;
        for(int j = 250; j >= -100; j-= 10){
            if(count % 2 == 0)
            {
                window.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                window.setForegroundColor(new Color(255,255, 255));
            }
            for(int i = -20; i <= width +20; i++)
            {
                window.fillCircle(i,(int)(50*Math.sin(x+Math.PI/2))+j,10);
                x += .01;
            }
            x = 0;
            count++;
        }
        count = 0;
        x = 0;
        for(int j = 350; j <= width+100; j+= 10){
            if(count % 2 == 0)
            {
                window.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                window.setForegroundColor(new Color(255,255, 255));
            }
            for(int i = -20; i <= width +20; i++)
            {
                window.fillCircle(i,(int)(-50*Math.sin(x+Math.PI/2))+j,10);
                x += .01;
            }
            x = 0;
            count++;
        }
    }
    
    /**
     * Final eye pattern op art.
     * 
     * @param none
     * @return nothing
     */
    public void opEye()
    {
        int count = 0;
        double x = 0;
        for(int i = 0; i < width-110; i += 20)
        {
            if(count % 2 == 0)
            {
                window.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                window.setForegroundColor(new Color(255,255, 255));
            }
            window.fillCircle((i)/2,(i)/2, width-i);
            count ++;
        }
        count = 0;
        for(int j = 250; j >= -100; j-= 10){
            if(count % 2 == 0)
            {
                window.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                window.setForegroundColor(new Color(255,255, 255));
            }
            for(int i = -20; i <= width +20; i++)
            {
                window.fillCircle(i,(int)(50*Math.sin(x+Math.PI/2))+j,10);
                x += .01;
            }
            x = 0;
            count++;
        }
        count = 0;
        x = 0;
        for(int j = 350; j <= width+100; j+= 10){
            if(count % 2 == 0)
            {
                window.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                window.setForegroundColor(new Color(255,255, 255));
            }
            for(int i = -20; i <= width +20; i++)
            {
                window.fillCircle(i,(int)(-50*Math.sin(x+Math.PI/2))+j,10);
                x += .01;
            }
            x = 0;
            count++;
        }
    }
}
