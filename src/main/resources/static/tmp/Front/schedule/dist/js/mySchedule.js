// class -off 屬性
const classSwitchOff = "-off";

// 行程搜尋欄相關的標籤
let search_btn_el = document.getElementById("search-btn");
let keywords_el = document.getElementById("keywords");
let sortByStart_el = document.getElementById("sortByStart");
let sortByDays_el = document.getElementById("sortByDays");

// 分頁元素
let pageSelect1_el = document.getElementById("pageSelect1");
let pageSelect2_el = document.getElementById("pageSelect2");
let pageSelect3_el = document.getElementById("pageSelect3");

// 行程增刪改標籤
const btn_schDone = document.getElementById("schDone");
// 編輯行程相關設定(會有多個，屆時動態生成，要重新取值)
const settingSch_el = document.querySelector(".settingSch");
const settingSelect_el = document.querySelector(".settingSelect");
// 公開權限
// 刪除

// 行程卡片內容標籤
const inputStartDate_el = document.getElementById("inputStartDate");
const schNameInput_el = document.getElementById("schNameInput");
const startDate_el = document.getElementById("startDate");
const endDate_el = document.getElementById("endDate");
const destination_el = document.getElementById("destination");
const schName_el = document.getElementById("schName");

// fetch對應到的路徑
let baseURL = window.location.protocol + "//" + window.location.host + "/u-and-me/";
let mySchbaseURL = baseURL + "mySch/";
let myURL = mySchbaseURL + "my/";
let addURL = mySchbaseURL + "create";
let deleteURL = mySchbaseURL + "delete/";
let privateURL = mySchbaseURL + "private/";
let copyrightURL = mySchbaseURL + "copyright/"
let hideURL = mySchbaseURL + "hide/";

let e = 0; //用來控制分頁

// 載入網頁就將所有該會員的行程列表查出
document.addEventListener("DOMContentLoaded", async function () {
  const response = await fetch(baseURL + `member/getMemId`);
  const member = await response.json();
  const memId = member.memId;
  fetchMyScheduleList(myURL, memId, e);
});

