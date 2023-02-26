const inputs = require("fs")
  .readFileSync(process.platform === "linux" ? "dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n")

const [n, d] = inputs[0].split(" ").map(Number)
let dist = Array.from(Array(d + 1).fill(Infinity))
const graph = Array.from(Array(d + 1), () => [])

for (let i = 0; i < n; i++) {
  const [start, end, w] = inputs[i + 1].split(" ").map(Number)
  if (end > d) continue
  if (end - start <= w) continue

  graph[start].push([end, w])
}

let prev = -1
for (let i = 0; i <= d; i++) {
  if (i) prev = dist[i - 1]

  dist[i] = Math.min(dist[i], prev + 1)

  for (let [next, cost] of graph[i]) {
    if (dist[next] > dist[i] + cost) {
      dist[next] = dist[i] + cost
    }
  }
}
console.log(dist[d])
