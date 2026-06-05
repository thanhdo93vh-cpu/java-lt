package view;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.KetNoiSQL;

public class ManHinhTaoTaiKhoan extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(ManHinhTaoTaiKhoan.class.getName());

    public ManHinhTaoTaiKhoan() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        txtNhapLai = new javax.swing.JPasswordField();
        btnXoa = new javax.swing.JButton();
        btnTao = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHoDem = new javax.swing.JTextField();
        lblDangNhap = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabel1.setText("Tạo tài khoản");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel2.setText("Tên:");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel4.setText("Email:");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel5.setText("Mật khẩu:");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel6.setText("Nhập lại mật khẩu:");
        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 18));
        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 18));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18));
        txtNhapLai.setFont(new java.awt.Font("Segoe UI", 0, 18));

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(this::btnXoaActionPerformed);
        btnTao.setText("Tạo");
        btnTao.addActionListener(this::btnTaoActionPerformed);

        jLabel3.setText("Đã có tài khoản?");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jLabel7.setText("Họ đệm:");
        txtHoDem.setFont(new java.awt.Font("Segoe UI", 0, 18));

        lblDangNhap.setText("<html><a href=\"\">Đăng nhập</a></html> ");
        lblDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangNhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6).addComponent(jLabel5).addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2).addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoDem, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1).addGap(281, 281, 281))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(293, 293, 293))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoDem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNhapLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa).addComponent(btnTao))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        txtHoDem.setText(""); txtTen.setText(""); txtEmail.setText("");
        txtMatKhau.setText(""); txtNhapLai.setText("");
        txtHoDem.requestFocus();
    }

    private void btnTaoActionPerformed(java.awt.event.ActionEvent evt) {
        String inputHoDem   = txtHoDem.getText().trim();
        String inputTen     = txtTen.getText().trim();
        String inputEmail   = txtEmail.getText().trim();
        String inputMatKhau = new String(txtMatKhau.getPassword());
        String inputNhapLai = new String(txtNhapLai.getPassword());

        if (inputHoDem.isEmpty() || inputTen.isEmpty() || inputEmail.isEmpty() || inputMatKhau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        if (!inputMatKhau.equals(inputNhapLai)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không trùng khớp!");
            return;
        }

        // BUG FIX #4: Kiểm tra kết nối null trước khi dùng, giống ManHinhDangNhap
        Connection conn = KetNoiSQL.KetNoi();
        if (conn == null) {
            JOptionPane.showMessageDialog(this,
                    "Không thể kết nối đến cơ sở dữ liệu!\nVui lòng kiểm tra cấu hình kết nối hoặc thư viện Driver.",
                    "Lỗi Kết Nối", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "INSERT INTO TaiKhoan(hoDem, ten, email, matKhau) VALUES (?, ?, ?, ?)";
        try (conn; PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, inputHoDem);
            ps.setString(2, inputTen);
            ps.setString(3, inputEmail);
            ps.setString(4, inputMatKhau);

            int dong = ps.executeUpdate();
            if (dong > 0) {
                JOptionPane.showMessageDialog(this, "Đã tạo tài khoản thành công");
                new ManHinhDangNhap().setVisible(true);
                this.dispose();
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 2627) {
                JOptionPane.showMessageDialog(this, "Email đã được sử dụng!");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi SQL: " + e.getMessage());
            }
        }
    }

    private void lblDangNhapMouseClicked(java.awt.event.MouseEvent evt) {
        new ManHinhDangNhap().setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ManHinhTaoTaiKhoan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTao;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblDangNhap;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoDem;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtNhapLai;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
