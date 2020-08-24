var express = require("express");
var static = require("serve-static");
var path = require("path");
var bodyParser = require("body-parser");
var expressSession = require("express-session");
var fs = require("fs");

var app = express();

app.use(static(path.join(__dirname, "public")));

app.use(bodyParser.urlencoded({
    extended: false
}));
app.use(bodyParser.json());

app.use(expressSession({
    // 해당 코드를 넣어 암호화
    secret: "gangnam4",
    // 매번 새로 저장할 것인가. 일반 적으로 false 권장
    resave: true,
    saveUnintialized: true
}));

var router = express.Router();

router.route("/user/product").get(function (req, res) {
    console.log("/user/product call");
    // session 객체에 user라는 이름의 세션이 있는가?
    if (req.session.user) {
        // 세션이 있다면 해당 파일을 읽어서 데이터를 출력해라
        fs.readFile("./product.html", "utf-8", function (err, data) {
            res.send(data);
        });
    } else {
        res.redirect("/login2.html");
    }
});

router.route("/user/login").post(function (req, res) {
    console.log("/user/login call");

    var paramId = req.body.id;
    var paramPw = req.body.pw;

    if (req.session.user) {
        res.redirect("/user/product");
    } else {
        req.session.user = {
            id: paramId,
            pw: paramPw
        };
        res.send(`
            <h1>로그인 성공</h1>
            <p>${paramId}</p>
            <p>${paramPw}</p>
            <p><a href = "/user/product">상품 페이지로 이동</a></p>
        `);
    }
});

app.listen(3000, function (req, res) {
    console.log("서버 구동 중");
});
app.use("/", router);
