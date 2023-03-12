const fs = require("fs");
let [nm, ...arr] = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [n, m] = nm.split(" ").map(Number);
arr = arr.map((a) => a.trim().split(" ").map(Number));

let degree = new Array(n + 1).fill(0);
let obj = Array.from({ length: n + 1 }, () => new Array());

arr.forEach((e) => {
  for (let i = 1; i < e.length - 1; i++) {
    obj[e[i]].push(e[i + 1]);
    degree[e[i + 1]]++;
  }
});

let result = [];
let queue = [];
let pointer = 0;
for (let i = 1; i < degree.length; i++) {
  if (degree[i] == 0) queue.push(i);
}

while (pointer < queue.length) {
  let cur = queue[pointer++];
  result.push(cur);

  if (obj[cur].length) {
    obj[cur].forEach((next) => {
      if (--degree[next] == 0) queue.push(next);
    });
  }
}

console.log(result.length == n ? result.join("\n") : 0);
