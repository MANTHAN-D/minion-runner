import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndLine here.
 * 
<<<<<<< HEAD
 * @author Minion Team
 * @version 1.0.1
=======
 * @author (your name) 
 * @version (a version number or a date)
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 */
public class EndLine  extends Actor implements Component
{
    public void initialize(){
    }
<<<<<<< HEAD

=======
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    /**
     * Act - do whatever the EndLine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveDown();
        checkLocation();
    }    
<<<<<<< HEAD

    public void moveDown()
    {
        setLocation(getX(), getY()+4);
    }

    public void checkLocation()
    {
        if (getY()>=(getWorld().getHeight()-1))
        {
            Greenfoot.stop();
            getWorld().addObject(new ScoreBoard("finish"),300,300);
            getWorld().removeObject(this);
        }
=======
    public void moveDown()
    {
       setLocation(getX(), getY()+4);
    }
    public void checkLocation()
    {
       if (getY()>=(getWorld().getHeight()-1))
       {
          Greenfoot.stop();
          getWorld().addObject(new ScoreBoard(),300,300);
          getWorld().removeObject(this);
       }
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    }
}
