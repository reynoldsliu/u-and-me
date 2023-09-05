let search_btn_el = document.getElementById("search-btn");
let keywords_el = document.getElementById("keywords");
let sortByStart_el = document.getElementById("sortByStart");
let sortByDays_el = document.getElementById("sortByDays");
// let sortByCost_el = document.getElementById("sortByCost");

let pageSelect1_el = document.getElementById("pageSelect1");
let pageSelect2_el = document.getElementById("pageSelect2");
let pageSelect3_el = document.getElementById("pageSelect3");


let e = 0; //用來控制分頁

// fetch對應到的路徑
let baseURL = window.location.protocol + "//" + window.location.host + "/u-and-me/schedules/";
let allURL = baseURL + "all/";
let daysURL = baseURL + "days/";


// 載入網頁就將所有公開行程列表查出
document.addEventListener("DOMContentLoaded", function () {
  fetchScheduleList(allURL, e);
});

async function fetchScheduleList(URL, e) {
  try {
    const response = await fetch(URL + e);
    const schList = await response.json();

    const schListInner = document.getElementById("schListInner");
    schListInner.innerHTML = "";

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
                    <p class="sch-date" style="font-size: 10px">
                    行程共${calDays(schedule.schStart, schedule.schEnd)}天</p>
                    <a href="myScheduleEdit.html" class="btn btn-outline-success btn-sm" id="viewDetails">查看詳情</a>
                </div>
              </div>
            </div>
            `;
      schListInner.appendChild(row);
    });

  } catch (error) {
    console.error("Error fetching scheRep list:", error);
  }
}


function formatDate(dateString) {
  const options = { year: 'numeric', month: 'long', day: 'numeric' };
  return new Date(dateString).toLocaleDateString('zh-TW', options);
}

function calDays(schStart, schEnd) {
  // 創建兩個日期對象
  var startDate = new Date(schStart);
  var endDate = new Date(schEnd);
  // 計算兩個日期之間的毫秒差距
  var timeDifference = endDate - startDate;
  // 將毫秒差距轉換為天數
  var daysDifference = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
  return (daysDifference + 1);
}

// =============== 依關鍵字(行程名稱)搜尋行程清單 ===============
search_btn_el.addEventListener("click", function (event) {
  event.preventDefault();
  let keywords = keywords_el.value;
  let keywordsURL = baseURL + keywords + "/";
  fetchScheduleList(keywordsURL, e);
});

// =============== 依行程天數排序行程清單 ===============
sortByDays_el.addEventListener("click", function (event) {
  event.preventDefault();
  fetchScheduleList(daysURL, e);
});


// 按修改鈕會根據schRepId跳轉到詳細內容頁面，並將資料映射到相關欄位上
function redirectToDetailPage(schId) {
  var newPageUrl = `scheduleEdit.html/schId/${schId}`;
  window.location.href = newPageUrl;
}

//=============== 以下為控制分頁 =================

pageSelect1_el.addEventListener('click', async function (e) {

  //增加actice 使分頁亮起來
  pageSelect1_el.classList.toggle("active");
  //刪除actice 使分頁暗下去
  pageSelect2_el.classList.remove("active");
  pageSelect3_el.classList.remove("active");

  //控制fetch傳入網址
  e = 0
  //調用方法
  fetchScheduleList(daysURL, e);
});

pageSelect2_el.addEventListener('click', async function (e) {
  pageSelect1_el.classList.remove("active");
  pageSelect2_el.classList.toggle("active");
  pageSelect3_el.classList.remove("active");

  e = 1;
  fetchScheduleList(daysURL, e);
});

document.getElementById('pageSelect3').addEventListener('click', async function (e) {
  pageSelect1_el.classList.remove("active");
  pageSelect2_el.classList.remove("active");
  pageSelect3_el.classList.toggle("active");

  e = 2;
  fetchScheduleList(daysURL, e);
});

//=============== 控制分頁結束 ===============