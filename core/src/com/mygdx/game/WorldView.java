package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class WorldView {
    private SpriteBatch batch;
    private Texture background = new Texture("background.jpg");
    private float width, height;
    private BitmapFont font;
    
    public WorldView() {
        batch = new SpriteBatch();
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();
        font = new BitmapFont();
    }


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

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
