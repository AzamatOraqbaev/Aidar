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

public class Category1Activity extends AppCompatActivity {

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
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fapple.png?alt=media&token=47f64f9f-9542-4630-82e8-43fd60b9c556");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fapricot.png?alt=media&token=2330402d-365a-4d91-909e-468074ba7261");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Favocado.png?alt=media&token=20f87cf7-fed8-474e-b2ae-51587528ce18");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fbanan.png?alt=media&token=7e4e6f37-1e0f-41a7-8c80-ed89c34fc7cb");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fcherry.png?alt=media&token=f38eb1ce-1314-4dff-90ce-3c966658cac8");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fgrape.png?alt=media&token=7ddf205b-b9f1-4def-86f0-d2ba02e9a956");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fkiwi.png?alt=media&token=ae343290-f05a-4bbe-8162-32b7d4069023");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Flemon.png?alt=media&token=2fa02489-4a27-4752-8390-b044628437aa");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fmelon.png?alt=media&token=9e40e70d-22ad-4a21-96d3-f43716dfc624");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Forange.png?alt=media&token=1c288f52-5ba7-44a8-bc60-dc91e5a45edb");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpear.png?alt=media&token=219c4ee9-43df-4317-93e7-f64e08ed2683");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpineapple.png?alt=media&token=a38ecfb7-19d4-4a23-8e3a-935930db7792");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpomegranat.png?alt=media&token=7a4a2ed5-805a-496b-adcb-c19a09d93df4");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fraspberries.png?alt=media&token=bea93d6a-0607-4e4f-af18-f4c8b2822a8d");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fstrawberry.png?alt=media&token=f3b72f95-745b-49b0-8299-c507acb09055");
        imageUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fwatermelon.png?alt=media&token=2e26740e-78bb-45c3-a226-ef39b53e6152");
        audioUrls = new ArrayList<>();
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fapple.mp3?alt=media&token=3d4f9393-cba4-408c-ab14-3dd79e400463");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fapricot.mp3?alt=media&token=2078eabf-cf00-4ea8-b931-21eb324c268b");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Favacado.mp3?alt=media&token=e49a6113-3078-484d-9260-c5c31001ce0e");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fbanan.mp3?alt=media&token=e6869f8f-8d43-4b49-8f10-ec19665a79df");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fcherry.mp3?alt=media&token=04a64368-d016-4871-8abe-e57096c815e5");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fgrape.mp3?alt=media&token=80850df2-e390-45df-b89b-c2e18cf60892");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fkiwi.mp3?alt=media&token=74944376-199f-4e37-a07a-59e9fe1ed2a3");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Flemon.mp3?alt=media&token=b797c51c-4997-4e6d-b0aa-ac8d2f5a5eea");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fmelon.mp3?alt=media&token=18e74931-743c-44a0-972a-6a19250fc6ea");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Forange.mp3?alt=media&token=e27de72d-b46f-4ade-9d94-b7e482a90a66");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpear.mp3?alt=media&token=c9e3906e-9cd6-4770-8102-34b65058a27f");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpineapple.mp3?alt=media&token=cdb09093-ae43-43a0-850b-a10383b8251f");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fpomegrand.mp3?alt=media&token=4b8c4b88-74d5-4d25-b4ea-0103424dd555");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fraspberries.mp3?alt=media&token=272d9546-40c1-4f5c-bc00-b20de53512fa");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fstrawberry.mp3?alt=media&token=05a5c3b7-51e0-466e-a771-9af08bace0f3");
        audioUrls.add("https://firebasestorage.googleapis.com/v0/b/aidar3-7119b.appspot.com/o/%D0%B6%D0%B5%D0%BC%D1%96%D1%81%D1%82%D0%B5%D1%80%2Fwatermelon.mp3?alt=media&token=1784306d-8f5d-4815-bcc6-fc66a81ae933");
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
