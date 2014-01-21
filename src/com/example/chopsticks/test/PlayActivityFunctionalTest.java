package com.example.chopsticks.test;

import android.app.Instrumentation.ActivityMonitor;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.UiThreadTest;
import android.view.KeyEvent;
import android.view.TextureView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.chopsticks.MainActivity;
import com.example.chopsticks.PlayActivity;
import com.example.chopsticks.SendActivity;

import com.example.chopsticks.R;

public class PlayActivityFunctionalTest extends
		ActivityInstrumentationTestCase2<PlayActivity> {

	private static final String new_dice_score = "11";

	public PlayActivityFunctionalTest() {
		super(PlayActivity.class);
		// TODO Auto-generated constructor stub
	}

	public void testSetDiceText() throws Exception {

		PlayActivity activity = getActivity();

		// search for the textView
		final TextView textView = (TextView) activity
				.findViewById(R.id.textViewDiceScoreDisplay);

		// set text
		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				textView.setText(new_dice_score);
			}
		});

		getInstrumentation().waitForIdleSync();
		assertEquals("Text incorrect", new_dice_score, textView.getText()
				.toString());

	}

	@UiThreadTest
	public void testSetDiceTextWithAnnotation() throws Exception {

		PlayActivity activity = getActivity();

		// search for the textView
		final TextView textView = (TextView) activity
				.findViewById(R.id.textViewDiceScoreDisplay);

		textView.setText(new_dice_score);
		assertEquals("Text incorrect", new_dice_score, textView.getText()
				.toString());

	}

//	public void testStartMainActivity() throws Exception {
//		
//		PlayActivity activity = getActivity();
//
//		// add monitor to check for the second activity
//		ActivityMonitor monitor = getInstrumentation().addMonitor(
//				MainActivity.class.getName(), null, false);
//
//		// find button and click it
//		TextView view = (TextView) activity.findViewById(R.id.textView_play_balance);
//
//		// TouchUtils handles the sync with the main thread internally
//		TouchUtils.clickView(this, view);
//
//		// to click on a click, e.g., in a listview
//		// listView.getChildAt(0);
//
//		// wait 2 seconds for the start of the activity
//		MainActivity startedActivity = (MainActivity) monitor
//				.waitForActivityWithTimeout(2000);
//		assertNotNull(startedActivity);
//
//		// press back and click again
//		this.sendKeys(KeyEvent.KEYCODE_BACK);
//
//		// TouchUtils.clickView(this, view);
//	}
	
	public void testBet1Button() throws Exception {

		PlayActivity activity = getActivity();

		// search for the textView
		final ImageButton button = (ImageButton) activity
				.findViewById(R.id.one);

		// set text
		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				button.performClick();
			}
		});

	

	}
	
	public void testBet2Button() throws Exception {

		PlayActivity activity = getActivity();

		// search for the textView
		final ImageButton button = (ImageButton) activity
				.findViewById(R.id.two);

		// set text
		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				button.performClick();
			}
		});

	

	}
	
	public void testBet5Button() throws Exception {

		PlayActivity activity = getActivity();

		// search for the textView
		final ImageButton button = (ImageButton) activity
				.findViewById(R.id.five);

		// set text
		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				button.performClick();
			}
		});

	

	}
	
	public void testBet10Button() throws Exception {

		PlayActivity activity = getActivity();

		// search for the textView
		final ImageButton button = (ImageButton) activity
				.findViewById(R.id.ten);

		// set text
		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				button.performClick();
			}
		});

	

	}
	
	public void testBet20Button() throws Exception {

		PlayActivity activity = getActivity();

		// search for the textView
		final ImageButton button = (ImageButton) activity
				.findViewById(R.id.twenty);

		// set text
		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				button.performClick();
			}
		});

	

	}
	
	public void testBet50Button() throws Exception {

		PlayActivity activity = getActivity();

		// search for the textView
		final ImageButton button = (ImageButton) activity
				.findViewById(R.id.fifty);

		// set text
		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				button.performClick();
			}
		});

	

	}

}
