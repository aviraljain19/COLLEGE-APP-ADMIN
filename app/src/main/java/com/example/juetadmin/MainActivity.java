package com.example.juetadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.juetadmin.faculty.UpdateFaculty;
import com.example.juetadmin.notice.DeleteNoticeActivity;
import com.example.juetadmin.notice.add_notice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice, addGalleryImage, addEbook, faculty , deleteNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uploadNotice=findViewById(R.id.addNotice);
        uploadNotice.setOnClickListener(this);
        addGalleryImage=findViewById(R.id.addGalleryImage);
        addGalleryImage.setOnClickListener(this);
        addEbook = findViewById(R.id.addEbook);
        addEbook.setOnClickListener(this);
        deleteNotice = findViewById(R.id.deleteNotice);
        deleteNotice.setOnClickListener(this);
        faculty= findViewById(R.id.faculty);
        faculty.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
          if(view.getId()==R.id.addNotice){
                 Intent intent = new Intent(MainActivity.this, add_notice.class);
                 startActivity(intent);
         } else if (view.getId()==R.id.addGalleryImage) {

              Intent intent = new Intent(MainActivity.this, Uploadimage.class);
              startActivity(intent);
          }
          else if(view.getId()==R.id.addEbook){
              Intent intent = new Intent(MainActivity.this, UploadPdfActivity.class);
              startActivity(intent);
          }
          else if(view.getId()==R.id.faculty){
              Intent intent = new Intent(MainActivity.this, UpdateFaculty.class);
              startActivity(intent);
          }
          else if(view.getId()==R.id.deleteNotice){
              Intent intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
              startActivity(intent);
          }



    }
}