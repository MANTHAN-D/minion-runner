import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Start here.
 * 
 * @author Manthan
 * @version 1.0.1
 */
public class Pause extends Actor implements Component, IMenuInvoker
{
    private ICommand haultGame;

    public Pause(){
        haultGame = new MenuCommand();
        haultGame.setReceiver(new IFunctionReceiver() {
                public void perform(Actor actor){
                    ((MinionWorld) getWorld()).pauseGame(true);

                    //toggles Music
                    ((MinionWorld) getWorld()).toggleMusic();

                    ((MinionWorld) getWorld()).add(new Start(),480,550);
                    getWorld().removeObject(actor); 
                }
            });
        setCommand(haultGame);
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
        haultGame = command;
    }

    public void invoke(Actor actor){
        haultGame.execute(actor);
    }
}
