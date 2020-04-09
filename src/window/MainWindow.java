package window;

import factories.FishFactory;
import fishes.GoldFish;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private Habitat habitat;

    public MainWindow() {
        super("My application");
        habitat = new Habitat();
        initGUI();
    }

    private void initGUI(){
        setVisible(true);
        setLocation(habitat.MONITOR_WIDTH/4,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(habitat);
        pack();
    }


}
