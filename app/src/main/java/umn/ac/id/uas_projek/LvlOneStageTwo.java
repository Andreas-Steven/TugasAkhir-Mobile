package umn.ac.id.uas_projek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class LvlOneStageTwo extends AppCompatActivity {
    Button bt1, bt2, bt3, bt4, btplay, btback;
    ImageView stage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl_one_stage_two);
        btback = findViewById(R.id.back);
        bt1 = findViewById(R.id.butt1);
        bt2 = findViewById(R.id.butt2);
        bt3 = findViewById(R.id.butt3);
        bt4 = findViewById(R.id.butt4);
        btplay = findViewById(R.id.playbutt);
        final Toast benar = Toast.makeText(getApplicationContext(),"Sugoi!!!", Toast.LENGTH_SHORT);
        final Toast salah = Toast.makeText(getApplicationContext(),"Non!!!", Toast.LENGTH_SHORT);
        final MediaPlayer mp = new MediaPlayer();

        stage2 = findViewById(R.id.stage2);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/vvibuumn-guesttheanimu.appspot.com/o/Gambar_Stage%2FStage%201%2FSaenai.png?alt=media&token=c78c28d6-6d64-4148-a7e7-e56aab19eec6").into(stage2);
        /*btback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent back = new Intent(LvlOneStageTwo.this, LevelOne.class);
                startActivity(back);
            }
        });*/

        btplay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    // Saenai Heroine no Sodatekata
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/vvibuumn-guesttheanimu.appspot.com/o/Musik%2FStage%201%2FKimiiro%20Signal%20-%20Luna_Haruna-%20Saenai%20Heroine%20no%20Sodatekata.mp3?alt=media&token=2da4e8e2-25fa-47db-9367-17cad4a16074"); // Link dari Firebase Storage
                    mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
                    {
                        @Override
                        public void onPrepared(MediaPlayer mp)
                        {
                            mp.start();
                        }
                    });

                    mp.prepare();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }


                mp.start();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                salah.show();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                salah.show();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                benar.show();
                mp.stop();
                Intent next = new Intent(LvlOneStageTwo.this, LvlOneStageThree.class);
                startActivity(next);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                salah.show();
            }
        });
    }
}
