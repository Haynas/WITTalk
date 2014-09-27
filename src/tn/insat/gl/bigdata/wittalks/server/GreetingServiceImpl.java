package tn.insat.gl.bigdata.wittalks.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.insat.gl.bigdata.wittalks.client.GreetingService;
import tn.insat.gl.bigdata.wittalks.server.dao.SpringDAO;
import tn.insat.gl.bigdata.wittalks.shared.FieldVerifier;
import tn.insat.gl.bigdata.wittalks.shared.model.User;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@Service("CassandraService")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	
	
	

	@Override
	public List<User> getAll() {
		
		String serverIP = "127.0.0.1";
    	String keyspace = "witspace";

    	List<User> users = new ArrayList<User>();
    	Cluster cluster = Cluster.builder()
    	  .addContactPoints(serverIP)
    	  .build();

    	Session session = cluster.connect(keyspace);
    	String cqlStatement = "SELECT * FROM users";
    	for (Row row : session.execute(cqlStatement)) {
    		 users.add(new User(row.getString(2)));
    	}
		// TODO Auto-generated method stub
		return users;
	}

	 
}
