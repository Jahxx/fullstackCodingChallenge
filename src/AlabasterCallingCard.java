import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public static void main() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine().trim());

    String[] numbers = br.readLine().trim().split(",");
    Set<Integer> a = new HashSet<>();

    for (String num : numbers) {
        a.add(Integer.parseInt(num));
    }

    for (int i = 0; i < t; i++) {
        int x = Integer.parseInt(br.readLine().trim());

        if (a.contains(x)) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }}
