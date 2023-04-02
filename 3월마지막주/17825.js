const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split(" ").map(Number);


const point = [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 13, 16, 19, 22, 24, 25, 26, 27, 28, 30, 35, 0]

const next = [
  [1, 2, 3, 4, 5],
  [2, 3, 4, 5, 6],
  [3, 4, 5, 6, 7],
  [4, 5, 6, 7, 8],
  [5, 6, 7, 8, 9],
  [21, 22, 23, 26, 30],
  [7, 8, 9, 10, 11],
  [8, 9, 10, 11, 12],
  [9, 10, 11, 12, 13],
  [10, 11, 12, 13, 14],
  [24, 25, 26, 30, 31],
  [12, 13, 14, 15, 16],
  [13, 14, 15, 16, 17],
  [14, 15, 16, 17, 18],
  [15, 16, 17, 18, 19],
  [29, 28, 27, 26, 30],
  [17, 18, 19, 20, 32],
  [18, 19, 20, 32, 32],
  [19, 20, 32, 32, 32],
  [20, 32, 32, 32, 32],
  [32, 32, 32, 32, 32],///
  [22, 23, 26, 30, 31],
  [23, 26, 30, 31, 20],
  [26, 30, 31, 20, 32],
  [25, 26, 30, 31, 20],
  [26, 30, 31, 20, 32],
  [30, 31, 20, 32, 32],
  [26, 30, 31, 20, 32],
  [27, 26, 30, 31, 20],
  [28, 27, 26, 30, 31],
  [31, 20, 32, 32, 32],
  [20, 32, 32, 32, 32],
  [32, 32, 32, 32, 32]
]




let max = 0;

for (let i = 0; i < 4; i++) {
  move(i, 0, [0, 0, 0, 0], 0)
}

console.log(max);
function move(unit, cnt, location, score) {
  if (cnt == 10) {
    max = Math.max(max, score)
    return;
  }

  const nowLocation = location[unit];
  if (nowLocation == 32) {
    return;
  }

  const nextLocation = next[nowLocation][input[cnt] - 1];

  if (location.filter(v => v != 32).includes(nextLocation)) {
    return;
  } else {
    const newLocation = [...location];
    newLocation[unit] = nextLocation
    const newScore = score + point[nextLocation]
    for (let i = 0; i < 4; i++) {
      move(i, cnt + 1, newLocation, newScore)
    }
  }
}
