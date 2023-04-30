const { channel } = require('diagnostics_channel');
const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let [n, k] = input[0].trim().split(' ').map(Number);
let d = {};

for (let i = 1; i <= k; i++) {
    let [n1, n2] = input[i].trim().split(' ').map(Number);
    d[n1] ? d[n1].push(n2) : d[n1] = [n2];
    d[n2] ? d[n2].push(n1) : d[n2] = [n1];
}

for (let key in d) {
    d[key] = Array.from(new Set(d[key])).sort((a, b) => a - b);
}

let [s, e] = input[k+1].trim().split(' ').map(Number);
let visit = {};

const getDist = (start, target) => {
    let queue = [[start]];
    let dist = 0;
    
    while(queue.length) {
        let nq = [];
        for (let i = 0; i < queue.length; i++) {
            let chain = queue[i];
            let cur = chain[chain.length-1];
    
            if (cur == target) {
                visit = {};
                for (let j = 1; j < chain.length-1; j++) {
                    visit[chain[j]] = 1;
                }
                return dist;
            }

            if (d[cur]) {
                for (let j = 0; j < d[cur].length; j++) {
                    let next = d[cur][j];
                    if (!visit[next]) {
                        visit[next] = 1;
                        nq.push(chain.concat(next))
                    }
                }
            }
        }
    
        queue = nq;
        dist++;
    }
}

console.log(getDist(s,e) + getDist(e, s));
