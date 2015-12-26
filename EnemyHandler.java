import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class EnemyHandler here.
 * 
 * @author Manthan
 * @version 1.0.1
 */
public class EnemyHandler implements Chain
{
    private Actor collidedEnemy;
    private  Chain nextInChain;

    public void setNextChain(Chain nextInChain) 
    {     
        this.nextInChain = nextInChain;    
    }

    public void calculate(Minion a) 
    {
        collidedEnemy = a.getCollidedActor(Enemy.class);
        if (collidedEnemy != null)
        {
            a.getWorld().removeObject(collidedEnemy);
            ((MinionWorld) a.getWorld()).collided();
            Greenfoot.playSound("Explosion.wav");
        }
        else 
        {
            if(nextInChain != null)
                nextInChain.calculate(a);
        }
    }

}
