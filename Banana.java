import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Banana class 
 * 
<<<<<<< HEAD
 * @author Jay Sardhara, Manthan
 * @version 1.0.1
=======
 * @author Jay Sardhara
 * @version 0.0.1
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 */
public class Banana extends Actor implements Component
{
    private GreenfootImage image1;
    private GreenfootImage image2;
<<<<<<< HEAD

=======
    
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    private Actor collided;
    private Actor collidedBanana;
    public Banana()
    {
<<<<<<< HEAD
        image1 = new GreenfootImage("banana.png");
        setImage(image1);
    }

    public void initialize(){
    }

=======
       image1 = new GreenfootImage("banana.png");
       //image2 = new GreenfootImage("placeholder.png");
       setImage(image1);
       //randomImage();
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
            ((MinionWorld) getWorld()).addBananaScore(1);
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
            ((CarWorld) getWorld()).addBananaScore(1);
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
            getWorld().removeObject(this);
        }
        else if ( getY()>=(getWorld().getHeight()-1) )
        {
            getWorld().removeObject(this);            
        }
    }
}
