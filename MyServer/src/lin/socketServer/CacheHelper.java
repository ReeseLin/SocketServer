package lin.socketServer;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CacheHelper {

	//keyΪ���ӵ�IP,valueΪSocket
	public static final Map<String,Socket> connCache =new HashMap<String,Socket>();
	
}
