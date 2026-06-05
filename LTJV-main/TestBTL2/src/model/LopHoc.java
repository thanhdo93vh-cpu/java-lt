package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LopHoc implements Serializable {
    private String maLop;
    private String tenLop;
    private String khoa;          // BUG FIX #2: Giữ kiểu String, xóa bỏ nhầm lẫn int ở nơi gọi
    private GiangVien giangVienDay;
    private List<SinhVien> sinhVienHoc;

    public LopHoc(String maLop, String tenLop, String khoa, GiangVien giangVienDay, List<SinhVien> sinhVienHoc) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.khoa = khoa;
        this.giangVienDay = giangVienDay;
        this.sinhVienHoc = (sinhVienHoc != null) ? sinhVienHoc : new ArrayList<>();
    }

    public String getMaLop() { return maLop; }
    public void setMaLop(String maLop) { this.maLop = maLop; }

    // BUG FIX #3: Đổi tên getNienKhoa/setNienKhoa → getKhoa/setKhoa cho nhất quán,
    //             nhưng giữ alias getNienKhoa() để không phá vỡ code view hiện tại.
    public String getKhoa() { return khoa; }
    public void setKhoa(String khoa) { this.khoa = khoa; }

    /** Alias giữ tương thích ngược với ManHinhQuanLyLopHoc. */
    public String getNienKhoa() { return khoa; }
    public void setNienKhoa(String nienKhoa) { this.khoa = nienKhoa; }

    public String getTenLop() { return tenLop; }
    public void setTenLop(String tenLop) { this.tenLop = tenLop; }

    public GiangVien getGiangVienDay() { return giangVienDay; }
    public void setGiangVienDay(GiangVien giangVienDay) { this.giangVienDay = giangVienDay; }

    public int getSiSo() { return sinhVienHoc.size(); }

    public void themSinhVien(SinhVien sv) { this.sinhVienHoc.add(sv); }

    public List<SinhVien> getDanhSachLop() { return sinhVienHoc; }
}
