const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
const [n, ...arr] = fs.readFileSync(filePath).toString().trim().split("\n")

let temp = []
for (let i = 0; i < n; i++) {
  if (Number(arr[i]) === 0) {
    temp.pop()
  } else {
    temp.push(Number(arr[i]))
  }
}
const result = temp.reduce(function add(sum, currValue) {
  return sum + currValue
}, 0)

console.log(result)
