package com.Pong.Entities;

import com.Pong.Math.Geometry.Intersectable;
import com.Pong.Math.Geometry.Rectangle;
import com.Pong.Math.Geometry.Square;
import com.Pong.Math.Number.Complex;

public abstract class Entity extends Intersectable<Rectangle> implements Drawable {
    protected Complex position, velocity;
    
    public Entity(Complex p, Complex v, int w, int h)
    {
    	super(new Rectangle(p,w,h));
    	position = p;
    	velocity = v;
    }
    
    public abstract void collide(Entity entity);
    
    public Entity(Complex p, Complex v, int w)
    {
    	this(p, v, w, w);
    }
    
    public void update() {
        position.add(velocity);
    }
}
