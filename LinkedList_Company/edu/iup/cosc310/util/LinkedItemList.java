package edu.iup.cosc310.util;

/**
 * Class that creates a linked item list using Nodes
 * 
 * @author wgkt
 *
 * @param <E>
 */
public class LinkedItemList<E> implements ItemList<E> {
	private E[] items = (E[]) new Object[4];
	private int noItems = 0;
	private Node<E> firstNode;
	private Node<E> lastNode;

	/**
	 * Method to return a Node
	 * 
	 * @param i
	 * @return
	 */
	private Node<E> getNode(int i) {
		Node<E> p = firstNode;
		while (i-- > 0) {
			p = p.next;
		}
		return p;
	}

	/**
	 * Method to add a new item to end of list
	 */
	public void appendItem(E item) {
		if (firstNode == null) {
			firstNode = new Node<E>(item, null, null);
		} else {
			Node p = getNode(getNoItems() - 1);
			p.next = new Node(item, null, p);
		}
		resize();
		items[noItems++] = item;
	}

	/**
	 * Method to insert an item at a specific location
	 */
	public void insertItemAt(E item, int index) {
		if (index == 0) {
			firstNode = new Node(item, firstNode, null);
		} else if (index == noItems) {
			lastNode = new Node(item, lastNode, null);
		} else {
			Node p = getNode(index - 1);
			p.next = new Node(item, p.next, p);
		}
		resize();
		noItems++;
	}

	/**
	 * Method to clear the list
	 */
	public void clear() {
		items = null;
	}

	/**
	 * Method to get a specific item
	 */
	public E getItem(int index) {
		checkIndex(index);
		Node<E> p = getNode(index);

		return p.item;
	}

	/**
	 * Method to find the index of an item
	 */
	public int indexOf(E item) {
		return 0;
	}

	/**
	 * Method to create an instance of an item iterator
	 */
	public ItemIterator<E> iterator() {
		return new LinkedItemIterator<E>();
	}

	/**
	 * Method to remove an item at a specific location
	 */
	public E removeItemAt(int index) {
		checkIndex(index);
		E item = getItem(index);

		if (noItems == 1) {
			clear();
		} else if (index == 0) {
			firstNode = firstNode.next;
			firstNode.prev = null;
		} else if (index == noItems - 1) {
			lastNode = lastNode.prev;
			lastNode.next = null;
		} else {
			Node p = getNode(index);
			p.next.prev = p.prev;
			p.prev.next = p.next;
		}
		noItems--;
		return item;
	}

	/**
	 * Method to return the number of items in a list
	 */
	public int getNoItems() {
		return noItems;
	}

	/**
	 * Method to check that the index is a valid part of the list
	 * 
	 * @param index
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= noItems) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Method to resize the list if it reaches the end
	 */
	private void resize() {
		if (items.length == noItems) {
			E[] newItems = (E[]) new Object[2 * noItems];
			System.arraycopy(items, 0, newItems, 0, noItems);
			items = newItems;
		}
	}

	/**
	 * Method to remove an item by its name opposed to its location
	 */
	public boolean removeItem(E item) {
		Node<E> n = firstNode;
		int count = 0;
		while (!n.item.equals(item)) {
			n = n.next;
			count++;
		}
		if (count < noItems) {
			removeItemAt(count);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Private class to create Nodes
	 * 
	 * @author wgkt
	 *
	 * @param <E>
	 */
	private class Node<E> {
		private E item;
		private Node<E> next;
		private Node<E> prev;

		/**
		 * Constructor of a node
		 * 
		 * @param item
		 * @param next
		 * @param prev
		 */
		public Node(E item, Node<E> next, Node<E> prev) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}

	/**
	 * Private class creating a LinkedItemIterator
	 * 
	 * @author wgkt
	 *
	 * @param <E>
	 */
	private class LinkedItemIterator<E> implements ItemIterator<E> {
		private Node pos = firstNode.next;
		private Node lastPos = null;

		/**
		 * Method to see if an item has an item following it
		 */
		public boolean hasNextItem() {
			return pos != null;
		}

		/**
		 * Method to move to the next item in the list if possible
		 */
		public E nextItem() {
			if (hasNextItem() == true) {
				lastPos = pos;
				pos = pos.next;
				return (E) lastPos.item;
			} else {
				return null;
			}
		}

		/**
		 * Method to remove an item from the list.
		 */
		public void removeItem() {
			lastPos.prev.next = lastPos.next;
		}

	}

}
