import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Minion here.
 * @version 1.0.1
 */ 

public class Minion extends Actor implements IKeyPadSubject,Component,IWeaponBearer
{
    Chain enemyHandler;
    Chain personHandler;
    Chain backgroundHandler;
    Chain weaponHandler;
    Chain bananaHandler;

    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;

    private int counter_animate = 0;

    private Actor collidedRocket;
    private Actor collidedFarter;

    private List<IKeyPadObserver> observers;
    private String pressedKey;

    private static IWeaponState weaponState;

    private NormalWeapon normalWeapon;
    private SmokerWeapon smokerWeapon;
    private RocketWeapon rocketWeapon;

    private int counter = 0;

    public Minion(){
        observers = new ArrayList<IKeyPadObserver>();

        image1 = new GreenfootImage("minion_LeftUp.png");
        image2 = new GreenfootImage("minion_mid.png");
        image3 = new GreenfootImage("minion_rightUp.png");

        enemyHandler = new EnemyHandler();
        backgroundHandler = new BackgroundHandler();
        weaponHandler = new WeaponHandler();
        bananaHandler = new BananaHandler();

        //Add leafs in reverse order when attaching to chain 

        weaponHandler.setNextChain(bananaHandler);
        backgroundHandler.setNextChain(weaponHandler);
        enemyHandler.setNextChain(backgroundHandler);

        normalWeapon = new NormalWeapon(this);
        smokerWeapon = new SmokerWeapon(this);
        rocketWeapon = new RocketWeapon(this);

        weaponState = normalWeapon;

    }

    /**
     * Act - do whatever the Minion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeyAndMove();
        createBomb();
        checkBombType();
        animate();
        checkCollision();
    }

    public void checkKeyAndMove()
    {
        if(((MinionWorld) getWorld()).getPause() == false)
        {
            notifyObservers();
        }
    }

    public void createBomb()
    {
        if(((MinionWorld) getWorld()).getPause() == false)
        {
            if( ((MinionWorld) getWorld()).getCurrPower() != 0 ){

                if(counter == 0)
                {
                    if (Greenfoot.isKeyDown("space"))
                    {
                        getWorld().addObject(new Bomb(),getX(),getY());
                        counter = 50;

                        //Setting release sounds
                        if(Minion.getWeaponState() instanceof RocketWeapon)
                            Greenfoot.playSound("rocket_launch.mp3");
                        else if(Minion.getWeaponState() instanceof SmokerWeapon)
                            Greenfoot.playSound("smoke_release.mp3");

                        ((MinionWorld) getWorld()).reduceCurrentPower();
                    }
                }
                else
                {
                    counter--;
                }

            }
        }
    }

    public void animate(){

        if( counter_animate == 0 ){

            setImage(image1);
            counter_animate++;
        }
        else if( counter_animate == 20 ){

            setImage(image2);
            counter_animate++;
        }
        else if( counter_animate == 40 ){

            setImage(image3);
            counter_animate++;
        }
        else{
            if( counter_animate > 60 )
                counter_animate = 0;
            else    
                counter_animate++;
        }

    }

    public void checkBombType(){

        collidedRocket = getOneIntersectingObject(Rocket.class);
        collidedFarter = getOneIntersectingObject(Smoker.class);

        if( collidedRocket != null ){
            rocketHit();
        }
        else if( collidedFarter != null ){
            smokerHit();
        }
    }

    public void checkCollision()
    {
        enemyHandler.calculate(this);
    }

    public Actor getCollidedActor(java.lang.Class className){
        return getOneIntersectingObject(className);
    }

    @Override
    public void attachObserver(IKeyPadObserver observer){
        observers.add(observer);
    }

    @Override
    public void detachObserver(IKeyPadObserver observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for(IKeyPadObserver observer : observers){
            observer.keyEventUpdate();
        }
    }

    @Override
    public void initialize(){
    }

    @Override
    public void rocketHit(){
        weaponState.rocketHit();
    }

    @Override
    public void smokerHit(){
        weaponState.smokerHit();
    }

    @Override
    public void setNormalWeapon(){
        weaponState = normalWeapon;
    }

    @Override
    public void setSmokerWeapon(){
        weaponState = smokerWeapon;
    }

    @Override
    public void setRocketWeapon(){
        weaponState = rocketWeapon;
    }

    public static IWeaponState getWeaponState(){
        return weaponState;
    }

}
