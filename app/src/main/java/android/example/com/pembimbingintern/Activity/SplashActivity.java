package android.example.com.pembimbingintern.Activity;

import android.content.Intent;
import android.example.com.pembimbingintern.R;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    TextView title, title2;
    Typeface customfont;
    private int load=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        title=findViewById(R.id.title);
        customfont = Typeface.createFromAsset(getAssets(), "font/geometric.ttf");
         title.setTypeface(customfont);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home=new Intent(SplashActivity.this, LoginPendampingActivity.class);
                startActivity(home);
                finish();

            }
        },load);

    }
}
