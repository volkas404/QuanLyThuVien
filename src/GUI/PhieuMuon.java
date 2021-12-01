package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BUS.CTPhieuMuonBUS;
import BUS.DocGiaBUS;
import BUS.NhanVienBUS;
import BUS.PhieuMuonBUS;
import BUS.SachBUS;
import BUS.TheLoaiBUS;
import BUS.TheThuVienBUS;
import DAO.TheThuVienDAO;
import DTO.CTPhieuMuon;
import DTO.DocGiaDTO;
import DTO.NhanVienDTO;
import DTO.PhieuMuonDTO;
import DTO.SachDTO;
import DTO.TheLoaiDTO;
import DTO.TheThuVienDTO;
import exportExel.export;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;

public class PhieuMuon extends JPanel {
	File fileAnhSP;
	ArrayList<TheThuVienDTO> thethuvien=new ArrayList<>();
	ArrayList<Object> thethuvien_tt=new ArrayList<>();
	ArrayList<SachDTO> masach=new ArrayList<>();
	ArrayList<TheThuVienDTO> thethuvien_ma=new ArrayList<>();
	ArrayList<PhieuMuonDTO> phieumuon=new ArrayList<>();
	ArrayList<CTPhieuMuon> ctphieumuon_ma=new ArrayList<>();
	ArrayList<CTPhieuMuon> ctphieumuon=new ArrayList<>();
	ArrayList<SachDTO> sach=new ArrayList<>();
	ArrayList<TheLoaiDTO> theloai=new ArrayList<>();
	Vector<String> thethuvien1= new Vector<>();
	Vector<String> sach1= new Vector<>();
	JTable table;
	private JTextField textField_36, txtmasach,txttheloai;
	DefaultTableModel model,model_1;
	JTable table1;
	DefaultTableModel model1,model_2;
	private JButton btnexport, btntrasach;
	private JTextField txttensach;
	private JTextField txtmanv;
	private int dem=1;
	private JTable table_1;
	private JTable table_2;
	private JTextField txtmhd;
	private JTextField txtmnv;
	private JTextField txtmttv;
	private JTextField txtnm;
	private JTextField txtnt;
	private JTextField txtms;
	private JTextField txtts;
	private JTextField txttl;
	private JTextField txtsoluong;
	private JTextField txttt;
	private JLabel lblNewLabel_3;
	/**
	/**
	 * Create the panel.
	 */
	public PhieuMuon() {
		
		setBackground(UIManager.getColor("Panel.background"));
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
		
		setBounds(100, 100, 774, 627);
		
		
		setLayout(null);
		TheThuVienBUS ttvb= new TheThuVienBUS();
		thethuvien=ttvb.danhsach();
		thethuvien1.add("Option...");
		for(TheThuVienDTO ttv:thethuvien) {
			thethuvien1.add(String.valueOf(ttv.getMathetv()));
		}
		SachBUS sb= new SachBUS();
		sach=sb.danhsach();
		SachDTO s = new SachDTO();
		sach1.add("Option...");
		for(SachDTO s1:sach) {
			sach1.add(String.valueOf(s1.getMasach()));
		}
		DangNhap dn= new DangNhap();
		
		model1= new DefaultTableModel();
		model1.addColumn("Mã Sách");
		model1.addColumn("Tên Sách");
		model1.addColumn("Thể Loại");
		model1.addColumn("Số Lượng");
		model1.addColumn("Hình Ảnh");
		
		model= new DefaultTableModel();
		model.addColumn("STT");
		model.addColumn("Mã Sách");
		model.addColumn("Tên Sách");
		model.addColumn("Số Lượng");
		model.addColumn("Thể Loại");
		
		final JPanel PhieuTra_Form = new JPanel();
		PhieuTra_Form.setLayout(null);
		add(PhieuTra_Form, "name_14545921437400");
		
		JPanel panel_19 = new JPanel();
		panel_19.setLayout(null);
		panel_19.setBounds(10, 11, 945, 804);
		PhieuTra_Form.add(panel_19);
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setLayout(null);
		panel_4_3.setBounds(467, 487, 468, 306);
		panel_19.add(panel_4_3);
		
		JTextPane txtpnMSch_3 = new JTextPane();
		txtpnMSch_3.setText("SL sách");
		txtpnMSch_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3.setEditable(false);
		txtpnMSch_3.setBackground(SystemColor.menu);
		txtpnMSch_3.setBounds(10, 28, 82, 25);
		panel_4_3.add(txtpnMSch_3);
		
		JTextField textField_39 = new JTextField();
		textField_39.setColumns(10);
		textField_39.setBounds(102, 22, 233, 31);
		panel_4_3.add(textField_39);
		
		JButton btnNewButton_8_2 = new JButton("...");
		btnNewButton_8_2.setBounds(354, 21, 83, 32);
		panel_4_3.add(btnNewButton_8_2);
		
		JButton btnNewButton_6_3 = new JButton("Xóa");
		btnNewButton_6_3.setIcon(new ImageIcon(Index.class.getResource("./eraser.png")));
		btnNewButton_6_3.setBounds(240, 238, 103, 38);
		panel_4_3.add(btnNewButton_6_3);
		
		JButton btnNewButton_4_3 = new JButton("Thêm");
		btnNewButton_4_3.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
		btnNewButton_4_3.setBounds(10, 238, 103, 38);
		panel_4_3.add(btnNewButton_4_3);
		
		JButton btnNewButton_5_3 = new JButton("Sửa");
		btnNewButton_5_3.setIcon(new ImageIcon(Index.class.getResource("./edit.png")));
		btnNewButton_5_3.setBounds(127, 238, 103, 38);
		panel_4_3.add(btnNewButton_5_3);
		
		JButton btnNewButton_7_2 = new JButton("Tải lại");
		btnNewButton_7_2.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
		btnNewButton_7_2.setBounds(353, 238, 103, 38);
		panel_4_3.add(btnNewButton_7_2);
		
		JTextPane txtpnMSch_3_1 = new JTextPane();
		txtpnMSch_3_1.setText("Ngày trả");
		txtpnMSch_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1.setEditable(false);
		txtpnMSch_3_1.setBackground(SystemColor.menu);
		txtpnMSch_3_1.setBounds(10, 78, 82, 25);
		panel_4_3.add(txtpnMSch_3_1);
		
		JTextField textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(102, 72, 335, 31);
		panel_4_3.add(textField_33);
		
		JTextPane txtpnMSch_3_2 = new JTextPane();
		txtpnMSch_3_2.setText("Ghi chú");
		txtpnMSch_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_2.setEditable(false);
		txtpnMSch_3_2.setBackground(SystemColor.menu);
		txtpnMSch_3_2.setBounds(10, 120, 82, 25);
		panel_4_3.add(txtpnMSch_3_2);
		
		JTextField textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(102, 114, 335, 113);
		panel_4_3.add(textField_34);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setLayout(null);
		panel_1_6.setBounds(10, 66, 512, 362);
		panel_19.add(panel_1_6);
		
		JButton btnNewButton_2_4 = new JButton("Tải lại");
		btnNewButton_2_4.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
		btnNewButton_2_4.setBounds(401, 300, 101, 40);
		panel_1_6.add(btnNewButton_2_4);
		
		JButton btnNewButton_3_3 = new JButton("Sửa");
		btnNewButton_3_3.setIcon(new ImageIcon(Index.class.getResource("./edit.png")));
		btnNewButton_3_3.setBounds(141, 300, 101, 40);
		panel_1_6.add(btnNewButton_3_3);
		
		JButton btnNewButton_12 = new JButton("Thêm");
		btnNewButton_12.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
		btnNewButton_12.setBounds(10, 300, 101, 40);
		panel_1_6.add(btnNewButton_12);
		
		JButton btnNewButton_1_10 = new JButton("Xóa");
		btnNewButton_1_10.setIcon(new ImageIcon(Index.class.getResource("./eraser.png")));
		btnNewButton_1_10.setBounds(278, 300, 101, 40);
		panel_1_6.add(btnNewButton_1_10);
		
		JTextPane txtpnMSch_3_1_1 = new JTextPane();
		txtpnMSch_3_1_1.setText("Mã PT");
		txtpnMSch_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1_1.setEditable(false);
		txtpnMSch_3_1_1.setBackground(SystemColor.menu);
		txtpnMSch_3_1_1.setBounds(10, 19, 94, 25);
		panel_1_6.add(txtpnMSch_3_1_1);
		
		JTextField textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(114, 17, 351, 40);
		panel_1_6.add(textField_35);
		
		JTextPane txtpnMSch_3_1_1_1 = new JTextPane();
		txtpnMSch_3_1_1_1.setText("Mã NV");
		txtpnMSch_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1_1_1.setEditable(false);
		txtpnMSch_3_1_1_1.setBackground(SystemColor.menu);
		txtpnMSch_3_1_1_1.setBounds(10, 86, 94, 25);
		panel_1_6.add(txtpnMSch_3_1_1_1);
		
		JTextField textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(114, 84, 351, 40);
		panel_1_6.add(textField_37);
		
		JTextPane txtpnMSch_3_1_1_2 = new JTextPane();
		txtpnMSch_3_1_1_2.setText("Mã thẻ TV");
		txtpnMSch_3_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1_1_2.setEditable(false);
		txtpnMSch_3_1_1_2.setBackground(SystemColor.menu);
		txtpnMSch_3_1_1_2.setBounds(10, 153, 94, 25);
		panel_1_6.add(txtpnMSch_3_1_1_2);
		
		JTextField textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(114, 151, 351, 40);
		panel_1_6.add(textField_38);
		
		JTextPane txtpnMSch_3_1_1_3 = new JTextPane();
		txtpnMSch_3_1_1_3.setText("Ngày trả");
		txtpnMSch_3_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMSch_3_1_1_3.setEditable(false);
		txtpnMSch_3_1_1_3.setBackground(SystemColor.menu);
		txtpnMSch_3_1_1_3.setBounds(10, 221, 94, 25);
		panel_1_6.add(txtpnMSch_3_1_1_3);
		
		JTextField textField_54 = new JTextField();
		textField_54.setColumns(10);
		textField_54.setBounds(114, 219, 351, 40);
		panel_1_6.add(textField_54);
		
		JTextField textField_44 = new JTextField();
		textField_44.setText("");
		textField_44.setColumns(10);
		textField_44.setBounds(180, 439, 390, 37);
		panel_19.add(textField_44);
		
		JButton btnNewButton_9_3 = new JButton("Phạt");
		btnNewButton_9_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_9_3.setBounds(580, 436, 72, 40);
		panel_19.add(btnNewButton_9_3);
		
		JButton btnNewButton_10_2 = new JButton("Danh sách");
		btnNewButton_10_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_10_2.setBounds(662, 436, 110, 40);
		panel_19.add(btnNewButton_10_2);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(4, 487, 453, 306);
		panel_19.add(scrollPane_7);
		
		JScrollPane scrollPane_1_3 = new JScrollPane();
		scrollPane_1_3.setBounds(532, 66, 403, 359);
		panel_19.add(scrollPane_1_3);
		
		JTextPane txtpnTmKim_5 = new JTextPane();
		txtpnTmKim_5.setText("Tìm kiếm");
		txtpnTmKim_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnTmKim_5.setEditable(false);
		txtpnTmKim_5.setBackground(SystemColor.menu);
		txtpnTmKim_5.setBounds(94, 439, 90, 37);
		panel_19.add(txtpnTmKim_5);
		model.setRowCount(0);
		JTextPane txtpnPhiuMn_1 = new JTextPane();
		txtpnPhiuMn_1.setText("Phiếu trả");
		txtpnPhiuMn_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnPhiuMn_1.setEditable(false);
		txtpnPhiuMn_1.setBackground(SystemColor.menu);
		txtpnPhiuMn_1.setBounds(399, 11, 181, 44);
		panel_19.add(txtpnPhiuMn_1);
		
		JPanel DangXuat = new JPanel();
		DangXuat.setLayout(null);
		add(DangXuat, "name_14548034441000");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 774, 661);
		add(tabbedPane);
		JPanel panel_18 = new JPanel();
		tabbedPane.addTab("Phiếu Mượn", null, panel_18, null);
		panel_18.setLayout(null);
		
		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBackground(Color.WHITE);
		panel_4_2.setBounds(460, 331, 299, 183);
		panel_18.add(panel_4_2);
		panel_4_2.setLayout(null);
		
