package android.example.com.pembimbingintern.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.pembimbingintern.Model.PostPutDelPendamping;
import android.example.com.pembimbingintern.R;
import android.example.com.pembimbingintern.RestApi.ApiClient;
import android.example.com.pembimbingintern.RestApi.ApiInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfilActivity extends AppCompatActivity  {
    EditText nama_lengkap, no_hp, nama_pengguna, repassword, password;
    Button btn_simpan;
    TextView editprofil;
    ApiInterface mApiInterface;
    ProgressDialog progressDialog;
    String id_pendamping,token;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofil);

        nama_lengkap = findViewById(R.id.nama);
        no_hp = findViewById(R.id.no_hp);
        nama_pengguna = findViewById(R.id.nama_pengguna);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);

        sharedPreferences = EditProfilActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        progressDialog = new ProgressDialog(EditProfilActivity.this);
        progressDialog.setMessage("Tunggu sebentar... ");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(true);


        nama_lengkap.setText(sharedPreferences.getString("nama","0"));
        no_hp.setText(sharedPreferences.getString("no_hp","0"));
        nama_pengguna.setText(sharedPreferences.getString("username","0"));
        password.setText(sharedPreferences.getString("password","0"));
        repassword.setText(sharedPreferences.getString("password","0"));
        token=sharedPreferences.getString("token","0");
        id_pendamping=sharedPreferences.getString("id_pendamping","0");

        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nama_lengkap.getText().toString().length() == 0) {
                    nama_lengkap.setError("Tidak Boleh Kosong!");
                }else if (no_hp.getText().toString().length() == 0) {
                    no_hp.setError("Tidak Boleh Kosong!");
                }else if (nama_pengguna.getText().toString().length() == 0) {
                    nama_pengguna.setError("Tidak Boleh Kosong!");
                } else if (password.getText().toString().length() == 0) {
                    password.setError("Tidak Boleh Kosong!");
                } else if (!repassword.getText().toString().equals(password.getText().toString())) {
                    Toast.makeText(getApplicationContext(),"Password harus sesuai!",Toast.LENGTH_SHORT).show();
                } else {

                    progressDialog.show();
                    Call<PostPutDelPendamping> pendampingCall = mApiInterface.putAkunPendamping(id_pendamping,nama_lengkap.getText().toString(), no_hp.getText().toString(), nama_pengguna.getText().toString(), password.getText().toString(),token);
                    pendampingCall.enqueue(new Callback<PostPutDelPendamping>() {
                        @Override
                        public void onResponse(Call<PostPutDelPendamping> call, Response<PostPutDelPendamping> response) {
                            Toast.makeText(getApplicationContext(), "Perubahan berhasil", Toast.LENGTH_LONG).show();
                            Intent mIntent = new Intent(EditProfilActivity.this, LoginPendampingActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
