import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Information here.
 * 
<<<<<<< HEAD
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

=======
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Information  extends Actor implements Component
{
    public void initialize(){
    }
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    /**
     * Act - do whatever the Information wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        click();
<<<<<<< HEAD
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
=======
    }    
    public void click()
    {
       if(Greenfoot.mouseClicked(null))
       {
          ((CarWorld) getWorld()).pauseGame(false);
          getWorld().removeObject(this);
       }
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    }
}
