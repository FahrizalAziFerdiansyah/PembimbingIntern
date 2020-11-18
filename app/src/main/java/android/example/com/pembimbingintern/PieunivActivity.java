package android.example.com.pembimbingintern;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.example.com.pembimbingintern.Model.Chart;
import android.example.com.pembimbingintern.RestApi.ApiClient;
import android.example.com.pembimbingintern.RestApi.ApiInterface;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class PieunivActivity extends AppCompatActivity {
    PieChart mPieChart;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pieuniv);
        mPieChart = findViewById(R.id.pieChart);
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);
        getEntries();

    }
    private void getEntries() {
        Call<List<Chart>> listCall=mApiInterface.getKampus();
        listCall.enqueue(new Callback<List<Chart>>() {
            @Override
            public void onResponse(Call<List<Chart>> call, Response<List<Chart>> response) {
                List<PieEntry> pieChart=new ArrayList<>();
                if (response.body() != null) {
                    for (Chart chart : response.body()) {
                        pieChart.add(new PieEntry(chart.getJumlah(), chart.getAsal_kampus()));
                    }
                    PieDataSet pieDataSet = new PieDataSet(pieChart, "( Asal Kampus )");
                    pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);


                    PieData pieData = new PieData(pieDataSet);
                    mPieChart.setData(pieData);
                    pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
                    pieDataSet.setSliceSpace(2f);
                    mPieChart.animateY(1000);
                    pieDataSet.setValueTextColor(Color.WHITE);
                    pieDataSet.setValueTextSize(10f);
                    pieDataSet.setSliceSpace(5f);

                    Description description= new Description();
                    description.setText("PT. Mangli Djaya Raya");
                    mPieChart.setDescription(description);
                }
            }

            @Override
            public void onFailure(Call<List<Chart>> call, Throwable t) {

            }
        });
    }
}