function showEditPerson(id) {
    document.location.replace("/personEdit.do?id=" + id);
}
async function remove(id) {
    alert(id);
    const response = await fetch("/api/person/" + id, {
        method: "DELETE"
    });
    document.location.replace("/person.do")
}
function editPerson(){
    const personEditForm = document.getElementById("personEditForm");
    const queryString = new URLSearchParams(new FormData(personEditForm)).toString();
    fetch("/personEdit.do?" + queryString, {
        method: "PUT"
    }).then(() => {
        document.location.replace("/profile.do");
    });
}