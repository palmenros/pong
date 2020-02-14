package com.Pong.Math.Geometry;

import com.Pong.Math.Number.Complex;

public class Rectangle {
	
	private double width;
	private double height;
	private Complex ul;
	
	public Rectangle(Complex c, double w, double h) {
		width = w;
		height = h;
		ul = c;
	}
	
	public Complex upperLeft() {
		return new Complex(ul.getX(), ul.getY());
	}
	
	public Complex lowerRight() {
		return new Complex(ul.getX() + width, ul.getY() + height);		
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
}
