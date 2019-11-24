package Http;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 使用ServerSocket建立与浏览器的连接，获取请求协议
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
			System.out.println("服务器启动");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void receive() {
		try {
			Socket client=serverSocket.accept();
			System.out.println("一个客户端建立了连接");
			InputStream is=client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len=is.read(datas);
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
			
			Respones respones=new Respones(client);
			respones.print("<html>");
			respones.print("<head>");
			respones.print("<title>");
			respones.print("服务器响应成功");
			respones.print("</title>");
			respones.print("</head>");
			respones.print("<body>");
			respones.print("shsxt server终于回来了。。。。");
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
