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
            const row = document.createElement("tr");
            row.innerHTML = `
                <td style="text-align: center;vertical-align: middle; width: 75px">${group.group_Id}</td>
                <td style="text-align: center;vertical-align: middle; width: 150px">${group.theme}</td>
                <td style="text-align: center;vertical-align: middle; width: 75px">${group.sch_Id}</td>
                <td style="text-align: center;vertical-align: middle; width: 75px"><a href="#">資料</a></td>
                <td style="text-align: center;vertical-align: middle; width: 100px""><a href="#">點此</a></td>
                <td style="text-align: center;vertical-align: middle; width: 75px">${group.group_Sta}</td>
                <td>
                    <button class="btn btn-outline-success  width: 75px" onclick="window.location.href='http://127.0.0.1:5501/tmp/Front/myGroupListUpdate.html'" type="button">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                        </svg>
                    </button>
                </td>
                <td>
                <button class="btn btn-outline-success id="delete" width: 75px" onclick="deleteGroup()" type="button">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
              </svg>
            </button>
               </td>
            `;
            myGroupList_el.appendChild(row);

        });

    } catch (error) {
        console.error("Error fetching GroupList:", error);
    }
}


function formatDate(dateString) {
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    return new Date(dateString).toLocaleDateString('zh-TW', options);
}

async function deleteGroup() {
    const response = await fetch('http://localhost:8080/u-and-me/myGroupList/1/0');
    const myGroupList = await response.json();
    const myGroupList_el = document.getElementById("myGroupList");
    myGroupList.forEach(group => {
        let r = confirm('確定刪除？');
        if (r) {
            fetch(`http://localhost:8080/u-and-me/group/${group.group_Id}`, {
                method: 'DELETE'
            });
            window.location.reload();
        }
    });
}

// // <!--按修改鈕會根據activityId跳轉到詳細內容頁面，並將資料映射到相關欄位上-->
// function redirectToDetailPage(activityId) {
//     var newPageUrl = `activityEdit.html?activId=${group_Id}`;
//     window.location.href = newPageUrl;
// }

//新增的按鈕
{/* <button class="btn btn-outline-success  width: 75px" onclick="redirectToDetailPage(${group.group_Id})">
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
<path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
</svg>
</button> */}