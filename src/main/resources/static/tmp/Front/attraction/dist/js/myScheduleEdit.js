const baseUrl = window.location.protocol + "//" + window.location.host + "/u-and-me/";

//時間計算
function getDayOfWeek(dateString) {
    const daysOfWeek = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'];
    const date = new Date(dateString);
    const dayOfWeek = daysOfWeek[date.getDay()];
    console.log("Date to change: " + dateString + ":" + dayOfWeek);
    return dayOfWeek;
}

// class -on -off -one 屬性
const classSwitchOn = "-on";
const classSwitchOff = "-off";
const classMapOne = "-one";

// 抓取所有會切換頁面使用到的標籤
const backToMySchedule_el = document.querySelector("#backToMySchedule");


// =============== 行程細節相關標籤 =============== 
// 選擇日期天數頁籤
const tab_dateBarLeft_el = document.querySelector(".dateBarTab.-left");
const tab_dateBarRight_el = document.querySelector(".dateBarTab.-right");
const dateSelectCell_el = document.querySelectorAll(".dateSelectCell");
// 更換順序
const iswitch_el = document.querySelectorAll("i.switch");
// 刪除第幾天行程
const itrash_el = document.querySelectorAll("i.trash");
// 新增景點按鈕
const addNewAttrbtn_el = document.querySelector("div.addNewAttrbtn");
// 行程細節cell
const schDetailCells = document.querySelector(".schDetailCell");

// =============== 景點搜尋相關標籤 =============== 
// 返回行程細節(箭頭)、搜尋、景點收藏、自訂景點
const tab_back_el = document.querySelector("#tab-back");
const tab_search_el = document.querySelector("#tab-search");
const tab_attrCollect_el = document.querySelector("#tab-attrCollect");
const tab_customize_el = document.querySelector("#tab-customize");

// 頁籤icon
const searchIcons = document.querySelectorAll("i.search");
const searchGlassIcon = document.querySelectorAll("i.search")[0];
const myCollectIcon = document.querySelectorAll("i.search")[1];
const myCustomIcon = document.querySelectorAll("i.search")[2];

// 每個頁籤對應到的頁面
const viewSchDetailsPage = document.querySelector(".viewSchDetailsColumn");
const viewSearchPage = document.querySelector(".viewAttrSearchColumn");
const attrSearchPage = document.querySelector(".attrSearch-result");
const myAttrsPage = document.querySelector(".myAttrs");
const myAttrCollectionList = document.querySelector(".attrCollectionList");
const attrCollectNotFound = document.querySelector(".attrCollectNotFound");
const myCustomizeAttrPage = document.querySelector(".myCustomizeAttr");

// 景點詳情及 GOOGLE MAP
const viewAttrDetailsCard = document.querySelector(".viewAttrDetailsColumn");
const viewGoogleMap = document.querySelector(".map");

// 自訂景點內容標籤
const myAttrName_el = document.querySelector("#myAttrName");
const myAttrAddr_el = document.querySelector("#myAttrAddr");
// const attrPicFilesInput = document.querySelector("#attrPicFilesInput");

// 景點搜尋相關按鈕
const addAttrCollect_btn_el = document.querySelector(".addAttrCollect-btn");
const addToSchedule_btn_el = document.querySelector(".addToSchedule-btn");
const myAttrDone_btn_el = document.querySelector(".myAttrDone-btn");

// 元素插入處

// 景點搜尋
const attrSearchListInsert_el = document.querySelector(".attrSearchList");
// 景點收藏
const attrCollectionListInsert_el = document.querySelector(".attrCollectionList")

const mySchDateStart_el = document.getElementById("mySchDateStart");
const mySchDateEnd_el = document.getElementById("mySchDateEnd");

const viewWhichDay_els = document.querySelectorAll(".viewWhichDay");
const viewWhichWeekDay_els = document.querySelectorAll(".viewWhichWeekDay");
const schDeStartTime_els = document.querySelectorAll(".schDeStartTime");
const viewSchDetailsRows = document.querySelector(".viewSchDetailsRows");


