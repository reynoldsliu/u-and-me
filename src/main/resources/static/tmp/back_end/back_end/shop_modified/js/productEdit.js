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

//表單中各欄位的元素id
const prodId_el = document.getElementById('prodId');
const prodName_el = document.getElementById('prodName');
const prodPri_el = document.getElementById('prodPri');
const prodCon_el = document.getElementById('prodCon');
const btnSubmit_el = document.getElementById('btnSubmit');
let prodPic_el = document.getElementById('prodPic');
let cover_img_el = document.getElementById('cover_img');
//用於紀錄原始數據
let cover;

//商品類別下拉選單
let prodCatId;
const prodCatId_el = document.getElementById('prodCatIdSelect');
prodCatId_el.addEventListener('change', prodCatIdChange)
function prodCatIdChange(){
   console.log(prodCatId_el.value);
   prodCatId = prodCatId_el.value;
}
// 上下架下拉選單
let prodSta;
const prodSta_el = document.getElementById('prodStaSelect');
prodSta_el.addEventListener('change', prodStaChange)
function prodStaChange(){
   console.log(prodSta_el.value);
   prodSta = prodSta_el.value;
}
//上下架按鈕
// const prodSta_el = document.getElementById('prodSta'); 
// let prodSta;
// const prodStaButtons_on_el = document.getElementById("prodStaButtons_on");
// const prodStaButtons_off_el = document.getElementById("prodStaButtons_off");
// const buttons = prodStaButtons.querySelectorAll("button");
// prodStaButtons_on_el.addEventListener('click',function(){
//     prodSta = 1;
    
//     // 添加 active 類別到上架按鈕，移除 active 類別從下架按鈕
//     prodStaButtons_on_el.classList.add('active');
//     prodStaButtons_off_el.classList.remove('active');
// });

// prodStaButtons_off_el.addEventListener('click',function(){
//     prodSta = 0;
//     // 添加 active 類別到下架按鈕，移除 active 類別從上架按鈕
//     prodStaButtons_off_el.classList.add('active');
//     prodStaButtons_on_el.classList.remove('active');
// });



// ==================使用到的元素結束==================

const baseUrl = window.location.protocol + "//" + window.location.host + "/u-and-me/";

//取得單筆商品資料
async function fetchListProductDetail(){
  try{
      const resp = await fetch(`${baseUrl}product/listProductDetail/${prodId}`);
      const productDetail = await resp.json();
      console.log(productDetail);
    
    //無選擇新圖片，cover保持舊的圖片數據
    const dataurl = `data:image/jpeg;base64,${productDetail.prodPic}`;
    cover = productDetail.prodPic;

    //將商品詳細資訊放進輸入框中
    //prodId readonly
    prodId_el.value = productDetail.prodId;
    prodCatId_el.value = productDetail.prodCatId;
    prodName_el.value = productDetail.prodName;
    prodCon_el.value = productDetail.prodCon;
    prodPri_el.value = productDetail.prodPri;
    prodSta_el.value = productDetail.prodSta;
    // prodSta.value = productDetail.prodSta;
    cover_img_el.src = dataurl;


  }catch(error){
    console.error('Error fetching product detail:', error);
  }
}

//網頁載入完成後執行
document.addEventListener('DOMContentLoaded',function() {

  console.log(prodId);
  fetchListProductDetail(); 

  //選擇圖片時觸發事件
  const prodPic_el = document.getElementById('prodPic');
  const cover_img_el = document.getElementById('cover_img');

  prodPic_el.addEventListener('change', changePicture);
  function changePicture(){
    const id = this.id;
    const files = this.files;
    const img = document.getElementById("cover_img");

    //1. 取得File物件
    prodPic = files[0];
    img.src = URL.createObjectURL(prodPic);

    //2. 實例化FileReader物件
    const fileReader = new FileReader();

    //3. 替FileReader物件 註冊 載入監聽器
    fileReader.onload = async event => {
        //4. 轉成Base64字串
        prodPic = btoa(event.target.result);
    }
    //5. 開始讀取檔案
    fileReader.readAsBinaryString(prodPic);
  }


  //   //透過this關鍵字來引用觸發事件的元素即上傳圖片的prodPic_el
  //   //files 是文件上傳輸入框的屬性，取第一個文件
  //   const file = this.files[0]
  //   if(file){
  //     //URL.createObjectURL(file)創建一個臨時的URL，指用戶選擇的文件，將圖片顯示在img元素中
  //     cover_img_el.src = URL.createObjectURL(file);
  //     //創建一個FileReader對象，用於讀取文件的內容
  //     const fileReader = new FileReader();
  //     //當文件加載/讀取完成，將執行event以下的程式
  //     fileReader.onload = event => {
  //       cover = bota(event.target.result);
  //     };
  //     //將文件內容讀取為二進位字符串
  //     fileReader.readAsBinaryString(file);
  //   }else {
  //     //如果未選擇文件，將清空原先顯示的圖像為空白
  //     cover_img_el.src = "";
  //   }
  // });

});

//按下確認修改按鈕時觸發
btnSubmit_el.addEventListener('click', async function(event){
    Swal.fire({
      icon: 'question',
      title: '確認',
      text: '確定更新此商品？',
      confirmButtonText: '確定',
      showCancelButton: true,
      cancelButtonText: '取消'
  }).then((result) => {
    if (result.isConfirmed) {
        window.location.href = 'productList.html';
    }
  });

  //將要傳遞的資料包裝成一個物件
  const send_data = {
    prodName: prodName_el.value,
    prodSta: prodSta_el.value,
    prodCatId: prodCatId_el.value,
    prodPri: prodPri_el.value,
    prodCon: prodCon_el.value,
    prodPic: prodPic
  };
//檢查cover_img_el是否有值，如果有選擇圖片，則更新prodPic
  if(cover){
    send_data.prodPic = cover;
  }

  try{
    const resp = await fetch (`${baseUrl}product/updateProduct/${prodId}`,{
      method: 'PUT',
      headers: {'Content-Type': 'application/json'},
      //將數據對象轉換為可在請求主體中傳輸的JSON字符串
      body: JSON.stringify(send_data)
    });
    
    if(resp.ok){
      const updatedProductData = await resp.json();
      
  } else {
    console.error('Failed to update product.');
  }
  } catch (error) {
  console.error('Error to update product.', error);
  }

  });
