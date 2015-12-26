import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Start here.
 * 
 * @author Manthan
 * @version 1.0.1
 */
public class Start extends Actor implements Component, IMenuInvoker
{
    private ICommand playGame;

    public Start(){
        playGame = new MenuCommand();
        playGame.setReceiver(new IFunctionReceiver() {
                public void perform(Actor actor){
                    ((MinionWorld) getWorld()).pauseGame(false);

                    //toggles Music
                    ((MinionWorld) getWorld()).toggleMusic();

                    ((MinionWorld) getWorld()).add(new Pause(),480,550);
                    getWorld().removeObject(actor);
                }
            });
        setCommand(playGame);       
    }

    /**
     * Act - do whatever the Information wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        click();
    }            

    public void click()
    {
        if(Greenfoot.mouseClicked(this))
        {
            invoke(this);

        }
    }

    public void initialize(){
    }

    public void setCommand(ICommand command){
        playGame = command;
    }

    public void invoke(Actor actor){
        playGame.execute(actor);
    }
}
