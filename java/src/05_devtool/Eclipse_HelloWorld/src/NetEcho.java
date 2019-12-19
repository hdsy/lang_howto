import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class NetEcho {
	
	public static void startClient() {
		try(DestroyImpl objDestroyImpl = new DestroyImpl()){
			Socket clnt = new Socket("localhost",5819);
			
			Scanner in = new Scanner(System.in);
			
			Scanner scn = new Scanner(clnt.getInputStream());
			
			PrintStream out = new PrintStream(clnt.getOutputStream());
			
			in.useDelimiter("\n");
			scn.useDelimiter("\n");
			
			boolean flg = true;
			
			while(flg) {
				System.out.println("Please input data :");
				
				if (in.hasNext()) {
					String str = in.next().trim();
					out.println(str);
					
					if(str.equalsIgnoreCase("byebye")) {
						flg =false;
					}
					
					if(scn.hasNext()) {
						System.out.println(scn.next());
					}
					else {
						flg = false;
					}
						
					
				}
			}
			
			in.close();
			scn.close();
			out.close();
			clnt.close();
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		
		
	}

	public static void startServer() {
		
		try(DestroyImpl objDestroyImpl = new DestroyImpl()){
			
			ServerSocket svr = new ServerSocket(5819);
			
			Socket clnt = svr.accept();
			
			Scanner scn = new Scanner(clnt.getInputStream());
			
			PrintStream ps = new PrintStream(clnt.getOutputStream());
			
			boolean flg = true;
			
			while(flg) {
				if(scn.hasNext()) {
					String str = scn.next().trim();
					
					if(str.equalsIgnoreCase("byebye!")) {
						ps.println("°Ý°Ý£¬ÏÂ´Î¼û byebye see you next time");
						
						flg = false;
						
					}
					
					else {
						ps.println("ECHO : " + str);
					}			
				}
			}
			
			scn.close();
			ps.close();
			clnt.close();
			svr.close();
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		
	}
}
