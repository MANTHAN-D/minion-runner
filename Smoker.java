import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Smoker  class 
 * 
 * @author Jay Sardhara
 * @version 0.0.1
 */
public class Smoker  extends Actor implements Component
{
    private GreenfootImage image1;
       
    private Actor collided;
    private Actor collidedWeapon;
    public Smoker()
    {
       
       image1 = new GreenfootImage("farter.png");
           
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
        collided = getOneIntersectingObject(Smoker.class);
        if (collided != null || getY()>=(getWorld().getHeight()-1))
        {
           getWorld().removeObject(this);
        }
    }
}
