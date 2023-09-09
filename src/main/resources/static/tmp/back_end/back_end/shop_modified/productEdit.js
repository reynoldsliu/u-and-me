/* global bootstrap: false */
(function () {
  'use strict'
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  tooltipTriggerList.forEach(function (tooltipTriggerEl) {
    new bootstrap.Tooltip(tooltipTriggerEl)

    var dropdownToggleList = [].slice.call(document.querySelectorAll('[data-bs-toggle="dropdown"]'))
    dropdownToggleList.map(function (dropdownToggle) {
      return new bootstrap.Dropdown(dropdownToggle)
    });
    



  })
})()

//取得查詢prodId的值
const urlParams = new URLSearchParams(window.location.search);
const prodId = urlParams.get('prodId');

//表單中各輸入框的元素
const prodName_el = document.querySelector('#prodName');
const prodPri_el = document.querySelector('#prodPri');
const prodCon_el = document.querySelector('#prodCon');
const btnSubmit_el = document.querySelector('#btnSubmit')
let prodPic_el = document.getElementById("prodPic");
let cover_img_el = document.getElementById("cover_img");

let prodCatId;
const prodCatId_el = document.getElementById('prodCatIdSelect');
prodCatId_el.addEventListener('change', prodCatIdChange)
function prodCatIdChange(){
   console.log(prodCatId_el.value);
   prodCatId = prodCatId_el.value;
}

let prodSta;
const prodStaButtons_on_el = document.getElementById("prodStaButtons_on");
const prodStaButtons_off_el = document.getElementById("prodStaButtons_off");
const buttons = prodStaButtons.querySelectorAll("button");
prodStaButtons_on_el.addEventListener('click',function(){
    prodSta = 1;
})
prodStaButtons_off_el.addEventListener('click',function(){
    prodSta = 0;
})

// ==================使用到的元素結束==================

const baseUrl = window.location.protocol + "//" + window.location.host + "/u-and-me/";

//取得單筆商品資料
async function fetchListProductDetail(){
  try{
    const resp = await fetch(`${baseUrl}listProductDetail/${prodId}`);
    const productDetail = await resp.json();
    
    //無選擇新圖片，cover_img_el保持舊的圖片數據
    const dataurl = `data:Image/jpeg;base64,${data.prodPic}"`;
    cover_img_el = productDetail.prodPic;

    //將商品詳細資訊放進輸入框中
    prodName_el.value = productDetail.prodName;
    prodSta.value = productDetail.prodSta;
    prodCatId_el.value = productDetail.prodCatId;
    prodPri_el.value = productDetail.prodPri;
    prodCon_el.value = productDetail.prodCon
    cover_img_el.src = dataurl;


  }catch(error){
    console.error('Error fetching product detail:', error);
  }
}

//網頁載入完成後執行
document.addEventListener('DOMContentLoaded',function() {
  fetchListProductDetail(); 

  //選擇圖片時觸發事件

  const prodPic_el = document.getElementById('prodPic');
  const cover_img = document.getElementById('cover_img');

  prodPic_el.addEventListener('change', function(){
    //透過this關鍵字來引用觸發事件的元素即prodPic_el
    //files 是文件上傳輸入框的屬性，取第一個文件
    const file = this.files[0]
    if(file){
      //URL.createObjectURL(file)創建一個臨時的URL，指用戶選擇的文件，將圖片顯示在img元素中
      cover_img.src = URL.createObjectURL(file);
      //創建一個FileReader對象，用於讀取文件的內容
      const fileReader = new FileReader();
      //當文件加載/讀取完成，將執行event以下的程式
      fileReader.onload = event => {
        cover = bota(event.target.result);
      };
      //將文件內容讀取為二進位字符串
      fileReader.readAsBinaryString(file);
    }else {
      //如果未選擇文件，將清空原先顯示的圖像為空白
      cover_img.src = "";
    }
  });

})

//按下確認修改按鈕時觸發
btnSubmit_el.addEventListener('click', async function(event){

  //將資料包裝成一個物件
  const send_data = {
    prodId: prodId,
    prodName: prodName_el.value,
    prodSta: prodSta,
    prodCatId: prodCatId_el.value,
    prodPri: prodPri_el.value,
    prodCon: prodCon_el.value,
    prodPic: base64Str
};
//檢查cover_img_el是否有值，如果有選擇圖片，則更新prodPic
if(cover_img_el){
  requsetData.prodPic = cover_img_el;
}

try{
  const response = await fetch (`${baseUrl}product/updateProduct/${prodId}`,{
    method: 'PUT',
    headers: {'Content-Type': 'application/json'},
    //將數據對象轉換為可在請求主體中傳輸的JSON字符串
    body: JSON.stringify(requsetData)
  });
  
  if(resp.ok){
    const updatedProductData = await resp.json();

    Swal.fire({
      icon: 'success',
      title: '更新成功',
      text: '',
      confirmButtonText: '確定'
  }).then((result) => {
    if (result.isConfirmed) {
        window.location.href = 'html';
    }
});
} else {
  console.error('Failed to update product.');
}
} catch (error) {
console.error('Error to update product.', error);
}

});
