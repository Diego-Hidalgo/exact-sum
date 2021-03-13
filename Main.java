import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        int minA = 0;
        int minB = 0;
        while((line = br.readLine()) != null) {
            if(!line.equals("")) {
                int books = Integer.parseInt(line);
                int[] prices = new int[books]; 
                String[] aux = br.readLine().split(" ");
                for(int i = 0; i < books; i ++) {
                    prices[i] = Integer.parseInt(aux[i]);
                }
                Arrays.sort(prices);
                int money = Integer.parseInt(br.readLine());
                int minDif = 1000001;
                for(int i = 0; i < books; i ++) {
                    int a = prices[i];
                    int b = money - a;
                    int start = i+1;
                    if(binarySearch(prices, b, start)) {
                        if((b-a) < minDif){
                            minA = a;
                            minB = b;
                            minDif = b-a;
                        }
                    }
                }
                bw.write("Peter should buy books whose prices are " + minA + " and " + minB + "." + "\n\n");
                bw.flush();
            }
        }
        br.close();
        bw.close();
    }

    public static boolean binarySearch(int[] array, int value, int start) {
        boolean found = false;
        int end = array.length - 1;
        while(start <= end && !found) {
            int mid = (start + end)/2;
            if(array[mid] == value) {
                found = true;
            } else if(array[mid] > value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return found;
    }

}