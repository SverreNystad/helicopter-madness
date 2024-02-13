package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class World {
    private float width, height;
    private Array<Helicopter> helicopters;
    private WorldView view;

    private static World instance = new World();

    private World() {
        view = new WorldView();
        width = view.getWidth();
        height = view.getHeight();
        
        helicopters = new Array<Helicopter>();
    }

    public static World getInstance() {
        return instance;
    }

    public void addHelicopter(Helicopter helicopter) {
        helicopters.add(helicopter);
    }

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

    private void handleCollision(Helicopter h1, Helicopter h2) {
        // Reverse the velocities of the helicopters to simulate a bounce
        h1.handleCrash(h2);
    }

    public void render() {
        view.render(helicopters);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
