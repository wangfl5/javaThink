package CollectionTset;

import java.util.Arrays;
import java.util.Random;

/**
 *@author wangfl5
 *@date 2018-4-17
 *@description
 **/
public class ArrayTest0417 {
	/**
	 * 2018-4-17
	 * @param args
	 */
	public static void main(String[] args) {
		Random a = new Random();
		System.out.println(a.nextInt(12));
		String[][][] b = new String[a.nextInt(5)][a.nextInt(6)][a.nextInt(7)];
		System.out.println(Arrays.deepToString(b));
	}

}
