import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MarioGame extends JFrame {
    private static final int FRAME_WIDTH = 1500;
    private static final int FRAME_HEIGHT = 800;

    private Background bgpanel;
    private Mario mario;
    private Obstacle obstacle;

    public MarioGame() {
        setTitle("Super Mario Game");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Path resourceDirectory = Paths.get("src", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        //Image imgIcon = new ImageIcon(absolutePath+"SuperMario_background.png").getImage();
        Image imgIcon = new ImageIcon("src/resources/SuperMario_background.png").getImage();
        bgpanel = new Background(imgIcon);
        bgpanel.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        getContentPane().add(bgpanel);

//        Image marioImage = new ImageIcon("src/resources/SuperMario_Image.png").getImage();
//        mario.setMario(marioImage);
//        mario.setHeight(100); mario.setWidth(100);
//        mario.setX(150); mario.setY(FRAME_HEIGHT - mario.getHeight() - 200);
//        Image obstacleImage = new ImageIcon("src/resources/SuperMario_Obstacles.png").getImage();
//        obstacle.setObstacle(obstacleImage);
//        obstacle.setX(400); obstacle.setY(FRAME_HEIGHT - obstacle.getHeight() - 200);
//        obstacle.setWidth(100); obstacle.setHeight(100);
//        add(mario);
//        add(obstacle);

    }

    public static void main(String[] args) {
        MarioGame game = new MarioGame();
        game.setVisible(true);
    }

}
