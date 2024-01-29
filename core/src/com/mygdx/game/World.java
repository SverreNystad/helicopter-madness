package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class World {
    private SpriteBatch batch;
    private float width, height;
    private Array<Helicopter> helicopters;

    public World() {
        batch = new SpriteBatch();
        helicopters = new Array<Helicopter>();
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
    }

    public void addHelicopter(Helicopter helicopter) {
        helicopters.add(helicopter);
    }

    public void update(float deltaTime) {
        for (Helicopter helicopter : helicopters) {
            helicopter.update(deltaTime);
        }
    }

    public void render() {
        update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(1, 0, 0, 1);

        for (Helicopter helicopter : helicopters) {
            helicopter.render(batch);
        }
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
