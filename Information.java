import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Information here.
 * 
 * @author Manthan
 * @version 1.0.1
 */
public class Information  extends Actor implements Component, IMenuInvoker
{
    private ICommand exitHelp;

    public Information(){
        exitHelp = new MenuCommand();
        exitHelp.setReceiver(new IFunctionReceiver() {
                public void perform(Actor actor){
                    ((MinionWorld) getWorld()).pauseGame(false);
                    getWorld().removeObject(actor);
                }
            });
        setCommand(exitHelp);
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
        if(Greenfoot.mouseClicked(null))
        {
            invoke(this); 
        }
    }

    public void initialize(){
    }

    public void setCommand(ICommand command){
        exitHelp = command;
    }

    public void invoke(Actor actor){
        exitHelp.execute(actor);
    }
}
