package BUS;

import java.util.ArrayList;

import DAO.SachDAO;
import DTO.SachDTO;

public class SachBUS {
	SachDAO sd = new SachDAO();
	public boolean add(SachDTO s) throws Exception {
		if(sd.add(s)) {
			return true;
		}
		return false;
	}
	public boolean edit(SachDTO s) throws Exception {
		if(sd.edit(s)) {
			return true;
		}
		return false;
	}
	public boolean edit_sl(int sl,int ms) throws Exception {
		if(sd.edit_sl(sl,ms)) {
			return true;
		}
		return false;
	}
	public boolean delete(SachDTO s) throws Exception {
		if(sd.delete(s)) {
			return true;
		}
		return false;
	}
	public ArrayList<SachDTO> danhsach(){
		return sd.danhsach();
	}
	public ArrayList<SachDTO> danhsach_masach(int masach){
		return sd.danhsach_masach(masach);
	}
	
	public SachDTO getSach(int masach){
		return sd.getSach(masach);
	}
	
}
