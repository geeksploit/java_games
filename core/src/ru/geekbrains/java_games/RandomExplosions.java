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
    private float explosionCooldown;
    private Rect worldBounds;

    public RandomExplosions(ExplosionPool explosionPool, int explosionTimeout) {
        this.explosionPool = explosionPool;
        this.explosionTimeout = explosionTimeout;
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
    }
}
