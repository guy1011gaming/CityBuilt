package com.citybuild.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Character extends Sprite implements InputProcessor {
    private boolean isWalking;

    public Character(Texture texture, float X, float Y, String direction) {
        super(texture);
        this.setPosition(X, Y);
        this.isWalking = false;
        if (direction == "up") {
            this.setRotation(180f);
        }
        else if (direction == "left") {
            this.setRotation(-90f);
        }
        else if (direction == "right") {
            this.setRotation(90f);
        }
    }

    public Character(Texture texture, String direction) {
        super(texture);
        this.setPosition(Gdx.graphics.getWidth() / 2 - this.getWidth() / 2,
                                Gdx.graphics.getHeight() / 2 - this.getHeight() / 2);
        this.isWalking = false;
        if (direction == "up") {
            this.setRotation(180f);
        }
        else if (direction == "left") {
            this.setRotation(-90f);
        }
        else if (direction == "right") {
            this.setRotation(90f);
        }
    }

    public void setRotation(String direction) {
        if (direction == "up") {
            this.setRotation(180f);
        }
        else if (direction == "left") {
            this.setRotation(-90f);
        }
        else if (direction == "right") {
            this.setRotation(90f);
        }
        else if (direction == "down") {
            this.setRotation(0);
        }

    }

    public void setWalking(boolean walking) {
        isWalking = walking;
    }

    public boolean isWalking() {
        return isWalking;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            this.setRotation("left");
            this.setWalking(true);
        }
        else if (keycode == Input.Keys.RIGHT) {
            this.setRotation("right");
            this.setWalking(true);
        }
        else if (keycode == Input.Keys.UP) {
            this.setRotation("up");
            this.setWalking(true);
        }
        else if (keycode == Input.Keys.DOWN) {
            this.setRotation("down");
            this.setWalking(true);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT || keycode == Input.Keys.RIGHT || keycode == Input.Keys.DOWN || keycode == Input.Keys.UP) {
            this.setWalking(false);
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
