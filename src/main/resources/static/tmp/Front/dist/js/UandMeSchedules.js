    let e = 0; //用來控制分頁
    
    // 載入網頁就將所有公開行程列表查出
      document.addEventListener("DOMContentLoaded", function () {
        fetchScheduleList(e);
      });

      async function fetchScheduleList(e) {
        try {
          const response = await fetch('http://localhost:8080/u-and-me/schedules/all/0');
          const schList = await response.json();

          const dataTableList = document.getElementById("dataTableList");
          dataTableList.innerHTML = "";

          schList.forEach(schedule => {

            let row = document.createElement("div");

            row.classList.add("col-lg-4");
            row.classList.add("mb-4");

            row.innerHTML = `
            <div class="card">
            <img src="https://images.unsplash.com/photo-1477862096227-3a1bb3b08330?ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60"
                alt="" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">${schedule.schName}</h5>
                    <p class="sch-date" style="font-size: 15px">
                    ${formatDate(schedule.schStart)} ~ ${formatDate(schedule.schEnd)}</p>
                    <p class="sch-date" style="font-size: 10px">行程共？天</p>
                    <a href="#" class="btn btn-outline-success btn-sm">查看詳情</a>
                </div>
              </div>
            </div>
            `;
            dataTableList.appendChild(row);
          });

        } catch (error) {
          console.error("Error fetching scheRep list:", error);
        }
      }


      function formatDate(dateString) {
      const options = { year: 'numeric', month: 'long', day: 'numeric' };
      return new Date(dateString).toLocaleDateString('zh-TW', options);
      }

      const statusMapping = new Map([
        [0, '審核中'],
        [1, '已處理'],
        [2, '已撤銷'],
      ]);

      // <!--按修改鈕會根據schRepId跳轉到詳細內容頁面，並將資料映射到相關欄位上-->
      function redirectToDetailPage(schId) {
        var newPageUrl = `scheduleEdit.html/schId/${schId}`;
        window.location.href = newPageUrl;
      }






// //=============== fetch揪團列表 =================

// let e = 0; //用來控制分頁
// // 網頁載入後執行
// document.addEventListener("DOMContentLoaded", function () {

//     fetchGroupList(e);
// });

// //async : async function 宣告一個非同步函式，可以告訴function在最後回傳一個promise。
// async function fetchGroupList(e) {
//     try {
//         // await : await必須放在任何基於promise的函數之前，等到獲得resolve的資料後，再執行後續動作
//         const response = await fetch('http://localhost:8080/u-and-me/groupsList/0/' + e);

//         //response.json()：把資料轉成JSON格式
//         const groupsList = await response.json();

//         //把資料清空
//         const groupListInner_el = document.getElementById("groupListInner");
//         groupListInner_el.innerHTML = "";


//         groupsList.forEach(group => {

//             //生成一個'div'
//             let schedules = document.createElement('div');
//             //賦予div class 'col-4'
//             schedules.classList.add('col-lg-4 mb-4');

//             let f = 0;
//             let cover_id = 'cover' + f
//             let title_id = 'title' + f
//             let member_id = 'member' + f
//             let day_id = 'day' + f
//             let price_id = 'price' + f

//             //由於後端傳進來的圖片是base64資料基於base64，須將base64轉換成image/png檔
//             //暫時換成圖片網址連結
//             let dataurl = `https://images.unsplash.com/photo-1477862096227-3a1bb3b08330?ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60`

//             //控制member顯示模式
//             let member = parseInt(`${group.m}`, 10); //轉換JSON為INT
//             if (member > 0) {
//                 member = `剩餘 <span style="color: red;"> ${group.m} </span> 人成團`;
//             } else {
//                 member = `<span style="color: red;">已達出團人數但仍可報名</span>`
//             }

//             groups.innerHTML =
//                 `
//                     <div class="card h-100">
//                         <!-- Product image-->
//                         <img class="card-img-top" src="${dataurl}"
//                         id="${cover_id}" alt="..." />
//                         <!-- Product details-->
//                         <div class="card-body p-4">
//                             <div class="text-center">
//                             <!-- Product name-->
//                             <h3 class="fw-bolder" id="${title_id}">${group.theme}</h3>
//                             <br>
//                             <!-- 尚缺人數成團-->
//                             <span id="${member_id}">${member}</span>
//                             <br>
//                             <!-- 剩餘天數-->
//                             揪團剩餘天數：<span id="${day_id}">${group.d}</span> 天
//                             <br>
//                             <!-- Product price-->
//                             價格：<span style="color: blue;" id="${price_id}">${group.amount}</span> 元
//                         </div>
//                         </div>
//                             <!-- Product actions-->
//                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
//                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">揪團詳情</a>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                 `;

//             //新增資料
//             groupListInner_el.appendChild(groups);

//             //f為控制每個列表id 若有需要可以用
//             f += 1;
//         });


//     } catch (error) {
//         console.error("Error fetching groupList:", error);
//     }
// }

// // =============== fetch揪團列表結束 =================
