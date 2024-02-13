package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * This class is responsible for animating the helicopter.
 * It is the View in the MVC pattern.
 * To read more about the MVC pattern, visit https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller
 */
public class HelicopterAnimator {

    private Array<Texture> sprites;
    private float displayTime;
    private boolean shallLoop;
    private float currentTime = 0;

    private static final String imagePath1 = "heli1.png";
    private static final String imagePath2 = "heli2.png";
    private static final String imagePath3 = "heli3.png";
    private static final String imagePath4 = "heli4.png";

    /**
     * Creates a new HelicopterAnimator.
     * @param displayTime in seconds
     * @param shallLoop whether the animation shall loop or not
     */
    public HelicopterAnimator(float displayTime, boolean shallLoop) {
        this.displayTime = displayTime;
        this.shallLoop = shallLoop;
        this.sprites = new Array<Texture>();
        this.sprites.add(new Texture(imagePath1));
        this.sprites.add(new Texture(imagePath2));
        this.sprites.add(new Texture(imagePath3));
        this.sprites.add(new Texture(imagePath4));
    }

    /**
     * Updates the animations clock.
     * @param deltaTime in seconds
     */
    public void update(float deltaTime) {
        currentTime += deltaTime;
    }
    
    public float getWidth() {
        return getSprite().getWidth();
    }

    public float getHeight() {
        return getSprite().getHeight();
    }

    public void render(SpriteBatch batch, float x, float y, float xVelocity, float rotation) {
        boolean shallFlipY = xVelocity < 0;
        Texture img = getSprite();
        batch.draw(img, x, y, img.getWidth() / 2, img.getHeight() / 2, img.getWidth(), img.getHeight(), 1, 1,
                rotation,
                0, 0, img.getWidth(), img.getHeight(), true, shallFlipY);
    }

    
    private Texture getSprite() {
        int index = (int) (currentTime / displayTime);
        if (index >= sprites.size) {
            if (shallLoop) {
                index = index % sprites.size;
            } else {
                index = sprites.size - 1;
            }
        }
        return sprites.get(index);
    }


}
