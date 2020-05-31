package umn.ac.id.uas_projek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelFive extends AppCompatActivity {
    Button st1, st2, st3, st4, st5, btback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_five);
        //btback = findViewById(R.id.back);
        st1 = findViewById(R.id.Lv1);
        st2 = findViewById(R.id.Lv2);
        st3 = findViewById(R.id.Lv3);
        st4 = findViewById(R.id.Lv4);
        st5 = findViewById(R.id.Lv5);

        st1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent level = new Intent(LevelFive.this, LevelFiveStage1.class);
                startActivity(level);
            }
        });
        st2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel2 = new Intent(LevelFive.this, LevelFiveStage2.class);
                startActivity(IntentLevel2);
            }
        });
        st3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel3 = new Intent(LevelFive.this, LevelFiveStage3.class);
                startActivity(IntentLevel3);
            }
        });
        st4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel4 = new Intent(LevelFive.this, LevelFiveStage4.class);
                startActivity(IntentLevel4);
            }
        });
        st5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel5 = new Intent(LevelFive.this, LevelFiveStage5.class);
                startActivity(IntentLevel5);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(LevelFive.this, Level.class);
        startActivity(intent);
    }
}
