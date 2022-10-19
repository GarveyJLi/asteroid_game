import processing.core.PApplet;
public class Asteroid extends Floater
{
    private double rotSpeed;
    public Asteroid(PApplet applet_)
    {
        super(applet_);
        myCenterX = Math.random() * 1920;
        myCenterY = Math.random() * 1080;
        myXspeed = (int) (Math.random() * 5) - 2;
        myYspeed = (int) (Math.random() * 5) - 2;
        corners = 6;
        xCorners = new int[corners];
        yCorners = new int[corners];
        xCorners[0] = -11;//(int)(Math.random() * 3) - 10;
        yCorners[0] = -8;//(int)(Math.random() * 3) - 1;
        xCorners[1] = 7;//(int) (Math.random() * 3) - 8;
        yCorners[1] = -8;//(int)(Math.random() * 3) - 8;
        xCorners[2] = 13;//(int)(Math.random() * 3) - 8;
        yCorners[2] = 0;//(int)(Math.random() * 3) + 6;
        xCorners[3] = 6;//(int)(Math.random() * 3) -1;
        yCorners[3] = 10;//(int)(Math.random() * 4) + 10;
        xCorners[4] = -11;//(int)(Math.random() * 3) + 6;
        yCorners[4] = 8;//(int)(Math.random() * 4) + 10;
        xCorners[5] = -5;//(int)(Math.random() * 4) + 10;
        yCorners[5] = 0;//(int)(Math.random() * 4) - 10;
        rotSpeed = (int)(Math.random() * 20) - 10;
        myColor = 100;

    }
    public float getX()
    {
        return (float)myCenterX;
    }
    public float getY()
    {
        return (float)myCenterY;
    }
    public void move()
    {
        turn(rotSpeed);
        super.move();
    }

}
