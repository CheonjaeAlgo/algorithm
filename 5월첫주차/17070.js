function move(x,y,pipe){
  if(x === N && y === N)
    return answer++;
  else{
    for(let i=0; i<3; i++){
      let nextX = x + dxy[i][1];
      let nextY = y + dxy[i][0];
      // 방의 범위를 넘어갈때.
      if(nextX > N || nextY > N)
        continue;
      if(nextX > N || nextY > N)
        continue;

      // 가로->세로, 세로->가로 불가능.
      if(pipe === 0 && i === 1)
        continue;
      if(pipe === 1 && i === 0)
        continue;

      // 현재 대각선일때
      if(i===2){
        if(room[y][x+1] === 1 || room[y+1][x] === 1)
          continue;
      }

      if(room[nextY][nextX] === 0)
        move(nextX,nextY,i);
    }
  }
}
