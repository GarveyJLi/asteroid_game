import processing.core.PApplet;
public class Shield extends Floater
{
    public Shield(PApplet _applet, Spaceship theShip)
    {
        super(_applet);
        myCenterX = theShip.getX();
        myCenterY = theShip.getY();
        myXspeed = theShip.myXspeed;
        myYspeed = theShip.myYspeed;
    }
    public float getX()
    {
        return (float)myCenterX;
    }
    public float getY()
    {
        return (float)myCenterY;
    }
    public void show()
    {
        applet.fill(255,0,0);
        applet.ellipse((float)myCenterX, (float)myCenterY, 60,60);
    }
    public void move(float x, float y)
    {
        myCenterX = x;
        myCenterY = y;
    }
}
