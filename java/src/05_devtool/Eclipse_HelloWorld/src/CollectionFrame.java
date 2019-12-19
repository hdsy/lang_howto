import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

/**
 * Iterable<e>
 * 	Collection<e>	add,allAll,clear,contains,isEmpty,remove,size,toArray,iterator
 * 		List<e>		get,set,listIterator
 * 		Set<e>		objec需要实现Comparable接口
 * 	
 * @author Administrator
 *
 */
public class CollectionFrame {
	
	/**
	 * Collections
	 * 
	 * 	tools for list set map
	 */
	
	public static void collectionsTest() {
		
		List<String> all = new ArrayList<String>();
		
		Collections.addAll(all, "abcd","bcde","cdef","defg","efgh");
		
		Collections.reverse(all);
		
		System.out.println(all);
	}
	
	/**
	 * Properties
	 * 	Object setProperty(String key,String value)
	 * 	String getProperty(String key)
	 * 	String getProperty(String key,String defaultValue);
	 * 	void store(OutputStream out,String comments) throws IOException
	 * 	void load(InputStream inStream)  throws IOException
	 * 
	 */
	public static void propertiesTest() {
		Properties objProperties = new Properties();

		objProperties.setProperty("name1", "value1");
		objProperties.setProperty("name2", "value2");
		objProperties.setProperty("name3", "value3");
		objProperties.setProperty("name4", "value4");

		System.out.println(objProperties.getProperty("name1"));
		System.out.println(objProperties.getProperty("name5"));
		System.out.println(objProperties.getProperty("name5","not exist"));
		
		try {
			objProperties.store(new FileOutputStream(new File("E:"+File.separator+"test.properties")), "test");

		}catch(Exception exp) {
			exp.printStackTrace();
		}
		
	}
	
	/**
	 * Stack
	 * 	E push(E item)
	 * 	E pop()
	 * 
	 */
	public static void stackTest() {
		Stack<String> objStack = new Stack<String>();
		
		objStack.push("abcd");
		objStack.push("abcd2");
		objStack.push("abcd3");
		objStack.push("abcd4");
		
		System.out.println("Stack :" + objStack);
	}
	
	/**
	 * V put (K key,V value)
	 * V get (Object key>
	 * Set<Map.Entry<K,V>> entrySet()  	// 将map集合转化为set集合
	 * Set <K> keySet()
	 * 
	 * 
	 * Hashtable   vs    HashMap
	 * 	
	 * 	k1.0+				jdk1.2+
	 * 	同步处理				异步处理
	 * 	线程安全				非线程安全
	 * 	不允许null				可有null
	 * 
	 * 
	 * 只要是实现hashCode和equals方法的类，其对象，都恶意作为map的key
	 * 
	 */
	public static void mapTest() {
		Map<String , Integer> mapString2Integer = new HashMap<String,Integer>();

		mapString2Integer.put("one", 1);
		mapString2Integer.put("three", 3);
		mapString2Integer.put("nine", 9);
		mapString2Integer.put("two", 2);
		mapString2Integer.put("one", 10);
		mapString2Integer.put(null, 0);		// special ,cannot be used in HashTable;
		
		System.out.println("HashMap of String2Integer : " + mapString2Integer);

		System.out.println(mapString2Integer.get("nine"));
		System.out.println(mapString2Integer.get(null));
		
		
		Map<String , Integer> mapString2IntegerHash = new Hashtable<String,Integer>();

		mapString2IntegerHash.put("one", 1);
		mapString2IntegerHash.put("three", 3);
		mapString2IntegerHash.put("nine", 9);
		mapString2IntegerHash.put("two", 2);
		mapString2IntegerHash.put("one", 10);
		// mapString2IntegerHash.put(null, 0);		// special ,cannot be used in HashTable;
		
		System.out.println("HashTable of String2Integer : " + mapString2IntegerHash);

		System.out.println(mapString2IntegerHash.get("nine"));
		//System.out.println(mapString2IntegerHash.get(null)); // no null in hashTable
		
		
		Set <Map.Entry<String, Integer>> setTemp = mapString2IntegerHash.entrySet();
		
		Iterator<Map.Entry<String,Integer>> iter = setTemp.iterator();
		
		while(iter.hasNext()) {
			Map.Entry<String, Integer> me = iter.next();
			
			System.out.println(me.getKey()+"=" + me.getValue());
		}
		
		
	}
	
