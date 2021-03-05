package tk.kuusei.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import tk.kuusei.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myTag";
    public static final String EXTRA_MESSAGE = "MESSAGE";
    final static String KEY_NUMBER = "my_number";
    MainActivity that = this;
    ActivityMainBinding binding;


    TextView textView;
    GlobalViewModel myViewModel;

    // 创建进程时触发
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");

        // setContentView(R.layout.activity_main);
        // 以DataBind模式启动内容视图
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 反射创建对象
        myViewModel = new ViewModelProvider(this).get(GlobalViewModel.class);
//        if (savedInstanceState != null){
//            myViewModel.getNumber().setValue(savedInstanceState.getInt(KEY_NUMBER));
//        }
        // 将对象进行绑定
        binding.setData(myViewModel);
        // 设定生命周期
        binding.setLifecycleOwner(this);

        // 数据持久化
        MyData myData = new MyData(getApplicationContext());
        myData.number = 1000;
        myData.save();
        int y = myData.load();
        Log.d(TAG, "onCreate: " + y);
//        SharedPreferences shp = getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences shp = getSharedPreferences("MY_DATA", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = shp.edit();
//        editor.putInt(KEY_NUMBER, 100);
//        editor.apply();



        // 传统的数据手动监听模式
//        myViewModel.getNumber().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                textView.setText(String.valueOf(integer));
//            }
//        });

        // 旧方式
        // Button login = findViewById(R.id.login);
        // 新方式
        Button login = binding.login;
        // 匿名类绑定监听器
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent进行页面显式跳转
                Intent intent = new Intent(that, ControlsActivity.class);
                EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);

                Snackbar.make(view, "跳转页面中", Snackbar.LENGTH_LONG).show();
            }
        });

        Button nav = binding.nav;
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(that, NavActivity.class);
                EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
                String message = editText.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

        Button room = binding.Room;
        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(that, RoomActivity.class);
                startActivity(intent);
            }
        });

    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//        outState.putInt(KEY_NUMBER, myViewModel.getNumber().getValue());
//    }

    // 启动进程时触发
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    // 恢复进程运行时触发（接start）
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    // 暂停进程时触发
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    // 停止进程时触发
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    // 从后台恢复时触发
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    // 销毁时触发
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}