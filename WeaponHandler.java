import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 *
 * 
 * @author Jay Sardhara
 * @version 0.0.1
 */
public class WeaponHandler implements Chain
{
    private Actor collidedWeapon;
    private  Chain nextInChain;

    public void setNextChain(Chain nextInChain) 
    {     
        this.nextInChain = nextInChain;    
    }

    public void calculate(Car a) 
    {
        //collidedWeapon = a.getCollidedActor(Weapons.class);
        
        if( a.getCollidedActor(Rocket.class) != null ){
            
          collidedWeapon = a.getCollidedActor(Rocket.class); 
          a.getWorld().removeObject(collidedWeapon);
        }
        else if( a.getCollidedActor(Smoker.class) != null ){
        
          collidedWeapon = a.getCollidedActor(Smoker.class); 
          a.getWorld().removeObject(collidedWeapon);
        }
        
        
        /*if (collidedWeapon != null)
        {
            a.getWorld().removeObject(collidedWeapon);
            //((CarWorld) a.getWorld()).collided();
            Greenfoot.playSound("Explosion.wav");
        }*/
        else 
        {
            if(nextInChain != null)
                nextInChain.calculate(a);
        }
    }

}
