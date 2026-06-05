package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import util.KetNoiSQL;

public class ManHinhDangNhap extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ManHinhDangNhap.class.getName());

    public ManHinhDangNhap() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        // Tối ưu hóa UX: Đặt btnDangNhap làm nút mặc định khi nhấn phím Enter trên toàn màn hình
        this.getRootPane().setDefaultButton(btnDangNhap);
        
        // Tối ưu hóa UX: Tự động nhấp nháy con trỏ tại ô nhập liệu Email khi mở form
        txtEmail.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        btnDangNhap = new javax.swing.JButton();
        btnQuenMatKhau = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Đăng nhập");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Email:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.addActionListener(this::txtEmailActionPerformed);

        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(this::btnDangNhapActionPerformed);

        btnQuenMatKhau.setText("Quên mật khẩu?");
        btnQuenMatKhau.addActionListener(this::btnQuenMatKhauActionPerformed);

        btnXoa.setText("Xóa");
        btnXoa.setToolTipText("");
        btnXoa.addActionListener(this::btnXoaActionPerformed);

        jLabel4.setText("Chưa có tài khoản?");

        jLabel5.setText("<html><a href=\"\">Tạo tài khoản</a></html>");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(253, 253, 253))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnQuenMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(308, 308, 308))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addComponent(btnQuenMatKhau)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {}

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        String inputEmail = txtEmail.getText().trim();
        String inputPassword = new String(txtMatKhau.getPassword()); 
        
        // 1. Kiểm tra rỗng đầu vào
        if (inputEmail.isEmpty() || inputPassword.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ Email và Mật khẩu!");
            return;
        }
        
        // 2. Lấy kết nối từ util.KetNoiSQL
        Connection conn = KetNoiSQL.KetNoi();
        
        // Fix lỗi sập: Kiểm tra kết nối database trước khi tạo PreparedStatement
        if (conn == null) {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Không thể kết nối đến cơ sở dữ liệu!\nVui lòng kiểm tra cấu hình kết nối hoặc thư viện Driver.", 
                "Lỗi Kết Nối", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String sql = "SELECT * FROM TaiKhoan WHERE email = ? AND matKhau = ?";
        
        // 3. Thực hiện truy vấn an toàn bằng Try-with-resources
        try (conn;
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, inputEmail);
            ps.setString(2, inputPassword);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hoDem = rs.getString("hoDem");
                    String ten = rs.getString("ten");
                    
                    javax.swing.JOptionPane.showMessageDialog(this, "Chào mừng " + hoDem + " " + ten + " đã đăng nhập!");
                    
                    ManHinhQuanLyLopHoc mhQuanLy = new ManHinhQuanLyLopHoc();
                    mhQuanLy.setVisible(true); 
                    this.dispose(); 
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Email hoặc mật khẩu không chính xác!");
                }
            }
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Lỗi thực thi truy vấn SQL: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnQuenMatKhauActionPerformed(java.awt.event.ActionEvent evt) {
        new ManHinhQuenMatKhau().setVisible(true);
        this.dispose();
    }

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        txtEmail.setText("");
        txtMatKhau.setText("");
        txtEmail.requestFocus();
    }

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {
        new ManHinhTaoTaiKhoan().setVisible(true);
        this.dispose();
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ManHinhDangNhap().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnQuenMatKhau;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}