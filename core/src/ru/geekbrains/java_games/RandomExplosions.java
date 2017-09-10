package ru.geekbrains.java_games;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.java_games.pools.ExplosionPool;
import ru.geekuniversity.engine.math.Rect;

/**
 * Created by geeksploit on 09.09.2017.
 */

public class RandomExplosions {

    private final float EXPLOSION_SCALE = 0.1f;

    private ExplosionPool explosionPool;
    private float explosionTimeout;
    private float explosionCooldown;
    private Rect worldBounds;
    private Vector2 explosionPosition;

    public RandomExplosions(ExplosionPool explosionPool, int explosionTimeout) {
        this.explosionPool = explosionPool;
        this.explosionTimeout = explosionTimeout;
        this.explosionPosition = new Vector2();
    }

    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    public void update(float deltaTime) {
        if ((explosionCooldown -= deltaTime) < 0) {
            explosionCooldown = explosionTimeout;
        }
    }

    public void draw(SpriteBatch batch) {
        if (explosionCooldown == explosionTimeout) {
            float positionX = MathUtils.random(-worldBounds.getHalfWidth(), worldBounds.getHalfWidth());
            float positionY = MathUtils.random(-worldBounds.getHalfHeight(), worldBounds.getHalfHeight());
            explosionPosition.set(positionX, positionY);
            explosionPool.obtain().set(EXPLOSION_SCALE, explosionPosition);
        }
    }
}
