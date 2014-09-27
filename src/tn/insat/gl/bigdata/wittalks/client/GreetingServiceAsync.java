package tn.insat.gl.bigdata.wittalks.client;

import java.util.List;

import tn.insat.gl.bigdata.wittalks.shared.model.User;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	 

	void getAll(AsyncCallback<List<User>> callback);
}
