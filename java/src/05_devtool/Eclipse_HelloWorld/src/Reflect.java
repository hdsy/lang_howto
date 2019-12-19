import java.util.Date;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class Reflect {

	/**
	 * 反射实例化对象
	 * 
	 * forName			通过字符串设置的类名称实例化Class类对象
	 * getInterfaces	取得类实现的所有接口
	 * getName			取得反射操作类的全名
	 * getPackage		取得反射操作类所在的包
	 * getSuperclass	取得反射操作类的父类
	 * isEnum			是否是枚举
	 * isInterface		是否是接口
	 * isArray			是否数组
	 * newInstance		反射实例化对象 ************
	 */
	private Class<?> objClass;
	
	public String objString;
	
	private int objInt;
	
	public void getClassTest() {
		Date dt = new Date();

		System.out.println(dt.getClass());
	}
	

	/**
	 * object.getClass
	 * 用以获取类名
	 */
	public void getClassInstance() {
		Date dt = new Date();


		Class<?> cls = dt.getClass();

		System.out.println(cls.getName());
	
		
	}
	/**
	 * class.class
	 * 用类名使用 ： java.util.Date.class
	 */
	public void getClassInstance1() {


		Class<?> cls = java.util.Date.class;

		System.out.println(cls.getName());

		
	}
	/**
	 * Class.forName(classname)
	 * Class.forName(java.util.Date)
	 */
	public void getClassInstance2() {

		try {
			Class<?> cls = Class.forName("java.util.Date");
	
			System.out.println(cls.getName());
		}catch(Exception exp) {
			exp.printStackTrace();
		}

		
	}
	
	public void getInstanceOfClass(String arg) {
		try {
			Class<?> cls = Class.forName(arg);
	
			System.out.println(cls.getName());
			
			Object obj = cls.newInstance();
			
			System.out.println(obj.getClass() + ":" + obj.toString());
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public void getInstanceOfClass(Object arg) {
		try {
			Class<?> cls = arg.getClass();
	
			System.out.println(cls.getName());
			
			Object obj = cls.newInstance();
			
			System.out.println(obj.getClass() + ":" + obj.toString());
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	
	public void getInstanceOfClass(Class<?> incls) {
		try {
			Class<?> cls = incls;
	
			System.out.println(cls.getName());
			
			Object obj = cls.newInstance();
			
			System.out.println(obj.getClass() + ":" + obj.toString());
			
			
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	/**
	 * Function & Variable
	 * @param incls
	 * 
	 * getMethods
	 * getMethod
	 * 
	 * getReturnType
	 * getParameterCount
	 * getParameterTypes
	 * invoke
	 * getExceptionTypes
	 * 
	 * 
	 * ----
	 * getDeclaredFields
	 * getDeclaredField
	 * getFields
	 * getField
	 * 
	 * getType
	 * get
	 * set
	 * 
	 */
	public void DumpInfo2(Class<?> incls) {
		//Date dt = new Date();
		
		//dt.getDate();
		//dt.setDate(date);
	
		
		
		// Method 
		try {
			Object obj = incls.newInstance();
			
			Method objGetDate = incls.getMethod("getDate");
			Method objSetDate = incls.getMethod("setDate", int.class);
	
			System.out.println(objGetDate.invoke(obj));
			
	
			objSetDate.invoke(obj,12);
			
			System.out.println(objGetDate.invoke(obj));
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	public void DumpInfo3(Class<?> incls) {
		//Reflect
	
		//Variable
		try {
			Object obj = incls.newInstance();
			
			Field objInt = incls.getDeclaredField("objInt");
			Field objString = incls.getDeclaredField("objString");

			System.out.println(objInt.get(obj));
			
			objInt.setAccessible(true);
			objInt.set(obj, 100);
			System.out.println(objInt.get(obj));
			

			System.out.println(objString.get(obj));
			objString.set(obj, "abcd");
			System.out.println(objString.get(obj));
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		
		
	}
	
	/**
	 * Constructor
	 * @param incls
	 */
	public void DumpInfo(Class<?> incls) {
		try {
			Class<?> cls = incls;
			
			Constructor<?> objConstructor = incls.getConstructor();
			
			{
				
				System.out.print(objConstructor.getName()+":"+objConstructor.getParameterCount() + "(");
				
				Class<?> [] arrClass = objConstructor.getParameterTypes();
				
				for(Class<?>itemClass :arrClass) {
					System.out.print(itemClass.getName()+",");
				}
				System.out.println(")");
			}
			
			
			Constructor<?> [] arrConstructor = incls.getConstructors();
			
			for(Constructor<?>  cons:arrConstructor) {
	
				System.out.print(cons.getName()+":"+cons.getParameterCount() + "(");
				
				Class<?> [] arrClass = cons.getParameterTypes();
				
				for(Class<?>itemClass :arrClass) {
					System.out.print(itemClass.getName()+",");
				}
				System.out.println(")");
			}
			
			
			
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	
	
	
}

