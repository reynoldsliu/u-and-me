async function Register(host) {
    const response = await fetch("http://localhost:8080/u-and-me/host/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(host)
    });

    if (response.ok) {
        Swal.fire({
                       icon: 'success',
                       title: '管理員新增成功',
                       text: '',
                       confirmButtonText: '確定'
    })}else {
        alert("管理員新增失敗，請再次嘗試");
    }
}

const regBtn_el = document.getElementById("regButton");
regBtn_el.addEventListener("click", function() {

    const hostEmail = document.getElementById("hostEmail").value;
    const hostPassword = document.getElementById("hostPassword").value;
    const hostName = document.getElementById("hostName").value;
    const hostPhone = document.getElementById("hostPhone").value;




    const host = {
        "hostEmail": hostEmail,
        "hostPassword": hostPassword,
        "hostName": hostName,
        "hostPhone": hostPhone


    };

    Register(host);
});