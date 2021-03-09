package tk.kuusei.helloworld.day1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import tk.kuusei.helloworld.R;

public class Day1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1);

        findViewById(R.id.day1_back).setOnClickListener(v -> onBackPressed());

    }
}