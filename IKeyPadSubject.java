/**
 * Interface for Subject.
 * 
 * @author Manthan H. 
 * @version 1.0.1
 */
public interface IKeyPadSubject  
{
   void attachObserver(IKeyPadObserver o);
   void detachObserver(IKeyPadObserver o);
   void notifyObservers();
}