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

        let n = 1;
        groupsList.forEach(group => {
            title_el = document.getElementById("title" + n);
            member_el = document.getElementById("member" + n);
            day_el = document.getElementById("day" + n);
            price_el = document.getElementById("price" + n);
            title_el.innerHTML = `${group.theme}`;
            member_el.innerHTML = `${group.m}`;
            day_el.innerHTML = `${group.d}`;
            price_el.innerHTML = `${group.amount}`;
            n += 1;
        });






    } catch (error) {
        console.error("Error fetching groupList:", error);
    }
}

