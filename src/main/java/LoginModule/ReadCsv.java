package LoginModule;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class ReadCsv {
	public ArrayList<User> users = new ArrayList<User>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user = new User();
			//name,id,email,password
			user.setUsername(reader.get("username"));
			user.setPassword(reader.get("password"));
			users.add(user);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
				csvOutput.write("username");
				csvOutput.write("password");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: users){
					csvOutput.write(u.getUsername());
					csvOutput.write(u.getPassword());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
	public ArrayList<User> Getuser(){
		return users;
		
	}
	
}
