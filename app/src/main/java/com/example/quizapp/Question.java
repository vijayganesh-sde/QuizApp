package com.example.quizapp;

import android.os.Bundle;
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
public class Question {
    private String mQuestionText;
    private String mOptionA;
    private String mOptionB;
    private String mOptionC;
    private String mOptionD;
    private String mCorrectOption;

    public Question(String questionText, String optionA, String optionB, String optionC, String optionD, String correctOption) {
        mQuestionText = questionText;
        mOptionA = optionA;
        mOptionB = optionB;
        mOptionC = optionC;
        mOptionD = optionD;
        mCorrectOption = correctOption;
    }

    public String getQuestionText() {
        return mQuestionText;
    }

    public String getOptionA() {
        return mOptionA;
    }

    public String getOptionB() {
        return mOptionB;
    }

    public String getOptionC() {
        return mOptionC;
    }

    public String getOptionD() {
        return mOptionD;
    }

    public String getCorrectOption() {
        return mCorrectOption;
    }
}