	public static void  vectorTest() {
		Vector <String> all = new Vector<String>();

		all.add("abcde.com.cn");
		all.add("bbcde.com.cn");
		all.add("ebcde.com.cn");
		all.add("zbcde.com.cn");


		all.add("abcde.com.cn");
		all.add("nbcde.com.cn");		all.add("abcde.com.cn");

		Enumeration<String> enu = all.elements();
		
		while (enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	}
	

	public static void SetTest() {
		Set<String> objSet = new HashSet<String>();

		objSet.add("first");
		objSet.add("first");
		objSet.add("first1");
		objSet.add("third");
		objSet.add("four");
		objSet.add("second");
		
		System.out.println("HashSet:"+objSet);
		
		Set<String> objSetTree = new TreeSet<String>();

		objSetTree.add("first");
		objSetTree.add("first");
		objSetTree.add("first1");
		objSetTree.add("third");
		objSetTree.add("four");
		objSetTree.add("second");
		
		System.out.println("TreeSet:"+objSetTree);
		
		Set<Book> objBookSet = new HashSet<Book>();

		objBookSet.add(new Book("ABC",123));
		objBookSet.add(new Book("BBC",223));
		objBookSet.add(new Book("CBC",323));
		objBookSet.add(new Book("DBC",423));
		objBookSet.add(new Book("EBC",523));

		objBookSet.add(new Book("ABC",123));
		
		System.out.println("HashSet of Book : " + objBookSet);
		
		

		Set<Book> objBookSetTree = new TreeSet<Book>();

		objBookSetTree.add(new Book("ABC",123));
		objBookSetTree.add(new Book("BBC",223));
		objBookSetTree.add(new Book("CBC",323));
		objBookSetTree.add(new Book("DBC",423));
		objBookSetTree.add(new Book("EBC",523));

		objBookSetTree.add(new Book("ABC",123));
		
		System.out.println("TreeSet of Book : " + objBookSetTree);

	}

	public static  void CollectionTest() {
		Collection<String> objCollectionString = new ArrayList<String>();
		
		objCollectionString.add("abc");
		objCollectionString.add("def");
		objCollectionString.add("ghj");
		
		for(String itm:objCollectionString) {
			System.out.println(itm);
		}
		
		Object objs[] = objCollectionString.toArray();
		for(int x = 0;x < objs.length;x++) {
			System.out.println((String)objs[x]);
			
		}
		
		System.out.println(objCollectionString);
		
		Iterator<String> iter = objCollectionString.iterator();
		
		while(iter.hasNext()) {
			System.out.println("iterator : " + iter.next());
		}
		
		
		
	}
	
	public static void ListTest() {
		List<String > objListString = new ArrayList<String>();
		
		System.out.println("size is " + objListString.size() + " isEmpty : " + objListString.isEmpty());

		objListString.add("List abc");
		objListString.add("List def");
		objListString.add("List ghj");
		objListString.add("List klm");
		System.out.println("size is " + objListString.size() + " isEmpty : " + objListString.isEmpty());
		
		for(int x = 0;x<objListString.size();x++) {
			System.out.println(objListString.get(x));
			
		}
		

		for(String itm:objListString) {
			System.out.println(itm);
		}
		
		System.out.println(objListString);
		
		Iterator<String> iter = objListString.iterator();
		
		while(iter.hasNext()) {
			System.out.println("iterator : " + iter.next());
		}
		
		ListIterator<String> iterList = objListString.listIterator();
		
		while(iterList.hasNext()) {
			System.out.println("iterator of list next : " + iterList.next());
		}
		// 
		while(iterList.hasPrevious()) {
			System.out.println("iterator of list prev : " + iterList.previous());
		}
		
		
	}
	
	
}
