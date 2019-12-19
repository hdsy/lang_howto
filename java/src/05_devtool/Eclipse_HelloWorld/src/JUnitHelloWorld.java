import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class JUnitHelloWorld {

	@Test
	void testCollectionFrame() {
		CollectionFrame.CollectionTest();
		CollectionFrame.ListTest();
		CollectionFrame.SetTest();
		CollectionFrame.vectorTest();
		CollectionFrame.mapTest();
		
		CollectionFrame.stackTest();
		CollectionFrame.collectionsTest();
		CollectionFrame.propertiesTest();
		
		try {
			TestCase.assertTrue(true);
			
			fail("abc");
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}

}
