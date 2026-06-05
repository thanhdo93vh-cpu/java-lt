/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fileconn;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.LopHoc;

/**
 *
 * @author VU LONG
 */
public class QuanLyFile
{
    // 1. Hàm đọc file nhận tham số File (Giữ nguyên gốc của bạn)
    public static <T> List<T> readFile(File f)
    {
        List<T> ds = new ArrayList<>();
        if (!f.exists() || f.length() == 0)
        {
            new TaiDuLieu().Tai();
            if (f.length() == 0)
            {
                return ds;
            }
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(f)))
        {
            ds = (ArrayList<T>) in.readObject();            
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
        return ds;
    }
    
    // 2. Bổ sung hàm đọc file nhận tham số String đường dẫn (Phòng trường hợp màn hình khác gọi)
    public static <T> List<T> readFile(String path) {
        return readFile(new File(path));
    }
    
    // 3. Hàm ghi file nhận (List, File) (Giữ nguyên gốc của bạn)
    public static <T> void writeFile(List<T> ds, File f)
    {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f)))
        {
            out.writeObject(ds);
        }
        catch(IOException e)
        {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }

    // 4. BỔ SUNG: Hàm ghiFile nhận (File, List) khớp 100% với code giao diện ban đầu của bạn
    public static <T> void ghiFile(File f, List<T> ds) {
        writeFile(ds, f);
    }

    // 5. BỔ SUNG: Hàm ghiFile nhận (String, List) khớp với Cách 1 khi bạn sửa đường dẫn dạng chuỗi
    public static <T> void ghiFile(String path, List<T> ds) {
        writeFile(ds, new File(path));
    }
}