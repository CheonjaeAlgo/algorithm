const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
let [N, M] = fs.readFileSync(filePath).toString().split(" ").map(Number)

const visited = new Array(N)

let output = []
let result = ""

function dfs(cnt) {
  if (cnt === M) {
    result += `${output.join(" ")}\n`
    return
  }
  for (let i = 0; i < N; i++) {
    if (visited[i] === true) continue
    visited[i] = true
    output.push(i + 1)
    dfs(cnt + 1)
    output.pop()
    visited[i] = false
  }
}

dfs(0)
console.log(result.trim())
