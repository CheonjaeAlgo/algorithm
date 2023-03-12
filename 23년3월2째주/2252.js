1
const fs = require("fs");
2
let input = fs.readFileSync("/dev/stdin").toString().split('\n');
3
​
4
const [N, M] = input[0].split(" ").map(Number);
5
const graph = Array.from({length: N+1}, () => []);
6
const dist = Array.from({length: N + 1}, () => 0);
7
for(let i=1;i<=M;i++) {
8
    const [a, b] = input[i].split(" ").map(Number);
9
    graph[a].push(b);
10
    dist[b]++;
11
}
12
​
13
const queue = [];
14
for(let i=1;i<=N;i++) {
15
    if(dist[i] === 0) {
16
        queue.push(i);
17
    }
18
}
19
​
20
let idx = 0;
21
while(idx < queue.length) {
22
    const node = queue[idx];
23
    graph[node].forEach((i) => {
24
        dist[i]--;
25
        if(dist[i] === 0) {
26
            queue.push(i);
27
        }
28
    })
29
    idx++;
30
}
31
​
32
console.log(queue.join(" "));
