package umn.ac.id.uas_projek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Start, Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Start = findViewById(R.id.start);
        Profile = findViewById(R.id.profile);

        Start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel = new Intent(MainActivity.this, Level.class);
                startActivity(IntentLevel);
            }
        });
    }
}