//將轉換成字串的日期物件中的 "-" 改成"/"
function modifiyDate(date) {
    return date.replace(/-/g, '/');
}

//將轉換成字串的日期物件中的 "00:00:00" 改成 "X時X分"
function formatStayTime(stayTime) {
    const parts = stayTime.split(':');
    const hours = parseInt(parts[0], 10);
    const minutes = parseInt(parts[1], 10);

    let formattedTime = '';

    if (hours > 0) {
        formattedTime += hours + '小時';
    }

    if (minutes > 0) {
        formattedTime += minutes + '分';
    }

    return formattedTime || '0分'; // 如果没有小时和分钟，默认为0分
}


// function todayFirstSchDetailIndex(data){

// }

//將timestampString轉成Date 並調整精度
function parseTimestamp(timestampString) {
    const parts = timestampString.split(' ');
    const datePart = parts[0];
    const timePart = parts[1];

    const dateParts = datePart.split('-');
    const year = parseInt(dateParts[0]);
    const month = parseInt(dateParts[1]) - 1; // 月份从0开始，所以要减1
    const day = parseInt(dateParts[2]);

    const timeParts = timePart.split(':');
    const hour = parseInt(timeParts[0]);
    const minute = parseInt(timeParts[1]);
    const second = parseInt(timeParts[2]);

    return new Date(year, month, day);//後面可加 ,hour , minute, second 調整精度
}

function addTimeToStartTime(startTime, stayTime) {
    // 解析 startTime 字符串为 Date 对象
    const startDate = new Date(startTime);

    // 解析 stayTime 字符串为小时、分钟和秒
    const stayTimeParts = stayTime.split(':');
    const stayHours = parseInt(stayTimeParts[0]);
    const stayMinutes = parseInt(stayTimeParts[1]);

    // 计算新的小时和分钟
    let newHours = startDate.getHours() + stayHours;
    let newMinutes = startDate.getMinutes() + stayMinutes;

    // 处理跨天情况
    if (newMinutes >= 60) {
        newHours += Math.floor(newMinutes / 60);
        newMinutes %= 60;
    }
    if (newHours >= 24) {
        newHours -= 24;
    }

    // 更新日期对象
    startDate.setHours(newHours);
    startDate.setMinutes(newMinutes);
    console.log(startDate);

    return startDate;
}

function extractHourAndMinute(timeString) {
    // 去掉字符串前后的方括号，然后解析为 Date 对象
    const date = new Date(timeString);

    // 获取时和分的部分
    const hours = date.getHours().toString().padStart(2, '0');
    const minutes = date.getMinutes().toString().padStart(2, '0');

    // 格式化结果
    return `${hours}:${minutes}`;
}


