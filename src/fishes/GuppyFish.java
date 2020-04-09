package fishes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GuppyFish extends Fish {

    private String path = "src/pictures/siamese-fighting-fish.png";

    public GuppyFish() {
        super(0,0);
        try {
            setImage(path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GuppyFish(int x, int y) {
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
        System.out.println("drewwwwwwwwwwwwwwwww");
        if (this.image == null)
            return;
        g.drawImage(this.getImage(), this.getCoordX(), this.getCoordY(), this);
    }

    @Override
    public void move() { }

}
