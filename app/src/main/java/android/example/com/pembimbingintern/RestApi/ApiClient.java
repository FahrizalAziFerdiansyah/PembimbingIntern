package android.example.com.pembimbingintern.RestApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
<<<<<<< Updated upstream
    public static final String BASE_URL = "http://192.168.43.224/apimagang/api/";
=======
    public static final String BASE_URL = "http://192.168.43.22:81/apimagang/api/";
>>>>>>> Stashed changes
    private static Retrofit retrofit = null;
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
