package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Helicopter {
    private float x, y, xVelocity, yVelocity, rotation;
    private float width, height;
    private World world;
    private HelicopterAnimator animator;

    public Helicopter(World world, float x, float y, float xVelocity, float yVelocity) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.rotation = 0;
        this.animator = new HelicopterAnimator(0.1f, true);

        width = animator.getSprite().getWidth();
        height = animator.getSprite().getHeight();
    }

    /**
     * Takes care of updating the helicopter's position and handling input
     * @param deltaTime
     */
    public void update(float deltaTime) {
        handleInput();
        x += xVelocity * deltaTime;
        y += yVelocity * deltaTime;
        
        handleWorldCollision();
        animator.update(deltaTime);
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            xVelocity = (xVelocity < 0) ? xVelocity : -xVelocity;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            xVelocity = (xVelocity > 0) ? xVelocity : -xVelocity;
        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            yVelocity = (yVelocity > 0) ? yVelocity : -yVelocity;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            yVelocity = (yVelocity < 0) ? yVelocity : -yVelocity;
        }
        rotation = xVelocity > 0 ? 0 : -180;

    }

    private void handleWorldCollision() {
        if (x < 0) {
            x = 0;
        }
        if (x > world.getWidth() - width) {
            x = world.getWidth() - width;
        }
        if (y < 0) {
            y = 0;
        }
        if (y > world.getHeight() - height) {
            y = world.getHeight() - height;
        }

        if (x <= 0 || x >= world.getWidth() - width) {
            xVelocity = -xVelocity;
            rotation = xVelocity > 0 ? 0 : -180;
        }
        if (y <= 0 || y >= world.getHeight() - height) {
            yVelocity = -yVelocity;
        }
    }

    public void render(SpriteBatch batch) {
        animator.render(batch, x, y, xVelocity, rotation);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean collidesWith(Helicopter other) {
        return x < other.x + other.width && x + width > other.x &&
               y < other.y + other.height && y + height > other.y;
    }

    public void handleCrash(Helicopter other) {
        // Make helicopters not overlap
        int xIntersection = (int) (x + width - other.x);
        int yIntersection = (int) (y + height - other.y);
        if (x < other.x) {
            x = other.x - xIntersection;
        } else {
            x = other.x + xIntersection;
        }
        if (y < other.y) {
            y = other.y - yIntersection;
        } else {
            y = other.y + yIntersection;
        }
        

        // Reverse the velocities of the helicopters to simulate a bounce
        xVelocity = -xVelocity;
        other.xVelocity = -other.xVelocity;
        yVelocity = -yVelocity;
        other.yVelocity = -other.yVelocity;
    }
}