async function addDailySchedule(restScheDetails) {
    //拿第一個細節的起始時間當今天開始時間
    //迴圈塞入各個行程細節 直到下一個行程的日期不是本日
    //期間 計算行程的停留時間 換算結束時間
    //              透過交通方式計算行程間的交通距離 交通時間
    //結束時間=開始時間+停留時間
    //開始時間=結束時間+交通時間

    //一但有變動 重新呼叫本函式更新一天行程
    var schdeStarttime = restScheDetails[0].schdeStarttime;
    let countedScheDetails;
    for (countedScheDetails = 0; ; countedScheDetails++) {
        //如果下一筆行程細節是明天的 結束今天的行程列印


        const schdeId = restScheDetails[countedScheDetails].schdeId;
        const schId = restScheDetails[countedScheDetails].schId;
        const attrId = restScheDetails[countedScheDetails].attrId;
        // const schdeStarttime = restScheDetails[countedScheDetails].schdeStarttime;
        const schdeStaytime = restScheDetails[countedScheDetails].schdeStaytime;
        console.log("schdeStarttime::" + schdeStarttime);
        console.log("schdeStaytime::" + schdeStaytime);
        const schdeEndtime = addTimeToStartTime(schdeStarttime, schdeStaytime);
        console.log("schdeEndtime::" + schdeEndtime);

        const schdeTranstime = restScheDetails[countedScheDetails].schdeTranstime;
        const schdeTrans = restScheDetails[countedScheDetails].schdeTrans;
        const schdeCost = restScheDetails[countedScheDetails].schdeCost;
        const schdeRemark = restScheDetails[countedScheDetails].schdeRemark;
        const responseAttr = await fetch(baseUrl + `getAttr?attrId=` + attrId);
        const attr = await responseAttr.json();
        const responseAttrPics = await fetch(baseUrl + `getAttrPics/` + attrId);
        const attrPicList = await responseAttrPics.json();
        //取得景點的第一張圖片
        const attrPicture = attrPicList.attrPic[0].attrPicData;
        let row = document.createElement("div");
        row.innerHTML = `
                <!-- 行程細節 cell 由此插入 -->
                <!-- 第一個行程細節 cell -->
                <!-- 待加入 onclick後將景點詳情資訊更改成點到的景點資料js -->
                <div class="schDetailCell card mb-3" onclick="viewSearchResultOfOneAttr();">
                    <div class="row g-0">
                        <div class="attrPic col-md-4">
                            <img src="data:image/jpeg;base64,${attrPicture}"
                                class="attrFirstPicInschDetail" class="img-fluid rounded-start"
                                alt="...">
                            <div class="schDetailOrder"><span class="schDetailOrder">${countedScheDetails + 1}</span>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="schDetailsCardBody">
                                <p class="schTimes"><span class="stayTimes">${formatStayTime(schdeStaytime)}</span> |
                                    <span class="startTimes">${extractHourAndMinute(schdeStarttime)}</span> - <span
                                        class="endTimes">${extractHourAndMinute(schdeEndtime)}</span>
                                </p>
                                <h5 class="attrName">
                                    <div class="attrNameInSchDetail">
                                        ${attr.attrName}
                                    </div>
                                </h5>
                                <p class="attrAddr">
                                    <small class="text-body-secondary"
                                        class="attrAddr">${attr.attrAddr}</small>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 行程細節 cell 結束 -->
            <!-- 第二個行程細節cell結束 ！！！！！！！！　-->
            `;


        viewSchDetailsRows.appendChild(row);
        
        //將TimeStampString轉為Date 且可以直接比大小
        //測試只比較日期的比大小 輸出應為相等
        if (parseTimestamp(restScheDetails[countedScheDetails].schdeStarttime)
            < parseTimestamp(restScheDetails[countedScheDetails + 1].schdeStarttime)) {

            break;
        }

        schdeStarttime = schdeEndtime;

        console.log("NEW START TIME: " + schdeStarttime);

    }
    return countedScheDetails;
}


