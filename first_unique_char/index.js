/**
 * Given a string such as "there is a dog at the door".
 * The first "unique char" is "i"
 */
var str = "there is a dog at the door";
var m = {};

// put each char in a map, with its index as value, if duplicate, set value to -1
str.split('').map((x,i) => {
    (m[x]!==undefined) ? m[x]=-1 : m[x]=i;
});

// remove all the duplicates (value=-1), and then sort it according the value which is the position
s = Object.keys(m).filter((k) => m[k] >=0 ).sort( (c,d) => {return m[c] - m[d]} );

console.log( "the char is: " + s[0]);
console.log( "the position is: " + m[s[0]]);


//
// sorted map by its values
//
var m = { 'a':5, 'b':1, 'c':4, 'd':2, 'e':7}
s = Object.keys(m).sort( (a, b) => {return m[a] - m[b]} );
