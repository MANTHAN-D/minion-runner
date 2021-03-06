import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MinionWorld here.
 * 
 * @author MinionTeam
 * @version 1.0.1
 */
public class MinionWorld extends World implements Component
{
    private int counter;
    private int lives;
    private int score;
    private boolean pause;
    private Minion minion;
    private List<Component> leafs;

    private int bananaScore;
    private int _currPower;
    private boolean _init = true;
    private Bar bar;
    private Bar lifeBar;
    private Label weaponBarLabel;
    private Label lifeBarLabel;

    //Sound variables
    GreenfootSound intro;
    GreenfootSound inGame;     

    /**
     * Constructor for objects of class MinionWorld.
     * 
     */
    public MinionWorld()
    {
        super(600, 600, 1);
        setPaintOrder(Start.class, Help.class, Pause.class, Information.class, ScoreBoard.class, Dot.class, Path.class, Minion.class, Bomb.class, Enemy.class,EndLine.class, Counter.class, Background.class);

        //Setting background sound resources
        setBackgroundSounds();

        lives = 100;
        score = 0;
        pause = true;
        //changes by Manthan start
        minion = new Minion();
        minion.attachObserver(new MinionController(minion));
        //Changes by manthan end
        leafs = new ArrayList<Component>();
        add(minion,305,550);
        add(new Counter("Score: "),95,550);
        add(new Dot(), 25, 395);
        add(new Path(), 25, 250);

        // Banana score visualization
        add(new BananaScore("Banana Score: "), 150, 580 );

        //Weapon Power visualization
        weaponBarLabel = new Label("Weapon Power");
        bar = new Bar("", "Weapon Strength", 0, 25);
        bar.setShowTextualUnits(false); 
        addObject(bar, 500 , 50 );
        addObject(weaponBarLabel, 500,35);

        //Life visualization
        lifeBarLabel = new Label("Life");
        lifeBar = new Bar("", "Life", 0, 100);
        lifeBar.setShowTextualUnits(false); 
        addObject(lifeBar, 70 , 50 );         
        lifeBar.setValue(100);
        addObject(lifeBarLabel, 70, 35);

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
        add(new Start(),480,550);
        add(new Help(),550,550); 
    }

    public void initialize(){

    }

    public void act()
    {
        if(pause == false)
        {
            chanceToEnemy();
            chanceToBackground();
            chanceToRocket();
            chanceToSmoker();
            chanceToBanana();

            changeWeaponBar();
            chanceLifeBar(); 

        }
    }

    public void setBackgroundSounds(){

        intro = new GreenfootSound("intro.mp3");

        inGame = new GreenfootSound("minion_theme_01.mp3");

    }

    public void toggleMusic(){

        if(getPause()){

            inGame.pause();
            intro.playLoop();
        }
        else{

            intro.pause();
            inGame.playLoop();
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

    public void chanceToEnemy()
    {
        if(Greenfoot.getRandomNumber(100)<1)
        {
            add(new Enemy(), Greenfoot.getRandomNumber(185)+215, 0);
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

    public void changeWeaponBar(){

        if(_init){
            _init = false;

            //Give some weapon power initially 
            _currPower = 5 ;
            bar.setValue((int)_currPower);
        }
        else
            bar.setValue((int)_currPower);            
    }

    public void chanceLifeBar(){

        lifeBar.setValue(lives);
    }

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
        return bananaScore;
    }

    public void addBananaScore(int scoreToAdd)
    {
        bananaScore += scoreToAdd;
    }

    public int getCurrPower(){
        return _currPower;
    }

    public void addCurrentPower()
    {
        /*
         * Set 3% of remaining bar everytime
         * Hence power collection would reduce over time
         *
         */
        if(_currPower != 25)
            _currPower += 0.3 * (25 - _currPower);
    }

    public void reduceCurrentPower()
    {
        /*
         * Reduce 10% of current bar everytime
         */

        if(_currPower != 0)
            _currPower -= 0.1 * _currPower;
    }

    public int getLives()
    {
        return lives;
    }

    public void collided()
    {
        /*
         * Reduce 30% of current bar everytime
         */

        if(lives != 0)
            lives -= 0.2 * 100;
        else
        {
            Greenfoot.stop();
            add(new ScoreBoard("dead"),300,300);
        }
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
