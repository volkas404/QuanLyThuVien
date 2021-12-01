package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.NhaCungCapBUS;
import BUS.NhanVienBUS;
import DTO.NhaCungCapDTO;
import DTO.NhanVienDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

public class NhaCungCap extends JPanel {

	private JButton btnNewButton_1_3,btnNewButton_1;
	private JTextField txtten;
	private JTextField txtdiachi;
	private JTextField txtsdt;
	private JTable table;
	private DefaultTableModel model;
	ArrayList<NhaCungCapDTO> ncc= new ArrayList<>();
	private JTextField txtma;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhaCungCap frame = new NhaCungCap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhaCungCap() {
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
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(SystemColor.textInactiveText, 2, true));
		panel.setBounds(21, 24, 727, 227);
		add(panel);
		
		JTextPane txtpnNgyBtu_1 = new JTextPane();
		txtpnNgyBtu_1.setText("Địa chỉ");
		txtpnNgyBtu_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnNgyBtu_1.setEditable(false);
		txtpnNgyBtu_1.setBackground(Color.WHITE);
		txtpnNgyBtu_1.setBounds(140, 88, 176, 27);
		panel.add(txtpnNgyBtu_1);
		
		JTextPane txtpnSinThoi_1 = new JTextPane();
		txtpnSinThoi_1.setText("Số điện thoại");
		txtpnSinThoi_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnSinThoi_1.setEditable(false);
		txtpnSinThoi_1.setBackground(Color.WHITE);
		txtpnSinThoi_1.setBounds(140, 125, 176, 27);
		panel.add(txtpnSinThoi_1);
		
		JTextPane txtpnGiiTnh = new JTextPane();
		txtpnGiiTnh.setText("Tên nhà cung cấp");
		txtpnGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnGiiTnh.setEditable(false);
		txtpnGiiTnh.setBackground(Color.WHITE);
		txtpnGiiTnh.setBounds(139, 50, 176, 27);
		panel.add(txtpnGiiTnh);
		
		txtten = new JTextField();
		txtten.setColumns(10);
		txtten.setBounds(337, 50, 281, 27);
		panel.add(txtten);
		
		txtdiachi = new JTextField();
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(337, 88, 281, 27);
		panel.add(txtdiachi);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(337, 128, 281, 27);
		panel.add(txtsdt);
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.setBackground(Color.ORANGE);
		
