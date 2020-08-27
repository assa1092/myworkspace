//httpServer.js
var http = require('http');  
 
//HTTP 서버 시작  
http.createServer(function (req, res) {  
    var data = []; 
    /* 응답변수 오류 이벤트 */ 
    res.on('error', function(err) {  
        logger.log("event RES error : " + err);  
    });  
    /* 요청변수 오류 이벤트 */ 
    req.on('error', function(err) {  
        logger.log("event REQ error : " + err);  
    });  
    /* 요청 시 데이터 수신 이벤트 */ 
    req.on('data', function (chunk) {  
        data.push(chunk);  
        logger.log(" event data chunk length : " + chunk.length);  
    });  
    
    req.on('end', function () { 
        res.writeHead(200, {'Content-Type': 'text/plain'}); 
        res.end('Hello World!'); 
    });  
}).listen(9080);
