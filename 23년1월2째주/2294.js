const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt"

let [n, ...input] = fs.readFileSync(filePath).toString().trim().split("\n")

const [N, K] = n.split(" ").map(Number)

input = input.map(Number)

const arr = new Array(K + 1).fill(100000)
arr[0] = 0
input.map((e) => {
  arr[e] = 1
})
function solution(target) {
  for (let i = 1; i < target + 1; i++) {
    for (let j = 0; j < N; j++) {
      if (input[j] < i) {
        arr[i] = Math.min(arr[i], arr[i - input[j]] + 1)
      }
    }
  }
  if (arr[target] === 100000) return -1
  return arr[target]
}
console.log(solution(K))
