package ru.geekbrains.java_games;

import ru.geekbrains.java_games.pools.EnemyPool;

/**
 * Created by geeksploit on 10.09.2017.
 */

public class RandomEnemyShips {

    private EnemyPool spawnPool;
    private float spawnTimeout;

    public RandomEnemyShips(EnemyPool spawnPool, float spawnTimeout) {
        this.spawnPool = spawnPool;
        this.spawnTimeout = spawnTimeout;
    }

}
