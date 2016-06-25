package lin.socketServer;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CacheHelper {

	//key为连接的IP,value为Socket
	public static final Map<String,Socket> connCache =new HashMap<String,Socket>();
	
}
