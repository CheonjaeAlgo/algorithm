const fs = require("fs")

const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"

const input = fs.readFileSync(filePath).toString().trim().split("\n")

let answer = ""
for (let i = 0; i < input.length; i++) {
  if (input[i].trim() === "end") break
  answer += tictacto(input[i]) + "\n"
}
console.log(answer.trim())
function tictacto(arr) {
  let board = []
  let countO = 0,
    countX = 0,
    flagO = false,
    flagX = false
  board.push(arr.slice(0, 3).trim())
  board.push(arr.slice(3, 6).trim())
  board.push(arr.slice(6).trim())
  //slice 잘못써서 고생했슴
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === "O") countO++
    else if (arr[i] === "X") countX++
  }

  if (countX - countO === 1 || countX - countO === 0);
  else {
    return "invalid"
  }
  //O가 이길때
  for (let i = 0; i < 3; i++) {
    if (board[i][0] === "O" && board[i][1] === "O" && board[i][2] === "O") {
      flagO = true
      if (countX > countO) return "invalid"
    }
  }
  for (let i = 0; i < 3; i++) {
    if (board[0][i] === "O" && board[1][i] === "O" && board[2][i] === "O") {
      flagO = true
      if (countX > countO) return "invalid"
    }
  }
  if (board[0][0] === "O" && board[1][1] === "O" && board[2][2] === "O") {
    flagO = true
    if (countX > countO) return "invalid"
  }
  if (board[0][2] === "O" && board[1][1] === "O" && board[2][0] === "O") {
    flagO = true
    if (countX > countO) return "invalid"
  }
  //O경우 끝
  //X가 이길때
  for (let i = 0; i < 3; i++) {
    if (board[i][0] === "X" && board[i][1] === "X" && board[i][2] === "X") {
      flagX = true
      if (flagO || countX === countO) return "invalid"
    }
  }
  for (let i = 0; i < 3; i++) {
    if (board[0][i] === "X" && board[1][i] === "X" && board[2][i] === "X") {
      flagX = true
      if (flagO || countX === countO) return "invalid"
    }
  }
  if (board[0][0] === "X" && board[1][1] === "X" && board[2][2] === "X") {
    flagX = true
    if (flagO || countX === countO) return "invalid"
  }
  if (board[0][2] === "X" && board[1][1] === "X" && board[2][0] === "X") {
    flagX = true
    if (flagO || countX === countO) return "invalid"
  }
  //X경우 끝
  //둘다 못 이기고 둘데가 있는데 끝났을 때
  if (!flagO && !flagX) {
    for (let i = 0; i < arr.length; i++) {
      if (arr[i] === ".") return "invalid"
    }
  }
  return "valid"
}
