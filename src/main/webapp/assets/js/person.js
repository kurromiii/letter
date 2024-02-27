function edit(id) {
    alert(id);
}

async function remove(id) {
    alert(id);
    const response = await fetch("/api/person/" + id, {
        method: "DELETE"
    });
    document.location.replace("/person.do")
}