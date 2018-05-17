const isBalanced = require('./index');
const gen = require('./index').genBrackets;

test('isBalanced is a function', () => {
  expect(typeof isBalanced).toEqual('function');
});

test('isBalanced returns true for {{[()]}}', () => {
    let inputStr = "{{[()]}}()";
    expect(isBalanced(inputStr)).toEqual(true);
});

test('isBalanced returns false', () => {
    let inputStr = "{{[()]}}()]";
    expect(isBalanced(inputStr)).toEqual(false);
});

test('isBalanced returns false', () => {
    let inputStr = "{{[()]})}(";
    expect(isBalanced(inputStr)).toEqual(false);
});

test('generate some balanced brackets', () => {
    let count = 4;
    console.log( gen(count) );
    // expect()
});
