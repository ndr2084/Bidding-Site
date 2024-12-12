package dbutils;

import java.util.ArrayList;

import beans.ServiceData;

public interface UserDAO {
	ServiceData getUserByProfile(String email, String password);
	
	int addUser(String first_name, String last_name, String email, String password);
}
