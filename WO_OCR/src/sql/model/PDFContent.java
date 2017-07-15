package sql.model;

public class PDFContent {

	private int id;
	private String summary;
	private String introduction;
	private String content;
	private String reference;
	private int pdfid;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public int getPdfid() {
		return pdfid;
	}
	public void setPdfid(int pdfid) {
		this.pdfid = pdfid;
	}
	
	public PDFContent(int pdfid) {
		this.pdfid = pdfid;
	}
	
}
