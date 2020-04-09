package window;

import factories.*;
import fishes.*;
import interfaces.IFishAbstractFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.TimerTask;
import java.util.Vector;
import java.util.Timer;


public class Habitat extends JPanel {

    protected int MONITOR_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int MONITOR_HEIGHT= Toolkit.getDefaultToolkit().getScreenSize().height;
    protected int PANEL_WIDTH = MONITOR_WIDTH / 2;
    protected int PANEL_HEIGHT= (int) (MONITOR_HEIGHT - MONITOR_HEIGHT * 0.08);

    private static long BEGIN_TIME = 0;
    private static long END_TIME = 0;
    private long GOLDFISH_TIME = 0;
    private long GUPPYFISH_TIME = 0;

    private double P1, P2;
    private int N1, N2;

    private Vector<Fish> fishes;
    private Timer timer;

    private JLabel label;
    private FishFactory fishFactory = new FishFactory();

    public Habitat() {

        super();
        P1 = 0.5;
        P2 = 0.8;
        N1 = 1;
        N2 = 1;
        setBackground(Color.PINK);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
//        label = new JLabel();
//        label.setForeground(Color.BLACK);
//        label.setText("qqqqqqqq");
//        label.setFont(new Font("Dialog", Font.CENTER_BASELINE, 14));
//        label.setVisible(false);
//        add(label);
        setVisible(true);
        setFocusable(true);

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.VK_B) {
                    beginSimulation();
                    System.out.println("B is pressed");
                }
                else if (keyEvent.getKeyCode() == KeyEvent.VK_E) {
                    stopSimulation();
                    System.out.println("E is pressed");
                }
                else if (keyEvent.getKeyCode() == KeyEvent.VK_P) {
                    pauseSimulation();
                    System.out.println("P is pressed");
                }
            }
        });

    }

    public void objectCreator(long time) {

        int imageWidth;
        int imageHeight;
        int coordX;
        int coordY;
        boolean REPAINT = false;

        if ((time - GOLDFISH_TIME) % N1 == 0) {
            GOLDFISH_TIME = time;
            if ((float)Math.random() <= P1 && P1 > 0) {
                Fish fish = fishFactory.makeFactory(FishFactory.FishType.GOLDFISH).createFish();
                imageWidth = fish.getImage().getWidth(null);
                imageHeight = fish.getImage().getHeight(null);
                coordX = (int) (Math.random()*(PANEL_WIDTH - imageWidth - 10));
                coordY = (int) (Math.random()*(PANEL_HEIGHT - imageHeight - 10));
                fish.setCoordX(coordX);
                fish.setCoordY(coordY);
                System.out.println(fish.getCoordX() + " " + fish.getCoordY());
                fishes.addElement(fish);
                REPAINT = true;
            }
        }
        if ((time - GUPPYFISH_TIME) % N2 == 0) {
            GUPPYFISH_TIME = time;
            if ((float)Math.random() <= P2 && P2 > 0) {
                Fish fish = fishFactory.makeFactory(FishFactory.FishType.GUPPYFISH).createFish();
                imageWidth = fish.getImage().getWidth(null);
                imageHeight = fish.getImage().getHeight(null);
                coordX = (int) (Math.random()*(PANEL_WIDTH - imageWidth - 10));
                coordY = (int) (Math.random()*(PANEL_HEIGHT - imageHeight - 10));
                fish.setCoordX(coordX);
                fish.setCoordY(coordY);
                System.out.println(fish.getCoordX() + " " + fish.getCoordY());
                fishes.addElement(fish);
                REPAINT = true;
            }
        }
        if (REPAINT) {
            this.repaint();
        }
    }




    public void beginSimulation() {
        fishes = new Vector<Fish>();
        Timer timer = new Timer();

        BEGIN_TIME = System.currentTimeMillis() / 1000;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            END_TIME = System.currentTimeMillis() / 1000;
            long time = END_TIME - BEGIN_TIME;
//            label.setText("Время: " + time);
            objectCreator(time);
        }
        }, 0, 1000);
    }

    public void stopSimulation() {
    }

    public void pauseSimulation() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fishes != null) {
            for (Fish fish : fishes) {
                this.add(fish);
                this.setVisible(true);
            }
        }

    }

}
