// 객체를 저장
var obj = {};

obj.add = function(a, b){
    return a+b;
}

obj.sub = function(a, b){
    return a-b;
}

// 객체를 모듈화 하려면 이렇게....
module.exports = obj;