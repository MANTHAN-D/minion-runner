import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rocket class 
 * 
<<<<<<< HEAD
 * @author Jay Sardhara, Manthan
 * @version 1.0.1
=======
 * @author Jay Sardhara
 * @version 0.0.1
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 */
public class Rocket  extends Actor implements Component
{
    private GreenfootImage image1;
    private GreenfootImage image2;
<<<<<<< HEAD

=======
   
    
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    private Actor collided;
    private Actor collidedWeapon;
    public Rocket()
    {
<<<<<<< HEAD
        image1 = new GreenfootImage("rocket.png");
        setImage(image1);
    }

    public void initialize(){
    }

=======
       image1 = new GreenfootImage("rocket.png");
       setImage(image1);
       //setRotation(90);
    }
    public void initialize(){
    }
        
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    public void act() 
    {
        moveDown();
        check();
    }
<<<<<<< HEAD

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
=======
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
            ((CarWorld) getWorld()).addCurrentPower();
            //getWorld().removeObject(this);
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
        }
        else if ( getY()>=(getWorld().getHeight()-1) )
        {
            getWorld().removeObject(this);            
        }
    }
}
