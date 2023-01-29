const fs = require("fs")
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt"
const [T, ...input] = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n")
  .map(Number)
//1번째 풀이 : 수식을 활용하여 dp로 품
//기본 타일링 문제는 2*n식으로 주어졌는데 이때에
//2*1,2*2로 경우의수를 나누었음을 생각했음
//4*n형식 타일링이니 4*4까지의 경우를 나누어서 수식으로 나타내면 될 것이라고 생각했슴
//4*4까지 대략적으로 그려서 점화식을 그려줌
const dp = new Array(500).fill(0)
dp[0] = 1
dp[1] = 5
dp[2] = 11
dp[3] = 36

let cnt = 5
for (let i = 0; i < T; i++) {
  if (dp[input[i] - 1] === 0) {
    for (let j = cnt - 1; j < input[i]; j++) {
      dp[j] = dp[j - 1] + dp[j - 2] * 5 + dp[j - 3] - dp[j - 4]

      //j-1 << 앞의 타일 배치 수와 동일 앞의타일배치 + 일자로
      //j-2 << 두개타일로 배치될 수있는 가짓 수(5)*j-2개갯수
      //j-3 <<3개타일로 배치 될 수 있는 경우의수 중 두개의 타일과 곂치지않는 조합
      //j-4<< 앞의 타일들의 경우의수에서 곂쳤을 경우의 수를 뺌.
      //A[n]=A[n-1]+5*A[n-2]+A[n-3]-A[n-4] 라는 점화식을 끌어낼 수 있슴
      //+A[n-3]-A[n-4]<<이부분 헤깔릴것 같아서 개인카톡에 사진자료로 설명
    }
  }
  console.log(dp[input[i] - 1])
  cnt = Math.max(cnt, input[i])
}
//2번째 풀이 :
