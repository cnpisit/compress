package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

	Map<ByteArray, Integer> mp = new HashMap<ByteArray, Integer>();
	List<ByteArray> ls = new ArrayList<ByteArray>();

	public void add(ByteArray str) {
		mp.put(str, new Integer(ls.size()));
		ls.add(str);
	}

	public final int numFromStr(ByteArray str) {
		return (mp.containsKey(str) ? ((Integer) mp.get(str)).intValue() : -1);
	}

	public final ByteArray strFromNum(int i) {
		return (i < ls.size() ? (ByteArray) ls.get(i) : null);
	}

	public final int size() {
		return ls.size();
	}
};
