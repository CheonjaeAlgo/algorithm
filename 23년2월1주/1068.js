const fs = require('fs')
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n')

function delLeaf(D) {
  if (!C[D].length) leaf--
  else C[D].forEach(i => delLeaf(i))
}

const N = +input[0]
const P = input[1].split(' ').map(Number)
const D = +input[2]

const C = Array.from({length: N}, _ => [])
P.forEach((p, c) => p != -1 && C[p].push(c))
let leaf = C.reduce((x, y) => (y.length ? x : ++x), 0) 
if (P[D] != -1 && C[P[D]].length == 1) leaf++ 
delLeaf(D)
console.log(leaf)
