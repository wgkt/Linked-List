package edu.iup.cosc310.util;
/**
 * Class to test that the LinkedItemList methods work
 * @author wgkt
 *
 */
public class TestLinkedItemList {
/**
 * Main class to test LinkedItemList methods
 * @param args
 */
	public static void main(String[] args) {
		LinkedItemList<String> list = new LinkedItemList<String>();

		assert list.getNoItems() == 0 : "Expected 0 items, got: "
				+ list.getNoItems();

		list.appendItem("A");
		list.appendItem("B");
		list.appendItem("C");
		
        //Tests if getNoItems() returns proper amount of items
		assert list.getNoItems() == 3 : "Expected 3 items, got: "
				+ list.getNoItems();
		
		//Tests if getItem returns proper item
		assert "A".equals(list.getItem(0)) : "Expected getItem(0) = A, got: "
				+ list.getItem(0);
		assert "C".equals(list.getItem(2)) : "Expected getItem(2) = C, got: "
				+ list.getItem(2);

		list.insertItemAt("0", 0);
		list.insertItemAt("1", 1);
		list.insertItemAt("2", 2);

		// tests if insertItemAt is working properly
		assert "0".equals(list.getItem(0)) : "Expect getItem(0) = 0, got: "
				+ list.getItem(0);
		assert "1".equals(list.getItem(1)) : "Expect getItem(1) = 1, got: "
				+ list.getItem(1);
		assert "2".equals(list.getItem(2)) : "Expect getItem(2) = 2, got: "
				+ list.getItem(2);
		assert "A".equals(list.getItem(3)) : "Expect getItem(3) = A, got: "
				+ list.getItem(3);

		list.removeItemAt(0);
		list.removeItemAt(0);
		list.removeItemAt(0);
        
		//Tests if removeItem works
		assert "A".equals(list.getItem(0)) : "Expect getItem(0) = A, got: "
				+ list.getItem(0);
		assert "B".equals(list.getItem(1)) : "Expect getItem(1) = B, got: "
				+ list.getItem(1);
		assert "C".equals(list.getItem(2)) : "Expect getItem(2) = C, got: "
				+ list.getItem(2);

		
		list.removeItem("B");
		
		assert "C".equals(list.getItem(1)) : "Expected getItem(1) = C, got: " + list.getItem(1);
		
//		System.out.println(list.getItem(0));
//		System.out.println(list.getItem(1));
//      System.out.println(list.getItem(2));
//
//		System.out.println(list.getNoItems());
		
		ItemIterator<String> iterator = list.iterator();
		//Tests is there is a next item - should print true
		//System.out.println(iterator.hasNextItem());
		
		assert iterator.hasNextItem() == true : "Expected true, got: " + iterator.hasNextItem();
		
        //Moves iterator the the next item
		String item = iterator.nextItem();
		//Removes the item
		iterator.removeItem();
		//Moves to next item - item is not there
		item = iterator.nextItem();

		assert iterator.nextItem() == null : "Expected null, got: " + iterator.nextItem();
		
		
		assert iterator.hasNextItem() == false : "Expected true, got: " + iterator.hasNextItem();
		
		System.out.println("done");
		
	}

}
