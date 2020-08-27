var express = require("express");
var static = require("serve-static");
var path = require("path");
var bodyParser = require("body-parser"); // parser가 들어가면 자바스크립트의 객체로 만들어주는것

// 외부모듈이므로 따로 install 해야 함
var cookieParser = require("cookie-parser");


var app = express();    // 서버라고 생각...


// 미들웨어는 use()로 사용
// public이라는 폴더를 명시하지 않아도 접근 가능
app.use(static(path.join(__dirname,
"public")));
app.use(bodyParser.urlencoded({extended : false}));   
// extended : false 객체안에 또다른 객체가 있으면 안받겠다는 의미

// 미들웨어
app.use(bodyParser.json());
app.use(cookieParser());

/*
app.get("/test/test",function(req,res){
    res.send("test/test");
})
*/


// 라우터 객체 만들기
var router = express.Router();


router.route("/process/delCookie").get(function(req, res){
   console.log("/process/delCookie call") ;
    res.clearCookie("user");
     // 쿠키 삭제
    res.redirect("/");
});



router.route("/process/setUserCookie").get(function(req, res){
    console.log("/process/setUserCookie call");
    
    // 쿠키를 클라이언트로 보낸다...
    // 쿠키는 클라이언트에 저장되므로 res를 사용
    res.cookie("user",{
        id:'m001',
        name:'kim',
        age:16
    });
    
    res.redirect("/process/showCookie");

});

router.route("/process/setUserCookie").get(function(req, res){
    console.log("/process/setUserCookie call");
    
    // 쿠키에 정보가 저장되어 있음
    res.send(req.cookies);

});




// pathVariable 방식
router.route("/process/getUser/:id").get(function(req, res){
   
    // 키보드 1 왼쪽의 ``
    var msg =`
    <h1>/process/getUser/:id로 접근했음</h1>
    <p>id : ${req.params.id}</p>,
   
`;
    res.send(msg);
});



// get 방식
router.route("/process/getShow").get(function(req,res){
   var msg= `
    <h1>/process/getShow로 접근했음</h1>
    <p>id: ${req.query.id}</p>
    <p>name: ${req.query.name}</p>
` ;
    
    res.send(msg);
});




// post방식이면 req.body.id
// get방식이면 req.query.id



//post방식
router.route("/process/login").post(function(req, res){
    console.log("/process/login 접속"); 
    // 키보드 1 왼쪽의 ``
    var msg =`
    login.html로부터 넘겨받은 데이터<br>
    id : ${req.body.id},
    pw : ${req.body.pw}
`;
    res.send(msg);
});


// 라우터를 미들웨어로 사용한다 의미
// 모든 요청에 라우터가 사용될수 있도록 먼저 선언해 주어야한다.
app.use("/",router);



// 3000번 포트, 웹 개발이기에 request, response
app.listen(3000, function(req,res){
   console.log("ExpressExample2에 서버가 가동중");
});