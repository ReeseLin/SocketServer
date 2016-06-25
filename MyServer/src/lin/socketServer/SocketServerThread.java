package lin.socketServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketServerThread implements Runnable {

	private Socket s;

	public SocketServerThread(Socket s) {
		super();
		this.s = s;
	}

	@Override
	public void run() {
		try {
			BufferedReader bufin = new BufferedReader(new InputStreamReader(
					s.getInputStream()));

			String receiveMsg = null;

			while ((receiveMsg = bufin.readLine()) != null) {
				String sendIP = s.getInetAddress().getHostAddress();
				String dispatchMsg = sendIP+":"+receiveMsg;
				System.out.println("dispatchMsg="+dispatchMsg);
				new Thread(new DispatchMsg(dispatchMsg)).start();
			}
			
			// ¹Ø±Õ×ÊÔ´
			s.close();
		} catch (Exception e) {
		}
	}

}
