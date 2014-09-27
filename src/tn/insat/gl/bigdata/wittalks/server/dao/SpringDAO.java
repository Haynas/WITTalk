package tn.insat.gl.bigdata.wittalks.server.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import tn.insat.gl.bigdata.wittalks.shared.model.User;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

@Repository
public class SpringDAO {
	
	private Session session ;
 
	public SpringDAO(){
		
		String serverIP = "127.0.0.1";
    	String keyspace = "witspace";

    	Cluster cluster = Cluster.builder()
    	  .addContactPoints(serverIP)
    	  .build();
    	
    	session = cluster.connect(keyspace);
    	
	}
		
	public List<User> getAll(){
		List<User> users = new ArrayList<User>();
		String cqlStatement = "SELECT * FROM users";
    	for (Row row : session.execute(cqlStatement)) {
    	  users.add(new User(row.getString(2)));
    		
    		System.out.println(row.toString());
    	}
		return users;
	}
    	
}
 
