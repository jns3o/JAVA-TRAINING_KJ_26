package practice.test260715;

import java.util.Random;

public class NormalDice implements roll{
	Random r = new Random();
	int[] normalDice = {3,3,3,4,4,4};
	@Override
	public int roll() {
		return normalDice[r.nextInt(normalDice.length)];
	}
}
