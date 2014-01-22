package com.example.chopsticks.test;

import java.util.ArrayList;

import com.example.chopsticks.MainActivity;
import com.example.chopsticks.PlayActivity;
import com.example.chopsticks.R;
import com.example.staticdata.StaticData;

import android.content.Intent;
import android.os.SystemClock;
import android.test.ActivityUnitTestCase;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PlayActivityUnitTest extends ActivityUnitTestCase<PlayActivity> {

	private PlayActivity activity;
	
	public PlayActivityUnitTest(){
		super(PlayActivity.class);
		// TODO Auto-generated constructor stub
	}
	public PlayActivityUnitTest(Class<PlayActivity> activityClass) {
		super(activityClass);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(),
				MainActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}
	
	/**
	 * dice1 click listener tests
	 */
	
	//test for Static.Balance >= 1 and (touchable == view && touchable.isPressed())
	//path = [220, 223, 224, 225, 226-228, 224, 223]
	public void testDice1ClickListnerPath1() {
		
		StaticData.balance = (float) 10.0;
		ImageView dice = (ImageView) activity.findViewById(R.id.imageViewrollingdiceOne);
		ViewGroup group = (ViewGroup) activity.findViewById(R.id.container);
		ArrayList<View> touchables = group.getTouchables();
		View view = group.getChildAt(0);
			//view.dispatch
		
		///////////
		// Obtain MotionEvent object
		long downTime = SystemClock.uptimeMillis();
		long eventTime = SystemClock.uptimeMillis() + 100;
		int[] coords = new int[2];
		view.getLocationOnScreen(coords);
		float x = coords[0];//0.0f;
		float y = coords[0];//0.0f;
		// List of meta states found here: developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
		int metaState = 0;
		MotionEvent motionEvent = MotionEvent.obtain(
		    downTime, 
		    eventTime, 
		    MotionEvent.ACTION_UP, 
		    x, 
		    y, 
		    metaState
		);
		dice.performClick();
		group.dispatchTouchEvent(motionEvent);
		view.dispatchTouchEvent(motionEvent);
		///
		dice.performClick();
		//button should be disabled 
		assertFalse("Dice1 is still enable", dice.isEnabled());
		
		
	}
	
	//test for Static.Balance < 1
	//path = [220, 233]
	public void testDice1ClickListnerPath2(){
		StaticData.balance = (float) 0.5;
		ImageView dice = (ImageView) activity.findViewById(R.id.imageViewrollingdiceOne);
		dice.performClick();
		//button should be still enable
		assertTrue("Dice1 is disabled", dice.isEnabled());
		
	}
	
	//test for Static.Balance >=1 and !(touchable == view && touchable.isPressed())
	//path = [220, 223, 224, 225, 224, 223]
	public void testDice1ClickListnerPath3(){
		StaticData.balance = (float) 0.5;
		ImageView dice = (ImageView) activity.findViewById(R.id.imageViewrollingdiceOne);
		dice.performClick();
		//button should be still enable
		assertTrue("Dice1 is disabled", dice.isEnabled());
		
	}
}
