package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.SachBUS;
import BUS.TacGiaBUS;
import BUS.TheLoaiBUS;
import DTO.SachDTO;
import DTO.TacGiaDTO;
import DTO.TheLoaiDTO;
import exportExel.export;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.MatteBorder;
public class sach2 extends JPanel {
	File fileAnhSP;
	boolean isSelect=false;
	private JTable table;
	private JComboBox comboBox_1;
	private DefaultTableModel model;
	private JComboBox comboBox ;
	private ArrayList<TacGiaDTO> tacgia=new ArrayList<>();
	private Vector<String> tacgia1= new Vector<>();
	private Vector<String> listSach= new Vector<>();
	private ArrayList<TheLoaiDTO> theloai=new ArrayList<>();
	private ArrayList<SachDTO> sach=new ArrayList<>();
	private Vector<String> theloai1= new Vector<>();
	private JTextField txtgia;
	private JTextField textField;
	private JTextField txttensach;
	private JButton btnThem,btnXoa,btnSua;
	private JTextField txtid;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sach2 frame = new sach2();
					frame.setVisible(true);
					frame.hienthi();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public sach2() {
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 24, 730, 2);
		add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(25, 42, 478, 209);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sách");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(104, 49, 95, 27);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Thể loại");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(104, 125, 95, 27);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("Giá sách");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(104, 163, 95, 27);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tác giả");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(104, 87, 95, 27);
		panel_1.add(lblNewLabel_1_5);
		TacGiaBUS tgb= new TacGiaBUS();
		tacgia=tgb.danhsach();
		tacgia1.add("Option...");
		for(TacGiaDTO tg:tacgia) {
			tacgia1.add(tg.getMatacgia()+"-"+tg.getTentacgia());
		}
		//System.out.println(tacgia.size());
		comboBox = new JComboBox(tacgia1);
		
		
		
		
		
		//comboBox.setModel(new DefaultComboBoxModel(tacgia1);
		comboBox.setBounds(226, 90, 155, 22);
		panel_1.add(comboBox);
		TheLoaiBUS tlb= new TheLoaiBUS();
		theloai=tlb.danhsach();
		theloai1.add("Option...");
		for(TheLoaiDTO tg:theloai) {
			theloai1.add(tg.getMatheloai()+"-"+tg.getTentheloai());
		}
		comboBox_1 = new JComboBox(theloai1);
		//comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"hi"}));
		comboBox_1.setBounds(226, 128, 155, 22);
		panel_1.add(comboBox_1);
		txtgia = new JTextField();
		txtgia.setColumns(10);
		txtgia.setBounds(226, 166, 155, 22);
		panel_1.add(txtgia);
		
		txttensach = new JTextField();
		txttensach.setColumns(10);
		txttensach.setBounds(226, 52, 155, 22);
		panel_1.add(txttensach);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID Sách");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(104, 11, 95, 27);
		panel_1.add(lblNewLabel_1_1_1);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setColumns(10);
		txtid.setBounds(226, 15, 155, 22);
		panel_1.add(txtid);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(25, 390, 725, 139);
		
		
		table = new JTable();
		
		 model=  new DefaultTableModel();
		table.setModel(model);
			
		btnThem = new JButton("Thêm");
		
//			model.addColumn(new String []{
//				"Ma Sach", "Ten Sach","The Loai","Tac Gia","Gia","So Luong"});
		btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.ORANGE);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoa.setIcon(new ImageIcon(sach2.class.getResource("./eraser.png")));
		btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.ORANGE);
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSua.setIcon(new ImageIcon(sach2.class.getResource("./edit.png")));
		btnThem.setBounds(36, 282, 105, 33);
		scrollPane.setViewportView(table);
		add(scrollPane);
		add(btnThem);
