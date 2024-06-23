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

public class Category4Activity extends AppCompatActivity {

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
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fbear.png?alt=media&token=53ffa4b8-7017-441b-b6f2-9f4c99f2a525");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fcat.png?alt=media&token=8a918ad5-7839-4698-b21c-eaab36a3711d");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fcow.png?alt=media&token=50f81c1d-3c7f-45db-8b25-ac6a13bab30d");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fdeer.png?alt=media&token=385758a5-801b-4142-82db-f0faf5ed3ef5");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fdog.png?alt=media&token=227ede0e-c706-492b-a826-9ef8a396c132");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Felephant.png?alt=media&token=af2cb859-da92-49d1-8949-7e9408f1860c");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Ffox.png?alt=media&token=3bd72394-174a-4219-bdc7-8f0af671ccfa");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fgiraffe.png?alt=media&token=8a3e9a59-f1dd-4c28-80d8-293e789ab268");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fhorse.png?alt=media&token=1a460310-a151-4a8e-877d-fbf3b9d220c4");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Flion.png?alt=media&token=d5baf70e-7fd4-46ae-9abd-953ad165cdad");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fmonkey.png?alt=media&token=8b7b8ded-69c5-42fe-9ec3-b41afa59217e");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Frabbit.png?alt=media&token=45b7bef6-8471-433b-93c1-e44b49f8f154");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fsheep.png?alt=media&token=e82a27ae-cc6b-4dad-95fc-bfb5bcb42dc8");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fsnake.png?alt=media&token=eab34f57-9552-4a84-8b47-270f885d4a88");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Ftiger.png?alt=media&token=d7919e60-af97-4247-926b-7f97a6398f2f");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fturtle.png?alt=media&token=850deab9-bb9c-43de-b64f-f3018db49fdd");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fwhitebear.png?alt=media&token=d3c6dde9-9ecb-483c-ba2e-7e8fa37cf733");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fzebra.png?alt=media&token=15c5b8c1-882a-42de-b1dd-b30395bdd2ca");

        audioUrls = new ArrayList<>();
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fbear.mp3?alt=media&token=b111377b-8964-4bad-acc4-fb4e72c253bc");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fcat.mp3?alt=media&token=94dfe02c-4eed-48b0-8bbc-5718190e9bf4");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fcow.mp3?alt=media&token=fe5f4da4-395e-496b-8154-62f304f58d8f");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fdeer.mp3?alt=media&token=b456804a-0de2-4f29-9b6f-731cfdbfe70c");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fdog.mp3?alt=media&token=976690f3-ff6c-43c0-a862-dedc8382983d");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Felephant.mp3?alt=media&token=b7fd35fe-89b0-4c41-9b93-a973c26d11aa");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Ffox.mp3?alt=media&token=bcf0aa5d-f271-4387-a035-26e8048d57f7");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fgiraffe.mp3?alt=media&token=29be8682-805e-4b24-b5b1-119d7be187bb");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fhorse.mp3?alt=media&token=36b0bcb5-bb0e-4037-9a52-e81eec9e9961");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Flion.mp3?alt=media&token=23b33abb-b1d0-41f8-975e-c84a9c6deff5");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fmonkey.mp3?alt=media&token=a3e47a8b-9552-4abc-b484-842cb31fecf6");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Frabbit.mp3?alt=media&token=2ead53a1-8180-4774-802a-fa0464401bb4");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fsheep.mp3?alt=media&token=d03f01c3-6553-4c16-bcd8-87c3f83ccbf6");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fsnake.mp3?alt=media&token=28e5398f-5ea6-496a-b3ad-6114bad02aaf");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Ftiger.mp3?alt=media&token=d1a1d445-5d0f-4190-8c53-27e0367d4869");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fturtle.mp3?alt=media&token=0f99abaa-fd5f-424e-8d41-887a7a756898");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fwhitebear.mp3?alt=media&token=a5036974-1ef4-4ee2-acb0-719216513059");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B0%D0%BD%D1%83%D0%B0%D1%80%D0%BB%D0%B0%D1%80%2Fzebra.mp3?alt=media&token=bed29271-4bde-45de-9943-0781bb1b98c3");
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
