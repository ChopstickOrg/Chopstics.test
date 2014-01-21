package com.example.chopsticks.test;

import android.content.Intent;
import android.widget.Button;

import com.example.chopsticks.MainActivity;

public class MainActivityUnitTest extends
		android.test.ActivityUnitTestCase<MainActivity> {

	private int playButtonId;
	private int sendButtonId;
	private int receiveButtonId;
	
	private MainActivity activity;

	// Constructor
	public MainActivityUnitTest() {
		super(MainActivity.class);
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
	
	public void testPlayButton() {
	    playButtonId = com.example.chopsticks.R.id.buttonPlay;
	    assertNotNull(activity.findViewById(playButtonId));
	    //Button view = (Button) activity.findViewById(buttonId);
	    //assertEquals("Incorrect label of the button", "Play", view.getText());
	  }
	
	public void testSendButton() {
	    sendButtonId = com.example.chopsticks.R.id.buttonSend;
	    assertNotNull(activity.findViewById(sendButtonId));
	    //Button view = (Button) activity.findViewById(buttonId);
	    //assertEquals("Incorrect label of the button", "Play", view.getText());
	  }
	
	public void testReceiveButton() {
		receiveButtonId = com.example.chopsticks.R.id.buttonReceive;
	    assertNotNull(activity.findViewById(receiveButtonId));
	    //Button view = (Button) activity.findViewById(buttonId);
	    //assertEquals("Incorrect label of the button", "Play", view.getText());
	  }
	
	public void testIntentTriggerViaOnClick_Play() {
		playButtonId = com.example.chopsticks.R.id.buttonPlay;
	    Button view = (Button) activity.findViewById(playButtonId);
	    assertNotNull("Button not allowed to be null", view);

	    view.performClick();
	    
	    // TouchUtils cannot be used, only allowed in 
	    // InstrumentationTestCase or ActivityInstrumentationTestCase2 
	  
	    // Check the intent which was started
	    Intent triggeredIntent = getStartedActivityIntent();
	    assertNotNull("Intent was null", triggeredIntent);
	  }
	
	public void testIntentTriggerViaOnClick_Send() {
		sendButtonId = com.example.chopsticks.R.id.buttonSend;
	    Button view = (Button) activity.findViewById(sendButtonId);
	    assertNotNull("Button not allowed to be null", view);

	    view.performClick();
	    
	    // TouchUtils cannot be used, only allowed in 
	    // InstrumentationTestCase or ActivityInstrumentationTestCase2 
	  
	    // Check the intent which was started
	    Intent triggeredIntent = getStartedActivityIntent();
	    assertNotNull("Intent was null", triggeredIntent);
	  }

	public void testIntentTriggerViaOnClick_Receive() {
		receiveButtonId = com.example.chopsticks.R.id.buttonReceive;
	    Button view = (Button) activity.findViewById(receiveButtonId);
	    assertNotNull("Button not allowed to be null", view);

	    view.performClick();
	    
	    // TouchUtils cannot be used, only allowed in 
	    // InstrumentationTestCase or ActivityInstrumentationTestCase2 
	  
	    // Check the intent which was started
	    Intent triggeredIntent = getStartedActivityIntent();
	    assertNotNull("Intent was null", triggeredIntent);
	  }
}
