package uk.co.gavd.android.multigotchi;

// TODO give credit for image http://antifarea.deviantart.com/ / http://opengameart.org/content/10-fantasy-rpg-enemies

import uk.co.gavd.android.multigotchi.pets.*;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainView extends Activity {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private TextView textOutput;
	private Pet model;
	private ImageView sprite;
	
	private static final int MILLISECONDS_BETWEEN_TICKS = 4000;
	
	// Create an anonymous implementation of OnClickListener
	private OnClickListener listener = new OnClickListener() {
		public void onClick(View v) {
			if(model.isDead()) {
				return;
			}
			
			try {
				if(v.equals(btn1)) {
					sprite.setImageResource(R.drawable.icon);
					model.operation(1);
				} else if(v.equals(btn2)) {
					model.operation(2);
				} else if(v.equals(btn3)) {
					model.operation(3);
				} else if(v.equals(btn4)) {
					model.operation(4);
				}

			} catch (AttributeNotFoundException e) {
				// TODO
			} catch (BehaviourNotFoundException e) {
				// TODO
			}
			
			updateText();
		}
	};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        this.setupModel();
		this.setupView();

		Heartbeat counter = new Heartbeat(MILLISECONDS_BETWEEN_TICKS, 1000);
	    counter.start();
    }
    
	public class Heartbeat extends CountDownTimer {
	    public Heartbeat(long millisInFuture, long countDownInterval) {
	        super(millisInFuture, countDownInterval);
	    }
	    public void onFinish() {
	    	this.start();
	    	try {
				model.tick();
			} catch (AttributeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	updateText();
	    }
	    public void onTick(long millisUntilFinished) {
	    	//textOutput.setText("Left: " + millisUntilFinished / 1000);
	    }
	}
    
    private void setupModel() {
    	this.model = PetFactory.getDragon();
    } 
    
    private void setupView() {
    	sprite = (ImageView) findViewById(R.id.sprite);

        try {
	    	btn1 = (Button) findViewById(R.id.btn_1);
	        btn1.setOnClickListener(listener);
	        btn1.setText(model.getBehaviour(1).getName());
	        
	        btn2 = (Button) findViewById(R.id.btn_2);
	        btn2.setOnClickListener(listener);
	        btn2.setText(model.getBehaviour(2).getName());
	        
	        btn3 = (Button) findViewById(R.id.btn_3);
	        btn3.setOnClickListener(listener);
	        btn3.setText(model.getBehaviour(3).getName());
	        
	        btn4 = (Button) findViewById(R.id.btn_4);
	        btn4.setOnClickListener(listener);
	        btn4.setText(model.getBehaviour(4).getName());
		} catch (BehaviourNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        textOutput = (TextView) findViewById(R.id.textOutput);
        
        updateText();
    }
    
    private void updateText() {
		if(model.isDead()) {
			textOutput.setText(model.getType() + " has died!");
		} else {
			textOutput.setText(model.toString());
		}
    }
}