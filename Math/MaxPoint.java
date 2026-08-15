import java.util.HashMap;
import java.util.Map;

public class MaxPoint {
   public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int maxCount = 1;

        for (int i = 0; i < n; i++) {
            // Map from a normalized (dx, dy) slope representation to count of points
            // sharing that slope relative to point i.
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicates = 0; // points identical to point i
            int localMax = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                int gcd = gcd(Math.abs(dx), Math.abs(dy));
                dx /= gcd;
                dy /= gcd;

                // Normalize sign: ensure dx is always non-negative to treat
                // (dx, dy) and (-dx, -dy) as the same slope/direction.
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    // Vertical line: normalize dy to always be positive
                    dy = Math.abs(dy);
                }

                String key = dx + "," + dy;
                int count = slopeCount.getOrDefault(key, 0) + 1;
                slopeCount.put(key, count);
                localMax = Math.max(localMax, count);
            }

            // +1 for point i itself, plus any exact duplicate points also lie on the same line
            maxCount = Math.max(maxCount, localMax + duplicates + 1);
        }

        return maxCount;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
