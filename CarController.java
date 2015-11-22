import greenfoot.*;  // (World, subject, pressedKeyImage, pressedKey and MouseInfo)
/**
 * Controls movement of car.
 * 
 * @author Manthan 
 * @version 0.0.1
 */
public class CarController implements IKeyPadObserver
{   
    private Actor subject;
    /**
     * Constructor for objects of class CarController
     */
    public CarController(IKeyPadSubject subject)
    {
        this.subject = (Actor)subject;
    }

    @Override
    public void keyEventUpdate()
    {
        int x = subject.getX();
        int y = subject.getY();

        if (Greenfoot.isKeyDown("right"))    
        {
            subject.setLocation( x+2, y );
        }
        if (Greenfoot.isKeyDown("left"))    
        {
            subject.setLocation( x-2, y );
        }

    }
}
