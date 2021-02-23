package project;

import java.util.*;

public class HomeworkM3Driver {

	public static void main(String[] args) {		
		System.out.println("******************************TESTING Comparable AND compareTo******************************");
		Person p1 = new Person("Chip", "Munk", 123);			Person p2 = new Person("Trina", "Woods", 234);
		Person p3 = new Person("Trina", "Forest", 345);			Person p4 = new Person("holly", "wood", 456);
		Person p5 = new Person("Holly", "McRel", 567);			Person p6 = new Person("chip", "munk", 678);
		Person p7 = new Person("Holly", "Wood", 789);			Person p8 = new Person("anne", "teak", 890);
		Person[] people =  {p1, p2, p3, p4, p5, p6, p7, p8};
		Person[] sortedPeople = {p3, p5, p1, p6, p8, p4, p7, p2};
		System.out.println("Before sorting, array order is:");
		System.out.println(Arrays.toString(people));
		Arrays.sort(people);
		System.out.println("\nAfter sorting, the array order should match this:\n" + Arrays.toString(sortedPeople));
		System.out.println(Arrays.toString(people));
		if(!Arrays.equals(people,  sortedPeople)) {
			System.out.println("***Test failed: array not sorted correctly.");
		}
		

		System.out.println("\n\n******************************TESTING isSet(BagInterface) METHOD******************************");
		// parameter 1: the contents being added to the bag
		// parameter 2: the expected result (true if the bag is a set, false otherwise)
		// parameter 3: a description of the test
		testBagIsSet(new String[] {}, 							  true, "empty bag");
		testBagIsSet(new String[] {"hi"}, 						  true, "singleton bag");
		testBagIsSet(new String[] {"hi", "HI"}, 				  true, "bag with no duplicates");
		testBagIsSet(new String[] {"a", "b", "c", "d", "e", "f"}, true, "bag with no duplicates");
		testBagIsSet(new String[] {"a", "b", "d", "e", "c", "c"}, false, "bag with duplicates both added last");
		testBagIsSet(new String[] {"a", "c", "b", "d", "a"}, 	  false, "bag with duplicates added first and last");
		testBagIsSet(new String[] {"a", "b", "b", "c"}, 		  false, "bag with duplicates added in the middle");
		testBagIsSet(new String[] {"a", "a", "b", "c", "e", "f"}, false, "bag with duplicates added first");


		System.out.println("\n\n******************************TESTING createListContainingChar METHOD******************************");
		// parameter 1: the contents of the ListInterface
		// parameter 2: the target character
		// parameter 3: the contents of the expected answer ListInterface
		// parameter 4: a description of the test
		testCreateList(new String[] {}, 'z',
				       new String[] {},
				       "empty list");
		testCreateList(new String[] {"gab"}, 'a',
				      new String[] {"gab"},
				      "singleton list with a word that has the target char");
		testCreateList(new String[] {"zip"}, 'e',
				      new String[] {},
				      "singleton list with a word that does not have the target char");
		testCreateList(new String[] {"bid", "sing", "ennui", "i", "icky"}, 'i',
				       new String[] {"bid", "sing", "ennui", "i", "icky"},
			           "list with all elements containing the target character");
		testCreateList(new String[] {"bid", "sing", "ennui", "i", "icky"}, 'z',
			           new String[] {}, "list with no elements containing the target character");
		testCreateList(new String[] {"apple", "anna", "bob", "ANIMAL", "canal", "frog", "cat"}, 'a',
				       new String[] {"apple", "anna",                  "canal",         "cat"},
				       "list with elements that contain the target at beginning, middle, and end of the list");


		System.out.println("\n\n******************************TESTING lastPosition METHOD******************************");
		// parameter 1: the contents of the List
		// parameter 2: the target word
		// parameter 3: a description of the test
		testLastPosition(new String[] {}, "frank", "empty list");
		testLastPosition(new String[] {"hyde"}, "frank", "singleton list that doens't contain the target");
		testLastPosition(new String[] {"square"}, "square", "singleton list that contains the target");
		testLastPosition(new String[] {"apple", "teal", "carrot"}, "ball", "target not on the list");
		testLastPosition(new String[] {"bell", "gourd", "sound", "age", "friend"}, "age", "target on the list once in the middle of the list");
		testLastPosition(new String[] {"x", "a", "d", "x", "e", "c", "b", "x"}, "x", "target on the list more than once with last occurrence being in last position on the list");
		testLastPosition(new String[] {"x", "b", "d", "x", "b", "c", "b", "x"}, "b", "target on the list more than once with last occurrence in the middle");
		testLastPosition(new String[] {"f", "b", "g", "b", "v", "e", "c", "s"}, "f", "target on the list once at the beginning of the list");


		System.out.println("\n\n******************************TESTING equivalentLists METHOD******************************");
		// parameter 1: the contents of the ListInterface
		// parameter 2: the contents of the List
		// parameter 3: the expected result (true means equivalent, false means not)
		// parameter 4: a description of the test
		testEquivalentLists(new Integer[] {}, new Integer[] {}, true, "two empty lists");
		testEquivalentLists(new Integer[] {4}, new Integer[] {4}, true, "two singleton lists with the same element");
		testEquivalentLists(new Integer[] {1, 3, 1, 5, 7}, new Integer[] {1, 3, 1, 5, 7}, true, "equivalent lists (odd length)");
		testEquivalentLists(new Integer[] {1, 3, 1, 5, 7, 6}, new Integer[] {1, 3, 1, 5, 7, 6}, true, "equivalent lists (even length)");
		testEquivalentLists(new Integer[] {4}, new Integer[] {7}, false, "two singleton lists with different elements");
		testEquivalentLists(new Integer[] {}, new Integer[] {1, 3, 1, 5, 7}, false, "ListInterface is empty, List is not");
		testEquivalentLists(new Integer[] {1, 3, 1, 5, 7}, new Integer[] {}, false, "List is empty, ListInterface is not");
		testEquivalentLists(new Integer[] {1}, new Integer[] {1, 3, 1, 5, 7}, false, "difference sizes; the first elements match");
		testEquivalentLists(new Integer[] {1, 3, 1, 5}, new Integer[] {1, 3, 1, 5, 7}, false, "ListInterface has one fewer element than List");
		testEquivalentLists(new Integer[] {2, 4, 7, 6, 3}, new Integer[] {2, 4, 7, 6}, false, "List has one fewer element than ListInterface");
		testEquivalentLists(new Integer[] {1, 2, 3}, new Integer[] {4, 2, 3}, false, "only the first elements are different");
		testEquivalentLists(new Integer[] {1, 2, 3}, new Integer[] {1, 6, 7}, false, "only the first elements are the same");
		testEquivalentLists(new Integer[] {1, 2, 3}, new Integer[] {1, 3, 2}, false, "same elements but different order");
		testEquivalentLists(new Integer[] {2, 3, 5, 4}, new Integer[] {3, 2, 5, 4}, false, "last two elements are the same");


		System.out.println("\n\n******************************TESTING EXTRA CREDIT prioritizeMaximumValue METHOD******************************");
		// parameter 1: the contents of the List
		// parameter 2: the expected contents of the list after the max is prioritized
		// parameter 3: a description of the test
		testPrioritizeMax(new Integer[] {}, new Integer[]{}, "empty list");
		testPrioritizeMax(new Integer[] {4}, new Integer[]{4}, "singleton list");
		testPrioritizeMax(new Integer[] {4, 3, 2, 5, 7}, new Integer[]{7, 4, 3, 2, 5}, "maximum at the end of the list");
		testPrioritizeMax(new Integer[] {1, 3, 9, 5, 7}, new Integer[]{9, 1, 3, 5, 7}, "maximum in the middle of the list");
		testPrioritizeMax(new Integer[] {8, 3, 4, 5, 2}, new Integer[]{8, 3, 4, 5, 2}, "maximum at the beginning of the list");
	}
	
