import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static boolean cp(String src,String dst) /*throws Exception*/ {
		
		try (DestroyImpl objDestroyImpl = new DestroyImpl()){	
			
		
			File srcFile = new File(src);
			
			if(!srcFile.exists()){
				System.out.println(src + " not Exist.");
				return false;
			}
			
			File dstFile = new File(dst);
			if(!dstFile.getParentFile().exists()) {
				dstFile.getParentFile().mkdirs();
			}
			
			InputStream in = new FileInputStream (srcFile);
			
			OutputStream out = new FileOutputStream(dstFile);
			
			int temp = 0;
			
			byte data[] = new byte[1024];
			
			while( -1 != (temp = in.read(data))) {
				out.write(data,0,temp);
			}
			
			in.close();
			out.close();

		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
		
		return false;
	}
}
