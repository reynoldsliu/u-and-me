//===================使用到的元素===================
let minMember_el = document.getElementById("minMember");
let maxMember_el = document.getElementById("maxMember");
let theme_el = document.getElementById("theme");
let amount_el = document.getElementById("amount");
let depDate_el = document.getElementById("depDate");
let deadline_el = document.getElementById("deadline");
let groupDesc_el = document.getElementById("groupDesc");
let notice_el = document.getElementById("notice");
let cover_el = document.getElementById("cover");
let cover_img_el = document.getElementById("cover_img");
let btn_submit_el = document.getElementById("btn_submit");

//用於紀錄原始數據
let cover;
// let memId;
// let schId;
// let members;
// let startDate;
// let groupSta;
// let paymentSta;

//===================使用到的元素結束===================

// //讓圖片轉成blob給filereader解析
// cover = dataURItoBlob(dataurl);
//網頁載入後執行
document.addEventListener("DOMContentLoaded", function () {
    let groupId;


    let today = new Date();//用於驗證、取得目前時間
    const isNumeric = n => !isNaN(n);//判斷數字

    // const inputMinMember_el = this.document.getElementById("inputMinMember");
    // const inputMaxMember_el = this.document.getElementById("inputMaxMember");
    // const inputTheme_el = this.document.getElementById("inputTheme");
    // const inputAmount_el = this.document.getElementById("inputAmount");
    // const inputDepDate_el = this.document.getElementById("inputDepDate");
    // const inputDeadline_el = this.document.getElementById("inputDeadline");
    // const inputGroupDesc_el = this.document.getElementById("inputGroupDesc");
    // const inputNotice_el = this.document.getElementById("inputNotice");


    //===================取得網址頁上傳遞的參數===================

    //先取得網址字串
    let url = location.href;

    //再來用去尋找網址列中是否有資料傳遞(QueryString)(有?則代表有資料傳遞)
    if (url.indexOf('?') != -1) {

        //之後去分割字串把分割後的字串放進陣列中
        let ary1 = url.split('?');
        //此時ary1裡的內容為：
        //ary1[0] = 'http://127.0.0.1:5501/tmp/Front/myGroupListUpdate.html'，ary2[1] = 'groupId=1'

        //以下為若傳遞參數為兩個做法 如果為一個可省略
        //let ary2 = ary1[1].split('&');
        //參數分別為 arr2[0],arr2[1]

        //在進一步以=做劃分 取得id資料
        let arr3 = ary1[1].split('=');
        //ary3[0] = groupId, arr3[1]=1

        //取得傳遞的Id值
        groupId = arr3[1];
    }
    //===================取得網址頁上傳遞的參數結束===================
    fetchMyGroup(groupId);

    //因為可能不改圖片，所以當change時才觸發檔案流
    cover_el.addEventListener('change', changeListener);
    function changeListener() {
        const id = this.id;
        const files = this.files;
        const img = document.getElementById("cover_img");

        //1. 取得File物件
        cover = files[0];
        img.src = URL.createObjectURL(cover);

        //2. 實例化FileReader物件
        const fileReader = new FileReader();

        //3. 替FileReader物件 註冊 載入監聽器
        fileReader.onload = async event => {
            //4. 轉成Base64字串
            cover = btoa(event.target.result);
        }
        //5. 開始讀取檔案
        fileReader.readAsBinaryString(cover);
    }

    //===================送出更新開始===================
    btn_submit_el.addEventListener("click", async function (e) {
        e.preventDefault();

        // if (minMember_el.value === null || minMember_el.value === "" || minMember_el.value < 0 || minMember_el.value > maxMember_el.value || isNumeric(minMember_el.value)) {
        //     // alert('成團最小人數有誤');
        //     let str = document.createElement("span");
        //     str.style.color='red';
        //     str.innerHTML = '==成團最小人數有誤'
        //     inputMinMember_el.appendChild(str);
        // }

        // if (maxMember_el.value === null || maxMember_el.value === "" || maxMember_el.value < minMember_el.value || isNumeric(maxMember_el.value)) {
        //     // alert('成團最大人數有誤');
        //     let str = document.createElement("span");
        //     str.style.color='red';
        //     str.innerHTML = '==成團最大人數有誤'
        //     inputMaxMember_el.appendChild(str);
        // }

        // if (theme_el.value === null || theme_el.value === "") {
        //     // alert('標題不可為空值');
        //     let str = document.createElement("span");
        //     str.style.color='red';
        //     str.innerHTML = '==標題不可為空值'
        //     inputTheme_el.appendChild(str);
        // }

        // if (amount_el.value === null || amount_el.value === "" || amount_el.value < 0 || isNumeric(amount_el.value)) {
        //     // alert('價格不可為空值');
        //     let str = document.createElement("span");
        //     str.style.color='red';
        //     str.innerHTML = '==價格不可為空值'
        //     inputAmount_el.appendChild(str);
        // }

        // if (depDate_el.value === null || depDate_el.value === "" || today.toLocaleDateString() > depDate_el.value || depDate_el.value < deadline_el.value) {
        //     // alert('行程出發日期有誤');
        //     let str = document.createElement("span");
        //     str.style.color='red';
        //     str.innerHTML = '==行程出發日期有誤'
        //     inputDepDate_el.appendChild(str);
        // }

        // if (deadline_el.value === null || deadline_el.value === "" || today.toLocaleDateString() > deadline_el.value || deadline_el.value > depDate_el.value) {
        //     // alert('揪團截止日期不可為空值');
        //     let str = document.createElement("span");
        //     str.style.color='red';
        //     str.innerHTML = '==揪團截止日期不可為空值'
        //     inputDeadline_el.appendChild(str);
        // }

        // if (groupDesc_el.value === null || groupDesc_el.value === "") {
        //     // alert('揪團描述不可為空值');
        //     let str = document.createElement("span");
        //     str.style.color='red';
        //     str.innerHTML = '==揪團描述不可為空值'
        //     inputGroupDesc_el.appendChild(str);
        // }

        // if (notice_el.value === null || notice_el.value === "") {
        //     // alert('行前通知不可為空值');
        //     let str = document.createElement("span");
        //     str.style.color='red';
        //     str.innerHTML = '==行前通知不可為空值'
        //     inputNotice_el.appendChild(str);
        // }

        //將資料包裝成一個物件
        const send_data = {
            groupId: groupId,
            minMember: minMember_el.value,
            maxMember: maxMember_el.value,
            theme: theme_el.value,
            amount: amount_el.value,
            depDate: depDate_el.value,
            deadline: deadline_el.value,
            groupDesc: groupDesc_el.value,
            notice: notice_el.value,
            cover: cover,
            // memId: memId,
            // schId: schId,
            // members: members,
            // startDate: startDate,
            // groupSta: groupSta,
            // paymentSta: paymentSta
        }
        // if(today.toLocaleDateString() < depDate_el.value && depDate_el.value > deadline_el.value && today.toLocaleDateString() < depDate_el.value){
        // console.log(send_data);
            await fetch('http://localhost:8080/u-and-me/myGroup/update/' + groupId, {
                headers: {
                    "content-type": "application/json",
                },
                method: 'PUT',
                body: JSON.stringify(send_data)
            }).catch(function(e){
                alert(更新失敗);
                return;
            });
            alert('更新成功');
        // } else {
        //     alert('更新失敗');
        // }
    });
});


