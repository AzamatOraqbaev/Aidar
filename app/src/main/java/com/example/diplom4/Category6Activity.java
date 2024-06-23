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

public class Category6Activity extends AppCompatActivity {

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
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fblue.png?alt=media&token=ff060c1e-4eed-4a89-bda1-7b45e2df3939");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fblack.png?alt=media&token=dff854e8-e275-4f14-80fb-012aebfa0a1b");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fbrown.png?alt=media&token=70b46da5-5eff-405c-bc9c-0098411b6b6f");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fgreen.png?alt=media&token=f86ae965-13e0-4d1a-8ee2-84dd2b019769");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Forange.png?alt=media&token=6826274b-71e0-4011-bdb4-54a89f084c19");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fpink.png?alt=media&token=d70837bf-ca5a-42ab-982f-6b11bdca6273");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fwhite.png?alt=media&token=63171b81-0c63-4e0d-b4ef-d3a9c769f5e8");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fyellow.png?alt=media&token=a788bd5e-b601-4944-8234-0898ca11e224");

        audioUrls = new ArrayList<>();
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fblue.mp3?alt=media&token=e8b0b764-bf2a-41c1-ad2f-d010706f294f");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fblack.mp3?alt=media&token=d765f6ac-599a-4333-a2fe-59409de827ae");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fbrown.mp3?alt=media&token=6f473a97-dacd-43ed-903c-cc733d07c36a");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fgreen.mp3?alt=media&token=4b89c165-ab61-424f-8c54-100db1fd4d6b");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Forange.mp3?alt=media&token=25f3f30e-aaf5-4b3a-a2c0-9a7186c322e4");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fpink.mp3?alt=media&token=fe97c311-9688-4206-873c-808351225b87");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fwhite.mp3?alt=media&token=ed1b38d9-fca2-4fdb-bcf6-bc2ee11fecd2");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D1%82%D2%AF%D1%81%D1%82%D0%B5%D1%80%2Fyellow.mp3?alt=media&token=7c26fef3-d16f-4eb6-82c9-9e3f4507c3f5");
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
