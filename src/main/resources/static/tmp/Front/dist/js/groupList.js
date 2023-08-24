// 網頁載入後執行
document.addEventListener("DOMContentLoaded", function () {
    fetchGroupList();
});

//async : async function 宣告一個非同步函式，可以告訴function在最後回傳一個promise。
async function fetchGroupList() {
    try {
        // await : await必須放在任何基於promise的函數之前，等到獲得resolve的資料後，再執行後續動作
        const response = await fetch('http://localhost:8080/u-and-me/groupsList/0/0');

        //response.json()：把資料轉成JSON格式
        const groupsList = await response.json();

        // const groupData = document.getElementById("groupData");
        // groupData.innerHTML = "";
        let title_el = document.getElementById("title1");
        let member_el = document.getElementById("member1");
        let day_el = document.getElementById("day1");
        let price_el = document.getElementById("price1");
        let cover_el = document.getElementById("cover1")

        let n = 1; //定義n讓下面各id可以按順序增加
        groupsList.forEach(group => {
            title_el = document.getElementById("title" + n);
            member_el = document.getElementById("member" + n);
            day_el = document.getElementById("day" + n);
            price_el = document.getElementById("price" + n);
            cover_el = document.getElementById("cover" + n)

            let dataurl = `data:image/png;base64,${group.cover}`
            cover_el.src = dataurl;

            title_el.innerHTML = `${group.theme}`;

            let member = parseInt(`${group.m}`, 10);
            if (member > 0) {
                member_el.innerHTML = `剩餘 <span style="color: red;"> ${group.m} </span> 人成團`;
            } else {
                member_el.innerHTML = `<span style="color: red;">已達出團人數但仍可報名</span>`
            }

            day_el.innerHTML = `${group.d}`;
            price_el.innerHTML = `${group.amount}`;
            n += 1;
        });





    } catch (error) {
        console.error("Error fetching groupList:", error);
    }
}

// // 網頁載入後執行
// document.addEventListener("DOMContentLoaded", function () {
//     fetchGroupList();
// });

// //async : async function 宣告一個非同步函式，可以告訴function在最後回傳一個promise。
// async function fetchGroupList() {
//     try {
//         // await : await必須放在任何基於promise的函數之前，等到獲得resolve的資料後，再執行後續動作
//         const response = await fetch('http://localhost:8080/u-and-me/groupsList/0/0');

//         //response.json()：把資料轉成JSON格式
//         const groupsList = await response.json();

//         // const groupData = document.getElementById("groupData");
//         // groupData.innerHTML = "";
//         let title_el = document.getElementById("title1");
//         let member_el = document.getElementById("member1");
//         let day_el = document.getElementById("day1");
//         let price_el = document.getElementById("price1");
//         const groupListInner_el = document.getElementById("groupListInner");

//         let n = 1;
//         groupsList.forEach(group => {
//             title_el = document.getElementById("title" + n);
//             member_el = document.getElementById("member" + n);
//             day_el = document.getElementById("day" + n);
//             price_el = document.getElementById("price" + n);

//             groupListInner_el.innerHTML =
//                 `
//                     <div class="col-4">
//                         <div class="card h-100">
//                         <!-- Product image-->
//                         <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg"
//                             alt="..." />
//                         <!-- Product details-->
//                         <div class="card-body p-4">
//                             <div class="text-center">
//                             <!-- Product name-->
//                             <h3 class="fw-bolder" id="${title_el}"></h3>
//                             <br>
//                             <!-- 尚缺人數成團-->
//                             <span id="${member_el}"></span>
//                             <br>
//                             <!-- 剩餘天數-->
//                             揪團剩餘天數：<span id="${day_el}"></span> 天
//                             <br>
//                             <!-- Product price-->
//                             價格：<span style="color: blue;" id="${price_el}"></span> 元
//                         </div>
//                         </div>
//                             <!-- Product actions-->
//                             <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
//                                 <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">揪團詳情</a>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                 `
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
