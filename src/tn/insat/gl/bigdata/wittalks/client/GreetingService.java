package tn.insat.gl.bigdata.wittalks.client;

import java.util.List;

import tn.insat.gl.bigdata.wittalks.shared.model.User;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("cassandra/greet")
public interface GreetingService extends RemoteService {
	List<User> getAll();
}
