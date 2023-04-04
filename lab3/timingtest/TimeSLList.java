package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> ns = new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts = new AList<>();
        int[] nums = new int[]{1000,2000,4000,8000,16000,32000,64000,128000};
        int ops = 10000;
        for (int i = 0; i < nums.length; i++){
            ns.addLast(nums[i]);
            times.addLast(stime(nums[i]));
            opCounts.addLast(ops);

        }
        printTimingTable(ns, times, opCounts);
    }

    public static double stime(int num){
        SLList L = new SLList();
        for (int i = 0; i < num; i++) {
            L.addLast(1);
        }
        Stopwatch sw = new Stopwatch();
        for (int j = 0; j < 10000; j++){
            L.getLast();
        }
        return sw.elapsedTime();
    }
}
