public class Practice {

    public static void main(String[] args) {
        BagInterface<String> statesBag = new ArrayBag<>();

        System.out.println(statesBag.isEmpty());
        statesBag.add("alaska");
        statesBag.add("california");
        statesBag.add("delaware");
        statesBag.add("california");
        statesBag.add("georgia");
        statesBag.add("delaware");
        statesBag.add("washington");
        statesBag.add("delaware");
        statesBag.add("iowa");
        System.out.println(statesBag.isEmpty());
        System.out.println(statesBag.getCurrentSize());
        System.out.println(statesBag.remove("california"));
        System.out.println(statesBag.contains("hawaii"));
        System.out.println(statesBag.getCurrentSize());
        System.out.println(statesBag.remove("washington"));
        System.out.println(statesBag.remove("new york"));
        System.out.println(statesBag.getCurrentSize());
        System.out.println(statesBag.remove("california"));
        System.out.println(statesBag.remove("california"));
        System.out.println(statesBag.getCurrentSize());
        System.out.println(statesBag.getFrequencyOf("delaware"));
        System.out.println(statesBag.getFrequencyOf("hawaii"));
    }
}
