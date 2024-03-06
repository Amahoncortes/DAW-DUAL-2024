import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    }

   public static int luckyNumber (String birthDate){
    String[] nums = birthDate.split("-");
    int count = 0;
    for (int i = 0; i < nums.length; i++){
        count += Integer.parseInt(nums[i]);
    }
    String[] c = Integer.toString(count).split("");
    while (c.length != 1) {
        count = 0;
        for (int j = 0; j < c.length; j++) {
            count += Integer.parseInt(c[j]);
        }
        c = Integer.toString(count).split("");
    }
    return count;
    }
}