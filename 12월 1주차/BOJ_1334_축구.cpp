#include <bits/stdc++.h>
using namespace std;

double dp[20][20][20];

bool isPrime(int n){
	if(n < 2) return 0;
	for(int i=2; i*i<=n; i++) if(n%i==0) return 0;
	return 1;
}

int main(){
	double a, b; cin >> a >> b;
	dp[0][0][0] = 1.0;
	a /=100, b /= 100;
	for(int i=1; i<=18; i++){
		for(int j=0; j<=i; j++){
			for(int k=0; k<=i; k++){
				if(j > 0) dp[i][j][k] += dp[i-1][j-1][k] * a * (1-b);
				if(k > 0) dp[i][j][k] += dp[i-1][j][k-1] * (1-a) * b;
				if(j > 0 && k > 0) dp[i][j][k] += dp[i-1][j-1][k-1] * a * b;
				dp[i][j][k] += dp[i-1][j][k] * (1-a) * (1-b);
			}
		}
	}

	double ans = 0;
	for(int i=0; i<=18; i++){
		for(int j=0; j<=18; j++){
			if(isPrime(i) || isPrime(j)) ans += dp[18][i][j];
		}
	}
	printf("%.9lf", ans);
}