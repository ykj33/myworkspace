var express = require("express");
var static = require("serve-static");
var path = require("path");
var bodyParser = require("body-parser");
// 외부모듈이므로 따로 install 해야 함
var cookieParser = require("cookie-parser");


var app = express(); // 서버라고 생각

// 미들웨어는 use()로 사용
// public이라는 폴더를 명시하지 않아도 접근 가능
app.use(static(path.join(__dirname, "public")));
// 객체 안에 또 다른 객체가 들어가 있을 경우 받지 않겠다.
app.use(bodyParser.urlencoded({
    extended: false
}));
app.use(bodyParser.json());
app.use(cookieParser());

var router = express.Router();

router.route("/process/delCookie").get(function(req, res){
   console.log("/process/delCookie call");
    // 쿠키 삭제
    res.clearCookie("user");
    res.redirect("/");
});

router.route("/process/showCookie").get(function (req, res) {
    console.log("/process/showCookie 접속");
    // 쿠키에 정보가 저장되어 있음
    res.send(req.cookies);
});

router.route("/process/setUserCookie").get(function (req, res) {
    console.log("/process/setUserCookie call");
    // 쿠키는 클라이언트에 저장되므로 res를 사용
    res.cookie("user", {
        id: 'm001',
        name: "kim",
        age: 16
    });
    res.redirect("/process/showCookie");
});

//app.get("test/test", function (req, res) {
//
//    res.send("test/test");
//});

// pathVariable 방식
router.route("/process/getUser/:id").get(function (req, res) {
    console.log("process/getUser 접속");

    var msg = `
<h1>/process/getUser/:id로 접근했음</h1>
<p>id : ${req.params.id}</p>
`;
    res.send(msg);
});

// get 방식
router.route("/process/getShow").get(function (req, res) {
    console.log("/process/getShow 접속");
    var msg = `
<h1>/process/getShow로 접근했음</h1>
<p>id : ${req.query.id}</p>
<p>name : ${req.query.name}</p>
`;
    res.send(msg);
});

// post 방식
router.route("/process/login").post(function (req, res) {
    console.log("/process/login 접속");
    // literal templete 사용
    var msg = `
login.html로부터 넘겨받은 데이터<br>
id : ${req.body.id},
pw : ${req.body.pw}
`;
    // msg를 출력해준다.
    res.send(msg);
});



// 모든 요청에 라우터가 사용될 수 있도록 먼저 선언해주어야 한다.
app.use("/", router);

//router.route("/process/login").post(function (req, res) {
//    console.log("/process/login 접속했음");
//});

// 3000번 포트, 웹 개발이기에 requset, response
app.listen(3000, function (req, res) {
    console.log("ExpressExample2 서버가 가동 중입니다.");
});
