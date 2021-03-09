package tk.kuusei.helloworld;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import tk.kuusei.helloworld.day1.Day1Activity;
import tk.kuusei.helloworld.day2.Day2Activity;
import tk.kuusei.helloworld.day3.Day3Activity;
import tk.kuusei.helloworld.day4.Day4Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Day1Activity.class)));
        findViewById(R.id.button2).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Day2Activity.class)));
        findViewById(R.id.button3).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Day3Activity.class)));
        findViewById(R.id.button4).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Day4Activity.class)));
    }
}