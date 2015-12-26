import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nature here.
 * 
<<<<<<< HEAD
 * @author Jay Sardhara, Manthan
 * @version 1.0.1
 */
public class Background  extends Actor implements Component
{

    private Actor collided;

=======
 * @author Jay Sardhara  
 * @version 0.0.1
 */
public class Background  extends Actor implements Component
{
    
    private Actor collided;
  
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    private GreenfootImage image4;
    private GreenfootImage image5;
    private GreenfootImage image6;
    private int collidedOn;
    public Background()
    {
<<<<<<< HEAD
        collidedOn = 0;

        image4 = new GreenfootImage("tree.png");
        image5 = new GreenfootImage("tree2.png");
        image6 = new GreenfootImage("stone.png");
        randomImage();

    }

    public void initialize(){
    }

    /**
=======
       collidedOn = 0;
       
       image4 = new GreenfootImage("tree.png");
       image5 = new GreenfootImage("tree2.png");
       image6 = new GreenfootImage("stone.png");
       randomImage();
       
    }
    public void initialize(){
    }
     /**
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
     * Act - do whatever the House4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
            setLocation(getX(), getY()+4);
        }
    }

    public void randomImage()
    {
        if (Greenfoot.getRandomNumber(6)<1)
        {
            setImage(image4);
        }
        else if (Greenfoot.getRandomNumber(6)<1)
        {
            setImage(image5);
        }
        else{

            setImage(image6);
        }

    }

    public void check()
    {
        if (getY()>=(getWorld().getHeight()-1))
        {
            getWorld().removeObject(this);
=======
    public void moveDown()
    {
       if(((CarWorld) getWorld()).getPause() == false)
       {
          setLocation(getX(), getY()+4);
       }
    }
    public void randomImage()
    {
        if (Greenfoot.getRandomNumber(6)<1)
       {
          setImage(image4);
       }
       else if (Greenfoot.getRandomNumber(6)<1)
       {
          setImage(image5);
       }
       else{
           
            setImage(image6);
       }
       
    }
     public void check()
    {
        if (getY()>=(getWorld().getHeight()-1))
        {
           getWorld().removeObject(this);
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
        }
    }
}
