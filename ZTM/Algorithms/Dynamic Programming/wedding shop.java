// Example
// UVa 11450 - Wedding Shopping
// Given:
//   Given different options for each garment (e.g. 3 shirt models, 2 belt models, 4 shoe models, …) and a certain limited budget, 
//   our task is to buy one model of each garment. 
//   We cannot spend more money than the given budget, but we want to spend the maximum possible amount

// Input:
//   Integers
//     1 ≤ M ≤ 200, M is budget
//     1 ≤ C ≤ 20, C is no. of garments
//     g element of [0..C-1], g is garment
//     1 ≤ K ≤ 20, no.of diff models for garment

// big(O)
//   O(kM)
//   M(0 to 200)
//   g(0 to 19)
//   M = 201 x 20 = 4020
//   k = 20
//   O(kM) = 4020 x 20 = 80400
  

// Output:
//   1 integer max  amt money can spent for each garment w/ou exceeding budget
//   no sol'n, print no solution
  
// Cases:
//   case A w/ M = 20, C =3:
//     Price of the 3 models of garment g=0 → 6 4 8 // the prices are not sorted in the input

//     Price of the 2 models of garment g=1 → 5 10

//     Price of the 4 models of garment g=2 → 1 5 3 5
//   case B w/ M = 9 (limited budget), C = 3:
//     Price of the 3 models of garment g=0 → 6 4 8

//     Price of the 2 models of garment g=1 → 5 10

//     Price of the 4 models of garment g=2 → 1 5 3 5 //print no soln

// Sol'n:
//   DP prereq(checked)
//     1.This problem has optimal sub-structures. This is illustrated in the third Complete Search recurrence above: The solution for the sub-problem is part of the solution of the original problem. In other words, if we select model i for garment g = 0, for our final selection to be optimal, our choice for garments g = 1 and above must also be the optimal choice for a reduced budget of M − price, where price refers to the price of model i.
//     2.This problem has overlapping sub-problems. This is the key characteristic of DP! The search space of this problem is not as big as the rough 2020 bound obtained earlier because many sub-problems are overlapping!

// Top Down sol'n
// assume that the necessary library files have been included
// this code is similar to recursive backtracking code
// parts of the code specific to top-down DP are commented with: ‘TOP-DOWN’
int M, C, price[25][25]; 
price[g (<= 20)][model (<= 20)]int memo[210][25]; 
// TOP-DOWN: 
dp table memo[money (<= 200)][g (<= 20)]int shop(int money, int g) {if (money < 0) return -1000000000; 
// fail, return a large -ve numberif (g == C) return M - money; 
// we have bought last garment, done 
// if the line below is commented, top-down DP will become backtracking!!
if (memo[money][g] != -1) return memo[money][g]; 
// TOP-DOWN: memorizationint 
ans = -1; 
// start with a -ve number as all prices are non negative for 
(int model = 1; model <= price[g][0]; model++) 
// try all 
modelsans = max(ans, shop(money - price[g][model], g + 1));return memo[money][g] = ans; } 
// TOP-DOWN: memoize ans and return it
int main() { 
// easy to code if you are already familiar with it
int i, j, TC, score;scanf("%d", &TC);while (TC--) {scanf("%d %d", &M, &C);for (i = 0; i < C; i++) {scanf("%d", &price[i][0]); 
// store K in 
price[i][0]for (j = 1; j <= price[i][0]; j++) scanf("%d", &price[i][j]);}memset(memo, -1, sizeof memo); 
// TOP-DOWN: initialize DP memo 
tablescore = shop(M, 0); 
// start the top-down DP
if (score < 0)  {
  printf("no solution");
}else {
  printf("%d", score);
}  
return 0;
