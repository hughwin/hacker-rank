import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    static boolean isAnagram(String a, String b) {
        if(a.length() != b.length()) return false;
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        Arrays.sort(aArray);
        Arrays.sort(bArray);
        for(int i = 0; i < a.length(); i++){
            if(aArray[i] != bArray[i]) return false;
        }
        return true;
    }

    public static void miniMaxSum(List<Integer> arr) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0, arrSize = arr.size(); i < arrSize; i++) {
            Integer integer = arr.get(i);
            if (integer > max) max = integer;
            if (integer < min) min = integer;
        }
        System.out.println((adder(arr, max))+ " " + (adder(arr, min)));
    }

    public static int adder(List<Integer> arr, int n){
        boolean encounted = false;
        int sum = 0;
        for(int i : arr){
            if(!encounted && i == n){
                encounted = true;
            }
            else sum += i;
        }
        return sum;
    }

    public static String timeConversion(String s) {
        String code = s.substring(s.length() - 2);
        String time = s.substring(0, s.length() - 2);
        DateFormat df = new SimpleDateFormat("hh:mm:ssaa");


        DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        String output;

        try {
            date = df.parse(time + code);
        }
        catch (ParseException e){
            e.printStackTrace();
        }

        //old date format to new date format
        output = outputformat.format(date);
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {

        timeConversion("12:05:45PM");

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        miniMaxSum(arrayList);
    }

    public static int countingValleys(int steps, String path) {
        char[] pathArray = path.toCharArray();
        int level = 0, valleys = 0;
        for(int i = 0; i < steps; i++){
            if (pathArray[i] == 'U' && level == -1) valleys++;
            if (pathArray[i] == 'D') level--;
            if (pathArray[i] == 'U') level++;
        }
        return valleys;
    }

    @Test
    public void countingValleysTest(){
        Assert.assertEquals(1, countingValleys(8, "UDDDUDUU"));
    }

}
