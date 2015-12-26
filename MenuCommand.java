import greenfoot.Actor;
/**
 * Write a description of class MenuCommand here.
 * 
 * @author (your name) 
 * @version 1.0.1
 */
public class MenuCommand implements ICommand
{
    IFunctionReceiver receiver;

    public void execute(Actor actor){
        receiver.perform(actor);
    }

    public void setReceiver( IFunctionReceiver receiver ){
        this.receiver = receiver;
    }
}
