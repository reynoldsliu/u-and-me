$(function () {
  'use strict'
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  tooltipTriggerList.forEach(function (tooltipTriggerEl) {
    new bootstrap.Tooltip(tooltipTriggerEl)

    var dropdownToggleList = [].slice.call(document.querySelectorAll('[data-bs-toggle="dropdown"]'))
    dropdownToggleList.map(function (dropdownToggle) {
      return new bootstrap.Dropdown(dropdownToggle)
    });
  })


});

//綁定
// const qaTitle = document.getElementById("qaTitle");
// const addqaTitle = document.getElementById("addqaTitle");
// const errortitle = document.getElementById("errortitle");
// const qaCon = document.getElementById("qaCon");
// const addqaCon = document.getElementById("addqaCon");
// const errorcon = document.getElementById("errorcon");
// const qaState = document.getElementById("qaState");
// const addqaState = document.getElementById("addqaState");
// const qabutton = document.getElementById("qabutton");




// //點擊新增按鈕
// qabutton.addEventListener("click", function () {

//   //錯誤驗證
//   if (addqaTitle.value === null && addqaTitle.value.trim() === "") {
//     errortitle.style.display = inline;
//     return;
//   }

//   if (addqaCon.value.trim() === null && addqaCon.value.trim() === "") {
//     errorcon.style.display = inline;
//     return;
//   }



//   //送出物件
//   var baseUrl = window.location.protocol + "//" + window.location.host;

//   fetch(baseUrl + "/u-and-me/addqa", {
//     method: 'POST',
//     headers: { 'Content-Type :': 'application/json' },
//     body: JSON.stringify({
//       qaTitle: qaTitle.value,
//       qaCon: qaCon.value,
//       qaState: qaState.value
//     })

//   }).then(function (resp) {
//     return resp.json()

//   }).then(function (body) {
//     const { success } = body;
//     if (success) {
//       Swal.fire(
//         '新增成功',
//         'success'
//       )
//     } else {
//       Swal.fire(
//         '新增失敗',
//         'error'
//       )
//     }

//   }).catch(function (error) {
//     console.error(error);
//   })

// })