		JComboBox cpbmattv = new JComboBox(thethuvien1);
		cpbmattv.setBounds(90, 40, 199, 22);
		panel_4_2.add(cpbmattv);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBackground(Color.WHITE);
		panel_1_5.setLayout(null);
		panel_1_5.setBounds(460, 205, 299, 117);
		panel_18.add(panel_1_5);
		
	    txtmasach = new JTextField();
	    txtmasach.setEnabled(false);
	    txtmasach.setColumns(10);
	    txtmasach.setBounds(90, 11, 199, 22);
	    panel_1_5.add(txtmasach);
	    
	    txttheloai = new JTextField();
	    txttheloai.setEnabled(false);
	    txttheloai.setColumns(10);
	    txttheloai.setBounds(90, 83, 199, 22);
	    panel_1_5.add(txttheloai);
	    
	    JTextPane txtpnMNv_1_2 = new JTextPane();
	    txtpnMNv_1_2.setText("Mã sách");
	    txtpnMNv_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    txtpnMNv_1_2.setEditable(false);
	    txtpnMNv_1_2.setBackground(Color.WHITE);
	    txtpnMNv_1_2.setBounds(10, 11, 70, 25);
	    panel_1_5.add(txtpnMNv_1_2);
	    
	    JTextPane txtpnMNv_1_2_1 = new JTextPane();
	    txtpnMNv_1_2_1.setText("Tên sách");
	    txtpnMNv_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    txtpnMNv_1_2_1.setEditable(false);
	    txtpnMNv_1_2_1.setBackground(Color.WHITE);
	    txtpnMNv_1_2_1.setBounds(10, 47, 70, 25);
	    panel_1_5.add(txtpnMNv_1_2_1);
	    
