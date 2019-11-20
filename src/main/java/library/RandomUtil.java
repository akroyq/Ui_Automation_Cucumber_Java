package library;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author Amit
 *
 */
public class RandomUtil {


	public static String generateAlphaNumericText(final int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static String generateIntNumber(final int length) {
		return RandomStringUtils.randomNumeric(length);
	}
	

	public static String generateAlphabatic(final int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}
	

	public static int generateIntNumber(final int start, final int end) {
		return ThreadLocalRandom.current().nextInt(start, end);
	}
	

	public static double generateDoubeNumber(final int start, final int end) {
		return ThreadLocalRandom.current().nextDouble(start, end);
	}

}
