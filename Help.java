import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Help here.
 * 
 * @author Manthan 
 * @version 1.0.1
 */
public class Help extends Actor implements Component, IMenuInvoker
{
    private ICommand viewHelp;

    public Help(){
        viewHelp = new MenuCommand();
        viewHelp.setReceiver(new IFunctionReceiver() {
                public void perform(Actor actor){
                    ((MinionWorld) getWorld()).pauseGame(true);
                    getWorld().addObject(new Information(),300,300);
                }
            });
        setCommand(viewHelp);
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
        viewHelp = command;
    }

    public void invoke(Actor actor){
        viewHelp.execute(actor);
    }
}
