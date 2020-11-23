package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

public class Mahasiswa {
    @SerializedName("NIM")
    private String NIM;
    @SerializedName("nama_mahasiswa")
    private String nama_mahasiswa;
    @SerializedName("jenis_kelamin")
    private String jenis_kelamin;
    @SerializedName("alamat_mahasiswa")
    private String alamat_mahasiswa;
    @SerializedName("asal_kampus")
    private String asal_kampus;
    @SerializedName("jurusan")
    private  String jurusan;
    @SerializedName("no_hp")
    private  String no_hp;
    @SerializedName("email")
    private  String email;
    @SerializedName("ipk mahasiswa")
    private String ipk;
    @SerializedName("foto_mahasiswa")
    private String foto_mahasiswa;
    @SerializedName("tgl_daftar")
    private String tgl_daftar;
    @SerializedName("id_akun")
    private String id_akun;

    public Mahasiswa() {
    }

    public Mahasiswa(String NIM, String nama_mahasiswa, String jenis_kelamin, String alamat_mahasiswa, String asal_kampus, String jurusan, String no_hp, String email,  String foto_mahasiswa, String tgl_daftar, String id_akun) {
        this.NIM = NIM;
        this.nama_mahasiswa = nama_mahasiswa;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat_mahasiswa = alamat_mahasiswa;
        this.asal_kampus = asal_kampus;
        this.jurusan = jurusan;
        this.no_hp = no_hp;
        this.email = email;
        this.ipk = ipk;
        this.foto_mahasiswa = foto_mahasiswa;
        this.tgl_daftar = tgl_daftar;
        this.id_akun = id_akun;
    }

    public String getId_akun() {
        return id_akun;
    }

    public void setId_akun(String id_akun) {
        this.id_akun = id_akun;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getNama_mahasiswa() {
        return nama_mahasiswa;
    }

    public void setNama_mahasiswa(String nama_mahasiswa) {
        this.nama_mahasiswa = nama_mahasiswa;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat_mahasiswa() {
        return alamat_mahasiswa;
    }

    public void setAlamat_mahasiswa(String alamat_mahasiswa) {
        this.alamat_mahasiswa = alamat_mahasiswa; }

    public String getAsal_kampus() {
        return asal_kampus;
    }

    public void setAsal_kampus(String asal_kampus) {
        this.asal_kampus = asal_kampus;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIpk() { return ipk; }

    public void setIpk(String ipk) { this.ipk = ipk; }

    public String getFoto_mahasiswa() {
        return foto_mahasiswa;
    }

    public void setFoto_mahasiswa(String foto_mahasiswa) {
        this.foto_mahasiswa = foto_mahasiswa;
    }

    public String getTgl_daftar() {
        return tgl_daftar;
    }

    public void setTgl_daftar(String tgl_daftar) {
        this.tgl_daftar = tgl_daftar;
    }
}
