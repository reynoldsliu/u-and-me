            const baseUrl = window.location.protocol + "//" + window.location.host + "/u-and-me/";
            const loginBtn_el = document.getElementById("loginBtn");
            loginBtn_el.addEventListener("click", function () {
                const memEmail = document.getElementById("memEmail").value;
                const memPassword = document.getElementById("memPassword").value;
                const member = {
                    "memEmail": memEmail,
                    "memPassword": memPassword
                }

                Login(member);
//                alert("登入成功")
            })

            const testloginBtn_el = document.getElementById("testloginBtn");
            testloginBtn_el.addEventListener("click", async function () {
                const response = await fetch(baseUrl + 'member/testlogin', {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    }
                });
                console.log(response);
            })
            const logoutBtn_el = document.getElementById("logoutBtn");
            logoutBtn_el.addEventListener("click", async function () {
                const response = await fetch(baseUrl + 'member/logout', {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    }
                });
                console.log(response);
            })


            Login = async function Login(member) {
                // const member = {
                //     "memEmail": memEmail,
                //     "memPassword": memPassword
                // }
                const response = await fetch(baseUrl + "member/login", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify(member)
                }); if (response.ok) {
                             Swal.fire({
                                            icon: 'success',
                                            title: '登入成功',
                                            text: '',
                                            confirmButtonText: '確定'
                         })}else {
                             alert("登入失敗，請再次嘗試");
                         }

            }
