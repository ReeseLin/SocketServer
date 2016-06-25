package lin.socketServer;

import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// 1，创建服务端对象
		ServerSocket serverSocket = new ServerSocket(10010);
		
		System.out.println("Server Running.....");
		
		while (true) {
			//阻塞方法
			Socket s = serverSocket.accept();
			//存入缓存
			CacheHelper.connCache.put(s.getInetAddress().getHostAddress(), s);
			System.out.println(s.getInetAddress().getHostAddress()+":connect in");
			// 开子线程给去处理
			new Thread(new SocketServerThread(s)).start();
		}
	}
}
