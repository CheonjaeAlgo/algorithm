const fs = require("fs");
const input = fs
	.readFileSync("./dev/stdin")
	.toString()
	.trim()
	.split("\n")
	.map(v => v.trim())


const N = +input[0];
const [A, B, C, D, E, F] = input[1].split(' ').map(Number)

const one_min = Math.min(A, B, C, D, E, F)

const two_arr = [
	[A, B],
	[A, C],
	[A, D],
	[A, E],
	[B, C],
	[B, D],
	[B, F],
	[C, E],
	[C, F],
	[D, E],
	[D, F],
	[E, F]
].map(v => v[0] + v[1])

const two_min = Math.min(...two_arr);


const three_arr = [
	[A, B, C],
	[A, B, D],
	[A, C, E],
	[A, D, E],
	[B, C, F],
	[B, D, F],
	[C, E, F],
	[D, E, F],
].map(v => v[0] + v[1] + v[2])

const three_min = Math.min(...three_arr);

// 2: 1: 0      2:4*0 + 4*1   3: 4
// 3: 1: 1+4*2  2:4*1 + 4*2   3: 4 
// 4: 1: 4+4*6  2:4*2 + 4*3   3: 4
// 5: 1: 9+4*

const three_cnt = 4;

const two_cnt = 4 * (2 * N - 3);

const one_cnt = Math.pow(N - 2, 2) + 4 * (Math.pow(N, 2) - 2 * N - (N - 2))


if (N == 1) {
	const Sum = A + B + C + D + E + F
	const max = Math.max(A, B, C, D, E, F);
	console.log(Sum - max);
} else if (N == 2) {
	console.log(three_cnt * three_min + two_cnt * two_min);
} else {
	console.log(three_cnt * three_min + two_cnt * two_min + one_min * one_cnt);
}
