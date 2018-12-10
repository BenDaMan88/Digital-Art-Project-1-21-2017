import java.awt.Color;

/**
 * Creates a checkerboard patterened art piece.
 * 
 * @author Ben Johnson
 * @version 12/23/2016
 */
public class CheckerBoard
{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final Color BG = new Color(255, 255, 255);
    private Canvas art;
    
    /**
     * Constructor for the checker board class. Creates a canvas with a checkerboard pattern.
     * 
     * @param none
     * @return nothing
     */
    public CheckerBoard()
    {
        art = new Canvas("Checker Board", WIDTH, HEIGHT, BG);
        art.setVisible(true);
        checkerPattern(25);
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
    
    
}




