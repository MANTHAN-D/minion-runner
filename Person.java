import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person  extends Actor implements Component
{
    public void initialize(){
    }
    /**
     * Act - do whatever the person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveDownAndRight();
        checkLocation();
    }    
    public void moveDownAndRight()
    {
       if(((CarWorld) getWorld()).getPause() == false)
       {
          setLocation(getX()+Greenfoot.getRandomNumber(3)+2, getY()+4);
       }
    }
    public void checkLocation()
    {
       if (getX()>= 450 || getY()>=(getWorld().getHeight()-1))
       {
          getWorld().removeObject(this);
       }
    }
}
