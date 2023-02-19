let input= require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

for(let i=1; i < input.length;){
    let section = Number(input[i]);
    let arr = input.slice(i+1, i+1+section).map( i=> i.split(' ').map(i => +i));
    sol(arr);
    i += section + 1;
}


function sol(arr){
    arr =  arr.sort((a,b) => a[0]-b[0]);
    let result = 1;
    let minScore = arr[0][1];
    for(let i=1; i < arr.length; i++){
        if(minScore > arr[i][1]){
            result += +1;
            minScore = arr[i][1];
        }
    }
    console.log(result);
}
