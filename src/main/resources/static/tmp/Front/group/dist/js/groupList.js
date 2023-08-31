//=============== 以下為控制分頁 =================

//====使用的元素====
const time_btn_el = document.getElementById("time_btn");
const amount_btn_el = document.getElementById("amount_btn");
const name_btn_el = document.getElementById("name_btn");
const name_input_el = document.getAnimations("name_input");

// fetch對應到的路徑
let baseURL = window.location.protocol + "//" + window.location.host + "/u-and-me";
let url;

let e = 0; //用來控制分頁
let time_btn_count = 0; //控制時間排序
let amount_btn_count = 0; //控制時間排序
let name_btn_count = 0; //控制搜尋名稱 
let response;


document.getElementById('pageSelect1').addEventListener('click', async function () {

    //增加actice 使分頁亮起來
    document.getElementById('pageSelect1').classList.add("active");

    //刪除actice 使分頁暗下去
    document.getElementById('pageSelect2').classList.remove("active");

    //刪除actice 使分頁暗下去
    document.getElementById('pageSelect3').classList.remove("active");

    //控制fetch傳入網址
    e = 0

    //調用方法
    fetchGroupList(e);
    // console.log(e);
});

document.getElementById('pageSelect2').addEventListener('click', async function (e) {
    document.getElementById('pageSelect1').classList.remove("active");

    document.getElementById('pageSelect2').classList.add("active");

    document.getElementById('pageSelect3').classList.remove("active");

    e = 1;
    fetchGroupList(e);
    // console.log(e);
});

document.getElementById('pageSelect3').addEventListener('click', async function (e) {
    document.getElementById('pageSelect1').classList.remove("active");

    document.getElementById('pageSelect2').classList.remove("active");

    document.getElementById('pageSelect3').classList.add("active");

    e = 2;
    fetchGroupList(e);
    // console.log(e);
});

//=============== 控制分頁結束 =================


//=============== 以下為控制排序 =================
//控制時間排序
time_btn_el.addEventListener('click',async function(){
    amount_btn_count = 0; //重製按鈕
    time_btn_count++;
    // console.log(e);
    // console.log(time_btn_count);
    fetchGroupList(e, time_btn_count, amount_btn_count);
});

//控制金錢排序
amount_btn_el.addEventListener('click',async function(){
    time_btn_count = 0; //重製按鈕
    amount_btn_count++;
    // console.log(e);
    // console.log(time_btn_count);
    fetchGroupList(e, time_btn_count, amount_btn_count, name_btn_count);
});
//=============== 控制排序結束 =================

//=============== 以下為名稱搜尋 =================
name_btn_el.addEventListener('click',async function(event){
    event.preventDefault();
    time_btn_count = 0; //重製按鈕
    amount_btn_count = 0; //重製按鈕
    // name_btn_count++;
    let keywords = name_input_el.value;
    console.log(keywords);
    fetchGroupList(e, time_btn_count, amount_btn_count, name_btn_count, keywords);
})
//=============== 為名稱搜尋結束 =================

//=============== fetch揪團列表 =================

// 網頁載入後執行
document.addEventListener("DOMContentLoaded", function () {
    fetchGroupList(e);
});

