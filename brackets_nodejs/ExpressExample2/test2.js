var express = require("express");
var static = require("serve-static");
var path = require("path");
var bodyParser = require("body-parser");
var expressSession = require("express-session");
var fs = require("fs");
var nodemailer = require("nodemailer");

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

// 로그인 해야만 접속할 수 있도록
router.route("/user/email2").get(function (req, res) {
    console.log("/user/email2 call");
    // session 객체에 user라는 이름의 세션이 있는가?
    if (req.session.user) {
        // 세션이 있다면 해당 파일을 읽어서 데이터를 출력해라
        fs.readFile("./email2.html", "utf-8", function (err, data) {
            res.send(data);
        });
    } else {
        res.redirect("/login2.html");
    }
});

router.route("/user/email").post(function (req, res) {
    console.log("/user/email call");
    // html페이지에서 받아온 값
    var sender = req.body.sender;
    var senderpw = req.body.senderpw;
    var receiver = req.body.receiver;
    var subject = req.body.subject;
    var content = req.body.content;

    // 어디에서 누가 발송할 것인가에 대한 정보를 transporter가 가지고 있음
    var transporter = nodemailer.createTransport({
        service: "gmail",
        host: "smtp.gmail.com",
        port: 587,
        secure: false,
        auth: {
            user: sender, 
            pass: senderpw
        }
    });
    // 메일의 내용에 대한 정보
    var mailOptions = {
        from: sender,
        to: receiver,
        subject: subject,
        text: content
    };

    // 실제로 보냄
   
    transporter.sendMail(mailOptions, function(err, info){
        if(err) {
            console.log(err);
            return;
        }
        res.send("발송 성공");
    });

   
});

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

// 로그아웃
router.route("/user/logout").get(function (req, res) {
    console.log("/user/logout call");
    if (req.session.user) {
        console.log("로그아웃을 합니다.");
        // destroy로 세션 삭제
        req.session.destroy(function (err) {
            if (err) {
                console.log("세션 삭제 중 에러 발생");
                return;
            }
            console.log("세션 삭제 성공");
            res.redirect("/login2.html");
        });
    } else {
        console.log("로그인이 되어 있지 않음");
        res.redirect("/login2.html");
    }
});

app.use("/", router);
