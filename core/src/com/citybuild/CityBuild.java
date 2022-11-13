package com.citybuild;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.citybuild.entities.Character;

public class CityBuild extends ApplicationAdapter {
	SpriteBatch batch;
	InputMultiplexer inputMultiplexer;

	// Textures
	Texture player_texture;
	Character player;



	@Override
	public void create () {
		batch = new SpriteBatch();
		inputMultiplexer = new InputMultiplexer();
		player_texture = new Texture("character_1.png");
		this.player = new Character(player_texture, "right");
		inputMultiplexer.addProcessor(player);
	}


	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(player,
				player.getX(),
				player.getY(),
				player.getWidth() / 2,
				player.getHeight() / 2,
				player.getWidth(),
				player.getHeight(),
				player.getScaleX(),
				player.getScaleY(),
				player.getRotation());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		player_texture.dispose();
	}
}