//async : async function 宣告一個非同步函式，可以告訴function在最後回傳一個promise。
async function fetchGroupList(e, time_btn_count, amount_btn_count, name_btn_count, keywords) {
    
    //時間排序按鈕
    try {
        // await : await必須放在任何基於promise的函數之前，等到獲得resolve的資料後，再執行後續動作
        response = await fetch('http://localhost:8080/u-and-me/groupList/0/' + e);
        //控制揪團時間排序
        if(time_btn_count >= 1){
            if(time_btn_count % 2 === 0){
                response = await fetch('http://localhost:8080/u-and-me/groupList/byDeadlineDesc/0/' + e);
            } else if (time_btn_count % 2 !== 0) {
                response = await fetch('http://localhost:8080/u-and-me/groupList/byDeadline/0/' + e)
            }
        }
        
        //控制金額排序
        if(amount_btn_count >= 1){
            if(amount_btn_count % 2 !== 0){
                response = await fetch('http://localhost:8080/u-and-me/groupList/byAmountDesc/0/' + e);
            } else if (amount_btn_count % 2 === 0) {
                response = await fetch('http://localhost:8080/u-and-me/groupList/byAmount/0/' + e)
            }
        }

        //控制搜尋名稱
        // if(name_btn_count >= 1){
        //     response = await fetch('http://localhost:8080/u-and-me/groupList/name'+ keywords + '/0/' + e);
        // }

        //response.json()：把資料轉成JSON格式
        const groupsList = await response.json();

        //把資料清空
        const groupListInner_el = document.getElementById("groupListInner");
        groupListInner_el.innerHTML = "";

        groupsList.forEach(group => {

            //生成一個'div'
            let groups = document.createElement('div');
            //賦予div class 'col-4'
            groups.classList.add('col-4');

            let f = 0;
            let cover_id = 'cover' + f
            let title_id = 'title' + f
            let member_id = 'member' + f
            let day_id = 'day' + f
            let price_id = 'price' + f

            //由於後端傳進來的圖片是base64資料基於base64，須將base64轉換成image/png檔
            let dataurl = `data:image/png;base64,${group.cover}`

            //控制member顯示模式
            let member = parseInt(`${group.m}`, 10); //轉換JSON為INT
            if (member > 0) {
                member = `剩餘 <span style="color: red;"> ${group.m} </span> 人成團`;
            } else {
                member = `<span style="color: red;">已達出團人數但仍可報名</span>`
            }

            groups.innerHTML =
                `
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" src="${dataurl}"
                        id="${cover_id}" alt="..." />
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                            <!-- Product name-->
                            <h3 class="fw-bolder" id="${title_id}">${group.theme}</h3>
                            <br>
                            <!-- 尚缺人數成團-->
                            <span id="${member_id}">${member}</span>
                            <br>
                            <!-- 剩餘天數-->
                            揪團剩餘天數：<span id="${day_id}">${group.d}</span> 天
                            <br>
                            <!-- Product price-->
                            價格：<span style="color: blue;" id="${price_id}">${group.amount}</span> 元
                        </div>
                        </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#" onclick="window.location.href='http://localhost:8081/u-and-me/tmp/Front/group/groupMemo.html?gorupId=${group.group_Id}'">揪團詳情</a>
                                </div>
                            </div>
                        </div>
                    </div>
                `;

            //新增資料
            groupListInner_el.appendChild(groups);

            //f為控制每個列表id 若有需要可以用
            f += 1;
        });

    } catch (error) {
        console.error("Error fetching groupList:", error);
    }
}

//=============== fetch揪團列表結束 =================






//=============== 原本寫死的 =================

// 網頁載入後執行
// document.addEventListener("DOMContentLoaded", function () {
    
//     fetchGroupList(e);
// });

//async : async function 宣告一個非同步函式，可以告訴function在最後回傳一個promise。
// async function fetchGroupList(e) {
//     try {

//         let response = await fetch('http://localhost:8080/u-and-me/groupsList/0/' + e);

//         //response.json()：把資料轉成JSON格式
//         const groupsList = await response.json();

//         // const groupData = document.getElementById("groupData");
//         // groupData.innerHTML = "";
//         let title_el = document.getElementById("title1");
//         let member_el = document.getElementById("member1");
//         let day_el = document.getElementById("day1");
//         let price_el = document.getElementById("price1");
//         let cover_el = document.getElementById("cover1")

//         let n = 1; //定義n讓下面各id可以按順序增加
//         groupsList.forEach(group => {
//             title_el = document.getElementById("title" + n);
//             member_el = document.getElementById("member" + n);
//             day_el = document.getElementById("day" + n);
//             price_el = document.getElementById("price" + n);
//             cover_el = document.getElementById("cover" + n)

//             //由於後端傳進來的圖片是base64資料基於base64，須將base64轉換成image/png檔
//             let dataurl = `data:image/png;base64,${group.cover}`
//             cover_el.src = dataurl;

//             title_el.innerHTML = `${group.theme}`;

//             let member = parseInt(`${group.m}`, 10);
//             if (member > 0) {
//                 member_el.innerHTML = `剩餘 <span style="color: red;"> ${group.m} </span> 人成團`;
//             } else {
//                 member_el.innerHTML = `<span style="color: red;">已達出團人數但仍可報名</span>`
//             }

//             day_el.innerHTML = `${group.d}`;
//             price_el.innerHTML = `${group.amount}`;
//             n += 1;
//         });


//     } catch (error) {
//         console.error("Error fetching groupList:", error);
//     }
// }
//=============== 原本寫死的結束 =================