package com.example.diplom4;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Category2Activity extends AppCompatActivity {

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

        // Инициализация MediaPlayer
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.reset();
            }
        });
    }

    private void playSoundForCategory() {
        int currentPosition = viewPager.getCurrentItem();
        if (currentPosition >= 0 && currentPosition < audioUrls.size()) {
            String audioUrl = audioUrls.get(currentPosition);

            try {
                mediaPlayer.reset();
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
                Toast.makeText(this, "Ошибка воспроизведения звука", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getImageAndAudioUrlsForCategory2() {
        imageUrls = new ArrayList<>();
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F0.png?alt=media&token=2c4b4d34-46cb-4f5e-9c8a-ccfb54cf89d0");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F1.png?alt=media&token=89fafa33-4143-4fa3-b2f5-87f47bd73ffd");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F2.png?alt=media&token=7f43fc12-dc05-4c34-996a-2fae74e38b9b");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F3.png?alt=media&token=74563678-3f62-458f-b70c-930fc89a9534");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F4.png?alt=media&token=eb18f63f-b1d5-4215-bb1c-f146534df43c");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F5.png?alt=media&token=e92f59d7-d81a-44df-a1ce-e9bd404ff60c");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F6.png?alt=media&token=212ae269-aea6-44b7-a24b-eae11e4c353c");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F7.png?alt=media&token=d0b1332c-9e68-4abc-8f86-8f187d263091");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F8.png?alt=media&token=3bedb777-2943-4299-903c-2811cd2e61ea");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F9.png?alt=media&token=a58d96c3-d580-4bb7-8866-c897c2ac2cd2");


        audioUrls = new ArrayList<>();
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F0.mp3?alt=media&token=672b2fe1-ed51-409b-b5a4-5b5a5ab3c759");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F1.mp3?alt=media&token=ea297d44-cf17-4db5-b3c8-d72325f69158");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F2.mp3?alt=media&token=f5614bdb-893d-4639-9200-08158899ba02");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F3.mp3?alt=media&token=24a54b5f-5fe8-4c57-a11c-984c61d802ba");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F4.mp3?alt=media&token=82294379-1456-48e3-b398-f606a2d9f29f");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F5.mp3?alt=media&token=d0862ed0-7050-46b4-9410-0bc71209140c");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F6.mp3?alt=media&token=880272d4-e8a8-404a-8eaf-e1d15bb85cc8");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F7.mp3?alt=media&token=5ee7fff7-b580-4344-b815-5454d78e68a7");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F8.mp3?alt=media&token=f1d7d878-fd42-4a38-8a45-428d5dc4e2b5");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%81%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%2F9.mp3?alt=media&token=c6b59a1a-2585-4435-9a79-d3431b792586");


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
