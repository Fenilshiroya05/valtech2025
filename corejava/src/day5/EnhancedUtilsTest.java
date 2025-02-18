package day5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class EnhancedUtilsTest {

	
	@Test
	public void testMap() {
		Map<String,Integer> nums = Map.of("One",1,"Two",2,"Three",3,"Four",4); // it's not hashmap but it's immutablecolection
		System.out.println(nums.getClass().getName());
		System.out.println(nums.keySet());
		
		try {
			nums.put("Five", 5);
			fail("Immutable Map Expected..");
		}catch (Exception e) {
		
		}
		Map<String,Integer> nums1= new HashMap<String,Integer>();
		nums1.putAll(nums);
		nums1.put("Five", 5);
		
	}
	@Test
	public void testList() {
		List<Integer> nums = List.of(1,2,3,4);
		try {
			nums.add(5);
			fail("Immutable list expected");
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		List<Integer> nums1 = new ArrayList<Integer>();
		nums1.addAll(nums);
		nums1.add(5);
		
	}
	
	@Test
	public void testMapsConventional() {
		Map<String,Integer> nums = new HashMap<String,Integer>();
		nums.put("One", 1);
		nums.put("Two", 2);
		nums.put("Three", 3);
	}
	
	@Test
	void testListConventional() {
		List<Integer> nums =new ArrayList<Integer>();// mutable -- changeable
		nums.add(1);
		nums.add(2);
		nums.add(3);
		System.out.println(nums);
		
		List<Integer> nums1= Arrays.asList(1,2,3);// Immutable -- not changeable
		assertEquals(nums,nums1);
	}

}
