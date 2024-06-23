package com.example.diplom4;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Category5Activity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private String category;
    private FirebaseStorage storage;
    private List<String> imageUrls;
    private List<String> audioUrls;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category1);

        category = getIntent().getStringExtra("category");
        TextView categoryTitle = findViewById(R.id.categoryTitle);
        categoryTitle.setText(category);

        viewPager = findViewById(R.id.viewPager);
        storage = FirebaseStorage.getInstance();

        getImageAndAudioUrlsForCategory2();

        ImageButton soundButton = findViewById(R.id.soundButton);
        soundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSoundForCategory();
            }
        });
    }

    private void playSoundForCategory() {
        int currentPosition = viewPager.getCurrentItem();
        if (currentPosition >= 0 && currentPosition < audioUrls.size()) {
            String audioUrl = audioUrls.get(currentPosition);
            playAudio(audioUrl);
        }
    }

    private void playAudio(String audioUrl) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(audioUrl);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getImageAndAudioUrlsForCategory2() {
        imageUrls = new ArrayList<>();
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fbellpepper.png?alt=media&token=4d74f5cc-297c-4941-84b6-f9d2274ecafe");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fcarrot.png?alt=media&token=bd16c852-e26f-47d8-9d64-81866ee29e3b");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fcorn.png?alt=media&token=71ef43f1-4843-413f-99b1-904e99bdc9e5");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fcucumber.png?alt=media&token=5c32088b-3d66-4b01-9005-4f1b0a7f6b5b");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fgarlic.png?alt=media&token=3ec553d1-ec39-436b-a373-1bd960e627da");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Flettuceleaves.png?alt=media&token=a033016c-a337-46cd-b059-0924b97cf10e");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fonion.png?alt=media&token=62c0ca4d-3163-45df-bc96-9722657428d9");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpotato.png?alt=media&token=8ec4f5e8-e889-4ccd-a497-c286562807d4");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpumpkin.png?alt=media&token=49d1bcd3-4340-45e6-afe1-a79bdd0f7c47");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Ftomato.png?alt=media&token=57e694b7-ba1e-4184-9aba-6cbb2429e83a");

        audioUrls = new ArrayList<>();
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fbellpeper.mp3?alt=media&token=e83635a4-a860-49b9-89a1-df9fe2051db6");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fcarrot.mp3?alt=media&token=2d8086e2-21a7-431d-ba09-77c7de5af366");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fcorn.mp3?alt=media&token=de0a494e-88cb-4a56-a4d4-61402e2bab5c");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fcucumber.mp3?alt=media&token=a66d707c-b844-463f-af2a-1887c5700d29");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fgarlic.mp3?alt=media&token=d2f16c63-0184-4010-9baa-5c08ea21b814");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Flettuceleaves.mp3?alt=media&token=18f8c0e9-3c99-4c36-a09f-c08c509d5576");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fonion.mp3?alt=media&token=823c5f83-cd4e-43a5-aa53-31faa6b66839");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpotato.mp3?alt=media&token=3413a42b-2de5-4c44-bd58-7d3dbfbde481");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpumpkin.mp3?alt=media&token=ee98db94-94a1-453f-a4c7-a1055522c468");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D2%9B%D3%A9%D2%9B%D3%A9%D0%BD%D1%96%D1%81%D1%82%D0%B5%D1%80%2Ftomato.mp3?alt=media&token=690b79a0-5b8e-4d82-9d8f-e020df5dfc22");

        ImageAdapter imageAdapter = new ImageAdapter(this, imageUrls);
        viewPager.setAdapter(imageAdapter);
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
