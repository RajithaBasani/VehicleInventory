package data;

public class VehicleDetails {
	
	private String vId;
	private String licNum; 
	private String type;
	private String Model;
	private String state;
	private int year;
	
	public VehicleDetails(String vId, String licNum, String type, String model, String state, int year) {
		super();
		this.vId = vId;
		this.licNum = licNum;
		this.type = type;
		Model = model;
		this.state = state;
		this.year = year;
	}
	public VehicleDetails() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the vId
	 */
	public String getvId() {
		return vId;
	}
	/**
	 * @param vId the vId to set
	 */
	public void setvId(String vId) {
		this.vId = vId;
	}
	/**
	 * @return the licNum
	 */
	public String getLicNum() {
		return licNum;
	}
	/**
	 * @param licNum the licNum to set
	 */
	public void setLicNum(String licNum) {
		this.licNum = licNum;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return Model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		Model = model;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	

}
