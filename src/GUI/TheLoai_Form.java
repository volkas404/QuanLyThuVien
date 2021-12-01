package GUI;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import BUS.NhanVienBUS;
import BUS.TheLoaiBUS;
import DTO.NhanVienDTO;
import DTO.TheLoaiDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class TheLoai_Form extends JPanel {

	private JTextField txtma,txtten;
	private JTable table;
	DefaultTableModel model;
	ArrayList<TheLoaiDTO> theloai= new ArrayList<>(); 
	private JTextField textField;
	public TheLoai_Form() {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(55, 34, 669, 108);
		add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnTn_4 = new JTextPane();
		txtpnTn_4.setText("Mã thể loại");
		txtpnTn_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnTn_4.setEditable(false);
		txtpnTn_4.setBackground(Color.WHITE);
		txtpnTn_4.setBounds(28, 36, 82, 27);
		panel_1.add(txtpnTn_4);
		JButton btnXoa = new JButton("Xóa");
		
		txtma = new JTextField();
		txtma.setEnabled(false);
		txtma.setColumns(10);
		txtma.setBounds(120, 36, 181, 27);
		panel_1.add(txtma);
		
		JTextPane txtpnTn_4_1 = new JTextPane();
		txtpnTn_4_1.setText("Tên thể loại");
		txtpnTn_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnTn_4_1.setEditable(false);
		txtpnTn_4_1.setBackground(Color.WHITE);
		txtpnTn_4_1.setBounds(347, 36, 105, 27);
		panel_1.add(txtpnTn_4_1);
		
		txtten = new JTextField();
		txtten.setColumns(10);
		txtten.setBounds(459, 36, 181, 27);
		panel_1.add(txtten);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(53, 309, 671, 139);
		table= new JTable();
		
		model= new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Ma");
		model.addColumn("Ten");
		scrollPane_9.setViewportView(table);
		add(scrollPane_9);
		
		JButton btnthem = new JButton("Thêm");
		
		btnthem.setIcon(new ImageIcon(Index.class.getResource("./add.png")));
		btnthem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnthem.setBounds(55, 188, 122, 36);
		add(btnthem);
		
		JButton btnSua = new JButton("Sửa");
		
		btnSua.setIcon(new ImageIcon(Index.class.getResource("./edit.png")));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setBounds(203, 188, 122, 36);
		add(btnSua);
		
		
		btnXoa.setIcon(new ImageIcon(Index.class.getResource("./eraser.png")));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setBounds(365, 188, 122, 36);
		add(btnXoa);
		
		JButton btnNewButton_1_3_1_2 = new JButton("Tải lại");
		btnNewButton_1_3_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnthem.setEnabled(true);
				reset();
			}
		});
		btnNewButton_1_3_1_2.setIcon(new ImageIcon(Index.class.getResource("./refresh.png")));
		btnNewButton_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_3_1_2.setBounds(531, 188, 122, 36);
		add(btnNewButton_1_3_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(135, 249, 451, 36);
		add(textField);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Mã", "Tên"}));
		comboBox_2.setBounds(810, 208, 96, 36);
		add(comboBox_2);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnthem.setEnabled(false);
				int i=table.getSelectedRow();
				if(i>=0) {
					txtma.setText(String.valueOf(model.getValueAt(i,0)));
					txtten.setText((String) model.getValueAt(i,1));
				}
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				btnthem.setEnabled(false);
			}
		});
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( txtten.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Bạn cần nhập tên thể loại!");
				}
				else {
				
					TheLoaiDTO tl= new TheLoaiDTO();
					
					tl.setTentheloai(txtten.getText());
					TheLoaiBUS tlb= new TheLoaiBUS();
					try {
						if(tlb.add(tl)) {
							JOptionPane.showMessageDialog(null,"Thêm thể loại thành công");
							
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Them The Loai That Bai");
				}
			}
		});
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null,"Bạn cần chọn sách cần sửa!");
					return;
				}
				if(txtten.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Bạn cần nhập tên cần sửa!");
					return;
				}
				else {
					int ma=Integer.parseInt(txtma.getText());//11
					TheLoaiDTO tl= new TheLoaiDTO();
					tl.setMatheloai(ma);
					tl.setTentheloai(txtten.getText());
					TheLoaiBUS tlb= new TheLoaiBUS();
					try {
						if(tlb.edit(tl)) {
							JOptionPane.showMessageDialog(null,"Sửa thể loại thành công");
							btnthem.setEnabled(true);
							
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Sua The Loai That Bai");
				}
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null,"Bạn cần chọn sách cần xóa!");
					return;
				}
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					int ma=Integer.parseInt(txtma.getText());
					TheLoaiDTO tl= new TheLoaiDTO();
					tl.setMatheloai(ma);
					TheLoaiBUS tlb= new TheLoaiBUS();
					try {
						if(tlb.delete(tl)) {
							JOptionPane.showMessageDialog(null,"Xóa thể loại thành công");
							btnthem.setEnabled(true);
							
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Xoa The Loai That Bai");
				}
				
			}
		});
		hienthi();
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) =="Mã"){
					SearchMaTL();
				}
		        else if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Tên"){
		            	  SearchTenTL();
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Mã"){
					SearchMaTL();
              }
              else if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Tên"){
            	  SearchTenTL();
              }
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) =="Mã"){
                  SearchMaTL();
              }
				 else if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Tên"){
	            	  SearchTenTL();
	              }
			}
		});
	}
	public void SearchMaTL(){
		try{
            model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            TheLoaiBUS tlb= new TheLoaiBUS();
    		theloai=tlb.danhsach();
            String hd = textField.getText().toLowerCase();
            for(TheLoaiDTO tl : theloai){
                if(String.valueOf(tl.getMatheloai()).toLowerCase().contains(hd)){
                	model.addRow(new Object[] {
                			tl.getMatheloai(),tl.getTentheloai()
        			});
                    table.setModel(model);
                }
            }  
        }catch(Exception E){
        }
    }
	public void SearchTenTL(){
        try{
            model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            TheLoaiBUS tl1= new TheLoaiBUS();
            theloai=tl1.danhsach();
            String hd = textField.getText().toLowerCase();
            for(TheLoaiDTO tl : theloai){
                if(tl.getTentheloai().toLowerCase().contains(hd)){
                    model.addRow(new Object[] {
                    		tl.getMatheloai(),tl.getTentheloai()
                    });
                    table.setModel(model);
                }
            }
        }catch(Exception E){
        }
    }
	public void reset() {
		txtma.setText("");
		txtten.setText("");
	}
	public void hienthi() {
		TheLoaiBUS tlb= new TheLoaiBUS();
		theloai=tlb.danhsach();
		model.setRowCount(0);
		for(TheLoaiDTO tl:theloai) {
			model.addRow(new Object[] {
				tl.getMatheloai(),tl.getTentheloai()
			});
		}
	}
}
