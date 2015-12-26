import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dot here.
 * 
<<<<<<< HEAD
 * @author Minion Team
 * @version 1.0.1
=======
 * @author (your name) 
 * @version (a version number or a date)
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 */
public class Dot  extends Actor implements Component
{
    private int counter = 0;
    public void initialize(){
    }
<<<<<<< HEAD

=======
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    /**
     * Act - do whatever the Dot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveUp();
        checkLocation();
    }    
<<<<<<< HEAD

    public void moveUp()
    {
        if(((MinionWorld) getWorld()).getPause() == false)
        {
            if(counter == 0)
            {
                setLocation(getX(), getY()-1);
                counter = 30;
            }
            else
            {
                counter--;
            }
        }
    }

    public void checkLocation()
    {
        if(getY() == 117)
        {
            setLocation(getX(), getY()-1);
            getWorld().addObject(new EndLine(), 307, 0);
        }
=======
    public void moveUp()
    {
       if(((CarWorld) getWorld()).getPause() == false)
       {
          if(counter == 0)
          {
             setLocation(getX(), getY()-1);
             counter = 30;
          }
          else
          {
             counter--;
          }
       }
    }
    public void checkLocation()
    {
       if(getY() == 117)
       {
          setLocation(getX(), getY()-1);
          getWorld().addObject(new EndLine(), 307, 0);
       }
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    }
}
