package Collection;

import java.util.Comparator;

public class BoxComparator<T extends Box<Integer,String>> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {

		if (o1.getIndex() == o2.getIndex())
		    return 0;
		else if (o1.getIndex() > o2.getIndex())
			return 1;
		else
			return -1;
	}

}
