package tk.kuusei.helloworld;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

public class GlobalViewModel extends AndroidViewModel {
    private SavedStateHandle handle;
    private final String key = getApplication().getResources().getString(R.string.MY_KEY);
    private final String name = getApplication().getResources().getString(R.string.MY_DATA);


    public GlobalViewModel(@NonNull Application application, SavedStateHandle handle) {
        super(application);
        this.handle = handle;
        if (!handle.contains(key)) {
            load();
        }
    }

    public LiveData<Integer> getNumber() {
        return handle.getLiveData(key);
    }

    private void load() {
        SharedPreferences shp = getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
        int x = shp.getInt(key, getApplication().getResources().getInteger(R.integer.defValue));
        handle.set(key, x);
    }

    private void save() {
        SharedPreferences shp = getApplication().getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt(key, getNumber().getValue() == null? 0 : getNumber().getValue());
        editor.apply();
    }

    public void add() {
        handle.set(key, getNumber().getValue() == null? 1 : getNumber().getValue() + 1);
        save();
    }

    public void add(int x) {
        handle.set(key, getNumber().getValue() == null? x : getNumber().getValue() + x);
        save();
    }

}
