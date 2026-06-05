package view;

import fileconn.QuanLyFile;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.GiangVien;
import model.LopHoc;
import model.SinhVien;

public class ManHinhQuanLyLopHoc extends javax.swing.JFrame {

    private static final String FILE_PATH = "lophoc.dat";
    DefaultTableModel tableModel;
    ArrayList<LopHoc> dsLopHoc = new ArrayList<>();

    private static final java.util.logging.Logger logger =
            java.util.logging.Logger.getLogger(ManHinhQuanLyLopHoc.class.getName());

    // --- Form fields (declared here so action handlers can access them) ---
    private JTextField txtMaLop;
    private JTextField txtTenLop;
    private JTextField txtNienKhoa;
    private JTextField txtTenGiaoVien;
    private JTable tblDanhSachLopHoc;
    private JScrollPane jScrollPane1;

    public ManHinhQuanLyLopHoc() {
        setTitle("Phần mềm quản lý lớp học");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(900, 640));
        setLayout(new BorderLayout(0, 8));

        // ── Menu bar ──────────────────────────────────────────────────────
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new JMenu("Tệp"));
        menuBar.add(new JMenu("Cài đặt"));
        JMenu menuXuat = new JMenu("Xuất tài liệu & Lịch sử");
        JMenuItem mi1 = new JMenuItem("Mục 1");
        mi1.addActionListener(e -> {});
        menuXuat.add(mi1);
        menuBar.add(menuXuat);
        menuBar.add(new JMenu("Trợ giúp"));
        setJMenuBar(menuBar);

        // ── Panel 1: Thông tin lớp học ────────────────────────────────────
        JPanel pnlInfo = new JPanel(new GridBagLayout());
        pnlInfo.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180)),
                "Thông tin lớp học",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 13)));
        pnlInfo.setBackground(Color.WHITE);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 14);

        String[] labels = {"Mã lớp:", "Tên lớp:", "Khóa:", "Giáo viên chủ nhiệm:"};
        txtMaLop        = new JTextField();
        txtTenLop       = new JTextField();
        txtNienKhoa     = new JTextField();
        txtTenGiaoVien  = new JTextField();
        JTextField[] fields = {txtMaLop, txtTenLop, txtNienKhoa, txtTenGiaoVien};

        for (int i = 0; i < labels.length; i++) {
            // Label — cố định width, không co giãn
            GridBagConstraints lc = new GridBagConstraints();
            lc.anchor  = GridBagConstraints.WEST;
            lc.insets  = new Insets(7, 16, 7, 8);
            lc.gridx   = 0; lc.gridy = i;
            lc.weightx = 0;
            JLabel lbl = new JLabel(labels[i]);
            lbl.setFont(labelFont);
            lbl.setPreferredSize(new Dimension(160, 24));
            pnlInfo.add(lbl, lc);

            // Field — chiều rộng cố định 280px, KHÔNG co giãn theo cửa sổ
            GridBagConstraints fc = new GridBagConstraints();
            fc.anchor  = GridBagConstraints.WEST;
            fc.insets  = new Insets(7, 0, 7, 16);
            fc.gridx   = 1; fc.gridy = i;
            fc.weightx = 0; // không stretch
            fields[i].setFont(fieldFont);
            fields[i].setPreferredSize(new Dimension(280, 28));
            pnlInfo.add(fields[i], fc);

            // Cột 2: khoảng trống đàn hồi để đẩy form về bên trái
            GridBagConstraints sc = new GridBagConstraints();
            sc.gridx = 2; sc.gridy = i;
            sc.weightx = 1.0;
            sc.fill = GridBagConstraints.HORIZONTAL;
            pnlInfo.add(new JLabel(), sc);
        }

        // ── Panel 2: Nút thao tác ─────────────────────────────────────────
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 6));
        pnlButtons.setBackground(new Color(245, 245, 245));

        JButton btnThem  = new JButton("Thêm lớp");
        JButton btnSua   = new JButton("Sửa lớp");
        JButton btnXoa   = new JButton("Xóa lớp");
        JButton btnThoat = new JButton("Thoát");

        Font btnFont = new Font("Segoe UI", Font.PLAIN, 13);
        for (JButton b : new JButton[]{btnThem, btnSua, btnXoa, btnThoat}) {
            b.setFont(btnFont);
            b.setPreferredSize(new Dimension(110, 32));
            pnlButtons.add(b);
        }
        btnThoat.setBackground(new Color(220, 80, 70));
        btnThoat.setForeground(Color.WHITE);
        btnThoat.setOpaque(true);

        btnThem .addActionListener(this::jButton1ActionPerformed);
        btnSua  .addActionListener(this::jButton2ActionPerformed);
        btnXoa  .addActionListener(this::jButton3ActionPerformed);
        btnThoat.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc muốn thoát không?", "Xác nhận thoát",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) System.exit(0);
        });

        // ── Panel 3: Bảng danh sách ───────────────────────────────────────
        tblDanhSachLopHoc = new JTable();
        tblDanhSachLopHoc.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã lớp", "Tên lớp", "Niên khóa", "Chi tiết", "Sĩ số", "Giáo viên"}
        ) {
            public boolean isCellEditable(int r, int c) { return false; }
        });
        tblDanhSachLopHoc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tblDanhSachLopHoc.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblDanhSachLopHoc.setRowHeight(26);

        jScrollPane1 = new JScrollPane(tblDanhSachLopHoc);
        jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        JPanel pnlTable = new JPanel(new BorderLayout());
        pnlTable.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 12));
        pnlTable.add(jScrollPane1, BorderLayout.CENTER);

        // ── Top wrapper (info + buttons stacked) ─────────────────────────
        JPanel pnlTop = new JPanel(new BorderLayout(0, 4));
        pnlTop.setBorder(BorderFactory.createEmptyBorder(8, 12, 4, 12));
        pnlTop.add(pnlInfo, BorderLayout.CENTER);
        pnlTop.add(pnlButtons, BorderLayout.SOUTH);

        add(pnlTop, BorderLayout.NORTH);
        add(pnlTable, BorderLayout.CENTER);

        // ── Table selection listener ──────────────────────────────────────
        tableModel = (DefaultTableModel) tblDanhSachLopHoc.getModel();

        tblDanhSachLopHoc.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tblDanhSachLopHoc.getSelectedRow();
                if (row != -1 && row < dsLopHoc.size()) {
                    LopHoc lh = dsLopHoc.get(row);
                    txtMaLop.setText(lh.getMaLop());
                    txtTenLop.setText(lh.getTenLop());
                    txtNienKhoa.setText(lh.getNienKhoa());
                    txtTenGiaoVien.setText(lh.getGiangVienDay() != null
                            ? lh.getGiangVienDay().getTenGV() : "");
                }
            }
        });

        tblDanhSachLopHoc.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                int col = tblDanhSachLopHoc.columnAtPoint(evt.getPoint());
                tblDanhSachLopHoc.setCursor(new Cursor(
                        col == 3 ? Cursor.HAND_CURSOR : Cursor.DEFAULT_CURSOR));
            }
        });

        tblDanhSachLopHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int dong = tblDanhSachLopHoc.rowAtPoint(evt.getPoint());
                int cot  = tblDanhSachLopHoc.columnAtPoint(evt.getPoint());
                if (cot == 3 && dong != -1) {
                    LopHoc lhChon = dsLopHoc.get(dong);
                    ManHinhDanhSachLop dlg = new ManHinhDanhSachLop(
                            ManHinhQuanLyLopHoc.this, true, dsLopHoc, lhChon);
                    dlg.setVisible(true);
                    fillTable();
                }
            }
        });

        // ── Load data ────────────────────────────────────────────────────
        dsLopHoc = (ArrayList<LopHoc>) (ArrayList) QuanLyFile.readFile(new File(FILE_PATH));
        if (dsLopHoc == null) dsLopHoc = new ArrayList<>();
        fillTable();

        pack();
    }

    // ── Fill table ────────────────────────────────────────────────────────
    public final void fillTable() {
        tableModel.setRowCount(0);
        String xemChiTiet = "<html><a href=''>Xem chi tiết</a></html>";
        for (LopHoc lh : dsLopHoc) {
            String tenGV = (lh.getGiangVienDay() != null) ? lh.getGiangVienDay().getTenGV() : "";
            tableModel.addRow(new Object[]{
                lh.getMaLop(), lh.getTenLop(), lh.getNienKhoa(),
                xemChiTiet, lh.getSiSo(), tenGV
            });
        }
    }

    // ── Button handlers ───────────────────────────────────────────────────
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String ma  = txtMaLop.getText().trim();
        String ten = txtTenLop.getText().trim();
        String kh  = txtNienKhoa.getText().trim();
        String gv  = txtTenGiaoVien.getText().trim();

        if (ma.isEmpty() || ten.isEmpty() || kh.isEmpty() || gv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin lớp học!");
            return;
        }
        try {
            dsLopHoc.add(new LopHoc(ma, ten, kh, new GiangVien("", gv, "", "", ""), new ArrayList<>()));
            QuanLyFile.ghiFile(new File(FILE_PATH), dsLopHoc);
            fillTable();
            clearForm();
            JOptionPane.showMessageDialog(this, "Thêm lớp học thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage());
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int index = tblDanhSachLopHoc.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một lớp học từ danh sách để sửa!");
            return;
        }
        String ten = txtTenLop.getText().trim();
        String kh  = txtNienKhoa.getText().trim();
        String gv  = txtTenGiaoVien.getText().trim();
        if (ten.isEmpty() || kh.isEmpty() || gv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin (Tên lớp, Khóa, Giáo viên)!");
            return;
        }
        try {
            LopHoc lh = dsLopHoc.get(index);
            lh.setTenLop(ten);
            lh.setNienKhoa(kh);
            lh.setGiangVienDay(new GiangVien("", gv, "", "", ""));
            QuanLyFile.ghiFile(new File(FILE_PATH), dsLopHoc);
            fillTable();
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin lớp học thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại: " + e.getMessage());
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        int index = tblDanhSachLopHoc.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một lớp học từ danh sách để xóa!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn xóa lớp này không?", "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dsLopHoc.remove(index);
            QuanLyFile.ghiFile(new File(FILE_PATH), dsLopHoc);
            fillTable();
            clearForm();
        }
    }

    private void clearForm() {
        txtMaLop.setText(""); txtTenLop.setText("");
        txtNienKhoa.setText(""); txtTenGiaoVien.setText("");
        txtMaLop.requestFocus();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new ManHinhQuanLyLopHoc().setVisible(true));
    }
}