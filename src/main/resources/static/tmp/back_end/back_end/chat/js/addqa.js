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

//綁定
let qaTitle_val = document.querySelector("#addqaTitle");
let errortitle = document.getElementById("errortitle");

let qaCon_val = document.querySelector("#addqaCon");
let errorcon = document.getElementById("errorcon");

let qaState_val = document.querySelector("#addqaState");
let qabutton = document.getElementById("qabutton");
var baseUrl = window.location.protocol + "//" + window.location.host;

//點擊新增按鈕
qabutton.addEventListener("click", function () {

  //錯誤驗證
  if (qaTitle_val.value.trim() === "") {
    errortitle.innerHTML = '文章標題不可空白!';
    return;
  }
  if (qaCon_val.value.trim() === "") {
    errorcon.innerHTML = '文章內容不可空白!';
    return;
  }

  //送出物件
  fetch('/u-and-me/add/qa', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      qaTitle: qaTitle_val.value,
      qaCon: qaCon_val.value,
      qaState: qaState_val.value
    })
  }).catch(function () {
    Swal.fire({
      title: '新增失敗',
      icon: 'error'
    })

  })
  Swal.fire({
    title: '新增成功',
    icon: 'success'
  }).then(function () {
    window.location.href = baseUrl + "/u-and-me/tmp/back_end/back_end/chat/qa.html";
  })

})


