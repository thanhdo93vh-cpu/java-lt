/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileconn;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import model.GiangVien;
import model.LopHoc;
import model.SinhVien;
/**
 *
 * @author VU LONG
 */
public class TaiDuLieu
{
    
    List<LopHoc> danhSachLopHoc = new ArrayList<>();
    List<GiangVien> danhsachGiangVien = new ArrayList<>();
    List<SinhVien> danhsachSinhVien = new ArrayList<>();
    
    public <T> void Tai()
    {
        GiangVien gv1 = new GiangVien("GV1", "Nguyễn Thị Lan", "Hà Nội", "lanng123@email.com", "0334563126");
        GiangVien gv2 = new GiangVien("GV2", "Phan Huy Tuấn", "Ninh Bình", "tuanhu@email.com", "0334563122");
        GiangVien gv3 = new GiangVien("GV3", "Ngô Anh Tài", "Hà Nội", "taihuy8386@email.com", "0334563129");
        GiangVien gv4 = new GiangVien("GV4", "Phan Thế Thuật", "Nghệ An", "langvuong11@email.com", "0334563128");
        GiangVien gv5 = new GiangVien("GV5", "Nguyễn Tuấn Anh", "Hải Phòng", "tunah@email.com", "0334563136");
        
        danhsachSinhVien.add(new SinhVien("SV001", "Phan Vũ Long", "04/11/2006", "Nam", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV002", "Nguyễn Thu Hà", "15/02/2006", "Nữ", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV003", "Trần Văn Nam", "20/08/2006", "Nam", 2.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV004", "Lê Thị Sương", "12/05/2006", "Nữ", 4.0, "Bảo lưu"));
        danhsachSinhVien.add(new SinhVien("SV005", "Phạm Minh Đức", "30/12/2006", "Nam", 2.0, "Đang học"));
        
        danhsachSinhVien.add(new SinhVien("SV006", "Hoàng Thùy Linh", "18/03/2006", "Nữ", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV007", "Đỗ Gia Bảo", "25/01/2006", "Nam", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV008", "Vũ Mai Phương", "09/09/2006", "Nữ", 2.5, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV009", "Bùi Tiến Dũng", "14/07/2006", "Nam", 3.5, "Thôi học"));
        danhsachSinhVien.add(new SinhVien("SV010", "Phan Thị Ngọc", "22/10/2006", "Nữ", 3.5, "Đang học"));
        
        danhsachSinhVien.add(new SinhVien("SV011", "Đặng Đình Phong", "05/06/2006", "Nam", 1.5, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV012", "Lý Hải Yến", "11/11/2006", "Nữ", 2.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV013", "Dương Quốc Anh", "19/04/2006", "Nam", 2.5, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV014", "Nguyễn Bích Thủy", "27/02/2006", "Nữ", 2.0, "Bảo lưu"));
        danhsachSinhVien.add(new SinhVien("SV015", "Trịnh Xuân Trường", "01/01/2006", "Nam", 3.0, "Đang học"));
        
        danhsachSinhVien.add(new SinhVien("SV016", "Ngô Bảo Ngọc", "14/08/2006", "Nữ", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV017", "Đinh Quang Huy", "23/03/2006", "Nam", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV018", "Tạ Thị Thanh", "08/12/2006", "Nữ", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV019", "Vũ Hoàng Long", "17/10/2006", "Nam", 3.5, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV020", "Phạm Thúy Vi", "03/05/2006", "Nữ", 2.0, "Đang học"));
        
        danhsachSinhVien.add(new SinhVien("SV021", "Nguyễn Minh Triết", "12/09/2006", "Nam", 2.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV022", "Lê Hồng Hạnh", "28/06/2006", "Nữ", 4.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV023", "Trần Đình Trọng", "04/04/2006", "Nam", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV024", "Hoàng Minh Thư", "19/01/2006", "Nữ", 2.5, "Bảo lưu"));
        danhsachSinhVien.add(new SinhVien("SV025", "Vũ Đức Đam", "15/07/2006", "Nam", 4.0, "Đang học"));
        
        danhsachSinhVien.add(new SinhVien("SV026", "Phan Văn Đức", "20/05/2006", "Nam", 3.5, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV027", "Cao Thùy Trang", "02/11/2006", "Nữ", 4.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV028", "Đỗ Hùng Dũng", "08/09/2006", "Nam", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV029", "Nguyễn Thị Diệu", "25/04/2006", "Nữ", 1.5, "Thôi học"));
        danhsachSinhVien.add(new SinhVien("SV030", "Lâm Thành Đạt", "31/10/2006", "Nam", 2.0, "Đang học"));
        
        danhsachSinhVien.add(new SinhVien("SV031", "Tống Văn Hùng", "13/02/2006", "Nam", 3.5, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV032", "Mai Phương Thảo", "07/07/2006", "Nữ", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV033", "Nguyễn Tiến Linh", "21/10/2006", "Nam", 4.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV034", "Phạm Thanh Hằng", "16/03/2006", "Nữ", 3.0, "Đang học"));
        danhsachSinhVien.add(new SinhVien("SV035", "Vũ Văn Thanh", "14/04/2006", "Nam", 2.5, "Đang học"));
        
        // Bug fix: thêm new ArrayList<>() vào cuối mỗi constructor LopHoc (tham số thứ 5)
        LopHoc lop1 = new LopHoc("LH001", "Công nghệ thông tin", "K19", gv1, new ArrayList<>());
        lop1.themSinhVien(timSinhVien("SV001"));
        lop1.themSinhVien(timSinhVien("SV002"));
        lop1.themSinhVien(timSinhVien("SV003"));
        lop1.themSinhVien(timSinhVien("SV004"));
        lop1.themSinhVien(timSinhVien("SV005"));
        danhSachLopHoc.add(lop1);

        LopHoc lop2 = new LopHoc("LH002", "An toàn thông tin", "K19", gv2, new ArrayList<>());
        lop2.themSinhVien(timSinhVien("SV006"));
        lop2.themSinhVien(timSinhVien("SV007"));
        lop2.themSinhVien(timSinhVien("SV008"));
        lop2.themSinhVien(timSinhVien("SV009"));
        lop2.themSinhVien(timSinhVien("SV010"));
        danhSachLopHoc.add(lop2);

        LopHoc lop3 = new LopHoc("LH003", "Khoa học máy tính", "K19", gv3, new ArrayList<>());
        lop3.themSinhVien(timSinhVien("SV011"));
        lop3.themSinhVien(timSinhVien("SV012"));
        lop3.themSinhVien(timSinhVien("SV013"));
        lop3.themSinhVien(timSinhVien("SV014"));
        lop3.themSinhVien(timSinhVien("SV015"));
        danhSachLopHoc.add(lop3);

        LopHoc lop4 = new LopHoc("LH004", "Thương mại điện tử", "K19", gv4, new ArrayList<>());
        lop4.themSinhVien(timSinhVien("SV016"));
        lop4.themSinhVien(timSinhVien("SV017"));
        lop4.themSinhVien(timSinhVien("SV018"));
        lop4.themSinhVien(timSinhVien("SV019"));
        lop4.themSinhVien(timSinhVien("SV020"));
        danhSachLopHoc.add(lop4);

        LopHoc lop5 = new LopHoc("LH005", "Hệ thống thông tin", "K19", gv5, new ArrayList<>());
        lop5.themSinhVien(timSinhVien("SV021"));
        lop5.themSinhVien(timSinhVien("SV022"));
        lop5.themSinhVien(timSinhVien("SV023"));
        lop5.themSinhVien(timSinhVien("SV024"));
        lop5.themSinhVien(timSinhVien("SV025"));
        danhSachLopHoc.add(lop5);

        LopHoc lop6 = new LopHoc("LH006", "Kỹ thuật phần mềm", "K19", gv3, new ArrayList<>());
        lop6.themSinhVien(timSinhVien("SV026"));
        lop6.themSinhVien(timSinhVien("SV027"));
        lop6.themSinhVien(timSinhVien("SV028"));
        lop6.themSinhVien(timSinhVien("SV029"));
        lop6.themSinhVien(timSinhVien("SV030"));
        danhSachLopHoc.add(lop6);

        LopHoc lop7 = new LopHoc("LH007", "Khoa học dữ liệu", "K19", gv1, new ArrayList<>());
        lop7.themSinhVien(timSinhVien("SV031"));
        lop7.themSinhVien(timSinhVien("SV032"));
        lop7.themSinhVien(timSinhVien("SV033"));
        lop7.themSinhVien(timSinhVien("SV034"));
        lop7.themSinhVien(timSinhVien("SV035"));
        danhSachLopHoc.add(lop7);
        
        // Bug fix: đổi writeFile -> ghiFile cho đúng tên method trong QuanLyFile
        // Bug fix: bỏ hardcode "D:/" -> dùng đường dẫn tương đối
        QuanLyFile.ghiFile(new File("lophoc.dat"), (ArrayList) danhSachLopHoc);
        QuanLyFile.ghiFile(new File("giangvien.dat"), (ArrayList) danhsachGiangVien);
        QuanLyFile.ghiFile(new File("sinhvien.dat"), (ArrayList) danhsachSinhVien);
    }
    
    public SinhVien timSinhVien(String maSV)
    {
        for (SinhVien sv : danhsachSinhVien)
        {
            if (sv.getMaSV().equalsIgnoreCase(maSV))
            {
                return sv;
            }
        }
        return null;
    }
}