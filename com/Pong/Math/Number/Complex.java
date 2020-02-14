package com.Pong.Math.Number;

public class Complex {
    private double r, phi;

    public Complex() {
    }

    public Complex(double x, double y) {
        set(x, y);
    }

    public void set(double x, double y) {
        r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        phi = Math.atan2(y, x);
    }

    public void addMagnitude(double r) {
        this.r += r;
    }

    public void addAngle(double phi) {
        this.phi += phi;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getPhi() {
        return phi;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }
    
    public double getX() {
    	return r * Math.cos(phi);
    }
    
    public double getY() {
    	return r * Math.sin(phi);    	
    }

    public void setX(double x)
    {
    	set(x,getY());
    }
    
    public void setY(double y)
    {
    	set(getX(),y);
    }
    
    public void add(Complex other)
    {
    	set(getX()+other.getX(),getY()+other.getY());
    }
    
    public void mirrorX() {
    	set(-getX(),getY());
    }
    public void mirrorY() {
    	set(getX(),-getY());
    }
    
}