// ================== 載入行程編輯頁面 ================== //
document.addEventListener("DOMContentLoaded", async function () {
    // 获取当前页面的 URL
    const currentURL = window.location.href;
    // 创建一个 URLSearchParams 对象，传入查询参数部分
    const urlSearchParams = new URLSearchParams(currentURL.split('?')[1]);
    // 使用 get() 方法来获取特定查询参数的值
    const schId = urlSearchParams.get('schId');

    //透過schId 獲取整個schedule物件
    const response = await fetch(baseUrl + `schedules/schId/${schId}`);
    const schedule = await response.json();
    console.log("Schedule ID: " + schId);
    //行程開始日期 結束日期
    var schStartDate = new Date(schedule.schStart);
    var schEndDate = new Date(schedule.schEnd);
    var schStart = schedule.schStart;
    var schEnd = schedule.schEnd;
    var schDuringDays = ((schEndDate - schStartDate) / (1000 * 60 * 60 * 24)) + 1;
    //將起始日期及結束日期放在行程最上方
    mySchDateStart_el.innerText = modifiyDate(schStart);
    mySchDateEnd_el.innerText = modifiyDate(schEnd);

    // const viewWhichDay_els = document.querySelectorAll(".viewWhichDay");第幾天
    // const viewWhichWeekDay_els = document.querySelectorAll(".viewWhichWeekDay");周幾
    // const schDeStartTime_els = document.querySelectorAll(".schDeStartTime");今天的起始時間

    //取出本行程所有的行程細節
    const response1 = await fetch(baseUrl + `schDetails/${schId}`);
    const schDetails = await response1.json();
    console.log("STAY time: " + schDetails[0].schdeStaytime);
    console.log("STAY time: " + formatStayTime(schDetails[0].schdeStaytime));
    const stayTimes = document.querySelectorAll(".stayTimes");
    let count = 0;
    //將所有行程細節stayTime顯示
    for (let stayTime of stayTimes) {
        stayTime.innerText = formatStayTime(schDetails[count++].schdeStaytime);
    }
    // schDetails.shift();
    // console.log(schDetails);
    addDailySchedule(schDetails);


    //每日的行程內容渲染
    // let countDate = schStartDate;
    // for (let day = 0, schDetail = 0; day < schDuringDays; day++) {

    //     //     //創造今天的物件 周幾 行程細節 等等

    //     //印出今天周幾
    //     viewWhichWeekDay_els[day].innerText = getDayOfWeek(countDate);


    //     //每個行程要做的事
    //     for (/**schDetail要一直累加 所以放在上層迴圈宣告 */; ; schDetail++) {
    //         if (parseTimestamp(schDetails[schDetail].schdeStarttime)
    //             < parseTimestamp(schDetails[schDetail + 1].schdeStarttime)) {

    //             break;
    //         }
    //         //獲得行程開始時間
    //         //取出行程停留時間
    //         //計算行程結束時間
    //         //印出上述資料
    //     }




    //     //計算明天周幾 天數加一
    //     countDate.setDate(countDate.getDate() + 1);
    // }



    // 關閉景點搜尋內其他頁籤內容
    switchSearchPagesAddOff();
    switchAttrDetailsAndMapOff();

});


//  ================== 行程細節頁面(待新增) ================== //
backToMySchedule_el.addEventListener("click", function () {

});


// 按下選擇天數tab，移動左右天數欄
// 向左移
let count_click_leftbtn = 0;
let translateXValue = -60;
tab_dateBarLeft_el.onclick = () => {
    for (let dateSelectCell of dateSelectCell_el) {
        dateSelectCell.style.transform = `translateX(${translateXValue * count_click_leftbtn}px)`;
    }
    count_click_rightbtn = 0;
    ++count_click_leftbtn;
    console.log("向左" + count_click_leftbtn + "次");
}

// 向右移(要移除left設定)
let count_click_rightbtn = 0;
tab_dateBarRight_el.onclick = () => {
    // 要讓元素從當下位置開始向右移動

    for (let dateSelectCell of dateSelectCell_el) {
        // if (count_click_rightbtn === 0) {
        // 讓元素停在當下位置不跑掉
        // }
        // if (count_click_rightbtn >= 1) {
        dateSelectCell.style.transform = `translateX(${-(translateXValue * count_click_rightbtn)}px)`;
        // }
    }
    count_click_leftbtn = 0;
    ++count_click_rightbtn;
    console.log("向右" + count_click_rightbtn + "次");
}


// 在行程細節中按下新增景點按鈕
function addNewAttrbtnOnclick() {
    // 關閉行程細節Page
    if (!viewSchDetailsPage.classList.contains(classSwitchOff)) {
        viewSchDetailsPage.classList.add(classSwitchOff);
    }
    // 關閉開啟中的景點詳細Page及景點搜尋相關Page
    switchSearchPagesAddOff();
    switchAttrDetailsAndMapOff();
    // 開啟景點搜尋Page
    if (viewSearchPage.classList.contains(classSwitchOff)) {
        viewSearchPage.classList.remove(classSwitchOff);
    }
    // 將所有頁籤icon變灰色
    switchIconsRemoveOn();
    // 搜尋放大鏡變色
    searchGlassIcon.classList.add(classSwitchOn);
    // 顯示搜尋欄及搜尋結果
    attrSearchPage.classList.remove(classSwitchOff);
}


// 點擊行程細節查看景點內容
// (綁定在div.schDetailCell標籤上onclick，方法為viewSearchResultOfOneAttr();)


//  ================== 行程細節頁面結束 ================== //


