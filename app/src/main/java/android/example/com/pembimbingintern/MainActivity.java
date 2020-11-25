package android.example.com.pembimbingintern;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;


public class MainActivity extends AppCompatActivity {

    private AppCompatRatingBar ratingBar;
    private Button btRating;
    private TextView tvRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ratingBar = (AppCompatRatingBar) findViewById(R.id.penilaian);
        btRating = (Button) findViewById(R.id.submit);
        tvRating = (TextView) findViewById(R.id.rate);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvRating.setText("Rate : "+rating);
            }
        });

        btRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this," Rating "+ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}