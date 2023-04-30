const input = []
const dist = [
  [1, 0],
  [-1, 0],
  [0, 1],
  [0, -1],
]
let N, pinAns, moveAns

const solution = () => {
  let s = 0
  let e = 5
  while (N-- > 0) {
    const map = input.slice(s, e)
    s += 6
    e += 6
    let cnt = 0
    map.forEach((r) => {
      cnt += r.filter((c) => c === "o").length
    })
    pinAns = cnt

    map.forEach((r, i) => {
      r.forEach((c, j) => {
        if (c === "o") {
          dfs(map, i, j, cnt, 0)
        }
      })
    })
    console.log(pinAns, moveAns)
  }
}

const dfs = (map, x, y, maxPin, pin) => {
  if (maxPin <= pinAns) {
    pinAns = maxPin
    moveAns = pin
  }

  dist.forEach((d) => {
    const nx = x + d[0]
    const ny = y + d[1]

    if (isIn(nx, ny) && map[nx][ny] === "o") {
      //핀근처를탐색해서 핀이 있는지 체크
      const nnx = nx + d[0]
      const nny = ny + d[1]
      if (isIn(nnx, nny) && map[nnx][nny] === ".") {
        //존재한다면 핀의 이동범위에 이동할 공간이 있는지 체크
        map[x][y] = "."
        map[nx][ny] = "."
        map[nnx][nny] = "o"

        map.forEach((r, i) => {
          r.forEach((c, j) => {
            if (map[i][j] === "o") dfs(map, i, j, maxPin - 1, pin + 1)
          })
        })
        //다음 실행을위해 초기화
        map[x][y] = "o"
        map[nx][ny] = "o"
        map[nnx][nny] = "."
      }
    }
  })
}

const isIn = (x, y) => {
  //핀이 맵안에 존재하는지 체크하는 함수
  return 0 <= x && x < 5 && 0 <= y && y < 9
}

require("readline")
  .createInterface(process.stdin, process.stdout)
  .on("line", (line) => {
    if (!N) {
      N = parseInt(line)
      return
    }
    input.push(line.split(""))
  })
  .on("close", () => {
    solution()
    process.exit()
  })
