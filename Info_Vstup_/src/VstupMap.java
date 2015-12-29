import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class VstupMap {
	
	private HashMap<Key, LinkedList<Info>> lis;

	VstupMap() {
		lis = new HashMap<Key, LinkedList<Info>>();
	}

	public void add(String univer, String department, String direction,
			String fio, String att) {
		Key j = new Key(univer);
		LinkedList<Info> g;
		g = lis.get(j);
		if (g == null) {
			g = new LinkedList<Info>();
		}
		Info gg = new Info(department, direction, fio, att);
		g.add(gg);
		lis.put(j, g);
	}

	public Collection<Info> get(String univer) {
		Key k = new Key(univer);
		LinkedList<Info> h = lis.get(k);
		if (h == null) {
			h = new LinkedList<Info>();
			h.add(new Info("", "", "", ""));
		}
		return h;
	}

	public static void main(String[] args) {

		VstupMap m = new VstupMap();
		m.add("KhNU", "FKN", "CS", "Petrov Petr Petrovich", "50.0");
		m.add("KhPI", "KIT", "SE", "Ivanov Ivan Ivanovich", "51.0");
		m.add("KhNURE", "SE", "ISPR", "Petrov Petr Petrovich", "50.0");
		m.add("KhNU", "FKN", "CS", "Ivanov Ivan Ivanovich", "51.0");

		Collection<Info> infos = m.get("KhNU");
		for (Info inf : infos) {
			System.out.println(inf);
		}

	}

}

class Info {
	public String department, direction;
	public String fio;
	public String att;

	public Info(String department, String direction, String fio, String att) {
		this.department = department;
		this.direction = direction;
		this.fio = fio;
		this.att = att;
	}

	public String toString() {
		return fio + "\t" + att + "\n";
	}
}

class Key {
	public String univer;

	public Key(String univer) {
		this.univer = univer;
	}

	public int compareTo(Key b) {
		if (univer.compareTo(b.univer) == 1) {
			return 1;
		}
		if (univer.compareTo(b.univer) == -1) {
			return -1;
		}
		if (univer.compareTo(b.univer) == 0) {
					return 0;
		}
		return 1;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (univer == null) {
			if (other.univer != null)
				return false;
		} else if (!univer.equals(other.univer))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((univer == null) ? 0 : univer.hashCode());
		return result;
	}

	public boolean equals(Key b) {
		if ((univer.equals(b.univer))){
			return true;
		}
		return false;
	}
}