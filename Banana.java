import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Banana class 
 * 
 * @author Jay Sardhara
 * @version 0.0.1
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
       //image2 = new GreenfootImage("placeholder.png");
       setImage(image1);
       //randomImage();
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
        collided = getOneIntersectingObject(Car.class);
        if (collided != null)
        {
            ((CarWorld) getWorld()).addBananaScore(1);
            getWorld().removeObject(this);
        }
        else if ( getY()>=(getWorld().getHeight()-1) )
        {
            getWorld().removeObject(this);            
        }
    }
}
