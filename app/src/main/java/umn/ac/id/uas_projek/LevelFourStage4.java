package umn.ac.id.uas_projek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class LevelFourStage4 extends AppCompatActivity {
    Button bt1, bt2, bt3, bt4, btplay, btback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_four_stage4);
        btback = findViewById(R.id.back);
        bt1 = findViewById(R.id.butt1);
        bt2 = findViewById(R.id.butt2);
        bt3 = findViewById(R.id.butt3);
        bt4 = findViewById(R.id.butt4);
        btplay = findViewById(R.id.playbutt);
        final Toast benar = Toast.makeText(getApplicationContext(),"Sugoi!!!", Toast.LENGTH_SHORT);
        final Toast salah = Toast.makeText(getApplicationContext(),"Non!!!", Toast.LENGTH_SHORT);
        final MediaPlayer mp = new MediaPlayer();

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
                    // High School DxD
                    mp.setDataSource("https://firebasestorage.googleapis.com/v0/b/vvibuumn-guesttheanimu.appspot.com/o/High%20School%20DxD%20-%20OP%201.mp3?alt=media&token=7a9ae559-a860-4378-9740-08cb7a21ac87"); // Link dari Firebase Storage
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
                salah.show();
            }
        });

        bt4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                benar.show();
                mp.stop();
                Intent next = new Intent(LevelFourStage4.this, LevelFourStage5.class);
                startActivity(next);
            }
        });
    }
}
