package Day2;

public class ExceptionExample {
	
	

	public static void main(String[] args) {
		Authenticator auth = new Authenticator();
		try {
			long code= auth.authenticate(null,"tiger");
			System.out.println("Auth Code="+code);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally { // it's always executed...
			System.out.println("I will always executed..");
		}
	}

}
