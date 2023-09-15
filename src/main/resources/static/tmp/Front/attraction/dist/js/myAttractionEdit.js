let baseURL = window.location.protocol + "//" + window.location.host + "/u-and-me/";
// 行程總天數
var schDuringDays;
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
// 更換順序
const iswitch_el = document.querySelectorAll("i.switch");
// 刪除第幾天行程
const itrash_el = document.querySelectorAll("i.trash");
// 新增景點按鈕
const addNewAttrbtn_el = document.querySelector("div.addNewAttrbtn");
// 行程細節cell(有很多個，先抓第一個)
const schDetailCells = document.querySelector(".schDetailCell");

// =============== 行程細節時間計算相關標籤(BY Reynolds) =============== 
const mySchDateStart_el = document.getElementById("mySchDateStart");
const mySchDateEnd_el = document.getElementById("mySchDateEnd");

const viewWhichDay_els = document.querySelectorAll(".viewWhichDay");
const viewWhichWeekDay_els = document.querySelectorAll(".viewWhichWeekDay");
const schDeStartTime_els = document.querySelectorAll(".schDeStartTime");
const viewSchDetailsRows = document.querySelector(".viewSchDetailsRows");
// =============== 行程細節時間計算相關標籤(BY Reynolds) =============== 



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

// 景點操作相關按鈕(將景點加入收藏、移除收藏、加入行程及完成自訂景點按鈕)
const addAttrCollect_btn_el = document.querySelector(".addAttrCollect-btn");
const removeAttrCollect_btn_el = document.querySelector(".removeAttrCollect-btn");
const addToSchedule_btn_el = document.querySelector(".addToSchedule-btn");
const myAttrDone_btn_el = document.querySelector(".myAttrDone-btn");

// =============== 元素插入處相關標籤 =============== 
// --------- 行程相關 ------------
const dateSelectCellInsert_el = document.querySelector("div.dateSelect");

// --------- 景點相關 ------------
// 景點搜尋
const attrSearchListInsert_el = document.querySelector(".attrSearchList");
// 景點收藏
const attrCollectionListInsert_el = document.querySelector(".attrCollectionList")
// 單一景點詳情圖片輪播
const attrTotalImgsInsert_el = document.querySelector(".attrTotalImgsInsert");
// 單一景點詳情內容
// 景點id隱藏欄位
const attrIdText_el = document.querySelector("#attrIdText");
// 景點名稱(標題)
const attrNameTitle = document.querySelector("#attrNameTitle");
// 景點評價
const attrComScore = document.querySelector("#attrComScore");
// 景點類型
const attrTypeName = document.querySelector("#attrTypeName");
// 景點地址
const attrAddress = document.querySelector("#attrAddress");
// 景點營業時間(只抓第一個標籤)
const attrBussTime = document.querySelector("#attrBussTimeMon");
// 景點消費價位(低中高價位)
const attrCostRange = document.querySelector("#attrCostRange");
// 景點描述
const attrIlla = document.querySelector("#attrIlla");

// =============== 行程細節時間計算相關函式(BY Reynolds)結束 =============== 



// 景點評價(3.5~5.0)
function generateRandomNumber() {
    const min = 3.5; // 最小值
    const max = 5.0; // 最大值

    // 生成随机数
    const randomNumber = Math.random() * (max - min) + min;

    // 使用 toFixed 方法四舍五入到小数点第一位
    const roundedNumber = Number(randomNumber.toFixed(1));

    return roundedNumber;
}

// 景點消費價位轉換
function codeToPriceRange(code) {
    switch (code) {
        case 1:
            return "低價位 (500元以下)";
        case 2:
            return "中價位 (500~1000元)";
        case 3:
            return "高價位 (1000元以上)";
        // 添加更多的代号和对应的描述
        default:
            return "尚無資料";
    }
}


// ================== 載入行程編輯頁面 ================== //
document.addEventListener("DOMContentLoaded", async function () {


});


//  ================== 行程細節頁面(待新增) ================== //
backToMySchedule_el.addEventListener("click", function () {

});


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


//  ================== 行程細節頁面結束 ================== //


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


function bussTimeString(inputString) {
    // 使用逗号分割字符串，并将结果存储在数组中
    if(inputString==undefined||inputString==null||inputString.trim()=='')
        return "尚無資料";
    const timeRanges = inputString.split('|');

    // 分别存储平日和假日的时间范围
    let weekdayTimeRange = "";
    let holidayTimeRange = "";

    holidayTimeRange = timeRanges[0];
    holidayTimeRangeArr = [];
    holidayTimeRangeArr = holidayTimeRange.split('');
    holidayTimeRange = holidayTimeRangeArr[0] + holidayTimeRange[1] + ":"
        + holidayTimeRange[2] + holidayTimeRange[3] + "~"
        + holidayTimeRange[5] + holidayTimeRange[6] + ":"
        + holidayTimeRange[7] + holidayTimeRange[8];
    weekdayTimeRange = timeRanges[1];
    weekdayTimeRangeArr = [];
    weekdayTimeRangeArr = weekdayTimeRange.split('');
    weekdayTimeRange = weekdayTimeRangeArr[0] + weekdayTimeRange[1] + ":"
        + weekdayTimeRange[2] + weekdayTimeRange[3] + "~"
        + weekdayTimeRange[5] + weekdayTimeRange[6] + ":"
        + weekdayTimeRange[7] + weekdayTimeRange[8];
    const resultString = `平日:${weekdayTimeRange} | 假日:${holidayTimeRange}`;
    return resultString;
}

