// 網頁載入後執行
document.addEventListener("DOMContentLoaded", function () {
    fetchMemberUpdateList();
});
    const inputName = document.getElementById('inputName');
    const GenderSelectElement = document.getElementById('inputGender');
    const inputEmail = document.getElementById('inputEmail');
    const inputPassword = document.getElementById('inputPassword');
    const inputPhone = document.getElementById('inputPhone');
    const inputAddress = document.getElementById('inputAddress');

    async function fetchMember() {
        const memberId = getMemberId();
        const url ="http://localhost:8080/u-and-me/member/update";

        try {
        inputName = this.inputName;
        inputEmail = this.inputEmail;
        inputPassword = this.inputPassword;
        inputPhone = this.inputPhone;
        inputAddress =this.inputPhone;

            const response = await fetch(url);
            member = await response.json();
            displayMember(member);
        } catch(e) {
            console.log("Error: " + e);
        }
    }

    function displayMember(member) {
        // Populate form with member info
        inputName.value = member.inputName;
        inputEmail.value = member.inputEmail;
        inputPassword.value = member.inputPassword;
        inputPhone.value = member.inputPhone;
        inputAddress.value = member.inputAddress;
        // Continue for all fields
    }

    function handleSubmit(event) {
        event.preventDefault();
        if (validateForm()) {
            showConfirmDialog();
        }
    }

    function showConfirmDialog() {
        const inputName = inputName.value;
        const inputEmail = inputEmail.value;
        const inputPassword = inputPassword.value;
        const inputPhone = inputPhone.value;
        const inputAddress = inputAddress.value;

        const newMember = member;
        newMember.inputName = inputName;
        newMember.inputEmail = inputEmail;
        newMember.inputPassword = inputPassword;
        newMember.inputPhone = inputPhone;
        newMember.inputAddress = inputAddress;

        Swal.fire({
            title: '確認會員資料',
            html: `
            <div class="row">
                <div class="col-4">姓名</div>
                <div class="col-8 text-left">${inputName}</div>
            </div>
            <div class="row">
                <div class="col-4">帳號</div>
                <div class="col-8 text-left">${newMember.inputEmail}</div>
            </div>
//            <div class="row">
//                <div class="col-4">生日</div>
//                <div class="col-8">${birthday}</div>
//            </div>
            <div class="row">
                <div class="col-4">電話</div>
                <div class="col-8">${inputPhone}</div>
            </div>
            <div class="row">
                <div class="col-4">信箱</div>
                <div class="col-8">${email}</div>
            </div>
            <div class="row">
                <div class="col-4">地址</div>
                <div class="col-8">${inputAddress}</div>
            </div>
        `,
        }).then((result) => {
            if (result.isConfirmed) {
                updateMember(newMember);
            }
        });
    }

    function updateMember(newMember) {
        fetch('http://localhost:8080/u-and-me/member/update', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(newMember)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error(response.status);
            })
            .then(json => redirectToProfilePage())
            .catch(error => {
                Swal.fire({
                    title: '修改失敗',
                    icon: 'error',
                    confirmButtonText: '確認'
                });
            });
    }

    function validateForm() {
        // Initialization
        let isFormValid = true;

        // Input validations
        const validations = [
            [inputName, '請輸入姓名'],
            [inputEmail, '請輸入電子郵件'],
            [inputEmail, '請輸入符合格式的電子郵件', /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/],
            [inputPhone, '請輸入電話號碼'],
            [inputPhone, '請輸入符合格式的台灣電話號碼', /^(\+886\-|\(02\)|09)[0-9\-]{7,10}$/],
            [inputAddress, '請輸入地址']
        ];

        for(const [inputElement, errorMessage, regex] of validations) {
            if (!validateInputElement(inputElement, errorMessage, regex)) {
                isFormValid = false;
                inputElement.focus();
                return isFormValid;
            }
        }

        // Select validation
        if (citySelectElement.selectedIndex === -1 || districtSelectElement.selectedIndex === -1) {
            showInvalidFeedback(citySelectElement, 'Please select your city.');
            showInvalidFeedback(districtSelectElement, 'Please select your district.');
            isFormValid = false;
            return isFormValid;
        }

        return isFormValid;
    }

    function validateInputElement(inputElement, errorMessage, regex = null) {
        if (inputElement.value === '' || (regex && !regex.test(inputElement.value))) {
            showInvalidFeedback(inputElement, errorMessage);
            return false;
        } else {
            removeInvalidFeedback(inputElement);
            return true;
        }
    }

    function showInvalidFeedback(inputElement, errorMessage) {
        inputElement.classList.add('is-invalid');
        const existingFeedbackElement = inputElement.parentNode.querySelector('.invalid-feedback');

        if (existingFeedbackElement) {
            existingFeedbackElement.textContent = errorMessage;
        } else {
            const newFeedbackElement = document.createElement('div');
            newFeedbackElement.classList.add('invalid-feedback');
            newFeedbackElement.textContent = errorMessage;
            inputElement.parentNode.appendChild(newFeedbackElement);
        }
    }

    function removeInvalidFeedback(inputElement) {
        inputElement.classList.remove('is-invalid');
        const feedbackElement = inputElement.parentNode.querySelector('.invalid-feedback');
        if (feedbackElement) {
            feedbackElement.remove();
        }
    }

();
