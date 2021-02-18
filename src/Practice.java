import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {

        // For Practice Question 1:
        BagInterface<String> statesBag = new ArrayBag<>();

        System.out.println(statesBag.isEmpty());                            // true
        statesBag.add("alaska");
        statesBag.add("california");
        statesBag.add("delaware");
        statesBag.add("california");
        statesBag.add("georgia");
        statesBag.add("delaware");
        statesBag.add("washington");
        statesBag.add("delaware");
        statesBag.add("iowa");
        System.out.println(statesBag.isEmpty());                            // false
        System.out.println(statesBag.getCurrentSize());                     // 9
        System.out.println(statesBag.remove("california"));         // true
        System.out.println(statesBag.contains("hawaii"));                   // false
        System.out.println(statesBag.getCurrentSize());                     // 8
        System.out.println(statesBag.remove("washington"));         // true
        System.out.println(statesBag.remove("new york"));           // false
        System.out.println(statesBag.getCurrentSize());                     // 7
        System.out.println(statesBag.remove("california"));         // true
        System.out.println(statesBag.remove("california"));         // false
        System.out.println(statesBag.getCurrentSize());                     // 6
        System.out.println(statesBag.getFrequencyOf("delaware"));   // 3
        System.out.println(statesBag.getFrequencyOf("hawaii"));     // 0

        System.out.println(statesBag.remove());                             // delaware; however there were 6 items left
        // with 3 delaware, 1 georgia, 1 alaska and
        // 1 iowa so remove is random

        // For Practice Question 5:
        System.out.println(getFrequencyOf(statesBag, "delaware"));  // 2

        // For Practice Question 4:
        System.out.println("before clear: " + statesBag.isEmpty());         // before clear: false
        clear(statesBag);
        System.out.println("after clear: " + statesBag.isEmpty());          // after clear: true

        // For Practice Question 2:
        ListInterface<String> fruitVegListInterface = new AList<>();

        System.out.println(fruitVegListInterface.isEmpty());                // true
        fruitVegListInterface.add("carrot");
        fruitVegListInterface.add("banana");
        fruitVegListInterface.add("fig");
        fruitVegListInterface.add("eggplant");
        fruitVegListInterface.add("honeydew");
        fruitVegListInterface.add(2, "apple");
        fruitVegListInterface.add("kale");
        fruitVegListInterface.add(4, "durian");
        System.out.println(fruitVegListInterface.isEmpty());                // false
        System.out.println(fruitVegListInterface.getLength());              // 8
        System.out.println(fruitVegListInterface.getEntry(2));  // apple
        System.out.println(fruitVegListInterface.remove(2));    // apple
        System.out.println(fruitVegListInterface.getEntry(2));  // banana
        System.out.println(fruitVegListInterface.remove(1));    // carrot
        System.out.println(fruitVegListInterface.remove(2));    // durian
        System.out.println(fruitVegListInterface.remove(3));    // eggplant
        System.out.println(fruitVegListInterface.getLength());              // 4
        System.out.println(fruitVegListInterface.replace(2, "ginger")); // fig
        System.out.println(fruitVegListInterface.getEntry(2));  // ginger
        System.out.println(fruitVegListInterface.getEntry(3));  // honeydew

        // For Practice Question 7:
        System.out.println(getFrequencyOf(fruitVegListInterface, "kale"));  // 1

//        fruitVegListInterface.clear();
//        System.out.println(fruitVegListInterface.getLength());              // 0

        // For Practice Question 6:
        System.out.println("before clear: " + fruitVegListInterface.isEmpty()); // before clear: false
        clear(fruitVegListInterface);
        System.out.println("after clear: " + fruitVegListInterface.isEmpty());  // after clear: true

        // For Practice Question 3:
        List<String> wordList = new ArrayList<>();

        System.out.println(wordList.isEmpty());                             // true
        wordList.add("vase");
        wordList.add("juice");
        wordList.add("thread");
        wordList.add("next");
        wordList.add("sweet");
        wordList.add(2, "igloo");
        wordList.add("angle");
        wordList.add(1, "aloha");
        System.out.println(wordList.isEmpty());                             // false
        System.out.println(wordList.size());                                // 8
        System.out.println(wordList.get(2));                                // juice
        System.out.println(wordList.remove(2));                       // juice
        System.out.println(wordList.get(1));                                // aloha
        System.out.println(wordList.remove(0));                       // vase
        System.out.println(wordList.get(0));                                // aloha
        System.out.println(wordList.remove(1));                       // igloo
        System.out.println(wordList.remove(3));                       // sweet
        System.out.println(wordList.size());                                // 4
        System.out.println(wordList.set(2, "enter"));                       // next
        System.out.println(wordList.get(2));                                // enter
        System.out.println(wordList.get(3));                                // angle
        System.out.println(wordList.get(1));                                // thread

        // For Practice Question 8:
        System.out.println(getFrequencyOf(wordList, "thread")); // 1

        wordList.clear();
        System.out.println(wordList.size());                                // 0

        // For Practice Question 11:
        Computer[] compArray = new Computer[5];

        compArray[0] = new Computer("Apple", 256);
        compArray[1] = new Computer("HP", 512);
        compArray[2] = new Computer("Dell", 256);
        compArray[3] = new Computer("Toshiba", 512);
        compArray[4] = new Computer("Toshiba");

        System.out.println(Arrays.toString(compArray));
        // [Name: Apple	Memory Size: 256, Name: HP	Memory Size: 512, Name: Dell	Memory Size: 256,
        // Name: Toshiba	Memory Size: 512, Name: Toshiba	Memory Size: 128]
        Arrays.sort(compArray);
        System.out.println(Arrays.toString(compArray));
        // [Name: Apple	Memory Size: 256, Name: Dell	Memory Size: 256, Name: HP	Memory Size: 512,
        // Name: Toshiba	Memory Size: 128, Name: Toshiba	Memory Size: 512]

        // For Practice Question 12:
        Box<String> wordBox1 = new Box<String>("hello");
//        wordBox1.replaceContents("adios");
        wordBox1.replaceContents("bye");

        Box<String> wordBox2 = new Box<String>("hi");
        wordBox2.replaceContents("bye");

        System.out.println(wordBox1.compareTo(wordBox2));                       // 1 or -4 (if adios is commented out)

    }

    // For Practice Question 4:
    public static void clear(BagInterface<String> wordBag) {
        while (!(wordBag.isEmpty())) {
            wordBag.remove();
        }
    }

    // For Practice Question 5:
    public static int getFrequencyOf(BagInterface<String> wordBag, String targetWord) {
        BagInterface<String> tempBag = new ArrayBag<>();
        int count = 0;

        while (!wordBag.isEmpty()) {
            String word = wordBag.remove();

            if (word.equals(targetWord)) {
                count++;
            }

            tempBag.add(word);
        }

        while (!tempBag.isEmpty()) {
            wordBag.add(tempBag.remove());
        }

        return count;
    }

    // For Practice Question 6:
    public static void clear(ListInterface<String> wordList) {
        while (!wordList.isEmpty()) {
            wordList.remove(1);
        }
    }

    // For Practice Question 7:
    public static int getFrequencyOf(ListInterface<String> wordList, String targetWord) {
        int count = 0;

        for (int i = 1; i <= wordList.getLength(); i++) {
            if (wordList.getEntry(i).equals(targetWord)) {
                count++;
            }
        }

        return count;
    }

    // For Practice Question 8:
    public static int getFrequencyOf(List<String> wordList, String tartgetWord) {
        int count = 0;

        for (String word : wordList) {
            if (word.equals(tartgetWord)) {
                count++;
            }
        }

        return count;
    }

}

/*
Practice Question 9: similarity - collection of data; difference - bags are unorganized while lists are arganized

Practice Question 10: similarity - organized; difference - starting position is 1 (ListInterface) and 0 (List)
 */
