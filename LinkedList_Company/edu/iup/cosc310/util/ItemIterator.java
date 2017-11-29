package edu.iup.cosc310.util;

/**
 * An iterator over an ItemList
 */
public interface ItemIterator<E> {

/**
 * Return true if the iteration has more items 
 *
 * @return true if the iteration has more items, otherwise false
 */
public boolean hasNextItem();

/**
 * Return next item from iteration
 *
 * @return next item from iteration
 * @throw NoSuchElementException if the iteration has no more items
 */
public E nextItem();

/**
 * Remove last item from returned iteration
 *
 * @throw NoSuchElementException if no item has been returned or if 
 *        the item has previously been deleted
 */
public void removeItem();

}
