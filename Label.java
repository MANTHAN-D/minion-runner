import greenfoot.Actor;
import greenfoot.GreenfootImage;
/**
 * Write a description of class Label here.
 * 
 * @author (Manthan) 
 * @version 1.0.1
 */
public class Label extends Actor
{
    // instance variables - replace the example below with your own
    private static String text;

    /**
     * Constructor for objects of class Label
     */
    public Label(String text)
    {
        this.text = text;
        setImage(new GreenfootImage(text,20,null,null));
    }

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
}
