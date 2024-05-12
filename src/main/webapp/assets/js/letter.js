function showEditLetter(id) {
    document.location.replace("/letterEdit.do?id=" + id);
}

async function removeLetter(id) {
    alert(id);
    const response = await fetch("/api/letter/" + id, {
        method: "DELETE"
    });
    document.location.replace("/letterBox.do")
}
function reference(id) {
    document.location.replace("/reference.do?letterIdRef=" + id);
}

function editLetter(event) {
    event.preventDefault()
    const letterEditForm = document.getElementById("letterEditForm");
    const formData=new FormData(letterEditForm)
    console.log(formData.get("id"))
    // const queryString = new URLSearchParams(new FormData(myForm)).toString();
    fetch("/letterEdit.do", {
        method: "PUT",
        body:formData
    }).then(() => {
        document.location.replace("/letterDisplay.do?id=" + formData.get("id"));
    });
}

function selectLetter(id) {
    document.location.replace("/letterDisplay.do?id=" + id);
}