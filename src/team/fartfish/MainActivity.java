package team.fartfish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView imgViewFish = null;
	Context   currentContext = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		currentContext = this;
		imgViewFish = (ImageView)findViewById(R.id.imgViewFish);
		imgViewFish.setOnClickListener(new View.OnClickListener(){
		    public void onClick(View v) {
		    	Intent intent = new Intent(currentContext, GameActivity.class);
		    	
		    	Animation animSurprise2Movement = new TranslateAnimation(imgViewFish.getLeft(), imgViewFish.getLeft()+150, imgViewFish.getTop(), imgViewFish.getTop());
		    	animSurprise2Movement.setDuration(1000);
		    	animSurprise2Movement.setFillAfter(true);
		    	animSurprise2Movement.setFillEnabled(true);
		    	imgViewFish.startAnimation(animSurprise2Movement);
		    	startActivity(intent); 
		    	overridePendingTransition(R.anim.in_from_right, R.anim.out_to_right);
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
