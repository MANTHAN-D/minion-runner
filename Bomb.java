import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author Jay, Manthan 
 * @version 1.0.1
 */
public class Bomb  extends Actor implements Component
{
    private GreenfootImage image1;
    private GreenfootImage image2;
    private Actor collidedEnemy;
    private Actor collidedBackground;
    public Bomb()
    {

    }

    public void initialize(){
    }

    public void act() 
    {

        if(Minion.getWeaponState() instanceof RocketWeapon){
            setImage(new GreenfootImage("rocket_only.png")); 

        }

        else if(Minion.getWeaponState() instanceof SmokerWeapon){
            setImage(new GreenfootImage("fart_smog.png"));

        }

        moveUp();
        check();
    }

    public void moveUp()
    {
        if(((MinionWorld) getWorld()).getPause() == false)
        {
            setLocation(getX(), getY()-4);
        }
    }

    public void check()
    {
        collidedEnemy = getOneIntersectingObject(Enemy.class);

        collidedBackground = getOneIntersectingObject(Background.class);
        if(collidedEnemy != null  || collidedBackground != null || getY() == 0)
        {

            //Set randimization for collision laugh of minion
            if( Greenfoot.getRandomNumber(2) < 1)
                Greenfoot.playSound("Minion Laugh Sound Effect_01.mp3");
            else if( Greenfoot.getRandomNumber(2) < 1 )
                Greenfoot.playSound("Minion Laugh Sound Effect_02.mp3");
            else
                Greenfoot.playSound("look_at_u.mp3");
            if(collidedEnemy != null)
            {
                ((MinionWorld) getWorld()).addScore(50);
                getWorld().removeObject(collidedEnemy);
            }
            if(collidedBackground != null)
            {
                ((MinionWorld) getWorld()).addScore(75);
                getWorld().removeObject(collidedBackground);
            }
            getWorld().removeObject(this);
        }
    }
}
