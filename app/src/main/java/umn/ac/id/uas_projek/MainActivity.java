package umn.ac.id.uas_projek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MainActivity extends AppCompatActivity {
    Button Start, Profile;
    private DatabaseReference mDatabase;
    private String ID;
    private String RdmNama;
    private ImageView imageViewProfile;
    private static final String TAG = "MyActivity";
    private static  final  String FILE_NAME = "Sessions.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Start = findViewById(R.id.start);
        Profile = findViewById(R.id.profile);
        imageViewProfile = findViewById(R.id.imageViewProfile);

        File file = getFileStreamPath(FILE_NAME);
            if (file.exists())
            {
                FileInputStream FIS = null;

                try
                {
                    FIS = openFileInput(FILE_NAME);
                    InputStreamReader ISR = new InputStreamReader(FIS);
                    BufferedReader BR = new BufferedReader(ISR);
                    StringBuilder SB = new StringBuilder();
                    String Text;

                    while ((Text = BR.readLine()) != null)
                    {
                        SB.append(Text).append("\n");
                    }

                    ID = SB.toString();
                    final Member member = new Member();
                    member.setUserID(ID.toString().trim());

                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(member.getUserID());
                    mDatabase.addValueEventListener(new ValueEventListener()
                    {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                        {
                            String nama = dataSnapshot.child("nama").getValue().toString();
                            String image = dataSnapshot.child("imageURL").getValue().toString();
                            member.setNama(nama);
                            member.setImageURL(image);
                            Picasso.get().load(image).resize(250, 250).into(imageViewProfile);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError)
                        {

                        }
                    });

                    Log.d(TAG, "ID From Member: " + member.getUserID());
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                finally {
                    if(FIS != null)
                    {
                        try
                        {
                            FIS.close();
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }

        }
        else
        {
            ID = getRandomString(8);
            Log.d(TAG, "ID: " + ID);
            RdmNama = getRandomString(6);
            Log.d(TAG, "RdmNama: " + RdmNama);

            // Store to Firebase Database
            Member member = new Member(ID, RdmNama, "https://firebasestorage.googleapis.com/v0/b/vvibuumn-guesttheanimu.appspot.com/o/ImageProfile%2Fprofile.png?alt=media&token=76eabb49-b1a8-4242-bbd8-0856b702cdf1");
            mDatabase.child("Users").child(ID).setValue(member);

            // Write to txt file
            FileOutputStream FOS = null;

            try
            {
                FOS = openFileOutput(FILE_NAME, MODE_PRIVATE);
                FOS.write(ID.getBytes());
                Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
                Log.d(TAG, "Saved to " + getFilesDir() + "/" + FILE_NAME);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                if(FOS != null)
                {
                    try
                    {
                        FOS.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }

        Start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLevel = new Intent(MainActivity.this, Level.class);
                startActivity(IntentLevel);
            }
        });

        Profile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentProfile = new Intent(MainActivity.this, Profile.class);
                startActivity(IntentProfile);
            }
        });
    }


    // Generated Ramdom Name Contains 8 Char
    private String getRandomString(int i)
    {
        final String characters = "abcdefghijklmnopqrtuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        while(i > 0)
        {
            Random rand = new Random();
            result.append(characters.charAt(rand.nextInt(characters.length())));
            i--;
        }

        return result.toString();
    }
}
