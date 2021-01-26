package com.example.animalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ClickedItemActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Button bt,bt_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.tvName);
        bt = (Button) findViewById(R.id.clickme);
        bt_stop = (Button) findViewById(R.id.stopclick);

        final MediaPlayer mp0 = MediaPlayer.create(this, R.raw.bat);
        final MediaPlayer mp1 = MediaPlayer.create(this, R.raw.cat);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.crocodile);
        final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.frog);
        final MediaPlayer mp4 = MediaPlayer.create(this, R.raw.horse);
        final MediaPlayer mp5 = MediaPlayer.create(this, R.raw.lion);
        final MediaPlayer mp6 = MediaPlayer.create(this, R.raw.mouse);
        final MediaPlayer mp7 = MediaPlayer.create(this, R.raw.panda);
        final MediaPlayer mp8 = MediaPlayer.create(this, R.raw.rabbit);
        final MediaPlayer mp9 = MediaPlayer.create(this, R.raw.tiger);




            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (textView.getText().toString().equals("bat")) {
                    mp0.start();
                }if(textView.getText().toString().equals("cat")) {
                        mp1.start();
                    }if(textView.getText().toString().equals("crocodile")) {
                        mp2.start();
                    }if(textView.getText().toString().equals("frog")) {
                        mp3.start();
                    }if(textView.getText().toString().equals("horse")) {
                        mp4.start();
                    }if(textView.getText().toString().equals("lion")) {
                        mp5.start();
                    }if(textView.getText().toString().equals("mouse")) {
                        mp6.start();
                    }if(textView.getText().toString().equals("panda")) {
                        mp7.start();
                    }if(textView.getText().toString().equals("rabbit")) {
                        mp8.start();
                    }if(textView.getText().toString().equals("tiger")) {
                        mp9.start();
                    }
            }});


        bt_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    mp0.release();
                    mp1.release();
                    mp2.release();
                    mp3.release();
                    mp4.release();
                    mp5.release();
                    mp6.release();
                    mp7.release();
                    mp8.release();
                    mp9.release();


                }
            });






        Intent intent = getIntent();

        if (intent.getExtras() != null) {
            String selectedName = intent.getStringExtra("name");
            int selectedImage = intent.getIntExtra("image", 0);

            textView.setText(selectedName);
            imageView.setImageResource(selectedImage);

        }



    }


}

