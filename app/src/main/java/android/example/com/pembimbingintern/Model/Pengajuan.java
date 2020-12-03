package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

public class    Pengajuan {

    @SerializedName("tgl_mulai")
    private String tgl_mulai;
    @SerializedName("tgl_selesai")
    private String tgl_selesai;
    @SerializedName("tgl_pengajuan")
    private String tgl_pengajuan;
    @SerializedName("file")
    private String file;
    @SerializedName("NIM")
    private String NIM;
    @SerializedName("status")
    private String status;
    @SerializedName("nama_mahasiswa")
    private String nama_mahasiswa;
    @SerializedName("jurusan")
    private String jurusan;
    @SerializedName("asal_kampus")
    private String asal_kampus;
    @SerializedName("foto_mahasiswa")
    private String foto_mahasiswa;
    @SerializedName("jenis_kelamin")
    private String jenis_kelamin;
    private String id_daily;
    private String catatan;
    private String img;
    private String ipk;









    public Pengajuan() {
    }

    public Pengajuan(String tgl_mulai, String tgl_selesai, String tgl_pengajuan, String file, String NIM, String status, String nama_mahasiswa, String jurusan, String asal_kampus, String foto_mahasiswa, String jenis_kelamin, String id_daily, String catatan, String img,String ipk) {
        this.tgl_mulai = tgl_mulai;
        this.tgl_selesai = tgl_selesai;
        this.tgl_pengajuan = tgl_pengajuan;
        this.file = file;
        this.NIM = NIM;
        this.status = status;
        this.nama_mahasiswa = nama_mahasiswa;
        this.jurusan = jurusan;
        this.asal_kampus = asal_kampus;
        this.foto_mahasiswa = foto_mahasiswa;
        this.jenis_kelamin = jenis_kelamin;
        this.id_daily = id_daily;
        this.catatan = catatan;
        this.img = img;
        this.ipk= ipk;
    }

    public String getTgl_mulai() {
        return tgl_mulai;
    }

    public void setTgl_mulai(String tgl_mulai) {
        this.tgl_mulai = tgl_mulai;
    }

    public String getTgl_selesai() {
        return tgl_selesai;
    }

    public void setTgl_selesai(String tgl_selesai) {
        this.tgl_selesai = tgl_selesai;
    }

    public String getTgl_pengajuan() {
        return tgl_pengajuan;
    }

    public void setTgl_pengajuan(String tgl_pengajuan) {
        this.tgl_pengajuan = tgl_pengajuan;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNama_mahasiswa() {
        return nama_mahasiswa;
    }

    public void setNama_mahasiswa(String nama_mahasiswa) {
        this.nama_mahasiswa = nama_mahasiswa;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getAsal_kampus() {
        return asal_kampus;
    }

    public void setAsal_kampus(String asal_kampus) {
        this.asal_kampus = asal_kampus;
    }

    public String getFoto_mahasiswa() {
        return foto_mahasiswa;
    }

    public void setFoto_mahasiswa(String foto_mahasiswa) {
        this.foto_mahasiswa = foto_mahasiswa;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getId_daily() {
        return id_daily;
    }

    public void setId_daily(String id_daily) {
        this.id_daily = id_daily;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    public String getIpk() {
        return ipk;
    }

    public void setIpk(String ipk) {
        this.ipk = ipk;
    }
}
