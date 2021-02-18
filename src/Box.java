import java.util.ArrayList;

public class Box<T extends Comparable<? super T>> implements Comparable<Box<T>>{
	
	private T thing;
	private ArrayList<T> history;

	public Box(T firstThing) {
		this.thing = firstThing;
		history = new ArrayList<>();
		history.add(firstThing);
	}
	
	public T getContents() {
		return thing;
	}

	public int getCount() {
		return history.size();
	}

	public ArrayList<T> getHistory() {
		return history;
	}

	public void replaceContents(T newThing) {
		this.thing = newThing;
		history.add(newThing);
	}
	
	@Override
	public String toString() {
		return thing.toString() + " (item " + history.size() + ")";
	}
	
	@Override
	public boolean equals(Object other) {
		if(other instanceof Box<?>) {
			Box<?> otherBoxR = (Box<?>) other;
			
			boolean sameThing = this.thing.equals(otherBoxR.thing);
			boolean sameCount = this.history.size()==otherBoxR.history.size();
			
			return sameThing && sameCount;
			
		} else {
			return false;
		}
	}

	public boolean contains(T someThing) {
		return this.thing.equals(someThing);
	}

	public boolean replaceIfDifferent(T someThing) {
		if (contains(someThing)) {
			return false;
		} else {
			replaceContents(someThing);
			return true;
		}
	}

	public boolean hasDuplicates() {
		if (history.contains(thing)) {
			return true;
		} else {
			for (int i = 0; i < history.size(); i++) {
				T thing1 = history.get(i);

				for (int j = i + 1; j < history.size(); j++) {
					if (thing1.equals(history.get(j))) {
						return true;
					}
				}
			}
			return false;
		}
	}

	@Override
	public int compareTo(Box<T> other) {
		int thingComparison = this.thing.compareTo(other.thing);

		if (thingComparison == 0) {
			if (this.history.size() < other.history.size()) {
				return -1;
			} else if (this.history.size() > other.history.size()) {
				return 1;
			} else { // same number of replacements
				return this.history.get(0).compareTo(other.history.get(0)); // compare first item in history
			}
		} else {
			return thingComparison;
		}
	}
}
