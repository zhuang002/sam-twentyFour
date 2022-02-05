import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i=0;i<n;i++) {
			List<Integer> cards = new ArrayList<>();
			for (int j=0;j<4;j++) {
				cards.add(sc.nextInt());	
			}
			
			List<Integer> answers = getAllAnswers(cards);
			System.out.println(getMaxLessThan24(answers));
		}
	}


	private static List<Integer> getAllAnswers(List<Integer> cards) {
		List<Integer> returnAnswers = new ArrayList<>();
		
		if (cards.size() == 2) {
			int a = cards.get(0);
			int b = cards.get(1);
			returnAnswers.add(a+b);
			returnAnswers.add(a-b);
			returnAnswers.add(a*b);
			if (b!=0 && a%b==0)
				returnAnswers.add(a/b);
			
			a = cards.get(1);
			b = cards.get(0);
			returnAnswers.add(a-b);
			if (b!=0 && a%b==0)
				returnAnswers.add(a/b);
			return returnAnswers;
		}
		
		for (int i=0;i<cards.size();i++) {
			for (int j=0;j<cards.size();j++) {
				List<Integer> list1 = new ArrayList<>();
				List<Integer> list2 = new ArrayList<>();
				if (i!=j) {
					list1.add(cards.get(i));
					list1.add(cards.get(j));
					
					for (int k=0;k<4;k++) {
						if (k!=i && k!=j) {
							list2.add(cards.get(k));
						}
					}
					List<Integer> answers = getAllAnswers(list1);
					for (int ans:answers) {
						list2.add(ans);
						returnAnswers.addAll(getAllAnswers(list2));
					}
				} 
				
			}
		}
		return returnAnswers;
	}

	private static int getMaxLessThan24(List<Integer> answers) {
		// TODO Auto-generated method stub
		int max = 0;
		for (Integer i:answers) {
			if (i<=24 && i>max) {
				max=i;
			}
		}
		return max;
	}

}
