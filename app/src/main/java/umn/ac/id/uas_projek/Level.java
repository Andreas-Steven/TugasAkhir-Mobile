package umn.ac.id.uas_projek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Level extends AppCompatActivity {
    private Button Lvl1, Lvl2, Lvl3, Lvl4, Lvl5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        Lvl1 = findViewById(R.id.Lv1);
        Lvl2 = findViewById(R.id.Lv2);
        Lvl3 = findViewById(R.id.Lv3);
        Lvl4 = findViewById(R.id.Lv4);
        Lvl5 = findViewById(R.id.Lv5);

        Lvl1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel1 = new Intent(Level.this, LevelOne.class);
                startActivity(IntentLevel1);
            }
        });
        Lvl2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel2 = new Intent(Level.this, LevelTwo.class);
                startActivity(IntentLevel2);
            }
        });
        Lvl3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel3 = new Intent(Level.this, LevelThree.class);
                startActivity(IntentLevel3);
            }
        });
        Lvl4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel4 = new Intent(Level.this, LevelFour.class);
                startActivity(IntentLevel4);
            }
        });
        Lvl5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel5 = new Intent(Level.this, LevelFive.class);
                startActivity(IntentLevel5);
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Level.this, MainActivity.class);
        startActivity(intent);
    }
}
