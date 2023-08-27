
const img = document.querySelector('img');
const input = document.querySelector('input');
input.addEventListener('change', () => {
    img.src = URL.createObjectURL(input.files[0]);

});

function checkPid(string) {
    let re = /^[A-Z]{1}[12]{1}[0-9]{8}$/;
    if (string === '') {
        return false; // 欄位空白
    }
    else if (!re.test(string)) {
        return false; // 身分證字號格式不符
    }

    const conver = 'ABCDEFGHJKLMNPQRSTUVXYWZIO'; // 地區(對應轉換數字為10-35)
    const weights = [1, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1]; // 身分證字號對應位置權數

    string = String(conver.indexOf(string[0]) + 10) + string.slice(1); // 將輸入的字串轉換為對應數字字元

    checkSum = 0;
    for (let i = 0; i < string.length; i++) {
        c = parseInt(string[i]) // 將每一個對應的字元轉換為數字
        w = weights[i]
        // 每個相對應數字乘上權數，將積相加
        checkSum += c * w
    }
    // 若積總和為10的倍數，則為true，反之則為false
    return checkSum % 10 === 0;
}

const pid = document.getElementById("pid");
pid.addEventListener("blur", function () {
    if (!checkPid(pid.value.trim())){
        alert("身分證字號未填寫或內容有誤，請重新輸入！");
    }
});