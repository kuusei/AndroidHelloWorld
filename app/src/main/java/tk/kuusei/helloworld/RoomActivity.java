package tk.kuusei.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class RoomActivity extends AppCompatActivity {
    WordDao wordDao;
    TextView textView;
    Button buttonInsert, buttonClear, buttonDelete, buttonUpdate;
    LiveData<List<Word>> allWordsLive;
    WordViewModel wordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

        textView = findViewById(R.id.textView3);
        // 使用监听器进行数据更新后的刷新
        wordViewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append("=").append(word.getChineseMeaning()).append("\n");
                }
                textView.setText(text.toString());
            }
        });

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonClear = findViewById(R.id.buttonClear);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonUpdate = findViewById(R.id.buttonUpdate);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("Hello", "你好！");
                Word word2 = new Word("World", "世界！");
//                wordDao.insertWords(word1, word2);
                // 改为异步操作
//                new InsertAsyncTask(wordDao).execute(word1, word2);
                // 进一步将异步操作封装到viewModel
                wordViewModel.insertWords(word1, word2);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                wordDao.deleteAllWords();
//                new DeleteAllAsyncTask();
                wordViewModel.deleteAllWords();
            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi", "你好啊！");
                word.setId(20);
//                wordDao.updateWords(word);
//                new UpdateAsyncTask(wordDao).execute(word);
                wordViewModel.updateWords(word);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word = new Word("Hi", "你好啊！");
                word.setId(17);
//                wordDao.deleteWords(word);
//                new DeleteAsyncTask(wordDao).execute(word);
                wordViewModel.deleteWords(word);
            }
        });

    }
}