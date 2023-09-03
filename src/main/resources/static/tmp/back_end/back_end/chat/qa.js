/* global bootstrap: false */
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

  findqalist();

});


//查詢所有的QA編號
function findqalist() {
  var baseUrl = window.location.protocol + "//" + window.location.host;
  //ajax區塊
  $.ajax({
    url: baseUrl + "/u-and-me/qas", //請求動態網址
    contentType: 'application/json; charset=UTF-8',
    data: {}, //請求獲取全部無參數
    dataType: "json",
    success: function (data) {
      // 綁定tableId，使用 jQuery Table 來動態生成表格
      $('#qatable').DataTable({
        //抓取請求的資料
        data: data,
        //搜尋欄位是否開啟及設定
        searching: true,
        searchDelay: 500,
        //資料欄位區塊(columns)
        columns: [
          { data: 'qaId' },               // targets[0]
          { data: 'qaTitle' },            // targets[1]
          { data: 'qaState' },            // targets[2]
          { data: 'qaCreatedTime' },      // targets[3]
          { data: 'qaLastUpdatedTime' },  // targets[4]
          { data: null }                  // targets[5] 操作欄位
        ],
        // 欄位元素定義區塊(columnDefs)，依需求決定內容可加可不加。
        columnDefs: [
          {
            //調整th:qaId欄位的寬度
            targets: [0],
            width: "50px"
          },{
            targets: [1],
            render: function (data, type, row) {
              //點擊qaTitle跳出檢視單筆資料視窗。
              $(document).on("click", `a.qalink${row.qaId}`, function () {

                //將qaState值改成中文顯示，狀態 = 0:下架、1:上架。
                if (row.qaState === 0) {
                  row.qaState = '下架';
                } else if (row.qaState === 1) {
                  row.qaState = '上架';
                }

                //彈跳視窗抓取單筆值。
                Swal.fire({
                  title: '<span> 檢視QA資料 </span><hr>',
                  html: `
                  <div class="oneqa">
                    <div class="oneqa">QA編號 :  <span>${row.qaId}</span></div>
                    <div class="oneqa">標題 :  <span>${row.qaTitle}</span></div>
                    <div class="oneqa">內容 :  <br><span>${row.qaCon}</span></div>
                    <div class="oneqa">狀態 :  <span class="state">${row.qaState}</span></div>
                    <div class="oneqa">建立時間 :  <span>${row.qaCreatedTime}</span></div>
                    <div class="oneqa">最後編輯時間 :  <span>${row.qaLastUpdatedTime}</span></div>
                  </div>
                  `,
                  confirmButtonText: '確認'
                })

              });
              return `<a class="link-primary qalink${row.qaId}" >` + data + '</a>'
            }
          },{
            //將qaState值改成中文顯示，狀態 = 0:下架、1:上架。
            targets: [2],
            render: function (data) {
              if (data === 0) {
                return '下架'
              } else {
                return '上架'
              }
            }
          },{
            //在操作欄位回傳按鈕。
            targets: [5],
            render: function () {
              return '<button type="button" class="btn btn-primary btn-sm">編輯</button> ' +
                '<button type="button" class="btn btn-danger btn-sm">刪除</button>'
            }
          },{
            //將全部欄位的字置中。
            targets: '_all',
            className: 'text-center'
          }
        ],
        //語言區塊:將預設英文配置改成中文顯示。
        language: {
          url: "https://cdn.datatables.net/plug-ins/1.11.3/i18n/zh_Hant.json"
        }
      });
    },
    error: function () {
      alert('Failed to fetch data from server.');
    }
  });
}

