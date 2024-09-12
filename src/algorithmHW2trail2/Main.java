package algorithmHW2trail2;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;


	public class Main {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        scanner.nextLine();

	        Algotree algo = new Algotree();

	        while (n-- > 0) {
	            String command = scanner.nextLine();
	            String[] order = command.split(" ");
	            String cmd = order[0];
	            String str = order.length > 1 ? order[1] : null;

	            switch (cmd) {
	                case "insert":
	                    algo.insert(str);
	                    break;
	                case "delete":
	                    algo.delete(str);
	                    break;
	                case "search":
	                    System.out.println(algo.search(str) ? "YES" : "NO");
	                    break;
	                case "startwith":
	                    List<String> res = algo.startsWith(str);
	                    Collections.sort(res);
	                    for (String result : res) {
	                        System.out.println(result);
	                    }
	                    break;
	                case "longest":
	                    System.out.println(algo.longest());
	                    break;
	            }
	        }

	        scanner.close();
	    }
	}

