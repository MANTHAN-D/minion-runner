/**
 * Interface for Subject.
 * 
 * @author Manthan H. 
<<<<<<< HEAD
 * @version 1.0.1
=======
 * @version v0.0.1
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 */
public interface IKeyPadSubject  
{
   void attachObserver(IKeyPadObserver o);
   void detachObserver(IKeyPadObserver o);
   void notifyObservers();
}