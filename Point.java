/**
 * creates a point on a cartesian plane.
 * 
 * @author Ben Johnson 
 * @version 12/23/2016
 */
public class Point
{
    //fields
    private int x;
    private int y;
    private final static int SECOND_POWER = 2;

    
    /**
     * Constructor for the point class, creates a point with the specified location.
     * 
     * @param int x - the x postition for the point relative to the cartiesian plane.
     * @param int y - the y postition for the point relative to the cartiesian plane.
     * @return nothing
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    
    /**
     * returns the x-coordinate of this point
     * 
     * @param none
     * @return the x-coordinate
     */
    public int getX()
    {
        return x;
    }
    
    
    /**
     * returns the y-coordinate of this point
     * 
     * @param none
     * @return the y-coordinate
     */
    public int getY()
    {
        return y;
    }
    
    
    /**
     * calculates the distance between the exiting point and another specified point.
     * 
     * @param Point other - the other point.
     * @return double distance - the distance between the 2 points.
     */
    public double distance(Point other)
    {
        double yDistance = Math.pow(getY()-other.getY(), SECOND_POWER);
        double xDistance = Math.pow(getX()-other.getX(), SECOND_POWER);
        return Math.sqrt(yDistance + xDistance);
    }
    
    
    /**
     * calculates the slope between the existing point and another specified point.
     * 
     * @param Point other - the other point.
     * @return double slope - the slope between the two points.
     */
    public double slope(Point other)
    {
        double rise = other.getY() - getY();
        double run = other.getX() - getX();
        if(run != 0)
        {
            return rise/run;
        }
        else
        {
            return Double.NaN;
        }
    }
    
    
}
