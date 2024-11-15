import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public static void main() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine().trim());

    String[] numbers = br.readLine().trim().split(",");
    Map<Integer, int[]> a = new HashMap<>();

    for (int i = 0; i < numbers.length; i++) {
        int n = Integer.parseInt(numbers[i]);

        if (!a.containsKey(n)) {
            a.put(n, new int[]{i, i});
        } else {
            a.get(n)[1] = i;
        }
    }

    StringBuilder res = new StringBuilder();
    for (int i = 0; i < t; i++) {
        int x = Integer.parseInt(br.readLine().trim());

        if (a.containsKey(x)) {

            int[] range = a.get(x);

            res.append(range[0]).append(" ").append(range[1]).append("\n");
        } else {
            res.append("-1\n");
        }
    }

    System.out.println(res);
}
