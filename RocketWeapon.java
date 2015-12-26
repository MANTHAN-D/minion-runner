/**
 * Write a description of class RocketWeapon here.
 * 
 * @author (Manthan) 
 * @version 1.0.1
 */
public class RocketWeapon implements IWeaponState
{    
    private IWeaponBearer minion;

    /**
     * Constructor for objects of class NormalWeapon
     */
    public RocketWeapon(IWeaponBearer minion)
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
