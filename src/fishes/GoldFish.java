package fishes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GoldFish extends Fish {

    private String path = "src/pictures/goldfish.png";


    public GoldFish() {
        super(0,0);
        try {
            setImage(path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GoldFish(int x, int y) {
        super(x, y);
        try {
            setImage(path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        System.out.println("drewwwwwwwwwwwww");
        if (this.image == null)
            return;
        g.drawImage(this.getImage(), this.getCoordX(), this.getCoordY(), this);
    }

    @Override
    public void move() { }

}
