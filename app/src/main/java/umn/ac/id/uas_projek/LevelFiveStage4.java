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

public class LevelFiveStage4 extends AppCompatActivity {
    Button bt1, bt2, bt3, bt4, btplay, btback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five_stage4);
        btback = findViewById(R.id.back);
        bt1 = findViewById(R.id.butt1);
        bt2 = findViewById(R.id.butt2);
        bt3 = findViewById(R.id.butt3);
        bt4 = findViewById(R.id.butt4);
        btplay = findViewById(R.id.playbutt);
        final Toast benar = Toast.makeText(getApplicationContext(),"Sugoi!!!", Toast.LENGTH_SHORT);
        final Toast salah = Toast.makeText(getApplicationContext(),"Non!!!", Toast.LENGTH_SHORT);
        final MediaPlayer mp = new MediaPlayer();

        ImageView stage4;
        stage4 = findViewById(R.id.stage4);
        Picasso.get().load("https://firebasestorage.googleapis.com/v0/b/vvibuumn-guesttheanimu.appspot.com/o/Gambar_Stage%2FStage%205%2Fhidan.jpg?alt=media&token=b5e03131-de8c-4019-9562-ba3d5b43352f").into(stage4);

        //btback.setOnClickListener(new View.OnClickListener()
        //{
        //    @Override
        //    public void onClick(View v)
        //    {
        //       mp.start();
        //    }
        //});

        btplay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    // Hidan no Aria
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/vvibuumn-guesttheanimu.appspot.com/o/Musik%2FStage%205%2FHidan%20no%20Aria%20Opening.mp3?alt=media&token=ba004da4-eff3-43b6-8fdf-b1530c57a21f"); // Link dari Firebase Storage
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
                benar.show();
                mp.stop();
                Intent next = new Intent(LevelFiveStage4.this, LevelFiveStage5.class);
                startActivity(next);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                salah.show();
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
