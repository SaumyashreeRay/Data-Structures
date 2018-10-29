/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedListA0;

public class LinkedListImpl implements LIST_Interface {
	Node root;// this will be the entry point to your linked list (the head)
	int size;

	public LinkedListImpl() {// this constructor is needed for testing purposes.
								// Please don't modify!
		root = new Node(0); // Note that the root's data is not a true part of
							// your data set!
		size = 0;
	}

	// implement all methods in interface, and include the getRoot method we
	// made for testing purposes. Feel free to implement private helper methods!

	public Node getRoot() { // leave this method as is, used by the grader to
							// grab your linkedList easily.
		return root;
	}

	@Override
	public boolean insert(Node n, int index) {
		Node current = null, previous = null;
		
		if ((index < 0) || (index > this.size())) {
			return false; //index out of bounds
		} else {
			//getting previous node
			if (index == 0) {
				previous = root;
				} else {
				previous = this.get(index - 1);
				}
			
			current = this.get(index);
			n.next = current;
			previous.next = n;
			size++;
			return true;
		}
	}

	@Override
	public boolean remove(int index) {
		Node prev = null, current = null, newnext = null;
		if (isEmpty() && index == 0){
			return false;
		}
		if (index < 0) {
			return false;
		} else if (index > this.size()) {
			return false;
		} else {
			current = this.get(index);
			newnext = this.get(index + 1);
			
			//getting previous node
			if (index == 0) {
			prev = root;
			} else {
			prev = this.get(index - 1);
			}
			
			//removing from beginning or end of list
			if ( ((index == 0) && (size == (index+1))) || (index == (size-1))){
				current.next = null;
				prev.next = null;
				size--;
				return true;
			}
			else{
				prev.next = newnext;
				current.next = null;
				size--;
				return true;
			}
		}
	}

	@Override
	public Node get(int index) {
		Node temp = root;
		if ((index < 0) || (index > (this.size()) - 1)) {
			return null;
		} else {
			for (int i = -1; i < this.size(); i++) {
				if (i == index) {
					return temp;
				}
				temp = temp.next;
			}
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (root.getNext() == null){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		root.next = null;
		size = 0;

	}
}
