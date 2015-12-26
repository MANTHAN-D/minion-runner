import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Banana class 
 * 
 * @author Jay Sardhara, Manthan
 * @version 1.0.1
 */
public class Banana extends Actor implements Component
{
    private GreenfootImage image1;
    private GreenfootImage image2;

    private Actor collided;
    private Actor collidedBanana;
    public Banana()
    {
        image1 = new GreenfootImage("banana.png");
        setImage(image1);
    }

    public void initialize(){
    }

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

    public void check()
    {
        collided = getOneIntersectingObject(Minion.class);
        if (collided != null)
        {
            ((MinionWorld) getWorld()).addBananaScore(1);
            getWorld().removeObject(this);
        }
        else if ( getY()>=(getWorld().getHeight()-1) )
        {
            getWorld().removeObject(this);            
        }
    }
}
