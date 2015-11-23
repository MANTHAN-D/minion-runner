import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Car here.
 */ 

public class Car extends Actor implements IKeyPadSubject,Component
{
    Chain vehicleHandler;
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
    public static boolean isRocket = false;
    public static boolean isSmoker = false;
    
    private List<IKeyPadObserver> observers;
    private String pressedKey;

    private int counter = 0;

    public Car(){
        observers = new ArrayList<IKeyPadObserver>();

        image1 = new GreenfootImage("minion_LeftUp.png");
        image2 = new GreenfootImage("minion_mid.png");
        image3 = new GreenfootImage("minion_rightUp.png");
        
        vehicleHandler = new VehicleHandler();
        personHandler = new PersonHandler();
        backgroundHandler = new BackgroundHandler();
        weaponHandler = new WeaponHandler();
        bananaHandler = new BananaHandler();
        
        //Add leafs in reverse order when attaching to chain 
        
        weaponHandler.setNextChain(bananaHandler);
        backgroundHandler.setNextChain(weaponHandler);
        personHandler.setNextChain(backgroundHandler);
        vehicleHandler.setNextChain(personHandler);
               
    }

    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKeyAndMove();
        createBomb();
        checkBombType();
        animate();
        checkCollision();
        click();
        
    }

    public void checkKeyAndMove()
    {
        if(((CarWorld) getWorld()).getPause() == false)
        {
            notifyObservers();
        }
    }

    public void createBomb()
    {
        if(((CarWorld) getWorld()).getPause() == false)
        {
            if( ((CarWorld) getWorld()).getCurrPower() != 0 ){
                
                if(counter == 0)
                {
                    if (Greenfoot.isKeyDown("space"))
                    {
                        getWorld().addObject(new Bomb(),getX(),getY());
                        counter = 50;
                    
                        ((CarWorld) getWorld()).reduceCurrentPower();
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
            //System.out.println("rocket set");
            isRocket = true;
            isSmoker = false;
        }
        else if( collidedFarter != null ){
            //System.out.println("smoker set");            
            isRocket = false;
            isSmoker = true;
        }
    }
    
    public void checkCollision()
    {
        vehicleHandler.calculate(this);
    }

    public void click()
    {
        if(Greenfoot.mouseClicked(null))
        {
            if(((CarWorld) getWorld()).getPause() == false)
            {
                ((CarWorld) getWorld()).pauseGame(true);
                getWorld().addObject(new Information(),300,300);
            }
        }
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
}