//  ================== 景點搜尋相關頁面 ================== //
// 從景點搜尋頁面中按下箭頭返回鍵，返回行程細節頁面
tab_back_el.addEventListener("click", function () {
    // 關閉所有景點搜尋相關頁面
    switchSearchPagesAddOff();
    switchAttrDetailsAndMapOff();
    // 顯示查看行程細節頁面
    viewSchDetailsPage.classList.remove(classSwitchOff);
});

// ---- 換頁籤處理 ----//
// 將所有icon顏色移除
function switchIconsRemoveOn() {
    for (let searchIcon of searchIcons) {
        // 將所有icon都變灰色
        if (searchIcon.classList.contains(classSwitchOn)) {
            searchIcon.classList.remove(classSwitchOn);
        }
    }
}

// 將所有頁籤頁面display: none
function switchSearchPagesAddOff() {
    if (!attrSearchPage.classList.contains(classSwitchOff)) {
        attrSearchPage.classList.add(classSwitchOff);
    }
    if (!myAttrsPage.classList.contains(classSwitchOff)) {
        myAttrsPage.classList.add(classSwitchOff);
    }
    if (!myCustomizeAttrPage.classList.contains(classSwitchOff)) {
        myCustomizeAttrPage.classList.add(classSwitchOff);
    }
}

// 將查看單一景點詳情頁面及 GOOGLE MAP(查看單一景點模式) 關閉
function switchAttrDetailsAndMapOff() {
    if (!viewAttrDetailsCard.classList.contains(classSwitchOff)) {
        viewAttrDetailsCard.classList.add(classSwitchOff);
    }
    if (viewGoogleMap.classList.contains(classMapOne)) {
        viewGoogleMap.classList.remove(classMapOne);
    }
}
// ---- 換頁籤處理結束 ----//

// ================== 景點搜尋 ================== //
// 按下景點搜尋頁籤時換到景點搜尋頁面
tab_search_el.addEventListener("click", function (e) {
    e.preventDefault();
    // 將當前icon變色
    switchIconsRemoveOn();
    searchGlassIcon.classList.add(classSwitchOn);
    // 關閉其他頁籤內容
    switchSearchPagesAddOff();
    switchAttrDetailsAndMapOff();
    // 顯示搜尋欄及搜尋結果
    attrSearchPage.classList.remove(classSwitchOff);
});

// 點擊到單一景點收藏cell時，出現景點詳細頁面
function viewSearchResultOfOneAttr() {
    // 顯示單一景點詳情頁面
    viewAttrDetailsCard.classList.remove(classSwitchOff);
    // 開啟 GOOGLE MAP(查看單一景點模式)
    viewGoogleMap.classList.add(classMapOne);
}

// 關閉單一景點詳情頁面(按下叉叉時觸發)
function closeViewAttrDetailsCard() {
    // 關閉單一景點詳情頁面
    viewAttrDetailsCard.classList.add(classSwitchOff);
    // 開啟 GOOGLE MAP(查看單一景點模式)
    viewGoogleMap.classList.remove(classMapOne);
}

// 按下加入景點收藏按鈕時跳出提示視窗
addAttrCollect_btn_el.onclick = () => {
    Swal.fire(
        '儲存成功!',
        '已儲存至景點收藏!',
        'success'
    )
}

// ================== 景點收藏 ================== //

// fetch to Controller路徑
let baseURL = window.location.protocol + "//" + window.location.host + "/u-and-me";
// 列出所有景點收藏
let myAttrCollectionURL = baseURL + "/attrCol/getAttrsFromCollectionByMemId/"



// 按下我的景點收藏時換到景點收藏頁面
tab_attrCollect_el.addEventListener("click", function (e) {
    e.preventDefault();
    // 將當前icon變色
    switchIconsRemoveOn();
    myCollectIcon.classList.add(classSwitchOn);
    // 關閉其他頁籤內容
    switchSearchPagesAddOff();
    switchAttrDetailsAndMapOff();
    // 顯示景點收藏清單
    myAttrsPage.classList.remove(classSwitchOff);
    if (myAttrCollectionList.classList.contains(classSwitchOff)) {
        myAttrCollectionList.classList.remove(classSwitchOff);
    }
    // 若沒有景點收藏，則顯示尚未有任何收藏景點頁面
    // myAttrCollectionList.classList.add(classSwitchOff);
    // if (attrCollectNotFound.classList.contains(classSwitchOff)) {
    //     attrCollectNotFound.classList.remove(classSwitchOff);
    // }

    let memId = 2;
    FindAllAttrCollectionList(myAttrCollectionURL, memId);

});


