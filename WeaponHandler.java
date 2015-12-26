import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
<<<<<<< HEAD
 * @author Jay Sardhara
 * @version 1.0.1
=======
 *
 * 
 * @author Jay Sardhara
 * @version 0.0.1
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 */
public class WeaponHandler implements Chain
{
    private Actor collidedWeapon;
    private  Chain nextInChain;

    public void setNextChain(Chain nextInChain) 
    {     
        this.nextInChain = nextInChain;    
    }

<<<<<<< HEAD
    public void calculate(Minion a) 
    {

        if( a.getCollidedActor(Rocket.class) != null ){

            collidedWeapon = a.getCollidedActor(Rocket.class); 
            a.getWorld().removeObject(collidedWeapon);
        }
        else if( a.getCollidedActor(Smoker.class) != null ){

            collidedWeapon = a.getCollidedActor(Smoker.class); 
            a.getWorld().removeObject(collidedWeapon);
        }
=======
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
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
        else 
        {
            if(nextInChain != null)
                nextInChain.calculate(a);
        }
    }

}
