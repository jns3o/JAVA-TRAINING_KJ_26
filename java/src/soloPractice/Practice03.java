package soloPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice03 {
	public static void main(String[] args) {
		calculate();
	}

	public static void calculate() {
		Random r = new Random();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(r.nextInt(0, 10));
		}

		System.out.println("처음 입력된 원본 리스트: " + list);

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {

				if (list.get(i).equals(list.get(j))) {

					list.remove(j);

					j--;
				}
			}
		}

		System.out.println("중복을 삭제하고 당겨진 리스트: " + list);
		System.out.println("최종 리스트의 크기: " + list.size());
	}
}