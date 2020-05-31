package umn.ac.id.uas_projek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Profile extends AppCompatActivity
{
    private TextView Nama, Score;
    private ImageView imageView;
    private String ID;
    private static final String TAG = "MyActivity";
    private static final String FILE_NAME = "Sessions.txt";
    public static Member member = new Member();
    private DatabaseReference mDatabase;
    private Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Nama = findViewById(R.id.Nama);
        imageView = findViewById(R.id.imageProfile);
        btnEdit = findViewById(R.id.btnEdit);

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
                member.setUserID(ID.toString().trim());
                Log.d(TAG, "ID From Member (PROFILE): " + member.getUserID());
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

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(member.getUserID());
        mDatabase.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String nama = dataSnapshot.child("nama").getValue().toString();
                String image = dataSnapshot.child("imageURL").getValue().toString();
                Nama.setText(nama);
                member.setNama(nama);
                member.setImageURL(image);
                Picasso.get().load(image).resize(800, 800).into(imageView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(v.getContext(), EditProfile.class);
                i.putExtra("UserID", member.getUserID());
                i.putExtra("Nama", member.getNama());
                i.putExtra("Image", member.getImageURL());
                v.getContext().startActivity(i);
            }
        });
    }
}














