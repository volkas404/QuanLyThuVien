package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BUS.CTPhieuNhapBUS;
import BUS.KhoSachBUS;
import BUS.NhaCungCapBUS;
import BUS.PhieuNhapBUS;
import BUS.SachBUS;
import DTO.CTPhieuNhap;
import DTO.KhoSachDTO;
import DTO.NhaCungCapDTO;
import DTO.PhieuNhapDTO;
import DTO.SachDTO;
import exportExel.export;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class PhieuNhap extends JPanel {
	ArrayList<PhieuNhapDTO> phieunhap = new ArrayList<>();
	ArrayList<CTPhieuNhap> ctphieunhap = new ArrayList<>();
	ArrayList<SachDTO> sach = new ArrayList<>();
	ArrayList<NhaCungCapDTO> ncc = new ArrayList<>();
	Vector<String> ncc1 = new Vector<>();
	private JTextField txtmanv;
	private JTextField txtsoluong;
	private JTextField txttimkiem;
	private JTable table_1;
	private JTable table;
	private DefaultTableModel model,model_1;
	int tongtien=0;
	private JTextField txtmasach;
	private JTextField txttensach;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuNhap frame = new PhieuNhap();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
		public PhieuNhap() {
			ncc=new NhaCungCapBUS().danhsach();
			ncc1.add("Option...");
			for(NhaCungCapDTO ncc: ncc) {
				ncc1.add(String.valueOf(ncc.getMancc()));
			}
			
			setBounds(100, 100, 774, 627);
			
			
			setLayout(null);
				TacGia tg1= new TacGia();
				setVisible(true);
				
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBounds(0, 0, 776, 552);
				add(tabbedPane);
				model = new DefaultTableModel();
				table = new JTable();
				table.setModel(model);
				model.addColumn("STT");
				model.addColumn("Mã Sách");
				model.addColumn("Tên Sách");
				model.addColumn("Giá");
				model.addColumn("Hình ảnh");
				table_1 = new JTable();
				
				JPanel panel = new JPanel();
				tabbedPane.addTab("Nhập Sách", null, panel, null);
				
				txttimkiem = new JTextField();
				txttimkiem.setBounds(150, 13, 340, 20);
				txttimkiem.setText("");
				txttimkiem.setColumns(10);
				panel.setLayout(null);
				panel.add(txttimkiem);
				
				JScrollPane scrollPane = new JScrollPane();
//				table_1.addMouseListener(new MouseAdapter() {
//					@Override
//					public void mouseClicked(MouseEvent e) {
//						int i=table_1.getSelectedRow();
//						if(i>=0) {
//							//comboBox.setSelectedItem(model.getValueAt(i,1));
//							
//							t3.setText(model.getValueAt(i,2).toString());
//							t4.setText(model.getValueAt(i,3).toString());
//							btnNewButton_4.setEnabled(false);
//						}
//					}
//				});
				scrollPane.setBounds(367, 70, 394, 207);
				panel.add(scrollPane);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(15, 321, 528, 192);
				panel.add(scrollPane_1);
				table_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
				model_1= new DefaultTableModel();
				
				table_1.setModel(model_1);
				model_1.addColumn("STT");
				model_1.addColumn("Mã sách");
				model_1.addColumn("Tên sách");
				model_1.addColumn("Số lượng");
				model_1.addColumn("Giá");
				scrollPane_1.setViewportView(table_1);
				
				JTextPane txtpnTmKim = new JTextPane();
				txtpnTmKim.setBackground(UIManager.getColor("PopupMenu.background"));
				txtpnTmKim.setFont(new Font("Tahoma", Font.BOLD, 11));
				txtpnTmKim.setText("Tìm kiếm");
				txtpnTmKim.setBounds(29, 13, 72, 20);
				panel.add(txtpnTmKim);
				
				JPanel panel_4 = new JPanel();
				panel_4.setBackground(Color.WHITE);
				panel_4.setBounds(10, 71, 347, 172);
				panel.add(panel_4);
				panel_4.setBorder(new TitledBorder(null, "Nhập sách", TitledBorder.LEADING, TitledBorder.TOP, null, null));
					panel_4.setLayout(null);
					
					
					txtmanv = new JTextField();
					txtmanv.setText("1");
					txtmanv.setEditable(false);
					txtmanv.setBounds(125, 22, 164, 20);
					panel_4.add(txtmanv);
					txtmanv.setColumns(10);
					
					txtsoluong = new JTextField();
					txtsoluong.setBackground(UIManager.getColor("ToggleButton.highlight"));
					txtsoluong.setBounds(125, 127, 161, 20);
					panel_4.add(txtsoluong);
					txtsoluong.setColumns(10);
					
					JTextPane txtpnMNv = new JTextPane();
					txtpnMNv.setBounds(10, 22, 112, 20);
					panel_4.add(txtpnMNv);
					txtpnMNv.setEditable(false);
					txtpnMNv.setBackground(Color.WHITE);
					txtpnMNv.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtpnMNv.setText("Mã nhân viên");
					
					JTextPane txtpncGi = new JTextPane();
					txtpncGi.setBounds(10, 53, 82, 20);
					panel_4.add(txtpncGi);
					txtpncGi.setEditable(false);
					txtpncGi.setBackground(Color.WHITE);
					txtpncGi.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtpncGi.setText("Mã sách");
					
					JTextPane txtpnMNcc = new JTextPane();
					txtpnMNcc.setText("Tên sách");
					txtpnMNcc.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtpnMNcc.setEditable(false);
					txtpnMNcc.setBackground(Color.WHITE);
					txtpnMNcc.setBounds(10, 85, 82, 20);
					panel_4.add(txtpnMNcc);
					
					txtmasach = new JTextField();
					txtmasach.setEditable(false);
					txtmasach.setColumns(10);
					txtmasach.setBounds(125, 53, 164, 20);
					panel_4.add(txtmasach);
					
					txttensach = new JTextField();
					txttensach.setEditable(false);
					txttensach.setColumns(10);
					txttensach.setBackground(UIManager.getColor("ToggleButton.light"));
					txttensach.setBounds(125, 85, 161, 20);
					panel_4.add(txttensach);
					
					JTextPane txtpnSLng = new JTextPane();
					txtpnSLng.setText("Số lượng");
					txtpnSLng.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtpnSLng.setEditable(false);
					txtpnSLng.setBackground(Color.WHITE);
					txtpnSLng.setBounds(10, 127, 112, 20);
					panel_4.add(txtpnSLng);
					
					scrollPane.setViewportView(table);
					
					
					JLabel lblNewLabel = new JLabel("THÔNG TIN SÁCH");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblNewLabel.setBounds(500, 29, 151, 30);
					panel.add(lblNewLabel);
					
					JLabel lblThngTinPhiu = new JLabel("THÔNG TIN PHIẾU NHẬP");
					lblThngTinPhiu.setFont(new Font("Tahoma", Font.BOLD, 13));
					lblThngTinPhiu.setBounds(222, 280, 180, 30);
					panel.add(lblThngTinPhiu);
					
					JPanel panel_4_1 = new JPanel();
					panel_4_1.setLayout(null);
					panel_4_1.setBorder(null);
					panel_4_1.setBackground(Color.WHITE);
					panel_4_1.setBounds(553, 321, 208, 192);
					panel.add(panel_4_1);
					
					JButton btnNewButton_6_1 = new JButton("Xóa");
					btnNewButton_6_1.setFont(new Font("Tahoma", Font.BOLD, 11));
					btnNewButton_6_1.setEnabled(false);
					btnNewButton_6_1.setBounds(207, 173, 82, 23);
					panel_4_1.add(btnNewButton_6_1);
					JButton btnthem = new JButton("Thêm");
					btnthem.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(table.getSelectedRow()<0) {
								JOptionPane.showMessageDialog(null, "Bạn cần chọn sách cần nhập!");
								return;
							}

							if(txtsoluong.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "Bạn cần nhập số lượng!");
								return;
							}
							int dem=1;
							String masach = model.getValueAt(table.getSelectedRow(), 1).toString();
							String tensach = model.getValueAt(table.getSelectedRow(), 2).toString();
							int gia = Integer.parseInt(txtsoluong.getText()) * Integer.parseInt(model.getValueAt(table.getSelectedRow(), 3).toString());
							Date now= new Date();
							
							if(model_1.getRowCount()>0) {
								for(int i=0;i<model_1.getRowCount();i++) {
									if(txtmasach.getText().equals(model_1.getValueAt(i, 1).toString())){
										int sl = Integer.parseInt(txtsoluong.getText()) + Integer.parseInt(model_1.getValueAt(i, 3).toString());
										int gia1 = sl * Integer.parseInt(model.getValueAt(table.getSelectedRow(),3 ).toString());
										model_1.setValueAt(sl, i, 3);
										model_1.setValueAt(gia1, i, 4);
										return;
									}
								}
							}
							
							model_1.addRow(new Object[] {
									dem++,masach,tensach,txtsoluong.getText(),gia
							});
							
						}
					});
					btnthem.setBounds(10, 76, 92, 23);
					panel_4_1.add(btnthem);
					
					
					
					btnthem.setFont(new Font("Tahoma", Font.BOLD, 11));
					btnthem.setIcon(new ImageIcon(PhieuNhap.class.getResource("./add.png")));
					
					JButton btnxoa = new JButton("Xóa");
					btnxoa.setBounds(112, 76, 82, 23);
					panel_4_1.add(btnxoa);
					btnxoa.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(table_1.getSelectedRow()<0) {
								JOptionPane.showMessageDialog(null, "Bạn cần chọn phiếu nhập cần xóa");
								return;
							}
							int i= table_1.getSelectedRow();
							
								model_1.removeRow(i);
							
						}
					});
					btnxoa.setFont(new Font("Tahoma", Font.BOLD, 11));
					btnxoa.setIcon(new ImageIcon(PhieuNhap.class.getResource("./eraser.png")));
					
					JButton btnNewButton_4_1 = new JButton("Tạo phiếu nhập");
					
					btnNewButton_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
					btnNewButton_4_1.setBounds(10, 124, 92, 23);
					panel_4_1.add(btnNewButton_4_1);
					
					JButton btnNewButton_4_2 = new JButton("Export");
					btnNewButton_4_2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							export.exportExcel(table);
						}
					});
					btnNewButton_4_2.setFont(new Font("Tahoma", Font.BOLD, 11));
					btnNewButton_4_2.setBounds(112, 124, 82, 23);
					panel_4_1.add(btnNewButton_4_2);
					
					JComboBox comboBox = new JComboBox(ncc1);
					comboBox.setBounds(80, 23, 114, 20);
					panel_4_1.add(comboBox);
					comboBox.setBackground(UIManager.getColor("ToggleButton.light"));
					JTextPane txtpnNgyMn = new JTextPane();
					txtpnNgyMn.setBounds(10, 23, 60, 20);
					panel_4_1.add(txtpnNgyMn);
					txtpnNgyMn.setEditable(false);
					txtpnNgyMn.setBackground(Color.WHITE);
					txtpnNgyMn.setFont(new Font("Tahoma", Font.PLAIN, 13));
					txtpnNgyMn.setText("Mã NCC");

					table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int i=table.getSelectedRow();
						if(i>=0) {
							txtmasach.setText(model.getValueAt(i,1).toString());
							txttensach.setText(model.getValueAt(i,2).toString());
						}
					}
				});
					btnNewButton_4_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(comboBox.getSelectedItem().equals("Option...")) {
								JOptionPane.showMessageDialog(null, "Bạn cần chọn nhà cung cấp!");
								return;
							}
							int total=0;
							int i = model_1.getRowCount();
							for(int j=0;j<i;j++) {
								total += Integer.valueOf(model_1.getValueAt(j,4).toString());
							}
							int manv = Integer.parseInt(txtmanv.getText());
							int mancc = Integer.parseInt(String.valueOf(comboBox.getSelectedItem()));
							Date now= new Date();
							PhieuNhapDTO pn= new PhieuNhapDTO();
							pn.setManv(manv);
							pn.setMancc(mancc);
							pn.setNgaynhap(now);
							pn.setTongtien(total);
							
							try {
								if(new PhieuNhapBUS().add(pn)) {
									phieunhap = new PhieuNhapBUS().danhsach();
									int mapn = phieunhap.get(phieunhap.size()-1).getMapn();
									CTPhieuNhap ctpn= new CTPhieuNhap();
									int idsach=0;
									int sl=0;
									int thanhtien =0;
									for(int k=0;k<model_1.getRowCount();k++) {
										idsach = Integer.parseInt(model_1.getValueAt(k, 1).toString()); 
										sl = Integer.parseInt(model_1.getValueAt(k, 3).toString()); 
										thanhtien = Integer.parseInt(model_1.getValueAt(k, 4).toString()); 
										ctpn.setMapn(mapn);
										ctpn.setIdsach(idsach);
										ctpn.setSoluong(sl);
										ctpn.setThanhtien(thanhtien);
										new CTPhieuNhapBUS().add(ctpn);
										SachDTO s = new SachBUS().getSach(idsach);
										new SachBUS().edit_sl(s.getSoluong()+sl, idsach);
										
									}
								
									JOptionPane.showMessageDialog(null, "Tạo phiếu nhập thành công");
									model_1.setRowCount(0);
									return;
									
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					});
				hienthi();		
	}
	public void hienthi() {
		int dem=1;
		sach = new SachBUS().danhsach();
		model.setRowCount(0);
		for(SachDTO s: sach) {
			model.addRow(new Object[] {
					dem++,s.getMasach(),s.getTensach(),s.getGia(),s.getHinhanh()
			});
		}
	}
}
