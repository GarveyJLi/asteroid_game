import processing.core.PApplet;
public class Bullet extends Floater
{
    public Bullet(PApplet _applet, Spaceship theShip)
    {
        super(_applet);
        myCenterX = theShip.getX();
        myCenterY = theShip.getY();
        myPointDirection = Math.random() *  7 + theShip.getDirection() - 3;
        super.accelerate(20);
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
        applet.ellipse((float)myCenterX, (float)myCenterY, 5,5);
    }
    public void move()
    {
        myCenterX += myXspeed;
        myCenterY += myYspeed;
    }
}
