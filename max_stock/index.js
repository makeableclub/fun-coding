/***
https://coderbyte.com/algorithm/stock-maximum-profit

You will be given a list of stock prices for a given day and your goal is
to return the maximum profit that could have been made by buying a stock
at the given price and then selling the stock later on.
For example if the input is: [45, 24, 35, 31, 40, 23, 34, 11]
then your program should return 16 because if you bought the stock at $24 and sold it at $40,
a profit of $16 was made and this is the largest profit that could be made.
If no profit could have been made, return -1.
***/

/**
 * RX: Algorithm
 * whenever see a drop in price between two consecutive days, change the buy-price to the lower one;
 * use the new lower price as buy-price, to calculate all "local max" from there,
 * compare with "global-max" and reset "global-max" if necessary.
 *
 * Need to find out "local max",
 * then pick out "global max".
 */

// Natural thinking
function StockPicker(arr) {
  var max_profit = -1;
  var buy_price = 0;
  var sell_price = 0;

  // this allows our loop to keep iterating the buying
  // price until a cheap stock price is found
  var change_buy_index = true;

  // loop through list of stock prices once
  for (var i = 0; i < arr.length-1; i++) {

    // selling price is the next element in list
    sell_price = arr[i+1];

    // if we have not found a suitable cheap buying price yet
    // we set the buying price equal to the current element
    if (change_buy_index) {
        buy_price = arr[i];
        console.log("buy price: ", buy_price);
    }

    // if the selling price is less than the buying price
    // we know we cannot make a profit so we continue to the
    // next element in the list which will be the new buying price
    if (sell_price < buy_price) {
        //RX: this is for two immediate prices
      change_buy_index = true;
    }

    // if the selling price is greater than the buying price
    // we check to see if these two indices give us a better
    // profit then what we currently have
    else {
        // RX: this check profit with earlier reginal max, to determine if we switch.
      var temp_profit = sell_price - buy_price;
      if (temp_profit > max_profit) {
          max_profit = temp_profit;
      }
      change_buy_index = false;
    }

  }

  return max_profit;

}

// Reduce approach
function StockPicker(arr) {
	let trueMax = 0;
	arr.reduce(function(prev, item){
		let max = Math.max(item - prev, 0);

		max > trueMax ? trueMax = max : null;

		if (max === 0) {
			return item;
		} else {
			return prev;
		}
	});

	if (trueMax === 0) {
		return -1;
	}
	return trueMax;
}

StockPicker([44, 30, 24, 32, 35, 30, 40, 38, 15]);
