import java.awt.*;

/**
 * Creates cube op art
 * 
 * @author Ben Johnson 
 * @version 1/21/2017
 */
public class CubeArt
{
    private int width;
    private int height;
    private Canvas window;

    public CubeArt()
    {
        window = new Canvas("ART!", 600, 600, Color.BLUE);
        window.setVisible(true);
        width = 600;
        height = 600;
    }

    public CubeArt(int WIDTH, int HEIGHT)
    {
        window = new Canvas("ART!", WIDTH, HEIGHT);
        window.setVisible(true);
        width = WIDTH;
        height = HEIGHT;
    }

    public void clear()
    {
        window.erase();
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
        for(int y = 0; y < height; y += spacing)
        {
            if(y % (2*spacing) == 0)
            {
                count = 1;
            }
            else
            {
                count = 0;
            }
            for(int x = 0; x < height; x += spacing)
            {
                if(count % 2 == 0)
                {
                    window.setForegroundColor( Color.WHITE );
                }
                else
                {
                    window.setForegroundColor( Color.BLACK );
                }
                window.fillRectangle(x, y, spacing, spacing);
                count++;
            }
        }
    }

    public void cubetest1()
    {
        int[] xCoords = {0, 0, 25, 25};
        int[] yCoords = {0, 25, 42, 17};
        window.setForegroundColor(Color.BLACK);
        Shape cube = new Polygon(xCoords, yCoords, 4);
        window.fill(cube);
    }

    public void cube(int spacing)
    {
        int count = 0;
        int start = (width -spacing*8)/2;
        int y = (height - spacing*8)/2+30;
        for(int j = 0; j <= spacing * 3; j += spacing){
            for(int i = 0+start; i < spacing * 4+start; i += spacing)
            {
                if(count % 2 == 0)
                {
                    window.setForegroundColor( Color.BLACK );
                }
                else
                {
                    window.setForegroundColor( Color.WHITE );
                }
                int[] xCoords = {i, i, i+spacing, i+spacing};
                int[] yCoords = {i/2+j+start +y, i/2+spacing+j+start +y, (i+spacing)/2+spacing+j+start +y, (i+spacing)/2+j+start +y};
                Shape cube = new Polygon(xCoords, yCoords, 4);
                window.fill(cube);
                count++;
            }
            count++;
        }

        count = 0;
        int startY = spacing*2+start;
        for(int j = 0; j <= spacing * 3; j += spacing){
            for(int i = 0+start+spacing*4; i < spacing * 8+start; i += spacing)
            {
                if(count % 2 == 0)
                {
                    window.setForegroundColor( Color.BLACK );
                }
                else
                {
                    window.setForegroundColor( Color.WHITE );
                }
                int[] xCoords = {i, i, i+spacing, i+spacing};
                int[] yCoords = {startY+j+spacing/2 -(i-start-spacing*4)/2 +y, startY+spacing+j+spacing/2 -(i-start-spacing*4)/2 +y, startY+spacing+j -(i-start-spacing*4)/2 +y, startY+j -(i-start-spacing*4)/2 +y};
                Shape cube = new Polygon(xCoords, yCoords, 4);
                window.fill(cube);
                count++;
            }
            count++;
        }
        
        count = 1;
        for(int j = 0; j <= spacing * 3; j += spacing){
            for(int i = 0+start; i < spacing * 4+start; i += spacing)
            {
                if(count % 2 == 0)
                {
                    window.setForegroundColor( Color.BLACK );
                }
                else
                {
                    window.setForegroundColor( Color.WHITE );
                }
                int[] xCoords = {i+j, i+spacing+j, i+spacing*2+j, i+spacing+j};
                int[] yCoords = {i/2-j/2+start +y, (i+spacing)/2-j/2+start +y, i/2-j/2+start +y, (i+spacing)/2-spacing-j/2+start +y};
                Shape cube = new Polygon(xCoords, yCoords, 4);
                window.fill(cube);
                count++;
            }
            count++;
        }
    }
}
