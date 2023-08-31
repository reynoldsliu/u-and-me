/* global bootstrap: false */
(function () {
  'use strict'
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  tooltipTriggerList.forEach(function (tooltipTriggerEl) {
    new bootstrap.Tooltip(tooltipTriggerEl)

    var dropdownToggleList = [].slice.call(document.querySelectorAll('[data-bs-toggle="dropdown"]'))
    dropdownToggleList.map(function (dropdownToggle) {
      return new bootstrap.Dropdown(dropdownToggle)
    });
    



  })
})()

<!--開始!!!!Katie my hero!!!!!!!!!-->
        <!--網頁載入後執行-->
           document.addEventListener("DOMContentLoaded", function () {
                     fetchMemberList();
                 });

                 async function fetchMemberList(e) {
                     try {
                         const response = await fetch('http://localhost:8081/u-and-me/host/member/all/'+e);
                         const memberList = await response.json();

                         const dataTableList = document.getElementById("dataTableList");
                         dataTableList.innerHTML = "";

                         memberList.forEach(members => {
                             const row = document.createElement("tr");
                             row.innerHTML = `
                                 <td style="width: 100px;text-align: center;vertical-align: middle;">${members.memId}</td>
                                 <td style="width: 100px;text-align: center;vertical-align: middle;">${members.memName}</td>
                                 <td style="width: 100px;text-align: center;vertical-align: middle;">${members.memEmail}</td>
                                 <td style="width: 100px;text-align: center;vertical-align: middle;">${members.memAddr}</td>
                                 <td style="width: 100px;text-align: center;vertical-align: middle;">${members.memPhone}</td>
                                 <td style="width: 100px;text-align: center;vertical-align: middle;">${members.memPoint}</td>
                                 <td style="width: 100px;text-align: center;vertical-align: middle;">${memStaMapping.get(members.memSta)}</td>
                                 <td style="width: 100px;text-align: center;vertical-align: middle;">${groupStaMapping.get(members.memGroup)}</td>

                                 <td>
                                  <button class="btn btn-outline-success" onclick="redirectToDetailPage(${members.memId})">
                                   <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                                   <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                                   </svg>
                                   </button>
                                 </td>
                             `;
                             dataTableList.appendChild(row);
                         });

                     } catch (error) {
                         console.error("Error fetching members list:", error);
                     }
                 }




                 const memStaMapping = new Map([
                     [0, '未驗證'],
                     [1, '正常'],
                     [2, '停權'],
                 ]);
                  const groupStaMapping = new Map([
                                      [0, '非團主'],
                                      [1, '團主'],

                                  ]);

 <!--按修改鈕會根據memId跳轉到詳細內容頁面，並將資料映射到相關欄位上-->
        function redirectToDetailPage(memId) {
              var newPageUrl = `membersEdit.html?memId=${memId}`;
              window.location.href = newPageUrl;
        }

//=============== 以下為控制分頁 =================

document.getElementById('pageSelect1').addEventListener('click', async function () {

    //增加actice 使分頁亮起來
    document.getElementById('pageSelect1').classList.toggle("active");

    //刪除actice 使分頁暗下去
    document.getElementById('pageSelect2').classList.remove("active");

    //刪除actice 使分頁暗下去
    document.getElementById('pageSelect3').classList.remove("active");

    //控制fetch傳入網址
    let e = 0

    //調用方法
    fetchMemberList(e);
    console.log(e);
});

document.getElementById('pageSelect2').addEventListener('click', async function (e) {
    document.getElementById('pageSelect1').classList.remove("active");

    document.getElementById('pageSelect2').classList.toggle("active");

    document.getElementById('pageSelect3').classList.remove("active");

    e = 1;
    fetchMemberList(e);
    console.log(e);
});

document.getElementById('pageSelect3').addEventListener('click', async function (e) {
    document.getElementById('pageSelect1').classList.remove("active");

    document.getElementById('pageSelect2').classList.remove("active");

    document.getElementById('pageSelect3').classList.toggle("active");

    e = 2;
    fetchMemberList(e);
    console.log(e);
});

//=============== 控制分頁結束 =================