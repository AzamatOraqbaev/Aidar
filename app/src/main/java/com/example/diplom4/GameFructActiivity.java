package com.example.diplom4;

import android.app.AlertDialog;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameFructActiivity extends AppCompatActivity{

    private List<ImageSoundPair> imageSoundPairs;
    private int currentPairIndex;
    private MediaPlayer mediaPlayer;
    private int correctAnswers;

    private List<ImageButton> imageButtons;
    private ImageView soundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Инициализация массива с парами изображений и звуков
        imageSoundPairs = new ArrayList<>();
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a0,R.raw.v0));
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a1, R.raw.v1));
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a2, R.raw.v2));
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a3, R.raw.v3));
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a4, R.raw.v4));
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a5, R.raw.v5));
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a6, R.raw.v6));
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a7, R.raw.v7));
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a8, R.raw.v8));
        imageSoundPairs.add(new ImageSoundPair(R.drawable.a9, R.raw.v9));

        // Добавьте другие пары изображений и звуков

        // Перемешиваем список пар
        Collections.shuffle(imageSoundPairs);

        currentPairIndex = 0;
        correctAnswers = 0;

        // Настраиваем обработчики для кнопок
        imageButtons = new ArrayList<>();
        imageButtons.add((ImageButton) findViewById(R.id.imageButton1));
        imageButtons.add((ImageButton) findViewById(R.id.imageButton2));
        imageButtons.add((ImageButton) findViewById(R.id.imageButton3));
        imageButtons.add((ImageButton) findViewById(R.id.imageButton4));

        // Настраиваем обработчик для soundImageView
        soundImageView = findViewById(R.id.soundImageView);
        soundImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playCurrentSound();
            }
        });

        loadNextPair();
    }

    private void loadNextPair() {
        if (currentPairIndex < imageSoundPairs.size()) {
            // Reset background color of all image buttons to transparent
            for (ImageButton button : imageButtons) {
                button.setBackgroundColor(Color.TRANSPARENT);
            }

            ImageSoundPair currentPair = imageSoundPairs.get(currentPairIndex);

            // Создаем список всех вариантов ответа, включая правильный ответ
            List<ImageSoundPair> allPairs = new ArrayList<>(imageSoundPairs);
            Collections.shuffle(allPairs);

            // Извлекаем первые четыре уникальных варианта ответа
            List<ImageSoundPair> answerOptions = new ArrayList<>();
            answerOptions.add(currentPair); // Добавляем правильный ответ
            for (ImageSoundPair pair : allPairs) {
                if (!pair.equals(currentPair) && !answerOptions.contains(pair)) {
                    answerOptions.add(pair);
                    if (answerOptions.size() >= 4) {
                        break;
                    }
                }
            }

            // Перемешиваем варианты ответа
            Collections.shuffle(answerOptions);

            // Устанавливаем изображения на кнопки
            for (int i = 0; i < 4; i++) {
                ImageButton button = imageButtons.get(i);
                ImageSoundPair pair = answerOptions.get(i);
                button.setImageResource(pair.getImageResourceId());
                button.setTag(pair);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkAnswer((ImageButton) v);
                    }
                });
            }

            // Проигрываем звук текущей пары
            playCurrentSound(currentPair);

            currentPairIndex++;
        } else {
            // Все пары пройдены, показываем результаты
            showResults();
        }
    }

    private void playCurrentSound(ImageSoundPair pair) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        mediaPlayer = MediaPlayer.create(this, pair.getSoundResourceId());
        mediaPlayer.start();
    }

    private void playCurrentSound() {
        if (currentPairIndex > 0 && currentPairIndex <= imageSoundPairs.size()) {
            ImageSoundPair currentPair = imageSoundPairs.get(currentPairIndex - 1);
            playCurrentSound(currentPair);
        }
    }

    private void checkAnswer(ImageButton clickedButton) {
        ImageSoundPair currentPair = imageSoundPairs.get(currentPairIndex - 1);
        ImageButton correctButton = null;

        for (ImageButton button : imageButtons) {
            if (((ImageSoundPair) button.getTag()).getImageResourceId() == currentPair.getImageResourceId()) {
                correctButton = button;
                break;
            }
        }

        if (clickedButton == correctButton) {
            correctAnswers++;
            clickedButton.setBackgroundColor(Color.GREEN);
        } else {
            clickedButton.setBackgroundColor(Color.RED);
            if (correctButton != null) {
                correctButton.setBackgroundColor(Color.GREEN);
            }
        }

        // Останавливаем воспроизведение звука
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadNextPair();
            }
        }, 100); // увеличиваем задержку до 1000 мс для видимости цвета ответа
    }

    private void showResults() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_game_results, null);
        builder.setView(dialogView);

        TextView textViewResults = dialogView.findViewById(R.id.textViewResults);
        TextView textViewScore = dialogView.findViewById(R.id.textViewScore);
        Button buttonRestart = dialogView.findViewById(R.id.buttonRestart);
        Button buttonExit = dialogView.findViewById(R.id.buttonExit);

        textViewResults.setText("Нәтижелер");
        textViewScore.setText("Дұрыс жауаптар саны: " + correctAnswers);

        AlertDialog dialog = builder.create();
        dialog.show();

        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
                dialog.dismiss();
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void restartGame() {
        currentPairIndex = 0;
        correctAnswers = 0;
        Collections.shuffle(imageSoundPairs);
        loadNextPair();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Освобождаем ресурсы при остановке активити
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

