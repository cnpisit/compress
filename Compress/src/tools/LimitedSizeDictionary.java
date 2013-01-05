package tools;

public class LimitedSizeDictionary extends Dictionary {
	int maxSize;

	LimitedSizeDictionary(int maxSize) {
		this.maxSize = maxSize;
	}

	public void add(ByteArray str) {
		if (size() < maxSize) {
			super.add(str);
		}
	}
}
