package com.example.pokemonrunning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtScore;
    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2, sb3;
    ImageButton imbPlay;
    int Score = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);

        txtScore.setText(Score + "");

        final CountDownTimer countDownTimer = new CountDownTimer(60000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 4;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                if (sb1.getProgress() >= sb1.getMax()){
                    this.cancel();
                    imbPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Pikachu win!", Toast.LENGTH_SHORT).show();
                    if (cb1.isChecked()){
                        Score += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác!", Toast.LENGTH_SHORT).show();
                    } else {
                        Score -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán sai!", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(Score + "");
                    EnableCheckbox();
                }
                if (sb2.getProgress() >= sb2.getMax()){
                    this.cancel();
                    imbPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Bulbasaur win!", Toast.LENGTH_SHORT).show();
                    if (cb2.isChecked()){
                        Score += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác!", Toast.LENGTH_SHORT).show();
                    } else {
                        Score -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán sai!", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(Score + "");
                    EnableCheckbox();
                }
                if (sb3.getProgress() >= sb3.getMax()){
                    this.cancel();
                    imbPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Totodile win!", Toast.LENGTH_SHORT).show();
                    if (cb3.isChecked()){
                        Score += 10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác!", Toast.LENGTH_SHORT).show();
                    } else {
                        Score -= 5;
                        Toast.makeText(MainActivity.this, "Bạn đã đoán sai!", Toast.LENGTH_SHORT).show();
                    }
                    txtScore.setText(Score + "");
                    EnableCheckbox();
                }

                sb1.setProgress(sb1.getProgress() + one);
                sb2.setProgress(sb2.getProgress() + two);
                sb3.setProgress(sb3.getProgress() + three);
            }

            @Override
            public void onFinish() {

            }
        };

        imbPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked()){
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    imbPlay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();

                    DisableCheckbox();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }
            }
        });
    }

    private void EnableCheckbox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    private void DisableCheckbox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void Anhxa(){
        txtScore    = (TextView) findViewById(R.id.txtScore);
        imbPlay     = (ImageButton) findViewById(R.id.ibtnPlay);
        cb1         = (CheckBox) findViewById(R.id.ckb1);
        cb2         = (CheckBox) findViewById(R.id.ckb2);
        cb3         = (CheckBox) findViewById(R.id.ckb3);
        sb1         = (SeekBar) findViewById(R.id.skb1);
        sb2         = (SeekBar) findViewById(R.id.skb2);
        sb3         = (SeekBar) findViewById(R.id.skb3);
    }
}
