async function Login(Member member) {
    const response = await fetch("login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(member),
    });

    if (response.ok) {
        console.log("success");
        const token = await response.text();
        localStorage.setItem("token", token); // 将 Token 保存到 localStorage
        checkLoginStatus();
    } else {
        console.error("Login failed");
    }
}
