const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
const input = fs.readFileSync(filePath).toString().trim()

function hansu(k) {
  const n = Number(k)
  if (n < 100) {
    return n
  } else {
    let sum = 99
    for (let i = 100; i <= n; i++) {
      if (
        parseInt(i / 100) - (parseInt(i / 10) % 10) ===
        (parseInt(i / 10) % 10) - (i % 10)
      )
        sum++
    }
    return sum
  }
}
console.log(hansu(input))
