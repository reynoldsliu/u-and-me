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

    const urlParams = new URLSearchParams(window.location.search);
    const qaId = urlParams.get('qaId');
    findByQaId(qaId);
    
})()

//綁定
let qaTitle = document.getElementById("qaTitle");
let qaTitle_val = document.querySelector("#addqaTitle");
let errortitle = document.getElementById("errortitle");

let qaCon = document.getElementById("qaCon");
let qaCon_val = document.querySelector("#addqaCon");
let errorcon = document.getElementById("errorcon");

let qaState = document.getElementById("qaState");
let qaState_val = document.querySelector("#addqaState");
let qabutton = document.getElementById("qabutton");


function findByQaId(qaId) {
    var baseUrl = window.location.protocol + "//" + window.location.host;
    fetch(baseUrl + `/u-and-me/qas/${qaId}`)
        .then(function (resp) {
            return resp.json()
        })
        .then(function (data) {

            qaTitle_val.value = data.qaTitle,
            qaCon_val.value = data.qaCon,
            qaState_val.value = data.qaState

        }).catch(function (error) {
            console.error(error);
        })
}


qabutton.addEventListener("click", function () {

    const urlParams = new URLSearchParams(window.location.search);
    const qaId = urlParams.get('qaId');
    var baseUrl = window.location.protocol + "//" + window.location.host;

    fetch(baseUrl + `/u-and-me/updqa/${qaId}`, {
        method: 'Put',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            qaTitle: qaTitle_val.value,
            qaCon: qaCon_val.value,
            qaState: qaState_val.value
        })
    }).catch(function () {
        Swal.fire({
            title: '更新失敗',
            icon: 'error'
        })

    })
    Swal.fire({
        title: '更新成功',
        icon: 'success'
    }).then(function () {
        window.location.href = baseUrl + "/u-and-me/tmp/back_end/back_end/chat/qa.html";
    })


})




