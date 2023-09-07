   document.addEventListener("DOMContentLoaded", function () {
          console.log("HIIIII");
             fetchMemDetail();
        });


//載入會員原先資料


// 表單中的各輸入框元素
const memName = document.getElementById('memName');
const memIdcard = document.getElementById('memIdcard');
const memPhone = document.getElementById('memPhone');
const memGender = document.getElementById("memGender");
const submitBtn = document.querySelector('button[type="submit"]');
var memEmail;

// 使用 fetch API 發送請求，獲取單筆會員詳細資料
async function fetchMemDetail() {
    try {
        const baseUrl = window.location.protocol + "//" + window.location.host + "/u-and-me/";
        const res = await fetch(baseUrl + `member/getMemId`);
        const member = await res.json();
        const memId = member.memId;
        const response = await fetch(baseUrl + `member/Details/${memId}`);
        const MemDetail = await response.json();
        memEmail = MemDetail.memEmail;
        console.log(MemDetail);


        // 將會員詳細資訊填充到輸入框中
        memEmail.value = MemDetail.memEmail;
        memName.value = MemDetail.memName;
        memIdcard.value = MemDetail.memIdcard;
        memPhone.value = MemDetail.memPhone;
        memGender.value = MemDetail.memGender;

    } catch (error) {
        console.error('Error fetching Member detail:', error);
    }
}


//
//







    const baseUrl = window.location.protocol + "//" + window.location.host + "/u-and-me/";
    //團主申請的身分證照片預覽
    // const imageInput = document.getElementById('imageInput');
    const preview = document.getElementById('preview');
    const groupRegBtn_el = document.getElementById("groupBtn");
    const memIdcardPic_el = document.getElementById("memIdcardPic");

    memIdcardPic_el.addEventListener('change', (event) => {
        preview.innerHTML = '';
        const file = event.target.files[0];

        const imageURL = URL.createObjectURL(file);
        const image = new Image();
        image.src = imageURL;
        image.style.maxWidth = '200px'; // 設定預覽圖最大寬度
        image.style.maxHeight = '200px'; // 設定預覽圖最大高度
        preview.appendChild(image);
    });

    async function getMemId() {
        const response = await fetch(baseUrl+"member/getMemId");
        console.log(response);
        respJson = await response.json();
        let memId = respJson.memId;
        return Number(memId);
    }

    //團主申請的身分證上傳
    // async function groupRegister(memIdPic) {
    //     // const response = await fetch("http://localhost:8081/u-and-me/member/groupRegister", {
    //     //     method: "POST",
    //     //     headers: {
    //     //         "Content-Type": "application/json",
    //     //     },
    //     //     body: JSON.stringify(member)
    //     // });

    //     // if (response.ok) {
    //     //     console.log("團主註冊成功");
    //     // } else {
    //     //     console.log("團主註冊失敗，請再次嘗試");
    //     // }
    //     const response = await fetch("http://localhost:8081/u-and-me/member/memberGroupRegister/" + await getMemId(), {
    //         method: "POST",
    //         headers: {
    //             "Content-Type": "application/json",
    //         },
    //         body: JSON.stringify(memIdPic)
    //     });

    //     if (response.ok) {
    //         alert("團主註冊成功");
    //     } else {
    //         alert("團主註冊失敗，請再次嘗試");
    //     }
    // }


    groupRegBtn_el.addEventListener("click", async function () {
        const picFile = memIdcardPic_el.files[0];
        // const formData = new FormData();
        // formData.append('image', picFile);
        // const idcard_base64String = btoa(picFile);
        // console.log("PicBse64: " + idcard_base64String);
        const fileReader = await new FileReader();
        fileReader.onload = async event => {
            const base64Str = btoa(event.target.result);
            console.log(base64Str);
            let memId = await getMemId();
            console.log("memId: "+memId);
            const response = await fetch(baseUrl+'member/memberGroupRegister/' + memId, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    pictureData: base64Str
                })
            });

        };
        fileReader.readAsBinaryString(picFile);

        // const memName = document.getElementById("memName").value;
        // const memGender = document.getElementById("memGender").value;
        // const memEmail = document.getElementById("memEmail").value;
        // const memPhone = document.getElementById("memPhone").value;
        // const memIdcard = document.getElementById("memIdcard").value;
        // const memAddr = document.getElementById("memAddr").value;

        //包裝一個申請團主專用 增加身分證圖片的DTO 後端記得寫
        // console.log(memIdCard_el.value);
        // const memIdPic = {
        //     memIdPic: idcard_base64String
        // };

        // groupRegister(memIdPic);
    });



//
//const img = document.querySelector('img');
//const input = document.querySelector('input');
//input.addEventListener('change', () => {
//    img.src = URL.createObjectURL(input.files[0]);
//
//});


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

const pid = document.getElementById("memIdcard");
pid.addEventListener("blur", function () {
    if (!checkPid(pid.value.trim())){
        alert("身分證字號未填寫或內容有誤，請重新輸入！");
    }
});