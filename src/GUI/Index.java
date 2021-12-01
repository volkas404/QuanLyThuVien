package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

public class Index extends JFrame {
	JButton btntrangchu;
	JButton btnsach;
	JButton btndx;
	JButton btntheloai;
	JButton btndocgia;
	JButton btntacgia;
	JButton btnpm;
	JButton btnttv;
	JButton btnnhanvien;
	JButton btnncc;
	JButton btnphanquyen;
	JButton btnPhiuNhp;
	private JLabel lbhome , lbname; 
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_36;
	private JTextField textField_39;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_54;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Index() {
		
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 0, 0);
		setTitle("QUẢN LÝ THƯ VIỆN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 20, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,118,179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(200, 45, 800, 580);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		setUndecorated(true);
		final JPanel TrangChu_Form = new JPanel();
		layeredPane.add(TrangChu_Form, "name_14377048369500");
		TrangChu_Form.setLayout(null);
		
		JTextPane txtpnQunLTh = new JTextPane();
		txtpnQunLTh.setForeground(new Color(230, 230, 250));
		txtpnQunLTh.setBorder(emptyBorder);
		txtpnQunLTh.setBackground(new Color(0,0,0,0));
		txtpnQunLTh.setFont(new Font("Tahoma", Font.BOLD, 47));
		txtpnQunLTh.setText("QUẢN LÝ THƯ VIỆN");
		txtpnQunLTh.setBounds(87, 135, 516, 107);
		TrangChu_Form.add(txtpnQunLTh);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Index.class.getResource("../image/home.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 800, 580);
		TrangChu_Form.add(lblNewLabel_1);
		
		sach2 Sach_Form = new sach2();
		
		layeredPane.add(Sach_Form, "name_14515675934600");
		PhanQuyen_Form PhanQuyen_Form=new PhanQuyen_Form();
		layeredPane.add(PhanQuyen_Form, "name_1452354230200");

		TheLoai_Form TheLoai_Form= new TheLoai_Form();
		layeredPane.add(TheLoai_Form, "name_14523537300900");
		
		TheThuVien_Form TheThuVien_Form = new TheThuVien_Form();
		
		layeredPane.add(TheThuVien_Form, "name_14525038627700");
		
		
		NhaCungCap NhaCungCap_Form = new NhaCungCap();
		layeredPane.add(NhaCungCap_Form, "name_14528015892200");
		
		
		TacGia TacGia_Form = new TacGia();
		layeredPane.add(TacGia_Form, "name_14534235950100");
		
		DocGia DocGia_Form = new DocGia();
		
		layeredPane.add(DocGia_Form, "name_14535786644000");
		
		
		NhanVien NhanVien_Form = new NhanVien();
		
		layeredPane.add(NhanVien_Form, "name_14539219320300");
		
		PhieuMuon PhieuMuon_Form = new PhieuMuon();
		PhieuMuon_Form.setLayout(null);
		layeredPane.add(PhieuMuon_Form, "name_14543444391100");
		
		PhieuNhap PhieuNhap = new PhieuNhap();
//		
		layeredPane.add(PhieuNhap, "name_14536428453246");
		
		
		
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBounds(10, 2, 945, 803);
		PhieuMuon_Form.add(panel_18);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBounds(462, 473, 473, 319);
		panel_18.add(panel_4_2);
		
		JButton btnNewButton_6_2 = new JButton("Xóa");
		btnNewButton_6_2.setIcon(new ImageIcon(Index.class.getResource("./eraser.png")));
		btnNewButton_6_2.setBounds(127, 260, 107, 48);
		panel_4_2.add(btnNewButton_6_2);
		
		JButton btnNewButton_4_2 = new JButton("Thêm");
		btnNewButton_4_2.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
		btnNewButton_4_2.setBounds(10, 260, 107, 48);
		panel_4_2.add(btnNewButton_4_2);
		
		JButton btnNewButton_5_2 = new JButton("Sửa");
		btnNewButton_5_2.setIcon(new ImageIcon(Index.class.getResource("./edit.png")));
		btnNewButton_5_2.setBounds(356, 260, 107, 48);
		panel_4_2.add(btnNewButton_5_2);
		
		JButton btnNewButton_7_1 = new JButton("Tải lại");
		btnNewButton_7_1.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
		btnNewButton_7_1.setBounds(244, 260, 107, 48);
		panel_4_2.add(btnNewButton_7_1);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setLayout(null);
		panel_1_5.setBounds(10, 66, 489, 319);
		panel_18.add(panel_1_5);
		
		JTextPane txtpnMNv_1 = new JTextPane();
		txtpnMNv_1.setText("Mã NV");
		txtpnMNv_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMNv_1.setEditable(false);
		txtpnMNv_1.setBackground(SystemColor.menu);
		txtpnMNv_1.setBounds(20, 48, 94, 38);
		panel_1_5.add(txtpnMNv_1);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(124, 43, 232, 38);
		panel_1_5.add(textField_32);
		
		JButton btnNewButton_2_3 = new JButton("Tải lại");
		btnNewButton_2_3.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
		btnNewButton_2_3.setBounds(378, 239, 101, 56);
		panel_1_5.add(btnNewButton_2_3);
		
		JButton btnNewButton_3_2 = new JButton("Sửa");
		btnNewButton_3_2.setIcon(new ImageIcon(Index.class.getResource("./edit.png")));
		btnNewButton_3_2.setBounds(378, 172, 101, 56);
		panel_1_5.add(btnNewButton_3_2);
		
		JButton btnNewButton_11 = new JButton("Thêm");
		btnNewButton_11.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
		btnNewButton_11.setBounds(378, 30, 101, 56);
		panel_1_5.add(btnNewButton_11);
		
		JButton btnNewButton_1_9 = new JButton("Xóa");
		btnNewButton_1_9.setIcon(new ImageIcon(Index.class.getResource("./eraser.png")));
		btnNewButton_1_9.setBounds(378, 105, 101, 56);
		panel_1_5.add(btnNewButton_1_9);
		
		JButton btnNewButton_8_1 = new JButton("...");
		btnNewButton_8_1.setBounds(301, 211, 55, 38);
		panel_1_5.add(btnNewButton_8_1);
		
		JTextPane txtpnMNv_1_1 = new JTextPane();
		txtpnMNv_1_1.setText("Mã thẻ TV");
		txtpnMNv_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMNv_1_1.setEditable(false);
		txtpnMNv_1_1.setBackground(SystemColor.menu);
		txtpnMNv_1_1.setBounds(20, 102, 94, 38);
		panel_1_5.add(txtpnMNv_1_1);
		
		textField_51 = new JTextField();
		textField_51.setColumns(10);
		textField_51.setBounds(124, 97, 232, 38);
		panel_1_5.add(textField_51);
		
		JTextPane txtpnMNv_1_1_1 = new JTextPane();
		txtpnMNv_1_1_1.setText("Ngày mượn");
		txtpnMNv_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMNv_1_1_1.setEditable(false);
		txtpnMNv_1_1_1.setBackground(SystemColor.menu);
		txtpnMNv_1_1_1.setBounds(20, 156, 94, 38);
		panel_1_5.add(txtpnMNv_1_1_1);
		
		textField_52 = new JTextField();
		textField_52.setColumns(10);
		textField_52.setBounds(124, 151, 232, 38);
		panel_1_5.add(textField_52);
		
		JTextPane txtpnMNv_1_1_1_1 = new JTextPane();
		txtpnMNv_1_1_1_1.setText("Mã sách");
		txtpnMNv_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMNv_1_1_1_1.setEditable(false);
		txtpnMNv_1_1_1_1.setBackground(SystemColor.menu);
		txtpnMNv_1_1_1_1.setBounds(20, 216, 94, 38);
		panel_1_5.add(txtpnMNv_1_1_1_1);
		
		textField_53 = new JTextField();
		textField_53.setColumns(10);
		textField_53.setBounds(124, 211, 164, 38);
		panel_1_5.add(textField_53);
		
		textField_36 = new JTextField();
		textField_36.setText("");
		textField_36.setColumns(10);
		textField_36.setBounds(267, 418, 267, 33);
		panel_18.add(textField_36);
		
		JButton btnNewButton_9_2 = new JButton("Phạt");
		btnNewButton_9_2.setBounds(544, 415, 72, 36);
		panel_18.add(btnNewButton_9_2);
		
		JButton btnNewButton_10_1 = new JButton("Danh sách");
		btnNewButton_10_1.setBounds(626, 415, 110, 36);
		panel_18.add(btnNewButton_10_1);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(508, 66, 409, 319);
		panel_18.add(scrollPane_6);
		
		JTextPane txtpnTmKim_4 = new JTextPane();
		txtpnTmKim_4.setText("Tìm kiếm");
		txtpnTmKim_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnTmKim_4.setEditable(false);
		txtpnTmKim_4.setBackground(SystemColor.menu);
		txtpnTmKim_4.setBounds(167, 418, 90, 33);
		panel_18.add(txtpnTmKim_4);
		
		JTextPane txtpnPhiuMn = new JTextPane();
		txtpnPhiuMn.setText("Phiếu mượn");
		txtpnPhiuMn.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnPhiuMn.setEditable(false);
		txtpnPhiuMn.setBackground(SystemColor.menu);
		txtpnPhiuMn.setBounds(326, 11, 181, 44);
		panel_18.add(txtpnPhiuMn);
		
		JScrollPane scrollPane_1_2 = new JScrollPane();
		scrollPane_1_2.setBounds(10, 473, 442, 319);
		panel_18.add(scrollPane_1_2);
		
		DangNhap dn = new DangNhap();
		 lbname = new JLabel("");
		 lbname.setText(dn.tennv);
		 lbname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lbname.setBounds(840, 11, 150, 25);
		 contentPane.add(lbname);
		 lbhome = new JLabel("TRANG CHỦ");
		 lbhome.setFont(new Font("Tahoma", Font.BOLD, 16));
		 lbhome.setBounds(395, 8, 345, 35);
		 contentPane.add(lbhome);
		
		btntacgia = new JButton("  TÁC GIẢ");
		btntacgia.setBounds(15, 245, 175, 35);
		btntacgia.setIcon(new ImageIcon(Index.class.getResource("./writer.png")));
		btntacgia.setHorizontalAlignment(SwingConstants.LEFT);
		btntacgia.setBorder(emptyBorder);
		btntacgia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbhome.setText("TÁC GIẢ");
				TacGia TacGia_Form= new TacGia();
				layeredPane.removeAll();
				layeredPane.add(TacGia_Form);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btntacgia.setForeground(Color.BLACK);
		btntacgia.setFont(new Font("Arial", Font.BOLD, 15));
		btntacgia.setBackground(new Color(255, 160, 122));
		contentPane.add(btntacgia);
		
		btnncc = new JButton("  NHÀ CUNG CẤP");
		btnncc.setBounds(15, 205, 175, 35);
		btnncc.setIcon(new ImageIcon(Index.class.getResource("./company.png")));
		btnncc.setHorizontalAlignment(SwingConstants.LEFT);
		btnncc.setBorder(emptyBorder);
		btnncc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbhome.setText("NHÀ CUNG CẤP");
				NhaCungCap NhaCungCap_Form= new NhaCungCap();
				layeredPane.removeAll();
				layeredPane.add(NhaCungCap_Form);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnncc.setForeground(Color.BLACK);
		btnncc.setFont(new Font("Arial", Font.BOLD, 15));
		btnncc.setBackground(new Color(255, 160, 122));
		contentPane.add(btnncc);
		
		btnnhanvien = new JButton("  NHÂN VIÊN");
		btnnhanvien.setBounds(15, 325, 175, 35);
		btnnhanvien.setHorizontalAlignment(SwingConstants.LEFT);
		btnnhanvien.setIcon(new ImageIcon(Index.class.getResource("./steward.png")));
		btnnhanvien.setBorder(emptyBorder);
		btnnhanvien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbhome.setText("QUẢN LÝ NHÂN VIÊN");
				NhanVien NhanVien_Form= new NhanVien();
				layeredPane.removeAll();
				layeredPane.add(NhanVien_Form);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnnhanvien.setForeground(Color.BLACK);
		btnnhanvien.setFont(new Font("Arial", Font.BOLD, 15));
		btnnhanvien.setBackground(new Color(255, 160, 122));
		contentPane.add(btnnhanvien);
		
		btndocgia = new JButton("  ĐỘC GIẢ");
		btndocgia.setBounds(15, 285, 175, 35);
		btndocgia.setIcon(new ImageIcon(Index.class.getResource("./reader.png")));
		btndocgia.setHorizontalAlignment(SwingConstants.LEFT);
		btndocgia.setBorder(emptyBorder);
		btndocgia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbhome.setText("QUẢN LÝ ĐỘC GIẢ");
				DocGia DocGia_Form= new DocGia();
				layeredPane.removeAll();
				layeredPane.add(DocGia_Form);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btndocgia.setForeground(Color.BLACK);
		btndocgia.setFont(new Font("Arial", Font.BOLD, 15));
		btndocgia.setBackground(new Color(255, 160, 122));
		contentPane.add(btndocgia);
		
		btnttv = new JButton("  THẺ THƯ VIỆN");
		btnttv.setBounds(15, 165, 175, 35);
		btnttv.setIcon(new ImageIcon(Index.class.getResource("./barcode.png")));
		btnttv.setHorizontalAlignment(SwingConstants.LEFT);
		btnttv.setBorder(emptyBorder);
		btnttv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbhome.setText("THẺ THƯ VIỆN");
				TheThuVien_Form TheThuVien_Form= new TheThuVien_Form();
				layeredPane.removeAll();
				layeredPane.add(TheThuVien_Form);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnttv.setForeground(Color.BLACK);
		btnttv.setFont(new Font("Arial", Font.BOLD, 15));
		btnttv.setBackground(new Color(255, 160, 122));
		contentPane.add(btnttv);
		
		btntheloai = new JButton("  THỂ LOẠI");
		btntheloai.setBounds(15, 125, 175, 35);
		btntheloai.setIcon(new ImageIcon(Index.class.getResource("./category.png")));
		btntheloai.setHorizontalAlignment(SwingConstants.LEFT);
		btntheloai.setBorder(emptyBorder);
		btntheloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbhome.setText("THỂ LOẠI SÁCH");
				TheLoai_Form TheLoai_Form= new TheLoai_Form();
				layeredPane.removeAll();
				layeredPane.add(TheLoai_Form);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btntheloai.setForeground(Color.BLACK);
		btntheloai.setFont(new Font("Arial", Font.BOLD, 15));
		btntheloai.setBackground(new Color(255, 160, 122));
		contentPane.add(btntheloai);
		
		btnpm = new JButton("  PHIẾU M-T");
		btnpm.setBounds(15, 405, 175, 35);
		btnpm.setHorizontalAlignment(SwingConstants.LEFT);
		btnpm.setIcon(new ImageIcon(Index.class.getResource("./phieutra.png")));
		btnpm.setBorder(emptyBorder);
		btnpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbhome.setText("QUẢN LÝ PHIẾU MƯỢN - TRẢ SÁCH");
				PhieuMuon PhieuMuon_Form= new PhieuMuon();
				layeredPane.removeAll();
				layeredPane.add(PhieuMuon_Form);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnpm.setForeground(Color.BLACK);
		btnpm.setFont(new Font("Arial", Font.BOLD, 15));
		btnpm.setBackground(new Color(255, 160, 122));
		contentPane.add(btnpm);
		
		btnphanquyen = new JButton("  PHÂN QUYỀN");
		btnphanquyen.setBounds(15, 365, 175, 35);
		btnphanquyen.setBorder(emptyBorder);
		btnphanquyen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhanQuyen_Form PhanQuyen_Form= new PhanQuyen_Form();
				layeredPane.removeAll();
				layeredPane.add(PhanQuyen_Form);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnphanquyen.setIcon(new ImageIcon(Index.class.getResource("./phieunhap.png")));
		btnphanquyen.setHorizontalAlignment(SwingConstants.LEFT);
		btnphanquyen.setForeground(Color.BLACK);
		btnphanquyen.setFont(new Font("Arial", Font.BOLD, 15));
		btnphanquyen.setBackground(new Color(255, 160, 122));
		contentPane.add(btnphanquyen);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,118,179));
		panel.setBounds(0, 45, 191, 580);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		btntrangchu = new JButton("  TRANG CHỦ");
		btntrangchu.setBounds(15, 0, 175, 35);
		panel.add(btntrangchu);
		btntrangchu.setHorizontalAlignment(SwingConstants.LEFT);
		btntrangchu.setIcon(new ImageIcon(Index.class.getResource("./home.png")));
		btntrangchu.setBorder(emptyBorder);
		btntrangchu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbhome.setText("TRANG CHỦ");
				layeredPane.removeAll();
				layeredPane.add(TrangChu_Form);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btntrangchu.setForeground(Color.BLACK);
		btntrangchu.setFont(new Font("Arial", Font.BOLD, 15));
		btntrangchu.setBackground(new Color(255, 160, 122));
		
