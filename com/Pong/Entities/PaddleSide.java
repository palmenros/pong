package com.Pong.Entities;

import java.awt.event.KeyEvent;

import com.Pong.Pong;
import com.Pong.Math.Number.Complex;

public enum PaddleSide {
    LEFT(new Complex(Pong.WIDTH / 10d, (Pong.HEIGHT - Paddle.HEIGHT) / 2d), KeyEvent.VK_W, KeyEvent.VK_S),
    RIGHT(new Complex((9 * Pong.WIDTH) / 10d, (Pong.HEIGHT - Paddle.HEIGHT) / 2d), KeyEvent.VK_UP, KeyEvent.VK_DOWN);

    protected final Complex initialPosition;
    protected final int upKey, downKey;

    PaddleSide(Complex initialPosition, int upKey, int downKey) {
        this.initialPosition = initialPosition;
        this.upKey = upKey;
        this.downKey = downKey;
    }
}
