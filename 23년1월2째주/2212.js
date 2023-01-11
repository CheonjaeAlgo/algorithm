const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let input = fs.readFileSync(filePath).toString().trim().split("\n")

const N = Number(input.shift())
const K = Number(input.shift())
const arr = input
  .shift()
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b)

const diff = []

for (let i = 0; i < arr.length - 1; i++) {
  diff.push(arr[i + 1] - arr[i])
}

diff.sort((a, b) => b - a)
let sum = 0

for (let i = K - 1; i < N - 1; i++) {
  sum += diff[i]
}

console.log(sum)
