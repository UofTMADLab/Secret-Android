package ca.utoronto.madlab.mysecretcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

//        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                TextView textView = (TextView) findViewById(R.id.textView2);
//                textView.setText(String.valueOf(i));
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
    }

    public void onButtonTapped (View v) {
        Intent intent = new Intent(this, ResultActivity.class);
        String message = "Sorry that was the incorrect code.";
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar2);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar3);
        Switch sw = (Switch) findViewById(R.id.switch1);
        if (seekBar.getProgress() == 25 && ratingBar.getRating() == 3.0 && sw.isChecked()== true){
            message = "This is the secret message!";
        }
        intent.putExtra("com.exampleapp.messagetext", message);
        startActivity(intent);
    }
}
