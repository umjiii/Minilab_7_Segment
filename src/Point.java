import java.util.*;

public class Point implements PointInterface {


    //data
    int x;
    int y;

    //default constructor
    public Point()
    {
        int x = 2;
        int y = -7;
    }

    //Constructors----------
    //parameterized constructor
    public Point(int theX, int theY)
    {
        this.x = theX;
        this.y = theY;
    }

    //copy contstructor
    public Point(Point thePoint)
    {
        if (thePoint == null)
        {
            throw new IllegalArgumentException("This point is null. Please enter a valid point.");
        }
        else {
            this.x = thePoint.x;
            this.y = thePoint.y;
        }
    }

    //Methods----------
    //toString
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }

    //distanceTo - calculates and returns distance between two points
    public double distanceTo(Point otherPoint)
    {
        if (otherPoint == null)
        {
            throw new IllegalArgumentException("This point does not exist. Please enter a valid point.");
        }
        else
        {
            int x1 = Math.min(otherPoint.x, x);
            int x2 = Math.max(otherPoint.x, x);
            int y1 = Math.min(otherPoint.y, y);
            int y2 = Math.max(otherPoint.y, y);

            int lg = x1 - x2;
            int ht = y2 - y1;
            return Math.hypot(lg, ht);
        }
    }

    //Tests whether or not two points are equal (boolean)
    public boolean equals(Object obj)
    {
        if (obj instanceof Point)
        {
            Point p = (Point)obj; //Casts obj to point so they can be compared.
            if (p == null)
            {
                throw new IllegalArgumentException("This point does not exist. Please enter a valid point.");
            }
            else if (this.x == p.x && this.y == p.y)
            {
                return true;
            }
            else return false;
        }
        else return false;
    }

    //inQuadrant - tests whether or not a point is in a specified quadrant (boolean)
    public boolean inQuadrant (int quadrant)
    {
        boolean quadBool = false;
        if (quadrant < 1 || quadrant > 4)
        {
            throw new IllegalArgumentException("Invalid quadrant. There are only quadrants 1 through 4.");
        }
        switch(quadrant) //switch used with if conditions testing x/y values of corresponding switch quadrant.
        {
            case 1:
                if (x > 0 && y > 0) quadBool = true;
                else quadBool = false;
                break;

            case 2:
                if (x < 0 && y > 0) quadBool = true;
                else quadBool = false;
                break;

            case 3:
                if (x < 0 && y < 0) quadBool = true;
                else quadBool = false;
                break;

            case 4:
                if (x > 0 && y < 0) quadBool = true;
                else quadBool = false;
                break;
        }
        return quadBool;
    }

    //translate
    public void translate(int xMove, int yMove)
    {
        x = x + xMove;
        y = y + yMove;
    }

    @Override
    public boolean onXAxis() {
        return false;
    }

    @Override
    public boolean onYAxis() {
        return false;
    }


}