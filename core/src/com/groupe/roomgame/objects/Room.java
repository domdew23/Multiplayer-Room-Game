package com.groupe.roomgame.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.groupe.roomgame.screens.GameScreen;

public class Room {

	public static final int CLEAN = 0;
	public static final int HALF_DIRTY = 1;
	public static final int DIRTY = 2;

	private int id;
	private Rectangle rect;
	private Body body;

	private Sprite[] socks;
	private Sprite[] lemonPledge;

	private GameScreen gameScreen;

	private int roomState; //0 clean, 1 half-dirty, 2-dirty

	public Room(int id, Rectangle rect, Body body, GameScreen gameScreen) {
		this.id = id;
		this.rect = rect;
		this.body = body;
		this.gameScreen = gameScreen;
	}

	public void generateSocks(){
		socks = new Sprite[8];
		for(int i = 0; i < 8; i++){
			socks[i] = new Sprite(new Texture("room/dirtysocks.png"));
			socks[i].setSize(.5f, .5f);
			float[] coordinates = gameScreen.randomRoomCoordinates(false, id);
			socks[i].setPosition(coordinates[0] / 100, coordinates[1] / 100);
		}
	}

	public void generateLemonPledge(){
		lemonPledge = new Sprite[8];
		for(int i = 0; i < 8; i++){
			lemonPledge[i] = new Sprite(new Texture("room/lemonpledge.png"));
			lemonPledge[i].setSize(.5f, .7f);
			float[] coordinates = gameScreen.randomRoomCoordinates(false, id);
			lemonPledge[i].setPosition(coordinates[0] / 100, coordinates[1] / 100);
		}
	}
	
	public void renderDirtyRoom(SpriteBatch batch){
		for(int i = 0; i < socks.length; i++){
			socks[i].draw(batch);
		}
	}

	public void renderCleanRoom(SpriteBatch batch){
		for(int i = 0; i < lemonPledge.length; i++){
			lemonPledge[i].draw(batch);
		}
	}
	
	public void setRoomState(int roomState) {
		this.roomState = roomState;
	}
	
	public int getRoomState() {
		return roomState;
	}
	
	public Body getBody() {
		return body;
	}
	
	public int getID() {
		return id;
	}
	
	public boolean overlaps(Rectangle rect) {
		return this.rect.overlaps(rect);
	}
	
	public Rectangle getRect() {
		return rect;
	}
}
