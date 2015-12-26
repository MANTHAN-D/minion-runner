import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rocket class 
 * 
 * @author Jay Sardhara, Manthan
 * @version 1.0.1
 */
public class Rocket  extends Actor implements Component
{
    private GreenfootImage image1;
    private GreenfootImage image2;

    private Actor collided;
    private Actor collidedWeapon;
    public Rocket()
    {
        image1 = new GreenfootImage("rocket.png");
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
            ((MinionWorld) getWorld()).addCurrentPower();
        }
        else if ( getY()>=(getWorld().getHeight()-1) )
        {
            getWorld().removeObject(this);            
        }
    }
}