	    JTextPane txtpnMNv_1_2_2 = new JTextPane();
	    txtpnMNv_1_2_2.setText("Thể loại");
	    txtpnMNv_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    txtpnMNv_1_2_2.setEditable(false);
	    txtpnMNv_1_2_2.setBackground(Color.WHITE);
	    txtpnMNv_1_2_2.setBounds(10, 83, 70, 25);
	    panel_1_5.add(txtpnMNv_1_2_2);
	    
	    txttensach = new JTextField();
	    txttensach.setEnabled(false);
	    txttensach.setColumns(10);
	    txttensach.setBounds(90, 47, 199, 22);
	    panel_1_5.add(txttensach);
	    
	    textField_36 = new JTextField();
	    
	    textField_36.setText("");
	    textField_36.setColumns(10);
	    textField_36.setBounds(176, 15, 409, 33);
	    panel_18.add(textField_36);
	    
	    JScrollPane scrollPane_6 = new JScrollPane();
	    table1= new JTable();
	    table1.setModel(model1);
	    scrollPane_6.setViewportView(table1);
	    scrollPane_6.setBounds(10, 80, 435, 205);
	    panel_18.add(scrollPane_6);
	    
	    JTextPane txtpnTmKim_4 = new JTextPane();
	    txtpnTmKim_4.setText("Tìm kiếm");
	    txtpnTmKim_4.setFont(new Font("Tahoma", Font.BOLD, 13));
	    txtpnTmKim_4.setEditable(false);
	    txtpnTmKim_4.setBackground(UIManager.getColor("Panel.background"));
	    txtpnTmKim_4.setBounds(71, 15, 90, 33);
	    panel_18.add(txtpnTmKim_4);
	    
