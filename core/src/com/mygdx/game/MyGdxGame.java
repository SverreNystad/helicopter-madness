package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture img;
    private float x, y, xVelocity, yVelocity, rotation;
    private int rotationAmount = 90;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("heli1.png");
        x = 0;
        y = 0;
        xVelocity = 200;
        yVelocity = 200;
        rotation = 0;
    }

    @Override
    public void render() {
        update(Gdx.graphics.getDeltaTime());
        ScreenUtils.clear(1, 0, 0, 1);

        boolean flipY = xVelocity < 0;
        batch.begin();
        batch.draw(img, x, y, img.getWidth() / 2, img.getHeight() / 2, img.getWidth(), img.getHeight(), 1, 1,
                rotation,
                0, 0, img.getWidth(), img.getHeight(), true, flipY);
        batch.end();
    }

    private void update(float deltaTime) {
        x += xVelocity * deltaTime;
        y += yVelocity * deltaTime;

        // Check for collision with the screen edges
        if (x < 0 || x > Gdx.graphics.getWidth() - img.getWidth()) {
            xVelocity = -xVelocity;
            rotation = xVelocity > 0 ? 0 : -180;

        }
        if (y < 0 || y > Gdx.graphics.getHeight() - img.getHeight()) {
            yVelocity = -yVelocity;
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}