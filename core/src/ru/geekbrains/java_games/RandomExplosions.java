package ru.geekbrains.java_games;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ru.geekbrains.java_games.pools.ExplosionPool;
import ru.geekuniversity.engine.math.Rect;

/**
 * Created by geeksploit on 09.09.2017.
 */

public class RandomExplosions {

    private ExplosionPool explosionPool;
    private float explosionTimeout;
    private Rect worldBounds;

    public RandomExplosions(ExplosionPool explosionPool, int explosionTimeout) {
        this.explosionPool = explosionPool;
        this.explosionTimeout = explosionTimeout;
    }

    public void resize(Rect worldBounds) {
        this.worldBounds.set(worldBounds);
    }

    public void update(float deltaTime) {
    }

    public void draw(SpriteBatch batch) {
    }
}
