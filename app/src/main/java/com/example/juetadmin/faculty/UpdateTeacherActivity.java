package com.example.juetadmin.faculty;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.juetadmin.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class UpdateTeacherActivity extends AppCompatActivity {

    private EditText updateTeacherName, updateTeacherEmail, updateTeacherPost;
    private ImageView updateTeacherImage;
    private Button updateTeacherBtn, deleteTeacherBtn;
    private String name,email,image,post;
    private final int REQ =1;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_teacher);
        updateTeacherName = findViewById(R.id.updateTeacherName);
        updateTeacherEmail  = findViewById(R.id.updateTeacherEmail);
        updateTeacherImage = findViewById(R.id.updateTeacherImage);
        updateTeacherPost = findViewById(R.id.updateTeacherPost);
        updateTeacherBtn = findViewById(R.id.updateTeacherBtn);
        deleteTeacherBtn = findViewById(R.id.deleteTeacherBtn);

        name= getIntent().getStringExtra("name");
        email= getIntent().getStringExtra("email");
        image= getIntent().getStringExtra("image");
        post= getIntent().getStringExtra("post");

        try {
            Picasso.get().load(image).into(updateTeacherImage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        updateTeacherEmail.setText(email);
        updateTeacherName.setText(name);
        updateTeacherPost.setText(post);

        updateTeacherImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage,REQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== REQ && resultCode== RESULT_OK){
            Uri uri= data.getData();
            try {
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            updateTeacherImage.setImageBitmap(bitmap);
        }
    }
}