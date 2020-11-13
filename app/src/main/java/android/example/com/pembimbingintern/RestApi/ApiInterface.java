package android.example.com.pembimbingintern.RestApi;

import android.example.com.pembimbingintern.Model.Akun;
import android.example.com.pembimbingintern.Model.Daily;
import android.example.com.pembimbingintern.Model.GetAkun;
import android.example.com.pembimbingintern.Model.GetDaily;
import android.example.com.pembimbingintern.Model.GetPendamping;
import android.example.com.pembimbingintern.Model.GetPengajuan;
import android.example.com.pembimbingintern.Model.Mahasiswa;
import android.example.com.pembimbingintern.Model.Pendamping;
import android.example.com.pembimbingintern.Model.Pengajuan;
import android.example.com.pembimbingintern.Model.PostPutDelAkun;
import android.example.com.pembimbingintern.Model.PostPutDelDaily;
import android.example.com.pembimbingintern.Model.PostPutDelMhs;
import android.example.com.pembimbingintern.Model.PostPutDelPendamping;
import android.example.com.pembimbingintern.Model.PostPutDelPengajuan;
import android.example.com.pembimbingintern.Model.UploadImage;
import android.view.View;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface ApiInterface {


    @GET("user")
    Call<GetAkun> getAkun();


    @GET("pendamping")
    Call<GetPendamping> getPendamping();

    @FormUrlEncoded
    @POST("user")
    Call<PostPutDelAkun> postAkun(@Field("username") String username,
                                  @Field("password") String password);

    @FormUrlEncoded
    @POST("pendamping")
    Call<PostPutDelPendamping> postAkunPendamping(
            @Field("nama_pendamping") String nama_pendamping,
            @Field("no_hp") String no_hp,
            @Field("username") String username,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("user/login")
    Call<Akun> postLogin(@Field("username") String username,
                         @Field("password") String password);

    @FormUrlEncoded
    @POST("pendamping/login")
    Call<Pendamping> postLoginPendamping(@Field("username") String username,
                                         @Field("password") String password);

    @FormUrlEncoded
    @POST("mahasiswa")
    Call<PostPutDelMhs> postData(@Field("NIM") String NIM,
                                 @Field("nama_mahasiswa") String nama_mahasiswa,
                                 @Field("jenis_kelamin") String jenis_kelamin,
                                 @Field("alamat_mahasiswa") String alamat_mahasiswa,
                                 @Field("asal_kampus") String asal_kampus,
                                 @Field("jurusan") String jurusan,
                                 @Field("foto_mahasiswa") String foto_mahasiswa,
                                 @Field("no_hp") String no_hp,
                                 @Field("email") String email,
                                 @Field("id_akun") String id_akun
    );

    @FormUrlEncoded
    @POST("mahasiswa/cek")
    Call<Mahasiswa> postNim(@Field("NIM") String nim);

    @FormUrlEncoded
    @POST("daily/cek")
    Call<GetDaily> postDaily(@Field("NIM") String nim);

    @FormUrlEncoded
    @POST("daily/cek2")
    Call<GetDaily> postDaily2(@Field("NIM") String nim);

    @FormUrlEncoded
    @POST("pendamping/pengajuan")
    Call<GetPengajuan> postPendamping(@Field("id_pendamping") String id_pendamping);

    @FormUrlEncoded
    @POST("daily/cek_daily")
    Call<Daily> postCekDaily(@Field("NIM") String nim,
                             @Field("tgl_daily") String tgl_daily);


    @FormUrlEncoded
    @POST("mahasiswa/cek_data")
    Call<Mahasiswa> postId(@Field("id_akun") String id_akun);

    @FormUrlEncoded
    @POST("pengajuan")
    Call<PostPutDelPengajuan> postPengajuan(@Field("tgl_mulai") String tgl_mulai,
                                            @Field("tgl_selesai") String tgl_selesai,
                                            @Field("NIM") String NIM,
                                            @Field("file") String file,
                                            @Field("nama_pendamping") String nama_pendamping

    );

    @FormUrlEncoded
    @POST("daily")
    Call<PostPutDelDaily> postDaily(@Field("tgl_daily") String tgl_daily,
                                    @Field("pokok_bahasan") String pokok_bahasan,
                                    @Field("sub_pokok") String sub_pokok,
                                    @Field("kegiatan") String kegiatan,
                                    @Field("NIM") String NIM
    );

    @FormUrlEncoded
    @POST("pengajuan/cek")
    Call<Pengajuan> postCekPengajuan(@Field("NIM") String NIM

    );

    @FormUrlEncoded
    @POST("user/cek_user")
    Call<Akun> potsCekUser(@Field("username") String username

    );

    @Multipart
    @POST("upload_image")
    Call<UploadImage> uploadFile(@Part MultipartBody.Part file,
                                 @Part("file") RequestBody name);

    @Multipart
    @POST("upload_image")
    Call<UploadImage> upload(@Header("Authorization") String authorization,
                             @PartMap Map<String, RequestBody> map
    );
    @FormUrlEncoded
    @PUT("pengajuan/status")
    Call<PostPutDelPengajuan> putPengajuan(@Field("status") String status,
                                           @Field("nim") String nim);

    @FormUrlEncoded
    @POST("pendamping/mahasiswa")
    Call<GetPengajuan> postMhs(@Field("id_pendamping") String id_pendamping);

    @FormUrlEncoded
    @POST("pendamping/konfirmasi")
    Call<Daily> postKonfirmasi(@Field("id_daily") String id_daily,
                               @Field("catatan") String catatan,
                               @Field("img") String img);


}