		btnNewButton_1_1.setIcon(new ImageIcon(NhaCungCap.class.getResource("./edit.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(231, 175, 122, 36);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Xóa");
		btnNewButton_1_2.setBackground(Color.ORANGE);
		
		btnNewButton_1_2.setIcon(new ImageIcon(NhaCungCap.class.getResource("./eraser.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2.setBounds(385, 175, 122, 36);
		panel.add(btnNewButton_1_2);
		
		btnNewButton_1_3 = new JButton("Tải lại");
		btnNewButton_1_3.setBackground(Color.ORANGE);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setEnabled(true);
				reset();
				hienthi();
			}
		});
		btnNewButton_1_3.setIcon(new ImageIcon(NhaCungCap.class.getResource("./refresh.png")));
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_3.setBounds(520, 175, 122, 36);
		panel.add(btnNewButton_1_3);
		
		JLabel lblNewLabel = new JLabel(" Mã nhà cung cấp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBackground(UIManager.getColor("Panel.background"));
		lblNewLabel.setBounds(140, 11, 195, 32);
		panel.add(lblNewLabel);
		
		txtma = new JTextField();
		txtma.setEnabled(false);
		txtma.setColumns(10);
		txtma.setBounds(337, 11, 281, 27);
		panel.add(txtma);
		
		btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setBounds(85, 175, 122, 36);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.ORANGE);
		
		btnNewButton_1.setIcon(new ImageIcon(NhaCungCap.class.getResource("./add.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtten.getText().equals("") || txtdiachi.getText().equals("") || txtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Bạn cần nhập đầy đủ các thông tin");
					return;
				}
				else {
					String tenncc=txtten.getText();
					String diachi=txtdiachi.getText();
					String sdt=txtsdt.getText();
					NhaCungCapDTO ncc= new NhaCungCapDTO();
					ncc.setTenncc(tenncc);
					ncc.setDiachi(diachi);
					ncc.setSdt(sdt);
					NhaCungCapBUS nccb= new NhaCungCapBUS();
					try {
						if(nccb.add(ncc)==true) {
							JOptionPane.showMessageDialog(null,"Thêm nhà cung cấp thành công");
							
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"them that bai");
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 333, 727, 197);
		
		model= new DefaultTableModel();
		table = new JTable();
		
		table.setModel(model);
		
		model.addColumn("Mã NCC");
		model.addColumn("Tên NCC");
		model.addColumn("Địa chỉ");
		model.addColumn("SĐT");
		scrollPane.setViewportView(table);
		add(scrollPane);
		
		JTextPane txtpnTmKim = new JTextPane();
		txtpnTmKim.setText("Tìm kiếm");
		txtpnTmKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnTmKim.setEditable(false);
		txtpnTmKim.setBackground(SystemColor.menu);
		txtpnTmKim.setBounds(117, 290, 76, 32);
		add(txtpnTmKim);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 120, 215), 6, true));
		panel_1.setBounds(205, 275, 413, 43);
		add(panel_1);
		Border emptyBorder = BorderFactory.createEmptyBorder(10, 10, 0, 0);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mã", "Tên"}));
		comboBox.setBounds(349, 7, 58, 30);
		panel_1.add(comboBox);
		textField = new JTextField();
		textField.setBounds(8, 7, 342, 30);
		panel_1.add(textField);
		
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(emptyBorder);
		textField.setBackground(UIManager.getColor("Panel.background"));
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Mã"){
                  SearchID();
				}
	              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
	                  SearchName();
	              }
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Mã"){
                  SearchID();
              }
              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
                  SearchName();
              }
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Mã"){
                  SearchID();
              }
              else if(comboBox.getItemAt(comboBox.getSelectedIndex()) == "Tên"){
                  SearchName();
              }
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null,"Bạn cần chọn nhà cung cấp cần sửa!");
					return;
				}
				if(txtten.getText().equals("") || txtdiachi.getText().equals("") || txtsdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Bạn cần nhập đầy đủ thông tin!");
					return;
				}
				else {
					int mancc=Integer.parseInt(txtma.getText());
					String tenncc=txtten.getText();
					String diachi=txtdiachi.getText();
					String sdt=txtsdt.getText();
					NhaCungCapDTO ncc= new NhaCungCapDTO();
					ncc.setMancc(mancc);
					ncc.setTenncc(tenncc);
					ncc.setDiachi(diachi);
					ncc.setSdt(sdt);
					NhaCungCapBUS nccb= new NhaCungCapBUS();
					try {
						if(nccb.edit(ncc)) {
							JOptionPane.showMessageDialog(null,"Sửa nhà cung cấp thành công");
							btnNewButton_1.setEnabled(true);
							
							hienthi();
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Sua that bai");
				}
			}
		});
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null,"Bạn cần chọn nhà cung cấp cần xóa!");
					return;
				}
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					int mancc=Integer.parseInt(txtma.getText());
					NhaCungCapDTO ncc= new NhaCungCapDTO();
					ncc.setMancc(mancc);
					NhaCungCapBUS nccb= new NhaCungCapBUS();
					try {
						if(nccb.delete(ncc)) {
							JOptionPane.showMessageDialog(null,"Xóa nhà cung cấp thành công");
							
							hienthi();
							btnNewButton_1.setEnabled(true);
							return;
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Xoa that bai");
				}
					
				}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_1.setEnabled(false);
				int i=table.getSelectedRow();
				if(i>=0) {
					txtma.setText(model.getValueAt(i,0).toString());
					txtten.setText(model.getValueAt(i,1).toString());
					txtdiachi.setText(model.getValueAt(i,2).toString());
					txtsdt.setText(model.getValueAt(i,3).toString());
				}
				btnNewButton_1_1.setEnabled(true);
				btnNewButton_1_2.setEnabled(true);
				
			}
		});
		hienthi();
	}
	public void SearchName() {
		try{
            model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            NhaCungCapBUS nvb= new NhaCungCapBUS();
    		ncc=nvb.danhsach();
            String hd = textField.getText().toLowerCase();
            for(NhaCungCapDTO ncc: ncc){
                if(ncc.getTenncc().toLowerCase().contains(hd)){
                	model.addRow(new Object[] {
        					ncc.getMancc(),ncc.getTenncc(),ncc.getDiachi(),ncc.getSdt(),
        			});
                    table.setModel(model);
                }
            }  
        }catch(Exception E){
        }
	}
	public void SearchID() {
		try{
			model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            NhaCungCapBUS nvb= new NhaCungCapBUS();
    		ncc=nvb.danhsach();
            String hd = textField.getText().toLowerCase();
            for(NhaCungCapDTO ncc: ncc){
                if(String.valueOf(ncc.getMancc()).toLowerCase().contains(hd)){
                	model.addRow(new Object[] {
        					ncc.getMancc(),ncc.getTenncc(),ncc.getDiachi(),ncc.getSdt(),
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
		txtdiachi.setText("");
		txtsdt.setText("");
	}
	public void hienthi() {
		NhaCungCapBUS nccb= new NhaCungCapBUS();
		ncc=nccb.danhsach();
		model.setRowCount(0);
		for(NhaCungCapDTO ncc1:ncc) {
			model.addRow(new Object[] {
					ncc1.getMancc(),ncc1.getTenncc(),ncc1.getDiachi(),ncc1.getSdt()
			});
		}
	}
}
