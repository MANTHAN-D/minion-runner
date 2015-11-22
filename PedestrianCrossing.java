import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PedestrianCrossing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PedestrianCrossing  extends Actor implements Component
{
    public PedestrianCrossing()
    {
       GreenfootImage image = new GreenfootImage(40, 80);
       image.setColor (java.awt.Color.WHITE);
       image.fill();
       setImage (image);
    }
    public void initialize(){
    }
     /**
     * Act - do whatever the PedestrianCrossing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       moveDown();
       checkLocation();
    }    
    public void moveDown()
    {
       if(((CarWorld) getWorld()).getPause() == false)
       {
          setLocation(getX(), getY()+4);
       }
    }
    public void checkLocation()
    {
       if (getY()>=(getWorld().getHeight()-1))
       {
          getWorld().removeObject(this);
       }
    }
}
