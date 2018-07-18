package info.leon.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;

    private Question[] questionBank = new Question[]{
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_australia,true)
    };
    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.b_true_button);
        falseButton = findViewById(R.id.b_false_button);
        questionTextView = findViewById(R.id.question_text_view);
        nextButton = findViewById(R.id.b_next_button);

        updateQuestion();
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnsver(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnsver(false);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % questionBank.length;
                updateQuestion();
            }
        });

        questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % questionBank.length;
                updateQuestion();
            }
        });

    }
    private void updateQuestion() {
        int question = questionBank[currentIndex].getTextResID();
        questionTextView.setText(question);
    }

    private void checkAnsver(boolean userPressedTrue){
        boolean answerIsTrue = questionBank[currentIndex].isAnswerTrue();

        int messageResID = 0;

        if(userPressedTrue == answerIsTrue){
            messageResID = R.string.correct_toast;
        }else {
            messageResID = R.string.incorrect_toast;
        }

        Toast.makeText(getApplicationContext(),messageResID,Toast.LENGTH_SHORT).show();
    }
}
