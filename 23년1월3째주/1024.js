var N,S,i,b=[],a=require('fs').readFileSync('/dev/stdin','utf8').trim().split(' ');
for(N=+a[1];N<=100;N++){
  S=+a[0]-N*(N-1)/2;
  if(S>=0&&S%N==0){
    S/=N;
    for(i=S;i<S+N;i++) b.push(i);
    console.log(b.join(' ')); break;
  }
}
if(N>100) console.log(-1);
