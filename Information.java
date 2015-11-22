import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Information here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Information  extends Actor implements Component
{
    public void initialize(){
    }
    /**
     * Act - do whatever the Information wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        click();
    }    
    public void click()
    {
       if(Greenfoot.mouseClicked(null))
       {
          ((CarWorld) getWorld()).pauseGame(false);
          getWorld().removeObject(this);
       }
    }
}
