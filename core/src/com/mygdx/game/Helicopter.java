package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Represents a helicopter entity within the game {@link World}.
 * This class manages the helicopter's position, movement, and rendering.
 * It responds to user input for direction changes and handles collisions
 * with the world boundaries by reversing direction and simulating a bounce effect.
 */
public class Helicopter {
    private float x, y, xVelocity, yVelocity, rotation;
    private float width, height;
    private World world;
    private HelicopterAnimator animator;

    /**
     * Constructs a new Helicopter with specified initial position and velocity.
     * Initializes the helicopter's animator and calculates its width and height based on the animator.
     *
     * @param world The game world the helicopter will exist within.
     * @param x The initial X position of the helicopter.
     * @param y The initial Y position of the helicopter.
     * @param xVelocity The initial horizontal velocity of the helicopter.
     * @param yVelocity The initial vertical velocity of the helicopter.
     */
    public Helicopter(World world, float x, float y, float xVelocity, float yVelocity) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.rotation = 0;
        this.animator = new HelicopterAnimator(0.1f, true);

        width = animator.getWidth();
        height = animator.getHeight();
    }

    /**
     * Updates the helicopter's position based on its velocity and handles user input
     * for direction control. Also checks and handles collisions with the world boundaries.
     *
     * @param deltaTime The time in seconds since the last update.
     */
    public void update(float deltaTime) {
        handleInput();
        x += xVelocity * deltaTime;
        y += yVelocity * deltaTime;
        
        handleWorldCollision();
        animator.update(deltaTime);
    }

    /**
     * Processes user input to control the helicopter's direction and speed.
     * Changes the helicopter's velocity and rotation based on arrow key inputs.
     */
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

    /**
     * Checks for and handles collisions between the helicopter and the world boundaries.
     * Adjusts the helicopter's position and velocity to prevent it from moving outside the world.
     */
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

    /**
     * Renders the helicopter on the screen using the {@link HelicopterAnimator}.
     *
     * @param batch The {@link SpriteBatch} used for drawing the helicopter.
     */
    public void render(SpriteBatch batch) {
        animator.render(batch, x, y, xVelocity, rotation);
    }

    /**
     * Checks if this helicopter collides with another helicopter.
     *
     * @param other The other helicopter to check collision with.
     * @return true if the helicopters collide, false otherwise.
     */
    public boolean collidesWith(Helicopter other) {
        return x < other.x + other.width && x + width > other.x &&
               y < other.y + other.height && y + height > other.y;
    }

    /**
     * Handles the event of this helicopter crashing into another helicopter.
     * Adjusts the position and velocity of both helicopters to simulate a bounce effect.
     *
     * @param other The other helicopter involved in the crash.
     */
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

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
