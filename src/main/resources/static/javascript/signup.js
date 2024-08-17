document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("form1");
    const password = document.getElementById("password");
    const passwordCheck = document.getElementById("password-check");
    const emailInput = document.getElementById("email");
    const checkEmailButton = document.getElementById("check-email");
    const signUpButton = document.getElementById("sign-up");
    let isEmailValid = false;

    // Function to toggle Sign Up button based on email validity
    function toggleSignUpButton() {
        signUpButton.disabled = !isEmailValid;
    }

    // Email check button event listener
    checkEmailButton.addEventListener("click", () => {
        const email = emailInput.value.trim();

        if (email === '') {
            alert('이메일을 입력하세요');
            isEmailValid = false;
            toggleSignUpButton();
            return;
        }

        fetch('/check-email', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({ email })
        })
        .then(response => response.json())
        .then(data => {
            if (data) { // Assuming the server responds with { exists: true/false }
                alert('이미 사용된 이메일입니다');
                isEmailValid = false;
            } else {
                alert('사용 가능한 이메일입니다');
                isEmailValid = true;
            }
            toggleSignUpButton();
        })
        .catch(error => {
            console.error('Email check failed:', error);
            alert('이메일 중복 체크에 실패했습니다');
        });
    });

    // Form submit event listener
    form.addEventListener("submit", (e) => {
        const passwordValue = password.value;
        const passwordCheckValue = passwordCheck.value;

        // Password validation conditions
        const hasSpecialCharacter = /[!@#$%^&*(),.?":{}|<>]/.test(passwordValue);
        const hasLetter = /[a-zA-Z]/.test(passwordValue);
        const hasMinLength = passwordValue.length >= 12;

        if (!isEmailValid) {
            e.preventDefault();
            alert("중복체크를 해주세요");
        } else if (passwordValue !== passwordCheckValue) {
            e.preventDefault();
            alert("Password와 Password Check가 불일치합니다");
        } else if (!hasSpecialCharacter) {
            e.preventDefault();
            alert("1개 이상의 특수문자가 필요합니다");
        } else if (!hasLetter) {
            e.preventDefault();
            alert("1개 이상의 영어 알파벳이 필요합니다");
        } else if (!hasMinLength) {
            e.preventDefault();
            alert("최소 12자를 입력해주세요");
        }
    });
});
