/**
 * Write a description of class SmokerWeapon here.
 * 
 * @author (Manthan) 
 * @version 1.0.1
 */
public class SmokerWeapon implements IWeaponState
{    
    private IWeaponBearer minion;

    /**
     * Constructor for objects of class NormalWeapon
     */
    public SmokerWeapon(IWeaponBearer minion)
    {
        this.minion = minion;
    }

    public void smokerHit(){
        minion.setSmokerWeapon();
    }

    public void rocketHit(){
        minion.setRocketWeapon();
    }

}
