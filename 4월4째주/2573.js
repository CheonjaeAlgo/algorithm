const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map(Number);
const iceberg = input.map(v => v.split(' ').map(Number));
const offset = [[0, 1], [1, 0], [0, -1], [-1, 0]];

const melt = () => {
  iceberg.forEach((row, x) => {
    row.forEach((height, y) => {
      if (height > 0) {
        let count = 0;
        for (let i = 0; i < 4; i++) {
          const nx = x + offset[i][0];
          const ny = y + offset[i][1];
          if (iceberg[nx][ny] === 0) {
            count++;
          }
        }
        iceberg[x][y] -= count;
        if (iceberg[x][y] <= 0) {
          iceberg[x][y] = -1;
        }
      }
    });
  });
};

const dfs = (start, visited) => {
  const stack = [start];
  while (stack.length) {
    const [x, y] = stack.pop();
    for (let i = 0; i < 4; i++) {
      const nx = x + offset[i][0];
      const ny = y + offset[i][1];
      if (nx === 2 && ny === 5) {
      }
      if (!visited[nx][ny] && iceberg[nx][ny] > 0) {
        visited[nx][ny] = true;
        stack.push([nx, ny]);
      }
    }
  }
}

const changeMinusToZero = () => {
  iceberg.forEach((row, x) => {
    row.forEach((height, y) => {
      if (height === -1) {
        iceberg[x][y] = 0;
      }
    });
  });
};

let year = 0;

while (true) {
  const visited = [...Array(N)].map(() => Array(M).fill(false));
  let count = 0;
  for (let i = 1; i < N - 1; i++) {
    for (let j = 1; j < M - 1; j++) {
      if (!visited[i][j] && iceberg[i][j] > 0) {
        visited[i][j] = true;
        dfs([i, j], visited);
        count++;
      }
    }
  }
  if (count >= 2) {
    console.log(year);
    break;
  } else if (count === 0) {
    console.log(0);
    break;
  }
  melt();
  changeMinusToZero();
  year++;
}
