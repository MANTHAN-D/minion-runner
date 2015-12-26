import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dot here.
 * 
 * @author Minion Team
 * @version 1.0.1
 */
public class Dot  extends Actor implements Component
{
    private int counter = 0;
    public void initialize(){
    }

    /**
     * Act - do whatever the Dot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveUp();
        checkLocation();
    }    

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
    }
}
