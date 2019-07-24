package beans;

public class Employee {
	private int id;
	private String name;
	private String pWord;
	private String securityQ;
	private String securityA;
	private boolean isManager;
	private boolean isLoggedIn;
	
	public Employee(String name, String pWord, String securityQ, String securityA, boolean isManager) {
		super();
		this.name = name;
		this.pWord = pWord;
		this.securityQ = securityQ;
		this.securityA = securityA;
		this.setManager(isManager);
		this.isLoggedIn = false;
	}
	public Employee() {
		super();
	}
	public Employee(int id, String name, String pWord, String securityQ, String securityA, boolean isManager) {
		super();
		this.id = id;
		this.name = name;
		this.pWord = pWord;
		this.securityQ = securityQ;
		this.securityA = securityA;
		this.setManager(isManager);
		this.isLoggedIn = false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getpWord() {
		return pWord;
	}
	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
	public String getSecurityQ() {
		return securityQ;
	}
	public void setSecurityQ(String securityQ) {
		this.securityQ = securityQ;
	}
	public String getSecurityA() {
		return securityA;
	}
	public void setSecurityA(String securityA) {
		this.securityA = securityA;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	
	
}
