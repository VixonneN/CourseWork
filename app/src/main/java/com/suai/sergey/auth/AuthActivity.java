package com.suai.sergey.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.suai.sergey.App;
import com.suai.sergey.MainActivity;
import com.suai.sergey.R;
import com.suai.sergey.databases.AppDatabase;
import com.suai.sergey.network.data_classes.auth.AuthBody;
import com.suai.sergey.storage.PreferencesProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity {

    private Button authButton;
    private EditText etLogin;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        etLogin = findViewById(R.id.et_login);
        etPassword = findViewById(R.id.et_password);

        authButton = findViewById(R.id.auth_button);

        deleteDataBase();
        authButton();

    }

    private void authButton(){
        authButton.setOnClickListener(v -> getToken());
    }

    //если добавить этот метод, то в выпадающем списке не будет данных
    private void deleteDataBase() {
        AppDatabase.getAppDatabase(this).worksDao().deleteAllGroups();
        AppDatabase.getAppDatabase(this).worksDao().deleteAllStudents();
        AppDatabase.getAppDatabase(this).worksDao().deleteAllSubjects();
        AppDatabase.getAppDatabase(this).worksDao().deleteAllSubmissions();
        AppDatabase.getAppDatabase(this).worksDao().deleteAllWorks();
        Log.d("deleteAll", "удалена вся бд");
    }


    private void getToken(){
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();

        AuthBody authBody = new AuthBody();
        authBody.setUsername(login);
        authBody.setPassword(password);
        Call<Void> call = getApp().getApi().getAuth(authBody);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.d("onResponse", "success");
                String token = response.headers().get("Authorization");
                if (token != null) {
                    PreferencesProvider.getPreferences().saveToken(token);
                    Log.d("onResponse:" , token);
                    makeToast(token);

                    openMainActivity();
                }

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("onFailure", t.getMessage());
            }
        });
    }


    private App getApp() {
        return ((App) getApplication());
    }

    private void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void openMainActivity(){
        MainActivity.start(this);
    }

}
