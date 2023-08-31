
//當頁面讀取後開始偵測function
window.addEventListener("load", function (e) {


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

    let today = new Date();//時間
    const isNumeric = n => !isNaN(n);//判斷數字

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

        if (memId_el.value === null || memId_el.value === "") {
            // alert('會員編號不可為空值');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==會員編號不可為空值'
            inputMemId_el.appendChild(str);
        }

        if (schId_el.value === null || memId_el.value === "") {
            // alert('行程編號不可為空值');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==行程編號不可為空值'
            inputSchId_el.appendChild(str);
        }

        if (minMember_el.value === null || minMember_el.value === "" || minMember_el.value < 0 || minMember_el.value > maxMember_el.value || isNaN(minMember_el.value)) {
            // alert('成團最小人數有誤');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==成團最小人數有誤'
            inputMinMember_el.appendChild(str);
        }

        if (maxMember_el.value === null || maxMember_el.value === "" || maxMember_el.value < minMember_el.value || isNumeric(maxMember_el.value)) {
            // alert('成團最大人數有誤');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==成團最大人數有誤'
            inputMaxMember_el.appendChild(str);
        }

        if (theme_el.value === null || theme_el.value === "") {
            // alert('標題不可為空值');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==標題不可為空值'
            inputTheme_el.appendChild(str);
        }

        if (amount_el.value === null || amount_el.value === "" || amount_el.value < 0 || isNumeric(amount_el.value)) {
            // alert('價格有誤');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==價格有誤'
            inputAmount_el.appendChild(str);
        }

        if (depDate_el.value === null || depDate_el.value === "" || today.toLocaleDateString() > depDate_el.value || depDate_el.value < deadline_el.value) {
            // alert('行程出發日期有誤');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==行程出發日期有誤'
            inputDepDate_el.appendChild(str);
        }

        if (deadline_el.value === null || deadline_el.value === "" || today.toLocaleDateString() > deadline_el.value || deadline_el.value > depDate_el.value) {
            // alert('揪團截止日期不可為空值');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==揪團截止日期不可為空值'
            inputDeadline_el.appendChild(str);
        }

        if (groupDesc_el.value === null || groupDesc_el.value === "") {
            // alert('揪團描述不可為空值');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==揪團描述不可為空值'
            inputGroupDesc_el.appendChild(str);
        }

        if (notice_el.value === null || notice_el.value === "") {
            // alert('行前通知不可為空值');
            let str = document.createElement("span");
            str.style.color = 'red';
            str.innerHTML = '==行前通知不可為空值'
            inputNotice_el.appendChild(str);
        }

        const cover = cover_el.files[0];

        //2. 實例化FileReader物件
        const fileReader = new FileReader();

        // if (today.toLocaleDateString() < depDate_el.value && depDate_el.value > deadline_el.value && today.toLocaleDateString() < depDate_el.value) {
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
                console.log(send_data);
                await fetch('http://localhost:8080/u-and-me/group', {
                    headers: {
                        "content-type": "application/json",
                    },
                    method: 'POST',
                    body: JSON.stringify(send_data)
                })
                .catch(function(error) {
                    alert('新增失敗');
                    return;
                });
                alert('新增成功');
                location.reload();
            };
            try {
                //5. 開始讀取檔案
                fileReader.readAsBinaryString(cover);
            } catch (e) {
                alert('新增失敗');
            }
        // } else{
        //     alert('更新失敗');
        // }
    });


});
