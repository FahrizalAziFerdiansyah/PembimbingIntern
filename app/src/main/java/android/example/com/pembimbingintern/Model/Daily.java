package android.example.com.pembimbingintern.Model;

import com.google.gson.annotations.SerializedName;

public class Daily {

    private String id_daily;
    @SerializedName("tgl_daily")
    private String tgl_daily;
    @SerializedName("pokok_bahasan")
    private String pokok_bahasan;
    @SerializedName("sub_pokok")
    private String sub_pokok;
    @SerializedName("pembimbing")
    private String pembimbing;
    @SerializedName("kegiatan")
    private String kegiatan;
    @SerializedName("NIM")
    private String NIM;
    @SerializedName("catatan")
    private String catatan;
    @SerializedName("img")
    private String img;
    @SerializedName("status")
    private String stat;



    public Daily() {
    }

    public Daily(String id_daily, String tgl_daily, String pokok_bahasan, String sub_pokok, String pembimbing, String kegiatan, String NIM, String catatan, String img, String stat) {
        this.id_daily = id_daily;
        this.tgl_daily = tgl_daily;
        this.pokok_bahasan = pokok_bahasan;
        this.sub_pokok = sub_pokok;
        this.pembimbing = pembimbing;
        this.kegiatan = kegiatan;
        this.NIM = NIM;
        this.catatan = catatan;
        this.img = img;
        this.stat = stat;
    }

    public String getId_daily() {
        return id_daily;
    }

    public void setId_daily(String id_daily) {
        this.id_daily = id_daily;
    }

    public String getTgl_daily() {
        return tgl_daily;
    }

    public void setTgl_daily(String tgl_daily) {
        this.tgl_daily = tgl_daily;
    }

    public String getPokok_bahasan() {
        return pokok_bahasan;
    }

    public void setPokok_bahasan(String pokok_bahasan) {
        this.pokok_bahasan = pokok_bahasan;
    }

    public String getSub_pokok() {
        return sub_pokok;
    }

    public void setSub_pokok(String sub_pokok) {
        this.sub_pokok = sub_pokok;
    }

    public String getPembimbing() {
        return pembimbing;
    }

    public void setPembimbing(String pembimbing) {
        this.pembimbing = pembimbing;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
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

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
