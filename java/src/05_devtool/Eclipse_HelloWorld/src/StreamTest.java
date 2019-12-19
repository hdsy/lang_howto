import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * OutputStream
 * 	public void close() throws Exception
 * 	public void flush()
 * 	public abstract void write(int b) throws IOException
 * 	public void write(byte[] b) throws IOException
 * 	public void write(byte[] b,int off, int len) throw IOException
 * 
 * public abstract class OutputStream extends Object implements Closeable,Flushable
 * 
 * public interface Closeable extends AutoCloseable{
 * 	public void close() throws IOException;
 * }
 * 
 * AutoCloseable 用来实现自动回收 
 * 		try( AutoCloseable_son_class obj = new AutoCloseable_son_class) {}catch(){}
 * 
 * public interface Flushable{
 * 	public void flush() throws IOException;
 * }
 * 
 * 
 * FileOutputStream
 * 	// 创建新文件，如果文件存在则覆盖
 * 	public FileOutputStream(File file) throws FileNotFoundException
 * 	// 如果append为true，则表示追加
 * 	public FIleOutputStream(File file,boolean append)）throws FileNotFoundException
 * 
 * @author Administrator
 *
 */
public class StreamTest {
	
	/**
	 * InputStreamReader   &   OutputStreamWriter
	 * 
	 * public class InputStreamReader extends Reader
	 * 		public InputStreamReader(InputStream in)
	 * 
	 * public class OutputStreamWriter extends Writer
	 * 		public InputStreamWriter(OutputStream out)
	 * 
	 * 
	 * 上述类可用来转换字节流与字符流
	 * 
	 * 
	 */
	public void Char2ByteStreamChangeTest(String fp) {
		
		File file = new File(fp);
		
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		// create and append
		try {
			OutputStream out_s = new FileOutputStream(file);
			
			Writer output = new OutputStreamWriter(out_s); // new FileWriter(file,true);
			
			String str = "更多课程资源请访问：www.yootk.com";
			
			output.write(str);
			
			output.close();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		// reader
		try {
			InputStream objInputStream = new FileInputStream (file);
			
			
			
			Reader input = new InputStreamReader(objInputStream);// new FileReader(file);
			
			char data[] = new char[1024];
			
			int len = input.read(data);
			
			input.close();
			
			System.out.println(new String(data,0,len)+ " len " + len );
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
	}
	
	
	/**
	 * Writer
	 * 	public void close() throws IOException
	 * 	public void flush() throws IOException
	 *  public void write(String str) throws IOException
	 *  public void write（char[] cbuf）throws IOException
	 *  public Writer append(CHarSequence cseq) throws IOException
	 *  
	 *  
	 *  
	 *Reader
	 *	void close()
	 *	int read()
	 *	int read(char [] data)  
	 *  long skip(long n)
	 *  
	 * @param fp
	 */
	public void FileWriteTest(String fp) {
		
		File file = new File(fp);
		
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		// create and append
		try {
			Writer output = new FileWriter(file,true);
			
			String str = "更多课程资源请访问：www.yootk.com";
			
			output.write(str);
			
			output.close();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		// reader
		try {
			Reader input = new FileReader(file);
			
			char data[] = new char[1024];
			
			int len = input.read(data);
			
			input.close();
			
			System.out.println(new String(data,0,len)+ " len " + len );
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
	}
	/**
	 * [EDIT]设定字符集
	 * 
	 * 	str 获取可设定string定义的const字符集常量，应该与文档的字符集一致，否则会是乱码
	 * 
	 * @param fp
	 */
	public void FileOutputStreamTest(String fp) {
		
		File file = new File(fp);
		
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		try {
			OutputStream output = new FileOutputStream(file);
			
			String str = "|||更多课程资源请访问尝试下|||：www.yootk.com";
			
			// 简单转换 出现乱码
			byte data[] = str.getBytes("GBK");
			
			//byte data [] = getBytes(str);
			
			output.write(data);
			
			output.close();
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}
	
	public void FileInputStreamTest(String fp) {
		File file = new File(fp);
		
		if(!file.exists()) {
			System.out.println("File not exist : " + fp);
			return;
		}
		try {
			InputStream objInputStream = new FileInputStream (file);
			
			byte data[] = new byte[1024];
			
			int len = objInputStream.read(data);
			
			objInputStream.close();
			
			System.out.println(fp+" 的内容是 ["+new String(data,0,len)+"] len :" + len);
			
			
	
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		
		
	}
	
	/**
	 * 大数据的接口
	 * Stream
	 * 	long count()
	 * 	Stream《T》 distinct()
	 * 	<R,A>R collect(Collector<?super T,A,R> collector)
	 * 	......
	 * 
	 * 
	 * JDK1.8+ 之后，Iterable接口增加了forEach接口
	 * 
	 */
	public static void StreamInContainTest() {
		List <String> objListString = new ArrayList<String>();
		
		objListString.add("www.sina.com");
		objListString.add("www.qq.com");
		objListString.add("www.wucar.com");
		objListString.add("www.my-soft.com");
		
		objListString.forEach(System.out::println);
	}

}
