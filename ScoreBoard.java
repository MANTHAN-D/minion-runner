import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

/**
 * The ScoreBoard is used to display results on the screen. It can display some
<<<<<<< HEAD
 * text and some numbers.
 * 
 * @author Manthan
 * @version 1.0.1
=======
 * text and several numbers.
 * 
 * @author M Kolling
 * @version 1.0
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
 */
public class ScoreBoard extends Actor implements Component
{
    public static final float FONT_SIZE = 48.0f;
<<<<<<< HEAD
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
=======
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    
    /**
     * Create a score board with dummy result for testing.
     */
    public ScoreBoard()
    {
        this(Counter.target, Lives.valueLives);
    }
    public void initialize(){
    }
    /**
     * Create a score board for the final result.
     */
    public ScoreBoard(int score, int lives)
    {
       makeImage("Game Over", "Score: ", "Lives: ", score, lives);
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
    }

    /**
     * Make the score board image.
     */
<<<<<<< HEAD
    private void makeImage(String prefix1, int score)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
        GreenfootImage endImage;                
=======
    private void makeImage(String title, String prefix1, String prefix2, int score, int lives)
    {
        GreenfootImage image = new GreenfootImage(WIDTH, HEIGHT);
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467

        image.setColor(new Color(0, 0, 0, 160));
        image.fillRect(0, 0, WIDTH, HEIGHT);
        image.setColor(new Color(255, 255, 255, 100));
        image.fillRect(5, 5, WIDTH-10, HEIGHT-10);
        Font font = image.getFont();
        font = font.deriveFont(FONT_SIZE);
        image.setFont(font);
        image.setColor(Color.WHITE);
<<<<<<< HEAD

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

=======
        image.drawString(title, 60, 100);
        image.drawString(prefix1 + score, 60, 200);
        image.drawString(prefix2 + lives, 60, 250);
>>>>>>> f94fd9031aa73377e96e9b72c468865abc01c467
        setImage(image);
    }
}
