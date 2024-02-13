package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Handles the rendering of the game world, including the background and helicopters.
 * This class manages drawing the game's background and helicopters on the screen,
 * and displays the current position of each helicopter. It uses LibGDX's {@link SpriteBatch},
 * {@link Texture}, and {@link BitmapFont} for rendering.
 */
public class WorldAnimator {
    private SpriteBatch batch;
    private Texture background = new Texture("background.jpg");
    private float width, height;
    private BitmapFont font;
    
    /**
     * Constructs a new WorldAnimator and initializes rendering tools.
     * This includes setting up the {@link SpriteBatch} for batch drawing,
     * determining the screen's width and height for proper scaling,
     * and initializing the font for text rendering.
     */
    public WorldAnimator() {
        batch = new SpriteBatch();
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        font = new BitmapFont();
    }

    /**
     * Renders the game world, including the background and helicopters.
     * Clears the screen, draws the background across the entire screen,
     * and then renders each helicopter and its position.
     *
     * @param helicopters An {@link Array} of {@link Helicopter} objects to be rendered.
     */
    public void render(Array<Helicopter> helicopters) {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        // Draw background
        batch.draw(background, 0, 0, width, height);
        for (Helicopter helicopter : helicopters) {
            helicopter.render(batch);
    
            String positionText = "Position: (" + helicopter.getX() + ", " + helicopter.getY() + ")";
            // Drawing text at top-left corner
            int padding = 10;
            
            font.draw(batch, positionText, padding, Gdx.graphics.getHeight() - padding); 
        }
        batch.end();
    }

    /**
     * Returns the width of the screen.
     *
     * @return The width of the screen.
     */
    public float getWidth() {
        return width;
    }

    /**
     * Returns the height of the screen.
     *
     * @return The height of the screen.
     */
    public float getHeight() {
        return height;
    }
}
