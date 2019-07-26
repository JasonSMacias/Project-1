package beans;

import java.time.LocalDate;

public class ReimbRequest {
	private int id;
	private int empId;
	private double value;
	private String description;
	private LocalDate date;
	private String status;
	private String imgFile;
	private String resolvedBy;
	
	public ReimbRequest(int id, int empId, double value, String description, LocalDate date, String status) {
		super();
		this.id = id;
		this.empId = empId;
		this.value = value;
		this.description = description;
		this.date = date;
		this.status = status;
	}
	public ReimbRequest(int empId, double value, String description, LocalDate date, String status) {
		super();
		this.empId = empId;
		this.value = value;
		this.description = description;
		this.date = date;
		this.status = status;
	}
	public ReimbRequest(double value, String description, LocalDate date, String status) {
		super();
		this.empId = empId;
		this.value = value;
		this.description = description;
		this.date = date;
		this.status = "pending";
	}
	public ReimbRequest() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public String getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	
	
}
