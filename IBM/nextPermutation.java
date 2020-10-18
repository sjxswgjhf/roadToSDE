package IBM;

public class nextPermutation {

    public static String nextPermutation(String input){
        char[] chars = input.toCharArray();
        int i = chars.length - 2;
        while(i >= 0 && chars[i] >= chars[i + 1]){
            i--;
        }
        if(i < 0){
            return input;
        }else{
            int j = chars.length - 1;
            while(j >= 0 && chars[i] >= chars[j]){
                j--;
            }
            swap(chars, i, j);
        }
        reverse(chars, i + 1);
        return new String(chars);
    }

    private static void reverse(char[] nums, int start){
        for(int i = start, j = nums.length - 1; i < j; i++, j--){
            swap(nums, i, j);
        }
    }


    private static void swap(char[] nums, int i, int j){
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "hgfe";
        System.out.println(nextPermutation(str));
    }
}
