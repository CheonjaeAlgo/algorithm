function solution(tickets) {

    //dfs 로 푼 문제
    //방문을 확인해주고 dfs를
    var answer = [];
    const result=[];
    const len= tickets.length
    const visited=[];
    tickets.sort();
    //결과가 알파벳순이니까 정렬
    const dfs=(str,count)=>{
        result.push(str);
        
        if(count===len){
            answer=result
            return true;
        }
            for(let i=0;i<len;i++){
        if(!visited[i]&&tickets[i][0]===str){
            visited[i]=true;
            if(dfs(tickets[i][1],count+1))return true;
            visited[i]=false;
        }
    }
    result.pop();
    
    return false;
    }
    
    dfs("ICN",0);
    return answer;
}
