import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class Solutions {


    // https://www.hackerrank.com/challenges/the-hurdle-race/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
    public static int hurdleRace(int k, List<Integer> height) {
        int result = Collections.max(height) - k;
        return Math.max(result, 0);
    }

    // https://www.hackerrank.com/challenges/designer-pdf-viewer/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&h_r=next-challenge&h_v=zen
    public static int designerPdfViewer(List<Integer> h, String word) {
        int maxLetterHeight = -1;
        for (char c : word.toCharArray()) {
            if (h.get(c - 'a') > maxLetterHeight) maxLetterHeight = h.get(c - 'a');
        }
        return maxLetterHeight * word.length();
    }

    public static int utopianTree(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) res++;
            else res *= 2;
        }
        return res;
    }

    @Test
    public void utopianTreeTest() {
        Assert.assertEquals(14, utopianTree(5));
    }

    public static int simpleArraySum(List<Integer> ar) {
        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        return sum;
    }

    public static long aVeryBigSum(List<Long> ar) {
        long bigInteger = 0;
        for (int i = 0; i < ar.size(); i++) {
            bigInteger += ar.get(i);
        }
        return bigInteger;
    }

    public static void plusMinus(List<Integer> arr) {
        int pos = 0, zero = 0, neg = 0;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) > 0) pos++;
            if(arr.get(i) < 0) neg++;
            if(arr.get(i) == 0) zero++;
        }
        System.out.println(String.format("%.6f", ((double) pos / arr.size())));
        System.out.println(String.format("%.6f", ((double) neg / arr.size())));
        System.out.println(String.format("%.6f", ((double) zero / arr.size())));
    }

    @Test
    public void plusMinusTest(){
        int[] inputArr = new int[]{-4, 3, -9, 0, 4, 1};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i: inputArr) arrayList.add(i);
        plusMinus(arrayList);
    }

    public static void staircase(int n){
        int justification = n;
        StringBuilder hashString = new StringBuilder("#");
        for(int i = 0; i < n; i++){
            System.out.println(String.format("%" + justification + "s", hashString.toString()));
            hashString.append("#");
        }
    }

    @Test
    public void staircaseTest(){
        staircase(5);
    }

    public static void main(String[] args) {
    }

}