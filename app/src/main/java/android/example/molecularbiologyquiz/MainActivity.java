package android.example.molecularbiologyquiz;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Global variable for keeping track of score
    double score = 0;
    int numberOfQuestions = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Final submit for quiz
     *
     * @param view no parameters
     */
    public void submitQuiz(View view) {
        //Obtain contestant's name
        EditText getName = (EditText) findViewById(R.id.Name);
        String contestantName = getName.getText().toString();
        //Declaring Carbs check and set bool to true
        CheckBox Carbs = findViewById(R.id.Check1);
        boolean carbohydrates = Carbs.isChecked();
        //Declaring lips and set bool to true
        CheckBox lips = findViewById(R.id.Check2);
        boolean lipids = lips.isChecked();
        //Proteins declared and set to true
        CheckBox pro = findViewById(R.id.Check3);
        boolean proteins = pro.isChecked();
        //Nucleic acid set to true
        CheckBox center = findViewById(R.id.Check4);
        boolean nucleicAcid = center.isChecked();
        double grade = ((calculateCheckBoxes(carbohydrates, lipids, proteins, nucleicAcid) + checkAnswer1() + checkAnswer4() + score) / 5) * 100;
        Toast.makeText(this, "Your grade is " + grade + "%", Toast.LENGTH_LONG).show();
        displayResults(createQuizSummary(contestantName));

    }

    /**
     * Obtain question 1 answer from user
     *
     * @return question 1 input
     */
    private String getAnswer1() {
        //Question 1 EditText
        EditText Q1 = (EditText) findViewById(R.id.Q1Answer);
        String question1 = Q1.getText().toString();
        return question1;
    }

    /**
     * Check to see if question 1 answer is correct
     *
     * @return the score if the answer was corrected
     */
    private double checkAnswer1() {
        String answer1 = getAnswer1();
        double question1 = 0;
        if (answer1.equalsIgnoreCase("central dogma")) {
            question1 += 1;
        }
        return question1;
    }

    /**
     * Obtain question 4 answer from user
     *
     * @return question 1 input
     */
    private String getAnswer4() {
        //Question 1 EditText
        EditText Q4 = (EditText) findViewById(R.id.Q4Answer);
        String question4 = Q4.getText().toString();
        return question4;
    }

    /**
     * Check to see if question 4 answer is correct
     *
     * @return the score if the answer was corrected
     */
    private double checkAnswer4() {
        String answer4 = getAnswer4();
        double question4 = 0;
        if (answer4.equalsIgnoreCase("nucleus")) {
            question4 += 1;
        }
        return question4;
    }

    /**
     * Calculate the scores from question 2 using break conditions
     *
     * @param view no parameters
     */
    public void RadioGroup1(View view) {
        //Is the button now check?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch (view.getId()) {
            case R.id.DNA:
                if (checked)
                    score = score + 1;
                break;
            case R.id.Lysosome:
                if (checked)
                    break;
            case R.id.Proteins:
                if (checked)
                    break;
            case R.id.RNA:
                if (checked)
                    break;
        }
    }

    /**
     * Calculate the scores from question 4 using break conditions
     *
     * @param view no parameters
     */
    public void RadioGroup2(View view) {
        //Is the button now check?
        boolean checked = ((RadioButton) view).isChecked();

        //Check which radio button was clicked
        switch (view.getId()) {
            case R.id.K_Mullis:
                if (checked)
                    score = score + 1;
                break;
            case R.id.D_Baltimore:
                if (checked)
                    break;
                break;
            case R.id.R_Weinberg:
                if (checked)
                    break;
            case R.id.J_Nash:
                if (checked)
                    break;
        }
    }

    /**
     * Calculate the score for question 3
     *
     * @param carbohydrates boolean
     * @param lipids        boolean
     * @param proteins      boolean
     * @param nucleicAcid   boolean
     * @return checkBoxScores
     */
    public double calculateCheckBoxes(boolean carbohydrates, boolean lipids, boolean proteins, boolean nucleicAcid) {
        double checkBoxScores = 0;
        if (carbohydrates) {
            checkBoxScores = checkBoxScores + 0.25;
        }
        if (lipids) {
            checkBoxScores = checkBoxScores + 0.25;
        }
        if (proteins) {
            checkBoxScores = checkBoxScores + 0.25;
        }
        if (nucleicAcid) {
            checkBoxScores = checkBoxScores + 0.25;
        }
        return checkBoxScores;
    }

    /**
     * Method to display the answers to the screen
     *
     * @param summary String
     */
    public void displayResults(String summary) {
        TextView resultsView = (TextView) findViewById(R.id.Results);
        resultsView.setText(String.valueOf(summary));
    }

    /**
     * @param contestantName User's name as a String
     * @return answers to questions in String
     */

    private String createQuizSummary(String contestantName) {
        String summary = "Name: " + contestantName;
        summary += "\nQuestion 1: Central dogma";
        summary += "\nQuestion 2: DNA";
        summary += "\nQuestion 3: All choices";
        summary += "\nQuestion 4: Nucleus";
        summary += "\nQuestion 5: Kary Mullus";
        return summary;
    }
}
