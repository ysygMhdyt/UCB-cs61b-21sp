package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing la = new AListNoResizing<>();
        BuggyAList lb = new BuggyAList();
        int[] testn = new int[]{4, 5, 6};
        for (int i = 0; i < testn.length; i++){
            la.addLast(testn);
            lb.addLast(testn);
        }
        for (int i = 0; i < testn.length; i++){
            assertEquals(la.removeLast(),lb.removeLast());
        }
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = B.size();
                //System.out.println("size: " + size + " sizeB:" + sizeB);
            }else if (operationNumber == 2 && L.size() > 0){
                int last = L.getLast();
                int lastB = B.getLast();
                //System.out.println("last:" + last + " lastB:" + lastB);
            }else if (operationNumber == 3 && L.size() > 0){
                int remove = L.removeLast();
                int removeB = B.removeLast();
                //System.out.println("remove:" + remove + " removeB:" + removeB);
            }
        }

    }
}
