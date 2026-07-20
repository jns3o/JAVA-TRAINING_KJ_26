package practice.test260715;

import java.util.Random;

public class UnderDogDice implements roll{
	Random r = new Random();
	int[] underDogDice = {1,1,1,1,6,6};
	@Override
	public int roll() {
		return underDogDice[r.nextInt(underDogDice.length)];
	}
}
