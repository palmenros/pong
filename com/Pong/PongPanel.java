package com.Pong;

import javax.swing.*;

import com.Pong.Entities.Ball;
import com.Pong.Entities.Entity;
import com.Pong.Entities.Paddle;
import com.Pong.Entities.PaddleSide;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

class PongPanel extends JPanel implements ActionListener {
    private final Ball ball = new Ball();
    private final Paddle leftPaddle = new Paddle(PaddleSide.LEFT, Color.CYAN), rightPaddle = new Paddle(PaddleSide.RIGHT, Color.YELLOW);
    private final Set<Entity> objects = Set.of(ball, leftPaddle, rightPaddle);
    private JLabel jlabel = new JLabel("0");
    
    PongPanel() {
    	
    	jlabel.setForeground(Color.WHITE);
        jlabel.setFont(new Font("Verdana",1,40));
        add(jlabel);
    	
        setPreferredSize(new Dimension(Pong.WIDTH, Pong.HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        setDoubleBuffered(true);

        addKeyListener(leftPaddle);
        addKeyListener(rightPaddle);

        new Timer(10, this).start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        objects.forEach(Entity::update);
        repaint();
    }

    private void checkCollisions() {
        ball.collide(leftPaddle);
        ball.collide(rightPaddle);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        jlabel.setText(Pong.PuntosIzquierda + " - " + Pong.PuntosDerecha);
        objects.forEach(e -> e.draw(g, Color.WHITE));
    }
}