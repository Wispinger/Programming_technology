package fishes;

import interfaces.IBehaviour;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

abstract public class Fish extends JPanel implements IBehaviour {

    private int coordX;
    private int coordY;
    protected Image image;
    private static int COUNT = 0;

    public Fish(int x, int y) {
        super();
        this.coordX = x;
        this.coordY = y;
        COUNT++;
    }

    public int getCoordX() {
        return this.coordX;
    }

    public int getCoordY() {
        return this.coordY;
    }

    public void setCoordX(int x) {
        this.coordX = x;
    }

    public void setCoordY(int y) {
        this.coordY = y;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(String path) throws IOException {
        image = ImageIO.read(new File(path));
    }

    @Override
    public void paintComponent(Graphics g) { }

}
