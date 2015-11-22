import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Banana here.
 * 
 * @author Manthan
 * @version (a version number or a date)
 */
public class VehicleHandler implements Chain
{
    private Actor collidedVehicle;
    private  Chain nextInChain;

    public void setNextChain(Chain nextInChain) 
    {     
        this.nextInChain = nextInChain;    
    }

    public void calculate(Car a) 
    {
        collidedVehicle = a.getCollidedActor(Vehicle.class);
        if (collidedVehicle != null)
        {
            a.getWorld().removeObject(collidedVehicle);
            ((CarWorld) a.getWorld()).collided();
            Greenfoot.playSound("Explosion.wav");
        }
        else 
        {
            if(nextInChain != null)
                nextInChain.calculate(a);
        }
    }

}
