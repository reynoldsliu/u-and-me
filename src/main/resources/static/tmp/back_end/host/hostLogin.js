    const loginBtn_el = document.getElementById("loginBtn");
    loginBtn_el.addEventListener("click", function () {
      const hostEmail = document.getElementById("hostEmail").value;
      const hostPassword = document.getElementById("hostPassword").value;
      const host = {
        "hostEmail": hostEmail,
        "hostPassword": hostPassword
      }

      Login(host);
//      alert("登入成功")
    })

    const testloginBtn_el = document.getElementById("testloginBtn");
    testloginBtn_el.addEventListener("click", async function () {
      const response = await fetch('http://localhost:8080/u-and-me/host/testlogin', {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        }
      });
      console.log(response);
    })
    const logoutBtn_el = document.getElementById("logoutBtn");
    logoutBtn_el.addEventListener("click", async function () {
      const response = await fetch('http://localhost:8080/u-and-me/host/hostLogout', {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        }
      });
      console.log(response);
    })




    Login = async function Login(host) {

      const response = await fetch("http://localhost:8080/u-and-me/host/hostLogin", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(host)
      });if (response.ok) {
                                      Swal.fire({
                                                     icon: 'success',
                                                     title: '管理員登入成功',
                                                     text: '',
                                                     confirmButtonText: '確定'
                                  })}else {
                                      alert("登入失敗，請再次嘗試");
                                  }
    }
