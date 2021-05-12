package zkTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ReconfigTwo {
	// create static instance for zookeeper class.
	private static ZooKeeper zk;

	// create static instance for ZooKeeperConnection class.
	private static ZKConnection conn;
	
	public static void main(String[] args){
		try {
			conn = new ZKConnection();
		    zk = conn.connect("localhost:12013");
		         
		    List<String> joiningServers = new ArrayList<String>();  
		    joiningServers.add("server.2=localhost:12017:12018:participant;12019");
		    byte[] config = zk.reconfig(joiningServers, null, null, -1, new Stat());
		       
		    zk.close();
		} catch(Exception e) {
			System.out.println(e.getMessage()); // Catches error messages
		}
	}
}
