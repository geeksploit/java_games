package ru.geekbrains.java_games;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import ru.geekbrains.java_games.pools.EnemyPool;
import ru.geekuniversity.engine.math.Rect;

/**
 * Created by geeksploit on 10.09.2017.
 */

public class RandomEnemyShips {

    private EnemyPool spawnPool;
    private float spawnTimeout;
    private float spawnCooldown;
    private Rect worldBounds;
    private Enemy tmpEnemy;

    public RandomEnemyShips(EnemyPool spawnPool, float spawnTimeout) {
        this.spawnPool = spawnPool;
        this.spawnTimeout = spawnTimeout;
    }

    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    public void update(float deltaTime) {
        if ((spawnCooldown -= deltaTime) < 0) {
            spawnCooldown = spawnTimeout;
        }
        spawnPool.updateActiveSprites(deltaTime);
    }

    public void draw(SpriteBatch batch) {
        if (spawnCooldown == spawnTimeout) {
            tmpEnemy = spawnPool.obtain();
            tmpEnemy.resize(worldBounds);
            tmpEnemy.setAngle(180);
            tmpEnemy.setVelocity(MathUtils.random(-0.1f, 0.1f), -MathUtils.random(0.25f, 0.5f));
            tmpEnemy.setBottom(worldBounds.getTop());
            tmpEnemy.setLeft(MathUtils.random(worldBounds.getLeft(), worldBounds.getRight()) / 2);
        }
        spawnPool.drawActiveObjects(batch);
    }

}
