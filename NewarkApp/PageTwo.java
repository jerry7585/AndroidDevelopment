package com.example.ese343finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ese343finalproject.Newark.binManager;
import com.example.ese343finalproject.Newark.xlsxManager;
import com.example.ese343finalproject.Newark.binManager;
import com.example.ese343finalproject.Newark.xlsxManager;

import java.io.IOException;

public class PageTwo extends AppCompatActivity {

    public final static String lowPriority = "Your issue is not a high priority ";
    public final static String highPriority = "Your issue is more of a high priority ";

    public final static String lowIncomeAndEducation = "and because of the lower average income and education level in your area, response from government assistance may take longer than average.";
    public final static String highIncomeAndEducation = "and because of the higher average income and level of education in your area, you can expect your issue to be resolved quicker than average time.";
    public final static String racePercentLower = " and the Caucasian race percentage of your area is less than the average. This may cause your issue to take longer than average to be resolved.";

    private final String INCOME_STRING = "income";

    public PageTwo() throws IOException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagetwo);

        Intent intent = getIntent();
        String current = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView category = findViewById(R.id.category);
        category.setText(current);

        ImageView imageView = findViewById(R.id.categoryPicture);

        TextView timeText = findViewById(R.id.timeText);
        TextView reasonText = findViewById(R.id.reasonText);

        double minutes = 0.0;
        boolean flag = true;

        switch(current){
            case "Abandoned Properties":
                imageView.setImageResource(R.drawable.abandonedproperty);
                minutes = 24703.26;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);
                break;

            case "Animal Complaints":
                imageView.setImageResource(R.drawable.animalcomplaints);
                minutes = 25324.96;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);
                break;

            case "Business Complaints":
                imageView.setImageResource(R.drawable.businesscomplaints);
                minutes = 20935.68;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);
                break;

            case "Damaged Sidewalks":
                imageView.setImageResource(R.drawable.damagedsidewalks);
                minutes = 27036.21;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(highPriority + racePercentLower);
                break;

            case "Environmental Complaints":
                imageView.setImageResource(R.drawable.environmentalissues);
                minutes = 32700.54;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation + " Your problem has a trend to take a long time to be solved.");
                break;

            case "Fire Code Violation":
                imageView.setImageResource(R.drawable.firecodeviolations);
                minutes = 33031.71;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Graffiti":
                imageView.setImageResource(R.drawable.graffiti);
                minutes = 13350.09;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(highPriority + highIncomeAndEducation);

                break;

            case "Heat Issues":
                imageView.setImageResource(R.drawable.heatissues);
                minutes = 14266.2;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + " but because of the average higher income, education level, and higher Caucasian rates, you can expect your problem to be solved quickly.");
                break;

            case "Home Inspection":
                imageView.setImageResource(R.drawable.homeinspection);
                minutes = 20985.17;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation + " The Caucasian race % in your area will also affect the time causing it to take longer.");

                break;

            case "Illegal Activity":
                imageView.setImageResource(R.drawable.illegalactivity);
                minutes = 6971.25;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(highPriority + highIncomeAndEducation + " The Caucasian rate is also above average: time will take shorter than average to be solved.");

                break;

            case "Illegal Construction":
                imageView.setImageResource(R.drawable.illegalconstruction);
                minutes = 23185.54;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Illegal Dumping":
                imageView.setImageResource(R.drawable.illegaldumping);
                minutes = 182014.5;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Lead Service":
                imageView.setImageResource(R.drawable.leadservice);
                minutes = 23471.5;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Manhole Issues":
                imageView.setImageResource(R.drawable.manholeissues);
                minutes = 58962.05;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Noise Issues":
                imageView.setImageResource(R.drawable.noiseissues);
                minutes = 10704.04;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(highPriority + highIncomeAndEducation);

                break;

            case "Open Hydrant":
                imageView.setImageResource(R.drawable.openhydrant);
                minutes = 47572.89;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + racePercentLower);

                break;

            case "Parking Violation":
                imageView.setImageResource(R.drawable.parkingviolation);
                minutes = 5454.41;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(highPriority + highIncomeAndEducation + " You can expect your problem to be solved within a few business days.");

                break;

            case "Park Structure Issues":
                imageView.setImageResource(R.drawable.parkstructureissues);
                minutes = 142715.2;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Potholes":
                imageView.setImageResource(R.drawable.potholeissues);
                minutes = 5851.46;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(highPriority + highIncomeAndEducation);
                break;

            case "Rodent Infestation":
                imageView.setImageResource(R.drawable.rodentinfestation);
                minutes = 14719.44;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + " but your average income and education level is higher, you can expect the problem to be solved quicker than the average wait time.");

                break;

            case "Sewer Issues":
                imageView.setImageResource(R.drawable.sewerissues);
                minutes = 19617.26;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Street Clean Up":
                imageView.setImageResource(R.drawable.streetcleanup);
                minutes = 252516.8;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Traffic Issues":
                imageView.setImageResource(R.drawable.trafficissues);
                minutes = 36072.19;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Tree Removal":
                imageView.setImageResource(R.drawable.treeremoval);
                minutes = 166066.1;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Water Issues":
                imageView.setImageResource(R.drawable.waterissues);
                minutes = 13982.7;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText(lowPriority + lowIncomeAndEducation);

                break;

            case "Other Issues":
                imageView.setImageResource(R.drawable.otherissues);
                minutes = 94468.2;
                timeText.setText("You can expect your " + current + " problem to take roughly " + Math.floor(minutes/24/60) + " days, " + Math.floor(minutes/60%24) + " hours, and " + Math.floor(minutes%60) + " minutes to be resolved");
                reasonText.setText("Your issue is not listed above, but if you are reporting from an area with higher average income, level of education, and Caucasian race %, your issue will be resolved quicker than the average time.");

                break;

            default:
                System.out.println("No category found");
                break;
        }
    }

    public void returnToMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

