import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;


public class VstupMapFIO {
	private HashMap<KeyFIO, LinkedList<InfoFIO>> lis;

	VstupMapFIO() {
		lis = new HashMap<KeyFIO, LinkedList<InfoFIO>>();
	}

	public void add(String univer, String department, String direction,
			String fio, String att) {
		KeyFIO j = new KeyFIO(fio);
		LinkedList<InfoFIO> g;
		g = lis.get(j);
		if (g == null) {
			g = new LinkedList<InfoFIO>();
		}
		InfoFIO gg = new InfoFIO(univer, department, direction, fio, att);
		g.add(gg);
		lis.put(j, g);
	}

	public LinkedList<LinkedList<InfoFIO>> get(String fio) {
		KeyFIO k = new KeyFIO(fio);
		Set<KeyFIO> m = lis.keySet();
		Object[] n = m.toArray();
		int cnt = 0;
		int[] z = new int[n.length];
		for (int i=0; i<z.length; i++){
			z[i]=-1;
		}
		for (int i=0; i<n.length; i++){
			if (k.equals((KeyFIO)n[i])){
				z[i] = i;
				cnt=cnt+1;
			}
		//	a[i] = n[i].toString();
		}
		//String[] b = new String[n.length];
		//
		//for (int i=0; i<n.length; i++){
		//	if(a[i].toLowerCase().contains(fio.toLowerCase())){
		//		b[cnt] = a[i];
		//		cnt = cnt+1;
		//	}
		//}
		LinkedList<LinkedList<InfoFIO>> v = new LinkedList<LinkedList<InfoFIO>>();
		LinkedList<InfoFIO> h = null;
		for (int i=0; i<n.length; i++){
			if (z[i]!=-1){
				h = lis.get(n[z[i]]);
				v.add(h);
			}
			
		}
		
		if (h == null) {
			h = new LinkedList<InfoFIO>();
			h.add(new InfoFIO("", "", "", "", ""));
		}
		return v;
	}

	public static void main(String[] args) {

		VstupMapFIO m = new VstupMapFIO();
		m.add("KhNU", "FKN", "CS", "Petrov Ivan Petrovich", "50.0");
		m.add("KhPI", "KIT", "SE", "Ivanov Petr Ivanovich", "51.0");
		m.add("KhNURE", "SE", "ISPR", "Petrov Petr Petrovich", "50.0");
		m.add("KhNU", "FKN", "CS", "Ivanov Ivan Ivanovich", "51.0");
		m.add("KhNURE", "SE", "ISPR", "Ivanov Ivan Ivanovich", "51.0");

		Collection<LinkedList<InfoFIO>> infos = m.get("Ivan");
		for (LinkedList<InfoFIO> inf : infos) {
			System.out.println(inf);
		}

	}

}

class InfoFIO {
	public String univer, department, direction;
	public String att,fio;

	public InfoFIO(String univer, String department, String direction, String fio, String att) {
		this.univer = univer;
		this.department = department;
		this.direction = direction;
		this.fio = fio;
		this.att = att;
	}

	public String toString() {
		return fio + "\n" + univer + "\t" + department + "\t" + direction + "\t" + att + "\n";
	}
}

class KeyFIO {
	public String fio;
	

	public KeyFIO(String fio) {
		this.fio = fio;
	}

	public int compareTo(KeyFIO b) {
		if (fio.compareTo(b.fio) == 1) {
			return 1;
		}
		if (fio.compareTo(b.fio) == -1) {
			return -1;
		}
		if (fio.compareTo(b.fio) == 0) {
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
		KeyFIO other = (KeyFIO) obj;
		if (fio == null) {
			if (other.fio != null)
				return false;
		} else if (!other.fio.contains(fio))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fio == null) ? 0 : fio.hashCode());
		return result;
	}

	public boolean equals(KeyFIO b) {
		if ((b.fio.contains(fio))) {
			return true;
		}
		return false;
	}
}