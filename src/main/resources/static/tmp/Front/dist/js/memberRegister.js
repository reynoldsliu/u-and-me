async function register(username, password) {
    const response = await fetch("register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ username, password }),
    });

    if (response.ok) {
        const token = await response.text();
        localStorage.setItem("token", token); // 将 Token 保存到 localStorage
        checkLoginStatus();
    } else {
        console.error("Login failed");
    }
}
