package ru.geekbrains.java_games.screens.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

import ru.geekbrains.java_games.screens.buttons.Button;
import ru.geekbrains.java_games.screens.buttons.ButtonExit;
import ru.geekbrains.java_games.screens.buttons.ButtonPlay;
import ru.geekbrains.java_games.screens.stars.Star;
import ru.geekuniversity.engine.Base2DScreen;
import ru.geekuniversity.engine.Sprite2DTexture;
import ru.geekuniversity.engine.math.Rect;
import ru.geekuniversity.engine.math.Rnd;

public class MenuScreen extends Base2DScreen {

    private Sprite2DTexture textureBackground;
    private TextureAtlas atlas;
    private Background background;
    private StarField starField;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        textureBackground = new Sprite2DTexture("textures/bg.png");
        atlas = new TextureAtlas("textures/mainAtlas.pack");
        background = new Background(new TextureRegion(textureBackground));

        starField = new StarField(atlas.findRegion("star"));

        Button play = new ButtonPlay(atlas.findRegion("btPlay"));
        Button exit = new ButtonExit(atlas.findRegion("btExit"));
        menuButtons = new MenuButtons(play, exit);

    }

    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
        starField.resize(worldBounds);
        menuButtons.resize(worldBounds);
    }

    @Override
    protected void touchDown(Vector2 touch, int pointer) {

        starField.touchDown(touch, pointer);
        menuButtons.touchDown(touch, pointer);

    }

    @Override
    public void touchUp(Vector2 touch, int pointer) {

        menuButtons.touchUp(touch, pointer);

    }

    @Override
    protected void touchMove(Vector2 touch, int pointer) {

        menuButtons.touchMove(touch, pointer);

    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float deltaTime) {

        starField.update(deltaTime);
        menuButtons.update(deltaTime);

    }

    private void draw() {
        Gdx.gl.glClearColor(0.7f, 0.7f, 0.7f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        starField.draw(batch);
        menuButtons.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        textureBackground.dispose();
        atlas.dispose();
        super.dispose();
    }

    private class StarField {

        private static final float STAR_MIN_WIDTH = 0.01f;
        private static final float STAR_MAX_WIDTH = STAR_MIN_WIDTH * 5;
        private static final int STAR_MAX_AMOUNT = 1000;

        private ArrayList<Star> stars;

        StarField(TextureRegion regionStar) {

            stars = new ArrayList<Star>(STAR_MAX_AMOUNT);

            while (stars.size() < STAR_MAX_AMOUNT) {
                float velocityX = Rnd.nextFloat(-0.005f, 0.005f);
                float velocityY = Rnd.nextFloat(-0.05f, -0.1f);
                // Tie star width to its velocity to give the star field a sense of depth.
                float starWidth = MathUtils.clamp(
                        (Math.abs(velocityX) + Math.abs(velocityY)) / 10,
                        STAR_MIN_WIDTH, STAR_MAX_WIDTH);
                stars.add(new Star(regionStar, velocityX, velocityY, starWidth));
            }

        }

        void resize(Rect worldBounds) {

            for (Star star : stars) {
                star.resize(worldBounds);
            }

        }

        void update(float deltaTime) {

            for (Star star : stars) {
                star.update(deltaTime);
            }

        }

        void draw(SpriteBatch spriteBatch) {

            for (Star star : stars) {
                star.draw(spriteBatch);
            }

        }

        void touchDown(Vector2 touch, int pointer) {

            for (Star star : stars) {
                star.touchDown(touch, pointer);
            }

        }
    }

    private class MenuButtons {

        private ArrayList<Button> buttons;

        MenuButtons(Button... newButtons) {

            buttons = new ArrayList<Button>(2);
            for (Button button : newButtons) {
                addButton(button);
            }

        }

        void addButton(Button newButton) {

            buttons.add(newButton);

        }

        void resize(Rect worldBounds) {

            for (Button button : buttons) {
                button.resize(worldBounds);
            }

        }

        void update(float deltaTime) {

            for (Button button : buttons) {
                button.update(deltaTime);
            }

        }

        void draw(SpriteBatch spriteBatch) {

            for (Button button : buttons) {
                button.draw(spriteBatch);
            }

        }

        void touchDown(Vector2 touch, int pointer) {

            for (Button button : buttons) {
                button.touchDown(touch, pointer);
            }

        }

        public void touchUp(Vector2 touch, int pointer) {

            for (Button button : buttons) {
                button.touchUp(touch, pointer);
            }

        }

        public void touchMove(Vector2 touch, int pointer) {

            for (Button button : buttons) {
                button.touchMove(touch, pointer);
            }

        }

    }

}
