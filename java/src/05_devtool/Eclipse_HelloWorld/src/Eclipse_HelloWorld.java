import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.regex.Matcher;

public class Eclipse_HelloWorld {
	public static void main(String args[]) {
		
		CollectionFrame.CollectionTest();
		CollectionFrame.ListTest();
		CollectionFrame.SetTest();
		CollectionFrame.vectorTest();
		CollectionFrame.mapTest();
		
		CollectionFrame.stackTest();
		CollectionFrame.collectionsTest();
		CollectionFrame.propertiesTest();
		
		StreamTest.StreamInContainTest();
		
		//MariaDBTest.mariaDBTest();
		
		MariaDBTest.InitEnv();
		MariaDBTest.execSQL("insert into hz(id,name,remark)values(2,'name','value');");
		//MariaDBTest.execSQL("insert into hz(id,name,remark)values(3,'name','value');");
		//MariaDBTest.execSQL("insert into hz(id,name,remark)values(4,'name','value');");
		MariaDBTest.execSQL("update hz set name='abc' where id=1;");

		MariaDBTest.execSQL("delete from hz where  id=2;");
		
		MariaDBTest.querySQL("select id,name remark from hz;");
		
		MariaDBTest.prepareStatementSQL("select id,name,remark from hz where id > ?;", 2);
		
		//MariaDBTest.execBatchSQL();
	
		MariaDBTest.transactionTest();
		
		MariaDBTest.ExitDB();
		
		/* 通讯demo
		new Thread(
	            
                ()->{
                	//System.out.println(Thread.currentThread().getName()+ " : TEST LAMBDA");
                	NetEcho.startServer();
                }

        ).start();

		new Thread(
	            
                ()->{
                	//System.out.println(Thread.currentThread().getName()+ " : TEST LAMBDA");
                	NetEcho.startClient();
                }

        ).start();
        
        //*/

		
		
		/**
		 * 字符编码务必要使用合适的字符集
		 * 
		 * GBK			中文国际编码，GBK包含简单中文与繁体中文，GB2312姿势包含简体中文  
		 * GB2312		
		 * 
		 * ISO8859-1	估计编码，可藐视任何文字信息，中文需要转码
		 * UNICODE		16进制编码，传递时尺寸过大
		 * UTF			瑟吉欧UNICODE的一种可变长度编码，常见的编码为UTF-8
		 * 
		 */
		
		
		
		/*
		
		// sun.jnu.encoding=GBK 这个是本例中的属性
		// objString.getBytes("GBK")
		// 如果没有GBK，可能输出的字节码会错乱
		System.getProperties().list(System.out);
		
		
		for (String item : args) {
			System.out.println(item);
		}
		
		JavaIO.MemoryStreamTest();
		
		
		regxTest();
		
		regxOfPatternTest();
		
		Reflect objReflect = new Reflect();
		
		objReflect.getClassTest();
		objReflect.getClassInstance();
		objReflect.getClassInstance2();
		objReflect.getClassInstance1();

		objReflect.getInstanceOfClass("Eclipse_HelloWorld");
		objReflect.getInstanceOfClass(objReflect);
		objReflect.getInstanceOfClass(Reflect.class);

		objReflect.DumpInfo(java.util.Date.class);
		objReflect.DumpInfo2(java.util.Date.class);
		objReflect.DumpInfo3(Reflect.class);
		
		Localization objLocalization = new Localization();
		objLocalization.DumpInfo();
		
		JavaIO objJavaIO = new JavaIO();
		
		objJavaIO.FileExist("e:\\java\\test\\1.txt");
		
		objJavaIO.ListFiles("F:\\git\\github\\lang_howto\\java\\");
		
		try (DestroyImpl objDestroyImpl = new DestroyImpl()){			
			objDestroyImpl.toString();
		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
		
		StreamTest objStreamTest = new StreamTest();
		
		// byte
		objStreamTest.FileOutputStreamTest("e:\\java\\test\\1.txt");
		
		
		objStreamTest.FileInputStreamTest("e:\\java\\test\\1.txt");
		
		// char
		System.out.println(".......");
		objStreamTest.FileWriteTest("e:\\java\\test\\1.txt");
		
		// byte --  char
		System.out.println("++++++++");
		objStreamTest.Char2ByteStreamChangeTest("e:\\java\\test\\1.txt");
		
		FileCopy.cp("D:\\SETUP\\Java\\jdk-8u231-windows-x64.exe", "D:\\\\SETUP\\\\Java\\\\jdk-8u231-windows-x64-dst.exe");
//*/
	}
	
	static void regxTest() {
		String str = "hello&*9909()mnnk3#GHJ$";

		String regx = "[^a-zA-Z]";
		String regx1 = "[^0-9]";

		System.out.println(str.replaceAll(regx, "-"));
		System.out.println(str.replaceAll(regx1, "-"));
	}
	
	static void regxOfPatternTest() {
		String str = "hwllo1yook22mldn333lixinghuaABCD8%^&klil";
		
		String regx = "\\d+";
		
		Pattern pt = Pattern.compile(regx);
		
		String res[] = pt.split(str);
		
		System.out.println(Arrays.deepToString(res));
		
		String str1 = "100";
		
		Pattern pt1 = Pattern.compile(regx);

		Matcher mt =pt1.matcher(str1);
		Matcher mt1 =pt1.matcher(str);
		

		System.out.println(mt.matches());
		System.out.println(mt1.matches());
		
	}
}
