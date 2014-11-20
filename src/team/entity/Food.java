package team.entity;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import team.fartfish.GameActivity;


public class Food {


	float FOOD_WIDTH = GameActivity.CAMERA_WIDTH * 0.18f;
	float FOOD_HEIGHT = FOOD_WIDTH * 0.46f;

	//Texture
	private static TextureRegion mFoodTexture;

	public static void onCreateResources(SimpleBaseGameActivity activity){

		//Load coin texture	
		BitmapTextureAtlas foodTextureAtlas = new BitmapTextureAtlas(activity.getTextureManager(), 40, 40, TextureOptions.BILINEAR);
		mFoodTexture = BitmapTextureAtlasTextureRegionFactory.createFromAsset(foodTextureAtlas, activity, "food.png", 0, 0);
		foodTextureAtlas.load();


	}

	private Scene mScene;

	private Sprite mFood;

	private static final float FOOD_Y_OFFSET = GameActivity.CAMERA_WIDTH + 200; // make sure they always spawn way off screen
	
	public Food(int mOpeningHeight,
			VertexBufferObjectManager mVertexBufferObjectManager, Scene mScene) {
		super();
		this.mScene = mScene;

		mFood = new Sprite(FOOD_Y_OFFSET, mOpeningHeight-122, 88, 41, mFoodTexture, mVertexBufferObjectManager);
		mFood.setZIndex(1);
		mScene.attachChild(mFood);

	}


	public void move(float offset){
		mFood.setPosition(mFood.getX() - offset, mFood.getY());

	}

	public boolean isOnScreen(){

		if(mFood.getX() < -200){
			return false;
		}

		return true;		
	}
	
	boolean counted = false;
	



	public void destroy(){
		mScene.detachChild(mFood);

	}

	public boolean collidesWith(Sprite bird){

		if(mFood.collidesWith(bird)) return true;
		return false;

	}

}
