package tk.kuusei.helloworld.day3;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tk.kuusei.helloworld.R;

public class Day3Activity extends AppCompatActivity {

    private final String[] title = new String[]{
            "香菱",
            "胡桃",
            "钟离",
    };
    private final int[] img = new int[]{
            R.drawable.day3_img1,
            R.drawable.day3_img2,
            R.drawable.day3_img3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day3);

        List<Day3Message> messages = new ArrayList<>();

        Button add = findViewById(R.id.day3_add);
        RecyclerView recyclerview = findViewById(R.id.day3_recycleview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        Day3MessageAdapter adapter = new Day3MessageAdapter();

        for (int i = 0; i < 3; i++) {
            messages.add(new Day3Message(
                    0,
                    title[i % title.length],
                    img[i % img.length])
            );
        }
        adapter.setList(messages);
        recyclerview.setAdapter(adapter);

        add.setOnClickListener(view -> {
            int i = new Random().nextInt(10);
            Day3Message message = new Day3Message(
                    0,
                    title[i % title.length],
                    img[i % img.length]);
            adapter.addData(message);
        });
    }
}
