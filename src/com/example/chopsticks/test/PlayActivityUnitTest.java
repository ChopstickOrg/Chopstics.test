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
import android.widget.ImageButton;
import android.widget.ImageView;

public class PlayActivityUnitTest extends ActivityUnitTestCase<PlayActivity> {

	private PlayActivity activity;

	public PlayActivityUnitTest() {
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

	// test for Static.Balance >= 1 and (touchable == view &&
	// touchable.isPressed())
	// path = [220, 223, 224, 225, 226-228, 224, 223]
	public void testDice1ClickListnerPath1() {

		StaticData.balance = (float) 10.0;
		ImageView dice = (ImageView) activity
				.findViewById(R.id.imageViewrollingdiceOne);
		ViewGroup group = (ViewGroup) activity.findViewById(R.id.container);
		ArrayList<View> touchables = group.getTouchables();
		View view = group.getChildAt(0);
		// view.dispatch

		// /////////
		// Obtain MotionEvent object
		long downTime = SystemClock.uptimeMillis();
		long eventTime = SystemClock.uptimeMillis() + 100;
		int[] coords = new int[2];
		view.getLocationOnScreen(coords);
		float x = coords[0];// 0.0f;
		float y = coords[0];// 0.0f;
		// List of meta states found here:
		// developer.android.com/reference/android/view/KeyEvent.html#getMetaState()
		int metaState = 0;
		MotionEvent motionEvent = MotionEvent.obtain(downTime, eventTime,
				MotionEvent.ACTION_UP, x, y, metaState);
		dice.performClick();
		group.dispatchTouchEvent(motionEvent);
		view.dispatchTouchEvent(motionEvent);
		// /
		dice.performClick();
		// button should be disabled
		assertFalse("Dice1 is still enable", dice.isEnabled());

	}

	// test for Static.Balance < 1
	// path = [220, 233]
	public void testDice1ClickListnerPath2() {
		StaticData.balance = (float) 0.5;
		ImageView dice = (ImageView) activity
				.findViewById(R.id.imageViewrollingdiceOne);
		dice.performClick();
		// button should be still enable
		assertTrue("Dice1 is disabled", dice.isEnabled());

	}

	// test for Static.Balance >=1 and !(touchable == view &&
	// touchable.isPressed())
	// path = [220, 223, 224, 225, 224, 223]
	public void testDice1ClickListnerPath3() {
		StaticData.balance = (float) 0.5;
		ImageView dice = (ImageView) activity
				.findViewById(R.id.imageViewrollingdiceOne);
		dice.performClick();
		// button should be still enable
		assertTrue("Dice1 is disabled", dice.isEnabled());

	}
	
	/**
	 * bet1 Click Listener tests
	 */
	
	// test for StaticData.balance < 1
	// path = [407, 411]
	public void testBet1ClickListner() {
		StaticData.balance = (float) 0.5;
		ImageView dice = (ImageView) activity
				.findViewById(R.id.imageViewrollingdiceOne);
		activity.doButton1Action();
		// button should be still enable
		assertTrue("Dice1 is not disabled", dice.isClickable());

	}
	
	/**
	 * bet2 Click Listener tests
	 */
	// test for StaticData.balance <2
	// path = [474, 522-523]
	public void testBet2ClickListnerPath1() {
		StaticData.balance = (float) 1;
		activity.bet2onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertTrue("button1 is not disabled", button1.isClickable());
		assertTrue("button2 is not disabled", button2.isClickable());
		assertTrue("button3 is not disabled", button3.isClickable());
		assertTrue("button4 is not disabled", button4.isClickable());
		assertTrue("button5 is not disabled", button5.isClickable());
	}

	// test for StaticData.balance >=2
	// path = [474, 522-523]
	public void testBet2ClickListnerPath2() {
		StaticData.balance = (float) 5;
		activity.bet2onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertFalse("button1 is disabled", button1.isEnabled());
		assertFalse("button2 is disabled", button2.isEnabled());
		assertFalse("button3 is disabled", button3.isEnabled());
		assertFalse("button4 is disabled", button4.isEnabled());
		assertFalse("button5 is disabled", button5.isEnabled());
	}

	/**
	 * bet5 Click Listener tests
	 * @throws InterruptedException
	 */
	// test for StaticData.balance < 5
	// path = [536, 582-585]
	public void testBet5ClickListnerPath1() throws InterruptedException {
		StaticData.balance = (float) 1;
		activity.bet5onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertTrue("button1 is not disabled", button1.isClickable());
		assertTrue("button1 is not disabled", button2.isClickable());
		assertTrue("button1 is not disabled", button3.isClickable());
		assertTrue("button1 is not disabled", button4.isClickable());
	}

	// test for StaticData.balance >= 5
	// path = [536, 582-585]
	public void testBet5ClickListnerPath2() throws InterruptedException {
		StaticData.balance = (float) 10;
		activity.bet5onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertFalse("button1 is disabled", button1.isEnabled());
		assertFalse("button2 is disabled", button2.isEnabled());
		assertFalse("button3 is disabled", button3.isEnabled());
		assertFalse("button4 is disabled", button4.isEnabled());
		assertFalse("button5 is disabled", button5.isEnabled());
	}

	/**
	 * bet10 Click Listener tests
	 * @throws InterruptedException
	 */
	// test for StaticData.balance < 10
	// path = [593, 645]
	public void testBet10ClickListnerPath1() throws InterruptedException {
		StaticData.balance = (float) 5;
		activity.bet10onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertTrue("button1 is not disabled", button1.isClickable());
		assertTrue("button1 is not disabled", button2.isClickable());
		assertTrue("button1 is not disabled", button3.isClickable());
		assertTrue("button1 is not disabled", button4.isClickable());
	}

	// test for StaticData.balance >= 10
	// path = [593, 645]
	public void testBet10ClickListnerPath2() throws InterruptedException {
		StaticData.balance = (float) 20;
		activity.bet10onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertFalse("button1 is disabled", button1.isEnabled());
		assertFalse("button2 is disabled", button2.isEnabled());
		assertFalse("button3 is disabled", button3.isEnabled());
		assertFalse("button4 is disabled", button4.isEnabled());
		assertFalse("button5 is disabled", button5.isEnabled());
	}

	/**
	 * bet20 Click Listener tests
	 * @throws InterruptedException
	 */
	// test for StaticData.balance < 20
	// path = [650, 699-700]
	public void testBet20ClickListnerPath1() throws InterruptedException {
		StaticData.balance = (float) 5;
		activity.bet20onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertTrue("button1 is not disabled", button1.isClickable());
		assertTrue("button1 is not disabled", button2.isClickable());
		assertTrue("button1 is not disabled", button3.isClickable());
		assertTrue("button1 is not disabled", button4.isClickable());
	}

	// test for StaticData.balance >= 20
	// path = [650, 699-700]
	public void testBet20ClickListnerPath2() throws InterruptedException {
		StaticData.balance = (float) 24;
		activity.bet20onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertFalse("button1 is disabled", button1.isEnabled());
		assertFalse("button2 is disabled", button2.isEnabled());
		assertFalse("button3 is disabled", button3.isEnabled());
		assertFalse("button4 is disabled", button4.isEnabled());
		assertFalse("button5 is disabled", button5.isEnabled());
	}

	/*
	 * bet50 Click Listener tests
	 */
	// test for StaticData.balance < 50
	// path = [707, 754-755]
	public void testBet50ClickListnerPath1() throws InterruptedException {
		StaticData.balance = (float) 25;
		activity.bet50onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertTrue("button1 is not disabled", button1.isClickable());
		assertTrue("button1 is not disabled", button2.isClickable());
		assertTrue("button1 is not disabled", button3.isClickable());
		assertTrue("button1 is not disabled", button4.isClickable());
	}

	// test for StaticData.balance >= 50
	// path = [707, 754-755]
	public void testBet50ClickListnerPath2() throws InterruptedException {
		StaticData.balance = (float) 60;
		activity.bet50onClickListner(null);
		final ImageButton button1 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button2 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button3 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button4 = (ImageButton) activity
				.findViewById(R.id.one);
		final ImageButton button5 = (ImageButton) activity
				.findViewById(R.id.one);
		assertFalse("button1 is disabled", button1.isEnabled());
		assertFalse("button2 is disabled", button2.isEnabled());
		assertFalse("button3 is disabled", button3.isEnabled());
		assertFalse("button4 is disabled", button4.isEnabled());
		assertFalse("button5 is disabled", button5.isEnabled());
	}
}
