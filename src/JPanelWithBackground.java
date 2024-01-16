/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class JPanelWithBackground extends JPanel {
    private Image background;

    public JPanelWithBackground(Image background) {
        this.background = background;
        setLayout( new BorderLayout() );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize()  {
        return new Dimension(background.getWidth(this), background.getHeight(this));
    }
}