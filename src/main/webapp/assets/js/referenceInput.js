let selectedListO=[]
const personRefEl=document.getElementById('person-ref-list')
const getReferences=async(e)=>{
    console.log('gg')
    const list=[
        {name:'parsa',family:'rajabi',user:1},
        {name:'parninan',family:'ahadzadeh',user:3},
        {name:'parninan',family:'ahadzadeh',user:2},
        {name:'parninan',family:'ahadzadeh',user:2},
        {name:'parninan',family:'ahadzadeh',user:2},
        {name:'parninan',family:'ahadzadeh',user:2},
        {name:'parninan',family:'ahadzadeh',user:2},
        
    ]

   
    personRefEl.innerHTML=''

    for(let person of list){
        personRefEl.innerHTML+=`<div  role="button" class="person-ref col-12 border-bottom p-1" onclick="setSelectedRefPerson(event,'${person.user}','${person.name}','${person.family}')">    <i class="fa fa-user col-1" aria-hidden="true"></i>
        <small class="col-11">${person.name} ${person.family}</small></div>`
    }

    
}
const setSelectedRefPerson=(e,userId,userName,userFamily)=>{
    e.stopPropagation()
    
    const selectedListE=document.getElementById('selected-list')
    console.log(selectedListO)
    if(selectedListO.includes(userId)){
        return 
        
    }
    
    
    selectedListE.innerHTML+=
`        <div class="rounded border p-1 d-flex justify-content-between  col-6">
            <input class="d-none" value="${userId}" name="users"/>
            <small>${userName} ${userFamily}</small>
            <i onclick="removeUser(event,'${userId}')" role="button" class="fa fa-window-close" aria-hidden="true"></i>
        </div>`
    personRefEl.innerHTML=''
    selectedListO.push(userId)

}
const removeUser=(e,userId)=>{
    console.log(e.target.parentNode)
    const target = e.target

    target.parentNode.innerHTML=""
    target.parentNode.remove()
    selectedListO.splice(selectedListO.indexOf(userId),1)

}
document.body.addEventListener('click',(e)=>{
    const personRefEl=document.getElementById('person-ref-list')
    personRefEl.innerHTML=''

})