var twoSum = function (nums, target) {
  const map = new Map();

  for (let i = 0; i <= nums.length; i++) {
    map.set(nums[i], i);
  }

  for (let j = 0; j <= nums.length; j++) {
    let complement = target - nums[j];
    if (map.has(complement) && map.get(complement) != j) {
      return [j, map.get(complement)];
    }
  }
};

nums = [2, 7, 9, 11, 21, 13];
target = 13;
console.log(twoSum(nums, target));