// 查看景點收藏，動態生成景點收藏清單
async function FindAllAttrCollectionList(URL, memId) {
    try {
        const response = await fetch(URL + memId);
        const myAttrCollectList = await response.json();
        // 如果找不到收藏，則顯示沒有收藏頁面的東西
        if (myAttrCollectList == null || myAttrCollectList == undefined) {
            attrCollectNotFound.classList.remove(classSwitchOff);
        }

        // 清空插入處所有的資料
        attrCollectionListInsert_el.innerHTML = "";

        myAttrCollectList.forEach(attr => {


            let row = document.createElement("div");
            row.innerHTML = `
                <div class="attrCell card mb-3" onclick="viewSearchResultOfOneAttr()" id="attrId${attr.collectionId.attrId}">
                <div class="row g-0">
                    <div class="col-md-8">
                        <div class="attrCardBody">
                            <h5 class="attrName">
                                <div id="attrName">
                                    AAAAAAA
                                </div>
                            </h5>
                        </div>
                    </div>
                    <div class="attrPic col-md-4">
                        <img src="https://images.unsplash.com/photo-1477862096227-3a1bb3b08330?ixlib=rb-1.2.1&auto=format&fit=crop&w=700&q=60"
                            id="attrFirstPic" class="img-fluid rounded-end" alt="...">
                    </div>
                </div>
            </div>`;

            attrCollectionListInsert_el.appendChild(row);
        });

    } catch (error) {
        console.error("Error fetching AttrCollectList:", error);
    }
}





// ================== 自訂景點 ================== //
// 按下自訂景點時換到自訂景點頁面
tab_customize_el.addEventListener("click", function (e) {
    e.preventDefault();
    // 將當前icon變色
    switchIconsRemoveOn();
    myCustomIcon.classList.add(classSwitchOn);
    // 關閉其他籤內容
    switchSearchPagesAddOff();
    switchAttrDetailsAndMapOff();
    // 顯示自訂景點頁面
    myCustomizeAttrPage.classList.remove(classSwitchOff);
});

// 自訂景點中新增景點圖片
// 待加入取消部分圖片上傳的功能！！！！！！！！！！！！！！！！！！！！！！！
const attrPicFilesInput = document.querySelector("#attrPicFilesInput");
const myAttrPicsPreview = document.querySelector("#attrPicsPreview");

attrPicFilesInput.addEventListener('change', (event) => {
    myAttrPicsPreview.innerHTML = '';
    const files = event.target.files;

    for (const file of files) {
        const imageURL = URL.createObjectURL(file);
        const image = new Image();
        image.src = imageURL;
        image.style.maxWidth = "318.3px"; // 設定預覽圖最大寬度
        image.style.width = "100%";
        image.style.objectFit = "cover;"// 設定圖片裁切
        image.style.position = "relative";
        image.style.marginTop = "5px";
        myAttrPicsPreview.appendChild(image);
    }
});




// 自訂景點內容完成後，顯示新增完成警示框
myAttrDone_btn_el.onclick = () => {

    let myAttrName = myAttrName_el.value.trim();
    let myAttrAddr = myAttrAddr_el.value.trim();
    const picFiles = attrPicFilesInput.files;

    if (myAttrName === "" || myAttrAddr === "" || picFiles === null) {
        Swal.fire({
            icon: 'error',
            title: '新增失敗',
            text: '請檢查資料是否填寫正確!',
            // footer: '<a href="">Why do I have this issue?</a>'
        })
    } else {
        Swal.fire(
            '新增成功!',
            '您已新增一個自訂景點!',
            'success'
        )
    }
}

//  ================== 景點搜尋相關頁面結束 ================== //