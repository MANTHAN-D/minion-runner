import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rocket class 
 * 
 * @author Jay Sardhara
 * @version 0.0.1
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
       //setRotation(90);
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
       if(((CarWorld) getWorld()).getPause() == false)
       {
          collided = getOneIntersectingObject(PedestrianCrossing.class);
          if (collided == null)
          {
             setLocation(getX(), getY()+Greenfoot.getRandomNumber(3)+5);
          }
          else
          {
             setLocation(getX(), getY()+Greenfoot.getRandomNumber(4));
          }
       }
    }
    
    public void check()
    {
        collided = getOneIntersectingObject(Rocket.class);
        if (collided != null || getY()>=(getWorld().getHeight()-1))
        {
           getWorld().removeObject(this);
        }
    }
}