var username = document.login.user;
var password = document.login.pass;

var button1 = document.querySelector("#btnOK");
var button2 = document.querySelector("#btnReset");

var alertun = document.querySelector("#alert-un");
var alertpw = document.querySelector("#alert-pw");

button1.addEventListener("click", () => {
    alertun.style.display = "none";
    alertpw.style.display = "none";

    var lberr1 = alertun.querySelector("#lb-err-un");
    var lberr2 = alertpw.querySelector("#lb-err-pw");

    lberr1.textContent = "";
    lberr2.textContent = "";

    var pattern = /^[a-zA-Z][a-zA-Z0-9]{5,11}$/;
    if(!username.value.match(pattern)) {
        lberr1.textContent = (username.value != "") ? "Username không hợp lệ." : "Username không được để trống.";
        alertun.style.display = "inline";
    }

    if(password.value == "") {
        lberr2.textContent = "Password không được để trống.";
        alertpw.style.display = "inline";
    }
});

button2.addEventListener("click", () => {
    document.login.user.value = "";
    document.login.pass.value = "";

    alertun.style.display = "none";
    alertpw.style.display = "none";
})

window.addEventListener("keydown", (KeyboardEvent) => {
    if(KeyboardEvent.key == "Enter") {
        alertun.style.display = "none";
        alertpw.style.display = "none";

        var lberr1 = alertun.querySelector("#lb-err-un");
        var lberr2 = alertpw.querySelector("#lb-err-pw");
    
        lberr1.textContent = "";
        lberr2.textContent = "";

        var pattern = /^[a-zA-Z][a-zA-Z0-9]{5,11}$/;
        if(!username.value.match(pattern)) {
            lberr1.textContent = (username.value != "") ? "Username không hợp lệ." : "Username không được để trống.";
            alertun.style.display = "inline";
        }

        if(password.value == "") {
            lberr2.textContent = "Password không được để trống.";
            alertpw.style.display = "inline";
        }
    }
});

// window.addEventListener("keydown", (KeyboardEvent) => {
//     if(KeyboardEvent.key == "Backspace") {
//         document.login.user.value = "";
//         document.login.pass.value = "";
//     }
// });


