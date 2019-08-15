package org.hello;

import java.util.Random;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    
    public Button rollButton;
    public Button advanceButton;
    public Button customButton;
    int inputNum;
    
    EditText customInput;
    
    
    
    final int [] mDiceArray = {R.drawable.mside1, R.drawable.mside2, R.drawable.mside3,
        R.drawable.mside4, R.drawable.mside5, R.drawable.mside6, R.drawable.mside7,
        R.drawable.mside8, R.drawable.mside9, R.drawable.mside10, R.drawable.mside11,
        R.drawable.mside12, R.drawable.mside13, R.drawable.mside14, R.drawable.mside15,
        R.drawable.mside16, R.drawable.mside17, R.drawable.mside18, R.drawable.mside19,
        R.drawable.mside20};
    
    
    
     public void advanceRoll(){
        advanceButton = (Button) findViewById(R.id.advanceButton);
        final MediaPlayer rollSound = MediaPlayer.create(this, R.raw.dice);
        final ImageView leftDice = (ImageView) findViewById(R.id.image_leftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.image_rightDice);
        
        final String [] messageArr = {"Nice Roll!", 
        "Get those beast!", 
        "So many numbers!",  
        "$$$$$$",
        "Put some more effort!",
        "DOUBLES!!!!"};
        advanceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random randomNumberGenerator = new Random();
                int lNumber = randomNumberGenerator.nextInt(20);
                leftDice.setImageResource(mDiceArray[lNumber]);
                int rNumber = randomNumberGenerator.nextInt(20);
                rightDice.setImageResource(mDiceArray[rNumber]);
                int mNumber = randomNumberGenerator.nextInt(3);
            
                 if(lNumber == rNumber){
                    mNumber = 5;
                 }else if((lNumber+rNumber) < 10){
                    mNumber = 4;
                 }
                 rollSound.start();
                 Toast.makeText(getBaseContext(), messageArr[mNumber], Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    public void rolling(){
        rollButton = (Button) findViewById(R.id.rollButton);
        final MediaPlayer diceSound = MediaPlayer.create(this, R.raw.dice);
        final ImageView leftDice = (ImageView) findViewById(R.id.image_leftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.image_rightDice);
        final int [] diceArray = {R.drawable.dice1, 
        R.drawable.dice2, 
        R.drawable.dice3, 
        R.drawable.dice4, 
        R.drawable.dice5, 
        R.drawable.dice6};
        final String [] messageArr = {"Nice Roll!", 
        "With Finesse!", 
        "Way to go!",  
        "$$$$$$",
        "Put some more effort!",
        "DOUBLES!!!!", 
        "SNAKE EYES!!!!" };
        rollButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View w){
            Random randomNumberGenerator = new Random();
            int lNumber = randomNumberGenerator.nextInt(6);
            leftDice.setImageResource(diceArray[lNumber]);
            int rNumber = randomNumberGenerator.nextInt(6);
            rightDice.setImageResource(diceArray[rNumber]);
            int mNumber = randomNumberGenerator.nextInt(3);
            
            if(lNumber == rNumber){
                mNumber = 5;
            }else if((lNumber+rNumber) < 4){
                mNumber = 4;
            }
            if(lNumber == 0 && rNumber == 0){
                mNumber = 6;
            }
            
            diceSound.start();
            Toast.makeText(getBaseContext(), messageArr[mNumber], Toast.LENGTH_SHORT).show();
        }
        });
    }
    
    public void custom(){
        customInput = (EditText) findViewById(R.id.customInput);
        customButton = (Button) findViewById(R.id.customButton);
        final ImageView leftDice = (ImageView) findViewById(R.id.image_leftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.image_rightDice);
        customButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                inputNum = Integer.valueOf(customInput.getText().toString());
                Random randomNumberGenerator = new Random();
                if(inputNum < 7 || inputNum > 20){
                    Toast.makeText(getBaseContext(), "Please insert a # between 7 and 20", Toast.LENGTH_SHORT).show();
                }else{
                int lNumber = randomNumberGenerator.nextInt(inputNum);
                leftDice.setImageResource(mDiceArray[lNumber]);
                int rNumber = randomNumberGenerator.nextInt(inputNum);
                rightDice.setImageResource(mDiceArray[rNumber]);
                }

            }
        });
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
        rolling();
        advanceRoll();
        custom();
        
        TextView theTextView = (TextView) findViewById(R.id.textView1);
        theTextView.setText("Press the Roll button to roll basic dice. Press the Advance Roll button to roll multi-sided dice. Insert your own custom amount of dice also. Enjoy!");
    }
   
}