import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author Jay 
 * @version 1.0.1
 */
public class Enemy extends Actor implements Component
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private GreenfootImage image4;

    private Actor collided;
    public Enemy()
    {
        image1 = new GreenfootImage("purple_minion.png");
        image2 = new GreenfootImage("purple_minion2.png");
        image3 = new GreenfootImage("purple_minion3.png");

        randomImage();
    }

    public void initialize(){
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveDown();
        check();
    }

    public void moveDown()
    {
        if(((MinionWorld) getWorld()).getPause() == false)
        {
            setLocation(getX(), getY()+Greenfoot.getRandomNumber(3)+5);
        }
    }

    public void randomImage()
    {
        //Play default purpule minion sound by default, when spawned
        Greenfoot.playSound("baah.mp3");

        if (Greenfoot.getRandomNumber(4)<1)
        {
            setImage(image1);
        }
        else if (Greenfoot.getRandomNumber(4)<1)
        {
            setImage(image2);
        }
        else 
        {
            setImage(image3);
        }           
    }

    public void check()
    {
        collided = getOneIntersectingObject(Enemy.class);
        if (collided != null || getY()>=(getWorld().getHeight()-1))
        {
            getWorld().removeObject(this);
        }
    }
}
