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
  findbyall();

});

//查詢所有的QA編號
function findqalist() {
  var baseUrl = window.location.protocol + "//" + window.location.host;
  let i = 0;
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
        columns: [  //物件包裝陣列
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
            render: function (data, type, row) {
              i++;
              return `<a class="link-primary qalink${i}">` + data + '</a>'
            }
          },
          {
            targets: [2],
            render: function (data, type, row) {
              if (data === 0) {
                return '下架'
              } else {
                return '上架'
              }
            }
          },
          {
            targets: 5,
            render: function (data, type, row) {
              return '<button type="button" class="btn btn-primary btn-sm">編輯</button> ' +
                '<button type="button" class="btn btn-danger btn-sm">刪除</button>'
            }
          }, {
            targets: '_all',
            className: 'text-center'
          }
        ],
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



let qa;

function findbyall() {

  var baseUrl = window.location.protocol + "//" + window.location.host;

  fetch(baseUrl + "/u-and-me/qas")  //抓後端Controller的路徑
    .then(function (resp) {
      return resp.json() //要求json檔的資料
    }).then(function (data) {

      qa = data;

    }
    ).catch(function (error) {
      console.log(error);
    })

}

/*****尚未成功*******/
// let qa1 = JSON.stringify(qa);
// //跳出檢視單一筆資料的視窗
// for (let i = 1; i <= qa1.data.length; i++) {
//   $(document).on('click', `a.qalink${i}`, function () {

//     let qaItem = qa.find(function (i) {
//       return i.qaId === index;
//     })

//     if (qaItem) {
//       Swal.fire({
//         title: '檢視QA資料',
//         html: `
//             <div>
//               <div>QA編號 :<span>${qaItem.qaId}</span></div>
//               <div>標題 :<span>${qaItem.qaTitle}</span></div>
//               <div>內容 :<span>${qaItem.qaCon}</span></div>
//               <div>狀態 :<span>${qaItem.qaState}</span></div>
//               <div>建立時間 :<span>${qaItem.qaCreatedTime}</span></div>
//               <div>最後編輯時間 :<span>${qaItem.qaLastUpdatedTime}</span></div>
//            </div>
//             `,
//         confirmButtonText: '確認'
//       })
//     }
//   })
// }

// $(document).on("click", 'a.qalink', function () {

  // $.each(qa, (qa1,val) => {
  //   Swal.fire({
  //     title: '檢視QA資料',
  //     html: `
  //       <div>
  //         <div>QA編號 :<span>${val.qaId}</span></div>
  //         <div>標題 :<span>${val.qaTitle}</span></div>
  //         <div>內容 :<span>${val.qaCon}</span></div>
  //         <div>狀態 :<span>${val.qaState}</span></div>
  //         <div>建立時間 :<span>${val.qaCreatedTime}</span></div>
  //         <div>最後編輯時間 :<span>${val.qaLastUpdatedTime}</span></div>
  //      </div>
  //       `,
  //     confirmButtonText: '確認'
  //   })
  // })

// })
