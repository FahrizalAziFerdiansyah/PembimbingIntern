package android.example.com.pembimbingintern.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.example.com.pembimbingintern.Model.PostPutDelPendamping;
import android.example.com.pembimbingintern.R;
import android.example.com.pembimbingintern.RestApi.ApiClient;
import android.example.com.pembimbingintern.RestApi.ApiInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarPendampingActivity extends AppCompatActivity {
    EditText nama_lengkap, no_hp, username, repassword, password;
    Button btn_daftar;
    TextView login;
    ApiInterface mApiInterface;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_pendamping);

        nama_lengkap = findViewById(R.id.nama_lengkap);
        no_hp = findViewById(R.id.no_hp);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        login=findViewById(R.id.login);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        progressDialog = new ProgressDialog(DaftarPendampingActivity.this);
        progressDialog.setMessage("Tunggu sebentar... ");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginPendampingActivity.class);
                startActivity(intent);
            }
        });

        btn_daftar = findViewById(R.id.btn_daftar);
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nama_lengkap.getText().toString().length() == 0) {
                    nama_lengkap.setError("Tidak Boleh Kosong!");
                }else if (no_hp.getText().toString().length() == 0) {
                    no_hp.setError("Tidak Boleh Kosong!");
                }else if (username.getText().toString().length() == 0) {
                    username.setError("Tidak Boleh Kosong!");
                } else if (password.getText().toString().length() == 0) {
                    password.setError("Tidak Boleh Kosong!");
                } else if (!repassword.getText().toString().equals(password.getText().toString())) {
                    Toast.makeText(getApplicationContext(),"Password harus sesuai!",Toast.LENGTH_SHORT).show();
                } else {

                    progressDialog.show();
                    Call<PostPutDelPendamping> pendampingCall = mApiInterface.postAkunPendamping(nama_lengkap.getText().toString(), no_hp.getText().toString(), username.getText().toString(), password.getText().toString());
                    pendampingCall.enqueue(new Callback<PostPutDelPendamping>() {
                        @Override
                        public void onResponse(Call<PostPutDelPendamping> call, Response<PostPutDelPendamping> response) {
                            Toast.makeText(getApplicationContext(), "Pendaftaran berhasil", Toast.LENGTH_LONG).show();
                            Intent mIntent = new Intent(DaftarPendampingActivity.this, LoginPendampingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(mIntent);
                            finish();
                            progressDialog.dismiss();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelPendamping> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }
                    });

                }
            }
        });

    }
}
