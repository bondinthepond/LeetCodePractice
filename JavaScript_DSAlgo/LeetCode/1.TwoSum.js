var twoSum = function (nums, target) {
  let temp1, temp2;
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] === target) {
        temp1 = i;
        temp2 = j;
        break;
      }
    }
  }
  return [temp1, temp2];
};

console.log(twoSum([4, 2, 7, 8], 15));
