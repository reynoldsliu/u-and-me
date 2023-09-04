//==========使用到的元素==========
const join_members_el = document.getElementById("join_members");
const selectMember_el = document.getElementById("selectMember");
const plus_el = document.getElementById("plus");
const minus_el = document.getElementById("minus");
const order_confirmed_el = document.getElementById("order_confirmed");
const email_el = document.getElementById("email");
const phone_el = document.getElementById("phone");
const emailtext_el = document.getElementById("emailtext");
const phonetext_el = document.getElementById("phonetext");

//驗證錯誤
let emailReg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
let emailStr = document.createElement("span");
emailStr.style.color = 'red';

let phoneReg = /09\d{8}/;
let phoneStr = document.createElement("span");
phoneStr.style.color = 'red';

let idnumberReg = /^[A-Z]{1}[1-2]{1}[0-9]{8}$/;

//==========全局變數==========
let groupId;//紀錄groupId
let maxMember;//紀錄能參與揪團的人數
let member = 1;//紀錄參團人數
let formId;

window.addEventListener("load", function (e) {

    //===================取得網址頁上傳遞的參數===================

    //先取得網址字串
    let url = location.href;

    //再來用去尋找網址列中是否有資料傳遞(QueryString)(有?則代表有資料傳遞)
    if (url.indexOf('?') != -1) {

        //之後去分割字串把分割後的字串放進陣列中
        let ary1 = url.split('?');
        //此時ary1裡的內容為：
        //ary1[0] = 'http://localhost:8081/u-and-me/tmp/Front/group/myGroupListUpdate.html?gorupId=1'，ary2[1] = 'groupId=1'

        //以下為若傳遞參數為兩個做法 如果為一個可省略
        let ary2 = ary1[1].split('=');
        //參數分別為 arr2[0],arr2[1]

        //取得傳遞的Id值
        groupId = ary2[1];

        // maxMember = Number(arr4[1]);
    }
    //===================取得網址頁上傳遞的參數結束===================

    // 取得插入的formId
    // 後面/1為memId
    fetch('http://localhost:8080/u-and-me/regForm/findFromId', {
        method: 'GET',
    }).then(response => {
        return response.json();
    }).then(regform => {
        formId = Number(regform.formId) + 1;
    });

    fetch('http://localhost:8080/u-and-me/group/findMember/' + groupId, {
        method: 'GET',
    }).then(response => {
        return response.json();
    }).then(group => {
        maxMember = Number(group.member)
    });
});

//控制按鈕＋被點擊後數值
plus_el.addEventListener('click', function (e) {
    e.preventDefault();
    if (member < maxMember) {
        member++;
    }
    selectMember_el.value = member;

    addMemberDetail(member);
});

//控制按鈕－被點擊後數值
minus_el.addEventListener('click', function (e) {
    e.preventDefault();
    if (member > 1) {
        member--;
    }
    selectMember_el.value = member;

    addMemberDetail(member);
});

