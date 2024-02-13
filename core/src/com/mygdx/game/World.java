package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

/**
 * Represents the world in the game, containing helicopters and managing their interactions.
 * This class is responsible for updating the state of the world, including moving helicopters
 * and handling their collisions. It uses a singleton pattern to ensure only one instance of the world exists.
 * To read more about the singleton pattern, see https://en.wikipedia.org/wiki/Singleton_pattern
 */
public class World {
    private float width, height;
    /** A collection of helicopters currently in the world. */
    private Array<Helicopter> helicopters;
    /** The animator responsible for rendering the world and its entities. */
    private WorldAnimator animator;

    private static World instance = new World();

    private World() {
        animator = new WorldAnimator();
        width = animator.getWidth();
        height = animator.getHeight();
        
        helicopters = new Array<Helicopter>();
    }

    public static World getInstance() {
        return instance;
    }

    /**
     * Returns the singleton instance of the World.
     *
     * @return The singleton instance of the World.
     */
    public void addHelicopter(Helicopter helicopter) {
        helicopters.add(helicopter);
    }

    /**
     * Updates the state of the world and all its entities based on the given delta time.
     * This includes moving helicopters and checking for collisions between them.
     *
     * @param deltaTime The time in seconds since the last update.
     */
    public void update(float deltaTime) {
        for (Helicopter helicopter : helicopters) {
            helicopter.update(deltaTime);
        }
        // Check for collisions
        for (int i = 0; i < helicopters.size; i++) {
            for (int j = i + 1; j < helicopters.size; j++) {
                Helicopter h1 = helicopters.get(i);
                Helicopter h2 = helicopters.get(j);
                if (h1.collidesWith(h2)) {
                    handleCollision(h1, h2);
                }
            }
        }
    }

    /**
     * Handles the collision between two helicopters by simulating a bounce effect.
     *
     * @param h1 The first helicopter involved in the collision.
     * @param h2 The second helicopter involved in the collision.
     */
    private void handleCollision(Helicopter h1, Helicopter h2) {
        // Reverse the velocities of the helicopters to simulate a bounce
        h1.handleCrash(h2);
    }

    /**
     * Renders the world and its helicopters.
     */
    public void render() {
        animator.render(helicopters);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
