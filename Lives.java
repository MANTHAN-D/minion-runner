import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.awt.Font;

/**
 * Counter that displays a number.
 * 
 * @author Michael Kolling
 * @version 1.0.1
 */
public class Lives extends Actor implements Component
{
    public static int valueLives = 3;
    public Lives()
    {
        valueLives = 3;
    }
    public void initialize(){
    }
    public void act()
    {
       valueLives = ((CarWorld) getWorld()).getLives();
       checkValueLives();
    }
    public void checkValueLives()
    {
       if(getX() == 150)
       {
          if(valueLives == 2)
          {
             getWorld().removeObject(this);
          }
       }
       else if(getX() == 100)
       {
          if(valueLives == 1)
          {
             getWorld().removeObject(this);
          }
       }
       else if(getX() == 50)
       {
          if(valueLives == 0)
          {
             Greenfoot.stop();
             getWorld().addObject(new ScoreBoard(),300,300);
          }
       }
    }
}
