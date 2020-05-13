package umn.ac.id.uas_projek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Level extends AppCompatActivity
{
    private Button Lvl1, Lvl2, Lvl3, Lvl4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        Lvl1 = findViewById(R.id.Lv1);
        Lvl2 = findViewById(R.id.Lv2);
        Lvl2 = findViewById(R.id.Lv2);
        Lvl3 = findViewById(R.id.Lv3);
        Lvl4 = findViewById(R.id.Lv4);

        Lvl1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel1 = new Intent(Level.this, LevelOne.class);
                startActivity(IntentLevel1);
            }
        });

        /*
        Lvl2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel1 = new Intent(Level.this, LevelOne.class)
                startActivity(IntentLevel1);
            }
        });

        Lvl3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel1 = new Intent(Level.this, LevelOne.class)
                startActivity(IntentLevel1);
            }
        });

        Lvl4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel1 = new Intent(Level.this, LevelOne.class)
                startActivity(IntentLevel1);
            }
        });
         */
    }
}
