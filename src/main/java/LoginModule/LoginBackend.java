package LoginModule;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginBackend {
	
	HashMap<String,String> login = new HashMap<String,String>();
	ArrayList<User> users;
	
	public void load() {
		String path = "src/main/java/users.csv";
		ReadCsv maintain = new ReadCsv();
	    try {
	    	maintain.load(path);
	    }
		catch(Exception e) {
			
		}
		
		users = maintain.Getuser();
		
		for(int i=0; i< users.size(); i++) {
			User u = users.get(i);
			login.put(u.username, u.password);
		}
		System.out.println(login.get("john"));
	}

	public HashMap<String, String> getLoginInfo(){
		return login;
	}
	
	
	
}
