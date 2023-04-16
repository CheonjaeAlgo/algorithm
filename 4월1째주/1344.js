const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let input = fs.readFileSync(filePath).toString().split("\r\n")

const a = [153, 816, 8568, 31824, 31824, 8568, 18]
const b = [2, 3, 5, 7, 11, 13, 17]
let A = [0, 0]
for (let i = 0; i < 2; i++) {
  for (let j = 0; j < a.length; j++) {
    A[i] =
      A[i] +
      a[j] *
        Math.pow(Number(input[i]) / 100.0, b[j]) *
        Math.pow(1 - Number(input[i]) / 100.0, 18 - b[j])
  }
}

console.log(A[0] + A[1] - A[0] * A[1])
