package DTO;

public class CTPhieuNhap {
	private int mapn, soluong,thanhtien,idsach;
	public CTPhieuNhap() {
		
	}
	
	
	public CTPhieuNhap(int mactpn, int mapn,int idsach, String tensach, int soluong, int thanhtien) {
		super();
		
		this.mapn = mapn;
		this.idsach=idsach;
		this.soluong = soluong;
		
		this.thanhtien = thanhtien;
	}


	
	public int getMapn() {
		return mapn;
	}


	public void setMapn(int mapn) {
		this.mapn = mapn;
	}


	public int getIdsach() {
		return idsach;
	}


	public void setIdsach(int idsach) {
		this.idsach = idsach;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	

	public int getThanhtien() {
		return thanhtien;
	}


	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}


	
	
	
}
