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

                 async function fetchMemberList() {
                     try {
                         const response = await fetch('http://localhost:8080/u-and-me/hostToMember/all');
                         const memberList = await response.json();

                         const dataTableList = document.getElementById("dataTableList");
                         dataTableList.innerHTML = "";

                         memberList.forEach(members => {
                             const row = document.createElement("tr");
                             row.innerHTML = `
                                 <td style="width: 100px;text-align: center; vertical-align: middle;">${members.memId}</td>
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

<!--       example member      -->
//       let members = [];
//
//       $(document).ready(function () {
//           guardIsSignedIn();
//           fetchMembers();
//       });
//
//       function fetchMembers() {
//           fetch('/member/Details/all)
//               .then(response => response.json())
//               .then(json => {
//                   members = json;
//                   renderTable(json);
//               });
//
//       }
//
//       function renderTable(members) {
//           $('#members').DataTable({
//               data: members,
//               columns: [
//                   {data: 'memId'},
//                   {data: 'memName'},
//                   {data: 'memEmail'},
//                   {data: 'memAddr'},
//                   {data: 'memPhone'},
//                   {data: 'memPoint'},
//                   {data: 'memSta'},
//                   {data: 'memGroup'},
//                   {
//                       data: 'access',
//                       render: function (data, type, row) {
//                           return getAccessElement(data, row);
//                       }
//                   },
//                   {
//                       data: 'isEmailVerified',
//                       render: function (data, type, row) {
//                           return getEmailVerifiedText(data);
//                       }
//                   }
//               ]
//           });
//       }
//
//       function getAccessElement(access, row) {
//           return `
//                   <select class="form-control access-select" onchange="changeAccess(this, ${row.id})">
//                       <option value="0" ${access === '0' ? 'selected' : ''}>${getAccessText('0')}</option>
//                       <option value="1" ${access === '1' ? 'selected' : ''}>${getAccessText('1')}</option>
//                   </select>
//               `;
//       }
//
//
//       function getEmailVerifiedText(isVerified) {
//           switch (isVerified) {
//               case true:
//                   return '✅已驗證';
//               case false:
//                   return '❌未驗證';
//           }
//       }
//
//
//       function changeAccess(input, memId) {
//           let access = input.value;
//
//           Swal.fire({
//               title: `確定要將會員ID: "${memId}" 之會員狀態變更為"${getAccessText(access)}"嗎？`,
//               icon: 'warning',
//               showCancelButton: true,
//               confirmButtonText: '確定',
//               cancelButtonText: '取消'
//           }).then((result) => {
//               if (result.isConfirmed) {
//                   updateAccess(memId, access);
//               } else {
//                   input.value = getRevertAccess(access);
//               }
//           })
//       }
//
//       function updateAccess(memId, access) {
//           const data = {
//               id: memberId,
//               access: access
//           }
//           fetch(`/members/change-access`, {
//               method: 'PUT',
//               headers: {
//                   'Content-Type': 'application/json'
//               },
//               body: JSON.stringify(data),
//           }).then(response => {
//               if (response.ok) {
//                   Swal.fire({
//                       title: '權限變更成功',
//                       icon: 'success',
//                       confirmButtonText: '確定'
//                   }).then(() => {
//                       location.reload();
//                   });
//               } else {
//                   Swal.fire({
//                       title: '權限變更失敗',
//                       icon: 'error',
//                       confirmButtonText: '確定'
//                   }).then(() => {
//                       location.reload();
//                   });
//               }
//           });
//       }
//
//       function getRevertAccess(access) {
//           switch (access) {
//               case '0':
//                   return '1';
//               case '1':
//                   return '0';
//           }
//       }
//
//       function getAccessText(access) {
//           switch (access) {
//               case '0':
//                   return '註冊未驗證';
//               case '1':
//                   return '正常';
//                case '2':
//                   return '停權';
//           }
//       }