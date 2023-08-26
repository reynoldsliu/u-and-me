
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


    


    //圖片傳送流程12345
    //1. 從<input>取得File物件
    const cover_el = document.getElementById("cover");


    //=======預覽圖=======
    cover_el.addEventListener('change', changeListener);
    function changeListener () {
        const id = this.id;
        const files = this.files;
        const img = document.getElementById("cover_img");
        const file = files[0];
        if(!file){
            img.src = "";
            return;
        }
        img.src = URL.createObjectURL(file);
    }
    //=======預覽圖結束=======

    //當按下送出後
    btn_submit_el.addEventListener("click", function (e) {
        e.preventDefault();

        const cover = cover_el.files[0];

        //2. 實例化FileReader物件
        const fileReader = new FileReader();

        
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
            });
        };
        //5. 開始讀取檔案
        fileReader.readAsBinaryString(cover);
    });

    
});



// =================日歷用js===================

// =================日歷用js===================