package model;

public class TaiKhoan {
    private String hoDem;
    private String ten;
    private String email;
    private String matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String hoDem, String ten, String email, String matKhau) {
        this.hoDem = hoDem;
        this.ten = ten;
        this.email = email;
        this.matKhau = matKhau;
    }

    public TaiKhoan(String email, String matKhau) {
        this.email = email;
        this.matKhau = matKhau;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "hoDem=" + hoDem + ", ten=" + ten + ", email=" + email + '}';
    }
}
