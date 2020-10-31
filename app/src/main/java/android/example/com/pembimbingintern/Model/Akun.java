package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

public class Akun {

    @SerializedName("id_akun")
    private String id_akun;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;


    public Akun() {
    }

    public Akun(String id_akun, String username, String password) {
        this.id_akun = id_akun;
        this.username = username;
        this.password = password;
    }

    public String getId_akun() {
        return id_akun;
    }

    public void setId_akun(String id_akun) {
        this.id_akun = id_akun;
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
}
