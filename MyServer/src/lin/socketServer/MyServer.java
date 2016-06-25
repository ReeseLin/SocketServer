package lin.socketServer;

import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// 1����������˶���
		ServerSocket serverSocket = new ServerSocket(10010);
		
		System.out.println("Server Running.....");
		
		while (true) {
			//��������
			Socket s = serverSocket.accept();
			//���뻺��
			CacheHelper.connCache.put(s.getInetAddress().getHostAddress(), s);
			System.out.println(s.getInetAddress().getHostAddress()+":connect in");
			// �����̸߳�ȥ����
			new Thread(new SocketServerThread(s)).start();
		}
	}
}