//點擊確認送出後新增資料
order_confirmed_el.addEventListener('click', function (e) {

    //驗證時間
    let today = new Date().getTime();//用於驗證、取得目前時間

    //控制是否新增資料
    let control = true;

    //初始化錯誤驗證資料
    emailStr.innerHTML = '';
    phoneStr.innerHTML = '';

    if(maxMember === 0){
        alert('該揪團已結束報名');
        location.href='http://localhost:8080/u-and-me/tmp/Front/group/groupMemo.html?groupId=' + groupId;
    }

    if (email_el.value === null || email_el.value.trim() === "") {
        control = false;
        emailStr.innerHTML = ' *email不可以為空值';
        emailtext_el.appendChild(emailStr);
    } else if (!(emailReg.test(email_el.value))) {
        control = false;
        emailStr.innerHTML = ' *email格式不正確';
        emailtext_el.appendChild(emailStr);
    }

    if (phone_el.value === null || phone_el.value.trim() === "") {
        control = false;
        phoneStr.innerHTML = ' *電話不可以為空值';
        phonetext_el.appendChild(phoneStr);
    } else if (!(phoneReg.test(phone_el.value))) {
        control = false;
        phoneStr.innerHTML = ' *電話格式不正確';
        phonetext_el.appendChild(phoneStr);
    }

    for (let i = 1; i <= Number(selectMember_el.value); i++) {

        //子標題的el
        let nametext_el = document.getElementById("nametext" + i);
        let idnumbertext_el = document.getElementById("idnumbertext" + i);
        let birthdaytext_el = document.getElementById("birthdaytext" + i);

        //讀取數值的el
        let name_el = document.getElementById("name" + i);
        let idnumber_el = document.getElementById("idnumber" + i);
        let birthday_el = document.getElementById("birthday" + i);

        //錯誤提示
        let idnumberStr = document.createElement("span");
        idnumberStr.style.color = 'red';

        let nameStr = document.createElement("span");
        nameStr.style.color = 'red';

        let birthdayStr = document.createElement("span");
        birthdayStr.style.color = 'red';

        //重製錯誤提示
        nametext_el.innerHTML = '姓名';
        idnumbertext_el.innerHTML = '身分證字號';
        birthdaytext_el.innerHTML = '出生日期';
        

        //錯誤判斷
        if (name_el.value === null || name_el.value.trim() === "") {
            control = false;
            nameStr.innerHTML = ' *姓名不可為空值';
            nametext_el.appendChild(nameStr);
        }

        if (idnumber_el.value === null || idnumber_el.value.trim() === "") {
            control = false;
            idnumberStr.innerHTML = ' *身份證字號不可為空值';
            idnumbertext_el.appendChild(idnumberStr);
        } else if (!(idnumberReg.test(idnumber_el.value))) {
            control = false;
            idnumberStr.innerHTML = ' *身份證字號格式錯誤';
            idnumbertext_el.appendChild(idnumberStr);
        }

        if (birthday_el.value === null || birthday_el.value.trim() === "") {
            control = false;
            birthdayStr.innerHTML = ' *出生日期不可為空值';
            birthdaytext_el.appendChild(birthdayStr);
        } else if (today < birthday_el.valueAsNumber){
            control = false;
            birthdayStr.innerHTML = ' *出生日期輸入錯誤';
            birthdaytext_el.appendChild(birthdayStr);
        }
    }

    if (control) {
        const form_data = {
            formId: formId,
            groupId: groupId,
            memId: 1, //這個將判斷登入者id，尚未實作
            email: email_el.value,
            phone: phone_el.value,
            joinMember: selectMember_el.value
        }
        // console.log(send_data);
        //先插入上面form的資料
        fetch('http://localhost:8080/u-and-me/regForm', {
            headers: {
                "content-type": "application/json",
            },
            method: 'POST',
            body: JSON.stringify(form_data)
        }).catch(function (error) {
            alert('新增失敗 請檢察填寫資料');
            return;
        });


        for (let i = 1; i <= Number(selectMember_el.value); i++) {
            let name_el = document.getElementById("name" + i);
            let idnumber_el = document.getElementById("idnumber" + i);
            let gender_el = document.getElementById("gender" + i);
            let birthday_el = document.getElementById("birthday" + i);
            let data = {
                formId: formId,
                name: name_el.value,
                idnumber: idnumber_el.value,
                gender: gender_el.value,
                birthday: birthday_el.value
            }
            fetch('http://localhost:8080/u-and-me/memberDetail', {
                headers: {
                    "content-type": "application/json",
                },
                method: 'POST',
                body: JSON.stringify(data)
            }).catch(function (error) {
                alert('新增失敗 請檢察填寫資料');
            });
        }
        alert('新增成功');
        // location.reload();

        //跳轉至前頁
        location.href='http://localhost:8080/u-and-me/tmp/Front/group/groupMemo.html?groupId=' + groupId;
    } else {
        alert('新增失敗');
    }
});



//停止按鈕跳轉頁面
function disableform() { }

//動態新增參加者資料填寫欄位
function addMemberDetail(member) {
    join_members_el.innerHTML = ""; //每次偵測前都先清空
    for (let i = 1; i <= member; i++) {
        let regForms = document.createElement('div');
        regForms.classList.add("row", "mt-5");
        regForms.innerHTML =
            `<h4 id="proAmount">參團人${i}</h4>
        <div class="col-md-6">
            <label for="name${i}" class="col-form-label" id="nametext${i}">姓名</label>
            <input type="text" id="name${i}" class="form-control"
                aria-describedby="passwordHelpInline">
        </div>
        <div class="col-md-6">
            <label for="idnumber${i}" class="col-form-label" id="idnumbertext${i}">身分證字號</label>
            <input type="text" id="idnumber${i}" class="form-control"
                aria-describedby="passwordHelpInline">
        </div>
        <div class="col-md-6">
            <label for="gender${i}" class="col-form-label" id="gendertext${i}">性別</label>
            <select id="gender${i}" class="form-select">
                <option selected value="1">男</option>
                <option value="2">女</option>
            </select>
        </div>
        <div class="col-md-6">
            <label for="birthday${i}" class="col-form-label" id="birthdaytext${i}">出生日期</label>
            <input type="date" id="birthday${i}" class="form-control"
                aria-describedby="passwordHelpInline">
        </div>`

        join_members_el.appendChild(regForms);
    }
}