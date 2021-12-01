package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Connect.connection;
import DTO.CTPhieuNhap;
import DTO.danhsachphieunhapDTO;

public class CTPhieuNhapDAO {
	public boolean add(CTPhieuNhap pn){
		String sql="insert into tbl_chitietphieunhap(mapn,idsach,soluong,thanhtien) values (?,?,?,?)";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			
			ps.setInt(1,pn.getMapn());
			ps.setInt(2,pn.getIdsach());
			ps.setInt(3,pn.getSoluong());
			
			ps.setInt(4,pn.getThanhtien());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean edit(CTPhieuNhap pn) {
		String sql="update tbl_chitietphieunhap set soluong=?, thanhtien=? where mapn=? and idsach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pn.getSoluong());
			
			ps.setInt(2,pn.getThanhtien());
			ps.setInt(3,pn.getMapn());
			ps.setInt(4,pn.getIdsach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean edit_sl(CTPhieuNhap pn) {
		String sql="update tbl_chitietphieunhap set soluong=?, thanhtien=? where mapn=? and idsach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pn.getSoluong());
			ps.setInt(2,pn.getThanhtien());
			ps.setInt(3,pn.getMapn());
			ps.setInt(4,pn.getIdsach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	public boolean delete(CTPhieuNhap pn) {
		String sql="delete from tbl_chitietphieunhap where mapn=? and idsach=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,pn.getMapn());
			ps.setInt(2,pn.getIdsach());
			return ps.executeUpdate()>0;
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	public ArrayList<CTPhieuNhap> danhsach(){
		ArrayList<CTPhieuNhap> ctpn=new ArrayList<>();
		String sql="select * from tbl_chitietphieunhap";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				CTPhieuNhap ct= new CTPhieuNhap();
				ct.setMapn(rs.getInt(1));
				ct.setIdsach(rs.getInt(2));
				ct.setSoluong(rs.getInt(3));
				
				ct.setThanhtien(rs.getInt(4));
				ctpn.add(ct);
			}
		}catch(Exception ex) {
			
		}
		return ctpn;
	}
	public ArrayList<CTPhieuNhap> danhsachid(int mapn){
		ArrayList<CTPhieuNhap> ctpn= new ArrayList<>();
		String sql="select * from tbl_chitietphieunhap where mapn=?";
		try {
			Connection conn=connection.openConnection();
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setInt(1,mapn);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				CTPhieuNhap ct= new CTPhieuNhap();
				ct.setMapn(rs.getInt(1));
				ct.setIdsach(rs.getInt(2));
				ct.setSoluong(rs.getInt(3));
				ct.setThanhtien(rs.getInt(4));
				ctpn.add(ct);
			}
		}catch(Exception ex) {
			
		}
		return ctpn;
	}
}