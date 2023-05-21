const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
const [N, K, ...arr] = fs.readFileSync(filePath).toString().trim().split("\n")

let low = 0
let high = 0

for (let i = 0; i < N; i++) {
  correct[i] = arr[i]
  high += correct[i]
}

while (low <= high) {
  let mid = (low + high) / 2
  let cnt = 1,
    sum = 0,
    min = Number.MAX_SAFE_INTEGER

  for (let i = 0; i < N; i++) {
    sum += correct[i]

    if (sum >= mid) {
      cnt++
      min = Math.min(min, sum)
      sum = 0
    }
  }

  if (cnt > K) low = mid + 1
  else high = mid - 1
}

console.log(low - 1)
