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


function editReference(event) {
    event.preventDefault()
    const referenceEditForm = document.getElementById("referenceEditForm");
    const formData=new FormData(referenceEditForm)
    console.log(formData.get("id"))
    // const queryString = new URLSearchParams(new FormData(myForm)).toString();
    fetch("/referenceEdit.do", {
        method: "PUT",
        body:formData
    }).then(() => {
        document.location.replace("/referenceDisplay.do?id=" + formData.get("id"));
    });
}