	public static boolean isSet(BagInterface<String> wordBag) {
		BagInterface<String> tempBag = new ArrayBag<>();
		boolean duplicate = false;

		while (!duplicate && !wordBag.isEmpty()) {
			String word = wordBag.remove();
			if (wordBag.getFrequencyOf(word) > 0) {
				duplicate = true;
			}
			tempBag.add(word);
		}

		while (!tempBag.isEmpty()) {
			wordBag.add(tempBag.remove());
		}

		return !duplicate;
	}

	public static ListInterface<String> createListInterfaceContainingChar(ListInterface<String> wordList, char key) {
		ListInterface<String> wordListWithCharacter = new AList<>();

		for (int i = 1; i <= wordList.getLength(); i++) {
			String word = wordList.getEntry(i);
			if (word.contains(String.valueOf(key))) {
				wordListWithCharacter.add(word);
			}
		}
		return wordListWithCharacter;
	}

	public static int lastPosition(List<String> wordList, String targetWord) {
		int lastIndex = -1;

//		for (int i = 0; i < wordList.size(); i++) {
//			if (wordList.get(i).equals(targetWord)) {
//				lastIndex = i;
//			}
//		}

		// Start from last position
		int index = wordList.size() - 1;

		while (lastIndex < 0 && index >= 0) {
			if (wordList.get(index).equals(targetWord)) {
				lastIndex = index;
			}
			index--;
		}

		return lastIndex;
	}

