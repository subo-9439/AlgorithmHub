const fs = require('fs');

const [input] = fs.readFileSync(0,"utf8").toString().trim().split(' ').map(Number);
// const [input] = fs.readFileSync("input.txt").toString().trim().split(' ').map(Number);

function grade(n) {
  if(n>=90) return 'A';
  if(n>=80) return 'B';
  if(n>=70) return 'C';
  if(n>=60) return 'D';
  return "F";
}
console.log(grade(input));