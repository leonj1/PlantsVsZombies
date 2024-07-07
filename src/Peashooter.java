import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * Created by Armin on 6/25/2016.
 */
public class Peashooter extends Plant {

    public Timer shootTimer;


    public Peashooter(GamePanel parent, int x, int y) {
        super(parent, x, y);
        shootTimer = new Timer(500, (ActionEvent e) -> {
            //System.out.println("SHOOT");
            ArrayList<ArrayList<Zombie>> zombiesPerLane = getGp().getLaneZombies();
            if (zombiesPerLane.size()>0) {
                for (int i = 0; i < zombiesPerLane.size(); i++) {
                    ArrayList<Zombie> zombies = zombiesPerLane.get(i);
                    for (int j = 0; j < zombies.size(); j++) {
                        Zombie zombie = zombies.get(j);
                        getGp()
                            .getLanePeas()
                            .get(y)
                            .add(
                                new MachineGunPea(
                                    getGp(),
                                    y,
                                    103 + this.getX() * 100,
                                    zombie.getPosX(),
                                    zombie.getMyLane()
                                )
                            );
                    }
                }
            }
//            if (getGp().getLaneZombies().get(y).size() > 0) {
//                getGp().getLanePeas().get(y).add(new Pea(getGp(), y, 103 + this.getX() * 100));
//            }
        });
        shootTimer.start();
    }

    @Override
    public void stop() {
        shootTimer.stop();
    }

}
