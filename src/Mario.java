import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class  Mario extends Character {
    private int speed;
    private boolean jumped;
    private Image marioRun;
    private Image marioJump;

    public Mario(int height, int width, int x, int y, int speed) {
        super(height, width, x, y);
        this.speed = speed;
    }

    public Mario(int speed) {
            }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE && !jumped) {
            int y = getY() - 15;
            setY(y);
            setJumped(true);
            repaint();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE && jumped) {
            int y = getY() + 15;
            setY(y);
            setJumped(false);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (jumped)
            g.drawImage(marioJump, getX(), getY(), getWidth(), getHeight(), this);
        else
            g.drawImage(marioRun, getX(), getY(), getWidth(), getHeight(), this);
    }

    public void moveMario(int frameWidth) {
        while(true) {
            int x = getX() + speed;
            setX(x);
            if (getX() > frameWidth) {
                setX(0);
            }
            repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
//
//    private class KeyInput extends KeyAdapter {
//        public KeyInput () {
//        }
//
//    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Image getMarioRun() {
        return marioRun;
    }

    public void setMarioRun(Image marioRun) {
        this.marioRun = marioRun;
    }

    public Image getMarioJump() {
        return marioJump;
    }

    public void setMarioJump(Image marioJump) {
        this.marioJump = marioJump;
    }

    public boolean hasJumped() {
        return jumped;
    }

    public void setJumped(boolean hasJumped) {
        this.jumped = hasJumped;
    }
}
