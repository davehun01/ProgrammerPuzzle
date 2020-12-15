package com.example.dave.programmerpuzzle.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dave.programmerpuzzle.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HowToPlayActivity extends AppCompatActivity {

    @BindView(R.id.howToPlayActivity_Text1)
    TextView text1;
    @BindView(R.id.howToPlayActivity_Text2)
    TextView text2;
    @BindView(R.id.howToPlayActivity_Text3)
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDesign();
    }

    private void activityDesign() {
        setContentView(R.layout.activity_how_to_play);

        ButterKnife.bind(this);

        getWindow().setStatusBarColor(getResources().getColor(R.color.colorDarkBlue));

        setTexts();
    }

    private void setTexts() {
        text1.setText(R.string.howToPlayActivity_Text1);
        text2.setText(R.string.howToPlayActivity_Text2);
        text3.setText(R.string.howToPlayActivity_Text3);
    }
}
