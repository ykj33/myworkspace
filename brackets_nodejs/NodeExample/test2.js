// 0번에는 node.js가 설치된 위치, 1번째는 현재 실행 파일의 위치
console.log(process.argv);

var arr = process.argv;
for (var i = 0; i < arr.length; i++) {
    console.log(i, arr[i]);
}

console.log("::::::::::::::::::::::");

process.argv.forEach(function (item, index) {
    console.log(index, ": ", item);

});
