// 網頁載入後執行
document.addEventListener("DOMContentLoaded", function () {
    fetchMemberUpdateList();
});
//async function fetchMemberUpdateList() {
//    try {
//        // await : await必須放在任何基於promise的函數之前，等到獲得resolve的資料後，再執行後續動作
//        const response = await fetch('http://localhost:8080/u-and-me/member/update');
//
//        //response.json()：把資料轉成JSON格式
//        const membersList = await response.json();

//async function fetchMemberUpdateList() {
//    try {
//        // await : await必須放在任何基於promise的函數之前，等到獲得resolve的資料後，再執行後續動作
//        const response = await fetch('http://localhost:8080/u-and-me/member/update');
//
//        //response.json()：把資料轉成JSON格式
//        const memberUpdateList = await response.json();
//
//        let title_el = document.getElementById("title1");
//        let member_el = document.getElementById("member1");
//        let day_el = document.getElementById("day1");
//        let price_el = document.getElementById("price1");
//        let cover_el = document.getElementById("cover1")
//
//        let n = 1; //定義n讓下面各id可以按順序增加
//        groupsList.forEach(group => {
//            title_el = document.getElementById("title" + n);
//            member_el = document.getElementById("member" + n);
//            day_el = document.getElementById("day" + n);
//            price_el = document.getElementById("price" + n);
//            cover_el = document.getElementById("cover" + n)
//
//            let dataurl = `data:image/png;base64,${group.cover}`
//            cover_el.src = dataurl;
//
//            title_el.innerHTML = `${group.theme}`;
//
//            let member = parseInt(`${group.m}`, 10);
//            if (member > 0) {
//                member_el.innerHTML = `剩餘 <span style="color: red;"> ${group.m} </span> 人成團`;
//            } else {
//                member_el.innerHTML = `<span style="color: red;">已達出團人數但仍可報名</span>`
//            }
//
//            day_el.innerHTML = `${group.d}`;
//            price_el.innerHTML = `${group.amount}`;
//            n += 1;
//        });
//
//
//
//
//
//    } catch (error) {
//        console.error("Error fetching groupList:", error);
//    }
//}
(() => {
    let member;
    let districtData;

    const inputName = document.getElementById('inputName');
    const GenderSelectElement = document.getElementById('inputGender');
    const inputEmail = document.getElementById('inputEmail');
    const inputPassword = document.getElementById('inputPassword');
    const inputPhone = document.getElementById('inputPhone');
    const inputAddress = document.getElementById('inputAddress');


    document.addEventListener('DOMContentLoaded', function () {
        guardIsSignedIn();
        preventSpaceInput();
        Promise.all([fetchMember(), fetchDistrictData()]).then(() => {
            initSelectedAddress(member, districtData);
        });
        document.getElementById('form').addEventListener('submit', handleSubmit);
        citySelectElement.addEventListener('change', handleCityChange);
    });

    function preventSpaceInput() {
        const inputElements = document.querySelectorAll('input');
        inputElements.forEach(input => {
            input.addEventListener('keypress', function (e) {
                if (e.key === ' ') {
                    e.preventDefault();
                }
            });
        });
    }

    async function fetchMember() {
        const memberId = getMemberId();
        const url = `/members/{memId}`;
        try {
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

//
//    function redirectToProfilePage() {
//        window.location.href = "/member/profile.html";
//    }
//
//    async function fetchDistrictData() {
//        try {
//            const response = await fetch('/members/districts');
//            const data = await response.json();
//            districtData = data;
//            populateCitySelect(data);
//        } catch(e) {
//            console.log("Error:" + e);
//        }
//    }
//
//    function populateCitySelect(data) {
//        const cityOptions = data.map((cityInfo, index) => `<option value=${index}>${cityInfo.name}</option>`);
//        citySelectElement.innerHTML = cityOptions.join('');
//        handleCityChange();
//    }
//
//    function handleCityChange() {
//        const cityIndex = citySelectElement.value;
//        const districtInfo = districtData[cityIndex];
//        populateDistrictSelect(districtInfo);
//    }
//
//    function populateDistrictSelect(districtInfo) {
//        const districtOptions = districtInfo.districts.map(district => `<option value=${district.name}>${district.name}</option>`);
//        districtSelectElement.innerHTML = districtOptions.join('');
//    }
//
//    function initSelectedAddress(member, districtData) {
//        const cityIndex = districtData.findIndex(cityInfo => member.address.includes(cityInfo.name));
//        if (cityIndex !== -1) {
//            citySelectElement.value = cityIndex;
//            handleCityChange();
//            const districtIndex = districtData[cityIndex].districts.findIndex(district => member.address.includes(district.name));
//            if (districtIndex !== -1) {
//                districtSelectElement.value = districtData[cityIndex].districts[districtIndex].name;
//                const cityName = districtData[cityIndex].name;
//                const districtName = districtData[cityIndex].districts[districtIndex].name;
//                const cityDistrictName = cityName + districtName;
//                addressInput.value = member.address.replace(`${cityDistrictName}`, '');
//            }
//        }
//    }
//})
();
