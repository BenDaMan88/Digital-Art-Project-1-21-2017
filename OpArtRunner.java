import java.awt.Color;

/**
 * Creates an original masterpiece.
 * 
 * @author Ben Johnson
 * @version 12/29/2016
 */
public class OpArtRunner
{
    private Canvas art;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int HALF = 2;
    
    /**
     * constructor that creates an empty canvas to draw on.
     * 
     * @param none
     * @return nothing
     */
    public OpArtRunner()
    {
        art = new Canvas("Art", WIDTH, HEIGHT);
        art.setVisible(true);
    }
    
    /**
     * creates a star shape on the canvas of specified size.
     * 
     * @param int spacing - the size of the squares.
     * @return nothing.
     */
    public void star(int spacing){
        art.setForegroundColor(new Color(0,0,0));
        for(int i = 0; i < WIDTH/2; i+= spacing)
        {
            art.drawLine(i,WIDTH/HALF,WIDTH/HALF,WIDTH/HALF-i);
            art.drawLine(i,WIDTH/HALF,WIDTH/HALF,WIDTH/HALF+i);
        }
        for(int i = 0; i <= WIDTH/2; i+= spacing)
        {
            art.drawLine(WIDTH/HALF,i,WIDTH/HALF+i,WIDTH/HALF);
            art.drawLine(WIDTH/HALF,WIDTH-i,WIDTH/HALF+i,WIDTH/HALF);
        }
    }
    
    /**
     * creates a pattern of transformed circles in all quadrants of the canvas. (part of actual project)
     * 
     * @param none
     * @return nothing
     */
    public void circleFourCenterConverge()
    {
        int count = 0;
        //bottom right circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(WIDTH/2,WIDTH/2, WIDTH-i);
            count ++;
        }
        count = 0;
        //bottom left circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(-WIDTH/2+i,WIDTH/2, WIDTH-i);
            count ++;
        }
        count = 0;
        //top left circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(-WIDTH/2+i,-WIDTH/2+i, WIDTH-i);
            count ++;
        }
        count = 0;
        //top right circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(WIDTH/2,-WIDTH/2+i, WIDTH-i);
            count ++;
        }
    }
    
    /**
     * creates a pattern of transformed circles in all quadrants of the canvas in a wierd way. 
     * 
     * @param none
     * @return nothing
     */
    public void circleFourCornersWeird()
    {
        int count = 0; 
        //top left circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(-WIDTH/2,-WIDTH/2, WIDTH-i);
            count ++;
        }
        count = 0;
        //bottom right circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(WIDTH/2,WIDTH/2, WIDTH-i);
            count ++;
        }
        count = 0;
        //bottom left circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(-WIDTH/2,WIDTH/2, WIDTH-i);
            count ++;
        }
        count = 0;
        //top right circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(WIDTH/2,-WIDTH/2, WIDTH-i);
            count ++;
        }
        
    }
    
    /**
     * creates rings at the four corners going inward. (part of actual porject)
     * 
     * @param none
     * @return nothing
     */
    public void circleFourCornersCorrect()
    {
        int count = 0; 
        //top left circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(-WIDTH/2,-WIDTH/2, WIDTH-i);
            count ++;
        }
        count = 0;
        //bottom right circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(WIDTH/2+i,WIDTH/2+i, WIDTH-i);
            count ++;
        }
        
        count = 0;
        //bottom left circles
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(-WIDTH/2,WIDTH/2+i, WIDTH-i);
            count ++;
        }
        count = 0;
        //top right circles
        for(int i = 0; i < WIDTH/2; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(WIDTH/2+i,-WIDTH/2, WIDTH-i);
            count ++;
        }
        
        
    }
    
    /**
     * creates a test of the circle pattern I am using for my op art project.
     * 
     * @param none
     * @return nothing
     */
    public void circleOneBig()
    {
        int count = 0;
        for(int i = 0; i < WIDTH; i += 10)
        {
            if(count % 2 == 0)
            {
                art.setForegroundColor(new Color(0,0,0));
            }
            else
            {
                art.setForegroundColor(new Color(255,255, 255));
            }
            art.fillCircle(0,0, WIDTH-i);
            count ++;
        }
    }
    
    /**
     * erases everything on the canvas.
     * 
     * @param none
     * @return nothing
     */
    public void clear()
    {
        art.erase();
    }
}
