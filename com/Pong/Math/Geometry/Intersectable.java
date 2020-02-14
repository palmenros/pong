package com.Pong.Math.Geometry;

import com.Pong.Pong;
import com.Pong.Math.Number.Complex;

public abstract class Intersectable<T extends Rectangle> {
    // Bounding box
    private T bb;

    public Intersectable(T bb) {
        this.bb = bb;
    }

    protected final boolean outOfVerticalBounds() {
    	return bb.upperLeft().getY() < 0 || bb.lowerRight().getY() > Pong.HEIGHT;
    }

    protected final boolean outOfHorizontalBounds() {
    	return bb.upperLeft().getX() < 0 || bb.lowerRight().getX() > Pong.WIDTH;
    }

    public Rectangle intersects(Intersectable other) {
        /* Asumimos rectangulos normalizados, el rectangulo
         * interseccion esta completamente determinado por sus vertices
         * superior izquierdo e inferior derecho
         *
         * .(ulx, uly)______.
         * |                |
         * |                |
         * |                |
         * .________________.(drx, dry)
         */
        double ulx, uly;
        double drx, dry;

        ulx = Math.max(bb.upperLeft().getX(), other.bb.upperLeft().getX());
        uly = Math.max(bb.upperLeft().getY(), other.bb.upperLeft().getY());

        drx = Math.min(bb.lowerRight().getX(), other.bb.lowerRight().getX());
        dry = Math.min(bb.lowerRight().getY(), other.bb.lowerRight().getY());

        // Si ulx > drx o uly > dry
        return ulx > drx || uly > dry ? null : new Rectangle(new Complex(ulx, uly), ulx - drx, uly - dry);
    }
}
