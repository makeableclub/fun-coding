/**
 * https://stackoverflow.com/questions/42773836/how-to-find-all-subsets-of-a-set-in-javascript
 */


// Generator approach
function* subsets(array, offset = 0) {
    while (offset < array.length) {
        let first = array[offset++];
        for (let subset of subsets(array, offset)) {
            subset.push(first);
            yield subset;
        }
    }
    yield [];
}
// Example:
for (let subset of subsets([1, 2, 3])) {
    console.log(subset);
}



// Map-Reduce solution
const getAllSubsets =
    theArray => theArray.reduce(
        (subsets, value) => subsets.concat(
            subsets.map(set => [...set, value])
        ),
        [[]]
    );

console.log(getAllSubsets([1,2,3,4]));




// Non-recursive solution
var arr = [1, 2, 3];
function generatePowerSet(array) {
  var result = [];
  result.push([]);

  for (var i = 1; i < (1 << array.length); i++) {
    var subset = [];
    for (var j = 0; j < array.length; j++)
      if (i & (1 << j))
        subset.push(array[j]);

    result.push(subset);
  }

  return result;
}

console.log(generatePowerSet(arr));
