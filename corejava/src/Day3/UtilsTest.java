package Day3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

class UtilsTest { //outer class 
	
	public class Point implements Comparable<Point>{ // it's work only within class , but making public we can use outside also.
		private int x;
		private int y;
		
		
		public Point() {}
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(x, y);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return x == other.x && y == other.y;
		}

		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}

		private UtilsTest getEnclosingInstance() {
			return UtilsTest.this;
		}

		@Override
		public int compareTo(Point other) {
			if(this == other || this.equals(other))
				return 0;
			int diffX= x-other.x;
			if(diffX==0) return y-other.y;
			return diffX;
		}
		
		
		
	}
	
// Maps - HashMap and TreeMap work with only keys
	@Test
	public void testMaps() {
		tryingMaps(new HashMap<String,Integer>());
		tryingMaps(new TreeMap<String,Integer>());
	}
	
	public void tryingMaps(Map<String,Integer> numbers) {
		assertEquals(0,numbers.size());
		
		numbers.put("One", 1); // value 1 and key "One"
		assertEquals(1,numbers.size());
		assertEquals(1,numbers.get("One")); // call key
		
		numbers.put("One", 2); // key - "One" but value 2
		assertEquals(1,numbers.size());
		assertEquals(2,numbers.get("One"));
		
		numbers.put("one", 1); // new key -"one" and value 1
		assertEquals(2,numbers.size());
		assertEquals(1,numbers.get("one"));
	}
	
// Lists - ArrayList and LinkedList - allowed duplicate
	@Test
	public void testArrayList() {
		tryingLists(new ArrayList<UtilsTest.Point>());
		tryingLists(new LinkedList<UtilsTest.Point>());
	}
	
	
	public void tryingLists(List<Point> points) {
		assertEquals(0,points.size());
		
		Point p= new Point(2,3);
		points.add(p);
		assertEquals(1,points.size());
		
		points.add(p);
		assertEquals(2,points.size()); //allowed & Increased
		
		points.add(new Point(2,3));
		assertEquals(3,points.size());// allowed set duplicate & increased
		
		points.add(new Point(3,2));
		assertEquals(4,points.size());// allowed because object is diff. and size of set increased
		
	}
	
	
	
// Sets- HashSet and TreeSet - not duplicate
	@Test
	public void testHashSet() {
		tryingSets(new HashSet<UtilsTest.Point>());
	}
	
	@Test
	public void testTreeSet() {
		tryingSets(new TreeSet<UtilsTest.Point>());
	}
	
	
	public void tryingSets(Set<Point> points) {
		assertEquals(0,points.size());
		
		Point p= new Point(2,3);
		points.add(p);
		assertEquals(1,points.size());
		
		points.add(p);
		assertEquals(1,points.size()); //not allowed
		
		points.add(new Point(2,3));
		assertEquals(1,points.size());// not allowed set duplicate
		
		points.add(new Point(3,2));
		assertEquals(2,points.size());// allowed because object is diff. and size of set increased
		
	}
	
	
}
