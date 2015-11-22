import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class CarWorld here.
 * 
 * @author MinionTeam
 * @version 0.0.1
 */
public class CarWorld extends World implements Component
{
    private int counter;
    private int lives;
    private int score;
    private boolean pause;
    private Car car;
    private List<Component> leafs;
    
    private int BananaScore;
    public Bar bar = new Bar("", "Weapon Strength", 0, 100);
        
    /**
     * Constructor for objects of class CarWorld.
     * 
     */
    public CarWorld()
    {
        super(600, 600, 1);
        setPaintOrder(Information.class, ScoreBoard.class, Dot.class, Path.class, Car.class, Bomb.class, Vehicle.class, Person.class, PedestrianCrossing.class,EndLine.class, Line.class, Counter.class, Lives.class, Background.class);
        Greenfoot.playSound("BackgroundMusic.mid");
        lives = 3;
        score = 0;
        pause = true;
        //changes by Manthan start
        car = new Car();
        car.attachObserver(new CarController(car));
        //Changes by manthan end
        leafs = new ArrayList<Component>();
        add(car,305,550);
        add(new Counter("Score: "),100,550);
        add(new Lives(),50,50);
        add(new Lives(),100,50);
        add(new Lives(),150,50);
        add(new Dot(), 25, 395);
        add(new Path(), 25, 250);
            
        // Banana score visualization
        add(new bananaScore("Banana Score"), 500, 550 );
        //Weapon Power visualization
        bar.setShowTextualUnits(false); 
        addObject(bar, 400 , 50 );
        
        /*add(new Line(),300,0);
        add(new Line(),300,90);
        add(new Line(),300,180);
        add(new Line(),300,270);
        add(new Line(),300,360);
        add(new Line(),300,450);
        add(new Line(),300,540);*/
        add(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        add(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        add(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        add(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        add(new Background(), Greenfoot.getRandomNumber(150), Greenfoot.getRandomNumber(600));
        add(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        add(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        add(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        add(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        add(new Background(), Greenfoot.getRandomNumber(150)+450, Greenfoot.getRandomNumber(600));
        add(new Information(),300,300);
    }

    public void initialize(){

    }
    public void act()
    {
        if(pause == false)
        {
            chanceToVehicle();
            chanceToBackground();
            chanceToRocket();
            chanceToSmoker();
            chanceToBanana();
            //setCounter();
            //chanceToPedestrianCrossing();
        }
    }

    public void chanceToBackground()
    {
        if(Greenfoot.getRandomNumber(50)<1)
        {
            add(new Background(), Greenfoot.getRandomNumber(150), 0);
        }
        if(Greenfoot.getRandomNumber(50)<1)
        {
            add(new Background(), Greenfoot.getRandomNumber(150)+450, 0);
        }
    }

    public void chanceToVehicle()
    {
        if(Greenfoot.getRandomNumber(100)<1)
        {
            add(new Vehicle(), Greenfoot.getRandomNumber(185)+215, 0);
        }
    }
    
    public void chanceToRocket()
    {
        if(Greenfoot.getRandomNumber(1000)<1)
        {
            add(new Rocket(), Greenfoot.getRandomNumber(185)+215, 0);
        }
    }
    
    public void chanceToSmoker()
    {
        if(Greenfoot.getRandomNumber(1000)<1)
        {
            add(new Smoker(), Greenfoot.getRandomNumber(185)+215, 0);
        }
    }
    
    public void chanceToBanana()
    {
        if(Greenfoot.getRandomNumber(100)<1)
        {
            add(new Banana(), Greenfoot.getRandomNumber(185)+215, 0);
        }
    }

    /*public void setCounter()
    {
        counter++;
        if (counter == 23)
        {
            add(new Line(),300,0);
            counter = 0;
        }
    }*/

    /*public void chanceToPedestrianCrossing()
    {
        if (Greenfoot.getRandomNumber(1000)<1)
        {
            add(new PedestrianCrossing(), 220, 0);
            add(new PedestrianCrossing(), 280, 0);
            add(new PedestrianCrossing(), 340, 0);
            add(new PedestrianCrossing(), 400, 0);
            add(new Person(), 180, 0);
        }
    }*/

    public void add(Component component,int x, int y) {
        leafs.add(component);
        addObject((Actor)component,x,y);
    }

    public void remove(Component component) {
        leafs.remove(component);
    }

    public int getScore()
    {
        return score;
    }

    public void addScore(int scoreToAdd)
    {
        score += scoreToAdd;
    }

    public int getBananaScore()
    {
        return BananaScore;
    }

    public void addBananaScore(int scoreToAdd)
    {
        BananaScore += scoreToAdd;
    }
    
    
    public int getLives()
    {
        return lives;
    }

    public void collided()
    {
        lives--;
    }

    public boolean getPause()
    {
        return pause;
    }

    public void pauseGame(boolean paused)
    {
        pause = paused;
    }
}
