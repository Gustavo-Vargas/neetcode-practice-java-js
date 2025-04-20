// 1929. Remove Duplicates From Sorted Array
// Dado un arreglo nums ordenado, elimina los duplicados in-place 
// de modo que cada elemento único aparezca solo una vez.
var getConcatenation = function(nums) {
    return [...nums, ...nums];
    // return nums.concat(nums) 
};