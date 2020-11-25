package android.example.com.pembimbingintern.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.pembimbingintern.Model.Pendamping;
import android.example.com.pembimbingintern.R;
import android.example.com.pembimbingintern.RestApi.ApiClient;
import android.example.com.pembimbingintern.RestApi.ApiInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPendampingActivity extends AppCompatActivity {
    EditText username, password;
    TextView daftar, judul, judul2,login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btn_login;
    ApiInterface mApiInterface;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pendamping);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);
        btn_login=findViewById(R.id.btn_login);
        login=findViewById(R.id.login);
        daftar=findViewById(R.id.daftar);
        sharedPreferences = LoginPendampingActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        progressDialog = new ProgressDialog(LoginPendampingActivity.this);
        progressDialog.setMessage("Tunggu sebentar... ");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Call<Pendamping> pendampingCall=mApiInterface.postLoginPendamping(username.getText().toString(),password.getText().toString());
                pendampingCall.enqueue(new Callback<Pendamping>() {
                    @Override
                    public void onResponse(Call<Pendamping> call, Response<Pendamping> response) {
                        String id_pendamping=response.body().getId_pendamping();
                        String nama=response.body().getNama_pendamping();
                        String no_hp=response.body().getNo_hp();
                        String username=response.body().getUsername();
                        String password=response.body().getPassword();
                        String token=response.body().getToken();
                        if (TextUtils.isEmpty(id_pendamping)){
                            Toast.makeText(LoginPendampingActivity.this, "Username atau Password salah", Toast.LENGTH_LONG).show();
                        } else{
                            progressDialog.dismiss();
                            Toast.makeText(LoginPendampingActivity.this, "Berhasil Login", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginPendampingActivity.this, HomePendampingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);;
                            editor.putString("id_pendamping", id_pendamping);
                            editor.putString("nama", nama);
                            editor.putString("no_hp", no_hp);
                            editor.putString("username", username);
                            editor.putString("password", password);
                            editor.putString("token", token);
                            editor.apply();
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Pendamping> call, Throwable t) {
                            Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    daftar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),DaftarPendampingActivity.class);
            startActivity(intent);
        }
    });

    }
}
