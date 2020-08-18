// 가져오려는 모듈이 현재 디렉토리에 있다.
var calc = require('./calc');
// 모듈 사용
console.log(calc.add(2, 5));

var calc2 = require('./calc2');
console.log(calc2.sub(2, 3));

var calc3 = require('./calc3');
console.log(calc3.add(10, 10));
console.log(calc3.sub(10, 10));