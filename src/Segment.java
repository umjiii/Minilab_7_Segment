public class Segment implements SegmentInterface {
    //data (aggregated)
    private Point startPt;
    private Point endPt ;
    private Point origin = new Point(0,0);



    //---------- constructors
    //default constructor
    public Segment() {

        this.startPt = new Point(1,1);
        this.endPt = new Point(7,7);
    }

    //2-parameterized constructor
    public Segment(Point start, Point end)
    {
        if (start == null || end == null)
        {
            throw new IllegalArgumentException("One of the entered points are null. A segment cannot be created with only one point.");
        }
        else if (start.x == end.x && start.y == end.y)
        {
            throw new IllegalArgumentException("The two points entered are equal, creating an invalid segment of length 0. A segment cannot be created.");
        }
        else {
            this.startPt = start;
            this.endPt = end;
        }
    }

    //single-parameterized constructor
    public Segment(Point end)
    {
        if (end == null)
        {
            throw new IllegalArgumentException("One of the entered points are null. A segment cannot be created without points containing data.");
        }
        else if (end.x == 0 && end.y == 0 )
        {
            throw new IllegalArgumentException("The point entered is equal to the starting point (0,0), creating an invalid segment of 0. A segment cannot be created.");
        }
        else {
            this.startPt = origin;
            this.endPt = end;
        }
    }

    //copy constructor
    public Segment(Segment segCopied)
    {
        if (segCopied == null)
        {
            throw new IllegalArgumentException("The segment entered is null. A segment cannot be created from a segment without data.");
        }
        else
        {
            this.startPt = new Point(segCopied.startPt.x, segCopied.startPt.y);
            this.endPt = new Point(segCopied.endPt.x, segCopied.endPt.y);
        }
    }


    //---------- methods
    public String toString()
    {
        return "Segment" + this.startPt + this.endPt;
    }

    public double length() //right triangle created using points, length = hypotenuse of triangle.
    {
        int x1 = Math.min(this.startPt.x, this.endPt.x);
        int x2 = Math.max(this.startPt.x, this.endPt.x);
        int y1 = Math.min(this.startPt.y, this.endPt.y);
        int y2 = Math.max(this.startPt.y, this.endPt.y);

        int deltaX = Math.abs(x1 - x2);
        int deltaY = Math.abs(y2 - y1);

        return Math.hypot(deltaX, deltaY);
    }

    public void translate(int xmove, int ymove)
    {
        this.startPt.x += xmove;
        this.startPt.y += ymove;

        this.endPt.x += xmove;
        this.endPt.y += ymove;
    }

    public boolean isAnEndpoint(Point p)
    {
        if (p == null)
        {
            throw new IllegalArgumentException("The segment being compared cannot be empty or null.");
        }
        if (p.x == startPt.x)
        {
            return (p.y == startPt.y);
        }
        else if (p.x == endPt.x)
        {
            return (p.y == endPt.y);
        }
        else return false;

    }

    public boolean equals(Object other)
    {
        if (other instanceof Segment)
        {
            Segment otherSeg = (Segment)other; //Casts other to segment so they can be compared.
            if (this.startPt.equals(otherSeg.startPt) && this.endPt.equals(otherSeg.endPt)) return true;
            else if (this.startPt.equals(otherSeg.endPt) && this.endPt.equals(otherSeg.startPt)) return true;
            else return false;
        }
        else return false;
    }












}
