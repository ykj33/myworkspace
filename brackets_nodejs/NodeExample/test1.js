console.log("hello world");

console.log("숫자입니다. %d", 10);

// 문자열은 %s
console.log("문자열 입력. %s", "안녕");

var obj = {
    id: 'm001',
    name: 'john',
    age: 15
}

// JSON 객체는 %j
// 속성명이 ""로 감싸져 있다면 JSON객체
console.log("JSON 객체입니다. %j", obj);


// 출력되는 방식은 같으므로 편한 방식을 사용하면 된다.
console.dir(obj);

console.log(obj);

// start, startEnd로 해도 된다.
// var은 전역변수, 함수 안에 var를 쓰면 지역변수
console.time("duration");
var result = 0;
for (var i = 0; i < 10000; i++) {
    result += i;
}
console.timeEnd("duration");

// 실행되는 파일의 파일정보
console.log(__filename);
// 실행되는 파일의 디렉토리 정보, 좀 더 중요
console.log(__dirname);