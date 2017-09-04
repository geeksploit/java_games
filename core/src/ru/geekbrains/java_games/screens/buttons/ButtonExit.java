package ru.geekbrains.java_games.screens.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by geeksploit on 04.09.2017.
 */

public class ButtonExit extends Button {

    public ButtonExit(TextureRegion region) {

        super(region, Alignment.BottomRight, new Runnable() {
            @Override
            public void run() {
                System.out.println("Exit");
            }
        });

    }

}
