package com.Pong.Entities;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import com.Pong.Pong;
import com.Pong.Math.Geometry.Rectangle;
import com.Pong.Math.Number.Complex;

public class Ball extends Entity {
    private static final int DIAMETER = 20, MIN_SPEED = 3, MAX_SPEED = 9;
    private static final double MIN_ANGLE = -0.2, MAX_ANGLE = 0.2;
    private static final int INITIAL_X = (Pong.WIDTH - DIAMETER) / 2, INITIAL_Y = (Pong.HEIGHT - DIAMETER) / 2;
    private static int speed = MIN_SPEED;
    
    public Ball() {
        super(new Complex(), new Complex(), DIAMETER);
        reset();
    }

    @Override
    public void draw(Graphics graphics, Color color) {
        graphics.setColor(color);
        graphics.fillOval((int) position.getX(), (int) position.getY(), DIAMETER, DIAMETER);
        Toolkit.getDefaultToolkit().sync();
    }

    private void addRandomAngle() {
        velocity.addAngle(ThreadLocalRandom.current().nextDouble(MIN_ANGLE, MAX_ANGLE));
    }

    @Override
    public void collide(Entity other) {
        // Collision box
        Rectangle cb;

        if (this.equals(other) || (cb = this.intersects(other)) == null) return;

        //TODO: REVIEW
        velocity.mirrorX();
        addRandomAngle();
        
        speed = Math.min(speed + 1, MAX_SPEED);
        velocity.setR( speed );
        //velocity.mirrorY();
    }

    private void reset() {
        position.set(INITIAL_X, INITIAL_Y);
        velocity.set(MIN_SPEED * (ThreadLocalRandom.current().nextBoolean() ? -1 : 1), 0);
        addRandomAngle();
        speed = MIN_SPEED;
    }

    @Override
    public void update() {
        super.update();

        //Si se sale del campo resetear
        if( outOfHorizontalBounds() ) {
        	if(position.getX() + DIAMETER >= Pong.WIDTH) {
        		Pong.PuntosIzquierda++;
        	} else {
        		Pong.PuntosDerecha++;
        	}
        	
        	reset();
        } else if(outOfVerticalBounds()) {
        	velocity.mirrorY();
        }
        
    }
}