	    JScrollPane scrollPane_1_2 = new JScrollPane();
	    table = new JTable();
	    table.setModel(model);
	    scrollPane_1_2.setViewportView(table);
	    scrollPane_1_2.setBounds(10, 341, 435, 173);
	    panel_18.add(scrollPane_1_2);
	    JButton phieutra = new JButton("Trả Sách");
	    
	    phieutra.setFont(new Font("Tahoma", Font.BOLD, 14));
	    phieutra.setBounds(310, 54, 112, 38);
	    panel_4_2.add(phieutra);
	    phieutra.setEnabled(false);
	    JButton btnNewButton_2_3 = new JButton("Xóa");
	    btnNewButton_2_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(table.getRowCount()<1) {
	    			JOptionPane.showMessageDialog(null,"Bạn cần chọn ít nhất 1 cuốn sách!");
	    			return;
	    		}
	    		int i= table.getSelectedRow();
	    		if(i<0) {
	    			JOptionPane.showMessageDialog(null,"Bạn cần chọn sách cần xóa!");
	    			return;
	    		}
	    		
	    		model.removeRow(i);
	    		if(table.getRowCount()<1) {
	    			
	    			btnexport.setEnabled(false);
	    		}
	    	}
	    });
	    btnNewButton_2_3.setBounds(165, 87, 94, 25);
	    panel_4_2.add(btnNewButton_2_3);
	    btnNewButton_2_3.setFont(new Font("Tahoma", Font.BOLD, 13));
	    btnNewButton_2_3.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
	    
	    JButton btnNewButton_2_3_1 = new JButton("Tạo Hóa Đơn");
	    btnNewButton_2_3_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    		if(table.getRowCount()<1) {
	    			JOptionPane.showMessageDialog(null,"Bạn cần có ít nhất 1 cuốn sách trong phiểu mượn!");
	    			return;
	    		}

	    		if(cpbmattv.getSelectedIndex() ==0) {
	    			JOptionPane.showMessageDialog(null,"Bạn chưa chọn độc giả để mượn kìaaaaaa!");
	    			return;
	    		}
	    		
	    		int manv = Integer.parseInt(txtmanv.getText());
	    		int mattv = Integer.parseInt(String.valueOf(cpbmattv.getSelectedItem()));
	    		Date ngaymuon = new Date();
	    		long nowOther = System.currentTimeMillis();
	    		long ngaytra1 = nowOther + (24*60*60)*10;
	    		Date ngaytra = new Date(ngaytra1);
	    		
	    		PhieuMuonDTO pm =  new PhieuMuonDTO();
	    		pm.setManv(manv);
	    		pm.setMathetv(mattv);
	    		pm.setNgaymuon(ngaymuon);
	    		pm.setNgaytra(ngaytra);
	    		pm.setTinhtrang(1);
	    		try {
	    			int tt= new TheThuVienBUS().danhsach_tt(Integer.parseInt(String.valueOf(cpbmattv.getSelectedItem())));
	    			if(tt == 1) {
	    				JOptionPane.showMessageDialog(null,"Độc giả này chưa trả sách nha!");
	    				return;
	    			}
	    			if(new PhieuMuonBUS().add(pm)) {
	    				phieumuon = new PhieuMuonBUS().danhsach();
	    				int mapm = phieumuon.get(phieumuon.size()-1).getMapm();
	    				CTPhieuMuon ctpm= new CTPhieuMuon();
	    				
	    				for(int i=0;i<table.getRowCount();i++) {
	    					ctpm.setMapm(mapm);
	    					ctpm.setMasach(Integer.parseInt((String) model.getValueAt(i, 1)));
	    					new CTPhieuMuonBUS().add(ctpm);
	    					for(SachDTO s: sach) {
	    						if(s.getSoluong()!=0) {
	    							if(String.valueOf(s.getMasach()).equals(model.getValueAt(i, 1).toString())) {
			    						new SachBUS().edit_sl(s.getSoluong()-1,Integer.parseInt((String) model.getValueAt(i, 1)));
			    					}
	    						}
	    					}	
	    				}
	    				
	    				TheThuVienDTO ttv = new TheThuVienDTO();
	    				ttv.setMathetv(Integer.parseInt(String.valueOf(cpbmattv.getSelectedItem())));
	    				ttv.setTinhtrang(1);
	    				
	    				if(new TheThuVienBUS().edit_tt(ttv)) {
	    					JOptionPane.showMessageDialog(null,"Tạo phiếu mượn thành công");
		    				model.setRowCount(0);
		    				hienthi();
		    				txtmasach.setText("");
		    				txttensach.setText("");
		    				txttheloai.setText("");
		    				cpbmattv.setSelectedIndex(0);
		    				btnexport.setEnabled(false);
		    				return;

	    				}
	    					    				
	    			}
	    		} catch (Exception e1) {
	    			// TODO Auto-generated catch block
	    			e1.printStackTrace();
	    		}
	    		JOptionPane.showMessageDialog(null,"Tạo phiếu mượn thất bại");
	    		
	    	}
	    });
	    btnNewButton_2_3_1.setBounds(35, 138, 124, 25);
	    panel_4_2.add(btnNewButton_2_3_1);
	    btnNewButton_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
	    
	    JTextPane txtpnMNv_1_2_4 = new JTextPane();
	    txtpnMNv_1_2_4.setText("Mã NV");
	    txtpnMNv_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    txtpnMNv_1_2_4.setEditable(false);
	    txtpnMNv_1_2_4.setBackground(Color.WHITE);
	    txtpnMNv_1_2_4.setBounds(10, 10, 70, 25);
	    panel_4_2.add(txtpnMNv_1_2_4);
	    
	    JTextPane txtpnMNv_1_2_5 = new JTextPane();
	    txtpnMNv_1_2_5.setText("Mã TTV");
	    txtpnMNv_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    txtpnMNv_1_2_5.setEditable(false);
	    txtpnMNv_1_2_5.setBackground(Color.WHITE);
	    txtpnMNv_1_2_5.setBounds(10, 40, 70, 25);
	    panel_4_2.add(txtpnMNv_1_2_5);
	    
	    txtmanv = new JTextField();
	    txtmanv.setText("1");
	    txtmanv.setEnabled(false);
	    txtmanv.setColumns(10);
	    txtmanv.setBounds(90, 10, 199, 22);
	    panel_4_2.add(txtmanv);
	    
	    
	     btnexport = new JButton("Export");
	     btnexport.setEnabled(false);
	    btnexport.setFont(new Font("Tahoma", Font.BOLD, 13));
	    btnexport.setBounds(165, 138, 94, 25);
	    panel_4_2.add(btnexport);
	    btnexport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				export.exportExcel(table);
			}
		});
	    
	    JButton btnThempm = new JButton("Thêm");
	    btnThempm.setBounds(35, 87, 94, 25);
	    panel_4_2.add(btnThempm);
	    btnThempm.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int i = table1.getSelectedRow();
	    		
	    		if(i<0) {
	    			JOptionPane.showMessageDialog(null,"Bạn chưa lựa chọn sách!");
	    			return;
	    		}
	    		
	    		if(table.getRowCount()>0) {
	    			for(int j=0;j<table.getRowCount();j++) {
	    				if(table.getValueAt(j, 2).toString().equals(txttensach.getText())) {
	    					JOptionPane.showMessageDialog(null,"Bạn chỉ được mượn 1 loại sách / lần");
	    					return;
	    				}
	    			}
	    		}
	    		
	    		
	    		model.addRow(new Object[] {
	    				dem++,txtmasach.getText(),txttensach.getText(),txttheloai.getText(),1
	    		});
	    		if(table.getRowCount()==1) {
	    			btnexport.setEnabled(true);
	    		}
	    		
	    	}
	    });
	    btnThempm.setFont(new Font("Tahoma", Font.BOLD, 13));
	    
	    btnThempm.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
	    
	    JSeparator separator = new JSeparator();
	    separator.setBounds(0, 103, 846, -1);
	    panel_18.add(separator);
	    
	    JSeparator separator_1 = new JSeparator();
	    separator_1.setBounds(10, 463, 846, -1);
	    panel_18.add(separator_1);
	    
	    JLabel lblNewLabel = new JLabel("SÁCH");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel.setForeground(new Color(0, 0, 0));
	    lblNewLabel.setBounds(186, 50, 111, 30);
	    panel_18.add(lblNewLabel);
	    
	    JLabel lblThngTinPhiu = new JLabel("THÔNG TIN PHIẾU MƯỢN");
	    lblThngTinPhiu.setForeground(Color.BLACK);
	    lblThngTinPhiu.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblThngTinPhiu.setBounds(135, 295, 205, 35);
	    panel_18.add(lblThngTinPhiu);
	    
	    lblNewLabel_3 = new JLabel("");
	    lblNewLabel_3.setBounds(507, 80, 213, 117);
	    lblNewLabel_3.setIcon(new ImageIcon(PhieuMuon.class.getResource("/image/justice_4.png")));
	    panel_18.add(lblNewLabel_3);
	    
	    JPanel panel = new JPanel();
	    tabbedPane.addTab("Phiếu Trả", null, panel, null);
	    panel.setLayout(null);
	    
	    JSeparator separator_2 = new JSeparator();
	    separator_2.setBackground(Color.BLACK);
	    separator_2.setBounds(358, 47, 9, 552);
	    panel.add(separator_2);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(Color.WHITE);
	    panel_1.setBounds(10, 47, 333, 215);
	    panel.add(panel_1);
	    panel_1.setLayout(null);
	    
	    JLabel lb1 = new JLabel("Mã HĐ");
	    lb1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lb1.setForeground(new Color(0, 0, 0));
	    lb1.setBounds(27, 11, 84, 32);
	    panel_1.add(lb1);
	    
	    JLabel lb2 = new JLabel("Mã NV");
	    lb2.setForeground(Color.BLACK);
	    lb2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lb2.setBounds(27, 42, 84, 32);
	    panel_1.add(lb2);
	    
	    JLabel lb3 = new JLabel("Mã TTV");
	    lb3.setForeground(Color.BLACK);
	    lb3.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lb3.setBounds(27, 73, 84, 32);
	    panel_1.add(lb3);
	    
	    JLabel lb4 = new JLabel("Ngày mượn");
	    lb4.setForeground(Color.BLACK);
	    lb4.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lb4.setBounds(27, 107, 84, 32);
	    panel_1.add(lb4);
	    
	    JLabel lb5 = new JLabel("Ngày trả");
	    lb5.setForeground(Color.BLACK);
	    lb5.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lb5.setBounds(27, 137, 84, 32);
	    panel_1.add(lb5);
	    
	    txtmhd = new JTextField();
	    txtmhd.setEditable(false);
	    txtmhd.setBounds(122, 18, 180, 20);
	    panel_1.add(txtmhd);
	    txtmhd.setColumns(10);
	    
	    txtmnv = new JTextField();
	    txtmnv.setEditable(false);
	    txtmnv.setColumns(10);
	    txtmnv.setBounds(121, 49, 180, 20);
	    panel_1.add(txtmnv);
	    
	    txtmttv = new JTextField();
	    txtmttv.setEditable(false);
	    txtmttv.setColumns(10);
	    txtmttv.setBounds(121, 80, 180, 20);
	    panel_1.add(txtmttv);
	    
	    txtnm = new JTextField();
	    txtnm.setEditable(false);
	    txtnm.setColumns(10);
	    txtnm.setBounds(121, 114, 180, 20);
	    panel_1.add(txtnm);
	    
	    txtnt = new JTextField();
	    txtnt.setEditable(false);
	    txtnt.setColumns(10);
	    txtnt.setBounds(121, 144, 180, 20);
	    panel_1.add(txtnt);
	    
	    JLabel lblTnhTrng = new JLabel("Tình trạng");
	    lblTnhTrng.setForeground(Color.BLACK);
	    lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblTnhTrng.setBounds(27, 170, 84, 32);
	    panel_1.add(lblTnhTrng);
	    
	    txttt = new JTextField();
	    txttt.setEditable(false);
	    txttt.setColumns(10);
	    txttt.setBounds(122, 177, 180, 20);
	    panel_1.add(txttt);
	    
	    JPanel panel_1_1 = new JPanel();
	    panel_1_1.setBackground(Color.WHITE);
	    panel_1_1.setBounds(392, 47, 350, 172);
	    panel.add(panel_1_1);
	    panel_1_1.setLayout(null);
	    
	    JLabel lb6 = new JLabel("Mã HĐ");
	    lb6.setForeground(Color.BLACK);
	    lb6.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lb6.setBounds(20, 11, 84, 32);
	    panel_1_1.add(lb6);
	    
	    JLabel lb7 = new JLabel("Tên sách");
	    lb7.setForeground(Color.BLACK);
	    lb7.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lb7.setBounds(20, 51, 84, 32);
	    panel_1_1.add(lb7);
	    
	    JLabel lb8 = new JLabel("Thể Loại");
	    lb8.setForeground(Color.BLACK);
	    lb8.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lb8.setBounds(20, 92, 84, 32);
	    panel_1_1.add(lb8);
	    
	    JLabel lb9 = new JLabel("Số lượng");
	    lb9.setForeground(Color.BLACK);
	    lb9.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lb9.setBounds(20, 130, 84, 32);
	    panel_1_1.add(lb9);
	    
	    txtms = new JTextField();
	    txtms.setEditable(false);
	    txtms.setColumns(10);
	    txtms.setBounds(107, 18, 180, 20);
	    panel_1_1.add(txtms);
	    
	    txtts = new JTextField();
	    txtts.setEditable(false);
	    txtts.setColumns(10);
	    txtts.setBounds(107, 54, 180, 20);
	    panel_1_1.add(txtts);
	    
	    txttl = new JTextField();
	    txttl.setEditable(false);
	    txttl.setColumns(10);
	    txttl.setBounds(107, 94, 180, 20);
	    panel_1_1.add(txttl);
	    
	    txtsoluong = new JTextField();
	    txtsoluong.setEditable(false);
	    txtsoluong.setColumns(10);
	    txtsoluong.setBounds(107, 135, 180, 20);
	    panel_1_1.add(txtsoluong);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 273, 335, 246);
	    panel.add(scrollPane);
	    
	    table_1 = new JTable();
	    model_1 = new DefaultTableModel();
	    table_1.setModel(model_1);
	    model_1.addColumn("Mã hóa đơn");
	    model_1.addColumn("Mã NV");
	    model_1.addColumn("Mã TTV");
	    model_1.addColumn("Ngày mượn");
	    model_1.addColumn("Ngày trả");
	    model_1.addColumn("Tình trạng");
	    scrollPane.setViewportView(table_1);
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(392, 230, 350, 289);
	    panel.add(scrollPane_1);
	    
	    table_2 = new JTable();
	    model_2 = new DefaultTableModel();
	    table_2.setModel(model_2);
	    model_2.addColumn("Mã HĐ");
	    model_2.addColumn("Tên sách");
	    model_2.addColumn("Thể loại");
	    model_2.addColumn("Số lượng");
	   
	    scrollPane_1.setViewportView(table_2);
	    
	    JLabel lblNewLabel_1 = new JLabel("HÓA ĐƠN");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1.setBounds(118, 11, 97, 32);
	    panel.add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("CT HÓA ĐƠN");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
	    lblNewLabel_1_1.setBounds(521, 11, 109, 32);
	    panel.add(lblNewLabel_1_1);
	    
	    btntrasach = new JButton("Trả sách");
	    btntrasach.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		SachDTO sach= new SachDTO();
	    		String mahd = txtmhd.getText();
	    		for(CTPhieuMuon ctpm: ctphieumuon) {
	    			if(String.valueOf(ctpm.getMapm()).equals(mahd)) {
	    						try {
	    							sach = new SachBUS().getSach(ctpm.getMasach());
									new SachBUS().edit_sl(sach.getSoluong()+1,ctpm.getMasach());
								} catch (Exception e1) {
						    		JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!!!");
									e1.printStackTrace();
								}
	    			}
	    		}
	    		TheThuVienDTO ttv = new TheThuVienDTO();
	    		ttv.setMathetv(Integer.parseInt(txtmttv.getText()));
	    		ttv.setTinhtrang(0);
	    		PhieuMuonDTO pm = new PhieuMuonDTO();
	    		pm.setMapm(Integer.parseInt(txtmhd.getText()));
	    		pm.setTinhtrang(0);
	    		
	    		if(new TheThuVienDAO().edit_tt(ttv) && new PhieuMuonBUS().edit_tt(pm)) {
	    			JOptionPane.showMessageDialog(null, "Trả sách thành công");
		    		reset();
		    		hienthi();
		    		btntrasach.setEnabled(false);
		    		return;
	    		}
	    		JOptionPane.showMessageDialog(null, "Trả sách thất bại");
	    		
	    	}
	    });
	    btntrasach.setEnabled(false);
	    btntrasach.setBackground(Color.ORANGE);
	    btntrasach.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    btntrasach.setBounds(653, 17, 89, 23);
	    panel.add(btntrasach);
		
		

		textField_36.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
                  SearchID();
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
                  SearchID();
             
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
                  SearchID();
              
             
			}
		});

		event();
		hienthi();
	}
	
	private ImageIcon getAnhSP(String src) {
        src = src.trim().equals("") ? "default.png" : src;
        //Xử lý ảnh
        BufferedImage img = null;
        File fileImg = new File(src);

        if (!fileImg.exists()) {
            src = "default.png";
            fileImg = new File("images/" + src);
        }

        try {
            img = ImageIO.read(fileImg);
            fileAnhSP = new File(src);
        } catch (IOException e) {
            fileAnhSP = new File("imgs/avatar.jpg");
        }

        if (img != null) {
            Image dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            return new ImageIcon(dimg);
        }

        return null;
    }
	private void event() {
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_1.getSelectedRow();
				if(i>=0) {
					if(model_1.getValueAt(i, 5).toString().equals("Đã trả")) {
						btntrasach.setEnabled(false);
					}else {
						btntrasach.setEnabled(true);
					}
					txtmhd.setText(model_1.getValueAt(i,0).toString());
					txtmnv.setText(model_1.getValueAt(i,1).toString());
					txtmttv.setText(model_1.getValueAt(i,2).toString());
					txtnm.setText(model_1.getValueAt(i,3).toString());
					txtnt.setText(model_1.getValueAt(i,4).toString());
					txttt.setText(model_1.getValueAt(i,5).toString());
					
					txtms.setText("");
					txtts.setText("");
					txttl.setText("");
					txtsoluong.setText("");
					showDetail();
				}
			}
		});
		
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_2.getSelectedRow();
				if(i>=0) {
					txtms.setText(model_2.getValueAt(i,0).toString());
					txtts.setText(model_2.getValueAt(i,1).toString());
					txttl.setText(model_2.getValueAt(i,2).toString());
					txtsoluong.setText(model_2.getValueAt(i,3).toString());
				}
			}
		});
		
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table1.getSelectedRow();
				
				if(i>=0) {
				
					txtmasach.setText(model1.getValueAt(i,0).toString());
					txttensach.setText(model1.getValueAt(i,1).toString());
					txttheloai.setText(model1.getValueAt(i,2).toString());
					
					lblNewLabel_3.setIcon(getAnhSP(model1.getValueAt(i, 4).toString()));
//					comboBox.setSelectedIndex(i);
					
//					lblNewLabel_2.setIcon(getAnhSP(model.getValueAt(i, 5).toString()));
				}
			}
		});
	}
	public void SearchID(){
        try{
            model1.setRowCount(0);
            if(textField_36.getText().isEmpty()){
                table.setModel(model);
            }
            PhieuMuonBUS pmb= new PhieuMuonBUS();
    		phieumuon=pmb.danhsach();
    		String hd = textField_36.getText().toLowerCase();
    		for(PhieuMuonDTO pm:phieumuon) {
    			if(String.valueOf(pm.getMapm()).toLowerCase().contains(hd)){
    			model1.addRow(new Object[] {
    					pm.getMapm(),pm.getManv(),pm.getMathetv(),pm.getNgaymuon(),pm.getNgaytra()
    			});
    			table1.setModel(model1);
    			}
    		}
            
        }catch(Exception E){
        }
    }
	public void reset() {
		txtmhd.setText("");
		txtmnv.setText("");
		txtmttv.setText("");
		txtnm.setText("");
		txtnt.setText("");
		txttt.setText("");
		txtmhd.setText("");
		txtts.setText("");
		txttl.setText("");
		txtsoluong.setText("");
	}
	
	public void hienthi() {
		sach = new SachBUS().danhsach();
		model1.setRowCount(0);
		TheLoaiDTO tl = new TheLoaiDTO();
		for(SachDTO s:sach) {
			tl = new TheLoaiBUS().getName(s.getMaloai());
			if(s.getSoluong()!=0) {
				model1.addRow(new Object[] {
						s.getMasach(),s.getTensach(),tl.getTentheloai(),s.getSoluong(),s.getHinhanh()
				});
			}
			
		}
		
		phieumuon = new PhieuMuonBUS().danhsach();
		ctphieumuon = new CTPhieuMuonBUS().danhsach();
		model_1.setRowCount(0);
		String tinhtrang;
		for(PhieuMuonDTO pm: phieumuon) {
			if(pm.getTinhtrang() == 1) {
				tinhtrang="Đang mượn";
			}else {
				tinhtrang="Đã trả";
			}
			
				model_1.addRow(new Object[] {
						pm.getMapm(),pm.getManv(),pm.getMathetv(),pm.getNgaymuon(),pm.getNgaytra(),tinhtrang
				});	
		}
		
//		model_2.setRowCount(0);
//		String name;
//		SachDTO s1= new SachDTO();
//		TheLoaiDTO theloai = new TheLoaiDTO();
//		for(CTPhieuMuon ctpm: ctphieumuon) {
//				s1 = new SachBUS().getSach(ctpm.getMasach());
//				theloai = new TheLoaiBUS().getName(s1.getMaloai());
//				
//				model_2.addRow(new Object[] {
//						ctpm.getMapm(),s1.getTensach(),theloai.getTentheloai(),1
//				});	
//			
//		}
		
		
		
	}
	public void showDetail() {
		ctphieumuon = new CTPhieuMuonBUS().danhsach();
		model_2.setRowCount(0);
		String name;
		SachDTO s1= new SachDTO();
		TheLoaiDTO theloai = new TheLoaiDTO();
		for(CTPhieuMuon ctpm: ctphieumuon) {
//			JOptionPane.showMessageDialog(null, ctpm.getMapm());
				if(String.valueOf(ctpm.getMapm()).equals(txtmhd.getText())) {
//					JOptionPane.showMessageDialog(null, ctpm.getMapm());
					s1 = new SachBUS().getSach(ctpm.getMasach());
					theloai = new TheLoaiBUS().getName(s1.getMaloai());
					
					model_2.addRow(new Object[] {
							ctpm.getMapm(),s1.getTensach(),theloai.getTentheloai(),1
					});	
				}
			
		}
	}
}
