import java.awt.*;

public class MachineGunPea extends Pea {
    private int posX;
    protected GamePanel gp;
    private int myLane;
    private int zombieX;
    private int zombieY;

    public MachineGunPea(GamePanel parent, int lane, int startX, int zombieX, int zombieY) {
        super(parent, lane, startX);
        this.gp = parent;
        this.myLane = lane;
        this.posX = startX;
        this.zombieX = zombieX;
        this.zombieY = zombieY;
    }

    public void advance() {
        Rectangle pRect = new Rectangle(posX, 130 + myLane * 120, 28, 28);
        this.posX += 15;
        if (this.zombieY > this.myLane) {
            this.myLane += 1;
        } else {
            this.myLane -= 1;
        }
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
