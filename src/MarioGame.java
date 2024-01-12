import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MarioGame extends JFrame {
    private static final int FRAME_WIDTH = 1200;
    private static final int FRAME_HEIGHT = 730;

    private JPanelWithBackground bgpanel;
    private Mario mario;
    private Obstacle obstacle;
    private String absolutePath;

    public MarioGame() {

        Path resourceDirectory = Paths.get( "resources");
        absolutePath = resourceDirectory.toFile().getAbsolutePath();

        setTitle("Super Mario Game");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image imgIcon = new ImageIcon(absolutePath+"/SuperMario_background.png").getImage();
        JPanelWithBackground bgpanel = new JPanelWithBackground(imgIcon);
        bgpanel.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);


        Image marioImage = new ImageIcon(absolutePath+"/SuperMario_Image.png").getImage();
        mario = new Mario(5);
        mario.setMario(marioImage);
        mario.setHeight(100); mario.setWidth(100);
        mario.setX(150); mario.setY(FRAME_HEIGHT - mario.getHeight()-130);
        Image obstacleImage = new ImageIcon(absolutePath+"/SuperMario_Obstacles.png").getImage();
        obstacle = new Obstacle();
        obstacle.setObstacle(obstacleImage);
        obstacle.setX(400); obstacle.setY(FRAME_HEIGHT - obstacle.getHeight() - 230);
        obstacle.setWidth(100); obstacle.setHeight(100);
        bgpanel.add(mario);
        bgpanel.add(obstacle);

        getContentPane().add(bgpanel);

    }

    public void start(){
        mario.moveMario(FRAME_WIDTH);
    }

    public static void main(String[] args) {
        MarioGame game = new MarioGame();
        game.start();
        game.setVisible(true);
    }

}
