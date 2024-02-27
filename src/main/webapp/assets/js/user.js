function edit(id) {
    alert(id);
}

async function remove(username) {
    alert(username);
    const response = await fetch("/api/user/" + username, {
        method: "DELETE"
    });
    document.location.replace("/user.do")
}