		 btnsach = new JButton("  SÁCH");
		 btnsach.setBounds(15, 40, 175, 35);
		 panel.add(btnsach);
		 btnsach.setHorizontalAlignment(SwingConstants.LEFT);
		 btnsach.setIcon(new ImageIcon(Index.class.getResource("./open-book.png")));
		 btnsach.setBorder(emptyBorder);
		 btnsach.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		lbhome.setText("QUẢN LÝ SÁCH");
		 		sach2 Sach_Form= new sach2();
		 		layeredPane.removeAll();
		 		layeredPane.add(Sach_Form);
		 		layeredPane.repaint();
		 		layeredPane.revalidate();
		 	}
		 });
		 
		 btnsach.setForeground(Color.BLACK);
		 btnsach.setFont(new Font("Arial", Font.BOLD, 15));
		 btnsach.setBackground(new Color(255, 160, 122));
		 
		 btndx = new JButton("  ĐĂNG XUẤT");
		 btndx.setBounds(15, 440, 175, 35);
		 panel.add(btndx);
		 btndx.setHorizontalAlignment(SwingConstants.LEFT);
		 btndx.setIcon(new ImageIcon(Index.class.getResource("./logout.png")));
		 btndx.setBorder(emptyBorder);
		 btndx.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 			DangNhap dn = new DangNhap();
		 			dn.setVisible(true);
		 			dn.setLocationRelativeTo(null);
		 			dispose();
		 		setVisible(false);
		 	}
		 });
		 btndx.setForeground(Color.BLACK);
		 btndx.setFont(new Font("Arial", Font.BOLD, 17));
		 btndx.setBackground(new Color(255, 160, 122));
		 
		 btnPhiuNhp = new JButton("  PHIẾU NHẬP");
		 btnPhiuNhp.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		lbhome.setText("NHẬP SÁCH MỚI");
				PhieuNhap phieunhap= new PhieuNhap();
				layeredPane.removeAll();
				layeredPane.add(phieunhap);
				layeredPane.repaint();
				layeredPane.revalidate();
		 	}
		 });
		 btnPhiuNhp.setBounds(15, 400, 175, 35);
		 btnPhiuNhp.setBorder(emptyBorder);
		 btnPhiuNhp.setIcon(new ImageIcon(Index.class.getResource("./phieutra.png")));
		 btnPhiuNhp.setHorizontalAlignment(SwingConstants.LEFT);
		 btnPhiuNhp.setForeground(Color.BLACK);
		 btnPhiuNhp.setFont(new Font("Arial", Font.BOLD, 15));
		 btnPhiuNhp.setBackground(new Color(255, 160, 122));
		 panel.add(btnPhiuNhp);
		 
	}
}
