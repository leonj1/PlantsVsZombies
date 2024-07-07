package aiming;

import game.GamePanel;
import players.Zombie;

import java.awt.*;

public class AimingDownLane implements AimingInterface {
    protected GamePanel gp;
    private int posX;
    private int myLane;

    @Override
    public String fire() {
        Rectangle pRect = new Rectangle(posX, 130 + myLane * 120, 28, 28);
        for (int i = 0; i < gp.getLaneZombies().get(myLane).size(); i++) {
            Zombie z = gp.getLaneZombies().get(myLane).get(i);
            Rectangle zRect = new Rectangle(z.getPosX(), 109 + myLane * 120, 400, 120);
            if (pRect.intersects(zRect)) {
                z.setHealth(z.getHealth() - 300);
                boolean exit = false;
                if (z.getHealth() < 0) {
                    System.out.println("ZOMBIE DIED");

                    gp.getLaneZombies().get(myLane).remove(i);
                    GamePanel.setProgress(10);
                    exit = true;
                }
                gp.getLaneZombies().get(myLane).remove(this);
                if (exit) break;
            }
        }
    }
}
