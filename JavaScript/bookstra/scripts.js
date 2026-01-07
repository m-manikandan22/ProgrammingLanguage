// selecting popup-box popup-overlay button

let popupOverlay = document.querySelector(".popup-overlay")
let popupBox = document.querySelector(".popup-box")
let addPoUpButton = document.getElementById("add-popup-button")

addPoUpButton.addEventListener("click",function(){
    popupOverlay.style.display="block";
    popupBox.style.display="block";
})


// select cancel button

let cancelPopUp = document.getElementById("cancel-popup")

cancelPopUp.addEventListener("click",function(event){
    event.preventDefault()
    popupOverlay.style.display="none";
    popupBox.style.display="none";
})

// select container , add-book , book-title, book-author-input, book-discription-input

let container = document.querySelector(".container")
let addBook = document.getElementById("add-book")
let bookTitleInput = document.getElementById("book-title-input")
let bookAuthorInput = document.getElementById("book-author-input")
let bookDiscription = document.getElementById("book-description-input")

addBook.addEventListener("click",function(event){
    event.preventDefault()
    let div = document.createElement("div")
    div.setAttribute("class","book-container")
    div.innerHTML = `<h2>${bookTitleInput.value}</h2>
            <h5>${bookAuthorInput.value}</h5>
            <p>${bookDiscription.value}</p>
            <button onclick="deletebook(event)" >Delete</button>`
    container.append(div)
    popupOverlay.style.display="none";
    popupBox.style.display="none";
})

function deletebook(event){
    event.target.parentElement.remove();
}