// 查詢會員專屬的行程
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
            <img src="../dist/img/scheduleimg/trip${getRandomInteger()}.jpeg"
                alt="" class="card-img-top" style="max-width: 354.656px; max-height: 236.604px; object-fit: cover;">
                <div class="settingSch" id="settingSch${schedule.schId}" onclick="editMySchedule(${schedule.schId})">
                  <div><i class="fa-solid fa-pen-to-square edit"></i></div>
                  <div class="settingSelect -off" id="settingSelect${schedule.schId}" onmouseleave="removeEditBox(${schedule.schId})">
                      <div class="privateSetting" id="privateSetting${schedule.schId}" onclick="selectPrivateSetting(${schedule.schId})">隱私設定與分享</div>
                      <div class="copyrightSetting" onclick="selectCopyrightSetting(${schedule.schId})">複製權限設定</div>
                     <div class="deleteMySch">刪除</div>
                  </div>
                </div>
                <div class="card-body">
                    <h5 class="card-title">${schedule.schName}</h5>
                    <p class="sch-date" style="font-size: 15px">
                    ${formatDate(schedule.schStart)} ~ ${formatDate(schedule.schEnd)}</p>
                    <p class="sch-date" style="font-size: 13px">
                    行程共${calDays(schedule.schStart, schedule.schEnd)}天
                    <span><i class="fa-solid fa-eye"></i> ${convertNumberToText(schedule.schPub)}</span>
                    <span><i class="fa-solid fa-copy"></i> ${convertBooleanToText(schedule.schCopy)}</span>
                    </p>
                    <a href="${baseURL}tmp/Front/schedule/myScheduleEdit.html?schId=${schedule.schId}" class="btn btn-outline-success btn-sm viewDetails">查看詳情</a>
                </div>
              </div>
            `;
      schListInner.appendChild(row);
    });

  } catch (error) {
    console.error("Error fetching MyScheduleList:", error);
  }
}

// 日期格式化
function formatDate(dateString) {
  const options = { year: 'numeric', month: 'long', day: 'numeric' };
  return new Date(dateString).toLocaleDateString('zh-TW', options);
}

// 計算日期間的天數
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

// 隨機取整數函式，更改行程卡片圖片
// 原先單一圖片網址:
// https://images.unsplash.com/photo-1477862096227-3a1bb3b08330?ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60
function getRandomInteger() {
  return Math.floor(Math.random() * (40 - 1 + 1)) + 1;
}

// 轉換行程公開權限設定顯示文字
function convertNumberToText(number) {
  switch (number) {
    case 0:
      return "私人檢視";
    case 1:
      return "連結分享";
    case 2:
      return "公開瀏覽";

  }
}

// 轉換行程複製權限設定顯示文字
function convertBooleanToText(boolValue) {
  return boolValue ? "可供複製" : "不可複製";
}


// =============== 待改，依關鍵字(行程名稱)搜尋行程清單 ===============
search_btn_el.addEventListener("click", function (event) {
  event.preventDefault();
  let keywords = keywords_el.value;
  let keywordsURL = mySchbaseURL + keywords + "/";
  fetchMyScheduleList(keywordsURL, e);
});

// =============== 待改，依行程天數排序行程清單 ===============
sortByDays_el.addEventListener("click", function (event) {
  event.preventDefault();
  fetchMyScheduleList(daysURL, e);
});

// 按修改鈕會根據schRepId跳轉到詳細內容頁面，並將資料映射到相關欄位上
// function redirectToDetailPage(schId) {
//   var newPageUrl = `scheduleEdit.html/schId/${schId}`;
//   window.location.href = newPageUrl;
// }

//=============== 以下為控制分頁(目前寫死) =================

pageSelect1_el.addEventListener('click', async function (e) {

  //增加actice 使分頁亮起來
  pageSelect1_el.classList.toggle("active");
  //刪除actice 使分頁暗下去
  pageSelect2_el.classList.remove("active");
  pageSelect3_el.classList.remove("active");

  //控制fetch傳入網址
  e = 0
  const response = await fetch(baseURL + `member/getMemId`);
  const member = await response.json();
  const memId = member.memId;
  //調用方法
  fetchMyScheduleList(myURL, memId, e);
});

pageSelect2_el.addEventListener('click', async function (e) {
  pageSelect1_el.classList.remove("active");
  pageSelect2_el.classList.toggle("active");
  pageSelect3_el.classList.remove("active");

  e = 1;
  const response = await fetch(baseURL + `member/getMemId`);
  const member = await response.json();
  const memId = member.memId;
  fetchMyScheduleList(myURL, memId, e);
});

document.getElementById('pageSelect3').addEventListener('click', async function (e) {
  pageSelect1_el.classList.remove("active");
  pageSelect2_el.classList.remove("active");
  pageSelect3_el.classList.toggle("active");

  e = 2;
  const response = await fetch(baseURL + `member/getMemId`);
  const member = await response.json();
  const memId = member.memId;
  fetchMyScheduleList(myURL, memId, e);
});

//=============== 控制分頁結束 ===============


// =============== 新增一個行程大綱 ===============

// 當新增行程燈箱內容填寫完畢，按下完成按鈕後，
// 將行程大綱資料傳輸進資料庫，並回到會員自己的行程頁面
btn_schDone.onclick = async event => {

  event.preventDefault();
  const response = await fetch(baseURL + `member/getMemId`);
  const member = await response.json();
  const memId = member.memId;

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


// =============== 編輯一個行程大綱(公開權限) ===============
function editMySchedule(schId) {
  // 跳出選擇公開權限及刪除選項框
  const settingSelect_el = document.querySelector("#settingSelect" + schId);
  if (settingSelect_el.classList.contains(classSwitchOff)) {
    settingSelect_el.classList.remove(classSwitchOff);
  }
}
// 滑鼠離開編輯選項時，自動關閉
function removeEditBox(schId) {
  const settingSelect_el = document.querySelector("#settingSelect" + schId);
  if (!settingSelect_el.classList.contains(classSwitchOff)) {
    settingSelect_el.classList.add(classSwitchOff);
  }
}

// 修改行程隱私設定與分享
async function selectPrivateSetting(schId) {
  Swal.fire({
    title: '隱私設定與分享',
    input: 'select',
    inputOptions: {
      '0': '私密',
      '1': '透過連結分享',
      '2': '公開'
    },
    showCancelButton: true,
    cancelButtonText: '取消',
    confirmButtonText: '確定',
    showLoaderOnConfirm: true,
    preConfirm: async (selectedOption) => {
      // 如果設定為連結分享，要顯示分享的連結
      // TODO...

      const response = await fetch(`${privateURL}${schId}/${selectedOption}`);
      return response;
    },
    allowOutsideClick: () => !Swal.isLoading()
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire({
        title: `設定成功！`,
        imageUrl: 'https://storage.googleapis.com/sticker-prod/yZzo2n9q8atPzSyYEWBg/9-1.png'
      }).then(() => {
        // 在用戶按下"確定"後執行重新整理
        location.reload();
      });
    }
  });
}


// 修改複製權限設定
async function selectCopyrightSetting(schId) {
  Swal.fire({
    title: '是否供他人複製此行程？',
    input: 'select',
    inputOptions: {
      true: '是',
      false: '否'
    },
    showCancelButton: true,
    cancelButtonText: '取消',
    confirmButtonText: '確定',
    showLoaderOnConfirm: true,
    preConfirm: async (selectedOption) => {
      const response = await fetch(`${copyrightURL}${schId}/${selectedOption}`);
      return response;
    },
    allowOutsideClick: () => !Swal.isLoading()
  }).then((result) => {
    if (result.isConfirmed) {
      Swal.fire({
        title: `設定成功！`,
        imageUrl: 'https://stickershop.line-scdn.net/stickershop/v1/product/11952172/LINEStorePC/main.png?v=1'
      }).then(() => {
        // 在用戶按下"確定"後執行重新整理
        location.reload();
      });
    }
  });
}

// =============== 編輯一個行程大綱結束 ===============


// =============== 刪除一個行程大綱 ===============




// =============== 刪除一個行程大綱結束 ===============