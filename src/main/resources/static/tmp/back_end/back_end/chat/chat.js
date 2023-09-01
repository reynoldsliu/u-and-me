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
  // findbyall();

});
//查詢所有的QA編號
function findqalist() {
  var baseUrl = window.location.protocol + "//" + window.location.host;
  $.ajax({
    url: baseUrl + "/u-and-me/qas",
    contentType: 'application/json; charset=UTF-8',
    data: {},
    dataType: "json",
    success: function (data) {
      // 使用 jQuery Table 來動態生成表格
      $('#qatable').DataTable({
        data: data,
        searching: true,
        searchDelay: 500,
        columns: [
          { data: 'qaId' },
          { data: 'qaTitle' },
          { data: 'qaState' },
          { data: 'qaCreatedTime' },
          { data: 'qaLastUpdatedTime' },
          { data: null }
        ], columnDefs: [
          {
            targets: [0], // 第一欄
            width: "50px"
          },
          {
            targets: [1],
            render: function (data, type ,row) {
              $(document).on("click", `a.qalink${row.qaId}`, function () {
                
                if(row.qaState === 0){
                  row.qaState = '下架';
                }else if(row.qaState === 1){
                  row.qaState = '上架';
                }

                Swal.fire({
                  title:'<span> 檢視QA資料 </span><hr>',
                  html: `
                  <div class="oneqa">
                    <div class="oneqa">QA編號 :  <span>${row.qaId}</span></div>
                    <div class="oneqa">標題 :  <span>${row.qaTitle}</span></div>
                    <div class="oneqa">內容 :  <br><span>${row.qaCon}</span></div>
                    <div class="oneqa">狀態 :  <span>${row.qaState}</span></div>
                    <div class="oneqa">建立時間 :  <span>${row.qaCreatedTime}</span></div>
                    <div class="oneqa">最後編輯時間 :  <span>${row.qaLastUpdatedTime}</span></div>
                  </div>
                  `,
                  confirmButtonText: '確認'

                })
              });
              return `<a class="link-primary qalink${row.qaId}" >` + data + '</a>'
            }
          },
          {
            targets: [2],
            render: function (data) {
              if (data === 0) {
                return '下架'
              } else {
                return '上架'
              }
            }
          },
          {
            targets: [5],
            render: function () {
              return '<button type="button" class="btn btn-primary btn-sm">編輯</button> ' +
                '<button type="button" class="btn btn-danger btn-sm">刪除</button>'
            }
          }, {
            targets: '_all',
            className: 'text-center'
          }
        ], language: {
          url: "https://cdn.datatables.net/plug-ins/1.11.3/i18n/zh_Hant.json"
        }
      });
    },
    error: function () {
      alert('Failed to fetch data from server.');
    }
  });
}
