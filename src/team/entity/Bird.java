package team.entity;

import java.io.IOException;
import java.util.Timer;

import org.andengine.audio.sound.Sound;
import org.andengine.audio.sound.SoundFactory;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.TiledTextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.ui.activity.SimpleBaseGameActivity;
import org.andengine.util.debug.Debug;

import team.fartfish.GameActivity;



public class Bird {

	public static final float BITMAP_WIDTH = 1047f;
	public static final float BITMAP_HEIGHT = 903f;
	
	public static float BIRD_WIDTH = 55.8f;
	public static float BIRD_HEIGHT = 40f;
	
	public static float MAX_SIZE = 5.0f;
	public static float MIN_SIZE = 0.5f;
	public static float VARIATION_SIZE = 0.1f;
	
	private AnimatedSprite mSprite;	

	protected static float mCurrentSize = MIN_SIZE;

	//bird
	private static BuildableBitmapTextureAtlas mBirdBitmapTextureAtlas;
	private static TiledTextureRegion mBirdTextureRegion;
	
	// sounds
	private static Sound mJumpSound;	

	public static void onCreateResources(SimpleBaseGameActivity activity){
		// bird
		mBirdBitmapTextureAtlas = new BuildableBitmapTextureAtlas(activity.getTextureManager(), (int)BITMAP_WIDTH, (int)BITMAP_HEIGHT, TextureOptions.NEAREST);
		mBirdTextureRegion = BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mBirdBitmapTextureAtlas, activity, "birdmap.png", 3, 3);
		try {
			mBirdBitmapTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 0, 0));
			mBirdBitmapTextureAtlas.load();
		} catch (TextureAtlasBuilderException e) {
			e.printStackTrace();
		}
		
		try {
			mJumpSound = SoundFactory.createSoundFromAsset(activity.getSoundManager(), activity, "jump.ogg");			
		} catch (final IOException e) {
			Debug.e(e);
		}

	}

	
	private float mBirdYOffset, mBirdXOffset;
	
	public Bird(float birdXOffset, float birdYOffset, VertexBufferObjectManager mVertexBufferObjectManager, Scene mScene) {

		this.mBirdXOffset = birdXOffset;
		this.mBirdYOffset = birdYOffset;		
		
		mSprite = new AnimatedSprite(mBirdXOffset, mBirdYOffset, BIRD_WIDTH, BIRD_HEIGHT, mBirdTextureRegion, mVertexBufferObjectManager);
		mSprite.animate(25);
		mSprite.setZIndex(2);
		mSprite.setScale(mCurrentSize);
		mScene.attachChild(mSprite);
		
	}
	
	public void restart(){
		//First Reset bird size
		mCurrentSize = MIN_SIZE;
		mSprite.setScale(mCurrentSize);
		
		mSprite.animate(25);
		mSprite.setY(mBirdYOffset);
		mSprite.setX(mBirdXOffset);
	}

	public float move(){
		
		// Stays static
		float newY = mSprite.getY();
		newY = Math.max(newY, 0);
		newY = Math.min(newY, GameActivity.FLOOR_BOUND);
		mSprite.setY(newY);
		
		return newY;
	}
	
	public float grow() {
		
		// Increase fish size over time			
		float newSize = mCurrentSize + VARIATION_SIZE;
		if (newSize < MAX_SIZE) {
			mCurrentSize += VARIATION_SIZE ;
			mSprite.setScale(mCurrentSize);
		}
		return mCurrentSize;
	}
			
	
	public void shrink(){
		if(mCurrentSize > MIN_SIZE){
			mCurrentSize = mCurrentSize - VARIATION_SIZE;
			mSprite.setScale(mCurrentSize);			
		}
		mJumpSound.play();
	}	
	
	// hover stuff	
	private static float WRAPAROUND_POINT = (float) (2 * Math.PI);
	
	private float mHoverStep = 0;
	
	public void hover(){
		mHoverStep+=0.13f;	
		if(mHoverStep > WRAPAROUND_POINT) mHoverStep = 0;
		
		float newY = mBirdYOffset + ((float) (7 * Math.sin(mHoverStep)));		
		mSprite.setY(newY);			
		
	}

	public AnimatedSprite getSprite() {
		return mSprite;
	}

}