//		model.addColumn("STT");
		model.addColumn("Mã Sách");
		model.addColumn("Tên Sách");
		model.addColumn("Tên thể loại");
		model.addColumn("Tên tác giả");
		model.addColumn("Số lượng");
		model.addColumn("Giá");
		model.addColumn("Image");
		
		
		btnThem.setBackground(Color.ORANGE);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThem.setIcon(new ImageIcon(sach2.class.getResource("./add.png")));
		
		btnSua.setBounds(151, 282, 105, 33);
		add(btnSua);
		
		
		
		btnXoa.setBounds(267, 282, 105, 33);
		add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(Color.ORANGE);
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCapNhat.setIcon(new ImageIcon(sach2.class.getResource("./refresh.png")));
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hienthi();
			}
		});
		btnCapNhat.setBounds(382, 282, 113, 33);
		add(btnCapNhat);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("Button.disabledShadow"));
		panel_2.setBounds(529, 42, 221, 209);
		add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(UIManager.getColor("CheckBox.background"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(sach2.class.getResource("/image/justice_4.png")));
		lblNewLabel_2.setBounds(10, 0, 199, 164);
		panel_2.add(lblNewLabel_2);
		 
		JButton btnNewButton_5 = new JButton("Thêm Hình");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser("images/");
		        FileNameExtensionFilter filter = new FileNameExtensionFilter(
		                "Tệp hình ảnh", "jpg", "png", "jpeg");
		        fileChooser.setFileFilter(filter);
		        int returnVal = fileChooser.showOpenDialog(null);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		        	isSelect = true;
		            fileAnhSP = fileChooser.getSelectedFile();
		            lblNewLabel_2.setIcon(getAnhSP(fileAnhSP.getPath()));
		        }
			}
		});
		btnNewButton_5.setBounds(52, 175, 111, 23);
		panel_2.add(btnNewButton_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Mã", "Tên"}));
		comboBox_2.setBounds(529, 344, 62, 27);
		add(comboBox_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new MatteBorder(5, 5, 5, 5, (Color)new Color(0,118,179)));
		panel_3.setBounds(138, 340, 385, 33);
		add(panel_3);
		panel_3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(5, 5, 375, 22);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				export.exportExcel(table);
			}
		});
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExport.setBackground(Color.ORANGE);
		btnExport.setBounds(548, 282, 113, 33);
		add(btnExport);
		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Mã"){
					SearchMaSach();
				}
		        else if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Tên"){
		            	  SearchTenSach();
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Mã"){
					SearchMaSach();
              }
              else if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Tên"){
            	  SearchTenSach();
              }
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Mã"){
                  SearchMaSach();
              }
				 else if(comboBox_2.getItemAt(comboBox_2.getSelectedIndex()) == "Tên"){
	            	  SearchTenSach();
	              }
			}
		});
		eventOnclick();
		hienthi();
	}
	public void eventOnclick() {
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i= table.getSelectedRow();
				if(i<0) {
					JOptionPane.showMessageDialog(null,"Bạn cần chọn sản phẩm cần xóa!");
					return;
				}
				int ques=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa không?","Question",JOptionPane.YES_NO_OPTION);
				if(ques==JOptionPane.YES_OPTION) {
					SachDTO s= new SachDTO();
					s.setMasach(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
					SachBUS sb= new SachBUS();
					try {
						if(sb.delete(s)) {
							JOptionPane.showMessageDialog(null,"Xóa sách thành công");
							btnThem.setEnabled(true);
							hienthi();
							return;
						}
					} catch (Exception e1) {
						
					}
					JOptionPane.showMessageDialog(null,"Xoa sach that bai");
				}
				
			}
		});
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tl=comboBox_1.getSelectedIndex();
				int tg=comboBox.getSelectedIndex();
				if(txttensach.getText().equals("") || String.valueOf(tl).equals("0") || String.valueOf(tg).equals("0") || txtgia.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Bạn cần nhập đầy đủ thông tin!");
					return;
				}
				String check="0";
				String name = txttensach.getText();
				
				int gia= Integer.parseInt(txtgia.getText());
				String image="";
				
				SachDTO s= new SachDTO();			
				if(isSelect==false) {
					image ="C:\\Users\\ASUS\\Downloads\\justice_4.png";
					check="1";
				}
				else {
					image = fileAnhSP.toString();
					isSelect= false;
				}
				
				for(SachDTO s1: sach) {
					if(s1.getTensach().equals(name)) {
						JOptionPane.showMessageDialog(null,"WARNING: Sách này đã tồn tại trong danh sách!");
						return;
					}
				}
				s.setTensach(name);
				s.setMatacgia(tacgia.get(tg-1).getMatacgia());
				s.setMaloai(theloai.get(tl-1).getMatheloai());
				s.setGia(gia);
				s.setSoluong(0);
				s.setHinhanh(image);
				SachBUS sb= new SachBUS();
				try {
					if(sb.add(s)) {
						if(check.equals("0")) {
							luuFileAnh();
						}
						
						JOptionPane.showMessageDialog(null,"Thêm sách thành công");
						hienthi();
						return;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Them sach that bai");
			}
		});
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				if(i>=0) {
					txtid.setText(model.getValueAt(i,0).toString());
					txttensach.setText(model.getValueAt(i,1).toString());
//					comboBox_1.setSelectedIndex(i);
//					comboBox.setSelectedIndex(i);
					txtgia.setText(model.getValueAt(i,5).toString());
					lblNewLabel_2.setIcon(getAnhSP(model.getValueAt(i, 6).toString()));
					btnThem.setEnabled(false);
				}
			}
		});
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i =table.getSelectedRow();
				if(i<0) {
					JOptionPane.showMessageDialog(null,"Bạn cần chọn sách cần sửa!");
					return;
				}
				int tl=comboBox_1.getSelectedIndex();
				int tg=comboBox.getSelectedIndex();
				if(txttensach.getText().equals("") || String.valueOf(tl).equals("0") || String.valueOf(tg).equals("0") || txtgia.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Bạn cần nhập đầy đủ thông tin cần sửa!");
					return;
				}
				String name =txttensach.getText();
				for(SachDTO s1: sach) {
					if(s1.getTensach().equals(table.getValueAt(i, 1).toString())) {
						continue;
					}
					if(s1.getTensach().equals(name)) {
						JOptionPane.showMessageDialog(null,"WARNING: Sách này đã tồn tại trong danh sách!");
						return;
					}
				}
				SachDTO s= new SachDTO();
				
				s.setMasach(Integer.parseInt(model.getValueAt(table.getSelectedRow(),0).toString()));
				s.setTensach(txttensach.getText());
				s.setGia(Integer.parseInt(txtgia.getText()));
				s.setSoluong(0);
				//vì ta có mảng tacgia vị trí giống với vị trí của combobox ta chọn
				s.setMatacgia(tacgia.get(tg-1).getMatacgia());
				s.setMaloai(theloai.get(tl-1).getMatheloai());
				
				SachBUS sb= new SachBUS();
				try {
					if(sb.edit(s)) {
						JOptionPane.showMessageDialog(null,"Sửa sách thành công");
						btnThem.setEnabled(true);
						hienthi();
						return;
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Sua sach that bai");
			}
		});
	}
	public void SearchMaSach(){
        try{
            model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            SachBUS s= new SachBUS();
            sach=s.danhsach();
            String hd = textField.getText().toLowerCase();
            for(SachDTO sach1 : sach){
                if(String.valueOf(sach1.getMasach()).toLowerCase().contains(hd)){
                    model.addRow(new Object[] {
                    		sach1.getMasach(),sach1.getTensach(),sach1.getMaloai(),sach1.getMatacgia(),sach1.getSoluong()
                    });
                    table.setModel(model);
                }
            }
        }catch(Exception E){
        }
        
    }
