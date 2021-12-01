package DTO;

public class SachDTO {
	private int masach,maloai,matacgia,soluong,gia;
	private String tensach,hinhanh;
	public SachDTO() {
		
	}
	public SachDTO(int masach, int maloai, int matacgia, int soluong, String tensach,String hinhanh,int gia) {
		super();
		this.masach = masach;
		this.maloai = maloai;
		this.matacgia = matacgia;
		this.soluong = soluong;
	this.gia=gia;
		this.tensach = tensach;
		this.hinhanh = hinhanh;
	}
	public int getMasach() {
		return masach;
	}
	public void setMasach(int masach) {
		this.masach = masach;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getMaloai() {
		return maloai;
	}
	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}
	public int getMatacgia() {
		return matacgia;
	}
	public void setMatacgia(int matacgia) {
		this.matacgia = matacgia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
//	public String getHinhanh() {
//		return hinhanh;
//	}
//	public void setHinhanh(String hinhanh) {
//		this.hinhanh = hinhanh;
//	}
}
