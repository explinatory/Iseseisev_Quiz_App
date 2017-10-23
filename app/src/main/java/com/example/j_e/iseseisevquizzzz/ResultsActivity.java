package com.example.j_e.iseseisevquizzzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView mGrade, mFinalScore;
    Button mRetryButton;

    public void seeAnswers(View view)
    {
        Intent lol = new Intent (this, AnswersActivity.class);
        startActivity(lol);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mGrade = (TextView)findViewById(R.id.grade);
        mFinalScore = (TextView)findViewById(R.id.outOf);
        mRetryButton = (Button)findViewById(R.id.retry);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        mFinalScore.setText("You scored "+ score + " out of " + QuizBook.questions.length);

        if (score == 9)
        {
            mGrade.setText("Pretty gud'");
        }
        if (score == 8)
        {
            mGrade.setText("Noice'");
        }
        if (score == 7)
        {
            mGrade.setText("Eh, good enough.");
        }
        if (score <= 6)
        {
            mGrade.setText("You need more IQ points.");
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, QuizActivity.class));
                ResultsActivity.this.finish();
            }
        });
    }
}
