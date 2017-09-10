package ru.geekbrains.java_games;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.geekbrains.java_games.pools.EnemyPool;

/**
 * Created by geeksploit on 10.09.2017.
 */

public class RandomEnemyShips {

    private EnemyPool spawnPool;
    private float spawnTimeout;
    private float spawnCooldown;

    public RandomEnemyShips(EnemyPool spawnPool, float spawnTimeout) {
        this.spawnPool = spawnPool;
        this.spawnTimeout = spawnTimeout;
    }

    public void update(float deltaTime) {
        if ((spawnCooldown -= deltaTime) < 0) {
            spawnCooldown = spawnTimeout;
        }
        spawnPool.updateActiveSprites(deltaTime);
    }

    public void draw(SpriteBatch batch) {
        spawnPool.drawActiveObjects(batch);
    }

}
