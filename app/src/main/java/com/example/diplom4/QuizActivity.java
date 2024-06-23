package com.example.diplom4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.diplom4.databinding.ActivityQuizBinding;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private ActivityQuizBinding binding;
    private Word2VecModel word2VecModel;
    private String correctAnswer;
    private int roundCount = 0;
    private int correctAnswersCount = 0;
    private static final int MAX_ROUNDS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Load the Word2Vec model from the assets folder
        word2VecModel = new Word2VecModel();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("word2vec_model.txt")));
            word2VecModel.loadModel(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up button click listeners
        binding.option1Button.setOnClickListener(this::checkAnswer);
        binding.option2Button.setOnClickListener(this::checkAnswer);
        binding.option3Button.setOnClickListener(this::checkAnswer);
        binding.option4Button.setOnClickListener(this::checkAnswer);

        // Generate the first quiz question
        generateQuiz();
    }

    private void generateQuiz() {
        if (roundCount >= MAX_ROUNDS) {
            endGame();
            return;
        }

        String hiddenWord = getRandomWord();
        List<String> options = generateQuizOptions(hiddenWord);

        // Устанавливаем текст вопроса
        binding.questionTextView.setText("Қай сөз ең жақын: " + hiddenWord + "?");

        // Перемешиваем варианты ответа
        Collections.shuffle(options);

        // Устанавливаем правильный ответ
        correctAnswer = options.get(options.indexOf(word2VecModel.getNearestWords(hiddenWord, 1).get(0)));

        binding.option1Button.setText(options.get(0));
        binding.option2Button.setText(options.get(1));
        binding.option3Button.setText(options.get(2));
        binding.option4Button.setText(options.get(3));

        roundCount++;
    }

    private List<String> generateQuizOptions(String hiddenWord) {
        // Получаем ближайшие слова, включая правильный ответ
        List<String> nearestWords = word2VecModel.getNearestWords(hiddenWord, 4);
        if (nearestWords.isEmpty()) {
            nearestWords.add(hiddenWord); // Добавляем скрытое слово, если ближайшие слова не найдены
        }

        // Удаляем скрытое слово из списка (если оно присутствует)
        nearestWords.remove(hiddenWord);

        // Если ближайших слов меньше 3, добавляем случайные слова до размера 3
        while (nearestWords.size() < 3) {
            String randomWord = getRandomWord();
            if (!nearestWords.contains(randomWord) && !randomWord.equals(hiddenWord)) {
                nearestWords.add(randomWord);
            }
        }

        // Добавляем правильный ответ как первое ближайшее слово
        String closestWord = word2VecModel.getNearestWords(hiddenWord, 1).get(0);
        nearestWords.add(closestWord);

        // Перемешиваем варианты ответа
        Collections.shuffle(nearestWords);

        return nearestWords;
    }

    private void checkAnswer(View view) {
        Button selectedButton = (Button) view;
        String selectedOption = selectedButton.getText().toString();

        if (selectedOption.equals(correctAnswer)) {
            correctAnswersCount++;
            selectedButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        } else {
            selectedButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        }

        binding.option1Button.postDelayed(() -> {
            binding.option1Button.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            binding.option2Button.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            binding.option3Button.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            binding.option4Button.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
            generateQuiz();
        }, 1000);
    }

    private String getRandomWord() {
        List<String> vocabulary = new ArrayList<>(word2VecModel.getVocabulary());
        Random random = new Random();
        return vocabulary.get(random.nextInt(vocabulary.size()));
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_game_results, null);
        builder.setView(dialogView);

        TextView textViewResults = dialogView.findViewById(R.id.textViewResults);
        TextView textViewScore = dialogView.findViewById(R.id.textViewScore);
        Button buttonRestart = dialogView.findViewById(R.id.buttonRestart);
        Button buttonExit = dialogView.findViewById(R.id.buttonExit);

        textViewResults.setText("Нәтижелер");
        textViewScore.setText("Дұрыс жауаптар саны: " + correctAnswersCount);

        AlertDialog dialog = builder.create();
        dialog.show();

        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
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

    private void resetGame() {
        roundCount = 0;
        correctAnswersCount = 0;
        generateQuiz();
    }
}
