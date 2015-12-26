import greenfoot.Actor;
/**
 * Write a description of interface IMenuInvoker here.
 * 
 * @author (your name) 
 * @version 1.0.1
 */
public interface IMenuInvoker  
{
   public void setCommand(ICommand c);
   public void invoke(Actor actor);
}
