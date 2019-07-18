package beans;

public class Employee extends User {

	public Employee(int userId, String password, String securityQ, String securityA) {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String password, String securityQ, String securityA) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isLoggedIn() {
		// TODO Auto-generated method stub
		return super.isLoggedIn();
	}

	@Override
	public void setLoggedIn(boolean isLoggedIn) {
		// TODO Auto-generated method stub
		super.setLoggedIn(isLoggedIn);
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getpWord() {
		// TODO Auto-generated method stub
		return super.getpWord();
	}

	@Override
	public void setpWord(String pWord) {
		// TODO Auto-generated method stub
		super.setpWord(pWord);
	}

	@Override
	public String getSecurityQ() {
		// TODO Auto-generated method stub
		return super.getSecurityQ();
	}

	@Override
	public void setSecurityQ(String securityQ) {
		// TODO Auto-generated method stub
		super.setSecurityQ(securityQ);
	}

	@Override
	public String getSecurityA() {
		// TODO Auto-generated method stub
		return super.getSecurityA();
	}

	@Override
	public void setSecurityA(String securityA) {
		// TODO Auto-generated method stub
		super.setSecurityA(securityA);
	}

	@Override
	public String toString() {
		return "Employee id: " + getId() + "Security Question: " + getSecurityQ();
	}
	
}
