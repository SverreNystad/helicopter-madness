package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

/**
 * Main application class for the game. It extends {@link ApplicationAdapter}, providing
 * methods to manage the game lifecycle. This class initializes the game world and
 * manages the rendering and updating of the world and its entities.
 */
public class GameApp extends ApplicationAdapter {
    /** The game world, containing all entities and game logic. */
    private World world;

   /**
     * Called when the application is created. Initializes the game world and adds helicopters.
     * This method sets up the initial state of the game by creating the world instance and
     * populating it with helicopter entities.
     */
    @Override
    public void create() {
        world = World.getInstance();
        // Initialize helicopters with different positions and the same velocity
        Helicopter helicopter1 = new Helicopter(world, 0, 0, 200, 200);
        Helicopter helicopter2 = new Helicopter(world, 150, 90, 200, 200);
        Helicopter helicopter3 = new Helicopter(world, 0, 200, 200, 200);

        // Add the helicopters to the world
        world.addHelicopter(helicopter1);
        world.addHelicopter(helicopter2);
        world.addHelicopter(helicopter3);
    }

    /**
     * Called each frame, responsible for updating the game logic and rendering the game world.
     * This method delegates to the world to handle updates to the game state and rendering.
     */
    @Override
    public void render() {
        world.update(Gdx.graphics.getDeltaTime());
        world.render();
    }
}