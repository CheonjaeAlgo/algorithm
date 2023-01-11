// const fs = require("fs")
// const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
// let [n, ...input] = fs.readFileSync(filePath).toString().trim().split("\n")
// let index = 0
// for (let i = 0; i < Number(n); i++) {
//   const phoneNoCnt = Number(input[index++]) //전화번호 갯수
//   let arr = [...Array(phoneNoCnt)].map(() => input[index++].trim()).sort()
//   console.log(arr)
//   let len = 0
//   let result = "YES"
//   for (let j = 0; j < phoneNoCnt - 1; j++) {
//     //번호수만큼비교
//     if (arr[j].slice(0, len) === arr[j - 1]) {
//       result = "NO"
//       break
//     }
//     len = arr[i].length
//   }
//   console.log(result)
// }

const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt"
let input = fs.readFileSync(filePath).toString().trim().split("\n")

let tc = +input[0]
let index = 1

while (tc--) {
  let num = +input[index++]
  let arr = [...Array(num)].map(() => input[index++].trim()).sort()
  let len = 0
  let result = "YES"

  for (let i = 0; i < num; i++) {
    if (arr[i].slice(0, len) === arr[i - 1]) {
      result = "NO"
      break
    }
    len = arr[i].length
  }
  console.log(result)
}
