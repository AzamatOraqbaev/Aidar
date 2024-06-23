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

public class Category3Activity extends AppCompatActivity {

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
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fbro.jpeg?alt=media&token=1dbdf906-31d2-4b7d-891d-f4551f3812c9");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fdad.jpeg?alt=media&token=a836bc92-82ba-4421-aad5-9793016ed72a");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fgrandfat.jpeg?alt=media&token=abd06b7b-3e22-4c93-8c44-ca701468db2f");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fgrandmom.jpeg?alt=media&token=ba0359f3-d368-475c-a2c7-e700e5171dd6");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Flitlebro.jpeg?alt=media&token=7956a789-8a29-4088-9a56-b642991954b4");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Flitlesis.jpeg?alt=media&token=7d953a80-f057-4c26-8777-c92d51057393");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fmam.jpeg?alt=media&token=86dffd7e-b09b-47f9-9da0-f4f416a34454");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fsis.jpeg?alt=media&token=b9e8f968-5bbe-4f71-ba56-ca9c6b47aa96");
        audioUrls = new ArrayList<>();
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fbrother.mp3?alt=media&token=c748cf99-92f9-4653-a256-5ce9f472771b");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Ffather.mp3?alt=media&token=939c216e-f288-46cb-8622-dc9c905bedee");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fgrandfather.mp3?alt=media&token=323c6010-652b-40ec-b833-a417e41a4441");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fgrandmother.mp3?alt=media&token=b4cf32ec-381a-428e-95ce-480602b66d44");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Flitlebro.mp3?alt=media&token=371d8d96-442f-4504-b238-6478733abc6c");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Flitlesis.mp3?alt=media&token=a930f944-31b9-4ebf-ade5-c93dae656ab6");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fmother.mp3?alt=media&token=f32864c4-62c3-4f75-9a6e-11dea12034c4");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%BE%D1%82%D0%B1%D0%B0%D1%81%D1%8B%2Fsister.mp3?alt=media&token=2cedf4db-65f2-49ed-ac2c-f689e64fd6eb");

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
