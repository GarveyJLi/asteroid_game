import processing.core.PApplet;

import java.util.ArrayList;

public class AsteroidsGame extends PApplet
{
    //variable declarations here
    Spaceship s;
    Star[] stars = new Star[100];
    ArrayList<Asteroid> a = new ArrayList<Asteroid>(100);
    ArrayList<Bullet> b = new ArrayList<Bullet>();
    private int shots = 0;
    private int count = 0;
    private int hits = 0;
    private int score = 0;
    private int respawns = 0;
    private int destroy = 0;
    private int timer;
    Shield shield;


    public static void main(String[] args)
    {
        PApplet.main("AsteroidsGame");
    }

    public void settings()
    {
        size(1920, 1080);
    }

    public void setup()
    {
        s = new Spaceship(this);
        shield = new Shield(this, s);
        for (int i = 0; i < stars.length; i++)
        {
            stars[i] = new Star(this);
            a.add(i, new Asteroid(this));

        }
    }

    public void draw() //throws ArrayIndexOutOfBoundsException
    {
        background(0);
        textSize(32);
        text("Hits Taken: " + hits, 1500, 30);
        text("Asteroids Destroyed: " + destroy, 1500, 60);
        text("Score: " + score, 1500, 80);
        text("A good score is positive", 0, 30);
        text("Asteroids: " + (a.size() - 1), 0, 60);

        for (int i = 0; i < a.size() - 1; i++)
        {
            a.get(i).show();
            a.get(i).move();
            if ((dist(s.getX(), s.getY(), a.get(i).getX(), a.get(i).getY()) < 20))
            {
                a.remove(i);
                hits++;
                score -= 1000;
                textSize(20);
                text("-1000", s.getX(), s.getY());
                destroy++;

            }

            for (int x = 0; x < b.size() - 1; x++)
            {
                if (dist(b.get(x).getX(), b.get(x).getY(), a.get(i).getX(), a.get(i).getY()) < 20)
                {
                    b.remove(x);
                    count++;
                    respawns--;
                    if (count < 20)
                    {
                        score += 10;
                        textSize(20);
                        text("+10", b.get(x).getX(), b.get(x).getY());
                    }
                    if (count >= 20)
                    {
                        count = 0;
                        a.remove(i);
                        score += 20;
                        textSize(20);
                        text("+20", b.get(x).getX(), b.get(x).getY());
                        destroy++;
                    }
                }
                if (b.size() > 200)
                {
                    b.remove(0);
                    respawns++;
                }
            }
        }

        for (int i = 0; i < 100; i++)
        {
            stars[i].show();
        }
        for (int i = 0; i < b.size(); i++)
        {
            b.get(i).show();
            b.get(i).move();
        }
        s.show();
        s.move();
        if (keyPressed)
        {
            if (keyCode == LEFT)
            {
                s.turn(-10);
            }
            if (keyCode == RIGHT)
            {
                s.turn(10);
            }
            if (keyCode == UP)
            {
                s.accelerate(.1);
            }
            if (key == 'e')
            {
                s.myXspeed = 0;
                s.myYspeed = 0;
                s.myCenterX = Math.random() * 1920;
                s.myCenterY = Math.random() * 1080;
                score -= 5;
                textSize(20);
                text("-5", s.getX(), s.getY());
            }
            if (keyCode == DOWN)
            {
                s.myXspeed *= 0.99;
                s.myYspeed *= 0.99;
            }
            if (key == 'd')
            {
                //shots++;
                //if (shots == 2)
                {
                    shots = 0;
                    b.add(new Bullet(this, s));
                    score--;
                }
                if (respawns > 100)
                {
                    a.add(new Asteroid(this));
                    respawns = 0;
                }
            }
            if (key == 'a')
            {
                shots++;
                if (shots == 2)
                {
                    shots = 0;
                    if (timer < 30)
                    {
                        for (int i = 0; i < 30; i++)
                        {
                            b.add(new Bullet(this, s));
                            score--;
                            timer++;
                        }
                    }
                    if (timer >= 30)
                    {
                        timer++;
                    }
                    if (timer == 40)
                    {
                        timer = 0;
                    }
                }
                if (respawns > 100)
                {
                    a.add(new Asteroid(this));
                    respawns = 0;
                }
            }

            if (key == ' ')
            {
                shield.show();
                shield.move(s.getX(), s.getY());
                textSize(20);
                text("-5", s.getX(), s.getY());
                score -= 5;
                for (int i = 0; i < a.size(); i++)
                {
                    if ((dist(shield.getX(), shield.getY(), a.get(i).getX(), a.get(i).getY()) < 50))
                    {
                        score -= 250;
                        a.remove(i);
                        text("-250", s.getX(), s.getY());
                        destroy++;
                    }
                }
            }

        }
    }
}
