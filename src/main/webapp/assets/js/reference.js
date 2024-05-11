function edit(id) {
    document.location.replace("/referenceEdit.do?id=" + id);
}

function showLetter(id) {
    document.location.replace("/letterDisplay.do?id=" + id);
}

async function remove(id) {
    alert(id);
    const response = await fetch("/api/reference/" + id, {
        method: "DELETE"
    });
    document.location.replace("/letterBox.do")
}