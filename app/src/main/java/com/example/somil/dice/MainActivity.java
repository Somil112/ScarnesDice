package com.example.somil.dice;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int totscore=0,totcscore=0,uscore=0,cscore=0,uTotalScore=0,cTotalScore=0;
    Button roll,b1;
    int a[]={1,2,3,4,5,6};
    int val,tscore=0;
    ImageView dice;
    TextView utotscore,ctotscore,win;
    Button hold;
    int val2,noOfOnes=0,noOfTurns=0;
    int tcscore;
    EditText playagain;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll=(Button)findViewById(R.id.roll);
        dice=(ImageView)findViewById(R.id.dice);
        utotscore=(TextView)findViewById(R.id.uscore);
        ctotscore=(TextView)findViewById(R.id.cscore);
        hold=(Button)findViewById(R.id.hold);
        win=(TextView)findViewById(R.id.Winner);
        b1=(Button)findViewById(R.id.button);
        playagain=(EditText)findViewById(R.id.playagain);

        reset=(Button)findViewById(R.id.reset);
        playagain.setVisibility(View.GONE);
        b1.setVisibility(View.GONE);
        win.setVisibility(View.GONE);

        roll();
        reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reset();
                        roll();
                    }
                }
        );



    }
    public void roll(){
        roll.setEnabled(true);
        hold.setEnabled(true);
        roll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Random generator = new Random();
                        int randomIndex = generator.nextInt(a.length);
                        val=a[randomIndex];
                        if(val==1)
                        {
                            uscore=0;
                            uTotalScore=0;

                            dice.setImageDrawable(getResources().getDrawable(R.drawable.dice1));

                        }
                        else  if(val==2)
                        {
                            uscore=2;
                            uTotalScore=uTotalScore+2;
                            dice.setImageDrawable(getResources().getDrawable(R.drawable.dice2));

                        }
                        else if(val==3)
                        {   uscore=3;
                            uTotalScore=uTotalScore+3;
                            dice.setImageDrawable(getResources().getDrawable(R.drawable.dice3));

                        }else  if(val==4)
                        {   uscore=4;
                            uTotalScore=uTotalScore+4;
                            dice.setImageDrawable(getResources().getDrawable(R.drawable.dice4));

                        }else  if(val==5)
                        {   uscore=5;
                            uTotalScore=uTotalScore+5;
                            dice.setImageDrawable(getResources().getDrawable(R.drawable.dice5));

                        }else  if(val==6)
                        {   uscore=6;
                            uTotalScore=uTotalScore+6;
                            dice.setImageDrawable(getResources().getDrawable(R.drawable.dice6));

                        }

                        tscore=uTotalScore;
                        final TextView turnscore=(TextView)findViewById(R.id.turnscore);
                        turnscore.setText("Turn Score:"+tscore);

                        hold.setOnClickListener(
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        totscore=totscore+uTotalScore;
                                        utotscore.setText("Your score"+totscore);
                                        tscore=0;
                                        turnscore.setText("Turn Score"+tscore);
                                        uTotalScore=0;
                                        hold();




                                    }
                                }
                        );


                    }
                }
        );
    }
    public void reset(){
        totscore=totcscore=uscore=cscore=uTotalScore=cTotalScore=0;
        val=tscore=0;
        val2=noOfOnes=noOfTurns=0;
        utotscore.setText("Your score"+totscore);
        ctotscore.setText("Computer score"+cTotalScore);

    }
    public void hold(){
        final Handler handler=new Handler();

        hold.setEnabled(false);
        roll.setEnabled(false);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                while(noOfTurns!=10) {
                    Random generator = new Random();
                    int randomIndex2 = generator.nextInt(a.length);
                    val2 = a[randomIndex2];
                    if (val2 == 1) {

                        cTotalScore = 0;


                        dice.setImageDrawable(getResources().getDrawable(R.drawable.dice1));

                    }

                    else  if(val==2)
                    {

                        cTotalScore=cTotalScore+2;
                        dice.setImageDrawable(getResources().getDrawable(R.drawable.dice2));

                    }
                    else if(val==3)
                    {
                        cTotalScore=cTotalScore+3;
                        dice.setImageDrawable(getResources().getDrawable(R.drawable.dice3));

                    }else  if(val==4)
                    {
                        cTotalScore=cTotalScore+4;
                        dice.setImageDrawable(getResources().getDrawable(R.drawable.dice4));

                    }else  if(val==5)
                    {
                        cTotalScore=cTotalScore+5;
                        dice.setImageDrawable(getResources().getDrawable(R.drawable.dice5));

                    }else  if(val==6)
                    {
                        cTotalScore=cTotalScore+6;
                        dice.setImageDrawable(getResources().getDrawable(R.drawable.dice6));

                    }
                    noOfTurns=noOfTurns+1;

                }
                ctotscore.setText("Computer score"+cTotalScore);
                if(cTotalScore>totscore)
                {   win.setVisibility(View.VISIBLE);
                    win.setText("Computer Wins!");
                }
                else if(cTotalScore==totscore)
                {    win.setVisibility(View.VISIBLE);
                    win.setText("It's a tie,do you want to play again?");
                    playagain.setVisibility(View.VISIBLE);
                    b1.setVisibility(View.VISIBLE);
                    b1.setOnClickListener(
                            new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    if(playagain.getText().toString().equalsIgnoreCase("yes"))
                                    {    playagain.setVisibility(View.GONE);
                                        b1.setVisibility(View.GONE);
                                        win.setVisibility(View.GONE);
                                        reset();
                                        roll();


                                    }
                                    else if(playagain.getText().toString().equalsIgnoreCase("no"))
                                    {   playagain.setVisibility(View.GONE);
                                        b1.setVisibility(View.GONE);

                                        win.setText("Thank You for playing!");

                                    }

                                }
                            }
                    );


                }
                else if(cTotalScore<totscore)
                {    win.setVisibility(View.VISIBLE);
                    win.setText("You Win!");
                }




            }
        },1000);




    }
}   
