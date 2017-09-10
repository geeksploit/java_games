package ru.geekbrains.java_games;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by geeksploit on 10.09.2017.
 */

public class Enemy extends Ship {

    private static final float SHIP_HEIGHT = 0.15f;

    public Enemy(TextureRegion region) {
        super(region, 1, 2, 2);
        setHeightProportion(SHIP_HEIGHT);
    }

    @Override
    public void update(float deltaTime) {
        pos.mulAdd(v, deltaTime);
    }

    public void setVelocity(float x, float y) {
        v.set(x, y);
    }

}
