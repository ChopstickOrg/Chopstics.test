package com.example.chopsticks.test;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

import com.example.chopsticks.MainActivity;
import com.example.chopsticks.PlayActivity;
import com.example.chopsticks.ReceiveActivity;
import com.example.chopsticks.SendActivity;

import com.example.chopsticks.R;

public class MainActivityFunctionalTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity activity;

	public MainActivityFunctionalTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setActivityInitialTouchMode(false);
		activity = getActivity();
	}

	public void testStartPlayActivity() throws Exception {

		// add monitor to check for the second activity
		ActivityMonitor monitor = getInstrumentation().addMonitor(
				PlayActivity.class.getName(), null, false);

		// find button and click it
		Button view = (Button) activity.findViewById(R.id.buttonPlay);

		// TouchUtils handles the sync with the main thread internally
		TouchUtils.clickView(this, view);

		// to click on a click, e.g., in a listview
		// listView.getChildAt(0);

		// wait 2 seconds for the start of the activity
		PlayActivity startedActivity = (PlayActivity) monitor
				.waitForActivityWithTimeout(2000);
		assertNotNull(startedActivity);

		// search for the textView
		TextView textView = (TextView) startedActivity
				.findViewById(R.id.textViewDiceScoreDisplay);

		// check that the TextView is on the screen
		ViewAsserts.assertOnScreen(startedActivity.getWindow().getDecorView(),
				textView);
		// validate the text on the TextView
		// assertEquals("Text incorrect", "Started",
		// textView.getText().toString());

		// press back and click again
		this.sendKeys(KeyEvent.KEYCODE_BACK);

		//TouchUtils.clickView(this, view);
	}

	public void testStartSendActivity() throws Exception {
		
		// add monitor to check for the second activity
		ActivityMonitor monitor = getInstrumentation().addMonitor(
				SendActivity.class.getName(), null, false);

		// find button and click it
		Button view = (Button) activity.findViewById(R.id.buttonSend);

		// TouchUtils handles the sync with the main thread internally
		TouchUtils.clickView(this, view);

		// to click on a click, e.g., in a listview
		// listView.getChildAt(0);

		// wait 2 seconds for the start of the activity
		SendActivity startedActivity = (SendActivity) monitor
				.waitForActivityWithTimeout(2000);
		assertNotNull(startedActivity);

		// press back and click again
		this.sendKeys(KeyEvent.KEYCODE_BACK);

		//TouchUtils.clickView(this, view);
	}
	
	public void testStartReceiveActivity() throws Exception {

		// add monitor to check for the second activity
		ActivityMonitor monitor = getInstrumentation().addMonitor(
				ReceiveActivity.class.getName(), null, false);

		// find button and click it
		Button view = (Button) activity.findViewById(R.id.buttonReceive);

		// TouchUtils handles the sync with the main thread internally
		TouchUtils.clickView(this, view);

		// to click on a click, e.g., in a listview
		// listView.getChildAt(0);

		// wait 2 seconds for the start of the activity
		ReceiveActivity startedActivity = (ReceiveActivity) monitor
				.waitForActivityWithTimeout(2000);
		assertNotNull(startedActivity);

		// press back and click again
		this.sendKeys(KeyEvent.KEYCODE_BACK);

		//TouchUtils.clickView(this, view);
	}


}
