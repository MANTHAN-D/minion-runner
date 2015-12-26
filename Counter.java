import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

import java.awt.Font;

/**
 * Counter that displays a number.
 * 
<<<<<<< HEAD
 * @author Minion Team
=======
 * @author Michael Kolling
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 * @version 1.0.1
 */
public class Counter extends Actor implements Component
{
    public static int value = 0;
    public static int target = 0;
    public static String text;
    public static int stringLength;
    public Counter()
    {
        this("");
    }
<<<<<<< HEAD

=======
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    public Counter(String prefix)
    {
        value = 0;
        target = 0;
        text = prefix;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));  // use larger font
<<<<<<< HEAD

        updateImage();
    }

    public void initialize(){
    }

    public void act()
    {
        target = ((MinionWorld) getWorld()).getScore();
        if(value > target)
        {
            value = 0;
            updateImage();
        }
        updateImage();
    }

=======
        
        updateImage();
    }
    public void initialize(){
    }
    public void act()
    {
       target = ((CarWorld) getWorld()).getScore();
       if(value > target)
       {
          value = 0;
          updateImage();
       }
       updateImage();
    }
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    public void add(int score)
    {
        target += score;
    }
<<<<<<< HEAD

=======
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    public int getValue()
    {
        return value;
    }
<<<<<<< HEAD

=======
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    /**
     * Make the image
     */
    public void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + target, 1, 18);
    }
}
