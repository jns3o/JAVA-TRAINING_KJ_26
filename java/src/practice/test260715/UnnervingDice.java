package practice.test260715;

import java.util.Random;

public class UnnervingDice implements roll{
	Random r = new Random();
	int[] unnervingDice = {2,2,2,5,5,5};
	@Override
	public int roll() {
		return unnervingDice[r.nextInt(unnervingDice.length)];
	}
}
