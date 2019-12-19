/** File
 * 
 * public File(String pathname)	// 文件全路径
 * public File(String parent,String child)
 * public boolean createNewFile() throws IOException
 * public boolean exists()
 * public boolean delete()
 * public File getParentFile()	// 取得当前路径的父路径
 * public boolean mkdirs()		// 创建多级目录
 * public long length()			// 取得文件大小，以字节为单位返回
 * public boolean isFile()		// 判断指定路径是否是文件
 * public boolean isDirectory()	// 判断指定路径是否是目录
 * public long lastModified()	// 取得文件的最后一次修改日期时间
 * public String[] list()		// 列出执行目录中的全部内容
 * public File[] listFiles()	// 列出所有的路径以File类对象包装
 * 
 * 
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaIO {
	
	/**
	 * Memory Stream
	 * 
	 * 1  	ByteArrayInputStream  &  ByteArrayOutputStream
	 * 2	CharArrayReader & CharArrayWriter
	 * 
	 * 
	 * 
	 * 
	 * @param file
	 * @param level
	 */
	
	public static  void MemoryStreamTest() {
		String str = "abcd ef gi HITHG";
		
		InputStream in = new ByteArrayInputStream(str.getBytes());
		
		OutputStream out = new ByteArrayOutputStream();
		
		int temp = 0;
		
		try(DestroyImpl objDestroyImpl= new DestroyImpl()){
		
			while(-1 != (temp = in.read()) ) {
				out.write(Character.toUpperCase(temp));
			}
			System.out.println(out);
			
			in.close();
			out.close();
		} catch(Exception exp) {
			exp.printStackTrace();
		}
		
		
	}
	
	
	private void List(File file,int level) {

		//System.out.println(file.getPath());
		
		for(int i =0;i<level;i++)
			System.out.print(" ");		
		System.out.print(file.getName() + "\n");
		
		if (file.isDirectory()) {
			
			File res[] = file.listFiles();
			
			if(res == null)
			{
				return;
			}
			level++;
			for(File itm:res) {
					this.List(itm,level);						
			}
		}
	
	
			
	}
	
	public void ListFiles(String filepath) {
		
		File file = new File(filepath);

		List(file,0);
	}

	public void FileExist(String filepath) {
		
		File file = new File(filepath);
		
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();

			System.out.println("mkdirs  " + file.getParentFile().getPath() );
		}
		
		if (file.exists()) {

			System.out.println("isFile : " + file.isFile() );
			System.out.println("isDirectory : " + file.isDirectory() );
			System.out.println("Size : " + file.length() );

			BigDecimal objBigDecimal = new BigDecimal(file.length());
			BigDecimal objBigDecimal1 = new BigDecimal(1024*1024);
			
			System.out.println("Size : " + objBigDecimal.divide(objBigDecimal1,2,BigDecimal.ROUND_HALF_UP) + "M");
			
			
			System.out.println("Modify Time : " + file.lastModified() );
			
			SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
			
			Date objDate = new Date(file.lastModified());
			System.out.println("Modify Time : " + objSimpleDateFormat.format(objDate));
			
			
			//file.delete();
			//System.out.println("delete " + filepath );
		}
		else {
			try {
				System.out.println("createNewFIle : "+filepath + " " + file.createNewFile());
			}
			catch(Exception exp) {
				System.out.println(exp.getMessage());
			}
		}
		
		
	}
}
