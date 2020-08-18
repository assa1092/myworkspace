console.log("hello world");

console.log("숫자입니다.%d", 10+10);
console.log("숫자입니다.", 10+10);

console.log("문자열 입력.%s", "안녕");

var obj = {
    id : 'm001',
    name : 'john',
    age : 15
}

console.log("JSON 객체입니다.%j",obj);
// JSON객체라 변수명도 "" 감싸져있다...

console.dir(obj);

console.log(obj);


// 경과시간 체크하기
console.time("duration");
var result = 0;
for(var i=0; i<10000;i++){
    result +=1;
}
console.timeEnd("duration");

// 실행되고있는 파일이름정보
console.log(__filename);
// 실행되고있는 파일의 경로 정보
console.log(__dirname);