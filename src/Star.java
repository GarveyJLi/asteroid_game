import processing.core.PApplet;

public class Star extends Floater
{
    public Star(PApplet applet_)
    {
        super(applet_);
        myCenterX = Math.random() * 1920;
        myCenterY = Math.random() * 1080;
    }


    public void show()
    {
        applet.fill(255,255,0);
        applet.ellipse((float)myCenterX, (float)myCenterY, 10,10);
    }
}
