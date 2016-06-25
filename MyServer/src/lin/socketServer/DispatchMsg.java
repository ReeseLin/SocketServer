package lin.socketServer;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DispatchMsg implements Runnable {

	private String disMsg;

	public DispatchMsg(String disMsg) {
		super();
		this.disMsg = disMsg;
	}

	@Override
	public void run() {
		Set<Map.Entry<String,Socket>> set = CacheHelper.connCache.entrySet();
		Iterator<Map.Entry<String,Socket>> it = set.iterator();
		while(it.hasNext()){
			Map.Entry<String,Socket> en =it.next();
			try {
				PrintWriter pw = new PrintWriter((en.getValue()).getOutputStream(),true);
				pw.println(disMsg);
			} catch (Exception e) {
			}
		}
	}

}
