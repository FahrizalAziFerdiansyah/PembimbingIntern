package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

public class Pendamping {

    @SerializedName("id_pendamping")
    private String id_pendamping;
    @SerializedName("nama_pendamping")
    private String nama_pendamping;
    @SerializedName("no_hp")
    private String no_hp;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("token")
    private String token;


    public Pendamping() {
    }


    public String getId_pendamping() {
        return id_pendamping;
    }

    public void setId_pendamping(String id_pendamping) {
        this.id_pendamping = id_pendamping;
    }

    public String getNama_pendamping() {
        return nama_pendamping;
    }

    public void setNama_pendamping(String nama_pendamping) {
        this.nama_pendamping = nama_pendamping;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
