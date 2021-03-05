package tk.kuusei.helloworld;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WordDao_Impl implements WordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Word> __insertionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Word> __deletionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Word> __updateAdapterOfWord;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllWords;

  public WordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWord = new EntityInsertionAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Word` (`id`,`english_word`,`chinese_meaning`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        stmt.bindLong(1, value.getId());
        if (value.getWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWord());
        }
        if (value.getChineseMeaning() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getChineseMeaning());
        }
      }
    };
    this.__deletionAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Word` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Word` SET `id` = ?,`english_word` = ?,`chinese_meaning` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        stmt.bindLong(1, value.getId());
        if (value.getWord() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getWord());
        }
        if (value.getChineseMeaning() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getChineseMeaning());
        }
        stmt.bindLong(4, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllWords = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM WORD";
        return _query;
      }
    };
  }

  @Override
  public void insertWords(final Word... words) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWord.insert(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteWords(final Word... words) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWord.handleMultiple(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWords(final Word... words) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWord.handleMultiple(words);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllWords() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllWords.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllWords.release(_stmt);
    }
  }

  @Override
  public List<Word> getAllWords() {
    final String _sql = "SELECT * FROM WORD ORDER BY ID DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "english_word");
      final int _cursorIndexOfChineseMeaning = CursorUtil.getColumnIndexOrThrow(_cursor, "chinese_meaning");
      final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Word _item;
        _item = new Word();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpWord;
        _tmpWord = _cursor.getString(_cursorIndexOfWord);
        _item.setWord(_tmpWord);
        final String _tmpChineseMeaning;
        _tmpChineseMeaning = _cursor.getString(_cursorIndexOfChineseMeaning);
        _item.setChineseMeaning(_tmpChineseMeaning);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
