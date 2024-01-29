package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class World {
    private SpriteBatch batch;
    private float width, height;
    private Array<Helicopter> helicopters;
    private BitmapFont font;
   

    public World() {
        batch = new SpriteBatch();
        helicopters = new Array<Helicopter>();
        this.width = Gdx.graphics.getWidth();
        this.height = Gdx.graphics.getHeight();

        font = new BitmapFont();
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
        batch.begin();
        for (Helicopter helicopter : helicopters) {
            helicopter.render(batch);
    
            String positionText = "Position: (" + helicopter.getX() + ", " + helicopter.getY() + ")";
            // Drawing text at top-left corner
            font.draw(batch, positionText, 10, Gdx.graphics.getHeight() - 10); 
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