	public static boolean equivalentLists(ListInterface<Integer> numberListInterface, List<Integer> numberList) {
		int size = numberListInterface.getLength();

		if (!(size == numberList.size())) {
			return false;
		} else if (size == 0) {
			return true;
		} else {
			for (int i = 1; i <= size; i++) {
				if (!(numberListInterface.getEntry(i).equals(numberList.get(i - 1)))) {
					return false;
				}
			}
			return true;
		}
	}

	public static void prioritizeMaximumValue(List<Integer> numberList) {
		if (numberList.size() > 1) {
			int maxValue = numberList.get(0);
			int indexOfMaxValue = 0;

			for (int i = 1; i < numberList.size(); i++) {
				if (numberList.get(i) > maxValue) {
					maxValue = numberList.get(i);
					indexOfMaxValue = i;
				}
			}

			numberList.remove(indexOfMaxValue);
			numberList.add(0, maxValue);
		}
	}
	
	
	
	/*
	 * The methods below are designed to help support the tests cases run from main. You don't
	 * need to use, modify, or understand these methods. You can safely ignore them. :) 
	 */
	public static void testBagIsSet(String[] wordArray, boolean expectedResult, String testDescription) {
		BagInterface<String> wordBag;
		Random generator = new Random();
		if(generator.nextBoolean()) {
			wordBag = new ArrayBag<String>();
		} else {
			wordBag = new LinkedBag<String>();
		}
		for(String word : wordArray) {
			wordBag.add(word);
		}
		Object[] beforeBagArray = wordBag.toArray();
		Arrays.sort(beforeBagArray);

		boolean actualResult = isSet(wordBag);

		Object[] afterBagArray = wordBag.toArray();
		Arrays.sort(afterBagArray);

		System.out.println("\nTest of: " +  Arrays.toString(beforeBagArray));
		System.out.println("Set? Expected result = " + expectedResult + "\n     Actual result   = " + actualResult);

		if(actualResult!=expectedResult) {
			System.out.println("\t***Test failed for: " + testDescription);
			System.out.println("\tError: Method did not return expected result.");
		}
		if(!Arrays.equals(beforeBagArray, afterBagArray)) {
			System.out.println("\t***Test failed for: " + testDescription);
			System.out.println("\tError: The bag contents were changed.");
			System.out.println("\tBag contents before isSet invoked: " + Arrays.toString(beforeBagArray));
			System.out.println("\tBag contents after  isSet invoked: " + Arrays.toString(afterBagArray));
		}
	}

