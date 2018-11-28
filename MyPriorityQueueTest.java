import static org.junit.Assert.*;

import org.junit.Test;

public class MyPriorityQueueTest {
	@Test
	public void testMyPriorityQueue() {
		MyPriorityQueue<String> test = new MyPriorityQueue<String>(new StringComparator());
		assertTrue("Should be 0", test.size() == 0);
	}

	public void testAdd() {
		MyPriorityQueue<String> test = new MyPriorityQueue<String>(new StringComparator());
		assertTrue(test.add("b"));
		test.add("c");
		test.add("a");
	}

	
	public void testAddNums() {
		MyPriorityQueue<String> test = new MyPriorityQueue<String>(new StringComparator());
		test.add("2");
		test.add("3");
		test.add("4");
		test.add("1");
		System.out.println(test.heap.get(0));
		System.out.println(test.heap.get(1));
		System.out.println(test.heap.get(2));
		System.out.println(test.heap.get(3));
	}
	@Test
	public void testRemove() {
		MyPriorityQueue<String> test = new MyPriorityQueue<String>(new StringComparator());
		test.add("2");
		test.add("3");
		test.add("4");
		test.add("1");
		System.out.println(test);
		System.out.println("\t" + test.remove());
		test.add("37");
		test.add("5");
		System.out.println(test);
		test.add("6");
		System.out.println(test);
		test.add("61");
		System.out.println(test);
		System.out.println(test.remove());
		System.out.println(test);
		}

	public void testToString() {
		MyPriorityQueue<String> test = new MyPriorityQueue<String>(new StringComparator());
		test.add("c");
		test.add("b");
		test.add("a");
		assertEquals("Should be c b a", "c b a ", test.toString());
	}

	public void testIsEmpty() {
		MyPriorityQueue<String> test = new MyPriorityQueue<String>(new StringComparator());
		assertTrue("Should be 0", test.isEmpty());
	}

	public void testSize() {
		MyPriorityQueue<String> test = new MyPriorityQueue<String>(new StringComparator());
		test.add("c");
		test.add("b");
		test.add("a");
		test.remove();
		assertTrue("Size should be 2", test.size() == 2);
	}

	public void testClear() {
		MyPriorityQueue<String> test = new MyPriorityQueue<String>(new StringComparator());
		test.add("c");
		test.add("b");
		test.add("a");
		assertEquals("Should be c b a", "c b a ", test.toString());
		test.clear();
		assertEquals("Should be blank", "", test.toString());
	}

}
