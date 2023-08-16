
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, total_surplus = 0, surplus = 0, start = 0;
        for (int i = 0; i < n; i++) {
            total_surplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                surplus = 0;
                start = i + 1;
            }
        }
        return (total_surplus < 0) ? -1 : start;
    }

    // bruteForce
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    // int n = gas.length;
    // for(int i = 0; i < n; i++){
    // int totalFuel = 0;
    // int stopCount = 0, j = i;
    // while(stopCount < n){
    // totalFuel += gas[j % n] - cost[j % n];
    // if(totalFuel < 0) break; // whenever we reach negative cost
    // stopCount++;
    // j++;
    // }
    // // cover all the stops & our fuel left is 0 or more than that
    // if(stopCount == n && totalFuel >= 0) return i;
    // }
    // return -1; //if no solution is found
    // }
}