//===================送出更新結束===================


//===================取得原揪團資料方法===================
async function fetchMyGroup(groupId) {

    // 取得修改資料
    await fetch('http://localhost:8080/u-and-me/myGroup/update/' + groupId, {
        method: 'GET',

        //取得所有資料
        // await fetch('http://localhost:8080/u-and-me/group/' + groupId, {
        //     method: 'GET',

    }).then(response => {
        return response.json();
    }).then(group => {

        cover = group.cover;
        // memId = group.memId;
        // schId = group.schId;
        // members = group.members;
        // startDate = group.startDate;
        // groupSta = group.groupSta;
        // paymentSta = group.paymentSta;

        //由於後端傳進來的圖片是base64資料，基於base64，須將base64定義成image/png檔，然後變成一個網址data:
        let dataurl = `data:image/png;base64,${group.cover}`
        cover_img_el.src = dataurl;


        minMember_el.value = `${group.min_Member}`;
        maxMember_el.value = `${group.max_Member}`;
        theme_el.value = `${group.theme}`;
        amount_el.value = `${group.amount}`;
        depDate_el.value = `${group.dep_Date}`;
        deadline_el.value = `${group.deadline}`;
        groupDesc_el.value = `${group.group_Desc}`;
        notice_el.value = `${group.notice}`;
        cover_img_el.src = dataurl;
    });

}
//===================取得原揪團資料結束===================
