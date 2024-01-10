import java.awt.*;

public class Obstacle extends Character {
    private Image obstacle;

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(obstacle, 0, 0, getWidth(), getHeight(), null); // image full size
    }

    public Image getObstacle() {
        return obstacle;
    }

    public void setObstacle(Image obstacle) {
        this.obstacle = obstacle;
    }
}
