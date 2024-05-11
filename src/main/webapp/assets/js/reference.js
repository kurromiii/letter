function showEditReference(id) {
    document.location.replace("/referenceEdit.do?id=" + id);
}

function showLetter(id) {
    document.location.replace("/letterDisplay.do?id=" + id);
}

async function removeReference(id) {
    alert(id);
    const response = await fetch("/api/reference/" + id, {
        method: "DELETE"
    });
    document.location.replace("/letterBox.do")
}

function selectReference(id) {
    document.location.replace("/referenceDisplay.do?id=" + id);
}