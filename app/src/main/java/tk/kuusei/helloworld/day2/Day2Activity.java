package tk.kuusei.helloworld.day2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import tk.kuusei.helloworld.R;
import tk.kuusei.helloworld.day1.Day1Activity;

public class Day2Activity extends AppCompatActivity {

    private EditText accountEdit;
    private EditText passwordEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2);

        accountEdit = findViewById(R.id.day2_account);
        passwordEdit = findViewById(R.id.day2_password);

        findViewById(R.id.day2_login).setOnClickListener(v -> {
            String account = accountEdit.getText().toString().trim();
            String password = passwordEdit.getText().toString();
            if ("lwl".equals(account) && "666".equals(password)) {
                startActivity(new Intent(Day2Activity.this, Day1Activity.class));
            } else {
                Toast.makeText(Day2Activity.this, "账号密码错误", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
