//全局變數
let detailId = '';

//元素
const baseUrl = window.location.protocol + "//" + window.location.host + "/u-and-me";
const bank_el = document.getElementById('bank');
const bankContent_el = document.getElementById('bankContent');
const reason_el = document.getElementById('reason');
const account_el = document.getElementById('account');
const btn_submit_el = document.getElementById('btn_submit');

window.addEventListener('load', function(e){

    //取得網址列detailId
    let url = location.href;

    if(url.indexOf('?') != -1){

        let ary1 = url.split('?');

        let ary2 = ary1[1].split('=');

        detailId = ary2[1];
    }

    bankContent_el.value = bank_el.value;
});

bank_el.addEventListener('change', function(e){
    bankContent_el.value = bank_el.value;
    console.log(account_el.value);
});

btn_submit_el.addEventListener('click', async function(e){
    e.preventDefault();

    const data = {
        account: bankContent_el.value + '-' + account_el.value.trim(),
        reason: reason_el.value,
    }

    await fetch(baseUrl + '/memberDetail/' + detailId, {
        headers: {
            "content-type": "application/json",
        },
        method: 'PUT',
        body: JSON.stringify(data)
    }).catch(function (e){
        Swal.fire({
            icon: 'error',
            title: '退款申請失敗',
            showCancelButton: true
          })
    })

    Swal.fire({
        icon: 'success',
        title: '退款申請成功',
        text: '已提交退款申請',
        showCancelButton: true
      })

})