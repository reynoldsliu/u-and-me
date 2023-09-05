
//<!--網頁載入後執行-->
document.addEventListener("DOMContentLoaded", function () {
    myOrderList();
});

async function myOrderList() {
    try {
        const response = await fetch(`http://localhost:8081/u-and-me/myOrders/memId${memId}/${page}`);
        const orderList = await response.json();

        const dataTableList = document.getElementById("dataTableList");
        dataTableList.innerHTML = "";

        orderList.forEach(myOrder => {
            const row = document.createElement("tr");
            row.innerHTML = `
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orders.ordId}</td>
    <td style="width: 130px;text-align: center;vertical-align: middle;">${formatDate(orders.ordTime)}</td>
    <td style="width: 100px;text-align: center;vertical-align: middle;">${orders.checktotal}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orders.recipientName}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orders.recipientPhone}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orders.recipientAddr}</td>
    <td style="width: 65px;text-align: center;vertical-align: middle;">${statusMapping.get(orders.ordSta)}</td>
//                        <td style="width: 65px;text-align: center;vertical-align: middle;">
        <button class="btn btn-outline-success" onclick="redirectToDetailPage(${orders.ordId})">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16">
                <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z" />
            </svg>
        </button>
    </td>
    `;
            dataTableList.appendChild(row);
        });

    } catch (error) {
        console.error("Error fetching order list:", error);
    }
}


function formatDate(dateString) {
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    return new Date(dateString).toLocaleDateString('zh-TW', options);
}

const statusMapping = new Map([
    [0, '未出貨'],
    [1, '已出貨'],
    [2, '已到貨'],
    [3, '訂單完成'],
    [4, '訂單取消'],
]);

// <!--按修改鈕會根據ordId跳轉到詳細內容頁面，並將資料映射到相關欄位上-->
function redirectToDetailPage(ordId) {
    var newPageUrl = `myOrder.html?ordId=${ordId}`;
    window.location.href = newPageUrl;
}


