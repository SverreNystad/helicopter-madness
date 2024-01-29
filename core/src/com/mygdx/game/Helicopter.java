package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Helicopter {
    private float x, y, xVelocity, yVelocity, rotation;
    private float width, height;
    private World world;
    private Texture img;

    public Helicopter(World world, float x, float y, float xVelocity, float yVelocity) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.rotation = 0;
        img = new Texture("heli1.png");
        width = img.getWidth();
        height = img.getHeight();
    }


    public void update(float deltaTime) {
        x += xVelocity * deltaTime;
        y += yVelocity * deltaTime;

        // Check for collision with the screen edges
        if (x < 0 || x > world.getWidth() - width) {
            xVelocity = -xVelocity;
            rotation = xVelocity > 0 ? 0 : -180;

        }
        if (y < 0 || y > world.getHeight() - height) {
            yVelocity = -yVelocity;
        }
    }

    public void render(SpriteBatch batch) {
        boolean shallFlipY = xVelocity < 0;

        batch.begin();
        batch.draw(img, x, y, img.getWidth() / 2, img.getHeight() / 2, img.getWidth(), img.getHeight(), 1, 1,
                rotation,
                0, 0, img.getWidth(), img.getHeight(), true, shallFlipY);
        batch.end();
    }
}
