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

(()=>{
    const btn1 = document.querySelector('#btn1');
    const prodname = document.querySelector('#prodname');
    const prodconTextarea = document.getElementById('prodcon');

    const buttons =document.querySelectorAll('.btn.btn-primary');
    buttons.forEach(button =>{
        const id=button.getAttribute('stadata-id');
    })

    const selectElement = document.querySelector('.form-select');
    const selectedOption = selectElement.options[selectElement.selectedIndex];
    const categoryId = selectedOption.value;
    const categoryName = selectedOption.textContent;

    const prodpri =document.querySelector('#prodpri');


   const fileInput = document.getElementById('fileInput');
   const previewImg = document.getElementById('previewPic');

   fileInput.addEventListener('change', function(event) {
       const selectedFile = event.target.files[0];

       if (selectedFile) {
           previewPic.style.display = 'block';
           previewPic.src = URL.createObjectURL(selectedFile);
           // 在这里可以使用 fetch 等操作将文件上传到后端
       } else {
           previewPic.style.display = 'none';
       }
   });




    // 示例：当用户点击提交按钮时调用 sendDataToBackend 函数
    submitButton.addEventListener('click', sendDataToBackend);

    init();

      function init() {
        btn1.addEventListener('click', shopback);

        fetch(`shopback`/${})
            .then(res => resp.json())
            .then(body =>{
            prodname.value = body['prodname'];
            prodcon.textContent = body['prodcon'];

            const picBinaryStr = atob(body['image']);
            let len = picBinaryStr.length;
            const uint8Array = new Uint8Array(len);
            while (len--) {
             uint8Array[len] = picBinaryStr.charCodeAt(len);
             }
             const blob = new Blob([uint8Array]);
             previewPic.src = URL.createObjectURL(blob);
             });


            })
            }



      function requestShopback(picBase64){
        fetch('shopback',{
            method:'PUT',
            headers:{
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
            prodpic: picBase64
            }),
        })
        .then(resp => resp.json())
        .then(body =>{
        });
      }

          // 在合适的时机使用 Fetch 操作
          function sendDataToBackend() {
              const prodcon = prodconTextarea.value;
              // 在这里可以使用 fetch 等操作将商品详细信息发送到后端
              const requestData = {
                 prodcon: prodcon,
                 prodname: prodname,
                 prodpri: prodpri
              };
              fetch('shopback',{
                  method: 'POST',
                  headers: {
                      'Content-Type': 'application/json'
                  },
                  body: JSON.stringify(requestData),
              })
              .then(resp => resp.json())
              .then(body =>{
              })
              .catch(error =>){
                  console.error('Error', error);
              }
          }
})


