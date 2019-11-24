package Http;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * ʹ��ServerSocket����������������ӣ���ȡ����Э��
 * @author dell
 *
 */

public class Server {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server server=new Server();
		server.start();
		server.receive();
	}
	
	
	public void start() {
		try {
			serverSocket=new ServerSocket(8888);
			System.out.println("����������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void receive() {
		try {
			Socket client=serverSocket.accept();
			System.out.println("һ���ͻ��˽���������");
			InputStream is=client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len=is.read(datas);
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
			
			Respones respones=new Respones(client);
			respones.print("<html>");
			respones.print("<head>");
			respones.print("<title>");
			respones.print("��������Ӧ�ɹ�");
			respones.print("</title>");
			respones.print("</head>");
			respones.print("<body>");
			respones.print("shsxt server���ڻ����ˡ�������");
			respones.print("</body>");
			respones.print("</html>");
			
			respones.pushToBroswer(200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void stop() {
		
	}
	

}
