import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MarioGame extends JFrame implements KeyListener {
    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 730;

    private JPanelWithBackground bgpanel;
    private Mario mario;
    private Obstacle[] obstacles;
    private String absolutePath;

    public MarioGame() {

        Path resourceDirectory = Paths.get("resources");
        absolutePath = resourceDirectory.toFile().getAbsolutePath();

        setTitle("Super Mario Game");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image imgIcon = new ImageIcon(absolutePath + "/SuperMario_background.png").getImage();
        JPanelWithBackground bgpanel = new JPanelWithBackground(imgIcon);
        bgpanel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        Image marioRunImage = new ImageIcon(absolutePath + "/mario_running.png").getImage();
        Image marioJumpImage = new ImageIcon(absolutePath + "/mario_jumping.png").getImage();
        mario = new Mario(5);
        mario.setMarioRun(marioRunImage);
        mario.setMarioJump(marioJumpImage);
        mario.setHeight(100);
        mario.setWidth(100);
        mario.setX(150);
        mario.setY(FRAME_HEIGHT - mario.getHeight() - 130);
        obstacles = new Obstacle[3];
        Image obstacleImage = new ImageIcon(absolutePath + "/obstacle.png").getImage();
        for (int i = 0; i < 3; i++) {
            obstacles[i] = new Obstacle();
            obstacles[i].setObstacle(obstacleImage);
            obstacles[i].setHeight(100);
            obstacles[i].setWidth(100);
            obstacles[i].setX(400 + i * 200);
            obstacles[i].setY(FRAME_HEIGHT - obstacles[i].getHeight() - 230);
            bgpanel.add(obstacles[i]);
        }
        bgpanel.add(mario);
        bgpanel.addKeyListener(this);
        getContentPane().add(bgpanel);
        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        mario.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        mario.keyReleased(e);
    }

    public void start() {
        mario.moveMario(FRAME_WIDTH);
    }

    public static void main(String[] args) {
        MarioGame game = new MarioGame();
        game.setVisible(true);
        game.start();
    }


}
