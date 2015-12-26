import greenfoot.Actor;
/**
 * Command interface.
 * 
 * @author (your name) 
 * @version 1.0.1
 */
public interface ICommand  
{
    public void execute(Actor actor);
    void setReceiver( IFunctionReceiver target ) ;
}
