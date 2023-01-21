let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const ports = input[1].split(" ").map(Number);

let LIS = [ports[0]];

function BinarySearch(num) {
  let lt = 0;
  let rt = LIS.length - 1;

  while (lt <= rt) {
    let mid = parseInt((lt + rt) / 2);

    if (LIS[mid] === num) return mid;
    else if (LIS[mid] > num) rt = mid - 1;
    else lt = mid + 1;
  }
  return lt;
}

for (let port of ports) {
  if (port > LIS[LIS.length - 1]) {
    LIS.push(port);
  } else {
    let idx = BinarySearch(port);
    LIS[idx] = port;
  }
}

console.log(String(LIS.length));
