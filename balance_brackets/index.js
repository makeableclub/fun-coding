// Balanced Parenthesis:
// N=1:  {}
// N=2:  {{}}, {}{}
// N=3:  {{{}}}, {{}}{}, {}{{}}, {{}{}}, {}{}{}
// ....
//
// check if a string contains a balanced brackets, using STACK for pair checking
// str - the content to be verified
//
function isBalanced(inputStr) {
    let brackets = inputStr.replace(/^{}()[]/gi, '');
    console.log( "inputStr: ", inputStr);
    console.log( "brackets: ", brackets);

    let charArray = brackets.split('');
    let stack = [];

    for (let i = 0; i < charArray.length; i++) {

        if (isOpenParenthesis(charArray[i])) {
            // push open brackets
            stack.push(charArray[i]);
        }
        else {
            // check close bracket
            if (stack.length === 0) {
                console.log("no more open bracket to match this close bracket");
                return false;
            }

            var top = stack.pop(); // pop off the top element from stack, and check it
            if (!matchBracket(top, charArray[i])) {
                console.log("open bracket is different type from close bracket");
                return false
            }

            // by now, consumed a balanced pair
        }
    }

    console.log("finished all contents");

    // by now, the stack should be empty if it is balanced
    return ( stack.length == 0 );
}

const tokenPair = {
    "[": "]",
    "{": "}",
    "(": ")"
}

// check if the character is an open bracket
function isOpenParenthesis(letter) {
    // console.log( Object.keys(tokenPair) );
    return Object.keys(tokenPair).includes(letter);
}

// make sure its open - close pair
function matchBracket(left, right) {
    return (tokenPair[left] === right);
}



//
// Generate all possible balanced brackets for given number of N
//
// to invoke for any number N like this, starting the count of left bracket.
// genBrackets( N, 0, "" );
//
// for example, for level 4:  N=4, you call
// genBrackets( 4, 0, "" );
//
// left - countdown on left bracket
// right - countdown on right bracket
// str - result produced so far
//
const allBalanced = [];
function recursiveGen(left, right, str) {
    // when a branch reaches to bottom, spit out all brackets we collected
    if (left === 0 && right === 0) {
        console.log(str);
        allBalanced.push(str);
    }

    // systematically travel down left size, which also create calls to produce right-size future calls
    if (left > 0) {
        recursiveGen(left-1, right+1, str+"(");
    }

    // for right-size, just add ")" and travel down
    if (right > 0) {
        recursiveGen(left, right-1, str+")");
    }
}

function genBrackets(n) {
    recursiveGen(n, 0, "");
    return allBalanced;
}

module.exports = isBalanced;
module.exports.genBrackets = genBrackets;
