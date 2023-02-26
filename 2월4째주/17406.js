const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
const input = fs.readFileSync(filePath).toString().trim().split("\n")

const [NMK, ...lines] = input
const [N, M, K] = NMK.split(" ").map((n) => parseInt(n))
const operation = lines
  .slice(N)
  .map((line) => line.split(" ").map((n) => parseInt(n)))
const res = []

function rotate(matrix, r, c, s) {
  const rotated = matrix.map((row) => [...row])

  for (let k = 1; k <= s; k += 1) {
    for (let i = 0; i < 2 * k; i += 1) {
      rotated[r - k][c - k + i + 1] = matrix[r - k][c - k + i]
      rotated[r - k + i + 1][c + k] = matrix[r - k + i][c + k]
      rotated[r + k][c + k - i - 1] = matrix[r + k][c + k - i]
      rotated[r + k - i - 1][c - k] = matrix[r + k - i][c - k]
    }
  }
  return rotated
}

function dfs(matrix, visited, min, count) {
  if (count === K) {
    res.push(
      Math.min(...matrix.map((row) => row.reduce((acc, curr) => acc + curr, 0)))
    )
  }
  for (let i = 0; i < K; i += 1) {
    if (!visited[i]) {
      const [r, c, s] = operation[i]
      const rotated = rotate(matrix, r - 1, c - 1, s)
      const newVisited = [...visited]
      newVisited[i] = true

      dfs(rotated, newVisited, min, count + 1)
    }
  }
}

function main() {
  const matrix = lines
    .slice(0, N)
    .map((line) => line.split(" ").map((n) => parseInt(n)))
  const visited = Array(K).fill(false)
  let min = 10 * M

  min = dfs(matrix, visited, min, 0)
  return Math.min(...res)
}

console.log(main())
