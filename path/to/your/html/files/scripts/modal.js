// Get the modal
var modal = document.getElementById("myModal");
var modalDetail = document.getElementById("modalDetail");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");
//var btnDetail = document.getElementById("btnDetail");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
//var spanDetail = document.getElementsByClassName("closeModal")[0];

// When the user clicks on the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}
/*
btnDetail.onclick = function() {
    modal.style.display = "block";
}
*/


// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
    location.reload()
}
/*
spanDetail.onclick = function() {
    modalDetail.style.display = "none";
    location.reload()
}
*/
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target === modal) {
        modal.style.display = "none";
        location.reload()
    }

    if (event.target === modalDetail) {
        modalDetail.style.display = "none";
        location.reload()
    }
}