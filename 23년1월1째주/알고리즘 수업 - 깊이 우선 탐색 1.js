const fs = require("fs")

const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"

let input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n")
  .map((val) => val.replace("\r", ""))
  .map((val) => val.split(" "))

let [nodeNum, lineNum, startNode] = input[0].map(Number)
let graph = new Map()
let visited = new Array(nodeNum).fill(0)
let cnt = 1

//그래프 세팅
for (let i = 0; i < nodeNum; i++) {
  graph.set(i + 1, [])
}
//그래프에는 각 노드당 연결되는 노드를 배열로
for (let i = 1; i <= lineNum; i++) {
  let [start, end] = input[i].map(Number)
  graph.get(start).push(end)
  graph.get(end).push(start)
}
//그래프의 배열들을 오름차순 정렬
graph.forEach((v) => {
  v.sort((a, b) => {
    return a - b
  })
})
DFS(startNode)
function DFS(node) {
  //방문하지 않은 노드만 체크
  if (visited[node - 1] == 0) {
    visited[node - 1] = cnt
    cnt++
    graph.get(node).forEach((v) => {
      DFS(v)
    })
  }
}
console.log(visited.join("\n"))
