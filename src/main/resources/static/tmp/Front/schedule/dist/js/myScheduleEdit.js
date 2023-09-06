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


// ================== 載入行程編輯頁面 ================== //
document.addEventListener("DOMContentLoaded", function () {


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
    // 關閉開啟中的景點詳細Page
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
    viewSearchPage.classList.add(classSwitchOff);
    viewSchDetailsPage.classList.remove(classSwitchOff);
    switchAttrDetailsAndMapOff();
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
});

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