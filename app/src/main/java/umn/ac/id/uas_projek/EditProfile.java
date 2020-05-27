package umn.ac.id.uas_projek;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class EditProfile extends AppCompatActivity
{
    private Button Update, PilihFoto;
    private ImageView imageViewProfile;
    private EditText editNama;
    private String UserID, Nama, ImageURL;
    private Member member = new Member();
    private static final int ImageBack = 1;
    private StorageReference Folder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        Update = findViewById(R.id.btnUpdate);
        PilihFoto = findViewById(R.id.btnPilihFoto);
        imageViewProfile = findViewById(R.id.imageViewProfile);
        editNama = findViewById(R.id.editNama);

        Folder = FirebaseStorage.getInstance().getReference().child("ImageProfile");

        Intent i = getIntent();
        UserID = i.getStringExtra("UserID");
        Nama = i.getStringExtra("Nama");
        ImageURL = i.getStringExtra("Image");
        member.setNama(Nama);
        member.setUserID(UserID);
        member.setImageURL(ImageURL);

        editNama.setText(Nama);
        Picasso.get().load(ImageURL).resize(800, 800).into(imageViewProfile);

        Update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Users").child(member.getUserID());
                String NamaUpdate = editNama.getText().toString();
                Member NewData = new Member(UserID, NamaUpdate, ImageURL);
                database.setValue(NewData);

                Toast.makeText(getApplicationContext(), "Your Profile Has Been Updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void UploadImage(View view)
    {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        startActivityForResult(i, ImageBack);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ImageBack)
        {
            if(resultCode == RESULT_OK)
            {
                Uri ImageData = data.getData();
                final StorageReference ImageName = Folder.child("image" + ImageData.getLastPathSegment());

                ImageName.putFile(ImageData).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>()
                {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
                    {
                        ImageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>()
                        {
                            @Override
                            public void onSuccess(Uri uri)
                            {
                                DatabaseReference ImageStore = FirebaseDatabase.getInstance().getReference().child("Users").child(member.getUserID());
                                Member NewData = new Member(UserID, Nama, uri.toString().trim());
                                ImageStore.setValue(NewData);
                                Toast.makeText(getApplicationContext(), "Image Uploaded", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                });
            }
        }
    }
}
