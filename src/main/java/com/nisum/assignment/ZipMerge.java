package com.nisum.assignment;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Sometimes items cannot be shipped to certain zip codes, and the rules for
 * these restrictions are stored as a series of ranges of 5-digit codes.
 * 
 * For example, if the ranges are:
 * 
 * [94133,94133] [94200,94299] [94600,94699]
 * 
 * Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot
 * be shipped to 94133, 94650, 94230, 94600, or 94299.
 * 
 * Any item might be restricted based on multiple sets of these ranges obtained
 * from multiple sources.
 * 
 * @author ranjit dhongade
 *
 */
public class ZipMerge {

	/**
	 * Process and merge zip codes which falls within valid range.
	 * 
	 * @param zipCodes
	 * @return list of zip ranges.
	 */
	public List<int[]> processZipCodes(int[][] zipCodes) {

		if (zipCodes != null && validateInputList(zipCodes)) {

			int[][] temp = new int[zipCodes.length][2];

			// hold the compared zip range to be removed to avoid duplicacy.
			List<int[]> hold = new ArrayList<int[]>();

			List<int[]> output = new ArrayList<int[]>();

			for (int rows = 0; rows < zipCodes.length; rows++) {
				// System.out.println(Arrays.toString(a[rows]));

				int lower = zipCodes[rows][0];
				int upper = zipCodes[rows][1];
				// System.out.println(lower+","+upper);
				boolean flag = false;

				// compare and merge.
				for (int i = 0; i < zipCodes.length; i++) {
					if (lower < zipCodes[i][0] && upper > zipCodes[i][0] && upper < zipCodes[i][1]) {
						temp[rows][0] = lower;
						temp[rows][1] = zipCodes[i][1];

						output.add(temp[rows]);
						flag = true;
						hold.add(zipCodes[i]);
					}
				}

				if (!flag) {
					temp[rows][0] = lower;
					temp[rows][1] = upper;
					output.add(temp[rows]);
				}
			}

			// remove duplicates
			for (int g = 0; g < output.size(); g++) {
				for (int f = 0; f < hold.size(); f++) {
					if (output.get(g)[0] == hold.get(f)[0] && output.get(g)[1] == hold.get(f)[1]) {
						output.remove(g);
					}
				}
			}
			return output;
		} else {
			return null;
		}
	}

	private boolean validateInputList(int[][] zipCodes) {
		if (zipCodes == null) {
			return false;
		}

		for (int[] zipRange : zipCodes) {
			if (ArrayUtils.isEmpty(zipRange)) {
				return false;
			}
		}

		for (int[] zipRange : zipCodes) {
			if (ArrayUtils.getLength(zipRange)>2) {
				return false;
			}
		}
		
		return true;
	}
}
