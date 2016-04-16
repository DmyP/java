/**
 * 
 */
package textgen;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
        }
		catch (IndexOutOfBoundsException e) {}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {}

		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		try {
			shortList.remove(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {}

		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {}

		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			int b = longerList.remove(0);
			assertEquals("Remove: check b is correct ", i, b);
			assertEquals("Remove: check size is correct ", LONG_LIST_LENGTH - i - 1, longerList.size());
		}
		// TODO: Add more tests here +
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test +
        try {
            shortList.add(null);
            fail("Check invalid element");
        }
        catch (NullPointerException e) {

        }
        boolean state = emptyList.add(7);
        assertEquals("AddEnd: check state is correct ", true, state);
        assertEquals("AddEnd: check value is correct", (Integer)7, emptyList.get(0));
        assertEquals("AddEnd: check size is correct", 1, emptyList.size());

        state = emptyList.add(7);
        assertEquals("AddEnd: check state is correct ", true, state);
        assertEquals("AddEnd: check value is correct", (Integer)7, emptyList.get(1));
        assertEquals("AddEnd: check size is correct", 2, emptyList.size());
    }


	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test +
        assertEquals("Size: empty list ", 0, emptyList.size());
        assertEquals("Size: short list ", 2, shortList.size());
        assertEquals("Size: longer list ", 10, longerList.size());
        assertEquals("Size: list1 ", 3, list1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test +
        try {
            shortList.add(0, null);
            fail("Check invalid element");
        }
        catch (NullPointerException e) {}

        try {
            shortList.add(20, "A");
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {}

        try {
            longerList.add(-1, 10);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {}

        longerList.add(2, 8);
        assertEquals("AddAtIndex: check value is correct ", (Integer)8, longerList.get(2));
        assertEquals("AddAtIndex: check size is correct", 11, longerList.size());


        shortList.add(1, "A");
        assertEquals("AddAtIndex: check value is correct ", (String)"A", shortList.get(1));
        assertEquals("AddAtIndex: check size is correct", 3, shortList.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test +
        try {
            shortList.set(0, null);
            fail("Check invalid element");
        }
        catch (NullPointerException e) {}

        try {
            shortList.set(2, "C");
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {}

        try {
            longerList.set(-1, 10);
            fail("Check out of bounds");
        }
        catch (IndexOutOfBoundsException e) {}

        longerList.set(2, 7);
        assertEquals("AddAtIndex: check value is correct ", (Integer)7, longerList.get(2));
        assertEquals("AddAtIndex: check size is correct", 10, longerList.size());

        shortList.set(1, "A");
        assertEquals("AddAtIndex: check value is correct ", (String)"A", shortList.get(1));
        assertEquals("AddAtIndex: check size is correct", 2, shortList.size());
	}
	
	
	// TODO: Optionally add more test methods.
	
}
