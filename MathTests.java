import java.awt.Color;

/**
 * Testing out the math class with art.
 * 
 * @author Ben Johnson 
 * @version 1/19/2017
 */
public class MathTests
{
    private int width;
    private int height;
    private Canvas window;
    
    /**
     * constructor for the mathtest class, creates empty canvas of specified size.
     * 
     * @param none
     * @return nothing
     */
    public MathTests(int WIDTH, int HEIGHT)
    {
        window = new Canvas("ART!", WIDTH, HEIGHT);
        window.setVisible(true);
        width = WIDTH;
        height = HEIGHT;
    }

    /**
     * constructor for the mathtests class, creates empty canvas 600 x 600.
     * 
     * @param none
     * @return nothing
     */
    public MathTests()
    {
        window = new Canvas("ART!", 600, 600);
        window.setVisible(true);
        width = 600;
        height = 600;
    }
    
    /**
     * original test to see if sin would work.
     * 
     * @param none
     * @return nothing
     */
    public void sinTest()
    {
        double x = 0;
        int count = 0;
        for(int i = 0; i < width; i++)
        {
            window.fillCircle(i,(int)(100*Math.sin(x))+100,10);
            x+=.01;
            count++;
        }
    }
    
    /**
     * test for color varience.
     * 
     * @param none
     * @return nothing
     */
    public void sinTest2()
    {
        double x = 0;
        int count = 0;
        for(int i = 0; i < width; i+=3)
        {
            if(count % 2 == 0)
            {
                window.setForegroundColor(Color.WHITE);
            }
            else
            {
                window.setForegroundColor(Color.BLACK);
            }
            window.fillCircle(i,(int)(100*Math.sin(x))+100,10);
            x+=.05;
            count++;
        }
    }
    
    /**
     * test to see translation capabilities.
     * 
     * @param none
     * @return nothing
     */
    public void sinTest3()
    {
        double x = 0;
        int count = 0;
        for(int i = 0; i < width; i+=3)
        {
            if(count % 2 == 0)
            {
                window.setForegroundColor(Color.WHITE);
            }
            else
            {
                window.setForegroundColor(Color.BLACK);
            }
            window.fillCircle(i,(int)(100*Math.sin(x))+100,50);
            x+=.05;
            count++;
        }
        x = 0;
        count = 0;
        for(int i = 0; i < width; i+=3)
        {
            if(count % 2 == 0)
            {
                window.setForegroundColor(Color.WHITE);
            }
            else
            {
                window.setForegroundColor(Color.BLACK);
            }
            window.fillCircle(i,(int)(100*Math.sin(x))+125,50);
            x+=.05;
            count++;
        }
    }
    
    /**
     * cool looking final product sin op art.
     * 
     * @param none
     * @return nothing
     */
    public void sinTest4()
    {
        double x = 0;
        int count = 0;
        for(int j = -100; j <= width+100; j += 100){
            for(int i = -50; i <= width; i+=3)
            {
                if(count % 2 == 0)
                {
                    window.setForegroundColor(Color.WHITE);
                }
                else
                {
                    window.setForegroundColor(Color.BLACK);
                }
                window.fillCircle(i,(int)(100*Math.sin(x))+j,100);
                x+=.05;
                count++;
            }
            x = 0;
            count = 0;
        }
    }
}
