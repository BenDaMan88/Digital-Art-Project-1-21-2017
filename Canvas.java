import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.BasicStroke;


/**
 * Class Canvas - a class to allow for simple graphical 
 * drawing on a canvas.
 * 
 * @author Michael Kolling (mik)
 * @author Bruce Quig
 *
 * @version 1.8  (23.01.2002)
 */

public class Canvas
{
    //fields
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private BasicStroke pen;
    private int width = 300;
    private int height = 300;
    private final static int DEFAULT_POINT_SIZE = 2;
    private final static int HALF = 2;
    private final static int RED_DISTANCE = 50;
    private final static int ORANGE_DISTANCE = 100;
    private final static int YELLOW_DISTANCE = 200;
    
    
    /**
     * Create a Canvas with default height, width and background color 
     * (300, 300, white).
     * @param title  title to appear in Canvas Frame     
     */
    public Canvas(String title)
    {
        this(title, 300, 300, Color.white);
    }

    
    /**
     * Create a Canvas with default background color (white).
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     */
    public Canvas(String title, int width, int height)
    {
        this(title, width, height, Color.white);
        this.width = width;
        this.height = height;
    }

    
    /**
     * Create a Canvas.
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background color of the canvas
     */
    public Canvas(String title, int width, int height, Color bgColor)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColor = bgColor;
        frame.pack();
        this.width = width;
        this.height = height;
    }

    
    /**
     * plots the specified point on the canvas with the default point size.
     * 
     * @param Point p - a point to plot.
     * @return nothing
     */
    public void plotPoint(Point p)
    {
        plotPoint(p, DEFAULT_POINT_SIZE);
    }

    
    /**
     * plots the specified point on the canvas with the specified diameter.
     * 
     * @param Point p - the point to plot.
     * @param int diameter - the diameter for the plotted point.
     */
    public void plotPoint(Point p, int diameter)
    {
        fillCircle(p.getX() + width/HALF - diameter/HALF, p.getY() + height/HALF - diameter/HALF, diameter);
    }
    
    
    /**
     * plots a randomly generated point with a randomly generated location on the canvas.
     * 
     * @param none.
     * @return nothing.
     */
    public void plotRandom()
    {
        plotPoint(randomPoint());
    }
    
    
    /**
     * generates a rendom coordinate (only x or y, not both) within the size of the width of the canvas.
     * 
     * @param none.
     * @return int - the random coordinate that was generated.
     */
    public int randomCoord()
    {
        return -width/HALF + (int)(Math.random() * width);
    }
    
    
    /**
     * generates a random point with a set of random coordinates (both an x and y).
     * 
     * @param none.
     * @return Point - the random point generated.
     */
    public Point randomPoint()
    {
        return new Point(randomCoord(), randomCoord());
    }
    
    
    /**
     * creates a map of locations that are safe and nbot safe to go if there is a downed power line.
     * 
     * @param Point start - the location of the downed power line.
     * @param int numOfLocations - the number of random points to draw on the screen. 
     */
    public void safteyMap(Point start, int numOfLocations)
    {
        for(int i = 0; i < numOfLocations; i++)
        {
            Point p = randomPoint();
            if(start.distance(p) < RED_DISTANCE)
            {
                setForegroundColor(Color.RED);
                plotPoint(p);
            }
            else if(start.distance(p) >=  RED_DISTANCE && start.distance(p) < ORANGE_DISTANCE)
            {
                setForegroundColor(Color.ORANGE);
                plotPoint(p);
            }
            else if(start.distance(p) >=  ORANGE_DISTANCE && start.distance(p) < YELLOW_DISTANCE)
            {
                setForegroundColor(Color.YELLOW);
                plotPoint(p);
            }
            else
            {
                setForegroundColor(Color.GREEN);
                plotPoint(p);
            }
        }
        setForegroundColor(Color.BLACK);
    }
    
    
    /**
     * Set the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    public void setVisible(boolean visible)
    {
        if(graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(true);
    }

    
    /**
     * Provide information on visibility of the Canvas.
     * @return  true if canvas is visible, false otherwise
     */
    public boolean isVisible()
    {
        return frame.isVisible();
    }

    
    /**
     * Draw the outline of a given shape onto the canvas.
     * @param  shape  the shape object to be drawn on the canvas
     */
    public void draw(Shape shape)
    {
        graphic.draw(shape);
        canvas.repaint();
    }

    
    /**
     * Sets the "pen size" to given size (thickness)
     * @param size the thickness of the pend
     */
    public void setPenSize(int size)
    {
        pen = new BasicStroke(size);
        graphic.setStroke(pen);
    }

    
    /**
     * Fill the internal dimensions of a given shape with the current 
     * foreground color of the canvas.
     * @param  shape  the shape object to be filled 
     */
    public void fill(Shape shape)
    {
        graphic.fill(shape);
        canvas.repaint();
    }

    
    /**
     * Fill the internal dimensions of the given circle with the current 
     * foreground color of the canvas.
     */
    public void fillCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        fill(circle);
    }

    
    /**
     * Fill the internal dimensions of the given rectangle with the current 
     * foreground color of the canvas. This is a convenience method. A similar 
     * effect can be achieved with the "fill" method.
     */
    public void fillRectangle(int xPos, int yPos, int width, int height)
    {
        fill(new Rectangle(xPos, yPos, width, height));
    }

    
    /**
     * Erase the whole canvas.
     */
    public void erase()
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
        canvas.repaint();
    }

    
    /**
     * Erase the internal dimensions of the given circle. This is a 
     * convenience method. A similar effect can be achieved with
     * the "erase" method.
     */
    public void eraseCircle(int xPos, int yPos, int diameter)
    {
        Ellipse2D.Double circle = new Ellipse2D.Double(xPos, yPos, diameter, diameter);
        erase(circle);
    }

    
    /**
     * Erase the internal dimensions of the given rectangle. This is a 
     * convenience method. A similar effect can be achieved with
     * the "erase" method.
     */
    public void eraseRectangle(int xPos, int yPos, int width, int height)
    {
        erase(new Rectangle(xPos, yPos, width, height));
    }

    
    /**
     * Erase a given shape's interior on the screen.
     * @param  shape  the shape object to be erased 
     */
    public void erase(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.fill(shape);              // erase by filling background color
        graphic.setColor(original);
        canvas.repaint();
    }

    
    /**
     * Erases a given shape's outline on the screen.
     * @param  shape  the shape object to be erased 
     */
    public void eraseOutline(Shape shape)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.draw(shape);  // erase by drawing background color
        graphic.setColor(original);
        canvas.repaint();
    }

    
    /**
     * Draws an image onto the canvas.
     * @param  image   the Image object to be displayed 
     * @param  x       x co-ordinate for Image placement 
     * @param  y       y co-ordinate for Image placement 
     * @return  returns boolean value representing whether the image was 
     *          completely loaded 
     */
    public boolean drawImage(Image image, int x, int y)
    {
        boolean result = graphic.drawImage(image, x, y, null);
        canvas.repaint();
        return result;
    }

    
    /**
     * Draws a String on the Canvas.
     * @param  text   the String to be displayed 
     * @param  x      x co-ordinate for text placement 
     * @param  y      y co-ordinate for text placement
     */
    public void drawString(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
        canvas.repaint();
    }

    
    /**
     * Erases a String on the Canvas.
     * @param  text     the String to be displayed 
     * @param  x        x co-ordinate for text placement 
     * @param  y        y co-ordinate for text placement
     */
    public void eraseString(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColor);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
        canvas.repaint();
    }

    
    /**
     * Draws a line on the Canvas.
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        graphic.drawLine(x1, y1, x2, y2);   
        canvas.repaint();
    }

    
    /**
     * Sets the foreground color of the Canvas.
     * @param  newColor   the new color for the foreground of the Canvas 
     */
    public void setForegroundColor(Color newColor)
    {
        graphic.setColor(newColor);
    }

    
    /**
     * Returns the current color of the foreground.
     * @return   the color of the foreground of the Canvas 
     */
    public Color getForegroundColor()
    {
        return graphic.getColor();
    }

    
    /**
     * Sets the background color of the Canvas.
     * @param  newColor   the new color for the background of the Canvas 
     */
    public void setBackgroundColor(Color newColor)
    {
        backgroundColor = newColor;   
        graphic.setBackground(newColor);
    }

    
    /**
     * Returns the current color of the background
     * @return   the color of the background of the Canvas 
     */
    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    
    /**
     * changes the current Font used on the Canvas
     * @param  newFont   new font to be used for String output
     */
    public void setFont(Font newFont)
    {
        graphic.setFont(newFont);
    }

    
    /**
     * Returns the current font of the canvas.
     * @return     the font currently in use
     **/
    public Font getFont()
    {
        return graphic.getFont();
    }

    
    /**
     * Sets the size of the canvas.
     * @param  width    new width 
     * @param  height   new height 
     */
    public void setSize(int width, int height)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        Image oldImage = canvasImage;
        canvasImage = canvas.createImage(width, height);
        graphic = (Graphics2D)canvasImage.getGraphics();
        graphic.drawImage(oldImage, 0, 0, null);
        frame.pack();
    }

    
    /**
     * Returns the size of the canvas.
     * @return     The current dimension of the canvas
     */
    public Dimension getSize()
    {
        return canvas.getSize();
    }

    
    /**
     * Waits for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number 
     */
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            // ignoring exception at the moment
        }
    }


    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel
    {
        
        public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
        
    }
    
    
    

    /**
    * Sample showing using a copy of our "graphic context" to rotate a rectangle.
    */
    public void rotateTest(){
        this.setVisible(true); // we have to do this to create the graphic field as it happens in that method
    
        /** Create a copy of the graphics context so we can use it to rotate without messing up other drawing **/
        Graphics2D g2d = (Graphics2D) graphic.create();
        g2d.setColor(Color.blue); // set this context to blue to show it is different than the one we draw on normally
        /** Make a box **/
        Rectangle box = new Rectangle(0, 0, 50, 50);
    
        /** Move our new context to the center of the canvas since we made the box at 0, 0 **/
        g2d.translate(canvas.getWidth()/2, canvas.getHeight()/2);
        /** Draw the box on the original graphic context from our canvas - notice it is at top left and is black! **/
        draw(box);
        /** Rotate the copy of the graphics context we made 45 degrees (rotate uses radians so we convert first) **/
        g2d.rotate(Math.toRadians(60));
        g2d.draw(box);
    
        /** Do it again and change the color to show it **/
        g2d.setColor(Color.red);
        g2d.rotate(Math.toRadians(60));
        g2d.draw(box);
        /** We can dispose of this context if we use a loop to draw lots of boxes in different places **/
        g2d.dispose();
    }
    
        /** 
    * Creates and fills a blue triangle with vertices at (50,100), (100,100) and (75, 150).
    */
    public void fillTriangleTest(){
        // We have to do this before we can draw on it! We'll get a NullPointerException otherwise since the graphics aren't created yet
        this.setVisible(true);
        // Create arrays for the x and y coordinates of our polygon vertices
        int[] xCoords = {50, 100, 75};
        int[] yCoords = {100, 100, 150};
        // Pick a color to draw it in
        setForegroundColor(Color.blue);
        // Pass them into the constructor for a Polygon which happens to implement the Shape interface (I'll explain soon enough...)
        Shape triangle = new Polygon(xCoords, yCoords, 3);
        // Now we can use the fill method and pass in the Shape (our triangle)
        fill(triangle);
    }
    
}
