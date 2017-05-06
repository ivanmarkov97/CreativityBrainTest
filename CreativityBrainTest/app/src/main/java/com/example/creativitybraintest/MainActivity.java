package com.example.creativitybraintest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView header;
    Button next;
    Button prev;
    CheckBox[] chb = new CheckBox[5];
    int questionNumber = 1;
    static int[][] answers = new int[15][5];
    static int[] toSend = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final String[] questions = getResources().getStringArray(R.array.questions);

        header = (TextView) findViewById(R.id.textView2);
        //header.setBackgroundColor(Color.WHITE);

        chb[0] = (CheckBox) findViewById(R.id.checkBox);
        chb[1] = (CheckBox) findViewById(R.id.checkBox2);
        chb[2] = (CheckBox) findViewById(R.id.checkBox3);
        chb[3] = (CheckBox) findViewById(R.id.checkBox4);
        chb[4] = (CheckBox) findViewById(R.id.checkBox5);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(questionNumber) + "/15");

        next = (Button) findViewById(R.id.button);

        for(int i = 0; i < 5; i++) {
            if ((5 * (questionNumber - 1) + i) < questions.length) {
                chb[i].setText(questions[5 * (questionNumber - 1) + i]);
            }
        }

        View.OnClickListener OnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.checkBox:
                        chb[1].setChecked(false);
                        chb[2].setChecked(false);
                        chb[3].setChecked(false);
                        chb[4].setChecked(false);

                        break;
                    case R.id.checkBox2:
                        chb[0].setChecked(false);
                        chb[2].setChecked(false);
                        chb[3].setChecked(false);
                        chb[4].setChecked(false);

                        break;
                    case R.id.checkBox3:
                        chb[0].setChecked(false);
                        chb[1].setChecked(false);
                        chb[3].setChecked(false);
                        chb[4].setChecked(false);

                        break;
                    case R.id.checkBox4:
                        chb[0].setChecked(false);
                        chb[1].setChecked(false);
                        chb[2].setChecked(false);
                        chb[4].setChecked(false);

                        break;
                    case R.id.checkBox5:
                        chb[0].setChecked(false);
                        chb[1].setChecked(false);
                        chb[2].setChecked(false);
                        chb[3].setChecked(false);

                        break;

                    case R.id.button:
                        if (questionNumber <= 15) {
                            for (int i = 0; i < 5; i++) {
                                if (chb[i].isChecked()) {
                                    answers[questionNumber - 1][i] = 1;
                                    chb[i].setChecked(false);
                                }
                            }
                            questionNumber++;

                            if(questionNumber != 16) {
                                textView.setText(String.valueOf(questionNumber) + "/15");
                                for (int i = 0; i < 5; i++) {
                                    if ((5 * (questionNumber - 1) + i) < questions.length) {
                                        chb[i].setText(questions[5 * (questionNumber - 1) + i]);
                                    }
                                }
                            }

                            if(questionNumber == 16){
                                for(int i = 0; i < 5; i++)
                                    if(chb[i].isChecked()) {
                                        answers[questionNumber - 2][i] = 1;
                                        chb[i].setChecked(false);
                                    }

                                for(int i = 0; i < 15; i++){
                                    toSend[0] += answers[i][0];
                                    toSend[1] += answers[i][1];
                                    toSend[2] += answers[i][2];
                                    toSend[3] += answers[i][3];
                                    toSend[4] += answers[i][4];
                                }
                                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                                intent.putExtra("subject", toSend[0]);
                                intent.putExtra("symbol", toSend[1]);
                                intent.putExtra("sign", toSend[2]);
                                intent.putExtra("sample", toSend[3]);
                                intent.putExtra("creativity", toSend[4]);
                                startActivity(intent);
                                finish();
                                break;
                            }
                        }

                       break;
                }
            }
        };

        chb[0].setOnClickListener(OnClickListener);
        chb[1].setOnClickListener(OnClickListener);
        chb[2].setOnClickListener(OnClickListener);
        chb[3].setOnClickListener(OnClickListener);
        chb[4].setOnClickListener(OnClickListener);

        next.setOnClickListener(OnClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
