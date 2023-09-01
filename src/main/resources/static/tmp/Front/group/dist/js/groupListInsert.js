
//當頁面讀取後開始偵測function
window.addEventListener("load", function (e) {

    //==========需要用的元素=========
    const memId_el = document.getElementById("memId");
    const schId_el = document.getElementById("schId");
    const minMember_el = document.getElementById("minMember");
    const maxMember_el = document.getElementById('maxMember');
    const theme_el = document.getElementById('theme');
    const amount_el = document.getElementById('amount');
    const depDate_el = document.getElementById('depDate');
    const deadline_el = document.getElementById("deadline");
    const groupDesc_el = document.getElementById("groupDesc");
    const notice_el = document.getElementById("notice");
    const btn_submit_el = document.getElementById("btn_submit");

    const inputMemId_el = this.document.getElementById("inputMemId");
    const inputSchId_el = this.document.getElementById("inputSchId");
    const inputMinMember_el = this.document.getElementById("inputMinMember");
    const inputMaxMember_el = this.document.getElementById("inputMaxMember");
    const inputTheme_el = this.document.getElementById("inputTheme");
    const inputAmount_el = this.document.getElementById("inputAmount");
    const inputDepDate_el = this.document.getElementById("inputDepDate");
    const inputDeadline_el = this.document.getElementById("inputDeadline");
    const inputGroupDesc_el = this.document.getElementById("inputGroupDesc");
    const inputNotice_el = this.document.getElementById("inputNotice");
    const inputFormFile_el = this.document.getElementById("inputFormFile");
    //==========需要用的元素結束=========



    //==========判斷錯誤需要用的=========
    let today = new Date().getTime();//實體化當前時間變數 getTime()轉成毫秒

    // let isInteger = n => (Number(n) === n); //判斷是否為整數

    //錯誤判斷新增的字串
    let memIdStr = document.createElement("span");
    memIdStr.style.color = 'red';

    let schIdStr = document.createElement("span");
    schIdStr.style.color = 'red';

    let minMemberStr = document.createElement("span");
    minMemberStr.style.color = 'red';

    let maxMemberStr = document.createElement("span");
    maxMemberStr.style.color = 'red';

    let themeStr = document.createElement("span");
    themeStr.style.color = 'red';

    let depDateStr = document.createElement("span");
    depDateStr.style.color = 'red';

    let deadlineStr = document.createElement("span");
    deadlineStr.style.color = 'red';

    let groupDescStr = document.createElement("span");
    groupDescStr.style.color = 'red';

    let amountStr = document.createElement("span");
    amountStr.style.color = 'red';

    let noticeStr = document.createElement("span");
    noticeStr.style.color = 'red';

    let coverStr = document.createElement("span");
    coverStr.style.color = 'red';

    //==========判斷錯誤需要用的 結束=========


    //圖片傳送後端流程12345
    //1. 取得File物件
    const cover_el = document.getElementById("cover");


    //=======預覽圖=======
    cover_el.addEventListener('change', changeListener);
    function changeListener() {
        const id = this.id;
        const files = this.files;
        const img = document.getElementById("cover_img");
        const file = files[0];
        if (!file) {
            img.src = "";
            return;
        }
        img.src = URL.createObjectURL(file);
    }
    //=======預覽圖結束=======

    //當按下送出後
    btn_submit_el.addEventListener("click", function (e) {
        e.preventDefault();
        let control = true; //控制是否進入fetch

        //==================錯誤驗證==================
        //初始化Str
        memIdStr.innerHTML = "";
        schIdStr.innerHTML = '';
        minMemberStr.innerHTML = '';
        maxMemberStr.innerHTML = '';
        themeStr.innerHTML = '';
        amountStr.innerHTML = '';
        depDateStr.innerHTML = '';
        deadlineStr.innerHTML = '';
        groupDescStr.innerHTML = '';
        noticeStr.innerHTML = '';
        coverStr.innerHTML = '';

        //會員編號
        if (memId_el.value === null || memId_el.value === "") {
            control = false;
            memIdStr.innerHTML = ' *會員編號必須填入數值';
            inputMemId_el.appendChild(memIdStr);
        }

        //行程編號
        if (schId_el.value === null || memId_el.value === "") {
            control = false;
            schIdStr.innerHTML = ' *行程編號必須填入數值';
            inputSchId_el.appendChild(schIdStr);
        }

        //最小人數
        if (minMember_el.value === null || minMember_el.value === "") {
            control = false;
            minMemberStr.innerHTML = ' *最小人數必須填入數值';
            inputMinMember_el.appendChild(minMemberStr);
        } else if (!(Number.isInteger(Number(minMember_el.value))) || Number(minMember_el.value) < 0) {
            control = false;
            minMemberStr.innerHTML = ' *最小人數必須為正整數';
            inputMinMember_el.appendChild(minMemberStr);
        } else if ((Number.isInteger(Number(maxMember_el.value))) && Number(maxMember_el.value) > 0) {
            if (Number(minMember_el.value) > Number(maxMember_el.value)) {
                control = false;
                console.log(minMember_el.value);
                minMemberStr.innerHTML = ' *最小人數不能大於最大人數';
                inputMinMember_el.appendChild(minMemberStr);
            }
        }

        //最大人數
        if (maxMember_el.value === null || maxMember_el.value === "") {
            control = false;
            maxMemberStr.innerHTML = ' *最大人數必須填入數值';
            inputMaxMember_el.appendChild(maxMemberStr);
        } else if (!(Number.isInteger(Number(maxMember_el.value))) || Number(maxMember_el.value) < 0) {
            control = false;
            maxMemberStr.innerHTML = ' *最大人數必須為正整數';
            inputMaxMember_el.appendChild(maxMemberStr);
        } else if ((Number.isInteger(Number(minMember_el.value))) && Number(minMember_el.value) > 0) {
            if (Number(maxMember_el.value) < Number(minMember_el.value)) {
                control = false;
                console.log(maxMember_el.value);
                maxMemberStr.innerHTML = ' *最大人數不能小於最小人數';
                inputMaxMember_el.appendChild(maxMemberStr);
            }
        }
        //標題
        if (theme_el.value === null || theme_el.value === "") {
            // alert('標題不可為空值');
            control = false;
            themeStr.innerHTML = ' *標題必須填入數值';
            inputTheme_el.appendChild(themeStr);
        }

        //價格
        if (amount_el.value === null || amount_el.value === "") {
            control = false;
            amountStr.innerHTML = ' *價格必須填入數值';
            inputAmount_el.appendChild(amountStr);
        } else if (amount_el.value < 0 || !(Number.isInteger(Number(amount_el.value)))) {
            console.log(amount_el.value);
            control = false;
            amountStr.innerHTML = ' *價格必須為正整數';
            inputAmount_el.appendChild(amountStr);
        }

        //出發日期
        if (depDate_el.value === null || depDate_el.value === "") {
            control = false;
            depDateStr.innerHTML = ' *行程出發日期必須填入數值';
            inputDepDate_el.appendChild(depDateStr);
        } else if (today > depDate_el.valueAsNumber) {
            control = false;
            depDateStr.innerHTML = ' *行程出發日期不得小於當前日期';
            inputDepDate_el.appendChild(depDateStr);
        } else if (depDate_el.value < deadline_el.value) {
            control = false;
            depDateStr.innerHTML = ' *行程出發日期不得小於截止日期';
            inputDepDate_el.appendChild(depDateStr);
        }

        //截止日期
        if (deadline_el.value === null || deadline_el.value === "") {
            control = false;
            deadlineStr.innerHTML = ' *揪團截止日期必須填入數值';
            inputDeadline_el.appendChild(deadlineStr);
        } else if (today > deadline_el.valueAsNumber) {
            control = false;
            deadlineStr.innerHTML = ' *揪團截止日期不得小於當前日期';
            inputDeadline_el.appendChild(deadlineStr);
        } else if (deadline_el.value > depDate_el.value) {
            control = false;
            deadlineStr.innerHTML = ' *揪團截止日期不得大於出發日期';
            inputDeadline_el.appendChild(deadlineStr);
        }

        //揪團描述
        if (groupDesc_el.value === null || groupDesc_el.value === "") {
            control = false;
            groupDescStr.innerHTML = ' *揪團描述必須填入數值';
            inputGroupDesc_el.appendChild(groupDescStr);
        }

        //行前通知
        if (notice_el.value === null || notice_el.value === "") {
            control = false;
            noticeStr.innerHTML = ' *行前通知必須填入數值';
            inputNotice_el.appendChild(noticeStr);
        }

        //照片
        if (cover_el.value == "") {
            control = false;
            coverStr.innerHTML = ' *必須選擇照片';
            inputFormFile_el.appendChild(coverStr);
        }

        //==================錯誤驗證結束==================

        const cover = cover_el.files[0];

        //2. 實例化FileReader物件
        const fileReader = new FileReader();

        if (control) {
            //3. 替FileReader物件 註冊 載入監聽器
            fileReader.onload = async event => {
                //4. 轉成Base64字串
                const base64Str = btoa(event.target.result);

                //將資料包裝成一個物件
                const send_data = {
                    memId: memId_el.value,
                    schId: schId_el.value,
                    minMember: minMember_el.value,
                    maxMember: maxMember_el.value,
                    theme: theme_el.value,
                    amount: amount_el.value,
                    depDate: depDate_el.value,
                    deadline: deadline_el.value,
                    groupDesc: groupDesc_el.value,
                    notice: notice_el.value,
                    cover: base64Str
                }
                // console.log(send_data);
                await fetch('http://localhost:8080/u-and-me/group', {
                    headers: {
                        "content-type": "application/json",
                    },
                    method: 'POST',
                    body: JSON.stringify(send_data)
                }).catch(function (error) {
                    alert('新增失敗 請檢察填寫資料');
                    return;
                });
                alert('新增成功');
                location.reload();
            };
            try {
                //5. 開始讀取檔案
                fileReader.readAsBinaryString(cover);
            } catch (e) {
                alert('新增失敗 請檢察填寫資料');
            }
        } else {
            alert('新增失敗 請檢察填寫資料');
        }

    });


});