	public static void testCreateList(String[] wordArray, char c, String[] answerArray, String testDescription) {
		ListInterface<String> wordList = new AList<String>();
		for(String word : wordArray) {
			wordList.add(word);
		}
		ListInterface<String> answerList = new AList<String>();
		for(String word : answerArray) {
			answerList.add(word);
		}

		Object[] beforeListArray = wordList.toArray();
		Object[] answerListArray = answerList.toArray();

		ListInterface<String> resultList = createListInterfaceContainingChar(wordList, c);

		Object[] resultListArray = resultList.toArray();

		System.out.println("\nOriginal list:\t\t\t " + Arrays.toString(beforeListArray));
		System.out.println("Expected list of words with '" + c + "': " + Arrays.toString(answerListArray));
		System.out.println("Actual list of words with   '" + c + "': " + Arrays.toString(resultListArray));

		if(!Arrays.equals(answerListArray,  resultListArray)) {
			System.out.println("*****Test failed for: " + testDescription);
		}
		if(!Arrays.equals(beforeListArray, wordList.toArray())) {
			System.out.println("*****Test failed for: " + testDescription);
			System.out.println("     Error: The parameter list was changed.");
			System.out.println("     Original list contents after method invoked: " + Arrays.toString(wordList.toArray()));
		}
	}

	public static void testLastPosition(String[] wordArray, String target, String testDescription) {
		List<String> originalList = new ArrayList<String>(Arrays.asList(wordArray));
		int resultPosition = lastPosition(originalList, target);
		int correctPosition = originalList.lastIndexOf(target);

		System.out.println("\nOriginal list:\t\t " + originalList);
		System.out.println("Expected last index of   \"" + target + "\": " + correctPosition);
		System.out.println("Actual last index of     \"" + target + "\": " + resultPosition);

		if(resultPosition!=correctPosition) {
			System.out.println("*****Test failed for: " + testDescription);
		}
	}

	public static void testEquivalentLists(Integer[] listInterfaceContents, Integer[] listArrayContents, boolean expectedResult, String testDescription) {
		ListInterface<Integer> listInterface = new AList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for(int num : listInterfaceContents) {
			listInterface.add(num);
		}
		for(int num : listArrayContents) {
			list.add(num);
		}

		Object[] listInterfaceArrayBefore = listInterface.toArray();

		boolean actualResult = equivalentLists(listInterface, list);

		Object[] listInterfaceArrayAfter =listInterface.toArray();
		List<Integer> listAfter = new ArrayList<Integer>(list);

		System.out.println("\nListInterface:\t " + Arrays.toString(listInterfaceArrayBefore));
		System.out.println("List:         \t " + list);
		System.out.println("Expected result: " + expectedResult);
		System.out.println("Actual result:   " + actualResult);

		if(actualResult!=expectedResult) {
			System.out.println("*****Test failed for: " + testDescription);
		}
		if(!Arrays.equals(listInterfaceArrayBefore, listInterfaceArrayAfter)) {
			System.out.println("*****Test failed: ListInterface contents changed. Now contains:\n\t" +  Arrays.toString(listInterfaceArrayAfter));
		}
		if(!list.equals(listAfter)) {
			System.out.println("*****Test failed: List contents changed. Now contains:\n\t" +  listAfter);
		}

	}

	public static void testPrioritizeMax(Integer[] array, Integer[] result, String testDescription) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
		List<Integer> originalList = new ArrayList<Integer>(list);
		prioritizeMaximumValue(list);
		List<Integer> resultList = new ArrayList<Integer>(Arrays.asList(result));

		System.out.println("\nOriginal list: \t " + originalList);
		System.out.println("Expected result: " + resultList);
		System.out.println("Actual result:   " + list);

		if(!resultList.equals(list)){
			System.out.println("*****Test failed for: " + testDescription);
		}
	}
}
