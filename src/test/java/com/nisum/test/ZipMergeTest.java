package com.nisum.test;

import com.nisum.assignment.ZipMerge;

import junit.framework.TestCase;

public class ZipMergeTest extends TestCase {

	private ZipMerge zipMerge;
	private final int[][] inputOne = {{}};
	private final int[][] inputTwo = {{35,45,22},{33,44}, {55,66}, {88,99}};
	private final int[][] inputThree = { {94133,94133},{1,3},{94200,94299}, {94226,94399}, {15,20}, {2,5}, {17, 88}};
	private final int[][] inputFour = {{94133,94133}, {94200,94299}, {94600,94699}};
	private final int[][] inputFive = {{94133,94133}, {94200,94299}, {94226,94399}};

	public ZipMergeTest(String name) {
		super(name);
		zipMerge = new ZipMerge();
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Unit test null
	 */
	public void testProcessZipCodesNull() {
		assertNull(zipMerge.processZipCodes(null));
	}
	
	/**
	 * Unit test empty list
	 */
	public void testProcessZipCodesEmpty() {
		assertNull(zipMerge.processZipCodes(inputOne));
	}
	
	/**
	 * Unit test invalid list
	 */
	public void testProcessZipCodesInvalidList() {
		assertNull(zipMerge.processZipCodes(inputTwo));
	}
	
	/**
	 * Unit test valid list input3
	 */
	public void testProcessZipCodesValidList3() {
		assertNotNull(zipMerge.processZipCodes(inputThree));
	}
	
	/**
	 * Unit test valid list input4
	 */
	public void testProcessZipCodesValidList4() {
		assertNotNull(zipMerge.processZipCodes(inputFour));
	}
	
	/**
	 * Unit test valid list input5
	 */
	public void testProcessZipCodesValidList5() {
		assertNotNull(zipMerge.processZipCodes(inputFive));
	}
}
