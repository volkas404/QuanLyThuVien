package DTO;

import java.util.Date;

public class PhieuMuonDTO {
	private int mapm, manv,mathetv,tinhtrang;
	private Date ngaymuon, ngaytra;
	public PhieuMuonDTO() {
		
	}
	public PhieuMuonDTO(int mapm,int manv, int mathetv, Date ngaymuon, Date ngaytra,int tinhtrang) {
		super();
		this.manv = manv;
		this.mathetv = mathetv;
		this.ngaymuon = ngaymuon;
		this.ngaytra = ngaytra;
		this.mapm=mapm;
		this.tinhtrang=tinhtrang;
	}
	public int getMapm() {
		return mapm;
	}
	public void setMapm(int mapm) {
		this.mapm = mapm;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public int getMathetv() {
		return mathetv;
	}
	public void setMathetv(int mathetv) {
		this.mathetv = mathetv;
	}
	public Date getNgaymuon() {
		return ngaymuon;
	}
	public void setNgaymuon(Date ngaymuon) {
		this.ngaymuon = ngaymuon;
	}
	public Date getNgaytra() {
		return ngaytra;
	}
	public void setNgaytra(Date ngaytra) {
		this.ngaytra = ngaytra;
	}
	public int getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(int tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
}
