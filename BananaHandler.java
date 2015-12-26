import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * 
 * @author Jay Sardhara
<<<<<<< HEAD
 * @version 1.0.1
=======
 * @version 0.0.1
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 */
public class BananaHandler implements Chain
{
    private Actor collidedBanana;
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
        collidedBanana = a.getCollidedActor(Banana.class);
        if (collidedBanana != null)
        {
            a.getWorld().removeObject(collidedBanana);
<<<<<<< HEAD
=======
            //((CarWorld) a.getWorld()).collided();
            Greenfoot.playSound("Explosion.wav");
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
        }
        else 
        {
            if(nextInChain != null)
                nextInChain.calculate(a);
        }
    }

}
