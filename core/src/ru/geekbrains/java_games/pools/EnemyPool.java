package ru.geekbrains.java_games.pools;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.java_games.Enemy;
import ru.geekuniversity.engine.pool.SpritesPool;

/**
 * Created by geeksploit on 10.09.2017.
 */

public class EnemyPool extends SpritesPool<Enemy> {

    private final TextureRegion textureRegion;

    public EnemyPool(TextureAtlas atlas) {
        String regionName = "enemy0";
        textureRegion = atlas.findRegion(regionName);
        if(textureRegion == null) throw new RuntimeException("Region " + regionName + " not found.");
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(textureRegion);
    }

}
