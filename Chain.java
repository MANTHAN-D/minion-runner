import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Chain here.
 * 
 * @author Manthan
 * @version 1.0.1
 */
public interface Chain
{
    public void setNextChain(Chain nextInChain);
	public void calculate(Minion a);		
}
