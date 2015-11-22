import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line  extends Actor implements Component
{
    public Line()
    {
       //It might be easier to create a white line image for this section
       //declare a variable called image to store a greenfoot image
       GreenfootImage image = new GreenfootImage(10, 60);
       //specify white as current paint color of image
       image.setColor (java.awt.Color.WHITE);
       //now fill the image with color
       image.fill();
       setImage (image);
    }
    public void initialize(){
    }
     /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
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
