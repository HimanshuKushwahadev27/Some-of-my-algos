public class GasStation {
      public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int totalTank = 0;
    int currentTank = 0;
    int startingIndex = 0;

    for (int i = 0; i < n; i++) {
        int diff = gas[i] - cost[i];
        totalTank += diff;
        currentTank += diff;
        if (currentTank < 0) {
            startingIndex = i + 1;
            currentTank = 0;
        }
    }

    return totalTank >= 0 ? startingIndex : -1;
    }
}
