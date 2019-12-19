
import java.util.Locale;

import java.util.ResourceBundle;
import java.text.MessageFormat;

public class Localization {
	/**
	 * getBundle
	 * getString
	 * 
	 * ���裺
	 * 
	 * 1�� �༭����Դ�ļ� *.properties
	 * 2. ����ֹ��༭����Ҫ��JDK�Ĺ���native2ascii.exe����ת��
	 * 3. ���ļ��ŵ�CLASSPATH·������
	 * 
	 * 	# key value 
		# >native2ascii abc.properties > ..\bin\abc_tar.properties
		# ����ŵ�CLASSPATH·����
		key1=����˭whoareyou.
		key2=hello {0},can you {1}!

	 * 
	 * 4. 
	 */
	private Locale m_objLocal;
	
	void DumpInfo() {
		m_objLocal = Locale.getDefault();
		System.out.println(m_objLocal + ":" + Locale.CHINESE);
		
		ResourceBundle rb = ResourceBundle.getBundle("abc_tar");

		System.out.println(rb.getString("key1"));
		System.out.println(rb.getString("key2"));
		System.out.println(
				MessageFormat.format(
					rb.getString("key2"),
					"gauss","work")
				);///**/
		
		// abc_tar_en_US.properties
		Locale enLoc = new Locale("en","US");
		
		ResourceBundle enRB = ResourceBundle.getBundle("abc_tar",enLoc);
		System.out.println(enRB.getString("key1"));
		// abc_tar_zh_CN.properties
		Locale zhLoc = new Locale("zh","CN");

		ResourceBundle zhRB = ResourceBundle.getBundle("abc_tar",zhLoc);
		System.out.println(zhRB.getString("key1"));
		
		
	}

}
