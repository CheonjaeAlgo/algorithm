const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

const N = +input[0];
let dp = Array(N+1).fill(0);
for (let i=0; i<N; i++) {
    const [T, P] = input[i+1].split(' ').map(Number);
    if (dp[i] > dp[i+1]) dp[i+1] = dp[i];
    if (i+T < N+1 && dp[i]+P > dp[i+T]) dp[i+T] = dp[i]+P;
}
console.log(dp[N]);