// 點擊到schDetailCell(單一行程細節Cell)、attrCell(景點搜尋、景點收藏Cell)時，出現景點詳細頁面
async function viewSearchResultOfOneAttr(attrId) {
    // 顯示單一景點詳情頁面
    viewAttrDetailsCard.classList.remove(classSwitchOff);
    // 開啟 GOOGLE MAP(查看單一景點模式)
    viewGoogleMap.classList.add(classMapOne);

    // 藉由景點id查詢相應所有圖片
    const responseOfAttrAllPic = await fetch(getAttrPicsByAttrIdURL + attrId);
    const attrPicList = await responseOfAttrAllPic.json();
    const pics = attrPicList.attrPic;

    // 清空景點詳情圖片
    attrTotalImgsInsert_el.innerHTML = "";

    // 取出每一張圖片，放入輪播img標籤中
    for (let pic of pics) {

        // console.log(pic);
        let imgs = document.createElement("div");
        imgs.classList.add("carousel-item");

        imgs.innerHTML = `
            <img class="attrImgs"
            style="width: 318.3px;height: 208.3px;object-fit: cover;"
            src="data: image/jpeg;base64,${pic.attrPicData}"
            alt="...">`;

        attrTotalImgsInsert_el.appendChild(imgs);

        // 將輪播的第一個圖片<div> class加上active屬性
        let firstImgDiv = document.querySelector("div.carousel-item:first-child");
        firstImgDiv.classList.add("active");
    }

    // 更改景點詳情內容
    const responseOfOneAttr = await fetch(getAttrByAttrIdURL + attrId);
    const attr = await responseOfOneAttr.json();
    console.log(attr);
    attrIdText_el.innerHTML = attrId;
    attrNameTitle.innerText = attr.attrName;
    attrComScore.innerText = generateRandomNumber();
    attrTypeName.innerText = attr.attrType;
    attrAddress.innerHTML = attr.attrAddr;
    attrBussTime.innerText = bussTimeString(attr.attrBussTime) ? bussTimeString(attr.attrBussTime) : attr.attrBussTime;
    attrCostRange.innerText = codeToPriceRange(attr.attrCostRange);
    attrIlla.innerHTML = attr.attrIlla;

    // console.log("LatLng: " + attr.attrLat + "::" + attr.attrLon);
    // 將 attr.attrLat 和 attr.attrLon 轉換為數字
    // 假設你有一個經緯度
    var latitude = attr.attrLat; // 緯度
    var longitude = attr.attrLon; // 經度
    console.log("經度: " + latitude);
    console.log("緯度: " + longitude);

    // 創建一個包含經緯度信息的 Place 物件
    var locationPlace = {
        geometry: {
            location: new google.maps.LatLng(latitude, longitude)
        }
    };

    // 創建地圖選項
    var mapOptions = {
        center: locationPlace.geometry.location, // 設置地圖中心為 Place 的位置
        zoom: 16, // 放大級別，根據需求調整
    };

    // 創建地圖對象
    var map = new google.maps.Map(document.getElementById('map'), mapOptions);

    // 在地圖上放置標記
    var marker = new google.maps.Marker({
        position: locationPlace.geometry.location,
        map: map,
        title: '自定義位置' // 可以自定義標記的標題
    });
}


// 關閉單一景點詳情頁面(按下叉叉時觸發)
function closeViewAttrDetailsCard() {
    // 關閉單一景點詳情頁面
    viewAttrDetailsCard.classList.add(classSwitchOff);
    // 開啟 GOOGLE MAP(查看單一景點模式)
    viewGoogleMap.classList.remove(classMapOne);
}

// ================== 景點收藏 ================== //

// fetch to Controller路徑
// 列出所有景點收藏
let myAttrCollectionURL = baseURL + "attrCol/getAttrsFromCollectionByMemId/";
// 依據景點編號查詢景點資訊
let getAttrByAttrIdURL = baseURL + "getAttr?attrId=";
// 依據景點編號查詢所有景點圖片
let getAttrPicsByAttrIdURL = baseURL + "getAttrPics/";



// 新增景點收藏(在景點搜尋頁面)
addAttrCollect_btn_el.onclick = async () => {

    // 抓取會員id
    const response = await fetch(baseURL + `member/getMemId`);
    const member = await response.json();
    const memId = member.memId;

    // 抓取景點id
    let attrId = attrIdText_el.innerText;

    const attrCollectionDTO = {
        collectionId: {
            memId: memId,
            attrId: attrId
        }
    }
    const responseCol = await fetch(baseURL + `attrCol/addAttrToCollection`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(attrCollectionDTO)
    })
    Swal.fire(
        '儲存成功!',
        '已儲存至景點收藏!',
        'success'
    )
}


// 移除景點收藏
removeAttrCollect_btn_el.onclick = async () => {

    // 抓取會員id
    const response = await fetch(baseURL + `member/getMemId`);
    const member = await response.json();
    const memId = member.memId;

    // 抓取景點id
    let attrId = attrIdText_el.innerText;

    const collectionId = {
        memId: memId,
        attrId: attrId
    }

    const responseCol = await fetch(baseURL + `attrCol/removeAttrFromCollection`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(collectionId)
    })
    Swal.fire(
        '移除成功!',
        '已從景點收藏中移除此景點!',
        'success'
    ).then(() => {
        FindAllAttrCollectionList(memId);
    })
}

