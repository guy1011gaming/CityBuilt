package com.citybuild.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Character extends Sprite {
    private boolean isWalking;
    private float speed;

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
        this.speed = 2f;
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
        this.speed = 2f;
    }

    public void update() {
        this.processInput();
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

    public void processInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.setRotation("left");
            this.walk();
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.setRotation("right");
            this.walk();
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.setRotation("up");
            this.walk();
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.setRotation("down");
            this.walk();
        }
    }

    public void setWalking(boolean walking) {
        isWalking = walking;
    }

    public boolean isWalking() {
        return isWalking;
    }

    public void walk() {
        if (this.getRotation() == 0f) {
            this.translateY(this.speed * -1f);
        }
        else if (this.getRotation() == 180f) {
            this.translateY(this.speed * 1f);
        }
        else if (this.getRotation() == 90f) {
            this.translateX(this.speed * 1f);
        }
        else if (this.getRotation() == -90f) {
            this.translateX(this.speed * -1f);
        }
    }
}
