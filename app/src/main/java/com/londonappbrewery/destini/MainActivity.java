package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    final int BOTTOM_PRESSED = 0;
    final int TOP_PRESSED = 1;
    Button mTopAnswerButton;
    Button mBottomAnswerButton;
    TextView mStoryTextView;
    int mStoryProgress = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTopAnswerButton = (Button) findViewById(R.id.buttonTop);
        mBottomAnswerButton = (Button) findViewById(R.id.buttonBottom);
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopAnswerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateStory(TOP_PRESSED);
                }
            }
        );

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(BOTTOM_PRESSED);
            }
        });

    }

    private void updateStory(int buttonPressed) {

        if (mStoryProgress == 1 && buttonPressed == TOP_PRESSED) {
            mStoryTextView.setText(R.string.T3_Story);
            mTopAnswerButton.setText(R.string.T3_Ans1);
            mBottomAnswerButton.setText(R.string.T3_Ans2);
            mStoryProgress = 3;
        }
        else if (mStoryProgress == 1 && buttonPressed == BOTTOM_PRESSED) {
            mStoryTextView.setText(R.string.T2_Story);
            mTopAnswerButton.setText(R.string.T2_Ans1);
            mBottomAnswerButton.setText(R.string.T2_Ans2);
            mStoryProgress = 2;
        }
        else if (mStoryProgress == 3 && buttonPressed == TOP_PRESSED) {
            mStoryTextView.setText(R.string.T6_End);
            mTopAnswerButton.setVisibility(View.GONE);
            mBottomAnswerButton.setVisibility(View.GONE);
            mStoryProgress = 6;
        }
        else if (mStoryProgress == 3 && buttonPressed == BOTTOM_PRESSED) {
            mStoryTextView.setText(R.string.T5_End);
            mTopAnswerButton.setVisibility(View.GONE);
            mBottomAnswerButton.setVisibility(View.GONE);
            mStoryProgress = 5;
        }
        else if (mStoryProgress == 2 && buttonPressed == TOP_PRESSED) {
            mStoryTextView.setText(R.string.T3_Story);
            mTopAnswerButton.setText(R.string.T3_Ans1);
            mBottomAnswerButton.setText(R.string.T3_Ans2);
            mStoryProgress = 3;
        }
        else if (mStoryProgress == 2 && buttonPressed == BOTTOM_PRESSED) {
            mStoryTextView.setText(R.string.T4_End);
            mTopAnswerButton.setVisibility(View.GONE);
            mBottomAnswerButton.setVisibility(View.GONE);
            mStoryProgress = 4;
        }

        if (mStoryProgress > 3){
            Toast.makeText(getApplicationContext(), "Story Complete!", Toast.LENGTH_SHORT).show();
        }

    }
}
