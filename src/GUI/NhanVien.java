package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.lang.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.BorderFactory;

import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

import BUS.DocGiaBUS;
import BUS.NhanVienBUS;
import BUS.TaiKhoanBUS;
import DTO.DocGiaDTO;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;

import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NhanVien extends JPanel {
	private DefaultTableModel model;
	private JTextField txtten;
	private JTextField txttuoi;
	private JTextField txtdc;
	private JTextField txtsdt;
	private JTextField textField_6;
	private JTable table;
	private JComboBox cbbgt;
	private JButton btnNewButton_1, btnNewButton_2;
	private ArrayList<NhanVienDTO> nhanvien = new ArrayList<>();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
					frame.setVisible(true);
					frame.hienthi();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public NhanVien() {
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
		repaint();
		setFont(new Font("Tahoma", Font.BOLD, 13));
		setBackground(UIManager.getColor("Panel.background"));
		
		setBounds(100, 100, 774, 627);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(SystemColor.textInactiveText, 2, true));
		panel.setBounds(30, 30, 721, 206);
		add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnTn = new JTextPane();
		txtpnTn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnTn.setText("Họ tên");
		txtpnTn.setBackground(UIManager.getColor("Panel.background"));
		txtpnTn.setEditable(false);
		txtpnTn.setBounds(27, 9, 82, 27);
		panel.add(txtpnTn);
		
		JTextPane txtpnNmSinh = new JTextPane();
		txtpnNmSinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnNmSinh.setText("Tuổi");
		txtpnNmSinh.setBackground(UIManager.getColor("Panel.background"));
		txtpnNmSinh.setEditable(false);
		txtpnNmSinh.setBounds(27, 60, 82, 27);
		panel.add(txtpnNmSinh);
		
		JTextPane txtpnaCh = new JTextPane();
		txtpnaCh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnaCh.setText("Địa chỉ");
		txtpnaCh.setBackground(UIManager.getColor("Panel.background"));
		txtpnaCh.setEditable(false);
		txtpnaCh.setBounds(27, 109, 82, 27);
		panel.add(txtpnaCh);
		
		JTextPane txtpnGiiTnh = new JTextPane();
		txtpnGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnGiiTnh.setText("Giới tính");
		txtpnGiiTnh.setBackground(UIManager.getColor("Panel.background"));
		txtpnGiiTnh.setEditable(false);
		txtpnGiiTnh.setBounds(367, 9, 116, 27);
		panel.add(txtpnGiiTnh);
		
		JTextPane txtpnSinThoi = new JTextPane();
		txtpnSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnSinThoi.setText("Số điện thoại");
		txtpnSinThoi.setBackground(UIManager.getColor("Panel.background"));
		txtpnSinThoi.setEditable(false);
		txtpnSinThoi.setBounds(367, 60, 116, 27);
		panel.add(txtpnSinThoi);
		
		txtten = new JTextField();
		txtten.setBounds(132, 9, 181, 27);
		panel.add(txtten);
		txtten.setColumns(10);
		
		txttuoi = new JTextField();
		txttuoi.setColumns(10);
		txttuoi.setBounds(132, 60, 181, 27);
		panel.add(txttuoi);
		
		txtdc = new JTextField();
		txtdc.setColumns(10);
		txtdc.setBounds(132, 109, 555, 27);
		panel.add(txtdc);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(506, 60, 181, 27);
		panel.add(txtsdt);
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.setBackground(Color.ORANGE);
		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.setBackground(Color.ORANGE);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null,"Bạn cần chọn nhân viên cần xóa");
					return;
				}
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					NhanVienDTO nv= new NhanVienDTO();
					nv.setManv(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
					NhanVienBUS nvb= new NhanVienBUS();
					try {
						if(nvb.delete(nv)) {
							TaiKhoanBUS tkb= new TaiKhoanBUS();
							TaiKhoanDTO tk= new TaiKhoanDTO();
							if(nhanvien.get(table.getSelectedRow()).getMatk() == 0) {
								JOptionPane.showMessageDialog(null,"Xóa nhân viên thành công");
								btnNewButton_1.setEnabled(true);
								hienthi();
								return;
							}else {
								tk.setMataikhoan(nhanvien.get(table.getSelectedRow()).getMatk());
								
								if(tkb.delete(tk)) {
									JOptionPane.showMessageDialog(null,"Xóa nhân viên thành công");
									btnNewButton_1.setEnabled(true);
									hienthi();
									return;
								}
							}
							
							
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Xoa Nhan Vien Thất Bại");
				}
					
			}
		});
		
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null,"Bạn cần chọn nhân viên cần sửa");
					return;
				}
				if(txtten.getText().equals("") || txttuoi.getText().equals("") || txtdc.getText().equals("") || txtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Bạn cần nhập đầy đủ thông tin cần sửa");
					return;
				}
				else {
					NhanVienDTO nv= new NhanVienDTO();
					nv.setManv(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
					nv.setTennv(txtten.getText());
					nv.setTuoi(Integer.parseInt(txttuoi.getText()));
					nv.setGioitinh(String.valueOf(cbbgt.getSelectedItem()));
					nv.setSdt(txtsdt.getText());
					nv.setDiachi(txtdc.getText());
					NhanVienBUS nvb= new NhanVienBUS();
					try {
						if(nvb.edit(nv)) {
							JOptionPane.showMessageDialog(null,"Sửa Nhân Viên Thành Công");
							btnNewButton_1.setEnabled(true);
							hienthi();
							return;
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Sửa Nhan Vien Thất Bại");
				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(DocGia.class.getResource("./edit.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(247, 157, 122, 36);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_2.setIcon(new ImageIcon(DocGia.class.getResource("./eraser.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2.setBounds(385, 157, 122, 36);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Tải lại");
		btnNewButton_1_3.setBackground(Color.ORANGE);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_2.setEnabled(false);
				hienthi();
			}
		});
		btnNewButton_1_3.setIcon(new ImageIcon(DocGia.class.getResource("./refresh.png")));
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_3.setBounds(520, 157, 122, 36);
		panel.add(btnNewButton_1_3);
		
		btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setBounds(97, 157, 122, 36);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtten.getText().equals("") || txttuoi.getText().equals("") || txtdc.getText().equals("") || txtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Bạn cần nhập đầy đủ thông tin");
					return;
				}
				else {
					NhanVienDTO nv= new NhanVienDTO();
					nv.setTennv(txtten.getText());
					nv.setTuoi(Integer.parseInt(txttuoi.getText()));
					nv.setGioitinh(String.valueOf(cbbgt.getSelectedItem()));
					nv.setSdt(txtsdt.getText());
					nv.setDiachi(txtdc.getText());
					nv.setTrangthai(0);
					NhanVienBUS nvb= new NhanVienBUS();
					try {
						if(nvb.add(nv)) {
							JOptionPane.showMessageDialog(null,"Thêm nhân viên thành công");
							
							hienthi();
							return;
							
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Them Nhan Vien Thất Bại");
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(DocGia.class.getResource("./add.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		Vector gt = new Vector<>();
		gt.add("Nam");
		gt.add("Nữ");
		gt.add("Khác");
		
		cbbgt = new JComboBox(gt);
		cbbgt.setBounds(506, 9, 181, 27);
		panel.add(cbbgt);
		
		JTextPane txtpnTmKim = new JTextPane();
		txtpnTmKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTmKim.setText("Tìm kiếm");
		txtpnTmKim.setBackground(UIManager.getColor("PopupMenu.background"));
		txtpnTmKim.setEditable(false);
		txtpnTmKim.setBounds(90, 260, 76, 32);
		add(txtpnTmKim);
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 0, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 318, 721, 198);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_1.setEnabled(false);
				int i=table.getSelectedRow();
				
				if(i>=0) {
					txtten.setText( model.getValueAt(i,1).toString());
					txttuoi.setText( model.getValueAt(i,2).toString());
					cbbgt.setSelectedItem(model.getValueAt(i,3).toString());
					txtsdt.setText( model.getValueAt(i,4).toString());
					txtdc.setText(model.getValueAt(i,5).toString());
					
					btnNewButton_1_1.setEnabled(true);
					btnNewButton_1_2.setEnabled(true);
					
					if(String.valueOf(nhanvien.get(i).getTrangthai()).equals("0")) {
						btnNewButton_2.setEnabled(true);
						//System.out.println("khuong");
					}
					else {
					//	System.out.println("anh");
						btnNewButton_2.setEnabled(false);
					}
				}
			}
		});
		table.setFont(new Font("Dialog", Font.PLAIN, 13));
		model= new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên nhân viên");
		model.addColumn("Tuổi");
		model.addColumn("Giới tính");
		model.addColumn("SĐT");
		model.addColumn("Địa chỉ");
		model.addColumn("Tình trạng");
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(176, 255, 425, 43);
		add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 120, 215), 6, true));
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(360, 7, 58, 30);
		panel_1.add(comboBox);
		comboBox.addItem("ID");
		comboBox.addItem("Tên");
		textField_6 = new JTextField();
		textField_6.setBounds(6, 7, 353, 30);
		panel_1.add(textField_6);
		
		textField_6.setBorder(emptyBorder);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setBackground(UIManager.getColor("Panel.background"));
		textField_6.setColumns(10);
		textField_6.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "ID"){
                  SearchID();
				}
	              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
	                  SearchName();
	              }
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "ID"){
                  SearchID();
              }
              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
                  SearchName();
              }
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "ID"){
                  SearchID();
              }
              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
                  SearchName();
              }
			}
		});
		
		btnNewButton_2 = new JButton("Tạo tài khoản");
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienDTO nv= new NhanVienDTO();
				nv.setManv(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
				
				DangKy dk= new DangKy(nv.getManv());
				dk.setVisible(true);
				
				dk.setLocationRelativeTo(null);
			
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(628, 260, 123, 37);
		add(btnNewButton_2);
		
		hienthi();
	}
	public void SearchID(){
        try{
        	String tt="";
            model.setRowCount(0);
            if(textField_6.getText().isEmpty()){
                table.setModel(model);
            }
            NhanVienBUS nvb= new NhanVienBUS();
    		nhanvien=nvb.danhsach();
            String hd = textField_6.getText().toLowerCase();
            for(NhanVienDTO nv : nhanvien){
                if(String.valueOf(nv.getManv()).toLowerCase().contains(hd)){
                	if(nv.getTrangthai() == 1) {
        				tt="Đã có TK";
        			}else {
        				tt="Chưa có TK";
        			}
                	model.addRow(new Object[] {
        					nv.getManv(),nv.getTennv(),nv.getTuoi(),nv.getGioitinh(),nv.getSdt(),nv.getDiachi(),tt
        			});
                    table.setModel(model);
                }
            }  
        }catch(Exception E){
        }
    }
	public void SearchName() {
		try{
			String tt="";
            model.setRowCount(0);
            if(textField_6.getText().isEmpty()){
                table.setModel(model);
            }
            NhanVienBUS nvb= new NhanVienBUS();
    		nhanvien=nvb.danhsach();
            String hd = textField_6.getText().toLowerCase();
            for(NhanVienDTO nv : nhanvien){
                if(nv.getTennv().toLowerCase().contains(hd)){
                	if(nv.getTrangthai() == 1) {
        				tt="Đã có TK";
        			}else {
        				tt="Chưa có TK";
        			}
                	model.addRow(new Object[] {
        					nv.getManv(),nv.getTennv(),nv.getTuoi(),nv.getGioitinh(),nv.getSdt(),nv.getDiachi(),tt
        			});
                    table.setModel(model);
                }
            }  
        }catch(Exception E){
        }
	}
	public void hienthi() {
		NhanVienBUS nvb= new NhanVienBUS();
		nhanvien=nvb.danhsach();
		model.setRowCount(0);
		String tt="";
		for(NhanVienDTO nv:nhanvien) {
			if(nv.getTrangthai() == 1) {
				tt="Đã có TK";
			}else {
				tt="Chưa có TK";
			}
			model.addRow(new Object[] {
					nv.getManv(),nv.getTennv(),nv.getTuoi(),nv.getGioitinh(),nv.getSdt(),nv.getDiachi(),tt
			});
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
