/** File
 * 
 * public File(String pathname)	// �ļ�ȫ·��
 * public File(String parent,String child)
 * public boolean createNewFile() throws IOException
 * public boolean exists()
 * public boolean delete()
 * public File getParentFile()	// ȡ�õ�ǰ·���ĸ�·��
 * public boolean mkdirs()		// �����༶Ŀ¼
 * public long length()			// ȡ���ļ���С�����ֽ�Ϊ��λ����
 * public boolean isFile()		// �ж�ָ��·���Ƿ����ļ�
 * public boolean isDirectory()	// �ж�ָ��·���Ƿ���Ŀ¼
 * public long lastModified()	// ȡ���ļ������һ���޸�����ʱ��
 * public String[] list()		// �г�ִ��Ŀ¼�е�ȫ������
 * public File[] listFiles()	// �г����е�·����File������װ
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
