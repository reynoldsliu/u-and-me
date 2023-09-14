const baseUrl = window.location.protocol + "//" + window.location.host + "/u-and-me/";



const ordId = document.getElementById('ordId');
const memName = document.getElementById('memName');
const ordTime = document.getElementById('ordTime');
const ordFee = document.getElementById('ordFee');
const total = document.getElementById('total');
const checktotal = document.getElementById('checktotal');
const points = document.getElementById('points');
//const checktotal = document.getElementById('checktotal');
const recipientName = document.getElementById('recipientName');
const recipientPhone = document.getElementById('recipientPhone');
const recipientAddr = document.getElementById('recipientAddr');
const check_el = document.getElementById('check');

let ordId_val;
let ordSta;
//<!--網頁載入後執行-->
document.addEventListener("DOMContentLoaded", async function () {
    // myOrderList();

    // 获取当前页面的URL
    var urlParams = new URLSearchParams(window.location.search);

    // 获取特定参数的值
    var OrdId = urlParams.get('ordId');

    getOrderDetail(OrdId);
    showProducts(OrdId);
    ordId_val = OrdId;
});

const productList = document.getElementById('productList');
async function showProducts(OrdId) {
    const response = await fetch(baseUrl + `OrderDetailOrdId/${OrdId}`);
    const orderDetailList = await response.json();
    orderDetailList.forEach(async (orderDetail) => {
        const response1 = await fetch(baseUrl + `product/listProductDetail/${orderDetail.id.prodId}`);
        const product = await response1.json();
        const productPicture = product.productPictures[0].prodPic;
        // const byteArray = productPicture; // 你的字节数组
        // console.log(byteArray);
        // const base64String = btoa(String.fromCharCode.apply(null, byteArray));

        let productPage = baseUrl + `product/prodtDetail.html?prodId=${product.prodId}`
        const row = document.createElement("tr");
        row.innerHTML = `
    <td style="width: 50px;text-align: center; vertical-align: middle;"><img src="data:image/jpeg;base64,${productPicture}" style=" width: 200px;height: 190px;object-fit: cover;"></td>
    <td style="width: 100px;text-align: center;vertical-align: middle;">${product.prodName}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orderDetail.prodQty}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orderDetail.prodPrice}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orderDetail.prodQty * orderDetail.prodPrice}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;"><button onclick="redirectToProdDetailPage(${product.prodId})">商品連結</button></td>
                         
    `;
        dataTableList.appendChild(row);
    });
}
function redirectToProdDetailPage(prodId) {
    var newPageUrl = baseUrl + `tmp/Front/shop/productDetail.html?prodId=${prodId}`;
    window.location.href = newPageUrl;
}

async function getOrderDetail(OrdId) {
    const response2 = await fetch(baseUrl + `member/getMemId`);
    const memberCheck = await response2.json();
    const response = await fetch(baseUrl + `Orders/ordId` + OrdId);
    const orderDetail = await response.json();
    console.log(memberCheck);
    if (memberCheck.memId == undefined || memberCheck.memId!=orderDetail.memId) {
        alert("此會員查無本單號" );
        return;
    }
    else {
        const response1 = await fetch(baseUrl + `member/getMemberByMemId/${orderDetail.memId}`);
        const member = await response1.json();

        switch(orderDetail.ordSta){
            case 0:
                check_el.innerText = '完成訂單';
                check_el.disabled = false;
                break;
            case 1:
                check_el.innerText = '已完成訂單';
                check_el.disabled = true;
                break;
        }
        ordId.innerText = OrdId;
        memName.innerText = member.memName;
        ordTime.innerText = orderDetail.ordTime;
        ordFee.innerText = orderDetail.ordFee;
        total.innerText = orderDetail.total;
        checktotal.innerText = orderDetail.checktotal + orderDetail.ordFee;
        // points.innerText = orderDetail.points;
        //checktotal = orderDetail.checktotal;
        recipientName.innerText = orderDetail.recipientName;
        recipientPhone.innerText = orderDetail.recipientPhone;
        recipientAddr.innerText = orderDetail.recipientAddr;
    }
}

async function myOrderList() {
    try {
        const response = await fetch(baseUrl + `OrderDetail/{ordId}/{prodId}`);
        const orderList = await response.json();
        
        const dataTableList = document.getElementById("dataTableList");
        dataTableList.innerHTML = "";

        orderList.forEach(myOrder => {
            const row = document.createElement("tr");
            row.innerHTML = `
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orders.ordId}</td>
    <td style="width: 130px;text-align: center;vertical-align: middle;">${formatDate(orders.ordTime)}</td>
    <td style="width: 100px;text-align: center;vertical-align: middle;">${orders.total}</td>
    <td style="width: 100px;text-align: center;vertical-align: middle;">${orders.ordFee}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orders.checktotal}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orders.recipientName}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orders.recipientPhone}</td>
    <td style="width: 50px;text-align: center; vertical-align: middle;">${orders.recipientAddr}</td>
    <td style="width: 65px;text-align: center;vertical-align: middle;">${statusMapping.get(orders.ordPaySta)}</td>
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

function checkOrder(){
    const data = {
        ordSta: 1
    }

    Swal.fire({
        icon: 'warning',
        title: '確認已收到物品了？',
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: '確認',
        cancelButtonText: "取消"
    }).then((result) => {
        if (result.isConfirmed) {
            fetch(baseUrl + 'orders/updSta/' + ordId_val,{
                headers: {
                    "content-type": "application/json",
                },
                method: 'PUT',
                body: JSON.stringify(data)
            }).catch(function (e) {
                Swal.fire({
                    icon: 'error',
                    title: '完成訂單失敗',
                    showCancelButton: true
                });
            });
            check_el.innerText = '已完成訂單';
            check_el.disabled = true;
            Swal.fire("已完成訂單", "success");
        }
    });
    
}