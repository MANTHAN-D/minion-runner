import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
 * text and some numbers.
 * 
 * @author Manthan
 * @version 1.0.1
 */
public class ScoreBoard extends Actor implements Component
{
    public static final float FONT_SIZE = 48.0f;
    public static final int WIDTH = 410;
    public static final int HEIGHT = 400;
    private String state;

    /**
     * Create a score board with dummy result for testing.
     */
    public ScoreBoard(String state)
    {
        this(Counter.target, state);
    }

    public void initialize(){
    }

    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score,String state)
    {
        this.state = state;
        makeImage("Score: ", score);
    }

    /**
     * Make the score board image.
     */
    private void makeImage(String prefix1, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        GreenfootImage endImage;                

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);

        if("dead".equals(state)){
            endImage = new GreenfootImage("death3.jpg");
            image.drawString("Awwwwww", 80, 65);
            image.drawImage(endImage,5,105);
            image.drawString(prefix1 + score, 80, 365);
        }
        else{
            endImage = new GreenfootImage("raceCompletion3.jpg");
            image.drawString("Yuppiieee", 80, 65);
            image.drawImage(endImage,5,105);
            image.drawString(prefix1 + score, 80, 365);
        }

        setImage(image);
    }
}
