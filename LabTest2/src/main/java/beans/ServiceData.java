package beans;

public class ServiceData implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String field1;
	private String field2;
	
	public String getFirstName() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getLastName() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	
}
