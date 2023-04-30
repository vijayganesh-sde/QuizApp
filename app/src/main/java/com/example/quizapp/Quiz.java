package com.example.quizapp;

import java.util.ArrayList;

import java.util.Collections;

public class Quiz {
    public ArrayList<Question> mQuestions;
    public int mCurrentQuestionIndex;

    public Quiz(ArrayList<Question> questions) {
        mQuestions = questions;
        mCurrentQuestionIndex = 0;
    }

    public Question getCurrentQuestion() {
        return mQuestions.get(mCurrentQuestionIndex);
    }

    public void moveToNextQuestion() {
        mCurrentQuestionIndex++;
    }

    public boolean isLastQuestion() {
        return mCurrentQuestionIndex == mQuestions.size() - 1;
    }
    public ArrayList<Question> getQuestions() {
        return mQuestions;
    }
    public void resetQuiz() {
        mCurrentQuestionIndex = 0;

        Collections.shuffle(mQuestions);
    }

    public int getScore() {
        int sc = 0;
        for (Question question : mQuestions) {
            if (question.getCorrectOption().equals(question.getCorrectOption())) {
                sc++;
            }
        }
        return sc;
    }
}
