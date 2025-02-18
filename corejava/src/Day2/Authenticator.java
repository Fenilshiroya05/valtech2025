package Day2;

import java.util.Random;

public class Authenticator {
	
	public long authenticate (String name, String pass) {
		if("scott".equals(null)& "tiger".equals(pass)) { //always use scott and tiger compared with name&pass 
			return new Random().nextLong(); // no need to write else because of the return
		}
	throw new RuntimeException("Only Scott is allowed"); // if use RuntimeException no need to write throws
	
	}
}
