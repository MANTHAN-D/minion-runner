import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Banana here.
 * 
 * @author Manthan 
<<<<<<< HEAD
 * @version 1.0.1
=======
 * @version (a version number or a date)
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 */
public class BackgroundHandler implements Chain
{
    private Actor collidedBackground;
    private  Chain nextInChain;
    public void setNextChain(Chain nextInChain) 
    {     
        this.nextInChain = nextInChain;    
    }

<<<<<<< HEAD
    public void calculate(Minion a)    
=======
    public void calculate(Car a)    
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    {
        collidedBackground = a.getCollidedActor(Background.class);
        if (collidedBackground != null)
        {
            a.getWorld().removeObject(collidedBackground);
<<<<<<< HEAD
            ((MinionWorld) a.getWorld()).collided();
=======
            ((CarWorld) a.getWorld()).collided();
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
            Greenfoot.playSound("Explosion.wav");
        }
        else 
        {
            if(nextInChain != null)
                nextInChain.calculate(a);

        }
    }
}
