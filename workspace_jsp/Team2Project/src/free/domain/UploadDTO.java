package free.domain;

import java.io.Serializable;

public class UploadDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String fileName;
	String orgFileName;
	int fnum;
	public UploadDTO() {
		// TODO Auto-generated constructor stub
	}
	public UploadDTO(String fileName, String orgFileName, int fnum) {
		super();
		this.fileName = fileName;
		this.orgFileName = orgFileName;
		this.fnum = fnum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fnum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UploadDTO other = (UploadDTO) obj;
		if (fnum != other.fnum)
			return false;
		return true;
	}
	
	
	
	
}
