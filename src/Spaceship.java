import processing.core.PApplet;
public class Spaceship extends Floater
{
    public Spaceship(PApplet applet_)
    {
        super(applet_);
        corners = 4;
        xCorners = new int[corners];
        yCorners = new int[corners];
        xCorners[0] = -8;
        yCorners[0] = -8;
        xCorners[1] = 16;
        yCorners[1] = 0;
        xCorners[2] = -8;
        yCorners[2] = 8;
        xCorners[3] = -2;
        yCorners[3] = 0;
        myColor = 255;
        myCenterX = Math.random() * 1920;
        myCenterY = Math.random() * 1080;
        myXspeed = 2;
        myYspeed = 2;
        myPointDirection = 0;
    }
    public float getX()
    {
        return (float)myCenterX;
    }
    public float getY()
    {
        return (float)myCenterY;
    }
    public double getDirection()
    {
        return myPointDirection;
    }


}
