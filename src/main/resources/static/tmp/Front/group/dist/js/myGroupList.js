let count = 0;

const regFormList_el = document.getElementById("regFormList");

// 網頁載入後執行
document.addEventListener("DOMContentLoaded", function () {
    fetchMyGroupList();
});

async function fetchMyGroupList() {
    try {
        //此fetch url 的1為memId 應該要直接讀取當前使用者的memId 尚未研究
        const response = await fetch('http://localhost:8080/u-and-me/myGroupList/1/0');
        const myGroupList = await response.json();

        const myGroupList_el = document.getElementById("myGroupList");

        myGroupList_el.innerHTML = "";

        myGroupList.forEach(group => {
            let group_Sta = "";
            count++;

            switch (group.group_Sta) {
                case 0:
                    group_Sta = "揪團中";
                    break;
                case 1:
                    group_Sta = "揪團成功";
                    break;
                case 2:
                    group_Sta = "揪團取消";
                    break;
                case 3:
                    group_Sta = "揪團延期";
                    break;
                case 4:
                    group_Sta = "揪團被下架";
                    break;
            }
            const row = document.createElement("tr");
            row.innerHTML = `
                <td style="text-align: center;vertical-align: middle; width: 60px" id="id${count}">${group.group_Id}</td>
                <td style="text-align: center;vertical-align: middle; width: 150px">${group.theme}</td>
                <td style="text-align: center;vertical-align: middle; width: 60px"><a href="#">行程</a></td>
                <td style="text-align: center;vertical-align: middle; width: 60px"><a href="#">資料</a></td>
                <td style="text-align: center;vertical-align: middle; width: 75px""><button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#regForm${group.group_Id}" id="regForm_btn${count}">
                點此</button></td>
                <td style="text-align: center;vertical-align: middle; width: 90px">${group_Sta}</td>
                <td>
                    <button class="btn btn-outline-success  width: 70px" onclick="window.location.href='http://localhost:8080/u-and-me/tmp/Front/group/myGroupListUpdate.html?gorupId=${group.group_Id}'" type="button">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                        </svg>
                    </button>
                </td>
                <td>
                <button class="btn btn-outline-success id="delete" width: 70px" onclick="deleteGroup(${group.group_Id})" type="button">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
              </svg>
            </button>
               </td>
            `;
            myGroupList_el.appendChild(row);


            regFormList_el.innerHTML +=
                `
        <div class="modal fade" id="regForm${group.group_Id}" tabindex="-1" aria-labelledby="regFormTitle${count}" 
    aria-hidden="true">
    <div class="modal-dialog modal-xl modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title" id="regFormTitle${count}">報名表資料</h3>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                    aria-label="Close"></button>
            </div>
            <div class="modal-body" >
            <p id="regFormContent${count}">
            <pre>會員編號: xxx  |   電子信箱: xxx@xxx.com  | 電話號碼: xxxxxx |  參加人數:xxxx | 報名時間:xxx
            </pre>
            <button class="btn btn-primary" type="button" data-bs-toggle="collapse"
                data-bs-target="#memberDetail_btn${count}" aria-expanded="false"
                aria-controls="memberDetail_btn${count}" style="float: right;">
                顯示資料
            </button>
            </p>
            <div class="collapse" id="memberDetail_btn${count}">
                <div class="card card-body" id="memberDetailContent${count}">
                    <pre>
                    姓名 | 身分證字號 | 出生日期 | 性別 (表格名)
                    XXX  | XXXXXXX   | XXXXXXXX| X</pre>
                </div>
            </div>
            <hr>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
`;
        });

    } catch (error) {
        console.error("Error fetching GroupList:", error);
    }
}


function formatDate(dateString) {
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    return new Date(dateString).toLocaleDateString('zh-TW', options);
}

async function deleteGroup(groupId) {

    //利用try catch 跳脫foreach循環
    try {
        let r = confirm('確定刪除？');

        if (r) {
            await fetch('http://localhost:8080/u-and-me/group/' + groupId, {
                method: 'DELETE'
            });
            window.location.reload();
            throw new Error();
        } else {
            throw new Error();
        }

    } catch (e) {
        window.location.reload();
    }
}



let regForm_btn_el = document.getElementById("regForm_btn" + count);