//	private void xuLyChonAnh() {
//        JFileChooser fileChooser = new MyFileChooser("image/SanPham/");
//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "Tệp hình ảnh", "jpg", "png", "jpeg");
//        fileChooser.setFileFilter(filter);
//        int returnVal = fileChooser.showOpenDialog(null);
//
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            fileAnhSP = fileChooser.getSelectedFile();
//            lblAnhSP.setIcon(getAnhSP(fileAnhSP.getPath()));
//        }
//    }
	
    public void SearchTenSach() {
        try{
            model.setRowCount(0);
            if(textField.getText().isEmpty()){
                table.setModel(model);
            }
            SachBUS s= new SachBUS();
            sach=s.danhsach();
            String hd = textField.getText().toLowerCase();
            for(SachDTO sach1 : sach){
                if(sach1.getTensach().toLowerCase().contains(hd)){
                    model.addRow(new Object[] {
                    		sach1.getMasach(),sach1.getTensach(),sach1.getMaloai(),sach1.getMatacgia(),sach1.getSoluong()
                    });
                    table.setModel(model);
                }
            }
        }catch(Exception E){
        }
    }
    
    public Image resize(Image image, int width, int height) {
    	Image resultImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    	return resultImage;
    }
    
    public byte[] toByArray(Image image, String type) throws IOException {
    	BufferedImage bimage = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);
    	Graphics2D g = bimage.createGraphics();
    	g.drawImage(image, 0, 0 ,null);
    	g.dispose();
    	
    	ByteArrayOutputStream baos = new ByteArrayOutputStream();
    	ImageIO.write(bimage, type, baos);
    	byte[] imageByte = baos.toByteArray();
    	return imageByte;
    	
    }
    
//    public Image createImageFromByArray(byte[] data, String type) {
//    	ByteArrayInputStream bis = new ByteArrayInputStream(data);
//    	BufferedImage buff= ImageIO.read(bis);
//    	
//    	Image img = buff.getScaledInstance(buff.getWidth(), buff.getHeight(), Image.SCALE_SMOOTH);
//    	return img;
//    }
    private void luuFileAnh() {
        BufferedImage bImage = null;
        try {
            File initialImage = new File(fileAnhSP.getPath());
            bImage = ImageIO.read(initialImage);

            ImageIO.write(bImage, "png", new File("Lib/" + fileAnhSP.getName()));

        } catch (IOException e) {
            System.out.println("Exception occured :" + e.getMessage());
        }
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
	public void hienthi() {
		SachBUS sb= new SachBUS();
		sach=sb.danhsach();
		model.setRowCount(0);
		TacGiaDTO tg= new TacGiaDTO();
		TheLoaiDTO tl= new TheLoaiDTO();
		
		//System.out.println(theloai.get(0).getMatheloai());
		for(SachDTO s:sach) {
			 tg =new TacGiaBUS().getName(s.getMatacgia());
			 tl =new TheLoaiBUS().getName(s.getMaloai());
			model.addRow(new Object[] {
					s.getMasach(),s.getTensach(),tl.getMatheloai()+"-"+tl.getTentheloai(),tg.getMatacgia()+"-"+tg.getTentacgia(),s.getSoluong(),s.getGia(),s.getHinhanh()
				});
			
		}
	}
}