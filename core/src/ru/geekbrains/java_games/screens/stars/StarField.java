package ru.geekbrains.java_games.screens.stars;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import ru.geekuniversity.engine.math.Rect;

/**
 * Created by geeksploit on 06.09.2017.
 */

public class StarField {

    public static final int DEFAULT_STARS_AMOUNT = 250;
    private static final float STAR_DEFAULT_HEIGHT = 0.01f;
    private static final float STAR_DEFAULT_SCROLLING_FACTOR = -0.005f;

    Array<Star> stars;

    public StarField(TextureAtlas atlas) {
        stars = new Array<Star>(DEFAULT_STARS_AMOUNT);
        TextureRegion regionStar = atlas.findRegion("star");
        while (stars.size < DEFAULT_STARS_AMOUNT) {
            float vx = MathUtils.random(-0.005f, 0.005f);
            float vy = MathUtils.random(-0.05f, -0.1f);
            float starHeight = STAR_DEFAULT_HEIGHT * MathUtils.random(0.75f, 1f);
            stars.add(new Star(regionStar, vx, vy, starHeight));
        }
    }

    public void resize(Rect worldBounds) {
        for (int i = 0; i < stars.size; i++) {
            stars.get(i).resize(worldBounds);
        }
    }

    public void draw(SpriteBatch spriteBatch) {
        for (int i = 0; i < stars.size; i++) {
            stars.get(i).draw(spriteBatch);
        }
    }

    public void update(float deltaTime) {
        for (int i = 0; i < stars.size; i++) {
            stars.get(i).update(deltaTime);
        }
    }

    public void applyScrollingX(float velocityX) {
        for (int i = 0; i < stars.size; i++) {
            stars.get(i).setLeft(stars.get(i).getLeft() + velocityX * STAR_DEFAULT_SCROLLING_FACTOR);
        }
    }
}
