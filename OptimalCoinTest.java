package OptimalCoinChange;

import static org.junit.Assert.*;

import org.junit.Test;

public class OptimalCoinTest {

	@Test
	public void test() {
		
		OptimalCoinChangeProblem testob = new OptimalCoinChangeProblem(false);
		testob.run();
		assertEquals(testob.getMinNumberOfCoins(),3);
	}
}