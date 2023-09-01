let search_btn_el = document.getElementById("search-btn");
let keywords_el = document.getElementById("keywords");
let sortByStart_el = document.getElementById("sortByStart");
let sortByDays_el = document.getElementById("sortByDays");
let btn_schDone = document.getElementById("schDone");

let pageSelect1_el = document.getElementById("pageSelect1");
let pageSelect2_el = document.getElementById("pageSelect2");
let pageSelect3_el = document.getElementById("pageSelect3");



// const inputMemId_el = document.getElementById("inputMemId");
const inputStartDate_el = document.getElementById("inputStartDate");
const schNameInput_el = document.getElementById("schNameInput");
const startDate_el = document.getElementById("startDate");
const endDate_el = document.getElementById("endDate");
const destination_el = document.getElementById("destination");
const schName_el = document.getElementById("schName");


let e = 0; //用來控制分頁
let memId = 1; // 會員Id從哪裡抓取？

// fetch對應到的路徑
let baseURL = window.location.protocol + "//" + window.location.host + "/u-and-me/mySch/";
let myURL = baseURL + "my/";
let addURL = baseURL + "create";
let deleteURL = baseURL + "delete/";
let editURL = baseURL + "edit/";
let hideURL = baseURL + "hide/";


// 載入網頁就將所有該會員的行程列表查出
document.addEventListener("DOMContentLoaded", function () {
  fetchMyScheduleList(myURL, memId, e);
});

async function fetchMyScheduleList(URL, memId, e) {
  try {
    const response = await fetch(URL + memId + "/" + e);
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
                <div class="settingSch">
                A
                </div>
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
    console.error("Error fetching MyScheduleList:", error);
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

// =============== 待改，依關鍵字(行程名稱)搜尋行程清單 ===============
search_btn_el.addEventListener("click", function (event) {
  event.preventDefault();
  let keywords = keywords_el.value;
  let keywordsURL = baseURL + keywords + "/";
  fetchMyScheduleList(keywordsURL, e);
});

// =============== 待改，依行程天數排序行程清單 ===============
sortByDays_el.addEventListener("click", function (event) {
  event.preventDefault();
  fetchMyScheduleList(daysURL, e);
});

// 按修改鈕會根據schRepId跳轉到詳細內容頁面，並將資料映射到相關欄位上
function redirectToDetailPage(schId) {
  var newPageUrl = `scheduleEdit.html/schId/${schId}`;
  window.location.href = newPageUrl;
}

//=============== 以下為控制分頁(目前寫死) =================

pageSelect1_el.addEventListener('click', async function (e) {

  //增加actice 使分頁亮起來
  pageSelect1_el.classList.toggle("active");
  //刪除actice 使分頁暗下去
  pageSelect2_el.classList.remove("active");
  pageSelect3_el.classList.remove("active");

  //控制fetch傳入網址
  e = 0
  //調用方法
  fetchMyScheduleList(myURL, memId, e);
});

pageSelect2_el.addEventListener('click', async function (e) {
  pageSelect1_el.classList.remove("active");
  pageSelect2_el.classList.toggle("active");
  pageSelect3_el.classList.remove("active");

  e = 1;
  fetchMyScheduleList(myURL, memId, e);
});

document.getElementById('pageSelect3').addEventListener('click', async function (e) {
  pageSelect1_el.classList.remove("active");
  pageSelect2_el.classList.remove("active");
  pageSelect3_el.classList.toggle("active");

  e = 2;
  fetchMyScheduleList(myURL, memId, e);
});

//=============== 控制分頁結束 ===============


// =============== 新增一個行程大綱 ===============

// 當新增行程燈箱內容填寫完畢，按下完成按鈕後，
// 將行程大綱資料傳輸進資料庫，並回到會員自己的行程頁面
btn_schDone.onclick = async event => {

  event.preventDefault();

  // TODO...待加資料驗證，驗證通過後才執行以下內容
  const send_data = {
    schName: schName_el.value,
    memId: memId,
    schStart: startDate_el.value,
    schEnd: endDate_el.value,
    schCopy: true,
    schPub: 0,
    schTags: destination_el.value
  }
  console.log(send_data);
  await fetch(addURL, {
    headers: {
      "content-type": "application/json",
    },
    method: 'POST',
    body: JSON.stringify(send_data)
  })
    .catch(function (error) {
      alert('新增失敗');
      return;
    });
  alert('新增成功');
  location.reload();
}

// =============== 新增一個行程大綱結束 ===============