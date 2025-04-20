// 26. Remove Duplicates From Sorted Array
// Dado un arreglo nums ordenado, elimina los duplicados in-place 
// de modo que cada elemento único aparezca solo una vez.
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1; // índice del siguiente elemento único
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}


// 27. Remove Element
// Dado un arreglo nums y un valor val, elimina todas las ocurrencias de val 
// en nums in-place y devuelve cuántos quedan.
public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // índice para colocar los elementos válidos
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}


// 1470. Shuffle the Array
// Dado un arreglo con formato [x1,x2,...,xn,y1,y2,...,yn], devolver [x1,y1,x2,y2,...,xn,yn]
public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }
}