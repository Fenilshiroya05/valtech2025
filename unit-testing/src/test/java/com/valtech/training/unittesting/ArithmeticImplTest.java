package com.valtech.training.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ArithmeticImplTest {

	private Arithmetic arithmetic;
	
	
	@BeforeAll
	public static void other() {
		System.out.println("before all connected....... ");
	}
	
	@ParameterizedTest(name="Add with CSV Source A={0} B={1} result={2}")
	@CsvSource(value = {"2,3,5","-1,3,2","0,3,3","-1,-1,-2"})
	void testAddwithCSV(int a,int b,int res) {
		assertEquals(res, arithmetic.add(a, b) );
	}
	
	@ParameterizedTest(name="add with CSV file A={0} B={1} Result={2}")
	@CsvFileSource(files="data.csv")
	void testAddwithCSVFile(int a,int b,int res) {
		assertEquals(res, arithmetic.add(a, b) );
	}
	
	@BeforeEach
	public void some() {
		System.out.println("Init.....");
		arithmetic = new ArithmeticImpl();
	}
	
	@ParameterizedTest(name ="Add With Multiple Values")
	@ValueSource(strings = {"5,2,3","4,2,2","0,3,-3"})
	void testAddAgain(String param) { 
		List<Integer> args= Arrays.asList(param.split(",")).stream().map(it -> Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(args.get(0), arithmetic.add(args.get(1), args.get(2)));
	}
	
	static Stream<Arguments> addArgumentsProvider(){
		return Stream.of(Arguments.of(2,3,5),
				Arguments.of(-1,2,1),
				Arguments.of(5,-5,0));
	}
	
	@ParameterizedTest(name="add with Method Source A={0} B={1} Result={2}")
	@MethodSource(value="addArgumentsProvider")
	void testAddwithMethodSource(int a,int b,int res) {
		assertEquals(res, arithmetic.add(a, b) );
	}
	
	@Test
	void testAdd() {
		System.out.println("add..");
		assertEquals(3,arithmetic.add(2, 1));
	}
	
	@Test
	void testSub() {
		System.out.println("sub..");
		assertEquals(4, arithmetic.sub(6, 2));
	}
}
