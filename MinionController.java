import greenfoot.*;  // (World, subject, pressedKeyImage, pressedKey and MouseInfo)
/**
 * Controls movement of Minion.
 * 
 * @author Manthan 
 * @version 1.0.1
 */
public class MinionController implements IKeyPadObserver
{   
    private Actor subject;
    /**
     * Constructor for objects of class MinionController
     */
    public MinionController(IKeyPadSubject subject)
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
            subject.setLocation( x+4, y );
        }
        if (Greenfoot.isKeyDown("left"))    
        {
            subject.setLocation( x-4, y );
        }

    }
}
