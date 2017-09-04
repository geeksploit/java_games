package ru.geekbrains.java_games.screens.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by geeksploit on 04.09.2017.
 */

public class ButtonPlay extends Button {

    public ButtonPlay(TextureRegion region) {

        super(region, Button.Alignment.BottomLeft, new Runnable() {
            @Override
            public void run() {
                System.out.println("Play");
            }
        });

    }

}
