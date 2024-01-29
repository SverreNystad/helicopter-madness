package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

public class GameApp extends ApplicationAdapter {
    private World world;
    private Helicopter helicopter;

    @Override
    public void create() {
        world = new World();
        helicopter = new Helicopter(world, 0, 0, 200, 200);
        world.addHelicopter(helicopter);
    }

    @Override
    public void render() {
        world.render();
    }

    private void update(float deltaTime) {
        world.update(deltaTime);
    }

}