// 1929. Remove Duplicates From Sorted Array
// Dado un arreglo nums ordenado, elimina los duplicados in-place 
// de modo que cada elemento único aparezca solo una vez.
public class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n]; // Crear un arreglo de tamaño 2n

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
            
        }
        return ans;
    }
}