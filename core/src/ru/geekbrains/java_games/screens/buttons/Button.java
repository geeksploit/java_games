package ru.geekbrains.java_games.screens.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekuniversity.engine.math.Rect;
import ru.geekuniversity.engine.sprites.Sprite;

public abstract class Button extends Sprite {

    private static final float WIDTH_DEFAULT = .1f;
    private static final float WIDTH_LARGE = WIDTH_DEFAULT * 1.1f;

    private boolean buttonPressed = false;
    private Alignment alignment;
    private Runnable buttonAction;
    private Rect worldBounds;

    public Button(TextureRegion region, Button.Alignment alignment, Runnable buttonAction) {

        super(region);

        setWidthProportion(WIDTH_DEFAULT);
        this.alignment = alignment;
        this.buttonAction = buttonAction;

    }

    @Override
    public void resize(Rect worldBounds) {

        this.worldBounds = worldBounds;

    }

    @Override
    public void update(float deltaTime) {

        alignment.align(this);

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {

        if (isMe(touch)) {
            buttonPressed = true;
            setWidthProportion(WIDTH_LARGE);
            System.out.println("Нажата кнопка");
        } else {
            buttonPressed = false;
        }

        return false;

    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {

        if (isMe(touch) && buttonPressed) {
            buttonPressed = false;
            setWidthProportion(WIDTH_DEFAULT);
            System.out.println("Кнопка сработала");
            buttonAction.run();
        }

        return false;

    }

    @Override
    public boolean touchMove(Vector2 touch, int pointer) {

        if (isMe(touch) && buttonPressed) {
            setWidthProportion(WIDTH_LARGE);
        } else {
            setWidthProportion(WIDTH_DEFAULT);
        }

        return false;

    }

    private Rect getWorldBounds() {

        return worldBounds;

    }

    public enum Alignment {

        BottomLeft() {
            @Override
            public void align(Button button) {
                button.setLeft(button.getWorldBounds().getLeft());
                button.setBottom(button.getWorldBounds().getBottom());
            }
        },

        BottomRight() {
            @Override
            public void align(Button button) {
                button.setRight(button.getWorldBounds().getRight());
                button.setBottom(button.getWorldBounds().getBottom());
            }
        };

        public abstract void align(Button button);

    }
}
