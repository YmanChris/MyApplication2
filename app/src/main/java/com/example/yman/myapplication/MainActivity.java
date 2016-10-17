package com.example.yman.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView image1;
    private ImageView image2;
    private SeekBar seekBar;
    private TextView progressText;
    private Bitmap tempBitmap;
    private Bitmap finalBitmap;
    private int mAltha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        tempBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.res);
        finalBitmap = BlurBitmap.blur(this,tempBitmap);
        image1.setImageBitmap(tempBitmap);
        image2.setImageBitmap(finalBitmap);
        setSeekBar();
    }
    public void initView(){
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        progressText = (TextView) findViewById(R.id.progress_text);
    }
    public void setSeekBar(){
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mAltha = i;
                image1.setAlpha((int)(255 - mAltha * 2.55));
                progressText.setText(String.valueOf(mAltha));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
