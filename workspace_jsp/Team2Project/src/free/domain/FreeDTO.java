package free.domain;

import java.io.Serializable;

public class FreeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int fnum;
	private String ftitle;
	private String fcontent;
	private String id;
	private String fwriteday;
	private int freadcnt;
	private int repRoot;
	private int repStep;
	private int repIndent;
	
	public FreeDTO() {
		// TODO Auto-generated constructor stub
	}

	public FreeDTO(int fnum, String ftitle, String fcontent, String id, String fwriteday, int freadcnt, int repRoot,
			int repStep, int repIndent) {
		super();
		this.fnum = fnum;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.id = id;
		this.fwriteday = fwriteday;
		this.freadcnt = freadcnt;
		this.repRoot = repRoot;
		this.repStep = repStep;
		this.repIndent = repIndent;
	}

	public int getFnum() {
		return fnum;
	}

	public void setFnum(int fnum) {
		this.fnum = fnum;
	}

	public String getFtitle() {
		return ftitle;
	}

	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFwriteday() {
		return fwriteday;
	}

	public void setFwriteday(String fwriteday) {
		this.fwriteday = fwriteday;
	}

	public int getFreadcnt() {
		return freadcnt;
	}

	public void setFreadcnt(int freadcnt) {
		this.freadcnt = freadcnt;
	}

	public int getRepRoot() {
		return repRoot;
	}

	public void setRepRoot(int repRoot) {
		this.repRoot = repRoot;
	}

	public int getRepStep() {
		return repStep;
	}

	public void setRepStep(int repStep) {
		this.repStep = repStep;
	}

	public int getRepIndent() {
		return repIndent;
	}

	public void setRepIndent(int repIndent) {
		this.repIndent = repIndent;
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
		FreeDTO other = (FreeDTO) obj;
		if (fnum != other.fnum)
			return false;
		return true;
	}
	
}
