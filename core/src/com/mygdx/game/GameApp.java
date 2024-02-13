package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class GameApp extends ApplicationAdapter {
    private World world;

   
    @Override
    public void create() {
        world = World.getInstance();
        Helicopter helicopter1 = new Helicopter(world, 0, 0, 200, 200);
        Helicopter helicopter2 = new Helicopter(world, 150, 90, 200, 200);
        Helicopter helicopter3 = new Helicopter(world, 0, 200, 200, 200);

        world.addHelicopter(helicopter1);
        world.addHelicopter(helicopter2);
        world.addHelicopter(helicopter3);
    }

    @Override
    public void render() {
        world.update(Gdx.graphics.getDeltaTime());
        world.render();
    }
}