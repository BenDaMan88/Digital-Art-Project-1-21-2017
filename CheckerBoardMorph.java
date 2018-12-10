import java.awt.Color;

/**
 * Creates a checkerboard patterened art piece.
 * 
 * @author Ben Johnson
 * @version 12/23/2016
 */
public class CheckerBoardMorph
{
    private  int WIDTH = 600;
    private  int HEIGHT = 600;
    private static final Color BG = new Color(255, 255, 155);
    private Canvas art;
    
    /**
     * Constructor for the checker board class. Creates a canvas with a checkerboard pattern.
     * 
     * @param none
     * @return nothing
     */
    public CheckerBoardMorph(int Width, int Height)
    {
        art = new Canvas("Checker Board", Width, Height, BG);
        art.setVisible(true);
        WIDTH = Width;
        HEIGHT = Height;
        //checkerPattern(25);
    }
    
    
    /**
     * clears the whole canvas to just the background color.
     * 
     * @param none
     * @return nothing
     */
    public void clear()
    {
        art.erase();
    }
    
    
    /**
     * creates a checker board pattern on the canvas.
     * 
     * @param int size - the size of each square on the checker board.
     * @return nothing
     */
    public void checkerPattern(int spacing)
    {
        int count = 0;
        for(int y = 0; y < HEIGHT; y += spacing)
        {
            if(y % (2*spacing) == 0)
            {
                count = 1;
            }
            else
            {
                count = 0;
            }
            for(int x = 0; x < WIDTH; x += spacing)
            {
                if(count % 2 == 0)
                {
                    art.setForegroundColor( Color.WHITE );
                }
                else
                {
                    art.setForegroundColor( Color.BLACK );
                }
                art.fillRectangle(x, y, spacing, spacing);
                count++;
            }
        }
    }
    
    
    /**
     * creates a morphed checker board pattern on the canvas with x = 300 as the line morphed
     * around and spacing of 25.
     * 
     * @param none
     * @return nothing
     */
    public void checkerPatternLinearFixed()
    {
        int spacing = 25;
        int line = 300;
        int count = 0;
        int length = spacing;
        for(int y = 0; y < HEIGHT; y += spacing)
        {
            if(y % (2*spacing) == 0)
                {
                    count = 1;
                }
                else
                {
                    count = 0;
                }
            for(int x = -(int)(spacing*1.1); x < WIDTH; x += length)
            {
                //System.out.println(x + " " + length);
                if(count % 2 == 0)
                {
                    art.setForegroundColor( Color.WHITE );
                }
                else
                {
                    art.setForegroundColor( Color.BLACK );
                }
                art.fillRectangle(x, y, length, spacing);
                if(x < line)
                {
                    length = (int)(spacing - x*(20/300.0));
                }
                else
                {
                    length = (int)(x*(2/30.0)-15);
                }
                count++;
            }
        }
    }
    
    
    /**
     * creates a morphed checker board pattern on the canvas around the line specified and with
     * the spacing specified. (linear)
     * 
     * @param int size - the size of each square on the checker board.
     * @param int line - the x value for the vertical line to morph the cherkboard pattern around.
     * @return nothing
     */
    public void checkerPatternLinear(int spacing, int line)
    {
        int count = 0;
        int length = spacing;
        for(int y = 0; y < HEIGHT; y += spacing)
        {
            if(y % (2*spacing) == 0)
                {
                    count = 1;
                }
                else
                {
                    count = 0;
                }
            for(int x = 0; x < WIDTH; x += length)
            {
                if(count % 2 == 0)
                {
                    art.setForegroundColor( Color.WHITE );
                }
                else
                {
                    art.setForegroundColor( Color.BLACK );
                }
                if(x > line)
                {
                    length = (int)( -((1.0-spacing)/line)*x - (spacing-2) );
                }
                if(x == 0)
                {
                    length = spacing;
                }
                art.fillRectangle(x, y, length, spacing);
                if(x <= line)
                {
                    length = (int)(spacing + (x*((1.0-spacing)/line)) );
                }
                count++;
            }
        }
    }
    
    
    /**
     * creates a morphed checker board pattern on the canvas around the line specified and with
     * the spacing specified. (exponential, close to linear)
     * 
     * @param int size - the size of each square on the checker board.
     * @param int line - the x value for the vertical line to morph the cherkboard pattern around.
     * @return nothing
     */
    public void checkerPatternExponentialish(int spacing, int line)
    {
        int count = 0;
        int length = spacing;
        for(int y = 0; y < HEIGHT; y += spacing)
        {
            if(y % (2*spacing) == 0)
                {
                    count = 1;
                }
                else
                {
                    count = 0;
                }
            for(int x = 0; x < WIDTH; x += length)
            {
                if(count % 2 == 0)
                {
                    art.setForegroundColor( Color.WHITE );
                }
                else
                {
                    art.setForegroundColor( Color.BLACK );
                }
                if(x > line)
                {
                    length = (int)( Math.pow( Math.E, Math.log(Math.E/spacing)/line*(line*2.0-x) )*spacing );
                }
                if(x == 0)
                {
                    length = spacing;
                }
                art.fillRectangle(x, y, length, spacing);
                if(x <= line)
                {
                    length = (int)( Math.pow( Math.E, (Math.log(Math.E/spacing)/line*x) )*spacing );
                }
                count++;
            }
        }
    }
    
    
    /**
     * creates a morphed checker board pattern on the canvas around the line specified and with
     * the spacing specified. (exponential)
     * specs: width - 400, height - 330, spacing - 33, line - 258
     * 
     * @param int size - the size of each square on the checker board.
     * @param int line - the x value for the vertical line to morph the cherkboard pattern around.
     * @return nothing
     */
    public void checkerPatternExponential(int spacing, int line)
    {
        int count = 0;
        int length = spacing;
        for(int y = 0; y < HEIGHT; y += spacing)
        {
            if(y % (2*spacing) == 0)
                {
                    count = 1;
                }
                else
                {
                    count = 0;
                }
            for(int x = 0; x < WIDTH; x += length)
            {
                if(count % 2 == 0)
                {
                    art.setForegroundColor( Color.WHITE );
                }
                else
                {
                    art.setForegroundColor( Color.BLACK );
                }
                if(x > line)
                {
                    length = (int)( -Math.pow( Math.E, -.0037*(x-400) )*30 + 55 );
                }
                if(x == 0)
                {
                    length = 33;
                }
                art.fillRectangle(x, y, length, spacing);
                if(x > 0 && x <= line)
                {
                    length = (int)( -Math.pow( Math.E, .003*(x-100) )*33 +  55);
                }
                count++;
            }
        }
    }
    

}
