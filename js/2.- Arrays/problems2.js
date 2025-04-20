// 26. Remove Duplicates From Sorted Array
// Dado un arreglo nums ordenado, elimina los duplicados in-place 
// de modo que cada elemento único aparezca solo una vez.
var removeDuplicates = function(nums) {
    if (nums.length === 0) return 0;

    let k = 1; // índice del siguiente elemento único
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] !== nums[k - 1]) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
};


// 27. Remove Element
// Dado un arreglo nums y un valor val, elimina todas las ocurrencias de val 
// en nums in-place y devuelve cuántos quedan.
var removeElement = function(nums, val) {
    let k = 0; // índice para elementos válidos
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== val) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
};

// 1470. Shuffle the Array
// Dado un arreglo con formato [x1,x2,...,xn,y1,y2,...,yn], devolver [x1,y1,x2,y2,...,xn,yn]
var shuffle = function(nums, n) {
    const result = [];
    for (let i = 0; i < n; i++) {
        result.push(nums[i]);
        result.push(nums[i + n]);
    }
    return result;
};