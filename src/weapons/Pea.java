package weapons;

import aiming.AimingInterface;
import game.GamePanel;

/**
 * Created by Armin on 6/25/2016.
 */
public class Pea {

    private int posX;
    protected GamePanel gp;
    private int myLane;
    private AimingInterface aiming;

    public Pea(GamePanel parent, int lane, int startX, AimingInterface aiming) {
        this.gp = parent;
        this.myLane = lane;
        this.posX = startX;
        this.aiming = aiming;
    }

    public void advance() {
        /*if(posX > 2000){
            gp.lanePeas.get(myLane).remove(this);
        }*/
        posX += 15;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getMyLane() {
        return myLane;
    }

    public void setMyLane(int myLane) {
        this.myLane = myLane;
    }
}
