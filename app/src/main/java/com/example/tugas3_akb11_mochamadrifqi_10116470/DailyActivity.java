package com.example.tugas3_akb11_mochamadrifqi_10116470;

public class DailyActivity {

    private String nama;
    private String kegiatan;

    public DailyActivity(String nama, String kegiatan) {
        this.nama = nama;
        this.kegiatan = kegiatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(String kegiatan) {
        this.kegiatan = kegiatan;
    }
}
