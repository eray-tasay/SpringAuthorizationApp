const passwordInputElm = document.querySelector("#register-form #password");
const confirmPasswordInputElm = document.querySelector("#register-form #confirm-password");
const submitBtn = document.querySelector("#register-form button[type='submit']");

submitBtn.onclick = (e) => {
    if (passwordInputElm.value !== confirmPasswordInputElm.value) {
        e.preventDefault();
        alert("Passwords don't match");
    }
};
