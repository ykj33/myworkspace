var obj = {};

obj.add = function (a, b) {
    return a + b;
}
obj.sub = function (a, b) {
    return a - b;
}

// 객체를 모듈로 넣어줄 때는 해당 방식을 사용하여야 한다.
module.exports = obj;