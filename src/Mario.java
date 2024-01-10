import java.awt.*;

public class Mario extends Character {
    private int speed;
    private Image mario;

    public Mario(int height, int width, int x, int y, int speed) {
        super(height, width, x, y);
        this.speed = speed;
    }

    public Mario(int speed) {
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(mario, 0, 0, getWidth(), getHeight(), null);
    }

    private void moveMario(int frameWidth) {
        int x = getX();
        x += speed;
        if (x > frameWidth) {
            setX(0);
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Image getMario() {
        return mario;
    }

    public void setMario(Image mario) {
        this.mario = mario;
    }
}
