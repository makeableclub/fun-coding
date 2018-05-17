/**
 * Find all duplicates in an array in linear time
 * using hashtable
 *
 * (1) Loop through the array
 * (2) At each element check if it exists in the hash table, which has a lookup of O(1) time
 * (3) If the element exists in the hash table then it is a duplicate, if it doesn't exist, insert it into the hash table, also O(1)
 */

function findDuplicates(arr) {
    let hashtable = {};
    let duplicates = [];

    for( let i=0; i<arr.length; i++) {
            var key = arr[i];
            if( ! hashtable[key] ) {
                hashtable[key] = 1;
            }
            else {
                // there is one existing, it is a duplicate; but we won't count for 2nd or 3rd time later.
                if( hashtable[key] == 1 )
                    duplicates.push(arr[i]);

                hashtable[key] = hashtable[key] + 1;
            }
    }

    console.log(hashtable);

    return duplicates;
}

findDuplicates([1,21,-4,103,21,4,1,1,21]);
