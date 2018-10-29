package LinkedListA0;

public class LinkedListPlayground {

	public static void main(String[] args) {
		/*
		 * here you can instantiate your LinkedList and play around with it to
		 * check correctness. We've graciously also provided you a bit of extra
		 * test data for debugging. It doesn't matter what you have in here. We
		 * will not grade it. This is for your use in testing your
		 * implementation.
		 */
		 //test1();
		//test2();
		//testGet();
//		RemoveTest0: insert(7,0),insert(9,1),insert(4,1),insert(8,3),insert(6,3),remove(1) --> 7,9,6,8
		LinkedListImpl L = new LinkedListImpl();
//		L.insert(new Node(7), 0);
//		L.insert(new Node(9), 1);
//		L.insert(new Node(4), 1);
//		L.insert(new Node(8), 3);
//		L.insert(new Node(6), 3);
//		L.remove(1);
//		printList(L);
		
//		RemoveTest1: insert(1,0),insert(2,1),insert(3,2),insert(1,1),insert(4,4),remove(4) --> 0,1,2,3
//		 and remove(4) should return true
//		1 
//		1 2
//		1 2 3 
//		1 1 2 3 
//		1 1 2 3 4
		// 1 1 2 3 
//		L.insert(new Node(0), 0);
//		L.insert(new Node(2), 1);
//		L.insert(new Node(3), 2);
//		L.insert(new Node(1), 1);
//		L.insert(new Node(4), 4);
//		printList(L);
//		L.remove(4);
//		printList(L);
//		 
//		RemoveTest2: insert(1,0),insert(5,1),insert(9,2),insert(3,2),remove(0),remove(0),remove(1) --> 3
//		L.insert(new Node(1), 0);
//		L.insert(new Node(5), 1);
//		L.insert(new Node(9), 2);
//		L.insert(new Node(3), 2);
//		L.remove(0);
//		L.remove(0);
//		L.remove(1);
//		printList(L);
//
//		RemoveTest3:  remove(0) on empty list should return false
//			and remove(0) on non-empty list should return true
//			and remove(0),insert(0,0),insert(1,1),insert(2,2),remove(5),remove(0) --> 1,2
		//L.insert(new Node (0), 0);
		System.out.println(L.remove(0));
//
//			
//			
//		SizeTest0: size(new List) --> 0
//
//		SizeTest1: size(insert(20.0,0),insert(20.0,1)) --> 2
//
//		SizeTest2: size(insert(3,0),remove(0)) --> 0
//
//		SizeTest3: size(insert(3,0),insert(2,1),insert(1,2),insert(1,100),remove(17)) --> 3
//			and size(insert(3,0),insert(2.0,1),insert(1,2),insert(1,100),remove(17),clear()) --> 0
//
//			
//			
//		ClearTest0: insert(5,0),insert(5,0),clear(),insert(6,0),insert(4,1) --> 6,4
//
//		ClearTest1: clear(),insert(2,0),insert(7,1),insert(8,1),remove(0),clear(),insert(4,0) --> 4
//
//
//
//		GetTest0: calling get(0) on list: {3,5,4} should return Node containing data 3
//			and calling get(1) on list: {3,5,4} should return Node containing data 5
//			and calling get(2) on list: {3,5,4} should return Node containing data 4
//			
//		GetTest1: calling get(0) on empty list should return null
//			and calling get(1) on list: {3} should return null
//			
//
//
//		InsertTest0: insert(5,0) --> 5
//
//		InsertTest1: insert(2,0),insert(1,0),insert(0,0) --> 0,1,2
//
//		InsertTest2: insert(0,0),insert(1,1),insert(2,2),insert(3,3),insert(4,4) --> 0,1,2,3,4
//
//		InsertTest3: insert(0,1) on empty list --> empty
//			and insert(0,1) on empty list should return false
//			and insert(1,3) on list: {0,1} should leave the list unchanged
	}

	public static void test1() {
		LinkedListImpl L = new LinkedListImpl();
		System.out.println(L.isEmpty());
		printList(L);
		L.clear();
		System.out.println(L.isEmpty());
		printList(L);
		System.out.println(L.root.toString());
		L.insert(new Node(3.3), 0);
		System.out.println(L.isEmpty());
		printList(L);
		System.out.println(L.root.next.toString());
		L.insert(new Node(3.4), 0);
		L.insert(new Node(3.5), 0);
		L.insert(new Node(3.67), 1);
		L.insert(new Node(3.357), 0);
		L.insert(new Node(3.333), 4);
		System.out.println(L.size());
		printList(L);
		L.remove(3);
		System.out.println(L.size());
		printList(L);
		L.clear();
		L.insert(new Node(3.4), 0);
		L.insert(new Node(3.5), 0);
		L.insert(new Node(3.67), 1);
		L.insert(new Node(3.357), 0);
		L.insert(new Node(3.333), 3);
		L.remove(0);
		System.out.println(L.size());
		printList(L);
		L.clear();
		printList(L);
	}

	public static void test2() {
		LinkedListImpl L = new LinkedListImpl();
		L.insert(new Node(3.4), 0);
		L.insert(new Node(3.5), 1);
		L.insert(new Node(3.67), 2);
		L.remove(0);
		System.out.println(L.size());
		printList(L);
	}
	public static void testGet(){
		LinkedListImpl L = new LinkedListImpl();
        L.insert(new Node(4.546), 0);
        L.insert(new Node(6.290354), 0);
        System.out.println(L.get(1));
    }

	public static void printList(LinkedListImpl L) { // note that this is a good
														// example of how to
														// iterate through your
														// linked list
		Node curr = L.root;
		for (int i = -1; i < L.size(); i++) { // -1 b/c the 0th node in list is
												// the one after root. Root is
												// just the entry point!
			System.out.print(curr.data + " --> ");
			curr = curr.next;
		}
		System.out.println();
	}
}