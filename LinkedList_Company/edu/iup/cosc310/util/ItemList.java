package edu.iup.cosc310.util;
/**
 * An ordered list of items.
 */
public interface ItemList<E> {

	/**
	 * Append an item to the end of the list
	 *
	 * @param item
	 *            – item to be appended
	 */
	public void appendItem(E item);

	/**
	 * Insert an item at a specified index position
	 *
	 * @param item
	 *            – item to be inserted
	 * @param index
	 *            – index position where to insert the item
	 * @throw IllegalArgumentException if index is < 0 or > no of items
	 */
	public void insertItemAt(E item, int index);

	/**
	 * Remove all items from the list
	 */
	public void clear();

	/**
	 * Return an item at a specified index
	 *
	 * @param index
	 *            – index of the item to return
	 * @return the item at the specified index
	 * @throw IllegalArgumentException if index is < 0 or >= no of items
	 */
	public E getItem(int index);

	/**
	 * Return the index of the first occurrence of an item in the list.
	 *
	 * @return index of the first occurrence in the list, -1 if not found
	 */
	public int indexOf(E item);

	/**
	 * Get an ItemIterator to iterate over items in the list.
	 * 
	 * @return an ItemIterator to iterate over items in the list
	 */
	public ItemIterator<E> iterator();

	/**
	 * Remove an item at a specified index
	 *
	 * @param index
	 *            – index of the item to be removed
	 * @return the removed item
	 * @throw IllegalArgumentException if index is < 0 or >= no of items
	 */
	public E removeItemAt(int index);

	/**
	 * Remove the first occurrence of an item in the list.
	 *
	 * @item – item to be removed
	 * @return true if an occurrence of the item was found and removed,
	 *         otherwise false
	 */
	public boolean removeItem(E item);

	/**
	 * Return the number of items currently in the list
	 *
	 * @return the number of items in the list
	 */
	public int getNoItems();
}