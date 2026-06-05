package view;

import fileconn.QuanLyFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.LopHoc;
import model.SinhVien;

public class ManHinhDanhSachLop extends javax.swing.JDialog {
    
    private javax.swing.table.DefaultTableModel tableModel;
    private List<LopHoc> dsLopHocTong;
    private LopHoc lopHocHienTai;

    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtDiemTB;
    private javax.swing.JTextField txtTrangThai;
    private javax.swing.JButton btnThemSV;
    
    public ManHinhDanhSachLop(java.awt.Frame parent, boolean modal, List<LopHoc> dsLopHocTong, LopHoc lopHocHienTai) {
        super(parent, modal);
        this.dsLopHocTong = dsLopHocTong;
        this.lopHocHienTai = lopHocHienTai;
        
        initComponents();
        tichHopFormNhapLieu();
        
        this.setLocationRelativeTo(null);
        
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), 
            "Danh sách sinh viên lớp: " + lopHocHienTai.getTenLop(),
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
            javax.swing.border.TitledBorder.DEFAULT_POSITION, 
            new java.awt.Font("Segoe UI", 1, 24))
        );
        
        tableModel = (DefaultTableModel) jTable1.getModel();
        fillTable(lopHocHienTai.getDanhSachLop());
    }

    private void tichHopFormNhapLieu() {
        txtMaSV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        txtDiemTB = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        btnThemSV = new javax.swing.JButton("Thêm Sinh Viên");

        javax.swing.JPanel pnlFields = new javax.swing.JPanel(new java.awt.GridLayout(2, 6, 5, 2));
        pnlFields.add(new javax.swing.JLabel("Mã sinh viên:"));
        pnlFields.add(new javax.swing.JLabel("Họ và tên:"));
        pnlFields.add(new javax.swing.JLabel("Ngày sinh:"));
        pnlFields.add(new javax.swing.JLabel("Giới tính:"));
        pnlFields.add(new javax.swing.JLabel("Điểm TB:"));
        pnlFields.add(new javax.swing.JLabel("Trạng thái:"));

        pnlFields.add(txtMaSV);
        pnlFields.add(txtHoTen);
        pnlFields.add(txtNgaySinh);
        pnlFields.add(txtGioiTinh);
        pnlFields.add(txtDiemTB);
        pnlFields.add(txtTrangThai);

        javax.swing.JPanel jPanelInput = new javax.swing.JPanel(new java.awt.BorderLayout(10, 10));
        jPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm thành viên mới vào lớp"));
        jPanelInput.add(pnlFields, java.awt.BorderLayout.CENTER);
        jPanelInput.add(btnThemSV, java.awt.BorderLayout.EAST);

        // Bug fix: KHÔNG override layout của contentPane (sẽ làm mất jPanel2, jTable1 của initComponents)
        // Thay vào đó, dùng một wrapper panel bao gồm cả jPanel2 (bảng) lẫn form nhập liệu
        javax.swing.JPanel wrapperPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
        wrapperPanel.add(jPanel2, java.awt.BorderLayout.CENTER);
        wrapperPanel.add(jPanelInput, java.awt.BorderLayout.SOUTH);

        this.getContentPane().removeAll();
        this.getContentPane().setLayout(new java.awt.BorderLayout());
        this.getContentPane().add(wrapperPanel, java.awt.BorderLayout.CENTER);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();

        btnThemSV.addActionListener(this::btnThemSVActionPerformed);
    }

    private void btnThemSVActionPerformed(java.awt.event.ActionEvent evt) {
        String ma = txtMaSV.getText().trim();
        String ten = txtHoTen.getText().trim();
        String ngaySinh = txtNgaySinh.getText().trim();
        String gioiTinh = txtGioiTinh.getText().trim();
        String diemStr = txtDiemTB.getText().trim();
        String trangThai = txtTrangThai.getText().trim();

        if (ma.isEmpty() || ten.isEmpty() || ngaySinh.isEmpty() || gioiTinh.isEmpty() || diemStr.isEmpty() || trangThai.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin sinh viên!");
            return;
        }

        try {
            double diem = Double.parseDouble(diemStr);
            SinhVien svMoi = new SinhVien(ma, ten, ngaySinh, gioiTinh, diem, trangThai);
            
            lopHocHienTai.themSinhVien(svMoi);
            fillTable(lopHocHienTai.getDanhSachLop());
            
            QuanLyFile.ghiFile(new File("lophoc.dat"), new ArrayList<>(dsLopHocTong));
            
            txtMaSV.setText("");
            txtHoTen.setText("");
            txtNgaySinh.setText("");
            txtGioiTinh.setText("");
            txtDiemTB.setText("");
            txtTrangThai.setText("");
            txtMaSV.requestFocus();
            
            javax.swing.JOptionPane.showMessageDialog(this, "Đã thêm sinh viên vào lớp thành công!");
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Điểm trung bình phải là một số thực hợp lệ!");
        }
    }

    private void fillTable(List<SinhVien> dsSV) {
        tableModel.setRowCount(0);
        if (dsSV == null) return;
        for (SinhVien sv : dsSV) {
            tableModel.addRow(new Object[]{
                sv.getMaSV(),
                sv.getTenSV(),       
                sv.getNgaySinh(),
                sv.getGioiTinh(),
                sv.getDiemTB(),       
                sv.getTrangThai()     
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sinh viên", "Họ và tên", "Ngày sinh", "Giới tính", "Điểm trung bình", "Trạng thái học tập"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}