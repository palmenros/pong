package com.Pong.Entities;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.Pong.Pong;
import com.Pong.Math.Number.Complex;

public class Paddle extends Entity implements KeyListener {
    public static final int WIDTH = 20, HEIGHT = 80;
    private PaddleSide side;
    private Color color;
    
    public Paddle(PaddleSide pd, Color c) {
    	super(pd.initialPosition, new Complex(0, 0), WIDTH, HEIGHT);
    	side = pd;
    	color = c;
    }
    
    @Override
    public void draw(Graphics graphics, Color c) {
        graphics.setColor(this.color);
        graphics.fillRect((int) position.getX(), (int) position.getY(), WIDTH, HEIGHT);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void collide(Entity entity) {
        // NOP
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // NOP
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == side.upKey) {
            velocity.setY(-5);
        } else if (keyEvent.getKeyCode() == side.downKey) {
            velocity.setY(5);
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == side.upKey || keyEvent.getKeyCode() == side.downKey)
            velocity.setR(0);
    }

    @Override
    public void update() {
        super.update();
        
        //Abajo
        if(position.getY() < 0) {
        	position.setY(0);
        }

        if(position.getY() > Pong.HEIGHT - HEIGHT) {
        	position.setY(Pong.HEIGHT - HEIGHT);
        }
        
    }
}
