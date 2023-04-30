package com.example.quizapp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.quizapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import com.example.quizapp.Quiz;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mQuestionText;
    private RadioGroup mOptionsGroup;
    private RadioButton mOptionA;
    private RadioButton mOptionB;
    private RadioButton mOptionC;
    private RadioButton mOptionD;
    private Button mSubmitButton;

    private int mQuestionIndex = 0;
    public Question[] mQuestions = {
            new Question("Who is the TOP G?", "LANA", "MK", "SASHA", "ANDREW TATE", "ANDREW TATE"),
            new Question("What car does the TOP G have?", "GIRL'S CAR", "GTR", "NANO", "BUGATTI", "BUGATTI"),
            new Question("What color is his Bugatti?", "PINK", "BLACK", "RED", "MAROON", "MAROON"),
            new Question("What is the currency of Japan?", "Yen", "Dollar", "Pound", "Euro", "Yen"),
            new Question("What is the tallest animal on earth?", "Giraffe", "Elephant", "Hippopotamus", "Rhino", "Giraffe"),
            new Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"),
            new Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"),
            new Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"),
            new Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"),
            new Question("What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris"),

    };
    Question[] questionsArray = new Question[10]; // assume the array has already been populated
    List<Question> questionsList = Arrays.asList(questionsArray);
    ArrayList<Question> questionsArrayList = new ArrayList<>(questionsList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionText = findViewById(R.id.question_text);
        mOptionsGroup = findViewById(R.id.options_group);
        mOptionA = findViewById(R.id.option_a);
        mOptionB = findViewById(R.id.option_b);
        mOptionC = findViewById(R.id.option_c);
        mOptionD = findViewById(R.id.option_d);
        mSubmitButton = findViewById(R.id.submit_button);

        showQuestion();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void showQuestion() {
        mQuestionText.setText(mQuestions[mQuestionIndex].getQuestionText());
        mOptionA.setText(mQuestions[mQuestionIndex].getOptionA());
        mOptionB.setText(mQuestions[mQuestionIndex].getOptionB());
        mOptionC.setText(mQuestions[mQuestionIndex].getOptionC());
        mOptionD.setText(mQuestions[mQuestionIndex].getOptionD());
        if(mQuestionIndex==mQuestions.length-1){
            mSubmitButton.setText("SUBMIT");
        }
    }
    static int score=0;
    public void restart(){
        mQuestionIndex=0;
        mSubmitButton.setText("NEXT");
        showQuestion();
    }
    private void checkAnswer() {
        int selectedOptionId = mOptionsGroup.getCheckedRadioButtonId();
        if (selectedOptionId == -1) {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedOption = findViewById(selectedOptionId);
        String selectedOptionText = selectedOption.getText().toString();
        String correctOptionText = mQuestions[mQuestionIndex].getCorrectOption();

        if (selectedOptionText.equals(correctOptionText)) {
            score++;
        }
        mOptionsGroup.clearCheck();
        mQuestionIndex++;
        if (mQuestionIndex < mQuestions.length) {
            showQuestion();
        } else {
            Toast.makeText(this, "Quiz completed!", Toast.LENGTH_SHORT).show();
            // After the last question is answered, calculate the score and display it in a dialog bo
            int totalQuestions = mQuestions.length;
            double percentage = ((double)score / totalQuestions) * 100;
            // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

// 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage("You scored " + score + " out of " + totalQuestions + " (" + percentage + "%)")
                    .setTitle("RESULTS!!");

// 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>


            builder.setPositiveButton("Click to Restart Quiz", (DialogInterface.OnClickListener) (dialog1, which) -> {
                restart();


            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }

    private Context getActivity() {
        return this;
    }
}
